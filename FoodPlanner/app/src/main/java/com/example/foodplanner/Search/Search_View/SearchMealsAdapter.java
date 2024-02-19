
package com.example.foodplanner.Search.Search_View;

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
import com.example.foodplanner.Search.Search_Model.Meals;

import java.util.ArrayList;
import java.util.List;


public class SearchMealsAdapter extends RecyclerView.Adapter<SearchMealsAdapter.MyViewHolder>  {


    private static final String TAG ="team";

    Context context;

    List<Meals> mealsList =new ArrayList<>();
    public SearchMealsAdapter(Context context){
        //  this.countryList=countryList;
        this.context=context;
        Log.i("X", "AllProducts Adapter constructor ");
    }

    @NonNull
    @Override
    public SearchMealsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_country_meals_card_view,parent,false);
        SearchMealsAdapter.MyViewHolder myViewHolder = new SearchMealsAdapter.MyViewHolder(view);
        Log.i("X", "AllMeals Adapter add card view ");
        return myViewHolder;
    }


    public void setMealsList(List<Meals> mealsList) { // update
        Log.i("Y", "Al meals adapter rando list: "+ mealsList);
        this.mealsList.addAll(mealsList);
        notifyDataSetChanged();
    }



    public void onBindViewHolder(@NonNull SearchMealsAdapter.MyViewHolder holder , int position) {

        /*
            private int id;
    private String countryName;
    private String countryDescription;
    private String countryThumbnail;
         */

        TextView meals;
        Button buttonTransparentButton;
        ImageView image;


        String imageURL= mealsList.get(position).getStrMealThumb();
        Meals current = mealsList.get(position);

        holder.tv_meals_mealName.setText(current.getStrMeal());


        Glide.with(context)
                .load(imageURL)
                .into(holder.img_meals);


    }

    @Override
    public int getItemCount() {
        return mealsList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_meals_mealName;

        ImageView img_meals;
        Button button_transpaentutton;
        Button button_favourite;


        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            tv_meals_mealName = itemView.findViewById(R.id.tv_countryMeals);
            img_meals = itemView.findViewById(R.id.img_countryMeals);
            button_transpaentutton =itemView.findViewById(R.id.button_transparentButton_countryMeals);
           // button_favourite = itemView.findViewById(R.id.button_favourite_meals);
        }
    }



}
