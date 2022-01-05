package com.example.cafemenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreateAccountActivity extends AppCompatActivity {
    TextView log;
    EditText inputUsername, inputEmail, inputFullName, pass1, pass2;
    String username, email, full_name, password1, password2;
    Button btnRegister;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setTitle("Register Menu");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        mAuth = FirebaseAuth.getInstance();


        TextView loginHere = findViewById(R.id.have_account);

        loginHere.setOnClickListener(view -> loginHere());

        inputUsername = findViewById(R.id.username_register);
        inputEmail = findViewById(R.id.email_register);
        inputFullName = findViewById(R.id.fullname_register);
        pass1 = findViewById(R.id.password_register1);
        pass2 = findViewById(R.id.password_register2);

        btnRegister = findViewById(R.id.register_button);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = inputUsername.getText().toString();
                email = inputEmail.getText().toString();
                full_name = inputFullName.getText().toString();
                password1 = pass1.getText().toString();
                password2 = pass2.getText().toString();
                if (email.isEmpty()) {
                    Toast.makeText(CreateAccountActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                } else if (full_name.isEmpty()) {
                    Toast.makeText(CreateAccountActivity.this, "Please enter your full name", Toast.LENGTH_SHORT).show();
                } else if (username.isEmpty()) {
                    Toast.makeText(CreateAccountActivity.this, "Please enter your username", Toast.LENGTH_SHORT).show();
                } else if(password1.length() < 6) {
                    Toast.makeText(CreateAccountActivity.this, "Password must be more than 5 letters", Toast.LENGTH_SHORT).show();
                } else if(!password1.equals(password2)) {
                    Toast.makeText(CreateAccountActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                } else
                register();
            }
        });
    }

    void register() {
        mAuth.createUserWithEmailAndPassword(email, password2).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(CreateAccountActivity.this, "Registration Succsess", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(CreateAccountActivity.this, "Registration Failed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    public void loginHere() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}