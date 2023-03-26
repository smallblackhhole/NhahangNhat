package com.example.nhahangnhat.cart;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhahangnhat.ADAPTER_Monan.MONAN;
import com.example.nhahangnhat.Helper.HelperDB;
import com.example.nhahangnhat.R;
import com.example.nhahangnhat.SERVER;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ADAPTER_Cart extends RecyclerView.Adapter<ADAPTER_Cart.KHUNGNHIN_CHUDE> {
    Context context;
    ArrayList<GIOHANG> data;


    public ADAPTER_Cart(Context context, ArrayList<GIOHANG> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public KHUNGNHIN_CHUDE onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_giohang, null);
        return new KHUNGNHIN_CHUDE(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KHUNGNHIN_CHUDE holder, int position) {
        GIOHANG chude = data.get(position);

        Picasso.get().load(SERVER.imagefoodpath + chude.hinhanh).into(holder.imgHinhchude);
        holder.textGiachude.setText(chude.getGiamon() + "");
        holder.textTenchude.setText(chude.getTenmon());



        holder.bincart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HelperDB helperDB = new HelperDB(context);
                helperDB.deleteProductById(chude.getMamon());
                data.remove(chude);
                notifyDataSetChanged();
                UpdateTotalPrice();
            }
        });

        holder.btnmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chude.setSoluong(chude.getSoluong() - 1);
                holder.sldh.setText(String.valueOf(chude.getSoluong()));

                if (chude.getSoluong() < 1) {
                    HelperDB helperDB = new HelperDB(context);
                    helperDB.deleteProductById(chude.getMamon());
                    data.remove(chude);
                }
                notifyDataSetChanged();
                UpdateTotalPrice();
            }
        });

        holder.btnmax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chude.setSoluong(chude.getSoluong() + 1);
                holder.sldh.setText(String.valueOf(chude.getSoluong()));
                notifyDataSetChanged();
                UpdateTotalPrice();
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    void UpdateTotalPrice() {
        double totalPrice = 0;
        for (GIOHANG sp : data) {
            totalPrice += sp.getGiamon() * sp.getSoluong();
        }
        ((FragmentCart)context).UpdateTotalPrice(totalPrice);

    }

    class KHUNGNHIN_CHUDE extends RecyclerView.ViewHolder {
        ImageView imgHinhchude, btnmin, btnmax;
        TextView textTenchude, sldh;
        TextView textGiachude;
        Button bincart;

        public KHUNGNHIN_CHUDE(@NonNull View itemView) {
            super(itemView);
            imgHinhchude = itemView.findViewById(R.id.imageCart);
            textTenchude = itemView.findViewById(R.id.nameCart);
            textGiachude = itemView.findViewById(R.id.priceCart);
            bincart = itemView.findViewById(R.id.bin);
            btnmax = itemView.findViewById(R.id.btmax);
            btnmin = itemView.findViewById(R.id.btmin);
            sldh = itemView.findViewById(R.id.soluongdh);
        }
    }
}
