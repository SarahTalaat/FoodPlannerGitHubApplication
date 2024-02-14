
package com.example.foodplanner.Random.Random_View;

import com.example.foodplanner.Random_Model.Random;
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


public class AllRandomAdapter extends RecyclerView.Adapter<AllRandomAdapter.MyViewHolder>  {


    private static final String TAG ="team";

    Context context;
    OnRandomClickListener onRandomClickListener;

    ArrayList<Random> randomList =new ArrayList<>();
    public AllRandomAdapter(Context context, OnRandomClickListener onRandomClickListener){
        //  this.categoryList=categoryList;
        this.context=context;
        this.onRandomClickListener=onRandomClickListener;
        Log.i("X", "AllProducts Adapter constructor ");
    }

    @NonNull
    @Override
    public AllRandomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_random_card_view,parent,false);
        AllRandomAdapter.MyViewHolder myViewHolder = new AllRandomAdapter.MyViewHolder(view);
        Log.i("X", "AllRandom Adapter add card view ");
        return myViewHolder;
    }


    public void setRandomList(ArrayList<Random> randomList) { // update
        Log.i("Y", "Al random adapter rando list: "+ randomList);
        this.randomList.addAll(randomList);
        notifyDataSetChanged();
    }



    public void onBindViewHolder(@NonNull AllRandomAdapter.MyViewHolder holder , int position) {

        /*
            private int id;
    private String categoryName;
    private String categoryDescription;
    private String categoryThumbnail;
         */

        TextView random;
        Button buttonTransparentButton;
        ImageView image;


        String imageURL= randomList.get(position).getStrMealThumb();

        Random current = randomList.get(position);
        holder.tv_random_mealName.setText(current.getStrMeal());


        Glide.with(context)
                .load(imageURL)
                .into(holder.img_random);
        holder.button_transpaentutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRandomClickListener.onFavClickRandom(current);
            }
        });

    }

    @Override
    public int getItemCount() {
        return randomList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_random_mealName;

        ImageView img_random;
        Button button_transpaentutton;


        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            tv_random_mealName = itemView.findViewById(R.id.tv_mealName_random);
            img_random = itemView.findViewById(R.id.img_random);
            button_transpaentutton =itemView.findViewById(R.id.button_transparentButton_random);

        }
    }



}
