package com.example.foodplanner.Network;




import com.example.foodplanner.Model_Category.CategoryResponse;

import io.reactivex.rxjava3.core.Observable;

public interface ProductsRemoteDataSource {
    Observable<CategoryResponse> makeNetworkCallBack();
}