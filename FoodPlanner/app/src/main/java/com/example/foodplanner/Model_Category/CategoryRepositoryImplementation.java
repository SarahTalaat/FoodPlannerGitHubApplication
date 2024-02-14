package com.example.foodplanner.Model_Category;

import com.example.foodplanner.Network.CategoryRemoteDataSource;
import com.example.foodplanner.db.CategoryLocalDataSource;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public class CategoryRepositoryImplementation implements CategoryRepository {
    private static CategoryRepositoryImplementation repository = null;
    CategoryRemoteDataSource categoryRemoteDataSource; //ntwork connection and get data
    CategoryLocalDataSource categoryLocalDataSource; //insert delete getpro interface

    private CategoryRepositoryImplementation(CategoryRemoteDataSource categoryRemoteDataSource, CategoryLocalDataSource categoryLocalDataSource) {
        this.categoryRemoteDataSource = categoryRemoteDataSource;
        this.categoryLocalDataSource = categoryLocalDataSource;
    }

    public static CategoryRepositoryImplementation getInstance(CategoryRemoteDataSource categoryRemoteDataSource, CategoryLocalDataSource categoryLocalDataSource) {
        if (repository == null) {
            repository = new CategoryRepositoryImplementation(categoryRemoteDataSource, categoryLocalDataSource);
        }
        return repository;
    }

    @Override
    public Flowable<List<Category>> getStoredProducts() {
        return categoryLocalDataSource.getAllStoredProducts();
    }

    @Override
    public Observable<CategoryResponse> getAllProducts() {
        return categoryRemoteDataSource.makeNetworkCallBack();
    }


    @Override
    public Completable insertProduct(Category category) {
        return categoryLocalDataSource.insertProduct(category);
    }
//Mariam
    //Hanen

    @Override
    public Completable deleteProduct(Category category) {
       return  categoryLocalDataSource.deleteProduct(category);
}
}