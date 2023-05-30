package com.example.food_planner.MealModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MealResponse implements Serializable {
	public List<MealModel> meals;

	public MealResponse(List<MealModel> meals) {
		this.meals = meals;
	}

	public List<MealModel> getMeals() {
		return meals;
	}

	public void setMeals(List<MealModel> meals) {
		this.meals = meals;
	}
}