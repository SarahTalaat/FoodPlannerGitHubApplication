package com.example.foodplanner.Fish_Model;

import com.example.foodplanner.Network.ConnetionRemoteDataSource;

import java.util.List;


import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public class FishRepositoryImplementation implements FishRepository{

    private static FishRepositoryImplementation repository = null;
    ConnetionRemoteDataSource connetionRemoteDataSource; //ntwork connection and get data

    public FishRepositoryImplementation(ConnetionRemoteDataSource connetionRemoteDataSource) {
        this.connetionRemoteDataSource = connetionRemoteDataSource;
    }

    //    CategoryLocalDataSource categoryLocalDataSource; //insert delete getpro interface
/*
    private CategoryRepositoryImplementation(ConnetionRemoteDataSource connetionRemoteDataSource, CategoryLocalDataSource categoryLocalDataSource) {
        this.connetionRemoteDataSource = connetionRemoteDataSource;
        this.categoryLocalDataSource = categoryLocalDataSource;
    }
*/
    public static FishRepositoryImplementation getInstance(ConnetionRemoteDataSource connetionRemoteDataSource) {
        if (repository == null) {
            repository = new FishRepositoryImplementation(connetionRemoteDataSource);
        }
        return repository;
    }

    @Override
    public Flowable<List<Fish>> getStoredFish() {
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
    public Observable<FishResponse> getAllFish() {
        return connetionRemoteDataSource.makeNetworkCallBackFish();
    }

    @Override
    public Completable insertFish(Fish fish) {
        return null;
    }

    @Override
    public Completable deleteFish(Fish fish) {
        return null;
    }


}
