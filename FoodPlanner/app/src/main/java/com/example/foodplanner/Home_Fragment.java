package com.example.foodplanner;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodplanner.Category.Category_View.Category_RecyclerView_Fragment;
import com.example.foodplanner.Random.Random_View.Random_RecyclerView_Fragment;


public class Home_Fragment extends Fragment {

    Category_RecyclerView_Fragment categoryRecyclerViewFragment;
    Random_RecyclerView_Fragment randomRecyclerViewFragment;

    public Home_Fragment() {
        // Required empty public constructor
        categoryRecyclerViewFragment = new Category_RecyclerView_Fragment();
        randomRecyclerViewFragment = new Random_RecyclerView_Fragment();

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}