package com.example.foodplanner.CountryMeals.CountryMeals_Model;


import java.util.List;


import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public interface CountryMealsRepository {

    public Flowable<List<CountryMeals>> getStoredCountryMeals();

    public Observable<CountryMealsResponse> getAllCountryMeals(String countryMeal);

    public Completable insertCountryMeals(CountryMeals countryMeals);

    public Completable deleteCountryMeals(CountryMeals countryMeals);



}
