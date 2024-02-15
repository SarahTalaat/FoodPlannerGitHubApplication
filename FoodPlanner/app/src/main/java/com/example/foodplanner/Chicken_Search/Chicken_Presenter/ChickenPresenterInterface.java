
package com.example.foodplanner.Chicken_Search.Chicken_Presenter;

import com.example.foodplanner.Chicken_Search.Chicken_Model.Chicken;
import com.example.foodplanner.Chicken_Search.Chicken_Model.ChickenResponse;

import io.reactivex.rxjava3.core.Observable;

public interface ChickenPresenterInterface {
    public Observable<ChickenResponse> getAllChicken();
    public void addToFavouriteChicken(Chicken chicken);


}
