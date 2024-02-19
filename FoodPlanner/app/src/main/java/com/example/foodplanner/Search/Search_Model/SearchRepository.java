package com.example.foodplanner.Search.Search_Model;



import com.example.foodplanner.AllCategory.AllCategory_Model.AllCategoryResponse;
import com.example.foodplanner.AllCountry.AllCountry_Model.CountryResponse;
import com.example.foodplanner.CategoryMeals.CategoryMeals_Model.CategoryMealsResponse;
import com.example.foodplanner.CountryMeals.CountryMeals_Model.CountryMealsResponse;

import io.reactivex.rxjava3.core.Observable;

public interface SearchRepository {

    Observable<AllCategoryResponse> getCategories();
    Observable<IngredientResponse>getIngredients();
    Observable<CountryResponse> getCountries();
//---------------------------------------------------------------
    Observable<CategoryMealsResponse> getCategoriesMeals(String categoryMeal);
    Observable<MealResponse>getIngredientsMeals(String ingredientMeal);
    Observable<CountryMealsResponse> getCountriesMeals(String countriesMeal);
    Observable<MealResponse>getMealsByName(String mealName);


}
