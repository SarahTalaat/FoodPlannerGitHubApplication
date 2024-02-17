package com.example.foodplanner.FavouriteMealDetails.FavouriteMealDetails_View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.foodplanner.Database.AppDataBase;
import com.example.foodplanner.Database.MealDetailsDAO;
import com.example.foodplanner.Database.MealDetailsLocalDataSourceImpl;
import com.example.foodplanner.FavouriteMealDetails.FavouriteMealDetails_Presenter.FavMealDetailsPresenter;
import com.example.foodplanner.FavouriteMealDetails.FavouriteMealDetails_Presenter.FavMealDetailsPresenterImpl;
import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;
import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetailsRepositoryImplementation;
import com.example.foodplanner.Network.ConnetionRemoteDataSourceImplementation;
import com.example.foodplanner.R;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public class FavouriteMealDetails_Fragment extends Fragment  implements OnMealDetailsClickListenerDelete, FavMealDetailsView {

    Flowable<List<MealDetails>> mealDetailsList;
    MealDetailsDAO mealDetailsDAO;
    RecyclerView allRecycler;

    ImageView imgHolder;
    TextView titleValue;
    TextView descriptionValue;
    TextView priceValue;
    TextView brandValue;
    RatingBar ratingValue;
    RecyclerView.LayoutManager layoutManager;
    AppDataBase mealDetailsDatabase;
    FavMealDetailsPresenter favMealDetailsPresenter;
    List<MealDetails> mealDetailssList;
    FavMealDetailsPresenterImpl favMealDetailsPresenterImplementatin;


    FavouriteMealDetailsAdapter favouriteMealDetailsAdapter;

    public FavouriteMealDetails_Fragment() {
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
        View view = inflater.inflate(R.layout.fragment_favouries, container, false);


        allRecycler = view.findViewById(R.id.rv_ingredients_favourite);
        layoutManager = new LinearLayoutManager(getContext());
        allRecycler.setLayoutManager(layoutManager);


        favouriteMealDetailsAdapter = new FavouriteMealDetailsAdapter(getContext(), new ArrayList<>(), this);
        // Set the adapter AFTER the layout manager
        allRecycler.setAdapter(favouriteMealDetailsAdapter);
        favMealDetailsPresenter = new FavMealDetailsPresenterImpl(this, MealDetailsRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance(),
                MealDetailsLocalDataSourceImpl.getInstance(getContext())));

        //   mealDetailssList = favMealDetailsPresenter.getStoredMealDetails();
        //   showData(mealDetailssList);
        favMealDetailsPresenterImplementatin=new FavMealDetailsPresenterImpl(this,MealDetailsRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance(), MealDetailsLocalDataSourceImpl.getInstance(getContext())));
        favMealDetailsPresenterImplementatin.getFavMealDetails();

        return view;
    }

    @Override
    public void onDeleteClick(MealDetails mealDetails) {
        removeMealDetails(mealDetails);
    }

    @Override
    public void showData(List<MealDetails> mealDetailss) {
     /*
        mealDetailss.observe(this, new Observer<List<MealDetails>>() {
            @Override
            public void onChanged(List<MealDetails> mealDetailss) {
                favouriteMealDetailsAdapter.setMealDetailsList(mealDetailss);
            }
        });
        */
        favouriteMealDetailsAdapter.setMealDetailsList(mealDetailss);

    }

    @Override
    public void removeMealDetails(MealDetails mealDetails) {
        favMealDetailsPresenter.removeFromFav(mealDetails);
    }



}