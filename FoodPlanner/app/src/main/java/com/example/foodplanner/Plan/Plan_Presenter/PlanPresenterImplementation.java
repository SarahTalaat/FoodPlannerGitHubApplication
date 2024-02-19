package com.example.foodplanner.Plan.Plan_Presenter;

import android.util.Log;

import com.example.foodplanner.CountryMeals.CountryMeals_Model.CountryMealsRepositoryImplementation;
import com.example.foodplanner.CountryMeals.CountryMeals_View.CountryMealsViewInterface;
import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetailsRepository;
import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetailsRepositoryImplementation;
import com.example.foodplanner.Plan.Plan_Model.Plan;
import com.example.foodplanner.Plan.Plan_View.PlanViewInterface;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Flowable;

public class PlanPresenterImplementation implements  PlanPresenterInterface{


    public static final String TAG = "PlanPresenterImp";
    MealDetailsRepository mealDetailsRepository;
    PlanViewInterface planViewInterface;




    public PlanPresenterImplementation(PlanViewInterface planViewInterface, MealDetailsRepositoryImplementation instance) {
        this.mealDetailsRepository = instance;
        this.planViewInterface = planViewInterface;
        Log.i("X", "AllCountryMeals presenter constructor ");
    }




    @Override
    public Flowable<List<Plan>> getMealplan() {
        return mealDetailsRepository.getStoredPlan();
    }

    @Override
    public void removemealplan(Plan plan) {
         mealDetailsRepository.deletePlan(plan).observeOn(AndroidSchedulers.mainThread()).subscribe(()-> {

                    Log.i(TAG, "Deleted successfully");},
                throwable -> {
                    Log.i(TAG, "erorr of deleting");}

        );
    }
}
