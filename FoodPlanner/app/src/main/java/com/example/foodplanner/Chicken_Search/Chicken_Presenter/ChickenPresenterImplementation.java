
package com.example.foodplanner.Chicken_Search.Chicken_Presenter;

import android.util.Log;

import com.example.foodplanner.Chicken_Search.Chicken_View.ChickenViewInterface;
import com.example.foodplanner.Chicken_Search.Chicken_Model.Chicken;
//import com.example.foodplanner.Chicken_Model.ChickenRepositoryImplementation;
import com.example.foodplanner.Chicken_Search.Chicken_Model.ChickenRepositoryImplementation;
import com.example.foodplanner.Chicken_Search.Chicken_Model.ChickenResponse;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class ChickenPresenterImplementation implements ChickenPresenterInterface{
    ChickenRepositoryImplementation repositoryImplementation;
    ChickenViewInterface viewInterface;
    //bygeb el data men el network
    public ChickenPresenterImplementation(ChickenViewInterface allProductsActivity, ChickenRepositoryImplementation instance) {
        this.repositoryImplementation = instance;
        this.viewInterface = allProductsActivity;
        Log.i("X", "AllChicken presenter constructor ");
    }



    //All product Pesenter interface imp
    @Override
    public Observable<ChickenResponse> getAllChicken() {
        Observable<ChickenResponse> observable = repositoryImplementation.getAllChicken();
        observable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ChickenResponse>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull ChickenResponse chickenResponse) {
                viewInterface.showDataChicken(chickenResponse.meals);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                viewInterface.showErrorMsgChicken("Error");
            }

            @Override
            public void onComplete() {

            }
        });

        return observable;
    }

    //All category Pesenter interface imp
    @Override
    public void addToFavouriteChicken(Chicken chicken) {
        Completable completable = repositoryImplementation.insertChicken(chicken);
        completable.observeOn(AndroidSchedulers.mainThread()).subscribe(() -> {
            viewInterface.showErrorMsgChicken("Chicken added to favourites successfully");
        },error -> {
            viewInterface.showErrorMsgChicken("Error adding chicken to favourites");
        });
    }
}

