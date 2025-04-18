package com.example.memoria;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class OnboardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_onboarding);

        ViewPager2 viewPager = findViewById(R.id.viewPager);

        // Set up the adapter for the ViewPager2 (this will manage the onboarding fragments)
        OnboardingAdapter onboardingAdapter = new OnboardingAdapter(this);
        viewPager.setAdapter(onboardingAdapter);

        // Optionally, set up dots or a TabLayout to indicate the current position in the ViewPager2
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
            }
        }).attach();

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        // After onboarding is done (e.g., on button click or swipe), save the completion
        markOnboardingCompleted();
    }

    private void markOnboardingCompleted() {
        // Save onboarding completion in SharedPreferences
        SharedPreferences preferences = getSharedPreferences("AppPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("onboardingCompleted", true);
        editor.apply();
    }
}