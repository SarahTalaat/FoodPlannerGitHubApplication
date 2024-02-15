package com.example.foodplanner.Network;




import com.example.foodplanner.Category_Model.CategoryResponse;
import com.example.foodplanner.Chicken_Model.ChickenResponse;
import com.example.foodplanner.Country_Model.CountryResponse;
import com.example.foodplanner.Fish_Model.FishResponse;
import com.example.foodplanner.Pasta_Model.PastaResponse;
import com.example.foodplanner.Random_Model.RandomResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ConnctionService {
    @GET("categories.php")
    Observable<CategoryResponse> getProducts();

    @GET("random.php")
    Observable<RandomResponse> getProductsRandom();

    @GET("list.php?a=list")
    Observable<CountryResponse> getProductsCountry();

    /*
    @GET("filter.php?i=chicken_breast")
    Observable<ChickenResponse> getProductsChicken(@Query("i") String chicken);
    */

    @GET("filter.php?i=chicken_breast")
    Observable<ChickenResponse> getProductsChicken();

    @GET("filter.php?c=Seafood")
    Observable<FishResponse> getProductsFish();

    @GET("search.php?s=Arrabiata")
    Observable<PastaResponse> getProductsPasta();

}
