
package com.example.foodplanner.CategoryMeals.CategoryMeals_View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.foodplanner.AllCategory.AllCategory_View.AllCategoryAdapter;

import com.example.foodplanner.CategoryMeals.CategoryMeals_Model.CategoryMeals;
import com.example.foodplanner.Network.ConnetionRemoteDataSourceImplementation;
import com.example.foodplanner.R;
import com.example.foodplanner.CategoryMeals.CategoryMeals_Presenter.CategoryMealsPresenterImplementation;
import com.example.foodplanner.CategoryMeals.CategoryMeals_Presenter.CategoryMealsPresenterInterface;
import com.example.foodplanner.CategoryMeals.CategoryMeals_Model.CategoryMealsRepositoryImplementation;


import java.util.ArrayList;


public class CategoryMeals_RecyclerView_Fragment extends Fragment implements CategoryMealsViewInterface, OnCategoryMealsClickListener{


    String value;
    RecyclerView allRecycler;
    AllCategoryAdapter categoryAdapter;
    ImageView imgHolder;
    TextView titleValue;
    TextView descriptionValue;
    TextView priceValue;
    TextView brandValue;
    RatingBar ratingValue;
    RecyclerView.LayoutManager layoutManager;

    CategoryMealsPresenterInterface allCategoryMealsPresenter;
    AllCategoryMealsAdapter allCategoryMealsAdapter;

    public CategoryMeals_RecyclerView_Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categorymeals_recycler_view, container, false);
        Log.i("X", "AllCategoryMeals Adapter after       ");

        allRecycler = view.findViewById(R.id.rv_categoryMeals);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        allRecycler.setLayoutManager(layoutManager);


        Log.i("X", "AllCategoryMeals Adapter after allRecycler.setLayoutManager(layoutManager);");

        //    allProductsPresenter = new AllAllCategoryPresenterImplementation(this, AllCategoryRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance(),
        //            CategoryLocalDataSourceImplementation.getInstance(getContext())));

        allCategoryMealsPresenter = new CategoryMealsPresenterImplementation(this, CategoryMealsRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance()));


        // Retrieve the Bundle from the arguments
        Bundle bundle = getArguments();

        // Check if the Bundle is not null and contains the desired key
        if (bundle != null && bundle.containsKey("category")) {
            // Retrieve the data from the Bundle
            value = bundle.getString("category");

            // Use the retrieved data as needed
            Log.d("Category Meals Fragment", "Value from Bundle: " + value);
        }

        allCategoryMealsAdapter = new AllCategoryMealsAdapter(getContext(), this);
        // Set the adapter AFTER the layout manager
        allRecycler.setAdapter(allCategoryMealsAdapter);
        allCategoryMealsPresenter.getAllCategoryMeals(value);
//

        // Inflate the layout for this fragment
        return view;
    }


    @Override
    public void onFavClickCategoryMeals(CategoryMeals categoryMeals) {
        addCategoryMeals(categoryMeals);
        //  repo.insert(category);
    }

    @Override
    public void showDataCategoryMeals(ArrayList<CategoryMeals> categoryMeals) {
        Log.i("TAG", "showDataCategoryMeals: RecyclerView_CategoryMeals: + " + categoryMeals);
        allCategoryMealsAdapter.setCategoryMealsList(categoryMeals);
        allCategoryMealsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMsgCategoryMeals(String error) {

    }

    @Override
    public void addCategoryMeals(CategoryMeals categoryMeals) {
        allCategoryMealsPresenter.addToFavouriteCategoryMeals(categoryMeals);
    }
}
