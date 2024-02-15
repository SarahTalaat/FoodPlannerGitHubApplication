package com.example.foodplanner.CategoryMeals.CategoryMeals_Model;

import com.example.foodplanner.Network.ConnetionRemoteDataSource;

import java.util.List;


import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public class CategoryMealsRepositoryImplementation implements CategoryMealsRepository {

    private static CategoryMealsRepositoryImplementation repository = null;
    ConnetionRemoteDataSource connetionRemoteDataSource; //ntwork connection and get data

    public CategoryMealsRepositoryImplementation(ConnetionRemoteDataSource connetionRemoteDataSource) {
        this.connetionRemoteDataSource = connetionRemoteDataSource;
    }

    //    CategoryLocalDataSource categoryLocalDataSource; //insert delete getpro interface
/*
    private AllCategoryRepositoryImplementation(ConnetionRemoteDataSource connetionRemoteDataSource, CategoryLocalDataSource categoryLocalDataSource) {
        this.connetionRemoteDataSource = connetionRemoteDataSource;
        this.categoryLocalDataSource = categoryLocalDataSource;
    }
*/
    public static CategoryMealsRepositoryImplementation getInstance(ConnetionRemoteDataSource connetionRemoteDataSource) {
        if (repository == null) {
            repository = new CategoryMealsRepositoryImplementation(connetionRemoteDataSource);
        }
        return repository;
    }

    @Override
    public Flowable<List<CategoryMeals>> getStoredCategoryMeals() {
        return null;
    }

    /*
        public static AllCategoryRepositoryImplementation getInstance(ConnetionRemoteDataSource connetionRemoteDataSource, CategoryLocalDataSource categoryLocalDataSource) {
            if (repository == null) {
                repository = new AllCategoryRepositoryImplementation(connetionRemoteDataSource, categoryLocalDataSource);
            }
            return repository;
        }

        */
/*
    @Override
    public Flowable<List<AllCategory>> getStoredProducts() {
        return categoryLocalDataSource.getAllStoredProducts();
    }
*/
    @Override
    public Observable<CategoryMealsResponse> getAllCategoryMeals() {
        return connetionRemoteDataSource.makeNetworkCallBackCategoryMeals();
    }

    @Override
    public Completable insertCategoryMeals(CategoryMeals categoryMeals) {
        return null;
    }

    @Override
    public Completable deleteCategoryMeals(CategoryMeals categoryMeals) {
        return null;
    }


}
