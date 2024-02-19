
package com.example.foodplanner.MealDetails.MealDetails_View;

import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodplanner.R;

import java.util.ArrayList;
import java.util.List;


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
        View view = inflater.inflate(R.layout.fragment_ingredients_card_view,parent,false);
        AllMealDetailsAdapter.MyViewHolder myViewHolder = new AllMealDetailsAdapter.MyViewHolder(view);
        Log.i("X", "AllMealDetails Adapter add card view ");
        return myViewHolder;
    }


    public void setMealDetailsList(List<MealDetails> mealDetailsList) { // update
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

        TextView mealDetails;
        Button buttonTransparentButton;
        ImageView image;


     //   String imageURL= mealDetailsList.get(position).getStrMealThumb();
     //   MealDetails current = mealDetailsList.get(position);
/*
        holder.tv_mealName_mealDetails.setText(current.getStrMeal());
        holder.tv_mealCounty_mealDetails.setText(current.getStrArea());
        holder.tv_instructions_mealDetails.setText(current.getStrInstructions());

        // Load and play the video
        String videoUrl = current.getStrYoutube();
        if (videoUrl != null && !videoUrl.isEmpty()) {
            holder.videoView_mealDetails.setVideoPath(videoUrl);
            holder.videoView_mealDetails.start();
        }


        Glide.with(context)
                .load(imageURL)
                .into(holder.img_mealDetails);


*/
    }

    @Override
    public int getItemCount() {
        return mealDetailsList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_mealName_mealDetails;
        ImageView img_mealDetails;
        TextView tv_mealCounty_mealDetails;
        TextView tv_instructions_mealDetails;
        VideoView videoView_mealDetails;
        
        Button button_addToFavourite;
        Button button_removeFromFavourite;


        public MyViewHolder(@NonNull View itemView){
            super(itemView);


            // button_favourite = itemView.findViewById(R.id.button_favourite_mealDetails);
        }
    }



}
