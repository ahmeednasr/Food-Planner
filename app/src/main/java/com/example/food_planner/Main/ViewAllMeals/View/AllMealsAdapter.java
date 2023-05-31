package com.example.food_planner.Main.ViewAllMeals.View;

import static java.security.AccessController.getContext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.food_planner.Main.ViewAllMeals.AllMealModel.MealsItemThumb;
import com.example.food_planner.R;

import java.util.ArrayList;
import java.util.List;

public class AllMealsAdapter extends RecyclerView.Adapter<AllMealsAdapter.ViewHolder> {
    Context context;
    List<MealsItemThumb> meals=new ArrayList<>();
    OnMealClickListener listener;

    public AllMealsAdapter(Context context, List<MealsItemThumb> meals, OnMealClickListener listener) {
        this.context = context;
        this.meals = meals;
        this.listener = listener;
    }
    public void setList(List<MealsItemThumb> updatedmeals){
        this.meals=updatedmeals;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ConstraintLayout constraintLayout;
        CardView cardView;
        ImageView mealImage;
        TextView mealName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view=itemView;
            constraintLayout=itemView.findViewById(R.id.card);
            cardView=itemView.findViewById(R.id.allmealCard);
            mealImage=itemView.findViewById(R.id.allmealImage_id);
            mealName=itemView.findViewById(R.id.allmealNameCard);
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
        MealsItemThumb thumb=meals.get(position);
        holder.mealName.setText(thumb.getStrMeal());
        Glide.with(context).load(thumb.getStrMealThumb())
                .apply(new RequestOptions().override(300,250))
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background).into(holder.mealImage);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               listener.onClick(meals.get(position).getIdMeal());
            }
        });
    }
    @Override
    public int getItemCount() {
        return meals.size();
    }


}
