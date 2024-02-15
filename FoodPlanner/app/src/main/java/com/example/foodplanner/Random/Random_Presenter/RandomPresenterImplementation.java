
package com.example.foodplanner.Random.Random_Presenter;

import android.util.Log;

import com.example.foodplanner.Random.Random_View.RandomViewInterface;
import com.example.foodplanner.Random.Random_Model.Random;
import com.example.foodplanner.Random.Random_Model.RandomRepositoryImplementation;
import com.example.foodplanner.Random.Random_Model.RandomResponse;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class RandomPresenterImplementation implements RandomPresenterInterface{
    RandomRepositoryImplementation repositoryImplementation;
    RandomViewInterface viewInterface;
    //bygeb el data men el network
    public RandomPresenterImplementation(RandomViewInterface allProductsActivity, RandomRepositoryImplementation instance) {
        this.repositoryImplementation = instance;
        this.viewInterface = allProductsActivity;
        Log.i("X", "AllRandom presenter constructor ");
    }



    //All product Pesenter interface imp
    @Override
    public void getAllRandom() {
        Observable<RandomResponse> observable = repositoryImplementation.getAllRandom();
        observable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<RandomResponse>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull RandomResponse randomResponse) {
                viewInterface.showDataRandom(randomResponse.meals);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                viewInterface.showErrorMsgRandom("Error");
            }

            @Override
            public void onComplete() {

            }
        });

    }

    //All category Pesenter interface imp
    @Override
    public void addToFavouriteRandom(Random random) {
        Completable completable = repositoryImplementation.insertRandom(random);
        completable.observeOn(AndroidSchedulers.mainThread()).subscribe(() -> {
            viewInterface.showErrorMsgRandom("Random added to favourites successfully");
        },error -> {
            viewInterface.showErrorMsgRandom("Error adding random to favourites");
        });
    }
}

