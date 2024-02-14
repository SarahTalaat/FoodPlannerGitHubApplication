package com.example.foodplanner.Category.presenter_Category;

import android.util.Log;

import com.example.foodplanner.Category.View_Category.CategoryViewInterface;
import com.example.foodplanner.Model_Category.Category;
import com.example.foodplanner.Model_Category.CategoryRepositoryImplementation;
import com.example.foodplanner.Model_Category.CategoryResponse;



import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;


public class CategoryPresenterImplementation implements  CategoryPresenterInterface {
    CategoryRepositoryImplementation repositoryImplementation;
    CategoryViewInterface viewInterface;
                                                                                            //bygeb el data men el network
    public CategoryPresenterImplementation(CategoryViewInterface allProductsActivity, CategoryRepositoryImplementation instance) {
        this.repositoryImplementation = instance;
        this.viewInterface = allProductsActivity;
        Log.i("X", "AllProducts presenter constructor ");
    }



    //All product Pesenter interface imp
    @Override
    public void getAllProducts() {
        Observable<CategoryResponse> observable = repositoryImplementation.getAllProducts();
        observable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<CategoryResponse>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull CategoryResponse categoryResponse) {
                viewInterface.showData(categoryResponse.categories);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                viewInterface.showErrorMsg("Error");
            }

            @Override
            public void onComplete() {

            }
        });

    }

    //All category Pesenter interface imp
    @Override
    public void addToFavourite(Category category) {
        Completable completable = repositoryImplementation.insertProduct(category);
        completable.observeOn(AndroidSchedulers.mainThread()).subscribe(() -> {
            viewInterface.showErrorMsg("Categories added to favourites successfully");
        },error -> {
            viewInterface.showErrorMsg("Error adding categories to favourites");
     });
    }

    //Network
}
