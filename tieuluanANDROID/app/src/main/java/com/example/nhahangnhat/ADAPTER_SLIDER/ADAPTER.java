package com.example.nhahangnhat.ADAPTER_SLIDER;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.nhahangnhat.R;

import java.util.List;

public class ADAPTER extends RecyclerView.Adapter<ADAPTER.ADAPTER_SLIDERVIEWHOLDER> {
    private List<Slider_Image> hinhanh;
    private Context context;

    public ADAPTER(List<Slider_Image> hinhanh , Context mcontext) {
        this.hinhanh = hinhanh;
        this.context = mcontext;
    }

    @NonNull
    @Override
    public ADAPTER_SLIDERVIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_image,parent,false);
        return new ADAPTER_SLIDERVIEWHOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ADAPTER_SLIDERVIEWHOLDER holder, int position) {
        Slider_Image image = hinhanh.get(position);
        Glide.with(context).load(image.getUrl())
                .centerCrop()
                .into(holder.img);
    }


    @Override
    public int getItemCount() {
        if (hinhanh != null){
            return hinhanh.size();
        }
        return 0;
    }

    public class ADAPTER_SLIDERVIEWHOLDER extends RecyclerView.ViewHolder{
        private ImageView img;
        public ADAPTER_SLIDERVIEWHOLDER(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image_slider);
        }
    }
}
