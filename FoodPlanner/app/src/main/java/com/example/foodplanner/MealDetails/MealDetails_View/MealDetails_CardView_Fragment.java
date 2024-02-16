
package com.example.foodplanner.MealDetails.MealDetails_View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

//import com.example.foodplanner.AllMealDetails.AllMealDetails_View.AllMealDetailsAdapter;
import com.example.foodplanner.Ingredients_RecyclerView_Fragment;

import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;
import com.example.foodplanner.Network.ConnetionRemoteDataSourceImplementation;
import com.example.foodplanner.R;
import com.example.foodplanner.MealDetails.MealDetails_Presenter.MealDetailsPresenterImplementation;
import com.example.foodplanner.MealDetails.MealDetails_Presenter.MealDetailsPresenterInterface;
import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetailsRepositoryImplementation;


import java.util.ArrayList;


public class MealDetails_CardView_Fragment extends Fragment implements MealDetailsViewInterface, OnMealDetailsClickListener{


    String value;
    RecyclerView allRecycler;
    AllMealDetailsAdapter mealDetailsAdapter;
    ImageView imgHolder;
    TextView titleValue;
    TextView descriptionValue;
    TextView priceValue;
    TextView brandValue;
    RatingBar ratingValue;
    RecyclerView.LayoutManager layoutManager;

    MealDetailsPresenterInterface allMealDetailsPresenter;
    AllMealDetailsAdapter allMealDetailsAdapter;

    public MealDetails_CardView_Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meal_details_card_view, container, false);
        Log.i("X", "AllMealDetails Adapter after       ");

       // allRecycler = view.findViewById(R.id.ingredients_fragmentContainerView_mealDetails);
      //  layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
      //  allRecycler.setLayoutManager(layoutManager);

        // Create and add
        Ingredients_RecyclerView_Fragment ingredients_RecyclerView_Fragment = new Ingredients_RecyclerView_Fragment();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView_ingredients_mealDetails, ingredients_RecyclerView_Fragment)
                .commit();

        Log.i("X", "AllMealDetails Adapter after allRecycler.setLayoutManager(layoutManager);");

        //    allProductsPresenter = new AllAllMealDetailsPresenterImplementation(this, AllMealDetailsRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance(),
        //            MealDetailsLocalDataSourceImplementation.getInstance(getContext())));

        allMealDetailsPresenter = new MealDetailsPresenterImplementation(this, MealDetailsRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance()));

        // Retrieve the Bundle from the arguments
        Bundle bundle = getArguments();

        // Check if the Bundle is not null and contains the desired key
        if (bundle != null && bundle.containsKey("mealDetails")) {
            // Retrieve the data from the Bundle
            value = bundle.getString("mealDetails");

            // Use the retrieved data as needed
            Log.d("MealDetails Meals Fragment", "Value from Bundle: " + value);
        }

        allMealDetailsAdapter = new AllMealDetailsAdapter(getContext(), this);
        // Set the adapter AFTER the layout manager
      //  allRecycler.setAdapter(allMealDetailsAdapter);
        allMealDetailsPresenter.getAllMealDetails(value);
//

        // Inflate the layout for this fragment
        return view;
    }


    @Override
    public void onFavClickMealDetails(MealDetails mealDetails) {
        addMealDetails(mealDetails);
        //  repo.insert(mealDetails);
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
