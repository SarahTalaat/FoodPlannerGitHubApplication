package com.example.foodplanner.Network;




import com.example.foodplanner.Category_Model.CategoryResponse;
import com.example.foodplanner.Random_Model.RandomResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface ConnctionService {
    @GET("categories.php")
    Observable<CategoryResponse> getProducts();

    @GET("random.php")
    Observable<RandomResponse> getProductsRandom();

    @GET("list.php?a=list")
    Observable<RandomResponse> getProductsCountry();

}