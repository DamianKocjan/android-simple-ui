package com.example.damiankocjan_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = findViewById(R.id.btnLogin);
        TextView errorText = findViewById(R.id.tvError);
        EditText email = findViewById(R.id.etEmail);
        EditText password = findViewById(R.id.etPassword);

        loginButton.setOnClickListener(v -> {
            if (!LoginValidator.validate(email.getText().toString(), password.getText().toString())) {
                errorText.setText(R.string.login_error);
                return;
            }

            State.getInstance().login(email.getText().toString(), password.getText().toString());
            finish();
        });
    }
}