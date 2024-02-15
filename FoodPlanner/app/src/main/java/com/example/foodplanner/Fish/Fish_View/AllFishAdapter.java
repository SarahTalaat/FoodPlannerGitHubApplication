
package com.example.foodplanner.Fish.Fish_View;

import com.example.foodplanner.Fish_Model.Fish;
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


public class AllFishAdapter extends RecyclerView.Adapter<AllFishAdapter.MyViewHolder>  {


    private static final String TAG ="team";

    Context context;
    OnFishClickListener onFishClickListener;

    ArrayList<Fish> fishList =new ArrayList<>();
    public AllFishAdapter(Context context, OnFishClickListener onFishClickListener){
        //  this.categoryList=categoryList;
        this.context=context;
        this.onFishClickListener=onFishClickListener;
        Log.i("X", "AllProducts Adapter constructor ");
    }

    @NonNull
    @Override
    public AllFishAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_fish_card_view,parent,false);
        AllFishAdapter.MyViewHolder myViewHolder = new AllFishAdapter.MyViewHolder(view);
        Log.i("X", "AllFish Adapter add card view ");
        return myViewHolder;
    }


    public void setFishList(ArrayList<Fish> fishList) { // update
        Log.i("Y", "Al fish adapter rando list: "+ fishList);
        this.fishList.addAll(fishList);
        notifyDataSetChanged();
    }



    public void onBindViewHolder(@NonNull AllFishAdapter.MyViewHolder holder , int position) {

        /*
            private int id;
    private String categoryName;
    private String categoryDescription;
    private String categoryThumbnail;
         */

        TextView fish;
        Button buttonTransparentButton;
        ImageView image;


        String imageURL= fishList.get(position).getStrMealThumb();

        Fish current = fishList.get(position);
        holder.tv_fish_mealName.setText(current.getStrMeal());


        Glide.with(context)
                .load(imageURL)
                .into(holder.img_fish);
        holder.button_transpaentutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFishClickListener.onFavClickFish(current);
            }
        });

    }

    @Override
    public int getItemCount() {
        return fishList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_fish_mealName;

        ImageView img_fish;
        Button button_transpaentutton;
        Button button_favourite;


        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            tv_fish_mealName = itemView.findViewById(R.id.tv_fish);
            img_fish = itemView.findViewById(R.id.img_fish);
            button_transpaentutton =itemView.findViewById(R.id.button_transparentButton_fish);
            button_favourite = itemView.findViewById(R.id.button_favourite_fish);
        }
    }



}
