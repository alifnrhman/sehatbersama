package com.example.sehatbersama;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class KaloriPage extends AppCompatActivity {

    private LinearLayout btnBeranda, btnAirHarian, btnKaloriHarian;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kalori_page);

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
                Intent intent = new Intent(KaloriPage.this, HomePageActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnAirHarian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KaloriPage.this, AirHarianActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnKaloriHarian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Already on this page, do nothing or refresh
            }
        });
        // Tombol tambah kalori
        ImageButton btnTambahKalori = findViewById(R.id.addKaloriButton);
        btnTambahKalori.setOnClickListener(v -> showKaloriDialog());

        // Tombol tambah nutrisi
        ImageButton btnTambahNutrisi = findViewById(R.id.addNutritionButton);
        btnTambahNutrisi.setOnClickListener(v -> showNutritionPopup());

        // Tombol kembali ke HomePageActivity
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(KaloriPage.this, HomePageActivity.class);
            startActivity(intent);
            finish(); // Supaya tidak bisa kembali ke KaloriPage lagi
        });
    }

    private void showKaloriDialog() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_kalori_popup); // Gunakan layout popup kalori

        if (dialog.getWindow() != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        }

        ImageButton btnClose = dialog.findViewById(R.id.btnClose);
        btnClose.setOnClickListener(v -> dialog.dismiss());

        EditText targetKalori = dialog.findViewById(R.id.targetCarb);
        Button btnSave = dialog.findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            String jumlahKalori = targetKalori.getText().toString().trim();
            Toast.makeText(this, "Data kalori disimpan", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });

        dialog.show();
    }

    private void showNutritionPopup() {
        // Inflate layout popup
        LayoutInflater inflater = LayoutInflater.from(this);
        View popupView = inflater.inflate(R.layout.dialog_nutrition_popup, null);

        // Buat AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(popupView);
        AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();

        // Tombol Close
        ImageButton btnClose = popupView.findViewById(R.id.btnClose);
        btnClose.setOnClickListener(v -> dialog.dismiss());

        // Tombol Simpan
        Button btnSave = popupView.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(v -> {
            EditText targetCarb = popupView.findViewById(R.id.targetCarb);
            EditText targetFat = popupView.findViewById(R.id.targetFat);
            EditText targetProtein = popupView.findViewById(R.id.targetProtein);

            EditText consumedCarb = popupView.findViewById(R.id.consumedCarb);
            EditText consumedFat = popupView.findViewById(R.id.consumedFat);
            EditText consumedProtein = popupView.findViewById(R.id.consumedProtein);

            // Ambil nilai input (opsional bisa divalidasi/diproses)
            String targetCarbVal = targetCarb.getText().toString();
            String targetFatVal = targetFat.getText().toString();
            String targetProteinVal = targetProtein.getText().toString();

            String consumedCarbVal = consumedCarb.getText().toString();
            String consumedFatVal = consumedFat.getText().toString();
            String consumedProteinVal = consumedProtein.getText().toString();

            // Contoh feedback
            Toast.makeText(this, "Data nutrisi disimpan", Toast.LENGTH_SHORT).show();

            dialog.dismiss();
        });
    }
}
