package com.example.food_planner.Main.HomePage.HomeView;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.food_planner.Main.MainNavigation;
import com.example.food_planner.MealDTO;
import com.example.food_planner.R;
import com.example.food_planner.ViewMeal;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    CardView mealOfDay;
    private NavController controller;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home_fragment, container, false);
        //return inflater.inflate(R.layout.view_meal_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        controller=Navigation.findNavController(view);
        MealDTO meal = new MealDTO(
                "1",
                "Spaghetti Carbonara",
                "Pasta",
                "Italian",
                "Season the beef cubes with salt and black pepper. Heat a tablespoon of oil in the frying pan and fry the meat over a high heat. Do this in three batches so that you don’t overcrowd the pan, transferring the meat to a large flameproof casserole dish once it is browned all over. Add extra oil if the pan seems dry. In the same pan, add another tablespoon of oil and cook the shallots for 4-5 minutes, then add the garlic and fry for 30 seconds. Add the bacon and fry until slightly browned. Transfer the onion and bacon mixture to the casserole dish and add the herbs. Preheat the oven to 180C/350F/Gas 4. Pour the stout into the frying pan and bring to the boil, stirring to lift any stuck-on browned bits from the bottom of the pan. Pour the stout over the beef in the casserole dish and add the stock. Cover the casserole and place it in the oven for 1½-2 hours, or until the beef is tender and the sauce is reduced. Skim off any surface fat, taste and add salt and pepper if necessary, then stir in the cornflour paste. Put the casserole dish on the hob – don’t forget that it will be hot – and simmer for 1-2 minutes, stirring, until thickened. Leave to cool. Increase the oven to 200C/400F/Gas 6. To make the pastry, put the flour and salt in a very large bowl. Grate the butter and stir it into the flour in three batches. Gradually add 325ml/11fl oz cold water – you may not need it all – and stir with a round-bladed knife until the mixture just comes together. Knead the pastry lightly into a ball on a lightly floured surface and set aside 250g/9oz for the pie lid. Roll the rest of the pastry out until about 2cm/¾in larger than the dish you’re using. Line the dish with the pastry then pile in the filling, tucking the oysters in as well. Brush the edge of the pastry with beaten egg. Roll the remaining pastry until slightly larger than your dish and gently lift over the filling, pressing the edges firmly to seal, then trim with a sharp knife. Brush with beaten egg to glaze. Put the dish on a baking tray and bake for 25-30 minutes, or until the pastry is golden-brown and the filling is bubbling.",
                "https://www.themealdb.com/images/media/meals/wrssvt1511556563.jpg",
                "Italian, Pasta",
                "https://www.youtube.com/watch?v=ONX74yP6JnI",
                "Spaghetti",
                "Bacon",
                "Eggs",
                "Parmesan cheese",
                "Spaghetti",
                "Bacon",
                "Eggs",
                "Parmesan cheese",
                "Spaghetti",
                "Bacon",
                "Eggs",
                "Parmesan cheese",
                "Spaghetti",
                "Bacon",
                "Eggs",
                "",
                "",
                "",
                "",
                "",
                "1 package",
                "6 slices",
                "3",
                "1/2 cup",
                "1 package",
                "6 slices",
                "3",
                "1/2 cup",
                "1 package",
                "1 package",
                "6 slices",
                "3",
                "1/2 cup",
                "1 package",
                "6 slices",
                "",
                "",
                "",
                "",
                ""
        );

        mealOfDay=view.findViewById(R.id.mealCard);
        mealOfDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.navigate(HomeFragmentDirections.actionHomeFragmentToViewMeal(meal));
            }
        });
    }
}