package com.example.foodplanner.Network;




import com.example.foodplanner.Category_Model.CategoryResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface CategoryService {
    @GET("categories.php")
    Observable<CategoryResponse> getProducts();

}
