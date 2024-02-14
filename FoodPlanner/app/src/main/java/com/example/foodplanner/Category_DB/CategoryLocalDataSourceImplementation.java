package com.example.foodplanner.Category_DB;

import android.content.Context;

import com.example.foodplanner.Category_Model.Category;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CategoryLocalDataSourceImplementation implements CategoryLocalDataSource {

    CategoryDAO productsDAO;
    static CategoryLocalDataSourceImplementation productsLocalDataSourceImpl;
    Flowable<List<Category>> storedProducts;

    private CategoryLocalDataSourceImplementation(Context context) {
        CategoryDatabase db = CategoryDatabase.getInstance(context.getApplicationContext());
        productsDAO = db.productDAO();
        storedProducts = productsDAO.getFavProducts();
    }
    public static CategoryLocalDataSourceImplementation getInstance(Context context){
        if (productsLocalDataSourceImpl == null) {
            productsLocalDataSourceImpl = new CategoryLocalDataSourceImplementation(context);
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