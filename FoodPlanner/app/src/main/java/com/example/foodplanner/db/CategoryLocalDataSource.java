package com.example.foodplanner.db;

import com.example.foodplanner.Model_Category.Category;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

public interface CategoryLocalDataSource {
    Completable insertProduct(Category category);

    Completable deleteProduct(Category category);

    Flowable<List<Category>> getAllStoredProducts();
}