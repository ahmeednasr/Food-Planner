package com.example.food_planner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MealDTO implements Serializable {
    private String idMeal;
    private String strMeal;
    private String strCategory;
    private String strArea;
    private String strInstructions;
    private String strMealThumb;
    private String strTags;
    private String strYoutube;
    private String strIngredient1;
    private String strIngredient2;
    private String strIngredient3;
    private String strIngredient4;
    private String strIngredient5;
    private String strIngredient6;
    private String strIngredient7;
    private String strIngredient8;
    private String strIngredient9;
    private String strIngredient10;
    private String strIngredient11;
    private String strIngredient12;
    private String strIngredient13;
    private String strIngredient14;
    private String strIngredient15;
    private String strIngredient16;
    private String strIngredient17;
    private String strIngredient18;
    private String strIngredient19;
    private String strIngredient20;
    private String strMeasure1;
    private String strMeasure2;
    private String strMeasure3;
    private String strMeasure4;
    private String strMeasure5;
    private String strMeasure6;
    private String strMeasure7;
    private String strMeasure8;
    private String strMeasure9;
    private String strMeasure10;
    private String strMeasure11;
    private String strMeasure12;
    private String strMeasure13;
    private String strMeasure14;
    private String strMeasure15;
    private String strMeasure16;
    private String strMeasure17;
    private String strMeasure18;
    private String strMeasure19;
    private String strMeasure20;

    private ArrayList<String> mealDetails=new ArrayList<>();

    public MealDTO(String idMeal, String strMeal, String strCategory, String strArea, String strInstructions, String strMealThumb, String strTags, String strYoutube, String strIngredient1, String strIngredient2, String strIngredient3, String strIngredient4, String strIngredient5, String strIngredient6, String strIngredient7, String strIngredient8, String strIngredient9, String strIngredient10, String strIngredient11, String strIngredient12, String strIngredient13, String strIngredient14, String strIngredient15, String strIngredient16, String strIngredient17, String strIngredient18, String strIngredient19, String strIngredient20, String strMeasure1, String strMeasure2, String strMeasure3, String strMeasure4, String strMeasure5, String strMeasure6, String strMeasure7, String strMeasure8, String strMeasure9, String strMeasure10, String strMeasure11, String strMeasure12, String strMeasure13, String strMeasure14, String strMeasure15, String strMeasure16, String strMeasure17, String strMeasure18, String strMeasure19, String strMeasure20) {
        this.idMeal = idMeal;
        this.strMeal = strMeal;
        this.strCategory = strCategory;
        this.strArea = strArea;
        this.strInstructions = strInstructions;
        this.strMealThumb = strMealThumb;
        this.strTags = strTags;
        this.strYoutube = strYoutube;
        this.strIngredient1 = strIngredient1;
        this.strIngredient2 = strIngredient2;
        this.strIngredient3 = strIngredient3;
        this.strIngredient4 = strIngredient4;
        this.strIngredient5 = strIngredient5;
        this.strIngredient6 = strIngredient6;
        this.strIngredient7 = strIngredient7;
        this.strIngredient8 = strIngredient8;
        this.strIngredient9 = strIngredient9;
        this.strIngredient10 = strIngredient10;
        this.strIngredient11 = strIngredient11;
        this.strIngredient12 = strIngredient12;
        this.strIngredient13 = strIngredient13;
        this.strIngredient14 = strIngredient14;
        this.strIngredient15 = strIngredient15;
        this.strIngredient16 = strIngredient16;
        this.strIngredient17 = strIngredient17;
        this.strIngredient18 = strIngredient18;
        this.strIngredient19 = strIngredient19;
        this.strIngredient20 = strIngredient20;
        this.strMeasure1 = strMeasure1;
        this.strMeasure2 = strMeasure2;
        this.strMeasure3 = strMeasure3;
        this.strMeasure4 = strMeasure4;
        this.strMeasure5 = strMeasure5;
        this.strMeasure6 = strMeasure6;
        this.strMeasure7 = strMeasure7;
        this.strMeasure8 = strMeasure8;
        this.strMeasure9 = strMeasure9;
        this.strMeasure10 = strMeasure10;
        this.strMeasure11 = strMeasure11;
        this.strMeasure12 = strMeasure12;
        this.strMeasure13 = strMeasure13;
        this.strMeasure14 = strMeasure14;
        this.strMeasure15 = strMeasure15;
        this.strMeasure16 = strMeasure16;
        this.strMeasure17 = strMeasure17;
        this.strMeasure18 = strMeasure18;
        this.strMeasure19 = strMeasure19;
        this.strMeasure20 = strMeasure20;
    }

    public String getIdMeal() {
        return idMeal;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public String getStrArea() {
        return strArea;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public String getStrTags() {
        return strTags;
    }

    public String getStrYoutube() {
        return strYoutube;
    }

    public ArrayList<String> getStrMealDetails() {
        if (!strIngredient1.isEmpty()) {
            mealDetails.add(strIngredient1 + " - " + strMeasure1);
        }
        if (!strIngredient2.isEmpty()) {
            mealDetails.add(strIngredient2 + " - " + strMeasure2);
        }
        if (!strIngredient3.isEmpty()) {
            mealDetails.add(strIngredient3 + " - " + strMeasure3);
        }
        if (!strIngredient4.isEmpty()) {
            mealDetails.add(strIngredient4 + " - " + strMeasure4);
        }
        if (!strIngredient5.isEmpty()) {
            mealDetails.add(strIngredient5 + " - " + strMeasure5);
        }
        if (!strIngredient6.isEmpty()) {
            mealDetails.add(strIngredient6 + " - " + strMeasure6);
        }
        if (!strIngredient7.isEmpty()) {
            mealDetails.add(strIngredient7 + " - " + strMeasure7);
        }
        if (!strIngredient8.isEmpty()) {
            mealDetails.add(strIngredient8 + " - " + strMeasure8);
        }
        if (!strIngredient9.isEmpty()) {
            mealDetails.add(strIngredient9 + " - " + strMeasure9);
        }
        if (!strIngredient10.isEmpty()) {
            mealDetails.add(strIngredient10 + " - " + strMeasure10);
        }
        if (!strIngredient11.isEmpty()) {
            mealDetails.add(strIngredient11 + " - " + strMeasure11);
        }
        if (!strIngredient12.isEmpty()) {
            mealDetails.add(strIngredient12 + " - " + strMeasure12);
        }
        if (!strIngredient13.isEmpty()) {
            mealDetails.add(strIngredient13 + " - " + strMeasure13);
        }
        if (!strIngredient14.isEmpty()) {
            mealDetails.add(strIngredient14 + " - " + strMeasure14);
        }
        if (!strIngredient15.isEmpty()) {
            mealDetails.add(strIngredient15 + " - " + strMeasure15);
        }
        if (!strIngredient16.isEmpty()) {
            mealDetails.add(strIngredient16 + " - " + strMeasure16);
        }
        if (!strIngredient17.isEmpty()) {
            mealDetails.add(strIngredient17 + " - " + strMeasure17);
        }
        if (!strIngredient18.isEmpty()) {
            mealDetails.add(strIngredient18 + " - " + strMeasure18);
        }
        if (!strIngredient19.isEmpty()) {
            mealDetails.add(strIngredient19 + " - " + strMeasure19);
        }
        if (!strIngredient20.isEmpty()) {
            mealDetails.add(strIngredient20 + " - " + strMeasure20);
        }
        return mealDetails;
    }
}
