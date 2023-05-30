package com.example.food_planner.Main.HomePage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_planner.Main.HomePage.HomeView.OnAreaClickListener;
import com.example.food_planner.R;

import java.util.List;

public class AllMealsAdapter  extends RecyclerView.Adapter<AllMealsAdapter.ViewHolder> {
    Context context;
    List<String> list;
    OnAreaClickListener listener;

    public AllMealsAdapter(Context context, List<String> list, OnAreaClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }
    public void setList(List<String> updatedProduct){
        this.list=updatedProduct;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ConstraintLayout constraintLayout;
        ImageView mealImage;
        TextView mealName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view=itemView;
            constraintLayout=itemView.findViewById(R.id.card);
            mealImage=itemView.findViewById(R.id.mealImage_id);
            mealName=itemView.findViewById(R.id.mealNameCard);
        }
    }

    @NonNull
    @Override
    public AllMealsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup recycleView, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(recycleView.getContext());
        View v=layoutInflater.inflate(R.layout.mealcard,recycleView,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AllMealsAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String requistmsg=list.get(position);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

}
