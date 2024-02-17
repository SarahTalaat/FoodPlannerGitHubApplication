package com.example.foodplanner.FavouriteMealDetails.FavouriteMealDetails_View;

//import androidx.lifecycle.LiveData;


import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;

import java.util.List;

public interface FavMealDetailsView {
    public void showData(List<MealDetails> mealDetailss);
    public void removeMealDetails(MealDetails mealDetails);
}