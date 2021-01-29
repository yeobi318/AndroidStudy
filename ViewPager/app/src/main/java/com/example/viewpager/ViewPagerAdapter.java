package com.example.viewpager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fa) {
        super(fa);
    }

    // 프래그먼트를 보여주는 처리를 구현
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return FragMonday.newInstance(position);
            case 1:
                return FragTuesday.newInstance(position);
            case 2:
                return FragWednesday.newInstance(position);
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

}
