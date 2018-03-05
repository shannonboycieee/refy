package com.reffy.shannon.reffyy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {

    //Variables
    private EditText userName, userPassword, userEmail;
    private Button signUp, loginButton;
    private FirebaseAuth authentication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Finding by xml id names
        userName = (EditText) findViewById(R.id.txtusername);
        userPassword = (EditText) findViewById(R.id.txtpassword);
        userEmail = (EditText) findViewById(R.id.txtuserEmail);
        signUp = (Button) findViewById(R.id.btn_signup);
        loginButton = (Button) findViewById(R.id.btnLoginA);

        authentication = FirebaseAuth.getInstance();

    }

    private boolean validate(){

        Boolean result = false;

        String name = userName.getText().toString();
        String password = userPassword.getText().toString();
        String email = userEmail.getText().toString();

        if(name.isEmpty() && password.isEmpty() && email.isEmpty()){
            Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show();
        }
        else{
            result = true;
        }

        return result;
    }

    public void Login(View loginscreen){

        Intent intent= new Intent(signup.this, Login.class);
        startActivity(intent);

    }



    public void Register(View view) {
        if(validate()){

            String user_email= userEmail.getText().toString().trim();
            String user_password = userPassword.getText().toString().trim();

            authentication.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    //If statement for sucessful registration
                    if(task.isSuccessful()) {

                        Toast.makeText(signup.this, "Registration successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(signup.this, Login.class));
                    }else{
                        Toast.makeText(signup.this, "Registrastion unsucessful", Toast.LENGTH_SHORT).show();

                    }

                }
            });
        }
    }
}
