package com.example.nhahangnhat.discount;

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

import java.util.ArrayList;

public class FragmentDiscount extends Fragment {
    RecyclerView recyclerView;
    Context context;
    ArrayList<DISSCOUNT> data = new ArrayList<>();
    DISCOUNT_ADAPTER discount_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_discount,container,false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getContext();
        recyclerView = view.findViewById(R.id.recycle_discount);
        data.add(new DISSCOUNT(R.drawable.discount,"day la ma giam gia 14/2","bạn sẻ được giảm giá 20% nếu áp mã này khi đặt shusi"));
        data.add(new DISSCOUNT(R.drawable.discount,"day la ma giam gia 14/2","bạn sẻ được giảm giá 20% nếu áp mã này khi đặt shusi"));
        data.add(new DISSCOUNT(R.drawable.discount,"day la ma giam gia 14/2","bạn sẻ được giảm giá 20% nếu áp mã này khi đặt shusi"));
        data.add(new DISSCOUNT(R.drawable.discount,"day la ma giam gia 14/2","bạn sẻ được giảm giá 20% nếu áp mã này khi đặt shusi"));
        data.add(new DISSCOUNT(R.drawable.discount,"day la ma giam gia 14/2","bạn sẻ được giảm giá 20% nếu áp mã này khi đặt shusi"));
        data.add(new DISSCOUNT(R.drawable.discount,"day la ma giam gia 14/2","bạn sẻ được giảm giá 20% nếu áp mã này khi đặt shusi"));
        data.add(new DISSCOUNT(R.drawable.discount,"day la ma giam gia 14/2","bạn sẻ được giảm giá 20% nếu áp mã này khi đặt shusi"));
        data.add(new DISSCOUNT(R.drawable.discount,"day la ma giam gia 14/2","bạn sẻ được giảm giá 20% nếu áp mã này khi đặt shusi"));
        data.add(new DISSCOUNT(R.drawable.discount,"day la ma giam gia 14/2","bạn sẻ được giảm giá 20% nếu áp mã này khi đặt shusi"));
        data.add(new DISSCOUNT(R.drawable.discount,"day la ma giam gia 14/2","bạn sẻ được giảm giá 20% nếu áp mã này khi đặt shusi"));
        data.add(new DISSCOUNT(R.drawable.discount,"day la ma giam gia 14/2","bạn sẻ được giảm giá 20% nếu áp mã này khi đặt shusi"));
        data.add(new DISSCOUNT(R.drawable.discount,"day la ma giam gia 14/2","bạn sẻ được giảm giá 20% nếu áp mã này khi đặt shusi"));



        discount_adapter = new DISCOUNT_ADAPTER(context,data);
        recyclerView.setAdapter(discount_adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL,false));
    }

}