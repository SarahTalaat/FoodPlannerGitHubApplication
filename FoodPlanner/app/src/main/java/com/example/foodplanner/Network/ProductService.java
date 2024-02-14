package com.example.foodplanner.Network;




import com.example.foodplanner.Model_Category.CategoryResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService {
    @GET("categories.php")
    Observable<CategoryResponse> getProducts();

}
