package com.example.foodplanner.AllCategory.AllCategory_Presenter;

import android.util.Log;

import com.example.foodplanner.AllCategory.AllCategory_View.AllCategoryViewInterface;
import com.example.foodplanner.AllCategory.AllCategory_Model.AllCategory;
import com.example.foodplanner.AllCategory.AllCategory_Model.AllCategoryRepositoryImplementation;
import com.example.foodplanner.AllCategory.AllCategory_Model.AllCategoryResponse;


import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;


public class AllAllCategoryPresenterImplementation implements AllCategoryPresenterInterface {
    AllCategoryRepositoryImplementation repositoryImplementation;
    AllCategoryViewInterface viewInterface;
                                                                                            //bygeb el data men el network
    public AllAllCategoryPresenterImplementation(AllCategoryViewInterface allProductsActivity, AllCategoryRepositoryImplementation instance) {
        this.repositoryImplementation = instance;
        this.viewInterface = allProductsActivity;
        Log.i("X", "AllProducts presenter constructor ");
    }



    //All product Pesenter interface imp
    @Override
    public void getAllProducts() {
        Observable<AllCategoryResponse> observable = repositoryImplementation.getAllProducts();
        observable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<AllCategoryResponse>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull AllCategoryResponse allCategoryResponse) {
                viewInterface.showData(allCategoryResponse.categories);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                viewInterface.showErrorMsg("Error");
            }

            @Override
            public void onComplete() {

            }
        });

    }

    //All allCategory Pesenter interface imp
    @Override
    public void addToFavourite(AllCategory allCategory) {
        Completable completable = repositoryImplementation.insertProduct(allCategory);
        completable.observeOn(AndroidSchedulers.mainThread()).subscribe(() -> {
            viewInterface.showErrorMsg("Categories added to favourites successfully");
        },error -> {
            viewInterface.showErrorMsg("Error adding categories to favourites");
     });
    }

    //Network
}
