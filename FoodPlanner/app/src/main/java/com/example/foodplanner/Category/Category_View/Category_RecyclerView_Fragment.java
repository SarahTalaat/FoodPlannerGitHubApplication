package com.example.foodplanner.Category.Category_View;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.Category.Category_Presenter.CategoryPresenterInterface;
import com.example.foodplanner.Category_Model.Category;
import com.example.foodplanner.R;


import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.foodplanner.Category.Category_Presenter.CategoryPresenterImplementation;
import com.example.foodplanner.Category_Model.CategoryRepositoryImplementation;
import com.example.foodplanner.Network.ConnetionRemoteDataSourceImplementation;


import java.util.List;


public class Category_RecyclerView_Fragment extends Fragment implements CategoryViewInterface, OnCategoryClickListener {



    RecyclerView allRecycler;
    AllCategoryAdapter categoryAdapter;
    ImageView imgHolder;
    TextView titleValue;
    TextView descriptionValue;
    TextView priceValue;
    TextView brandValue;
    RatingBar ratingValue;
    RecyclerView.LayoutManager layoutManager;

    CategoryPresenterInterface allProductsPresenter;
    AllCategoryAdapter allProductsAdapter;

    public Category_RecyclerView_Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Log.i("X", "AllProducts Adapter after         View view = inflater.inflate(R.layout.fragment_inspirational_meal_details_recycler_view, container, false);");

        allRecycler = view.findViewById(R.id.rv_category_home);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        allRecycler.setLayoutManager(layoutManager);


        Log.i("X", "AllProducts Adapter after allRecycler.setLayoutManager(layoutManager);");

    //    allProductsPresenter = new CategoryPresenterImplementation(this, CategoryRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance(),
    //            CategoryLocalDataSourceImplementation.getInstance(getContext())));

        allProductsPresenter = new CategoryPresenterImplementation(this,CategoryRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance()));


        allProductsAdapter = new AllCategoryAdapter(getContext(), this);
        // Set the adapter AFTER the layout manager
        allRecycler.setAdapter(allProductsAdapter);
        allProductsPresenter.getAllProducts();


        // Inflate the layout for this fragment
        return view;
    }


    @Override
    public void onFavClick(Category category) {
        addProduct(category);
        //  repo.insert(category);
    }

    @Override
    public void showData(List<Category> categories) {
        allProductsAdapter.setProductList(categories);
        allProductsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMsg(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addProduct(Category category) {
        allProductsPresenter.addToFavourite(category);
    }

}