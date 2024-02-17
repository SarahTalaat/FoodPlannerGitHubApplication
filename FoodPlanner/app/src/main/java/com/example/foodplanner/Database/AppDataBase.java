package com.example.foodplanner.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;


@Database(entities = {MealDetails.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase instance=null;
    public abstract MealDetailsDAO getProductDAO();
    public static AppDataBase getInstance(Context context) {
        if(instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),AppDataBase.class,"mealDetailsDB").build();
        }
        return instance;
    }
}
