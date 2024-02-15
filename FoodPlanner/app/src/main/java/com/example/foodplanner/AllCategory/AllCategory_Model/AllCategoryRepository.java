package com.example.foodplanner.AllCategory.AllCategory_Model;


import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public interface AllCategoryRepository {
    public Flowable<List<AllCategory>> getStoredProducts();

    public Observable<AllCategoryResponse> getAllProducts();

    public Completable insertProduct(AllCategory allCategory);

    public Completable deleteProduct(AllCategory allCategory);

}