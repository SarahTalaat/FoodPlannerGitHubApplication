package com.example.foodplanner.Model_Category;

import android.database.Observable;

import androidx.lifecycle.LiveData;

import com.example.foodplanner.Network.NetworkCallBack;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

public interface CategoryRepository {
    public Flowable<List<Category>> getStoredProducts();

    public Observable<CategoryResponse> getAllProducts();

    public Completable insertProduct(Category category);

    public Completable deleteProduct(Category category);

}