
package com.example.foodplanner.Fish.Fish_View;

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
import com.example.foodplanner.Fish.Fish_Presenter.FishPresenterImplementation;
import com.example.foodplanner.Fish.Fish_Presenter.FishPresenterInterface;
import com.example.foodplanner.Fish_Model.Fish;
import com.example.foodplanner.Fish_Model.FishRepositoryImplementation;


import java.util.ArrayList;


public class Fish_RecyclerView_Fragment extends Fragment implements FishViewInterface, OnFishClickListener{



    RecyclerView allRecycler;
    AllCategoryAdapter categoryAdapter;
    ImageView imgHolder;
    TextView titleValue;
    TextView descriptionValue;
    TextView priceValue;
    TextView brandValue;
    RatingBar ratingValue;
    RecyclerView.LayoutManager layoutManager;

    FishPresenterInterface allFishPresenter;
    AllFishAdapter allFishAdapter;

    public Fish_RecyclerView_Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fish_recycler_view, container, false);
        Log.i("X", "AllFish Adapter after       ");

        allRecycler = view.findViewById(R.id.rv_fish);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        allRecycler.setLayoutManager(layoutManager);


        Log.i("X", "AllFish Adapter after allRecycler.setLayoutManager(layoutManager);");

        //    allProductsPresenter = new CategoryPresenterImplementation(this, CategoryRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance(),
        //            CategoryLocalDataSourceImplementation.getInstance(getContext())));

        allFishPresenter = new FishPresenterImplementation(this, FishRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance()));


        allFishAdapter = new AllFishAdapter(getContext(), this);
        // Set the adapter AFTER the layout manager
        allRecycler.setAdapter(allFishAdapter);
        allFishPresenter.getAllFish();


        // Inflate the layout for this fragment
        return view;
    }


    @Override
    public void onFavClickFish(Fish fish) {
        addFish(fish);
        //  repo.insert(category);
    }

    @Override
    public void showDataFish(ArrayList<Fish> fish) {
        Log.i("TAG", "showDataFish: RecyclerView_Fish: + " + fish);
        allFishAdapter.setFishList(fish);
        allFishAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMsgFish(String error) {

    }

    @Override
    public void addFish(Fish fish) {
        allFishPresenter.addToFavouriteFish(fish);
    }
}
