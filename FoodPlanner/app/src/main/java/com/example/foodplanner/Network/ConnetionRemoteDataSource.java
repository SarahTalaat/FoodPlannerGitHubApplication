package com.example.foodplanner.Network;




import com.example.foodplanner.AllCategory.AllCategory_Model.AllCategoryResponse;
import com.example.foodplanner.Chicken_Search.Chicken_Model.ChickenResponse;
import com.example.foodplanner.AllCountry.AllCountry_Model.CountryResponse;
import com.example.foodplanner.CategoryMeals.CategoryMeals_Model.CategoryMealsResponse;
import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetailsResponse;
import com.example.foodplanner.Random.Random_Model.RandomResponse;

import io.reactivex.rxjava3.core.Observable;

public interface ConnetionRemoteDataSource {
    Observable<AllCategoryResponse> makeNetworkCallBackCategory();
    Observable<RandomResponse> makeNetworkCallBackRandom();
    Observable<CountryResponse> makeNetworkCallBackCountry();
    Observable<ChickenResponse> makeNetworkCallBackChicken();
    Observable<CategoryMealsResponse> makeNetworkCallBackCategoryMeals();
    Observable<MealDetailsResponse> makeNetworkCallBackMealDetails();
}