package com.example.nhahangnhat.Notification;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class VIEWPAGER_ADAPTER extends FragmentStateAdapter {
    ArrayList<Fragment>fragmentlist;
    public VIEWPAGER_ADAPTER(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, ArrayList<Fragment>fragmentlist) {
        super(fragmentManager, lifecycle);
        this.fragmentlist = fragmentlist;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentlist.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentlist.size();
    }
}
