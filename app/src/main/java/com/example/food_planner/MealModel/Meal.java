package com.example.food_planner.MealModel;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Dao
@Entity
public class Meal implements Serializable {
	@PrimaryKey
	@NonNull
	public String idMeal;
	public String strMeal;
	public String strDrinkAlternate;
	public String strCategory;
	public String strArea;
	public String strInstructions;
	public String strMealThumb;
	public String strTags;
	public String strYoutube;
	public String strIngredient1;
	public String strIngredient2;
	public String strIngredient3;
	public String strIngredient4;
	public String strIngredient5;
	public String strIngredient6;
	public String strIngredient7;
	public String strIngredient8;
	public String strIngredient9;
	public String strIngredient10;
	public String strIngredient11;
	public String strIngredient12;
	public String strIngredient13;
	public String strIngredient14;
	public String strIngredient15;
	public String strIngredient16;
	public String strIngredient17;
	public String strIngredient18;
	public String strIngredient19;
	public String strIngredient20;
	public String strMeasure1;
	public String strMeasure2;
	public String strMeasure3;
	public String strMeasure4;
	public String strMeasure5;
	public String strMeasure6;
	public String strMeasure7;
	public String strMeasure8;
	public String strMeasure9;
	public String strMeasure10;
	public String strMeasure11;
	public String strMeasure12;
	public String strMeasure13;
	public String strMeasure14;
	public String strMeasure15;
	public String strMeasure16;
	public String strMeasure17;
	public String strMeasure18;
	public String strMeasure19;
	public String strMeasure20;

	@Ignore
	public List<String> strIngredient=new ArrayList<>();
	@Ignore
	public List<String>strMeasure=new ArrayList<>();

	public String strSource;

	public Object strImageSource;
	public Object strCreativeCommonsConfirmed;
	public Object dateModified;

	public Meal(String idMeal, String strMeal, String strDrinkAlternate, String strCategory, String strArea, String strInstructions, String strMealThumb, String strTags, String strYoutube, String strIngredient1, String strIngredient2, String strIngredient3, String strIngredient4, String strIngredient5, String strIngredient6, String strIngredient7, String strIngredient8, String strIngredient9, String strIngredient10, String strIngredient11, String strIngredient12, String strIngredient13, String strIngredient14, String strIngredient15, String strIngredient16, String strIngredient17, String strIngredient18, String strIngredient19, String strIngredient20, String strMeasure1, String strMeasure2, String strMeasure3, String strMeasure4, String strMeasure5, String strMeasure6, String strMeasure7, String strMeasure8, String strMeasure9, String strMeasure10, String strMeasure11, String strMeasure12, String strMeasure13, String strMeasure14, String strMeasure15, String strMeasure16, String strMeasure17, String strMeasure18, String strMeasure19, String strMeasure20, String strSource, Object strImageSource, Object strCreativeCommonsConfirmed, Object dateModified) {
		this.idMeal = idMeal;
		this.strMeal = strMeal;
		this.strDrinkAlternate = strDrinkAlternate;
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


		this.strSource = strSource;
		this.strImageSource = strImageSource;
		this.strCreativeCommonsConfirmed = strCreativeCommonsConfirmed;
		this.dateModified = dateModified;
	}

	public String getIdMeal() {
		return idMeal;
	}

	public String getStrMeal() {
		return strMeal;
	}

	public String getStrDrinkAlternate() {
		return strDrinkAlternate;
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

	public List<String> getStrIngredient() {
		this.strIngredient.add(strIngredient1);
		this.strIngredient.add(strIngredient2);
		this.strIngredient.add(strIngredient3);
		this.strIngredient.add(strIngredient4);
		this.strIngredient.add(strIngredient5);
		this.strIngredient.add(strIngredient6);
		this.strIngredient.add(strIngredient7);
		this.strIngredient.add(strIngredient8);
		this.strIngredient.add(strIngredient9);
		this.strIngredient.add(strIngredient10);
		this.strIngredient.add(strIngredient11);
		this.strIngredient.add(strIngredient12);
		this.strIngredient.add(strIngredient13);
		this.strIngredient.add(strIngredient14);
		this.strIngredient.add(strIngredient15);
		this.strIngredient.add(strIngredient16);
		this.strIngredient.add(strIngredient17);
		this.strIngredient.add(strIngredient18);
		this.strIngredient.add(strIngredient19);
		this.strIngredient.add(strIngredient20);

		return strIngredient;
	}

	public List<String> getStrMeasure() {
		this.strMeasure.add(strMeasure1);
		this.strMeasure.add(strMeasure2);
		this.strMeasure.add(strMeasure3);
		this.strMeasure.add(strMeasure4);
		this.strMeasure.add(strMeasure5);
		this.strMeasure.add(strMeasure6);
		this.strMeasure.add(strMeasure7);
		this.strMeasure.add(strMeasure8);
		this.strMeasure.add(strMeasure9);
		this.strMeasure.add(strMeasure10);
		this.strMeasure.add(strMeasure11);
		this.strMeasure.add(strMeasure12);
		this.strMeasure.add(strMeasure13);
		this.strMeasure.add(strMeasure14);
		this.strMeasure.add(strMeasure15);
		this.strMeasure.add(strMeasure16);
		this.strMeasure.add(strMeasure17);
		this.strMeasure.add(strMeasure18);
		this.strMeasure.add(strMeasure19);
		this.strMeasure.add(strMeasure20);
		return strMeasure;
	}

	public String getStrSource() {
		return strSource;
	}
}
