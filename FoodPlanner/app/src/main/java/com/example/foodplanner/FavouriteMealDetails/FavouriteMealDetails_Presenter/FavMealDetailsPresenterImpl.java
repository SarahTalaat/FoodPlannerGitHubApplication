package com.example.foodplanner.FavouriteMealDetails.FavouriteMealDetails_Presenter;

//import androidx.lifecycle.LiveData;

import android.util.Log;

import com.example.foodplanner.FavouriteMealDetails.FavouriteMealDetails_View.FavMealDetailsView;
import com.example.foodplanner.FavouriteMealDetails.FavouriteMealDetails_View.FavouriteMealDetails_Fragment;
import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;
import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetailsRepository;
import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetailsRepositoryImplementation;
import com.example.foodplanner.R;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FavMealDetailsPresenterImpl implements FavMealDetailsPresenter {

    MealDetailsRepository repository;
    FavMealDetailsView view;

/*
    public FavMealDetailsPresenterImpl(FavouriteMealDetails_Fragment favouriteMealDetails_fragment, MealDetailsRepositoryImplementation mealDetailssRepository) {
        this.repository = mealDetailssRepository;
        this.view = favouriteMealDetails_fragment;
    }

 */
    public FavMealDetailsPresenterImpl(FavMealDetailsView favMealDetailsView, MealDetailsRepository mealDetailsRepository){
        this.view = favMealDetailsView;
        this.repository=mealDetailsRepository;
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
        repository.deleteMealDetails(mealDetails).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> view.removeMealDetails(mealDetails),
                error -> Log.i("RemoveFromFavourite", "removeFromFav: ERRORRRRR ")
        );

    }
}