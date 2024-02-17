package com.example.foodplanner.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

@Dao
public interface MealDetailsDAO {
    @Query("select * from meal_table")
    public Flowable<List<MealDetails>> getAllProducts();
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public Completable insert(MealDetails mealDetails);
    @Delete
    public Completable delete(MealDetails mealDetails);
}

