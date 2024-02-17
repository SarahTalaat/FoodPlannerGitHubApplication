package com.example.foodplanner.FavouriteMealDetails.FavouriteMealDetails_Presenter;

//import androidx.lifecycle.LiveData;

import com.example.foodplanner.FavouriteMealDetails.FavouriteMealDetails_View.FavMealDetailsView;
import com.example.foodplanner.FavouriteMealDetails.FavouriteMealDetails_View.FavouriteMealDetailsActivity;
import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;
import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetailsRepositoryImplementation;
import com.example.foodplanner.R;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FavMealDetailsPresenterImpl implements FavMealDetailsPresenter {

    MealDetailsRepositoryImplementation repository;
    FavMealDetailsView view;

    public FavMealDetailsPresenterImpl(){

    }

    public FavMealDetailsPresenterImpl(FavouriteMealDetailsActivity favMealDetailsActivity, MealDetailsRepositoryImplementation mealDetailssRepository) {
        this.repository = mealDetailssRepository;
        this.view = favMealDetailsActivity;
    }
/*
    @Override
    public void getStoredMealDetails() {
        repository.getStoredMealDetails().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mealDetailss -> view.showData(mealDetailss));
    }
*/

    @Override
    public void getFavMealDetails() {
        repository.getStoredMealDetails().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mealDetailss -> view.showData(mealDetailss));
    }

    @Override
    public void removeFromFav(MealDetails mealDetails) {
        repository.deleteMealDetails(mealDetails);
}
}