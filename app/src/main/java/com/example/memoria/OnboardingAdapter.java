package com.example.memoria;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class OnboardingAdapter extends FragmentStateAdapter {

    public OnboardingAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new OnboardingFragment1();  // Fragment 1
            case 1:
                return new OnboardingFragment2();  // Fragment 2
            case 2:
                return new OnboardingFragment3();  // Fragment 3
            default:
                return new OnboardingFragment1();  // Default to Fragment 1
        }
    }

    @Override
    public int getItemCount() {
        return 3;  // Total number of onboarding fragments
    }
}

