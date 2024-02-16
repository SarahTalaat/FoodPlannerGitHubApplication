
package com.example.foodplanner.CountryMeals.CountryMeals_View;

import com.example.foodplanner.CountryMeals.CountryMeals_Model.CountryMeals;
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


public class AllCountryMealsAdapter extends RecyclerView.Adapter<AllCountryMealsAdapter.MyViewHolder>  {


    private static final String TAG ="team";

    Context context;
    OnCountryMealsClickListener onCountryMealsClickListener;

    ArrayList<CountryMeals> countryMealsList =new ArrayList<>();
    public AllCountryMealsAdapter(Context context, OnCountryMealsClickListener onCountryMealsClickListener){
        //  this.countryList=countryList;
        this.context=context;
        this.onCountryMealsClickListener=onCountryMealsClickListener;
        Log.i("X", "AllProducts Adapter constructor ");
    }

    @NonNull
    @Override
    public AllCountryMealsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_country_meals_card_view,parent,false);
        AllCountryMealsAdapter.MyViewHolder myViewHolder = new AllCountryMealsAdapter.MyViewHolder(view);
        Log.i("X", "AllCountryMeals Adapter add card view ");
        return myViewHolder;
    }


    public void setCountryMealsList(ArrayList<CountryMeals> countryMealsList) { // update
        Log.i("Y", "Al countryMeals adapter rando list: "+ countryMealsList);
        this.countryMealsList.addAll(countryMealsList);
        notifyDataSetChanged();
    }



    public void onBindViewHolder(@NonNull AllCountryMealsAdapter.MyViewHolder holder , int position) {

        /*
            private int id;
    private String countryName;
    private String countryDescription;
    private String countryThumbnail;
         */

        TextView countryMeals;
        Button buttonTransparentButton;
        ImageView image;


        String imageURL= countryMealsList.get(position).getStrMealThumb();

        CountryMeals current = countryMealsList.get(position);
        holder.tv_countryMeals_mealName.setText(current.getStrMeal());


        Glide.with(context)
                .load(imageURL)
                .into(holder.img_countryMeals);
        holder.button_transpaentutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCountryMealsClickListener.onFavClickCountryMeals(current);
            }
        });

        holder.button_transpaentutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCountryMealsClickListener.onCountryMealsClick(countryMealsList.get(position).getStrMeal());
            }
        });

    }

    @Override
    public int getItemCount() {
        return countryMealsList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_countryMeals_mealName;

        ImageView img_countryMeals;
        Button button_transpaentutton;
        Button button_favourite;


        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            tv_countryMeals_mealName = itemView.findViewById(R.id.tv_countryMeals);
            img_countryMeals = itemView.findViewById(R.id.img_countryMeals);
            button_transpaentutton =itemView.findViewById(R.id.button_transparentButton_countryMeals);
           // button_favourite = itemView.findViewById(R.id.button_favourite_countryMeals);
        }
    }



}
