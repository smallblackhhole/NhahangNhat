package com.example.nhahangnhat.ADAPTER_Menu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhahangnhat.Phanloaimonan;
import com.example.nhahangnhat.R;
import com.example.nhahangnhat.SERVER;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ADPATER_MENU extends RecyclerView.Adapter<VIEWHOLDER> {
    Context context;
    ArrayList<PhanLoai> data;

    public ADPATER_MENU(Context context, ArrayList<PhanLoai> data) {
        this.context = context;
        this.data = data;
    }
    @NonNull
    @Override
    public VIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.phanloai_recycleview,null);
        return new VIEWHOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VIEWHOLDER holder, int position) {
        PhanLoai phanLoai = data.get(position);

        Picasso.get().load(SERVER.imagepath + phanLoai.HinhLoai).into(holder.imgRoom);
//        holder.tvRoomName.setText(phanLoai.TenLoai);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Phanloaimonan.class);
                intent.putExtra("maloai",phanLoai.MaLoai);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
class VIEWHOLDER extends RecyclerView.ViewHolder {

//    TextView tvRoomName;
    ImageView imgRoom;

    public VIEWHOLDER(@NonNull View itemView) {
        super(itemView);

        anhxa();
    }

    public void anhxa() {
        imgRoom = itemView.findViewById(R.id.imageView);
//        tvRoomName = itemView.findViewById(R.id.textView);

    }
}