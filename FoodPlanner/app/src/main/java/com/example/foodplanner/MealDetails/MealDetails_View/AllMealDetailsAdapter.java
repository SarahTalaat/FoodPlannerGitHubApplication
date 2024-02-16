
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

import androidx.annotation.NonNull;
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
        View view = inflater.inflate(R.layout.fragment_country_meals_card_view,parent,false);
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

        TextView mealDetails;
        Button buttonTransparentButton;
        ImageView image;


        String imageURL= mealDetailsList.get(position).getStrMealThumb();

        MealDetails current = mealDetailsList.get(position);
        holder.tv_mealDetails_mealName.setText(current.getStrMeal());


        Glide.with(context)
                .load(imageURL)
                .into(holder.img_mealDetails);
        holder.button_transpaentutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMealDetailsClickListener.onFavClickMealDetails(current);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mealDetailsList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_mealDetails_mealName;

        ImageView img_mealDetails;
        Button button_transpaentutton;
        Button button_favourite;


        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            tv_mealDetails_mealName = itemView.findViewById(R.id.tv_mealDetails);
            img_mealDetails = itemView.findViewById(R.id.img_mealDetails);
            button_transpaentutton =itemView.findViewById(R.id.button_transparentButton_mealDetails);
            // button_favourite = itemView.findViewById(R.id.button_favourite_mealDetails);
        }
    }



}
