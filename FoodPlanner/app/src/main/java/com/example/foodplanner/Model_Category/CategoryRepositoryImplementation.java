package com.example.foodplanner.Model_Category;

import androidx.lifecycle.LiveData;

import com.example.foodplanner.Network.ProductsRemoteDataSource;
import com.example.foodplanner.db.ProductsLocalDataSource;

import java.util.List;
import com.example.foodplanner.Model_Category.CategoryResponse;
import com.example.foodplanner.Model_Category.CategoryRepositoryImplementation;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public class CategoryRepositoryImplementation implements CategoryRepository {
    private static CategoryRepositoryImplementation repository = null;
    ProductsRemoteDataSource productsRemoteDataSource; //ntwork connection and get data
    ProductsLocalDataSource productsLocalDataSource; //insert delete getpro interface

    private CategoryRepositoryImplementation(ProductsRemoteDataSource productsRemoteDataSource, ProductsLocalDataSource productsLocalDataSource) {
        this.productsRemoteDataSource = productsRemoteDataSource;
        this.productsLocalDataSource = productsLocalDataSource;
    }

    public static CategoryRepositoryImplementation getInstance(ProductsRemoteDataSource productsRemoteDataSource, ProductsLocalDataSource productsLocalDataSource) {
        if (repository == null) {
            repository = new CategoryRepositoryImplementation(productsRemoteDataSource, productsLocalDataSource);
        }
        return repository;
    }

    @Override
    public Flowable<List<Category>> getStoredProducts() {
        return productsLocalDataSource.getAllStoredProducts();
    }

    @Override
    public Observable<CategoryResponse> getAllProducts() {
        return productsRemoteDataSource.makeNetworkCallBack();
    }


    @Override
    public Completable insertProduct(Category category) {
        return productsLocalDataSource.insertProduct(category);
    }
//saroraaaaaaaaaaaa
    @Override
    public Completable deleteProduct(Category category) {
       return  productsLocalDataSource.deleteProduct(category);
}
}