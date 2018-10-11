package com.itskshitizsh.bhukhad;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    Button signUpButton;
    Button signInButton;

    private boolean isNetworkConnected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInButton = findViewById(R.id.buttonSignIn);
        signUpButton = findViewById(R.id.buttonSignUp);
        Paper.init(this);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignInActivity.class));
                finish();
            }
        });
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
            }
        });
        try {
            ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            if (conMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED
                    || conMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {

                isNetworkConnected = true;

            } else {
                Toast.makeText(this, "Please check your internet connection", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        String user = Paper.book().read("name");
        String password = Paper.book().read("password");

        if (isNetworkConnected) {
            if (user != null && password != null) {
                if (!user.isEmpty() && !password.isEmpty()) {
                    directLogin(user, password);
                }
            }
        }
    }

    private void directLogin(final String user, final String password) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference userTable = database.getReference("User");
        final ProgressDialog mDialog = new ProgressDialog(MainActivity.this);
        mDialog.setMessage("Working...\nPlease Wait !");
        mDialog.show();
        userTable.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // User exists or not?
                if (dataSnapshot.child(user).exists()) {
                    // Get user information
                    mDialog.dismiss();
                    User currentUser = dataSnapshot.child(user).getValue(User.class);
                    if (currentUser.getPassword().equals(password)) {
                        Toast.makeText(MainActivity.this, "Sign In Successfully !", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, HomeActivity.class).putExtra("name", currentUser.getName()).putExtra("rollNo", currentUser.getRollNo()));
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, " Sign In Failed !!\nCheck Credentials", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    mDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "User not exist inside Database", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
