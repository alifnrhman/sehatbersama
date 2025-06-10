package com.example.sehatbersama;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomePageActivity extends AppCompatActivity {
    private LinearLayout btnBeranda, btnAirHarian, btnKaloriHarian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnBeranda = findViewById(R.id.btnBeranda);
        btnAirHarian = findViewById(R.id.btnAirHarian);
        btnKaloriHarian = findViewById(R.id.btnKaloriHarian);

        btnBeranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Already on this page, do nothing or refresh
            }
        });

        btnAirHarian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, AirHarianActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnKaloriHarian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, KaloriHarianActivity.class);
                startActivity(intent);
                finish();
            }
        });

        CardView calorieTrackingCard = findViewById(R.id.calorieTrackingCard);
        calorieTrackingCard.setOnClickListener(v -> {
            Intent intent = new Intent(HomePageActivity.this, KaloriHarianActivity.class);
            startActivity(intent);
            finish();
        });

        CardView waterTrackingCard = findViewById(R.id.waterTrackingCard);
        waterTrackingCard.setOnClickListener(v -> {
            Intent intent = new Intent(HomePageActivity.this, AirHarianActivity.class);
            startActivity(intent);
            finish();
        });

    }
}