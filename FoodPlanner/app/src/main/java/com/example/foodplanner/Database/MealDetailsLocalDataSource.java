package com.example.foodplanner.Database;

import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

public interface MealDetailsLocalDataSource {
    public Completable insert(MealDetails mealDetails);
    public Completable delete(MealDetails mealDetails);
    public Flowable<List<MealDetails>> getStoredProducts();
}
