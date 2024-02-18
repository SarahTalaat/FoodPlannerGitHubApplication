package com.example.foodplanner.Database;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;
import com.example.foodplanner.Plan.Plan_Model.Plan;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

public interface PlanDAO {

    @Query("select * from plan_table")
    public Flowable<List<Plan>> getAllPlan();
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public Completable insertPlans(Plan plan);
    @Delete
    public Completable deletePlan(Plan plan);




}
