package com.example.food_planner.Main.SavedMeals.SavedMealsView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import com.example.food_planner.MealModel.MealModel;
import com.example.food_planner.R;

import java.util.List;

public class SavedMealsAdapter extends RecyclerView.Adapter<SavedMealsAdapter.ViewHolder> {
    Context context;
    List<MealModel> meals;
    onSavedMealsClickListener listener;

    public SavedMealsAdapter(Context context, List<MealModel> meals, onSavedMealsClickListener listener) {
        this.context = context;
        this.meals = meals;
        this.listener = listener;
    }
    public void setList(List<MealModel> updatedmeals){
        this.meals=updatedmeals;
        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ConstraintLayout constraintLayout;
        CardView cardView;
        ImageView mealImage;
        TextView mealName;
        Button removeBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view=itemView;
            constraintLayout=itemView.findViewById(R.id.savedcard);
            cardView=itemView.findViewById(R.id.savedmealCard);
            mealImage=itemView.findViewById(R.id.savedmealImage_id);
            mealName=itemView.findViewById(R.id.savedmealNameCard);
            removeBtn=itemView.findViewById(R.id.rmBtn);
            Log.i("TAG","OK  saved viewholder: ");

        }
    }
    @NonNull
    @Override
    public SavedMealsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup recycleView, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(recycleView.getContext());
        View v=layoutInflater.inflate(R.layout.savedcard,recycleView,false);
        SavedMealsAdapter.ViewHolder viewHolder=new SavedMealsAdapter.ViewHolder(v);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull SavedMealsAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        MealModel meal=meals.get(position);
        holder.mealName.setText(meal.getStrMeal());
        Glide.with(context).load(meal.getStrMealThumb())
                .apply(new RequestOptions().override(300,250))
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background).into(holder.mealImage);
        holder.removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,meals.get(position).getStrMeal(),Toast.LENGTH_SHORT).show();
                listener.onRemove(meals.get(position));
            }
        });
        holder.mealImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,meals.get(position).getStrMeal(),Toast.LENGTH_SHORT).show();
                listener.onclick(meals.get(position));
            }
        });

    }
    @Override
    public int getItemCount() {
        return meals.size();
    }
}
