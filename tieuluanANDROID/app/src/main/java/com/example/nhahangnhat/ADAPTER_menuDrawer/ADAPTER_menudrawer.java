package com.example.nhahangnhat.ADAPTER_menuDrawer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhahangnhat.ADAPTER_Menu.PhanLoai;
import com.example.nhahangnhat.ADAPTER_menuDrawer.VIEWHOLDERDRAWER;
import com.example.nhahangnhat.Phanloaimonan;
import com.example.nhahangnhat.R;
import com.example.nhahangnhat.SERVER;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ADAPTER_menudrawer extends RecyclerView.Adapter<com.example.nhahangnhat.ADAPTER_menuDrawer.VIEWHOLDERDRAWER> {
    Context context;
    ArrayList<PhanloaiMenudrawer> data;

    public ADAPTER_menudrawer(Context context, ArrayList<PhanloaiMenudrawer> data) {
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public VIEWHOLDERDRAWER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.phanloai_menudrawer,null);
        return new VIEWHOLDERDRAWER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VIEWHOLDERDRAWER holder, int position) {
        PhanloaiMenudrawer phanLoai = data.get(position);

        Picasso.get().load(SERVER.imagepath + phanLoai.HinhLoai).into(holder.imgRoom);
        holder.tvRoomName.setText(phanLoai.TenLoai);
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
class VIEWHOLDERDRAWER extends RecyclerView.ViewHolder {

    TextView tvRoomName;
    ImageView imgRoom;

    public VIEWHOLDERDRAWER(@NonNull View itemView) {
        super(itemView);

        anhxa();
    }

    public void anhxa() {
        imgRoom = itemView.findViewById(R.id.hinhmenudrawer);
        tvRoomName = itemView.findViewById(R.id.tenmenudrawer);

    }
}
