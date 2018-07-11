package com.example.alireza.myshop.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alireza.myshop.Activityes.CategoryActivity;
import com.example.alireza.myshop.Models.CategoryMode;
import com.example.alireza.myshop.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Category0_Content extends RecyclerView.Adapter<Category0_Content.Holder> {
    private List<CategoryMode> sliders;
    private Activity activity;
    private ImageLoader imageLoader = ImageLoader.getInstance();

    public Category0_Content(List<CategoryMode> sliders, Activity activity) {
        this.sliders = sliders;
        this.activity = activity;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.content0_category, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(final Holder holder, final int position) {
        holder.title.setText(sliders.get(position).getTittle());
        holder.id = sliders.get(position).getID();
        holder.id_parent = sliders.get(position).getID_parent();
//        imageLoader.displayImage(sliders.get(position).getPic(), holder.mCircleImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, CategoryActivity.class);
                intent.putExtra("id", sliders.get(position).getID());

                activity.startActivity(intent);
//
//                activity.startActivity();
//                               Toast.makeText(activity, ""+sliders.get(position).getID(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return sliders.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        TextView title;
        //        CircleImageView mCircleImageView;
        String id = "";
        String id_parent = "";

        Holder(final View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.t);
//            mCircleImageView = itemView.findViewById(R.id.mImageContentCategory);
        }
    }
}