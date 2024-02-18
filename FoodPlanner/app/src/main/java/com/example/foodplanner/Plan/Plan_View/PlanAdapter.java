
package com.example.foodplanner.Plan.Plan_View;

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
import com.example.foodplanner.MealDetails.MealDetails_View.OnMealDetailsClickListener;
import com.example.foodplanner.Plan.Plan_Model.Plan;
import com.example.foodplanner.R;

import java.util.ArrayList;
import java.util.List;


public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.MyViewHolder>  {


    private static final String TAG ="team";

    Context context;
    OnMealDetailsClickListener onMealDetailsClickListener;

   // ArrayList<MealDetails> mealDetailsList =new ArrayList<>();
    private List<Plan> planList;
    public PlanAdapter(Context context, List<Plan> planList, OnMealDetailsClickListener onMealDetailsClickListener){
        //  this.countryList=countryList;
        this.context=context;
        this.onMealDetailsClickListener=onMealDetailsClickListener;
        this.planList = planList;
        Log.i("X", "AllProducts Adapter constructor ");
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_plan_card,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        Log.i("X", "AllMealDetails Adapter add card view ");
        return myViewHolder;
    }


    public void setMealplanList(List<Plan> planList) { // update
        Log.i("Y", "Al mealDetails adapter rando list: "+ planList);
        this.planList.addAll(planList);
        notifyDataSetChanged();
    }



    public void onBindViewHolder(@NonNull MyViewHolder holder , int position) {

        /*
            private int id;
    private String countryName;
    private String countryDescription;
    private String countryThumbnail;
         */

        TextView mealDetails;
        Button button_favourite_plan;
        ImageView image;


     //   String imageURL= mealDetailsList.get(position).getStrMealThumb();
     //   MealDetails current = mealDetailsList.get(position);

        String imageURL = planList.get(position).getStrMealThumb();
        Plan current = planList.get(position);

        holder.tv_mealName_plan.setText(current.getStrMeal());
        Glide.with(context)
                .load(imageURL)
                .into(holder.img_plan);
        holder.button_favourite_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


/*
        holder.tv_mealName_mealDetails.setText(current.getStrMeal());
        holder.tv_mealCounty_mealDetails.setText(current.getStrArea());
        holder.tv_instructions_mealDetails.setText(current.getStrInstructions());

        // Load and play the video
        String videoUrl = current.getStrYoutube();
        if (videoUrl != null && !videoUrl.isEmpty()) {
            holder.videoView_mealDetails.setVideoPath(videoUrl);
            holder.videoView_mealDetails.start();
        }


        Glide.with(context)
                .load(imageURL)
                .into(holder.img_mealDetails);


*/
    }

    @Override
    public int getItemCount() {
        return planList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_mealName_plan;
        ImageView img_plan;

        Button button_favourite_plan;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            tv_mealName_plan = itemView.findViewById(R.id.tv_Plan);
            img_plan = itemView.findViewById(R.id.img_Plan);
            button_favourite_plan = itemView.findViewById(R.id.button_transparentButton_plan);

            // button_favourite = itemView.findViewById(R.id.button_favourite_mealDetails);

        }
    }



}
