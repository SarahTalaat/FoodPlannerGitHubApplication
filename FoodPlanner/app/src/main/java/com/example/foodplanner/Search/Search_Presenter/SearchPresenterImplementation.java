package com.example.foodplanner.Search.Search_Presenter;

import android.annotation.SuppressLint;
import android.content.Context;

import com.example.foodplanner.Network.ConnetionRemoteDataSource;
import com.example.foodplanner.Network.ConnetionRemoteDataSourceImplementation;
import com.example.foodplanner.Search.Search_Model.SearchRepository;
import com.example.foodplanner.Search.Search_Model.SearchRepositoryImplementation;
import com.example.foodplanner.Search.Search_View.SearchViewInterface;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SearchPresenterImplementation implements SearchPresenterInterface{

    SearchRepository searchRepository;
    SearchViewInterface searchViewInterface;


    public SearchPresenterImplementation(SearchViewInterface searchViewInterface){
        ConnetionRemoteDataSource connetionRemoteDataSource = ConnetionRemoteDataSourceImplementation.getInstance();
        searchRepository = SearchRepositoryImplementation.getInstance(connetionRemoteDataSource);
        this.searchViewInterface=searchViewInterface; //we have the ui that we will show the data on
    }



    @Override
    public void getCategories() {
        searchRepository.getCategories() // subscribe = ana 5las 7t3ml m3 el observable dah
        .observeOn(AndroidSchedulers.mainThread()).subscribe(
                item -> searchViewInterface.showCategories(item.categories),
                error -> searchViewInterface.showMessage(error.getMessage())
        );
    }

    @SuppressLint("CheckResult")
    @Override
    public void getIngredients() {
        searchRepository.getIngredients() // subscribe = ana 5las 7t3ml m3 el observable dah
               .observeOn(AndroidSchedulers.mainThread()).subscribe(
                        item -> searchViewInterface.showIngredient(item.getAllIngredients()),
                        error -> searchViewInterface.showMessage(error.getMessage())
                );
    }

    @Override
    public void getCountries() {
        searchRepository.getCountries() // subscribe = ana 5las 7t3ml m3 el observable dah
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                        item -> searchViewInterface.showCountries(item.meals),
                        error -> searchViewInterface.showMessage(error.getMessage())
                );
    }

    @Override
    public void getCategoriesMeals(String categoryMeal) {
        searchRepository.getCategoriesMeals(categoryMeal) // subscribe = ana 5las 7t3ml m3 el observable dah
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                        item -> searchViewInterface.showCategoriesMeals(item.meals),
                        error -> searchViewInterface.showMessage(error.getMessage())
                );
    }

    @Override
    public void getIngredientsMeals(String ingredientMeal) {
        searchRepository.getIngredientsMeals(ingredientMeal) // subscribe = ana 5las 7t3ml m3 el observable dah
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                        item -> searchViewInterface.showMeals(item.meals),
                        error -> searchViewInterface.showMessage(error.getMessage())
                );
    }

    @Override
    public void getCountriesMeals(String countriesMeal) {
        searchRepository.getCountriesMeals(countriesMeal) // subscribe = ana 5las 7t3ml m3 el observable dah
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                        item -> searchViewInterface.showCountriesMeals(item.meals),
                        error -> searchViewInterface.showMessage(error.getMessage())
                );
    }

    @Override
    public void getMealsByName(String mealName) {
        searchRepository.getMealsByName(mealName) // subscribe = ana 5las 7t3ml m3 el observable dah
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                        item -> searchViewInterface.showMeals(item.meals),
                        error -> searchViewInterface.showMessage(error.getMessage())
                );
    }
}
