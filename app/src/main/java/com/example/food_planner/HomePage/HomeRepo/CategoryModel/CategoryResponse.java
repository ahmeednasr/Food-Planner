package com.example.food_planner.HomePage.HomeRepo.CategoryModel;

import java.util.List;

public class CategoryResponse{
	private List<CategoryItem> meals;

	public List<CategoryItem> getMeals(){
		return meals;
	}
}