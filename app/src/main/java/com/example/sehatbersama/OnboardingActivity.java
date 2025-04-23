package com.example.sehatbersama;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2.PageTransformer;
import androidx.recyclerview.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class OnboardingActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private OnboardingAdapter onboardingAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        viewPager2 = findViewById(R.id.viewPager);
        dotsLayout = findViewById(R.id.layoutDots);
        btnContinue = findViewById(R.id.btnContinue);

        setupOnboardingItems();

        // FIX: tampilkan dots pertama setelah ViewPager2 siap
        viewPager2.post(() -> setupDots(0));

        setupPageChange();
        viewPager2.setPageTransformer(new FadeZoomTransformer());

        btnContinue.setOnClickListener(v -> {
            int current = viewPager2.getCurrentItem();
            if (current < onboardingAdapter.getItemCount() - 1) {
                viewPager2.setCurrentItem(current + 1);
            } else {
                startActivity(new Intent(OnboardingActivity.this, AuthActivity.class));
                finish();
            }
        });
    }


    private void setupOnboardingItems() {
        List<OnboardingItem> items = new ArrayList<>();
        items.add(new OnboardingItem(R.drawable.onboarding1,
                "Selamat Datang di SehatBersama!",
                "Aplikasi yang siap nemenin kamu hidup lebih sehat, dari minum air sampai kebiasaan baik lainnya."));

        items.add(new OnboardingItem(R.drawable.onboarding2,
                "Minum Air? Jangan Lupa!",
                "Tubuh butuh cukup cairan untuk tetap fokus dan segar. SehatBersama siap bantu kamu tetap terhidrasi dengan pengingat rutin."));

        items.add(new OnboardingItem(R.drawable.onboarding3,
                "Pantau Asupan Kalorimu",
                "Makan enak tetap bisa sehat. Catat kalori harian dengan mudah dan jaga pola makanmu tetap seimbang."));

        onboardingAdapter = new OnboardingAdapter(items);
        viewPager2.setAdapter(onboardingAdapter);
    }

    private void setupDots(int position) {
        dots = new TextView[onboardingAdapter.getItemCount()];
        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(" ● ");
            dots[i].setTextSize(20);
            dots[i].setTextColor(getResources().getColor(
                    i == position ? R.color.active_dot : R.color.inactive_dot
            ));
            dotsLayout.addView(dots[i]);
        }
    }

    private void setupPageChange() {
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                setupDots(position);
                if (position == onboardingAdapter.getItemCount() - 1) {
                    btnContinue.setText("Mulai");
                } else {
                    btnContinue.setText("Lanjut");
                }
            }
        });
    }

    // Fade & Zoom Animasi
    public static class FadeZoomTransformer implements PageTransformer {
        @Override
        public void transformPage(@NonNull View page, float position) {
            float scale = 1 - Math.abs(position) * 0.2f;
            float alpha = 1 - Math.abs(position) * 0.5f;
            page.setScaleX(scale);
            page.setScaleY(scale);
            page.setAlpha(alpha);
        }
    }
}
