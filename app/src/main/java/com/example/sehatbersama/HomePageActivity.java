package com.example.sehatbersama;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomePageActivity extends AppCompatActivity {

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

        ImageButton addNutritionButton = findViewById(R.id.addNutritionButton);
        addNutritionButton.setOnClickListener(v -> showNutritionPopup());
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