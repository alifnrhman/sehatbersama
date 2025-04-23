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

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener  {
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnRegister = (Button)findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(this);

        // Register Prompt TextView
        TextView loginPromptText = findViewById(R.id.tv_login);
        String loginPrompt = "Sudah memiliki akun? masuk";
        SpannableString spannableLoginPrompt = new SpannableString(loginPrompt);
        spannableLoginPrompt.setSpan(new ForegroundColorSpan(Color.parseColor("#71BEF4")), loginPrompt.indexOf("masuk"), loginPrompt.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        spannableLoginPrompt.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        }, loginPrompt.indexOf("masuk"), loginPrompt.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Menetapkan teks yang telah dimodifikasi ke TextView
        loginPromptText.setText(spannableLoginPrompt);

        // Mengaktifkan klik pada teks
        loginPromptText.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_register) {
            Intent moveIntent = new Intent(RegisterActivity.this,
                    HomePageActivity.class);
            startActivity(moveIntent);
        }
    }
}
