package com.example.sehatbersama.ui.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sehatbersama.R;

public class AuthActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnLogin;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_auth);
        btnLogin = (Button)findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

        btnRegister = (Button)findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_login) {
            Intent moveIntent = new Intent(AuthActivity.this,
                    LoginActivity.class);
            startActivity(moveIntent);
        } else if (view.getId() == R.id.btn_register) {
            Intent moveIntent = new Intent(AuthActivity.this,
                    RegisterActivity.class);
            startActivity(moveIntent);
        }
    }
}