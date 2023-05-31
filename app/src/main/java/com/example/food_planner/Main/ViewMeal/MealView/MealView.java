package com.example.food_planner.Main.ViewMeal.MealView;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.food_planner.DataBase.ContractLocalSource;
import com.example.food_planner.DataBase.LocalSource;
import com.example.food_planner.Main.ViewMeal.MealPresenter.MealPresenter;
import com.example.food_planner.Main.ViewMeal.MealPresenter.MealPresenterInterface;
import com.example.food_planner.Main.ViewMeal.MealRepo.MealRepo;
import com.example.food_planner.MealModel.MealModel;
import com.example.food_planner.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MealView extends Fragment implements MealViewInterface {
    TextView mealName,area,category,instractions,ingrediant;
    MealModel mealModel;
    AppCompatImageView imageView;
    YouTubePlayerView youTubePlayerView;
    FloatingActionButton addFavButton;
    MealPresenterInterface presenter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_meal_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //presenter=new
        initUI(view);
        mealModel=MealViewArgs.fromBundle(getArguments()).getMeal();
        presenter=new MealPresenter(this, MealRepo.getInstance(ContractLocalSource.getInstance(getContext()),getContext()));

        addFavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMeal(mealModel);
                Toast.makeText(getContext(), "done", Toast.LENGTH_SHORT).show();
            }
        });
        Glide.with(getContext()).load(mealModel.getStrMealThumb())
                .apply(new RequestOptions().override(400,300))
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background).into(imageView);
        mealName.setText(mealModel.getStrMeal());
        area.setText(mealModel.getStrArea());
        category.setText(mealModel.getStrCategory());
        instractions.setText(mealModel.getStrInstructions());
        youTubePlayerView = view.findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);
        getYoutubeVideo();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 20; i++) {
            String ingredients = null;
            String measure=null;
            try {
                ingredients = mealModel.getClass().getMethod("getStrIngredient" + i).invoke(mealModel).toString();
                 measure = mealModel.getClass().getMethod("getStrMeasure" + i).invoke(mealModel).toString();
              if(!ingredients.isEmpty()&&!measure.isEmpty()){
                  sb.append(ingredients).append(": ").append(measure).append("\n");
              }

            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        ingrediant.setText(sb.toString());
    }

    private void initUI(View view) {
        mealName=view.findViewById(R.id.mealNameValue);
        area=view.findViewById(R.id.areaValue);
        category=view.findViewById(R.id.categoryValue);
        instractions=view.findViewById(R.id.instractionsValue);
        ingrediant=view.findViewById(R.id.mealIngredients);
        imageView=view.findViewById(R.id.mealImage_id);
        addFavButton=view.findViewById(R.id.addFavBtn);
    }

    private String extractVideoIdFromLink(String videoLink) {
        String videoId = null;
        Pattern pattern = Pattern.compile("(?<=watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*");
        Matcher matcher = pattern.matcher(videoLink);
        if (matcher.find()) {
            videoId = matcher.group();
        }

        return videoId;
    }
    private void getYoutubeVideo(){
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                String videoId = extractVideoIdFromLink(mealModel.getStrYoutube());
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
    }

    @Override
    public void addMeal(MealModel meal) {
        presenter.addToFav(meal);
    }
}