package com.example.nhahangnhat.Notification;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nhahangnhat.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Notification extends Fragment {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    View view;
    ArrayList<Fragment> FragmentArrayList = new ArrayList<>();
     VIEWPAGER_ADAPTER viewpager_adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_notification, container, false);
        tabLayout = view.findViewById(R.id.tab_noti);
        viewPager2 = view.findViewById(R.id.vp2_notify);


        FragmentArrayList.add(new NotificationDiscount());
        FragmentArrayList.add(new NotificationOrder());

        viewpager_adapter = new VIEWPAGER_ADAPTER(getChildFragmentManager(), getLifecycle(), FragmentArrayList);
//        viewpager_adapter = new VIEWPAGER_ADAPTER(getActivity().getSupportFragmentManager().beginTransaction().add(khuyenmai));
        viewPager2.setAdapter(viewpager_adapter);

        tabLayout.addTab(tabLayout.newTab().setText("FREESHIP").setIcon(R.drawable.profile));
        tabLayout.addTab(tabLayout.newTab().setText("Notification").setIcon(R.drawable.address));

        //Thao tác vuốt qua trái phải -> tab sẽ thay đổi theo
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }



}