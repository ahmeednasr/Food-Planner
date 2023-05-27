package com.example.food_planner;

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
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewMeal extends Fragment {
    TextView mealName,area,category,instractions,ingrediant;
    MealDTO mealDTO;
    AppCompatImageView imageView;
    YouTubePlayerView youTubePlayerView;
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
        mealName=view.findViewById(R.id.mealNameValue);
        area=view.findViewById(R.id.areaValue);
        category=view.findViewById(R.id.categoryValue);
        instractions=view.findViewById(R.id.instractionsValue);
        ingrediant=view.findViewById(R.id.mealIngredients);
        imageView=view.findViewById(R.id.mealImage_id);
        mealDTO=ViewMealArgs.fromBundle(getArguments()).getMeal();
        Toast.makeText(getContext(), "mealGetsData sucss"+mealDTO.getStrMealDetails().get(3), Toast.LENGTH_SHORT).show();
        Glide.with(getContext()).load(mealDTO.getStrMealThumb())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(imageView);

        mealName.setText(mealDTO.getStrMeal());
        area.setText(mealDTO.getStrArea());
        category.setText(mealDTO.getStrCategory());
        instractions.setText(mealDTO.getStrInstructions());
        youTubePlayerView = view.findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);
        getYoutubeVideo();
        StringBuilder sb = new StringBuilder();
        for (String element : mealDTO.getStrMealDetails()) {
            sb.append(element);
            sb.append("\n"); // add a newline character after each element
        }
        ingrediant.setText(sb.toString());
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
                String videoId = extractVideoIdFromLink(mealDTO.getStrYoutube());
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

    }
}