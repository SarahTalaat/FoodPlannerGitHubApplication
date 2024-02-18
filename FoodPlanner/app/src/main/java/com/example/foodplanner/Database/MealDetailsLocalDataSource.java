package com.example.foodplanner.Database;

import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;
import com.example.foodplanner.Plan.Plan_Model.Plan;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

public interface MealDetailsLocalDataSource {
    public Completable insert(MealDetails mealDetails);
    public Completable delete(MealDetails mealDetails);
    public Flowable<List<MealDetails>> getStoredProducts();



    public Completable insertPlan(Plan plan);
    public Completable deletePlan(Plan plan);
    public Flowable<List<Plan>> getStoredPlan();
}
