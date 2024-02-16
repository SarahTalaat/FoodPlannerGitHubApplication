
package com.example.foodplanner.CountryMeals.CountryMeals_Presenter;

import android.util.Log;

import com.example.foodplanner.CountryMeals.CountryMeals_Model.CountryMeals;
import com.example.foodplanner.CountryMeals.CountryMeals_View.CountryMealsViewInterface;
import com.example.foodplanner.CountryMeals.CountryMeals_Model.CountryMealsRepositoryImplementation;
import com.example.foodplanner.CountryMeals.CountryMeals_Model.CountryMealsResponse;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class CountryMealsPresenterImplementation implements CountryMealsPresenterInterface {
    CountryMealsRepositoryImplementation repositoryImplementation;
    CountryMealsViewInterface viewInterface;
    //bygeb el data men el network
    public CountryMealsPresenterImplementation(CountryMealsViewInterface allProductsActivity, CountryMealsRepositoryImplementation instance) {
        this.repositoryImplementation = instance;
        this.viewInterface = allProductsActivity;
        Log.i("X", "AllCountryMeals presenter constructor ");
    }


    ////////////////////////////////
    //All product Pesenter interface imp
    @Override
    public void getAllCountryMeals(String countryMeal) {
        Observable<CountryMealsResponse> observable = repositoryImplementation.getAllCountryMeals(countryMeal);
        observable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<CountryMealsResponse>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull CountryMealsResponse countryMealsResponse) {
                viewInterface.showDataCountryMeals(countryMealsResponse.meals);

            }

            @Override
            public void onError(@NonNull Throwable e) {
                viewInterface.showErrorMsgCountryMeals("Error");
            }

            @Override
            public void onComplete() {

            }
        });

    }

    //All country Pesenter interface imp
    @Override
    public void addToFavouriteCountryMeals(CountryMeals countryMeals) {
        Completable completable = repositoryImplementation.insertCountryMeals(countryMeals);
        completable.observeOn(AndroidSchedulers.mainThread()).subscribe(() -> {
            viewInterface.showErrorMsgCountryMeals("CountryMeals added to favourites successfully");
        },error -> {
            viewInterface.showErrorMsgCountryMeals("Error adding countryMeals to favourites");
        });
    }
}

