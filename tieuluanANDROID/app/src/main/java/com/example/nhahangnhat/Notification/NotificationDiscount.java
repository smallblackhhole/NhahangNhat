package com.example.nhahangnhat.Notification;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nhahangnhat.R;
import com.example.nhahangnhat.discount.DISCOUNT_ADAPTER;
import com.example.nhahangnhat.discount.DISSCOUNT;

import java.util.ArrayList;

public class NotificationDiscount extends Fragment {

    @Nullable
    RecyclerView recyclerViewkm;
    Context context;
    ArrayList<DISSCOUNT> data = new ArrayList<>();
    DISCOUNT_ADAPTER discount_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_notification_discount,container,false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getContext();
        recyclerViewkm = view.findViewById(R.id.recycle_viewkm);
        data.add(new DISSCOUNT(R.drawable.home,"Miễn phí vận chuyển","Tối đa 10k"));
        data.add(new DISSCOUNT(R.drawable.home,"Miễn phí vận chuyển","Tối đa 10k"));
        data.add(new DISSCOUNT(R.drawable.home,"Miễn phí vận chuyển","Tối đa 10k"));
        data.add(new DISSCOUNT(R.drawable.home,"Miễn phí vận chuyển","Tối đa 10k"));
        data.add(new DISSCOUNT(R.drawable.home,"Miễn phí vận chuyển","Tối đa 10k"));
        data.add(new DISSCOUNT(R.drawable.home,"Miễn phí vận chuyển","Tối đa 10k"));
        data.add(new DISSCOUNT(R.drawable.home,"Miễn phí vận chuyển","Tối đa 10k"));
        data.add(new DISSCOUNT(R.drawable.home,"Miễn phí vận chuyển","Tối đa 10k"));
        data.add(new DISSCOUNT(R.drawable.home,"Miễn phí vận chuyển","Tối đa 10k"));
        data.add(new DISSCOUNT(R.drawable.home,"Miễn phí vận chuyển","Tối đa 10k"));
        data.add(new DISSCOUNT(R.drawable.home,"Miễn phí vận chuyển","Tối đa 10k"));
        data.add(new DISSCOUNT(R.drawable.home,"Miễn phí vận chuyển","Tối đa 10k"));



        discount_adapter = new DISCOUNT_ADAPTER(context,data);
        recyclerViewkm.setAdapter(discount_adapter);
        recyclerViewkm.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL,false));
    }

}