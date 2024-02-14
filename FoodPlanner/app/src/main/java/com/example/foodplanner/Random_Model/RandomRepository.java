package com.example.foodplanner.Random_Model;

import com.example.foodplanner.Category_Model.Category;
import com.example.foodplanner.Category_Model.CategoryResponse;

import java.util.List;


import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public interface RandomRepository {

    public Flowable<List<Random>> getStoredRandom();

    public Observable<RandomResponse> getAllRandom();

    public Completable insertRandom(Random random);

    public Completable deleteRandom(Random random);



}
