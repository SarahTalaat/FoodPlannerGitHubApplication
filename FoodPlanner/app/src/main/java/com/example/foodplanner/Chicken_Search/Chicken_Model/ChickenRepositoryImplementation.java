package com.example.foodplanner.Chicken_Search.Chicken_Model;

import com.example.foodplanner.Network.ConnetionRemoteDataSource;

import java.util.List;


import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public class ChickenRepositoryImplementation implements ChickenRepository{

    private static ChickenRepositoryImplementation repository = null;
    ConnetionRemoteDataSource connetionRemoteDataSource; //ntwork connection and get data

    public ChickenRepositoryImplementation(ConnetionRemoteDataSource connetionRemoteDataSource) {
        this.connetionRemoteDataSource = connetionRemoteDataSource;
    }

    //    CategoryLocalDataSource categoryLocalDataSource; //insert delete getpro interface
/*
    private AllCategoryRepositoryImplementation(ConnetionRemoteDataSource connetionRemoteDataSource, CategoryLocalDataSource categoryLocalDataSource) {
        this.connetionRemoteDataSource = connetionRemoteDataSource;
        this.categoryLocalDataSource = categoryLocalDataSource;
    }
*/
    public static ChickenRepositoryImplementation getInstance(ConnetionRemoteDataSource connetionRemoteDataSource) {
        if (repository == null) {
            repository = new ChickenRepositoryImplementation(connetionRemoteDataSource);
        }
        return repository;
    }

    @Override
    public Flowable<List<Chicken>> getStoredChicken() {
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
    public Observable<ChickenResponse> getAllChicken() {
        return connetionRemoteDataSource.makeNetworkCallBackChicken();
    }

    @Override
    public Completable insertChicken(Chicken chicken) {
        return null;
    }

    @Override
    public Completable deleteChicken(Chicken chicken) {
        return null;
    }


}
