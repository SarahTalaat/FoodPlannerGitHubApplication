
package com.example.foodplanner.MealDetails.MealDetails_View;

import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodplanner.R;

import java.util.ArrayList;


public class AllMealDetailsAdapter extends RecyclerView.Adapter<AllMealDetailsAdapter.MyViewHolder>  {


    private static final String TAG ="team";

    Context context;
    OnMealDetailsClickListener onMealDetailsClickListener;

    ArrayList<MealDetails> mealDetailsList =new ArrayList<>();
    public AllMealDetailsAdapter(Context context, OnMealDetailsClickListener onMealDetailsClickListener){
        //  this.countryList=countryList;
        this.context=context;
        this.onMealDetailsClickListener=onMealDetailsClickListener;
        Log.i("X", "AllProducts Adapter constructor ");
    }

    @NonNull
    @Override
    public AllMealDetailsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_meal_details_card_view,parent,false);
        AllMealDetailsAdapter.MyViewHolder myViewHolder = new AllMealDetailsAdapter.MyViewHolder(view);
        Log.i("X", "AllMealDetails Adapter add card view ");
        return myViewHolder;
    }


    public void setMealDetailsList(ArrayList<MealDetails> mealDetailsList) { // update
        Log.i("Y", "Al mealDetails adapter rando list: "+ mealDetailsList);
        this.mealDetailsList.addAll(mealDetailsList);
        notifyDataSetChanged();
    }



    public void onBindViewHolder(@NonNull AllMealDetailsAdapter.MyViewHolder holder , int position) {

        /*
            private int id;
    private String countryName;
    private String countryDescription;
    private String countryThumbnail;
         */


        ImageView image;

        TextView tv_mealName_mealDetails;
        TextView tv_mealCountryName_mealDetails;
        TextView tv_mealInstructions_mealDetails;
        WebView video_mealDetails;
        RecyclerView ingredients_recyclerView_mealDetails;
        Button button_addToFavourite_mealDetails;
        Button button_removeFromFavourite_mealDetails;


        Log.i("PPPPPPPPP", " lis: "+mealDetailsList);

        String imageURL= mealDetailsList.get(position).getStrMealThumb();

        MealDetails current = mealDetailsList.get(position);

        holder.tv_mealName_mealDetails.setText(current.getStrMeal());
        holder.tv_mealCountryName_mealDetails.setText(current.getStrArea());
        holder.tv_mealInstructions_mealDetails.setText(current.getStrInstructions());

        String videoUrl = mealDetailsList.get(position).getStrYoutube();
        String videoId = extractYoutubeVideoId(videoUrl);
        String youtubeVideoUrl = "https://www.youtube.com/watch?v=" + videoId;

        // Load the YouTube video
        holder.video_mealDetails.setVideoPath(youtubeVideoUrl);
        holder.video_mealDetails.start();


        Glide.with(context)
                .load(imageURL)
                .into(holder.img_mealDetails);


    }

    @Override
    public int getItemCount() {
        return mealDetailsList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{



        ImageView img_mealDetails;
        TextView tv_mealName_mealDetails;
        TextView tv_mealCountryName_mealDetails;
        TextView tv_mealInstructions_mealDetails;
        VideoView video_mealDetails;
        Button button_addToFavourite_mealDetails;
        Button button_removeFromFavourite_mealDetails;
        FragmentContainerView fragmentContainerView_ingredients_mealDetails;


        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            img_mealDetails = itemView.findViewById(R.id.img_mealDetails);
            tv_mealName_mealDetails = itemView.findViewById(R.id.tv_mealName_mealDetails);
            tv_mealCountryName_mealDetails = itemView.findViewById(R.id.tv_mealCountryName_mealDetails);
            tv_mealInstructions_mealDetails = itemView.findViewById(R.id.tv_mealInstructions_mealDetails);
            fragmentContainerView_ingredients_mealDetails = itemView.findViewById(R.id.fragmentContainerView_ingredients_mealDetails);
            video_mealDetails = itemView.findViewById(R.id.video_mealDetails);
            button_addToFavourite_mealDetails = itemView.findViewById(R.id.button_addToFavourite_mealDetails);
            button_removeFromFavourite_mealDetails=itemView.findViewById(R.id.button_removeFromFavourite_mealDetails);
        }
    }
    private String extractYoutubeVideoId(String youtubeUrl) {
        String videoId = null;
        if (youtubeUrl != null && youtubeUrl.trim().length() > 0 && youtubeUrl.startsWith("https://www.youtube.com/watch?v=")) {
            String[] parts = youtubeUrl.split("=");
            videoId = parts[1];
        }
        return videoId;
    }



}
