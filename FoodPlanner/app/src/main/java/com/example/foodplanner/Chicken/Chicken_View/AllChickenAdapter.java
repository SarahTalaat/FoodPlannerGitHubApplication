/*
package com.example.foodplanner.Chicken.Chicken_View;

import com.example.foodplanner.Chicken_Model.Chicken;
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
import com.example.foodplanner.Category.Category_View.AllCategoryAdapter;
import com.example.foodplanner.Category_Model.Category;
import com.example.foodplanner.R;

import java.util.ArrayList;
import java.util.List;


public class AllChickenAdapter extends RecyclerView.Adapter<AllChickenAdapter.MyViewHolder>  {


    private static final String TAG ="team";

    Context context;
    OnChickenClickListener onChickenClickListener;

    ArrayList<Chicken> chickenList =new ArrayList<>();
    public AllChickenAdapter(Context context, OnChickenClickListener onChickenClickListener){
        //  this.categoryList=categoryList;
        this.context=context;
        this.onChickenClickListener=onChickenClickListener;
        Log.i("X", "AllProducts Adapter constructor ");
    }

    @NonNull
    @Override
    public AllChickenAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_chicken_card_view,parent,false);
        AllChickenAdapter.MyViewHolder myViewHolder = new AllChickenAdapter.MyViewHolder(view);
        Log.i("X", "AllChicken Adapter add card view ");
        return myViewHolder;
    }


    public void setChickenList(ArrayList<Chicken> chickenList) { // update
        Log.i("Y", "Al chicken adapter rando list: "+ chickenList);
        this.chickenList.addAll(chickenList);
        notifyDataSetChanged();
    }



    public void onBindViewHolder(@NonNull AllChickenAdapter.MyViewHolder holder , int position) {

        /*
            private int id;
    private String categoryName;
    private String categoryDescription;
    private String categoryThumbnail;
         */

    /*    TextView chicken;
        Button buttonTransparentButton;
        ImageView image;


        String imageURL= chickenList.get(position).getStrMealThumb();

        Chicken current = chickenList.get(position);
        holder.tv_chicken_mealName.setText(current.getStrMeal());


        Glide.with(context)
                .load(imageURL)
                .into(holder.img_chicken);
        holder.button_transpaentutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onChickenClickListener.onFavClickChicken(current);
            }
        });

    }

    @Override
    public int getItemCount() {
        return chickenList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_chicken_mealName;

        ImageView img_chicken;
        Button button_transpaentutton;


        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            tv_chicken_mealName = itemView.findViewById(R.id.tv_mealName_chicken);
            img_chicken = itemView.findViewById(R.id.img_chicken);
            button_transpaentutton =itemView.findViewById(R.id.button_transparentButton_chicken);

        }
    }



}
*/