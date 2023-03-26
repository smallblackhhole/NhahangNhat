package com.example.nhahangnhat.booking;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhahangnhat.DrawerMenu.BookingFragment;
import com.example.nhahangnhat.R;

import java.util.ArrayList;

public class BOOKING_ADAPTER extends RecyclerView.Adapter<KHUNGNHIN>{
    Context context;
    ArrayList<BOOKING> data;


    public BOOKING_ADAPTER(Context context, ArrayList<BOOKING> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public KHUNGNHIN onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_view_booking,null);
        return new KHUNGNHIN(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KHUNGNHIN holder, int position) {
        BOOKING booking = data.get(position);
        holder.imgdatngay.setImageResource((booking.imgdatngay));
        holder.imgdatngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, datban.class);
                intent.putExtra("ban",booking.ban);
                context.startActivity(intent);
            }
        });
        holder.tv_ban.setText(booking.ban);
        holder.tv_tinhtrang.setText(booking.tinhtrang);
        holder.imgdatngay.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale));

    }


    @Override
    public int getItemCount() {
        return data.size();
    }
}
class KHUNGNHIN extends RecyclerView.ViewHolder{
    TextView tv_ban,tv_tinhtrang;

    ImageView img_booking,background,imgdatngay;
    public KHUNGNHIN(@NonNull View itemView) {
        super(itemView);

        imgdatngay = itemView.findViewById(R.id.imgdatngay);
        tv_ban = itemView.findViewById(R.id.tv_ban);
        tv_tinhtrang = itemView.findViewById(R.id.tv_tinhtrang);
        background = itemView.findViewById(R.id.background);

    }
}