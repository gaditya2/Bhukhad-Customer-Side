package com.itskshitizsh.bhukhad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FeedbackActivity extends AppCompatActivity {

    private EditText subject;
    private EditText message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        subject = findViewById(R.id.subject);
        message = findViewById(R.id.messageText);
        Button sendE = findViewById(R.id.sendEmail);
        sendE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (subject.getText().toString().isEmpty()) {
                    subject.setError("Required");
                    subject.requestFocus();
                }
                if (message.getText().toString().isEmpty()) {
                    message.setError("Required");
                    message.requestFocus();
                }
                if (!(subject.getText().toString().isEmpty()) && !(message.getText().toString().isEmpty())) {
                    String subStr = subject.getText().toString();
                    String mesStr = message.getText().toString();
                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{"adityaguptaks1998@gmail.com"});
                    email.putExtra(Intent.EXTRA_SUBJECT, subStr);
                    email.putExtra(Intent.EXTRA_TEXT, mesStr);
                    email.setType("message/rfc822");
                    startActivity(Intent.createChooser(email, "choose an app to send an email"));
                }
            }
        });
    }
}

