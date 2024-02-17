/*
package com.example.foodplanner.FavouriteMealDetails.FavouriteMealDetails_View;
*/
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

/*
import androidx.recyclerview.widget.RecyclerView;


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


public class FavouriteMealDetailsActivity extends AppCompatActivity implements OnMealDetailsClickListenerDelete, FavMealDetailsView {


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_mealDetailss);

        allRecycler = findViewById(R.id.rv_Favourite);
        layoutManager = new LinearLayoutManager(this);
        allRecycler.setLayoutManager(layoutManager);


        favouriteMealDetailsAdapter = new FavouriteMealDetailsAdapter(this, new ArrayList<>(), this);
        // Set the adapter AFTER the layout manager
        allRecycler.setAdapter(favouriteMealDetailsAdapter);
        favMealDetailsPresenter = new FavMealDetailsPresenterImpl(this, MealDetailsRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance(),
                MealDetailsLocalDataSourceImpl.getInstance(this)));

     //   mealDetailssList = favMealDetailsPresenter.getStoredMealDetails();
     //   showData(mealDetailssList);
        favMealDetailsPresenterImplementatin=new FavMealDetailsPresenterImpl(this,MealDetailsRepositoryImplementation.getInstance(MealDetailsRemoteDataSourceImplementation.getInstance(), MealDetailsLocalDataSourceImplementation.getInstance(this)));
        favMealDetailsPresenterImplementatin.getFavMealDetails();
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
/*
        favouriteMealDetailsAdapter.setMealDetailsList(mealDetailss);

    }

    @Override
    public void removeMealDetails(MealDetails mealDetails) {
        favMealDetailsPresenter.removeFromFav(mealDetails);
    }
}
*/