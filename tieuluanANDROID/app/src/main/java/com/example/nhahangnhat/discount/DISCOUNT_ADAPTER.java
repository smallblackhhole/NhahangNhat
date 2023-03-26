package com.example.nhahangnhat.discount;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhahangnhat.R;

import java.util.ArrayList;

public class DISCOUNT_ADAPTER extends RecyclerView.Adapter<KHUNGNHIN>{
    Context context;
    ArrayList<DISSCOUNT> data;


    public DISCOUNT_ADAPTER(Context context, ArrayList<DISSCOUNT> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public KHUNGNHIN onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycleview_discount,null);
        return new KHUNGNHIN(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KHUNGNHIN holder, int position) {
        DISSCOUNT disscount = data.get(position);
        holder.img_discount.setImageResource(disscount.image);
        holder.tv_discountname.setText(disscount.discountcodename);
        holder.tv_Contentsofdiscountcode.setText(disscount.Contentsofdiscountcode);
        holder.img_discount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Bạn đã chọn vào mã giảm giá này!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
class KHUNGNHIN extends RecyclerView.ViewHolder{
    TextView tv_discountname,tv_Contentsofdiscountcode;
    ImageView img_discount,background;
    public KHUNGNHIN(@NonNull View itemView) {
        super(itemView);
        img_discount = itemView.findViewById(R.id.imageView2);
        tv_discountname = itemView.findViewById(R.id.textView2);
        tv_Contentsofdiscountcode = itemView.findViewById(R.id.textView3);


    }
}