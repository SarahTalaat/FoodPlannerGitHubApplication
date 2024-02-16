
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

import com.example.foodplanner.AllCountry.AllCountry_View.AllCountryAdapter;

import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;
import com.example.foodplanner.Network.ConnetionRemoteDataSourceImplementation;
import com.example.foodplanner.R;
import com.example.foodplanner.MealDetails.MealDetails_Presenter.MealDetailsPresenterImplementation;
import com.example.foodplanner.MealDetails.MealDetails_Presenter.MealDetailsPresenterInterface;
import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetailsRepositoryImplementation;


import java.util.ArrayList;


public class MealDetails_RecyclerView_Fragment extends Fragment implements MealDetailsViewInterface, OnMealDetailsClickListener{


    String value;
    RecyclerView allRecycler;
    AllCountryAdapter countryAdapter;
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
        View view = inflater.inflate(R.layout.fragment_country_meals_recycler_view, container, false);
        Log.i("X", "AllMealDetails Adapter after       ");

        allRecycler = view.findViewById(R.id.rv_countrymeals);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        allRecycler.setLayoutManager(layoutManager);
//

        Log.i("X", "AllMealDetails Adapter after allRecycler.setLayoutManager(layoutManager);");

        //    allProductsPresenter = new AllAllCountryPresenterImplementation(this, AllCountryRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance(),
        //            CountryLocalDataSourceImplementation.getInstance(getContext())));

        allMealDetailsPresenter = new MealDetailsPresenterImplementation(this, MealDetailsRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance()));


        // Retrieve the Bundle from the arguments
        Bundle bundle = getArguments();

        // Check if the Bundle is not null and contains the desired key
        if (bundle != null && bundle.containsKey("country")) {
            // Retrieve the data from the Bundle
            value = bundle.getString("country");

            // Use the retrieved data as needed
            Log.d("Country Meals Fragment", "Value from Bundle: " + value);
        }

        allMealDetailsAdapter = new AllMealDetailsAdapter(getContext(), this);
        // Set the adapter AFTER the layout manager
        allRecycler.setAdapter(allMealDetailsAdapter);
        allMealDetailsPresenter.getAllMealDetails(value);
//

        // Inflate the layout for this fragment
        return view;
    }


    @Override
    public void onFavClickMealDetails(MealDetails mealDetails) {
        addMealDetails(mealDetails);
        //  repo.insert(country);
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
}
