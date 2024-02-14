package com.example.foodplanner.Category_DB;

import com.example.foodplanner.Category_Model.Category;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

public interface CategoryLocalDataSource {
    Completable insertProduct(Category category);

    Completable deleteProduct(Category category);

    Flowable<List<Category>> getAllStoredProducts();
}