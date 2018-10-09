package com.itskshitizsh.bhukhad;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignInActivity extends AppCompatActivity {

    Button SignInButton;
    private EditText editUserId, editUserPassword;
    public static String name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editUserId = findViewById(R.id.editRollNo);
        editUserPassword = findViewById(R.id.editPassword);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference userTable = database.getReference("User");

        SignInButton = findViewById(R.id.SignInButton);
        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                            User currentUser = dataSnapshot.child(editUserId.getText().toString()).getValue(User.class);
                            name=currentUser.getName();
                            if (currentUser.getPassword().equals(editUserPassword.getText().toString())) {
                                Toast.makeText(SignInActivity.this, "Sign In Successfully !", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignInActivity.this, HomeActivity.class));
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
        });
    }

}
