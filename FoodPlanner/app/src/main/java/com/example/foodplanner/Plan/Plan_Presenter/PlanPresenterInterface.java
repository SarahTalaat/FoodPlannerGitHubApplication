package com.example.foodplanner.Plan.Plan_Presenter;

import com.example.foodplanner.Plan.Plan_Model.Plan;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public interface PlanPresenterInterface {

    public Flowable<List<Plan>> getMealplan();
    public void  removemealplan(Plan plan);

}
