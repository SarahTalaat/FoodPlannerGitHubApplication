package com.example.foodplanner.Network;




import com.example.foodplanner.Category_Model.CategoryResponse;
import com.example.foodplanner.Country_Model.CountryResponse;
import com.example.foodplanner.Random_Model.RandomResponse;

import io.reactivex.rxjava3.core.Observable;

public interface ConnetionRemoteDataSource {
    Observable<CategoryResponse> makeNetworkCallBackCategory();
    Observable<RandomResponse> makeNetworkCallBackRandom();

    Observable<CountryResponse> makeNetworkCallBackCountry();
}