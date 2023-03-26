package com.example.nhahangnhat.ADAPTER_Monan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhahangnhat.FoodDetail;
import com.example.nhahangnhat.FooddetailAfterLogin;
import com.example.nhahangnhat.R;
import com.example.nhahangnhat.SERVER;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ADAPTER_MonanBeforeLogin extends  RecyclerView.Adapter<KHUNGNHIN_MONANBL> {
    Context context;
    ArrayList<MONAN> data;


    public ADAPTER_MonanBeforeLogin(Context context, ArrayList<MONAN> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public KHUNGNHIN_MONANBL onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.monan, null);
        return new KHUNGNHIN_MONANBL(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KHUNGNHIN_MONANBL holder, int position) {
        MONAN monan = data.get(position);
        Picasso.get().load(SERVER.imagefoodpath + monan.hinhanh).into(holder.imgmonan);
        holder.tenmon.setText(monan.tenmon);


        holder.imgmonan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FooddetailAfterLogin.class);
                intent.putExtra("masp",monan.mamon);
                intent.putExtra("tenmon",monan.tenmon);
                intent.putExtra("dongia",monan.giamon);
                intent.putExtra("spnoibat",monan.spnoibat);
                intent.putExtra("hinhanh",monan.hinhanh);
                intent.putExtra("chitiet",monan.chitiet);
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return data.size();
    }

}

    class KHUNGNHIN_MONANBL extends RecyclerView.ViewHolder {

        TextView tenmon, giamon;
        ImageView imgmonan;



        public KHUNGNHIN_MONANBL(@NonNull View itemView) {
            super(itemView);
            imgmonan = itemView.findViewById(R.id.hinhmonan);
            tenmon = itemView.findViewById(R.id.tenmonan);


        }
}
