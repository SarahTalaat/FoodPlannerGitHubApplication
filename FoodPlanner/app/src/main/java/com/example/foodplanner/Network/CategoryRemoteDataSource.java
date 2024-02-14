package com.example.foodplanner.Network;




import com.example.foodplanner.Category_Model.CategoryResponse;

import io.reactivex.rxjava3.core.Observable;

public interface CategoryRemoteDataSource {
    Observable<CategoryResponse> makeNetworkCallBack();
}