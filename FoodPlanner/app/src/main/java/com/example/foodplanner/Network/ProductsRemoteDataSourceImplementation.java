package com.example.foodplanner.Network;


import android.util.Log;

import com.example.foodplanner.Model_Category.CategoryResponse;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.internal.schedulers.SchedulerWhen;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductsRemoteDataSourceImplementation implements ProductsRemoteDataSource {
    private static final String TAG = "retrofit";
    private static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";

    private ProductService productService;

    private static ProductsRemoteDataSourceImplementation client = null;

    private ProductsRemoteDataSourceImplementation() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        productService = retrofit.create(ProductService.class);
    }

    public static ProductsRemoteDataSourceImplementation getInstance() {
        if (client == null) {
            client = new ProductsRemoteDataSourceImplementation();
        }
        return client;
    }
/*
    @Override
    public void makeNetworkCallBack(NetworkCallBack networkCallback) {

        productService.getProducts().enqueue(new Callback<CategoryResponse>() {
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


    public Observable<CategoryResponse> makeNetworkCallBack(){
        Observable<CategoryResponse> observable = productService.getProducts().subscribeOn(Schedulers.io());
        return observable;
    }







}