package com.example.foodplanner.Category_Model;

import com.example.foodplanner.Network.ConnetionRemoteDataSource;


import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public class CategoryRepositoryImplementation implements CategoryRepository {
    private static CategoryRepositoryImplementation repository = null;
    ConnetionRemoteDataSource connetionRemoteDataSource; //ntwork connection and get data

    public CategoryRepositoryImplementation(ConnetionRemoteDataSource connetionRemoteDataSource) {
        this.connetionRemoteDataSource = connetionRemoteDataSource;
    }

    //    CategoryLocalDataSource categoryLocalDataSource; //insert delete getpro interface
/*
    private CategoryRepositoryImplementation(ConnetionRemoteDataSource connetionRemoteDataSource, CategoryLocalDataSource categoryLocalDataSource) {
        this.connetionRemoteDataSource = connetionRemoteDataSource;
        this.categoryLocalDataSource = categoryLocalDataSource;
    }
*/
    public static CategoryRepositoryImplementation getInstance(ConnetionRemoteDataSource connetionRemoteDataSource) {
        if (repository == null) {
            repository = new CategoryRepositoryImplementation(connetionRemoteDataSource);
        }
        return repository;
    }

    @Override
    public Flowable<List<Category>> getStoredProducts() {
        return null;
    }

    /*
        public static CategoryRepositoryImplementation getInstance(ConnetionRemoteDataSource connetionRemoteDataSource, CategoryLocalDataSource categoryLocalDataSource) {
            if (repository == null) {
                repository = new CategoryRepositoryImplementation(connetionRemoteDataSource, categoryLocalDataSource);
            }
            return repository;
        }

        */
/*
    @Override
    public Flowable<List<Category>> getStoredProducts() {
        return categoryLocalDataSource.getAllStoredProducts();
    }
*/
    @Override
    public Observable<CategoryResponse> getAllProducts() {
        return connetionRemoteDataSource.makeNetworkCallBackCategory();
    }

    @Override
    public Completable insertProduct(Category category) {
        return null;
    }

    @Override
    public Completable deleteProduct(Category category) {
        return null;
    }

/*
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
*/
}