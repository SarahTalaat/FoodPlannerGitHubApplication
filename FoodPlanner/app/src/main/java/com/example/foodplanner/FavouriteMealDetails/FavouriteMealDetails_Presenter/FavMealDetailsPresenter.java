package com.example.foodplanner.FavouriteMealDetails.FavouriteMealDetails_Presenter;

//import androidx.lifecycle.LiveData;


import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;

public interface FavMealDetailsPresenter {

    public void getFavMealDetails();
    public void removeFromFav(MealDetails mealDetails);
}