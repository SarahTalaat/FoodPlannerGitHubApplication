package com.example.foodplanner.Chicken_Model;

import com.example.foodplanner.Chicken_Model.Chicken;
import com.example.foodplanner.Chicken_Model.ChickenResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public interface ChickenRepository {


    public Flowable<List<Chicken>> getStoredChicken();

    public Observable<ChickenResponse> getAllChicken();

    public Completable insertChicken(Chicken chicken);

    public Completable deleteChicken(Chicken chicken);



}
