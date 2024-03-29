
package com.example.foodplanner.MealDetails.MealDetails_Presenter;

import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;
import com.example.foodplanner.Plan.Plan_Model.Plan;

public interface MealDetailsPresenterInterface {
    public void getAllMealDetails(String countryMeal);
    public void addToFavouriteMealDetails(MealDetails mealDetails);

    public void removeFromFavourite(MealDetails mealDetails);

    public void addToPlanPresenterInterface(Plan plan);

}

