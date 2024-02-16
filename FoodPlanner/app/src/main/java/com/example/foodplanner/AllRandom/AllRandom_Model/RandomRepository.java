package com.example.foodplanner.AllRandom.AllRandom_Model;

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
