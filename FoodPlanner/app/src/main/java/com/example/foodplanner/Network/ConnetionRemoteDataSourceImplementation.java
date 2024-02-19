package com.example.foodplanner.Network;


import com.example.foodplanner.AllCategory.AllCategory_Model.AllCategoryResponse;
import com.example.foodplanner.Chicken_Search.Chicken_Model.ChickenResponse;
import com.example.foodplanner.AllCountry.AllCountry_Model.CountryResponse;
import com.example.foodplanner.CategoryMeals.CategoryMeals_Model.CategoryMealsResponse;
import com.example.foodplanner.CountryMeals.CountryMeals_Model.CountryMealsResponse;
import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetailsResponse;
import com.example.foodplanner.Random.Random_Model.RandomResponse;
import com.example.foodplanner.Search.Search_Model.IngredientResponse;
import com.example.foodplanner.Search.Search_Model.MealResponse;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnetionRemoteDataSourceImplementation implements ConnetionRemoteDataSource {
    private static final String TAG = "retrofit";
    private static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";

    private ConnctionService connctionService;
//
    private static ConnetionRemoteDataSourceImplementation client = null;

    private ConnetionRemoteDataSourceImplementation() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        connctionService = retrofit.create(ConnctionService.class);
    }

    public static ConnetionRemoteDataSourceImplementation getInstance() {
        if (client == null) {
            client = new ConnetionRemoteDataSourceImplementation();
        }
        return client;
    }
/*
    @Override
    public void makeNetworkCallBack(NetworkCallBack networkCallback) {

        connctionService.getProducts().enqueue(new Callback<AllCategoryResponse>() {
            @Override
            public void onResponse(Call<AllCategoryResponse> call, Response<AllCategoryResponse> response) {
                if (response.isSuccessful()) {
                    networkCallback.onSuccessResult(response.body().categories);
                    Log.i(TAG, " on response + isSuccessful");
                }
            }

            @Override
            public void onFailure(Call<AllCategoryResponse> call, Throwable t) {
                Log.i(TAG, "onFauiler : " + t.getMessage());
                networkCallback.onFailureResult((t.getMessage()));
            }
        });
    }
    */


    public Observable<AllCategoryResponse> makeNetworkCallBackCategory(){
        Observable<AllCategoryResponse> observable = connctionService.getProducts().subscribeOn(Schedulers.io());
        return observable;
    }


    public Observable<RandomResponse> makeNetworkCallBackRandom(){
        Observable<RandomResponse> observable = connctionService.getProductsRandom().subscribeOn(Schedulers.io());
        return observable;
    }

    public Observable<CountryResponse> makeNetworkCallBackCountry(){
        Observable<CountryResponse> observable = connctionService.getProductsCountry().subscribeOn(Schedulers.io());
        return observable;
    }

    public Observable<ChickenResponse> makeNetworkCallBackChicken(){
        Observable<ChickenResponse> observable = connctionService.getProductsChicken().subscribeOn(Schedulers.io());
        return observable;
    }

    public Observable<CategoryMealsResponse> makeNetworkCallBackCategoryMeals(String categoryMeal){
        Observable<CategoryMealsResponse> observable = connctionService.getProductsCategoryMeals(categoryMeal).subscribeOn(Schedulers.io());
        return observable;
    }

    public Observable<CountryMealsResponse> makeNetworkCallBackCountryMeals(String countryMeal){
        Observable<CountryMealsResponse> observable = connctionService.getProductsCountryMeals(countryMeal).subscribeOn(Schedulers.io());
        return observable;
    }


    public Observable<MealDetailsResponse> makeNetworkCallBackMealDetails(String mealDetails){
        Observable<MealDetailsResponse> observable = connctionService.getProductsMealDetails(mealDetails).subscribeOn(Schedulers.io());
        return observable;
    }

    @Override
    public Observable<IngredientResponse> makeNetworkCallBackIngredients() {
        Observable<IngredientResponse> observable = connctionService.getProductsIngredients().subscribeOn(Schedulers.io());
        return observable;
    }

    @Override
    public Observable<MealResponse> makeNetworkCallBackIngredientMeals(String ingredient) {
        Observable<MealResponse> observable = connctionService.getProductsIngredientMeals(ingredient).subscribeOn(Schedulers.io());
        return observable;
    }

    @Override
    public Observable<MealResponse> makeNetworkCallBackByName(String ingredient) {
        Observable<MealResponse> observable = connctionService.getProductsByName(ingredient).subscribeOn(Schedulers.io());
        return observable;
    }

}