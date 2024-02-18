
package com.example.foodplanner.MealDetails.MealDetails_Presenter;

import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;

public interface MealDetailsPresenterInterface {
    public void getAllMealDetails(String countryMeal);
    public void addToFavouriteMealDetails(MealDetails mealDetails);

    public void removeFromFavourite(MealDetails mealDetails);


}

