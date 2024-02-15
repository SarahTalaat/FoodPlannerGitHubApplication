package com.example.foodplanner.CategoryMeals.CategoryMeals_Model;


import java.util.List;


import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public interface CategoryMealsRepository {

    public Flowable<List<CategoryMeals>> getStoredCategoryMeals();

    public Observable<CategoryMealsResponse> getAllCategoryMeals(String categoryMeal);

    public Completable insertCategoryMeals(CategoryMeals categoryMeals);

    public Completable deleteCategoryMeals(CategoryMeals categoryMeals);



}
