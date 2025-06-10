package com.example.sehatbersama;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class AirHarianActivity extends AppCompatActivity {

    private LinearLayout btnBeranda, btnAirHarian, btnKaloriHarian;
    private CardView btnAddWater, btnRemoveWater;
    private TextView tvProgress, tvTercapai, tvRemainingAmount, tvConsumedAmount;
    private int currentWaterConsumption = 1800; // Current water consumption in ml
    private final int waterGoal = 2000; // Water goal in ml

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_harian);

        // Initialize views
        btnBeranda = findViewById(R.id.btnBeranda);
        btnAirHarian = findViewById(R.id.btnAirHarian);
        btnKaloriHarian = findViewById(R.id.btnKaloriHarian);
        btnAddWater = findViewById(R.id.btnAddWater);
        btnRemoveWater = findViewById(R.id.btnRemoveWater);
        tvProgress = findViewById(R.id.tvProgress);
        tvTercapai = findViewById(R.id.tvTercapai);
        tvRemainingAmount = findViewById(R.id.tvRemainingAmount);
        tvConsumedAmount = findViewById(R.id.tvConsumedAmount);

        btnBeranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AirHarianActivity.this, HomePageActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnAirHarian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AirHarianActivity.this, "Anda sudah berada di halaman Air Harian", Toast.LENGTH_SHORT).show();
            }
        });

        btnKaloriHarian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AirHarianActivity.this, KaloriHarianActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnAddWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddWaterDialog();
            }
        });

        btnRemoveWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRemoveWaterDialog();
            }
        });

//        updateWaterDisplay();
    }

    private void showAddWaterDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_add_water);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        // Find views
        ImageButton btnClose = dialog.findViewById(R.id.btnCloseDialog);
        EditText etWaterVolume = dialog.findViewById(R.id.etWaterVolume);
        Button btnTambah = dialog.findViewById(R.id.btnTambah);

        // Set click listeners
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

//        btnTambah.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String volumeStr = etWaterVolume.getText().toString().trim();
//                if (!TextUtils.isEmpty(volumeStr)) {
//                    try {
//                        int volume = Integer.parseInt(volumeStr);
//                        if (volume > 0) {
//                            addWater(volume);
//                            dialog.dismiss();
//                        } else {
//                            Toast.makeText(AirHarianActivity.this, "Volume air harus lebih dari 0", Toast.LENGTH_SHORT).show();
//                        }
//                    } catch (NumberFormatException e) {
//                        Toast.makeText(AirHarianActivity.this, "Masukkan angka yang valid", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(AirHarianActivity.this, "Masukkan volume air", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        dialog.show();
    }

    private void showRemoveWaterDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_remove_water);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        // Find views
        ImageButton btnClose = dialog.findViewById(R.id.btnCloseDialog);
        EditText etWaterVolume = dialog.findViewById(R.id.etWaterVolume);
        Button btnPerbarui = dialog.findViewById(R.id.btnPerbarui);

        // Set click listeners
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

//        btnPerbarui.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String volumeStr = etWaterVolume.getText().toString().trim();
//                if (!TextUtils.isEmpty(volumeStr)) {
//                    try {
//                        int volume = Integer.parseInt(volumeStr);
//                        if (volume > 0) {
//                            removeWater(volume);
//                            dialog.dismiss();
//                        } else {
//                            Toast.makeText(AirHarianActivity.this, "Volume air harus lebih dari 0", Toast.LENGTH_SHORT).show();
//                        }
//                    } catch (NumberFormatException e) {
//                        Toast.makeText(AirHarianActivity.this, "Masukkan angka yang valid", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(AirHarianActivity.this, "Masukkan volume air", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        dialog.show();
    }
}