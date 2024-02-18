
package com.example.foodplanner.MealDetails.MealDetails_View;

import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;
import com.example.foodplanner.Plan.Plan_Model.Plan;

import java.util.ArrayList;
import java.util.List;


public interface MealDetailsViewInterface {

    public void showDataMealDetails(List<MealDetails> mealDetails);
    public void showErrorMsgMealDetails(String error);
    public void addMealDetails(MealDetails mealDetails);
    public void removeMealDetails(MealDetails mealDetails);

    public void addToPlan(Plan plan);

}

