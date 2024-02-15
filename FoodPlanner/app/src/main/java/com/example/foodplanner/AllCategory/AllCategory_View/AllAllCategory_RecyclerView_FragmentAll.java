package com.example.foodplanner.AllCategory.AllCategory_View;

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

import com.example.foodplanner.AllCategory.AllCategory_Presenter.AllCategoryPresenterInterface;
import com.example.foodplanner.AllCategory.AllCategory_Model.AllCategory;
import com.example.foodplanner.R;


import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.foodplanner.AllCategory.AllCategory_Presenter.AllAllCategoryPresenterImplementation;
import com.example.foodplanner.AllCategory.AllCategory_Model.AllCategoryRepositoryImplementation;
import com.example.foodplanner.Network.ConnetionRemoteDataSourceImplementation;


import java.util.List;


public class AllAllCategory_RecyclerView_FragmentAll extends Fragment implements AllCategoryViewInterface, AllOnCategoryClickListener {



    RecyclerView allRecycler;
    AllCategoryAdapter categoryAdapter;
    ImageView imgHolder;
    TextView titleValue;
    TextView descriptionValue;
    TextView priceValue;
    TextView brandValue;
    RatingBar ratingValue;
    RecyclerView.LayoutManager layoutManager;

    AllCategoryPresenterInterface allProductsPresenter;
    AllCategoryAdapter allProductsAdapter;

    public AllAllCategory_RecyclerView_FragmentAll() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_recycler_view_fragmet, container, false);
        Log.i("X", "AllProducts Adapter after         View view = inflater.inflate(R.layout.fragment_inspirational_meal_details_recycler_view, container, false);");

        allRecycler = view.findViewById(R.id.rv_category);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        allRecycler.setLayoutManager(layoutManager);


        Log.i("X", "AllProducts Adapter after allRecycler.setLayoutManager(layoutManager);");

    //    allProductsPresenter = new AllAllCategoryPresenterImplementation(this, AllCategoryRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance(),
    //            CategoryLocalDataSourceImplementation.getInstance(getContext())));

        allProductsPresenter = new AllAllCategoryPresenterImplementation(this, AllCategoryRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance()));
        allProductsAdapter = new AllCategoryAdapter(getContext(), this);
        // Set the adapter AFTER the layout manager
        allRecycler.setAdapter(allProductsAdapter);
        allProductsPresenter.getAllProducts();


        // Inflate the layout for this fragment
        return view;
    }


    @Override
    public void onFavClick(AllCategory allCategory) {
        addProduct(allCategory);
        //  repo.insert(allCategory);
    }

    @Override
    public void showData(List<AllCategory> categories) {
        allProductsAdapter.setProductList(categories);
        allProductsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMsg(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addProduct(AllCategory allCategory) {
        allProductsPresenter.addToFavourite(allCategory);
    }

}