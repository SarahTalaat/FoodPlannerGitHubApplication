package com.example.foodplanner.Search.Search_Presenter;

import com.example.foodplanner.AllCategory.AllCategory_Model.AllCategoryResponse;
import com.example.foodplanner.AllCountry.AllCountry_Model.CountryResponse;
import com.example.foodplanner.CategoryMeals.CategoryMeals_Model.CategoryMealsResponse;
import com.example.foodplanner.CountryMeals.CountryMeals_Model.CountryMealsResponse;
import com.example.foodplanner.Search.Search_Model.IngredientResponse;
import com.example.foodplanner.Search.Search_Model.MealResponse;

import io.reactivex.rxjava3.core.Observable;

public interface SearchPresenterInterface {

    void getCategories();
    void getIngredients();
    void getCountries();
    //---------------------------------------------------------------
    void getCategoriesMeals(String categoryMeal);
    void getIngredientsMeals(String ingredientMeal);
    void getCountriesMeals(String countriesMeal);
    void getMealsByName(String mealName);

}
