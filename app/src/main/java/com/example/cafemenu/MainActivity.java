package com.example.cafemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Login Menu");

        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(view -> login());
    }

    public  void login() {
        TextView usernameLogin = findViewById(R.id.username_login);
        TextView passwordLogin = findViewById(R.id.password_login);

        String username = usernameLogin.getText().toString();
        String password = passwordLogin.getText().toString();

        if(username.equals("test") && password.equals("123456")) {
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
            this.finish();
        } else {
            Toast errorLogin = Toast.makeText(getApplicationContext(),"Username/Password yang anda masukkan salah", Toast.LENGTH_SHORT);
            errorLogin.show();
        }
    }

}