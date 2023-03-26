package com.example.nhahangnhat.SearchActi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhahangnhat.ADAPTER_Monan.MONAN;
import com.example.nhahangnhat.FoodDetail;
import com.example.nhahangnhat.R;
import com.example.nhahangnhat.SERVER;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ADAPTER_SEARCH extends RecyclerView.Adapter<KHUNHNHIN_SEARCH> {

    Context context;
    ArrayList<MONAN> data;

    public ADAPTER_SEARCH(Context context, ArrayList<MONAN> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public KHUNHNHIN_SEARCH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.searchitem, null);
        return new KHUNHNHIN_SEARCH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KHUNHNHIN_SEARCH holder, int position) {
        MONAN products = data.get(position);

        Picasso.get().load(SERVER.imagefoodpath + products.getHinhanh()).into(holder.imgHinhsanpham);
        holder.tvTensanpham.setText(products.getTenmon());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FoodDetail.class);
                intent.putExtra("masp",products.getMamon());
                intent.putExtra("tenmon",products.getTenmon());
                intent.putExtra("dongia",products.getGiamon());
                intent.putExtra("spnoibat",products.getSpnoibat());
                intent.putExtra("hinhanh",products.getHinhanh());
                intent.putExtra("chitiet",products.getChitiet());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

class KHUNHNHIN_SEARCH extends RecyclerView.ViewHolder {
    ImageView imgHinhsanpham;
    TextView tvTensanpham, tvGiaspsearch, tvDetailspsearch;

    public KHUNHNHIN_SEARCH(@NonNull View itemView) {
        super(itemView);

        imgHinhsanpham = itemView.findViewById(R.id.imgHinhspSearch);
        tvTensanpham = itemView.findViewById(R.id.tvItemsearch);
        tvGiaspsearch = itemView.findViewById(R.id.tvGiaspsearch);
        tvDetailspsearch = itemView.findViewById(R.id.tvDetailspsearch);
    }
}
