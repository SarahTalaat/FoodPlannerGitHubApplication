
package com.example.foodplanner.CountryMeals.CountryMeals_View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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

import com.example.foodplanner.CountryMeals.CountryMeals_Model.CountryMeals;
import com.example.foodplanner.MealDetails.MealDetails_View.MealDetails_CardView_Fragment;
import com.example.foodplanner.Network.ConnetionRemoteDataSourceImplementation;
import com.example.foodplanner.R;
import com.example.foodplanner.CountryMeals.CountryMeals_Presenter.CountryMealsPresenterImplementation;
import com.example.foodplanner.CountryMeals.CountryMeals_Presenter.CountryMealsPresenterInterface;
import com.example.foodplanner.CountryMeals.CountryMeals_Model.CountryMealsRepositoryImplementation;


import java.util.ArrayList;


public class CountryMeals_RecyclerView_Fragment extends Fragment implements CountryMealsViewInterface, OnCountryMealsClickListener{


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

    CountryMealsPresenterInterface allCountryMealsPresenter;
    AllCountryMealsAdapter allCountryMealsAdapter;

    public CountryMeals_RecyclerView_Fragment() {
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
        Log.i("X", "AllCountryMeals Adapter after       ");

        allRecycler = view.findViewById(R.id.rv_countrymeals);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        allRecycler.setLayoutManager(layoutManager);


        Log.i("X", "AllCountryMeals Adapter after allRecycler.setLayoutManager(layoutManager);");

        //    allProductsPresenter = new AllAllCountryPresenterImplementation(this, AllCountryRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance(),
        //            CountryLocalDataSourceImplementation.getInstance(getContext())));

        allCountryMealsPresenter = new CountryMealsPresenterImplementation(this, CountryMealsRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance()));


        // Retrieve the Bundle from the arguments
        Bundle bundle = getArguments();

        // Check if the Bundle is not null and contains the desired key
        if (bundle != null && bundle.containsKey("country")) {
            // Retrieve the data from the Bundle
            value = bundle.getString("country");

            // Use the retrieved data as needed
            Log.d("MealDetails Fragment", "Value from Bundle: " + value);
        }

        allCountryMealsAdapter = new AllCountryMealsAdapter(getContext(), this);
        // Set the adapter AFTER the layout manager
        allRecycler.setAdapter(allCountryMealsAdapter);
        allCountryMealsPresenter.getAllCountryMeals(value);
//

        // Inflate the layout for this fragment
        return view;
    }


    @Override
    public void onFavClickCountryMeals(CountryMeals countryMeals) {
        addCountryMeals(countryMeals);
        //  repo.insert(country);
    }

    @Override
    public void onCountryMealsClick(String countryMeal) {
        Bundle bundle=new Bundle();
        bundle.putString("mealDetails",countryMeal);


        // Create an instance of the receiver fragment
        MealDetails_CardView_Fragment mealDetailsCardViewFragment = new MealDetails_CardView_Fragment();

        // Set the Bundle to the receiver fragment
        mealDetailsCardViewFragment.setArguments(bundle);

        // Replace the current fragment with the countryMealsFragment
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.navigation_drawer_frame_layout, mealDetailsCardViewFragment)
                .addToBackStack(null)  // This line adds the transaction to the back stack
                .commit();


    }

    @Override
    public void showDataCountryMeals(ArrayList<CountryMeals> countryMeals) {
        Log.i("TAG", "showDataCountryMeals: RecyclerView_CountryMeals: + " + countryMeals);
        allCountryMealsAdapter.setCountryMealsList(countryMeals);
        allCountryMealsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMsgCountryMeals(String error) {

    }

    @Override
    public void addCountryMeals(CountryMeals countryMeals) {
        allCountryMealsPresenter.addToFavouriteCountryMeals(countryMeals);
    }
}
