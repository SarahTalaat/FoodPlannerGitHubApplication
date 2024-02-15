package com.example.foodplanner.Network;




import com.example.foodplanner.AllCategory.AllCategory_Model.AllCategoryResponse;
import com.example.foodplanner.Chicken_Search.Chicken_Model.ChickenResponse;
import com.example.foodplanner.AllCountry.AllCountry_Model.CountryResponse;
import com.example.foodplanner.CategoryMeals.CategoryMeals_Model.CategoryMealsResponse;
import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetailsResponse;
import com.example.foodplanner.Random.Random_Model.RandomResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ConnctionService {
    @GET("categories.php")
    Observable<AllCategoryResponse> getProducts();

    @GET("random.php")
    Observable<RandomResponse> getProductsRandom();

    @GET("list.php?a=list")
    Observable<CountryResponse> getProductsCountry();

    /*
    @GET("filter.php?i=chicken_breast")
    Observable<ChickenResponse> getProductsChicken(@Query("i") String chicken);
    */

    @GET("filter.php?i=chicken_breast") //ingredients //search
    Observable<ChickenResponse> getProductsChicken();

    @GET("filter.php") // category fav button
    Observable<CategoryMealsResponse> getProductsCategoryMeals(@Query("c") String categoryMeals);

    @GET("search.php?s=Arrabiata") // meal details
    Observable<MealDetailsResponse> getProductsMealDetails();
//
}
