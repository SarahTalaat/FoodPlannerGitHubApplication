package com.example.foodplanner.AllCountry.AllCountry_Model;



import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public interface CountryRepository {


    public Flowable<List<Country>> getStoredCountry();

    public Observable<CountryResponse> getAllCountry();

    public Completable insertCountry(Country random);

    public Completable deleteCountry(Country random);
    
    
}
