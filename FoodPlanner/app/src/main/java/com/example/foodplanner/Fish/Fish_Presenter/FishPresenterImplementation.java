
package com.example.foodplanner.Fish.Fish_Presenter;

import android.util.Log;

import com.example.foodplanner.Category.Category_View.CategoryViewInterface;
import com.example.foodplanner.Category_Model.Category;
import com.example.foodplanner.Category_Model.CategoryRepositoryImplementation;
import com.example.foodplanner.Category_Model.CategoryResponse;
import com.example.foodplanner.Fish.Fish_View.FishViewInterface;
import com.example.foodplanner.Fish_Model.Fish;
import com.example.foodplanner.Fish_Model.FishRepositoryImplementation;
import com.example.foodplanner.Fish_Model.FishResponse;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class FishPresenterImplementation implements FishPresenterInterface{
    FishRepositoryImplementation repositoryImplementation;
    FishViewInterface viewInterface;
    //bygeb el data men el network
    public FishPresenterImplementation(FishViewInterface allProductsActivity, FishRepositoryImplementation instance) {
        this.repositoryImplementation = instance;
        this.viewInterface = allProductsActivity;
        Log.i("X", "AllFish presenter constructor ");
    }



    //All product Pesenter interface imp
    @Override
    public void getAllFish() {
        Observable<FishResponse> observable = repositoryImplementation.getAllFish();
        observable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<FishResponse>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull FishResponse fishResponse) {
                viewInterface.showDataFish(fishResponse.meals);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                viewInterface.showErrorMsgFish("Error");
            }

            @Override
            public void onComplete() {

            }
        });

    }

    //All category Pesenter interface imp
    @Override
    public void addToFavouriteFish(Fish fish) {
        Completable completable = repositoryImplementation.insertFish(fish);
        completable.observeOn(AndroidSchedulers.mainThread()).subscribe(() -> {
            viewInterface.showErrorMsgFish("Fish added to favourites successfully");
        },error -> {
            viewInterface.showErrorMsgFish("Error adding fish to favourites");
        });
    }
}

