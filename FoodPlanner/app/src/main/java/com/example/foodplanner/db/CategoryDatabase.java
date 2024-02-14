package com.example.foodplanner.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.foodplanner.Model_Category.Category;

@Database(entities = {Category.class}, version=1)
public abstract class CategoryDatabase extends RoomDatabase {
     public abstract CategoryDAO productDAO();

     private static CategoryDatabase instance = null;

     public static synchronized CategoryDatabase getInstance(Context context){

          if(instance==null){
               instance=Room.databaseBuilder(context.getApplicationContext(), CategoryDatabase.class,"categories")
                       .build();
          }
          return instance;
     }
}
