package com.example.foodplanner.Plan.Plan_View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodplanner.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Plan_Fragment_RecyclerView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Plan_Fragment_RecyclerView extends Fragment {


    public Plan_Fragment_RecyclerView() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_plan_recycler_view, container, false);
    }
}