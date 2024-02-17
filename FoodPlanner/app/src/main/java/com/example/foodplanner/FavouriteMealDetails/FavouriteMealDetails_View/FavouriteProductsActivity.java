/*
package com.example.foodplanner.FavouriteMealDetails.FavouriteMealDetails_View;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.productappmvp.FavouriteProducts.View.OnProductClickListenerDelete;
import com.example.productappmvp.FavouriteProducts.presenter.FavProductsPresenter;
import com.example.productappmvp.FavouriteProducts.presenter.FavProductsPresenterImpl;
import com.example.productappmvp.Model.Product;
import com.example.productappmvp.Model.ProductRepositoryImplementation;
import com.example.productappmvp.Network.ProductsRemoteDataSourceImplementation;
import com.example.productappmvp.R;
import com.example.productappmvp.db.ProductDAO;
import com.example.productappmvp.db.ProductDatabase;
import com.example.productappmvp.db.ProductsLocalDataSourceImplementation;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Flowable;


public class FavouriteProductsActivity extends AppCompatActivity implements OnProductClickListenerDelete , FavProductView {


    Flowable<List<Product>> productList;
    ProductDAO productDAO;
    RecyclerView allRecycler;

    ImageView imgHolder;
    TextView titleValue;
    TextView descriptionValue;
    TextView priceValue;
    TextView brandValue;
    RatingBar ratingValue;
    RecyclerView.LayoutManager layoutManager;
    ProductDatabase productDatabase;
    FavProductsPresenter favProductsPresenter;
    List<Product> productsList;
    FavProductsPresenterImpl favProductsPresenterImplementatin;


    FavouriteProductAdapter favouriteProductAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_products);

        allRecycler = findViewById(R.id.rv_Favourite);
        layoutManager = new LinearLayoutManager(this);
        allRecycler.setLayoutManager(layoutManager);


        favouriteProductAdapter = new FavouriteProductAdapter(this, new ArrayList<>(), this);
        // Set the adapter AFTER the layout manager
        allRecycler.setAdapter(favouriteProductAdapter);
        favProductsPresenter = new FavProductsPresenterImpl(this, ProductRepositoryImplementation.getInstance(ProductsRemoteDataSourceImplementation.getInstance(),
                ProductsLocalDataSourceImplementation.getInstance(this)));

     //   productsList = favProductsPresenter.getStoredProducts();
     //   showData(productsList);
        favProductsPresenterImplementatin=new FavProductsPresenterImpl(this,ProductRepositoryImplementation.getInstance(ProductsRemoteDataSourceImplementation.getInstance(), ProductsLocalDataSourceImplementation.getInstance(this)));
        favProductsPresenterImplementatin.getFavProducts();
    }

    @Override
    public void onDeleteClick(Product product) {
        removeProduct(product);
    }

    @Override
    public void showData(List<Product> products) {
     /*
        products.observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                favouriteProductAdapter.setProductList(products);
            }
        });
        */
/*
        favouriteProductAdapter.setProductList(products);

    }

    @Override
    public void removeProduct(Product product) {
        favProductsPresenter.removeFromFav(product);
    }
}
*/