package com.example.foodplanner.FavouriteMealDetails.FavouriteMealDetails_View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.example.foodplanner.Database.AppDataBase;
import com.example.foodplanner.Database.MealDetailsDAO;
import com.example.foodplanner.Database.MealDetailsLocalDataSourceImpl;
import com.example.foodplanner.FavouriteMealDetails.FavouriteMealDetails_Presenter.FavMealDetailsPresenter;
import com.example.foodplanner.FavouriteMealDetails.FavouriteMealDetails_Presenter.FavMealDetailsPresenterImpl;
import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;
import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetailsRepositoryImplementation;
import com.example.foodplanner.Network.ConnetionRemoteDataSourceImplementation;
import com.example.foodplanner.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public class FavouriteMealDetails_Fragment extends Fragment  implements OnMealDetailsClickListenerDelete, FavMealDetailsView {






    TextView tv_mealName_favourite;
    ImageView img_favourite;
    TextView tv_mealCounty_favourite;
    TextView tv_instructions_favourite;
    VideoView videoView_favourite;
    Button button_removeFromFavourite;



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
 //   List<MealDetails> mealDetailsList;
    FavMealDetailsPresenterImpl favMealDetailsPresenterImplementation;
    OnMealDetailsClickListenerDelete listener;

    FavouriteMealDetailsAdapter favouriteMealDetailsAdapter;
    String[] videoSplit;
    String videoId;
    YouTubePlayerView videoView ;
    MealDetails mealDetailsObject;


    public FavouriteMealDetails_Fragment() {
        // Required empty public constructor
    }

    public FavouriteMealDetails_Fragment(OnMealDetailsClickListenerDelete listener) {
        this.listener=listener;
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
        View view = inflater.inflate(R.layout.fragment_favourites_recyclerview, container, false);


        allRecycler = view.findViewById(R.id.rv_favourite);
        layoutManager = new LinearLayoutManager(getContext());
        allRecycler.setLayoutManager(layoutManager);



/*
        listener = new OnMealDetailsClickListenerDelete() {
            @Override
            public void onDeleteClick(MealDetails mealDetails) {
                removeMealDetails(mealDetails);
                Toast.makeText(getContext(),"Remove from fav",Toast.LENGTH_SHORT).show();
            }
        };

*/

        // Set the adapter AFTER the layout manager

        favMealDetailsPresenterImplementation = new FavMealDetailsPresenterImpl(this, MealDetailsRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance(),
                MealDetailsLocalDataSourceImpl.getInstance(getContext())));
        favouriteMealDetailsAdapter = new FavouriteMealDetailsAdapter(getContext(), new ArrayList<>(), this);

        allRecycler.setAdapter(favouriteMealDetailsAdapter);

/*
        tv_mealName_favourite = view.findViewById(R.id.tv_mealName_favourite);
        tv_mealCounty_favourite = view.findViewById(R.id.tv_mealCountryName_favourite);
        tv_instructions_favourite = view.findViewById(R.id.tv_mealInstructions_favourite);
        videoView = view.findViewById(R.id.video_favourite);

        button_removeFromFavourite = view.findViewById(R.id.button_removeFromFavourite_favourite);
        img_favourite= view.findViewById(R.id.img_favourite);
*/
        //   mealDetailsList = favMealDetailsPresenter.getStoredMealDetails();
        //   showData(mealDetailsList);
      //  favMealDetailsPresenterImplementation =new FavMealDetailsPresenterImpl(this,MealDetailsRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance(), MealDetailsLocalDataSourceImpl.getInstance(getContext())));
        favMealDetailsPresenterImplementation.getFavMealDetails();

        return view;
    }

    @Override
    public void onDeleteClick(MealDetails mealDetails) {
        removeMealDetails(mealDetails);
    }

    @Override
    public void showData(List<MealDetails> mealDetails) {
     /*
        mealDetails.observe(this, new Observer<List<MealDetails>>() {
            @Override
            public void onChanged(List<MealDetails> mealDetails) {
                favouriteMealDetailsAdapter.setMealDetailsList(mealDetails);
            }
        });
        */
        favouriteMealDetailsAdapter.setMealDetailsList(mealDetails);
        favouriteMealDetailsAdapter.notifyDataSetChanged();
/*
        if (!mealDetails.isEmpty()) {
            receiveArrayListAndSetDataInItsPlace(mealDetails);
        }
   */
    }


/*
    public void receiveArrayListAndSetDataInItsPlace(List<MealDetails> mealDetails){
        mealDetailsObject = new MealDetails();
        mealDetailsObject=mealDetails.get(0);
        tv_mealName_favourite.setText(mealDetailsObject.getStrMeal());
        tv_mealCounty_favourite.setText(mealDetailsObject.getStrArea());
        tv_instructions_favourite.setText(mealDetailsObject.getStrInstructions());

        /*

        String imageURL= countryMealsList.get(position).getStrMealThumb();
        CountryMeals current = countryMealsList.get(position);

        holder.tv_countryMeals_mealName.setText(current.getStrMeal());


        Glide.with(context)
                .load(imageURL)
                .into(holder.img_countryMeals);
         */
    /*
        String imageURL= mealDetailsObject.getStrMealThumb();
        Glide.with(getContext())
                .load(imageURL)
                .into(img_favourite);

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





        button_removeFromFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //    MealDetails_CardView_Fragment mealDetailsCardViewFragment=new MealDetails_CardView_Fragment(listener);

                listener.onDeleteClick(mealDetailsObject);
            }
        });


    }

     */

    @Override
    public void removeMealDetails(MealDetails mealDetails) {
        favMealDetailsPresenter.removeFromFav(mealDetails);
        favMealDetailsPresenterImplementation.removeFromFav(mealDetails);

    }



}