package com.example.food_planner.Search;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.food_planner.R;

public class SearchFragment extends Fragment {
    NavController controller;
    EditText search;
    RadioGroup radioGroup;
    RadioButton areaRadio;
    RadioButton categoryRadio;
    RadioButton ingrediantRadio;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.search_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        search=view.findViewById(R.id.search);
        radioGroup=view.findViewById(R.id.radioGroup);
        areaRadio=view.findViewById(R.id.areaRadio);
        categoryRadio=view.findViewById(R.id.categoryRadio);
        ingrediantRadio=view.findViewById(R.id.ingrediantRadio);
        areaRadio.setChecked(true);
        controller= Navigation.findNavController(view);
    }
}