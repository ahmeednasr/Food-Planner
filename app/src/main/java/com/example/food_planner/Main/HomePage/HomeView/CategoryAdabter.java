package com.example.food_planner.Main.HomePage.HomeView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_planner.Main.HomePage.HomeRepo.CategoryModel.CategoryItem;
import com.example.food_planner.R;

import java.util.List;

public class CategoryAdabter extends RecyclerView.Adapter<CategoryAdabter.ViewHolder> {
    Context context;
    List<CategoryItem> list;
    OnCategoryClickListner listener;

    public CategoryAdabter(Context context, List<CategoryItem> list, OnCategoryClickListner listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }
    public void setList(List<CategoryItem> updatedProduct){
        this.list=updatedProduct;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ConstraintLayout constraintLayout;
        Button itemBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view=itemView;
            constraintLayout=itemView.findViewById(R.id.item);
            itemBtn=itemView.findViewById(R.id.valueBtn);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup recycleView, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(recycleView.getContext());
        View v=layoutInflater.inflate(R.layout.textcard,recycleView,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        CategoryItem requistmsg=list.get(position);
        holder.itemBtn.setText(requistmsg.getStrCategory());
        holder.itemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,list.get(position).getStrCategory(),Toast.LENGTH_SHORT).show();
                listener.onCategoryClick(requistmsg.getStrCategory(),"CATEGORY");
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
}
