package com.example.foodplanner.Random.Random_Model;

import com.example.foodplanner.Network.ConnetionRemoteDataSource;

import java.util.List;


import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public class RandomRepositoryImplementation implements RandomRepository{

    private static RandomRepositoryImplementation repository = null;
    ConnetionRemoteDataSource connetionRemoteDataSource; //ntwork connection and get data

    public RandomRepositoryImplementation(ConnetionRemoteDataSource connetionRemoteDataSource) {
        this.connetionRemoteDataSource = connetionRemoteDataSource;
    }

    //    CategoryLocalDataSource categoryLocalDataSource; //insert delete getpro interface
/*
    private AllCategoryRepositoryImplementation(ConnetionRemoteDataSource connetionRemoteDataSource, CategoryLocalDataSource categoryLocalDataSource) {
        this.connetionRemoteDataSource = connetionRemoteDataSource;
        this.categoryLocalDataSource = categoryLocalDataSource;
    }
*/
    public static RandomRepositoryImplementation getInstance(ConnetionRemoteDataSource connetionRemoteDataSource) {
        if (repository == null) {
            repository = new RandomRepositoryImplementation(connetionRemoteDataSource);
        }
        return repository;
    }

    @Override
    public Flowable<List<Random>> getStoredRandom() {
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
    public Observable<RandomResponse> getAllRandom() {
        return connetionRemoteDataSource.makeNetworkCallBackRandom();
    }

    @Override
    public Completable insertRandom(Random random) {
        return null;
    }

    @Override
    public Completable deleteRandom(Random random) {
        return null;
    }


}
