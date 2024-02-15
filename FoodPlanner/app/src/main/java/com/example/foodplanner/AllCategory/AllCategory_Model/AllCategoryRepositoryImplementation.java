package com.example.foodplanner.AllCategory.AllCategory_Model;

import com.example.foodplanner.Network.ConnetionRemoteDataSource;


import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public class AllCategoryRepositoryImplementation implements AllCategoryRepository {
    private static AllCategoryRepositoryImplementation repository = null;
    ConnetionRemoteDataSource connetionRemoteDataSource; //ntwork connection and get data

    public AllCategoryRepositoryImplementation(ConnetionRemoteDataSource connetionRemoteDataSource) {
        this.connetionRemoteDataSource = connetionRemoteDataSource;
    }

    //    CategoryLocalDataSource categoryLocalDataSource; //insert delete getpro interface
/*
    private AllCategoryRepositoryImplementation(ConnetionRemoteDataSource connetionRemoteDataSource, CategoryLocalDataSource categoryLocalDataSource) {
        this.connetionRemoteDataSource = connetionRemoteDataSource;
        this.categoryLocalDataSource = categoryLocalDataSource;
    }
*/
    public static AllCategoryRepositoryImplementation getInstance(ConnetionRemoteDataSource connetionRemoteDataSource) {
        if (repository == null) {
            repository = new AllCategoryRepositoryImplementation(connetionRemoteDataSource);
        }
        return repository;
    }

    @Override
    public Flowable<List<AllCategory>> getStoredProducts() {
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
    public Observable<AllCategoryResponse> getAllProducts() {
        return connetionRemoteDataSource.makeNetworkCallBackCategory();
    }

    @Override
    public Completable insertProduct(AllCategory allCategory) {
        return null;
    }

    @Override
    public Completable deleteProduct(AllCategory allCategory) {
        return null;
    }

/*
    @Override
    public Completable insertProduct(AllCategory category) {
        return categoryLocalDataSource.insertProduct(category);
    }
//Mariam
    //Hanen

    @Override
    public Completable deleteProduct(AllCategory category) {
       return  categoryLocalDataSource.deleteProduct(category);
}
*/
}