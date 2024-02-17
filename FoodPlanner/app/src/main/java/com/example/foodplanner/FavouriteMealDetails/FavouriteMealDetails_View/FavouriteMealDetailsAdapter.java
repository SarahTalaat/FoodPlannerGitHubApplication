package com.example.foodplanner.FavouriteMealDetails.FavouriteMealDetails_View;

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
import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;
import com.example.foodplanner.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;


import java.util.List;

public class FavouriteMealDetailsAdapter extends RecyclerView.Adapter<FavouriteMealDetailsAdapter.MyViewHolder> {
    private static final String TAG ="team";
    String[] videoSplit;
    String videoId;
    YouTubePlayerView videoView ;
    Context context;
    OnMealDetailsClickListenerDelete onMealDetailsClickListenerDelete;

    List<MealDetails> mealDetailsList;
    public FavouriteMealDetailsAdapter(Context context, List<MealDetails>  mealDetailsList, OnMealDetailsClickListenerDelete onMealDetailsClickListenerDelete){
        this.mealDetailsList=mealDetailsList;
        this.context=context;
        this.onMealDetailsClickListenerDelete = onMealDetailsClickListenerDelete;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_favourite_meal_card_view,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }


    public void setMealDetailsList(List<MealDetails> mealDetailsList) { // update
        Log.i(TAG, "setMealDetailsList: ");
      //  this.mealDetailsList.addAll(mealDetailsList);
        this.mealDetailsList=mealDetailsList;
        notifyDataSetChanged();
    }



    public void onBindViewHolder(@NonNull MyViewHolder holder , int position) {
/*
        ImageView image;
        String imageURL=mealDetailsList.get(position).getThumbnail();

        MealDetails current = mealDetailsList.get(position);
        holder.tv_title_value.setText(current.getTitle());
        holder.tv_price_value.setText(""+current.getPrice());
        holder.tv_description_value.setText(current.getDescription());
        holder.tv_brand_value.setText(current.getBrand());
        holder.rating_bar.setRating(current.getRating());
        Glide.with(context)
                .load(imageURL)
                .into(holder.img_mealDetails);
        holder.addToFavourteButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMealDetailsClickListenerDelete.onDeleteClick(current);
            }
        });
*/


        String imageURL = mealDetailsList.get(position).getStrMealThumb();
        MealDetails current = mealDetailsList.get(position);

        holder.tv_mealName_favourite.setText(current.getStrMeal());
        holder.tv_mealCounty_favourite.setText(current.getStrArea());
        holder.tv_instructions_favourite.setText(current.getStrInstructions());

        Glide.with(context)
                .load(imageURL)
                .into(holder.img_favourite);


    }

    @Override
    public int getItemCount() {
        return mealDetailsList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_mealName_favourite;
        ImageView img_favourite;
        TextView tv_mealCounty_favourite;
        TextView tv_instructions_favourite;
        VideoView videoView_favourite;
        Button button_removeFromFavourite;




        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            /*
            tv_title_value = itemView.findViewById(R.id.tv_title_value);
            tv_price_value = itemView.findViewById(R.id.tv_price_value);
            tv_brand_value = itemView.findViewById(R.id.tv_brand_value);
            tv_description_value =itemView.findViewById(R.id.tv_description_value);
            rating_bar = itemView.findViewById(R.id.ratingBar_value);
            img_mealDetails = itemView.findViewById(R.id.img_mealDetails);
            addToFavourteButon=itemView.findViewById(R.id.btn_remove);
            */

            tv_mealName_favourite = itemView.findViewById(R.id.tv_mealName_favourite);
            tv_mealCounty_favourite = itemView.findViewById(R.id.tv_mealCountryName_favourite);
            tv_instructions_favourite = itemView.findViewById(R.id.tv_mealInstructions_favourite);
            button_removeFromFavourite = itemView.findViewById(R.id.button_removeFromFavourite_favourite);
            img_favourite= itemView.findViewById(R.id.img_favourite);

        }
    }

}