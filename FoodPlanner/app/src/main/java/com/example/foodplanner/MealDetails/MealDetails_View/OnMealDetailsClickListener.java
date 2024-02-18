
package com.example.foodplanner.MealDetails.MealDetails_View;

import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;
import com.example.foodplanner.Plan.Plan_Model.Plan;

public interface OnMealDetailsClickListener {

    void onFavClickMealDetails(MealDetails mealDetails);
    void onDeleteClickMealDetails(MealDetails mealDetails);

    void onPlanClick(Plan plan);

  //  void onMealDetailsClick(String categoryMeal);

}
