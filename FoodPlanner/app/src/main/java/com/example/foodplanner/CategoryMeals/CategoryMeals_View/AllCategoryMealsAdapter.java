
package com.example.foodplanner.CategoryMeals.CategoryMeals_View;

import com.example.foodplanner.CategoryMeals.CategoryMeals_Model.CategoryMeals;
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


public class AllCategoryMealsAdapter extends RecyclerView.Adapter<AllCategoryMealsAdapter.MyViewHolder>  {


    private static final String TAG ="team";

    Context context;
    OnCategoryMealsClickListener onCategoryMealsClickListener;

    ArrayList<CategoryMeals> categoryMealsList =new ArrayList<>();
    public AllCategoryMealsAdapter(Context context, OnCategoryMealsClickListener onCategoryMealsClickListener){
        //  this.categoryList=categoryList;
        this.context=context;
        this.onCategoryMealsClickListener=onCategoryMealsClickListener;
        Log.i("X", "AllProducts Adapter constructor ");
    }

    @NonNull
    @Override
    public AllCategoryMealsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_categorymeals_card_view,parent,false);
        AllCategoryMealsAdapter.MyViewHolder myViewHolder = new AllCategoryMealsAdapter.MyViewHolder(view);
        Log.i("X", "AllCategoryMeals Adapter add card view ");
        return myViewHolder;
    }


    public void setCategoryMealsList(ArrayList<CategoryMeals> categoryMealsList) { // update
        Log.i("Y", "Al categoryMeals adapter rando list: "+ categoryMealsList);
        this.categoryMealsList.addAll(categoryMealsList);
        notifyDataSetChanged();
    }



    public void onBindViewHolder(@NonNull AllCategoryMealsAdapter.MyViewHolder holder , int position) {

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
        holder.button_transpaentutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCategoryMealsClickListener.onFavClickCategoryMeals(current);
            }
        });

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

            tv_categoryMeals_mealName = itemView.findViewById(R.id.tv_categoryMeals);
            img_categoryMeals = itemView.findViewById(R.id.img_categoryMeals);
            button_transpaentutton =itemView.findViewById(R.id.button_transparentButton_categoryMeals);
            button_favourite = itemView.findViewById(R.id.button_favourite_categoryMeals);
        }
    }



}
