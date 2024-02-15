package com.example.foodplanner.AllCountry.AllCountry_Presenter;

import android.util.Log;

import com.example.foodplanner.AllCountry.AllCountry_View.CountryViewInterface;
import com.example.foodplanner.AllCountry.AllCountry_Model.Country;
import com.example.foodplanner.AllCountry.AllCountry_Model.CountryRepositoryImplementation;
import com.example.foodplanner.AllCountry.AllCountry_Model.CountryResponse;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

    public class CountryPresenterImplementation implements CountryPresenterInterface {
        CountryRepositoryImplementation repositoryImplementation;
        CountryViewInterface viewInterface;
        //bygeb el data men el network
        public CountryPresenterImplementation(CountryViewInterface allProductsActivity, CountryRepositoryImplementation instance) {
            this.repositoryImplementation = instance;
            this.viewInterface = allProductsActivity;
            Log.i("X", "AllCountry presenter constructor ");
        }



        //All product Pesenter interface imp
        @Override
        public void getAllCountry() {
            Observable<CountryResponse> observable = repositoryImplementation.getAllCountry();
            observable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<CountryResponse>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onNext(@NonNull CountryResponse countryResponse) {
                    viewInterface.showDataCountry(countryResponse.meals);
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    viewInterface.showErrorMsgCountry("Error");
                }

                @Override
                public void onComplete() {

                }
            });

        }

        //All category Pesenter interface imp
        @Override
        public void addToFavouriteCountry(Country country) {
            Completable completable = repositoryImplementation.insertCountry(country);
            completable.observeOn(AndroidSchedulers.mainThread()).subscribe(() -> {
                viewInterface.showErrorMsgCountry("Country added to favourites successfully");
            },error -> {
                viewInterface.showErrorMsgCountry("Error adding country to favourites");
            });
        }
    }






