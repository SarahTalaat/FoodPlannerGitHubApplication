
package com.example.foodplanner.MealDetails.MealDetails_View;

import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;

import java.util.ArrayList;
import java.util.List;


public interface MealDetailsViewInterface {

    public void showDataMealDetails(List<MealDetails> mealDetails);
    public void showErrorMsgMealDetails(String error);
    public void addMealDetails(MealDetails mealDetails);

    public void removeMealDetails(MealDetails mealDetails);


}

