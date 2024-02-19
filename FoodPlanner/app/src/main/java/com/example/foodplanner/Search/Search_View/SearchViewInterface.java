package com.example.foodplanner.Search.Search_View;

import com.example.foodplanner.AllCategory.AllCategory_Model.AllCategory;
import com.example.foodplanner.AllCountry.AllCountry_Model.Country;
import com.example.foodplanner.CategoryMeals.CategoryMeals_Model.CategoryMeals;
import com.example.foodplanner.CountryMeals.CountryMeals_Model.CountryMeals;
import com.example.foodplanner.Search.Search_Model.IngredientDTO;
import com.example.foodplanner.Search.Search_Model.Meals;

import java.util.ArrayList;
import java.util.List;


public interface SearchViewInterface {


    void showCountries(ArrayList<Country> allCountryArrayList);

    void showCategories(ArrayList<AllCategory> categoriesArrayList);
    void showIngredient(List<IngredientDTO> ingredientList);

    void showCountriesMeals(ArrayList<CountryMeals> allCountryMealsArrayList);
    void showCategoriesMeals(ArrayList<CategoryMeals> categoriesMealsArrayList);

    void showMeals(List<Meals> mealsList);
    void showMessage(String message);


}
