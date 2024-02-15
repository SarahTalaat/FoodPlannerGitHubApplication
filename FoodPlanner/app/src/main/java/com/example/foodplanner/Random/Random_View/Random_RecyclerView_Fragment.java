
package com.example.foodplanner.Random.Random_View;

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
import com.example.foodplanner.Random.Random_Presenter.RandomPresenterImplementation;
import com.example.foodplanner.Random.Random_Presenter.RandomPresenterInterface;
import com.example.foodplanner.Random_Model.Random;
import com.example.foodplanner.Random_Model.RandomRepositoryImplementation;


import java.util.ArrayList;


public class Random_RecyclerView_Fragment extends Fragment implements RandomViewInterface, OnRandomClickListener{



    RecyclerView allRecycler;
    AllCategoryAdapter categoryAdapter;
    ImageView imgHolder;
    TextView titleValue;
    TextView descriptionValue;
    TextView priceValue;
    TextView brandValue;
    RatingBar ratingValue;
    RecyclerView.LayoutManager layoutManager;

    RandomPresenterInterface allRandomPresenter;
    AllRandomAdapter allRandomAdapter;

    public Random_RecyclerView_Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_random_recycler_view, container, false);
        Log.i("X", "AllRandom Adapter after       ");

        allRecycler = view.findViewById(R.id.rv_random);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        allRecycler.setLayoutManager(layoutManager);


        Log.i("X", "AllRandom Adapter after allRecycler.setLayoutManager(layoutManager);");

        //    allProductsPresenter = new CategoryPresenterImplementation(this, CategoryRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance(),
        //            CategoryLocalDataSourceImplementation.getInstance(getContext())));

        allRandomPresenter = new RandomPresenterImplementation(this, RandomRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance()));


        allRandomAdapter = new AllRandomAdapter(getContext(), this);
        // Set the adapter AFTER the layout manager
        allRecycler.setAdapter(allRandomAdapter);
        allRandomPresenter.getAllRandom();


        // Inflate the layout for this fragment
        return view;
    }


    @Override
    public void onFavClickRandom(Random random) {
        addRandom(random);
        //  repo.insert(category);
    }

    @Override
    public void showDataRandom(ArrayList<Random> random) {
        Log.i("TAG", "showDataRandom: RecyclerView_Random: + " + random);
        allRandomAdapter.setRandomList(random);
        allRandomAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMsgRandom(String error) {

    }

    @Override
    public void addRandom(Random random) {
        allRandomPresenter.addToFavouriteRandom(random);
    }
}
