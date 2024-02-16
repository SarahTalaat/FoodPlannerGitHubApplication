package com.example.foodplanner.MealDetails.MealDetails_Model;

import com.example.foodplanner.Network.ConnetionRemoteDataSource;

import java.util.List;


import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public class MealDetailsRepositoryImplementation implements MealDetailsRepository {

    private static MealDetailsRepositoryImplementation repository = null;
    ConnetionRemoteDataSource connetionRemoteDataSource; //ntwork connection and get data

    public MealDetailsRepositoryImplementation(ConnetionRemoteDataSource connetionRemoteDataSource) {
        this.connetionRemoteDataSource = connetionRemoteDataSource;
    }

    //    CountryLocalDataSource countryLocalDataSource; //insert delete getpro interface
/*
    private AllCountryRepositoryImplementation(ConnetionRemoteDataSource connetionRemoteDataSource, CountryLocalDataSource countryLocalDataSource) {
        this.connetionRemoteDataSource = connetionRemoteDataSource;
        this.countryLocalDataSource = countryLocalDataSource;
    }
*/
    public static MealDetailsRepositoryImplementation getInstance(ConnetionRemoteDataSource connetionRemoteDataSource) {
        if (repository == null) {
            repository = new MealDetailsRepositoryImplementation(connetionRemoteDataSource);
        }
        return repository;
    }

    @Override
    public Flowable<List<MealDetails>> getStoredMealDetails() {
        return null;
    }

    /*
        public static AllCountryRepositoryImplementation getInstance(ConnetionRemoteDataSource connetionRemoteDataSource, CountryLocalDataSource countryLocalDataSource) {
            if (repository == null) {
                repository = new AllCountryRepositoryImplementation(connetionRemoteDataSource, countryLocalDataSource);
            }
            return repository;
        }

        */
/*
    @Override
    public Flowable<List<AllCountry>> getStoredProducts() {
        return countryLocalDataSource.getAllStoredProducts();
    }
*/
    @Override
    public Observable<MealDetailsResponse> getAllMealDetails(String mealDetail) {
        return connetionRemoteDataSource.makeNetworkCallBackMealDetails(mealDetail);
    }

    @Override
    public Completable insertMealDetails(MealDetails mealDetail) {
        return null;
    }

    @Override
    public Completable deleteMealDetails(MealDetails mealDetail) {
        return null;
    }


}
