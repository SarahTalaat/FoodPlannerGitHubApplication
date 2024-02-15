
package com.example.foodplanner.CategoryMeals.CategoryMeals_View;

import com.example.foodplanner.CategoryMeals.CategoryMeals_Model.CategoryMeals;

import java.util.ArrayList;


public interface CategoryMealsViewInterface {

    public void showDataCategoryMeals(ArrayList<CategoryMeals> categoryMeals);
    public void showErrorMsgCategoryMeals(String error);
    public void addCategoryMeals(CategoryMeals categoryMeals);


}

