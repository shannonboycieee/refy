package com.reffy.shannon.reffyy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

     EditText loginUsername, loginPassword;
     Button loginButton;
     Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginUsername = (EditText) findViewById(R.id.txtusername);
        loginPassword = (EditText) findViewById(R.id.txtpassword);
        loginButton = (Button) findViewById(R.id.btnLogin);
        signupButton = (Button) findViewById(R.id.btnSignup);



    }

    @Override
    protected void onStart() {

        super.onStart();

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, signup.class));
            }

});

    }
}
