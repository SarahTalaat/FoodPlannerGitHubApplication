
package com.example.foodplanner.CategoryMeals.CategoryMeals_Presenter;

import android.util.Log;

import com.example.foodplanner.CategoryMeals.CategoryMeals_Model.CategoryMeals;
import com.example.foodplanner.CategoryMeals.CategoryMeals_View.CategoryMealsViewInterface;
import com.example.foodplanner.CategoryMeals.CategoryMeals_Model.CategoryMealsRepositoryImplementation;
import com.example.foodplanner.CategoryMeals.CategoryMeals_Model.CategoryMealsResponse;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class CategoryMealsPresenterImplementation implements CategoryMealsPresenterInterface {
    CategoryMealsRepositoryImplementation repositoryImplementation;
    CategoryMealsViewInterface viewInterface;
    //bygeb el data men el network
    public CategoryMealsPresenterImplementation(CategoryMealsViewInterface allProductsActivity, CategoryMealsRepositoryImplementation instance) {
        this.repositoryImplementation = instance;
        this.viewInterface = allProductsActivity;
        Log.i("X", "AllCategoryMeals presenter constructor ");
    }



    //All product Pesenter interface imp
    @Override
    public void getAllCategoryMeals() {
        Observable<CategoryMealsResponse> observable = repositoryImplementation.getAllCategoryMeals();
        observable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<CategoryMealsResponse>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull CategoryMealsResponse categoryMealsResponse) {
                viewInterface.showDataCategoryMeals(categoryMealsResponse.meals);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                viewInterface.showErrorMsgCategoryMeals("Error");
            }

            @Override
            public void onComplete() {

            }
        });

    }

    //All category Pesenter interface imp
    @Override
    public void addToFavouriteCategoryMeals(CategoryMeals categoryMeals) {
        Completable completable = repositoryImplementation.insertCategoryMeals(categoryMeals);
        completable.observeOn(AndroidSchedulers.mainThread()).subscribe(() -> {
            viewInterface.showErrorMsgCategoryMeals("CategoryMeals added to favourites successfully");
        },error -> {
            viewInterface.showErrorMsgCategoryMeals("Error adding categoryMeals to favourites");
        });
    }
}

