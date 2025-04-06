package com.example.memoria;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        boolean isOnboardingCompleted = checkIfOnboardingCompleted();

        // If onboarding is not completed, start OnboardingActivity
        if (!isOnboardingCompleted) {
            Intent onboardingIntent = new Intent(MainActivity.this, OnboardingActivity.class);
            startActivity(onboardingIntent);
            finish(); // Optionally finish MainActivity to prevent going back to it
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private boolean checkIfOnboardingCompleted() {
        // Example using SharedPreferences to store whether the user has completed onboarding
        // If you don't have a SharedPreferences setup for onboarding completion, set to false to show onboarding every time
        SharedPreferences preferences = getSharedPreferences("AppPreferences", MODE_PRIVATE);
        return preferences.getBoolean("onboardingCompleted", false);
    }
}