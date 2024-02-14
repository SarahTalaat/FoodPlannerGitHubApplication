package com.example.foodplanner.Country_Model;

import com.example.foodplanner.Network.ConnetionRemoteDataSource;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;


public class CountryRepositoryImplementation implements CountryRepository {

    private static com.example.foodplanner.Country_Model.CountryRepositoryImplementation repository = null;
    ConnetionRemoteDataSource connetionRemoteDataSource; //ntwork connection and get data

    public CountryRepositoryImplementation(ConnetionRemoteDataSource connetionRemoteDataSource) {
        this.connetionRemoteDataSource = connetionRemoteDataSource;
    }

    //    CategoryLocalDataSource categoryLocalDataSource; //insert delete getpro interface
/*
    private CategoryRepositoryImplementation(ConnetionRemoteDataSource connetionRemoteDataSource, CategoryLocalDataSource categoryLocalDataSource) {
        this.connetionRemoteDataSource = connetionRemoteDataSource;
        this.categoryLocalDataSource = categoryLocalDataSource;
    }
*/
    public static com.example.foodplanner.Country_Model.CountryRepositoryImplementation getInstance(ConnetionRemoteDataSource connetionRemoteDataSource) {
        if (repository == null) {
            repository = new com.example.foodplanner.Country_Model.CountryRepositoryImplementation(connetionRemoteDataSource);
        }
        return repository;
    }

    @Override
    public Flowable<List<Country>> getStoredCountry() {
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
    public Observable<CountryResponse> getAllCountry() {
        return connetionRemoteDataSource.makeNetworkCallBackCountry();
    }

    @Override
    public Completable insertCountry(Country country) {
        return null;
    }

    @Override
    public Completable deleteCountry(Country country) {
        return null;
    }


}






