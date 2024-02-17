
package com.example.foodplanner.MealDetails.MealDetails_View;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.VideoView;

//import com.example.foodplanner.AllMealDetails.AllMealDetails_View.AllMealDetailsAdapter;
import com.bumptech.glide.Glide;
import com.example.foodplanner.CountryMeals.CountryMeals_View.CountryMeals_RecyclerView_Fragment;
import com.example.foodplanner.Ingredients_RecyclerView_Fragment;

import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;
import com.example.foodplanner.Network.ConnetionRemoteDataSourceImplementation;
import com.example.foodplanner.R;
import com.example.foodplanner.MealDetails.MealDetails_Presenter.MealDetailsPresenterImplementation;
import com.example.foodplanner.MealDetails.MealDetails_Presenter.MealDetailsPresenterInterface;
import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetailsRepositoryImplementation;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;


import java.util.ArrayList;
import java.util.List;


public class MealDetails_CardView_Fragment extends Fragment implements MealDetailsViewInterface, OnMealDetailsClickListener{
    ArrayList<MealDetails> mealDetailsArrayList = new ArrayList<>();
    TextView tv_mealName_mealDetails;
    ImageView img_mealDetails;
    TextView tv_mealCounty_mealDetails;
    TextView tv_instructions_mealDetails;
    VideoView videoView_mealDetails;

    Button button_addToFavourite;
    Button button_removeFromFavourite;
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

    String[] videoSplit;
    String videoId;
    YouTubePlayerView videoView ;



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

        allRecycler = view.findViewById(R.id.fragmentContainerView_ingredients_mealDetails);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        allRecycler.setLayoutManager(layoutManager);


        Log.i("X", "AllMealDetails Adapter after allRecycler.setLayoutManager(layoutManager);");

        //    allProductsPresenter = new AllAllMealDetailsPresenterImplementation(this, AllMealDetailsRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance(),
        //            MealDetailsLocalDataSourceImplementation.getInstance(getContext())));

        allMealDetailsPresenter = new MealDetailsPresenterImplementation(this, MealDetailsRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance()));


        tv_mealName_mealDetails = view.findViewById(R.id.tv_mealName_mealDetails);
        img_mealDetails = view.findViewById(R.id.img_mealDetails);
        tv_mealCounty_mealDetails = view.findViewById(R.id.tv_mealCountryName_mealDetails);
        tv_instructions_mealDetails = view.findViewById(R.id.tv_mealInstructions_mealDetails);
        videoView = view.findViewById(R.id.video_mealDetails);

        button_addToFavourite = view.findViewById(R.id.button_addToFavourite_mealDetails);
        button_removeFromFavourite = view.findViewById(R.id.button_removeFromFavourite_mealDetails);
        img_mealDetails= view.findViewById(R.id.img_mealDetails);

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
        allRecycler.setAdapter(allMealDetailsAdapter);
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
    public void showDataMealDetails(List<MealDetails> mealDetails) {
        Log.i("KKKK", "showDataMealDetails: RecyclerView_MealDetails: + " + mealDetails);
        allMealDetailsAdapter.setMealDetailsList(mealDetails);
        mealDetailsArrayList.addAll(mealDetails);
        allMealDetailsAdapter.notifyDataSetChanged();
        if (!mealDetails.isEmpty()) {
            receiveArrayListAndSetDataInItsPlace(mealDetails);
        }
    }

    public void receiveArrayListAndSetDataInItsPlace(List<MealDetails> mealDetails){
        MealDetails mealDetailsObject = new MealDetails();
        mealDetailsObject=mealDetails.get(0);
        tv_mealName_mealDetails.setText(mealDetailsObject.getStrMeal());
        tv_mealCounty_mealDetails.setText(mealDetailsObject.getStrArea());
        tv_instructions_mealDetails.setText(mealDetailsObject.getStrInstructions());

        /*

        String imageURL= countryMealsList.get(position).getStrMealThumb();
        CountryMeals current = countryMealsList.get(position);

        holder.tv_countryMeals_mealName.setText(current.getStrMeal());


        Glide.with(context)
                .load(imageURL)
                .into(holder.img_countryMeals);
         */
        String imageURL= mealDetailsObject.getStrMealThumb();
        Glide.with(getContext())
                .load(imageURL)
                .into(img_mealDetails);

        // YouTube video link
        //String youtubeLink = mealDetailsObject.getStrYoutube();




        if(!mealDetailsObject.getStrYoutube().equals(""))
        {
            videoSplit =mealDetailsObject.getStrYoutube().split("=");
            videoId =videoSplit[1];
        }else{
            videoId =" ";
        }

        getLifecycle().addObserver(videoView);

        videoView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {

                youTubePlayer.loadVideo(videoId, 0);
            }
        });





    }





    @Override
    public void showErrorMsgMealDetails(String error) {

    }

    @Override
    public void addMealDetails(MealDetails mealDetails) {
        allMealDetailsPresenter.addToFavouriteMealDetails(mealDetails);
    }
/*
    @Override
    public void onMealDetailsClick(String countryMeal) {
        Bundle bundle=new Bundle();
        bundle.putString("mealDetails",countryMeal);


        // Create an instance of the receiver fragment
        Ingredients_RecyclerView_Fragment ingredients_RecyclerView_Fragment = new Ingredients_RecyclerView_Fragment();

        // Set the Bundle to the receiver fragment
        ingredients_RecyclerView_Fragment.setArguments(bundle);

        // Replace the current fragment with the countryMealsFragment
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.navigation_drawer_frame_layout, ingredients_RecyclerView_Fragment)
                .addToBackStack(null)  // This line adds the transaction to the back stack
                .commit();
    }
    */

}
