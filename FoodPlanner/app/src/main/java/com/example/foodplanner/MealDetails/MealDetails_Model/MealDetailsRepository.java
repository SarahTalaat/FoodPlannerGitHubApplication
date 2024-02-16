package com.example.foodplanner.MealDetails.MealDetails_Model;


import java.util.List;


import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public interface MealDetailsRepository {

    public Flowable<List<MealDetails>> getStoredMealDetails();

    public Observable<MealDetailsResponse> getAllMealDetails(String countryMeal);

    public Completable insertMealDetails(MealDetails mealDetails);

    public Completable deleteMealDetails(MealDetails mealDetails);



}
