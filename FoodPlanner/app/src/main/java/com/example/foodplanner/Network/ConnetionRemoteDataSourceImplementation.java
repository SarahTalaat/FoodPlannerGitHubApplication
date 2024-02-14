package com.example.foodplanner.Network;


import com.example.foodplanner.Category_Model.CategoryResponse;
import com.example.foodplanner.Random_Model.RandomResponse;

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

        connctionService.getProducts().enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                if (response.isSuccessful()) {
                    networkCallback.onSuccessResult(response.body().categories);
                    Log.i(TAG, " on response + isSuccessful");
                }
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                Log.i(TAG, "onFauiler : " + t.getMessage());
                networkCallback.onFailureResult((t.getMessage()));
            }
        });
    }
    */


    public Observable<CategoryResponse> makeNetworkCallBackCategory(){
        Observable<CategoryResponse> observable = connctionService.getProducts().subscribeOn(Schedulers.io());
        return observable;
    }


    public Observable<RandomResponse> makeNetworkCallBackRandom(){
        Observable<RandomResponse> observable = connctionService.getProductsRandom().subscribeOn(Schedulers.io());
        return observable;
    }





}