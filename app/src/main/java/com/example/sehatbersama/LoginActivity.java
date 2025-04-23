package com.example.sehatbersama;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        btnLogin = (Button)findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);


        // Forgot Password TextView
        TextView forgotPasswordText = findViewById(R.id.tv_forgot_password);
        String forgotPassword = "Lupa kata sandi? atur ulang";
        SpannableString spannableForgotPassword = new SpannableString(forgotPassword);
        spannableForgotPassword.setSpan(new ForegroundColorSpan(Color.parseColor("#71BEF4")), forgotPassword.indexOf("atur ulang"), forgotPassword.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        forgotPasswordText.setText(spannableForgotPassword);

        // Register Prompt TextView
        TextView registerPromptText = findViewById(R.id.tv_register);
        String registerPrompt = "Belum memiliki akun? daftar";
        SpannableString spannableRegisterPrompt = new SpannableString(registerPrompt);
        spannableRegisterPrompt.setSpan(new ForegroundColorSpan(Color.parseColor("#71BEF4")), registerPrompt.indexOf("daftar"), registerPrompt.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Membuat ClickableSpan untuk bagian "daftar"
        spannableRegisterPrompt.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Redirect ke Activity Registrasi
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        }, registerPrompt.indexOf("daftar"), registerPrompt.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Menetapkan teks yang telah dimodifikasi ke TextView
        registerPromptText.setText(spannableRegisterPrompt);

        // Mengaktifkan klik pada teks
        registerPromptText.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_login) {
            Intent moveIntent = new Intent(LoginActivity.this,
                    HomePageActivity.class);
            startActivity(moveIntent);
        }
    }
}
