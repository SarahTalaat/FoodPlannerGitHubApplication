package com.example.foodplanner;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodplanner.AllCategory.AllCategory_View.AllAllCategory_RecyclerView_FragmentAll;
import com.example.foodplanner.AllCountry.AllCountry_View.Country_RecyclerView_Fragment;
import com.example.foodplanner.Random.Random_View.Random_RecyclerView_Fragment;


public class Home_Fragment extends Fragment {


    public Home_Fragment() {


    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Create and add ChildFragment1
        AllAllCategory_RecyclerView_FragmentAll fragment1 = new AllAllCategory_RecyclerView_FragmentAll();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView_category, fragment1)
                .commit();


        // Create and add ChildFragment3
        Random_RecyclerView_Fragment fragment2 = new Random_RecyclerView_Fragment();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView_random, fragment2)
                .commit();

        // Create and add ChildFragment2
        Country_RecyclerView_Fragment fragment3 = new Country_RecyclerView_Fragment();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView_country, fragment3)
                .commit();






        return view;    }
}