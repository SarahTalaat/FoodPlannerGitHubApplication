
package com.example.foodplanner.Country.Country_View;

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

import com.example.foodplanner.Category.Category_View.AllCategoryAdapter;

import com.example.foodplanner.Network.ConnetionRemoteDataSourceImplementation;
import com.example.foodplanner.R;
import com.example.foodplanner.Country.Country_Presenter.CountryPresenterImplementation;
import com.example.foodplanner.Country.Country_Presenter.CountryPresenterInterface;
import com.example.foodplanner.Country_Model.Country;
import com.example.foodplanner.Country_Model.CountryRepositoryImplementation;


import java.util.ArrayList;


public class Country_RecyclerView_Fragment extends Fragment implements CountryViewInterface, OnCountryClickListener{



    RecyclerView allRecycler;
    AllCategoryAdapter categoryAdapter;
    ImageView imgHolder;
    TextView titleValue;
    TextView descriptionValue;
    TextView priceValue;
    TextView brandValue;
    RatingBar ratingValue;
    RecyclerView.LayoutManager layoutManager;

    CountryPresenterInterface allCountryPresenter;
    AllCountryAdapter allCountryAdapter;

    public Country_RecyclerView_Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country_recycler_view, container, false);
        Log.i("X", "AllCountry Adapter after       ");

        allRecycler = view.findViewById(R.id.rv_country);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        allRecycler.setLayoutManager(layoutManager);


        Log.i("X", "AllCountry Adapter after allRecycler.setLayoutManager(layoutManager);");

        //    allProductsPresenter = new CategoryPresenterImplementation(this, CategoryRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance(),
        //            CategoryLocalDataSourceImplementation.getInstance(getContext())));

        allCountryPresenter = new CountryPresenterImplementation(this, CountryRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance()));


        allCountryAdapter = new AllCountryAdapter(getContext(), this);
        // Set the adapter AFTER the layout manager
        allRecycler.setAdapter(allCountryAdapter);
        allCountryPresenter.getAllCountry();


        // Inflate the layout for this fragment
        return view;
    }


    @Override
    public void onFavClickCountry(Country country) {
        addCountry(country);
        //  repo.insert(category);
    }

    @Override
    public void showDataCountry(ArrayList<Country> country) {
        Log.i("TAG", "showDataCountry: RecyclerView_Country: + " + country);
        allCountryAdapter.setCountryList(country);
        allCountryAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMsgCountry(String error) {

    }

    @Override
    public void addCountry(Country country) {
        allCountryPresenter.addToFavouriteCountry(country);
    }
}
