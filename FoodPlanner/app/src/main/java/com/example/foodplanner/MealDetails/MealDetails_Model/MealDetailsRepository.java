package com.example.foodplanner.MealDetails.MealDetails_Model;


import com.example.foodplanner.Plan.Plan_Model.Plan;

import java.util.List;


import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public interface MealDetailsRepository {

    public Flowable<List<MealDetails>> getStoredMealDetails();

    public Observable<MealDetailsResponse> getAllMealDetails(String countryMeal);

    public Completable insertMealDetails(MealDetails mealDetails);

    public Completable deleteMealDetails(MealDetails mealDetails);



    public Flowable<List<Plan>> getStoredPlan();
    public Completable insertPlan(Plan plan);

    public Completable deletePlan(Plan plan);
}
