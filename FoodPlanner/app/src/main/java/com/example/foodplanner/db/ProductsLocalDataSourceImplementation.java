package com.example.foodplanner.db;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.foodplanner.Model_Category.Category;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ProductsLocalDataSourceImplementation implements ProductsLocalDataSource{

    ProductDAO productsDAO;
    static ProductsLocalDataSourceImplementation productsLocalDataSourceImpl;
    Flowable<List<Category>> storedProducts;

    private ProductsLocalDataSourceImplementation(Context context) {
        ProductDatabase db = ProductDatabase.getInstance(context.getApplicationContext());
        productsDAO = db.productDAO();
        storedProducts = productsDAO.getFavProducts();
    }
    public static ProductsLocalDataSourceImplementation getInstance(Context context){
        if (productsLocalDataSourceImpl == null) {
            productsLocalDataSourceImpl = new ProductsLocalDataSourceImplementation(context);
        }
        return productsLocalDataSourceImpl;
    }

    @Override
    public Completable insertProduct(Category category) {
           return productsDAO.insert(category).subscribeOn(Schedulers.io());
    }

    @Override
    public Completable deleteProduct(Category category) {
        return productsDAO.delete(category).subscribeOn(Schedulers.io());

    }

    @Override
    public Flowable<List<Category>> getAllStoredProducts() {
        return productsDAO.getFavProducts().subscribeOn(Schedulers.io());
}
}