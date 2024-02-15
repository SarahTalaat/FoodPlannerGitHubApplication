package com.example.foodplanner.Fish_Model;


import java.util.List;


import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public interface FishRepository {

    public Flowable<List<Fish>> getStoredFish();

    public Observable<FishResponse> getAllFish();

    public Completable insertFish(Fish fish);

    public Completable deleteFish(Fish fish);



}
