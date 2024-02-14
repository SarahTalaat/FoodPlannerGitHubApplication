package com.example.foodplanner.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.foodplanner.Model_Category.Category;

@Database(entities = {Category.class}, version=1)
public abstract class ProductDatabase extends RoomDatabase {
     public abstract ProductDAO productDAO();

     private static ProductDatabase instance = null;

     public static synchronized ProductDatabase getInstance(Context context){

          if(instance==null){
               instance=Room.databaseBuilder(context.getApplicationContext(),ProductDatabase.class,"categories")
                       .build();
          }
          return instance;
     }
}
