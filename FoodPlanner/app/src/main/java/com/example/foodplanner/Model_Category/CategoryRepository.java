package com.example.foodplanner.Model_Category;


import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public interface CategoryRepository {
    public Flowable<List<Category>> getStoredProducts();

    public Observable<CategoryResponse> getAllProducts();

    public Completable insertProduct(Category category);

    public Completable deleteProduct(Category category);

}