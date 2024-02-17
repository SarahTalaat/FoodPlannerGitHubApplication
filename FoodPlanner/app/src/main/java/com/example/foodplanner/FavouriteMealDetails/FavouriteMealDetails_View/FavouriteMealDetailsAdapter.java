package com.example.foodplanner.FavouriteMealDetails.FavouriteMealDetails_View;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;
import com.example.foodplanner.R;


import java.util.List;

public class FavouriteMealDetailsAdapter extends RecyclerView.Adapter<FavouriteMealDetailsAdapter.MyViewHolder> {
    private static final String TAG ="team";

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
        View view = inflater.inflate(R.layout.fragment_ingredients_card_view,parent,false);
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
    }

    @Override
    public int getItemCount() {
        return mealDetailsList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        /*
        TextView tv_title_value;
        TextView tv_description_value;
        TextView tv_brand_value;
        TextView tv_price_value;
        RatingBar rating_bar;

        ImageView img_mealDetails;
        Button addToFavourteButon;
*/

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
        }
    }

}