package com.example.foodplanner;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.foodplanner.Category.Category_View.Category_RecyclerView_Fragment;
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

        // Get the container layout
        FrameLayout containerLayout = view.findViewById(R.id.fragmentContainer_home);

        // Create and add ChildFragment1
        Category_RecyclerView_Fragment fragment1 = new Category_RecyclerView_Fragment();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer_categoy, fragment1)
                .commit();

        // Create and add ChildFragment2
        Random_RecyclerView_Fragment fragment2 = new Random_RecyclerView_Fragment();
        getChildFragmentManager().beginTransaction()
                .add(R.id.fragmentContainer_Random, fragment2)
                .commit();

        return view;    }
}