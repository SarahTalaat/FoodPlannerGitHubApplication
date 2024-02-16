package com.example.foodplanner.CountryMeals.CountryMeals_Model;

import com.example.foodplanner.Network.ConnetionRemoteDataSource;

import java.util.List;


import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public class CountryMealsRepositoryImplementation implements CountryMealsRepository {

    private static CountryMealsRepositoryImplementation repository = null;
    ConnetionRemoteDataSource connetionRemoteDataSource; //ntwork connection and get data

    public CountryMealsRepositoryImplementation(ConnetionRemoteDataSource connetionRemoteDataSource) {
        this.connetionRemoteDataSource = connetionRemoteDataSource;
    }

    //    CountryLocalDataSource countryLocalDataSource; //insert delete getpro interface
/*
    private AllCountryRepositoryImplementation(ConnetionRemoteDataSource connetionRemoteDataSource, CountryLocalDataSource countryLocalDataSource) {
        this.connetionRemoteDataSource = connetionRemoteDataSource;
        this.countryLocalDataSource = countryLocalDataSource;
    }
*/
    public static CountryMealsRepositoryImplementation getInstance(ConnetionRemoteDataSource connetionRemoteDataSource) {
        if (repository == null) {
            repository = new CountryMealsRepositoryImplementation(connetionRemoteDataSource);
        }
        return repository;
    }

    @Override
    public Flowable<List<CountryMeals>> getStoredCountryMeals() {
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
    public Observable<CountryMealsResponse> getAllCountryMeals(String countryMeal) {
        return connetionRemoteDataSource.makeNetworkCallBackCountryMeals(countryMeal);
    }

    @Override
    public Completable insertCountryMeals(CountryMeals countryMeals) {
        return null;
    }

    @Override
    public Completable deleteCountryMeals(CountryMeals countryMeals) {
        return null;
    }


}
