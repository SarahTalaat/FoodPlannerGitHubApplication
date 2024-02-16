
package com.example.foodplanner.MealDetails.MealDetails_View;

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

import com.example.foodplanner.Network.ConnetionRemoteDataSourceImplementation;
import com.example.foodplanner.R;
import com.example.foodplanner.MealDetails.MealDetails_Presenter.MealDetailsPresenterImplementation;
import com.example.foodplanner.MealDetails.MealDetails_Presenter.MealDetailsPresenterInterface;
import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;
import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetailsRepositoryImplementation;


import java.util.ArrayList;


public class MealDetails_RecyclerView_Fragment extends Fragment implements MealDetailsViewInterface, OnMealDetailsClickListener{



    RecyclerView allRecycler;
    AllCategoryAdapter categoryAdapter;
    ImageView imgHolder;
    TextView titleValue;
    TextView descriptionValue;
    TextView priceValue;
    TextView brandValue;
    RatingBar ratingValue;
    RecyclerView.LayoutManager layoutManager;

    MealDetailsPresenterInterface allMealDetailsPresenter;
    AllMealDetailsAdapter allMealDetailsAdapter;

    public MealDetails_RecyclerView_Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mealdetails_recycler_view, container, false);
        Log.i("X", "AllMealDetails Adapter after       ");

        allRecycler = view.findViewById(R.id.rv_mealDetails);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        allRecycler.setLayoutManager(layoutManager);


        Log.i("X", "AllMealDetails Adapter after allRecycler.setLayoutManager(layoutManager);");

        //    allProductsPresenter = new AllAllCategoryPresenterImplementation(this, AllCategoryRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance(),
        //            CategoryLocalDataSourceImplementation.getInstance(getContext())));

        allMealDetailsPresenter = new MealDetailsPresenterImplementation(this, MealDetailsRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance()));


        allMealDetailsAdapter = new AllMealDetailsAdapter(getContext(), this);
        // Set the adapter AFTER the layout manager
        allRecycler.setAdapter(allMealDetailsAdapter);
        allMealDetailsPresenter.getAllMealDetails();


        // Inflate the layout for this fragment
        return view;
    }


    public void MealDetails_RecyclerView_Fragment(MealDetails mealDetails) {
        addMealDetails(mealDetails);
        //  repo.insert(category);
    }

    @Override
    public void showDataMealDetails(ArrayList<MealDetails> mealDetails) {
        Log.i("TAG", "showDataMealDetails: RecyclerView_MealDetails: + " + mealDetails);
        allMealDetailsAdapter.setMealDetailsList(mealDetails);
        allMealDetailsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMsgMealDetails(String error) {

    }

    @Override
    public void addMealDetails(MealDetails mealDetails) {
        allMealDetailsPresenter.addToFavouriteMealDetails(mealDetails);
    }

    @Override
    public void onFavClickMealDetails(MealDetails mealDetails) {

    }
}
