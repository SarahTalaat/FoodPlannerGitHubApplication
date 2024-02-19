
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
import com.example.foodplanner.CategoryMeals.CategoryMeals_Model.CategoryMeals;
import com.example.foodplanner.CategoryMeals.CategoryMeals_View.OnCategoryMealsClickListener;
import com.example.foodplanner.R;

import java.util.ArrayList;


public class SearchCategoryMealsAdapter extends RecyclerView.Adapter<SearchCategoryMealsAdapter.MyViewHolder>  {


    private static final String TAG ="team";

    Context context;

    
    ArrayList<CategoryMeals> categoryMealsList =new ArrayList<>();
    public SearchCategoryMealsAdapter(Context context){
        //  this.categoryList=categoryList;
        this.context=context;
        Log.i("X", "AllProducts Adapter constructor ");
    }

    @NonNull
    @Override
    public SearchCategoryMealsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_country_meals_card_view,parent,false);
        SearchCategoryMealsAdapter.MyViewHolder myViewHolder = new SearchCategoryMealsAdapter.MyViewHolder(view);
        Log.i("X", "AllCategoryMeals Adapter add card view ");
        return myViewHolder;
    }


    public void setCategoryMealsList(ArrayList<CategoryMeals> categoryMealsList) { // update
        Log.i("Y", "Al categoryMeals adapter rando list: "+ categoryMealsList);
        this.categoryMealsList.addAll(categoryMealsList);
        notifyDataSetChanged();
    }



    public void onBindViewHolder(@NonNull SearchCategoryMealsAdapter.MyViewHolder holder , int position) {

        /*
            private int id;
    private String categoryName;
    private String categoryDescription;
    private String categoryThumbnail;
         */

        TextView categoryMeals;
        Button buttonTransparentButton;
        ImageView image;


        String imageURL= categoryMealsList.get(position).getStrMealThumb();
        CategoryMeals current = categoryMealsList.get(position);

        holder.tv_categoryMeals_mealName.setText(current.getStrMeal());


        Glide.with(context)
                .load(imageURL)
                .into(holder.img_categoryMeals);


    }

    @Override
    public int getItemCount() {
        return categoryMealsList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_categoryMeals_mealName;

        ImageView img_categoryMeals;
        Button button_transpaentutton;
        Button button_favourite;


        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            tv_categoryMeals_mealName = itemView.findViewById(R.id.tv_countryMeals);
            img_categoryMeals = itemView.findViewById(R.id.img_countryMeals);
            button_transpaentutton =itemView.findViewById(R.id.button_transparentButton_countryMeals);
           // button_favourite = itemView.findViewById(R.id.button_favourite_categoryMeals);
        }
    }



}
