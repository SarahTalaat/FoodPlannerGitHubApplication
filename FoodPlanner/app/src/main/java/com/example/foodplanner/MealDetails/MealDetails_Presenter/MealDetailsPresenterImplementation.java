
package com.example.foodplanner.MealDetails.MealDetails_Presenter;

import android.util.Log;
import android.widget.Toast;

import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;
import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetailsRepository;
import com.example.foodplanner.MealDetails.MealDetails_View.MealDetailsViewInterface;
import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetailsRepositoryImplementation;
import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetailsResponse;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class MealDetailsPresenterImplementation implements MealDetailsPresenterInterface {
    MealDetailsRepositoryImplementation repositoryImplementation;
    MealDetailsViewInterface viewInterface;
    private MealDetailsRepository mealDetailsRepository;

    private static final String TAG = "MealDetails Presenter Impl";
    private static final String DB = "DB";

    //bygeb el data men el network
    public MealDetailsPresenterImplementation(MealDetailsViewInterface allProductsActivity, MealDetailsRepositoryImplementation instance) {
        this.repositoryImplementation = instance;
        this.viewInterface = allProductsActivity;
        Log.i("X", "AllMealDetails presenter constructor ");
    }



    ////////////////////////////////
    //All product Pesenter interface imp



    @Override
    public void getAllMealDetails(String countryMeal) {
        Observable<MealDetailsResponse> observable = repositoryImplementation.getAllMealDetails(countryMeal);
        observable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<MealDetailsResponse>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull MealDetailsResponse mealDetailsResponse) {
                viewInterface.showDataMealDetails(mealDetailsResponse.getMeals());
                Log.i("onNext MealDetailsPresenterImp ", "  "+ mealDetailsResponse.getMeals());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                viewInterface.showErrorMsgMealDetails("Error MealDetailsPresenterImp");
            }

            @Override
            public void onComplete() {

            }
        });

    }

    //All country Pesenter interface imp
    @Override
    public void addToFavouriteMealDetails(MealDetails mealDetails) {
        Completable completable = repositoryImplementation.insertMealDetails(mealDetails);
        completable.observeOn(AndroidSchedulers.mainThread()).subscribe(() -> {
            viewInterface.showErrorMsgMealDetails("MealDetails added to favourites successfully");
            Log.i(DB, "addToFavouriteMealDetails: "+
                  "Meal id: " + mealDetails.getIdMeal() +
                  "Meal name: " + mealDetails.getStrMeal() +
                  "Meal Area: " + mealDetails.getStrArea() +
                  "Meal Instructions: " + mealDetails.getStrInstructions() +
                  "Meal YoutubeURL: " + mealDetails.getStrYoutube()
            );
        },error -> {
            viewInterface.showErrorMsgMealDetails("Error adding mealDetails to favourites");
        });
    }
}

