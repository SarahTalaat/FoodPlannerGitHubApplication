
package com.example.foodplanner.MealDetails.MealDetails_View;

import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;

import java.util.ArrayList;


public interface MealDetailsViewInterface {

    public void showDataMealDetails(ArrayList<MealDetails> mealDetails);
    public void showErrorMsgMealDetails(String error);
    public void addMealDetails(MealDetails mealDetails);


}

