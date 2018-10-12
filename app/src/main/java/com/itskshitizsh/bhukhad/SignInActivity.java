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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import io.paperdb.Paper;

public class SignInActivity extends AppCompatActivity {

    Button SignInButton;
    private EditText editUserId, editUserPassword;
    String name;
    String id;
    CheckBox checkBox;
    public static User currentUser;



    private boolean isNetworkConnected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editUserId = findViewById(R.id.editRollNo);
        editUserPassword = findViewById(R.id.editPassword);
        checkBox = findViewById(R.id.rememberMeCheckBox);

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
        Paper.init(this);
        if (isNetworkConnected) {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            final DatabaseReference userTable = database.getReference("User");

            SignInButton = findViewById(R.id.SignInButton);
            SignInButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if (editUserId.getText().toString().isEmpty()) {
                        editUserId.setError("Required");
                        editUserId.requestFocus();
                    }
                    if (editUserPassword.getText().toString().isEmpty()) {
                        editUserPassword.setError("Required");
                        editUserPassword.requestFocus();
                    }

                    if (!editUserId.getText().toString().isEmpty() && !editUserPassword.getText().toString().isEmpty()) {

                        if (checkBox.isChecked()) {
                            Paper.book().write("name", editUserId.getText().toString());
                            Paper.book().write("password", editUserPassword.getText().toString());
                        }
                        final ProgressDialog mDialog = new ProgressDialog(SignInActivity.this);
                        mDialog.setMessage("Working...\nPlease Wait !");
                        mDialog.show();

                        userTable.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                // User exists or not?
                                if (dataSnapshot.child(editUserId.getText().toString()).exists()) {
                                    // Get user information
                                    mDialog.dismiss();
                                    currentUser = dataSnapshot.child(editUserId.getText().toString()).getValue(User.class);
                                    name = currentUser.getName();
                                    id = currentUser.getRollNo();
                                    if (currentUser.getPassword().equals(editUserPassword.getText().toString())) {
                                        Toast.makeText(SignInActivity.this, "Sign In Successfully !", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(SignInActivity.this, HomeActivity.class).putExtra("name", currentUser.getName()).putExtra("id", currentUser.getRollNo()));
                                        finish();
                                    } else {
                                        Toast.makeText(SignInActivity.this, " Sign In Failed !!\nCheck Credentials", Toast.LENGTH_SHORT).show();
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
            });
        } else {
            Toast.makeText(getApplicationContext(), "Try to connect with Internet and Restart the App.", Toast.LENGTH_SHORT).show();
        }
    }
}
