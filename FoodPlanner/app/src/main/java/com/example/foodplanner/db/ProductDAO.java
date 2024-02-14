package com.example.foodplanner.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.foodplanner.Model_Category.Category;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

@Dao
public interface ProductDAO {
@Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insert(Category category);
@Delete
Completable delete(Category category);
@Query("SELECT * FROM category")
Flowable<List<Category>> getFavProducts();


}
