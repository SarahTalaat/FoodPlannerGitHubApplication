package com.example.foodplanner.AllCountry.AllCountry_View;

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

import com.example.foodplanner.R;
import com.example.foodplanner.AllCountry.AllCountry_Model.Country;

import java.util.ArrayList;



    public class AllCountryAdapter extends RecyclerView.Adapter<com.example.foodplanner.AllCountry.AllCountry_View.AllCountryAdapter.MyViewHolder>  {


        private static final String TAG ="team";

        Context context;
        OnCountryClickListener onCountryClickListener;

        ArrayList<Country> countryList =new ArrayList<>();
        public AllCountryAdapter(Context context, OnCountryClickListener onCountryClickListener){
            //  this.categoryList=categoryList;
            this.context=context;
            this.onCountryClickListener=onCountryClickListener;
            Log.i("X", "AllProducts Adapter constructor ");
        }

        @NonNull
        @Override
        public com.example.foodplanner.AllCountry.AllCountry_View.AllCountryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.fragment_country_card_view,parent,false);
            com.example.foodplanner.AllCountry.AllCountry_View.AllCountryAdapter.MyViewHolder myViewHolder = new com.example.foodplanner.AllCountry.AllCountry_View.AllCountryAdapter.MyViewHolder(view);
            Log.i("X", "AllCountry Adapter add card view ");
            return myViewHolder;
        }


        public void setCountryList(ArrayList<Country> countryList) { // update
            Log.i("Y", "Al country adapter rando list: "+ countryList);
            this.countryList.addAll(countryList);
            notifyDataSetChanged();
        }



        public void onBindViewHolder(@NonNull com.example.foodplanner.AllCountry.AllCountry_View.AllCountryAdapter.MyViewHolder holder , int position) {

        /*
            private int id;
    private String categoryName;
    private String categoryDescription;
    private String categoryThumbnail;
         */

            TextView tv_country;
            Button buttonTransparentButton_country;
            ImageView image_country;



            Country current = countryList.get(position);
            holder.tv_country_mealName.setText(current.getStrArea());


            holder.button_transparentutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onCountryClickListener.onCountryClick(countryList.get(position).getStrArea());

                }
            });

        }

        @Override
        public int getItemCount() {
            return countryList.size();
        }


        class MyViewHolder extends RecyclerView.ViewHolder{

            TextView tv_country_mealName;
            Button button_transparentutton;


            public MyViewHolder(@NonNull View itemView){
                super(itemView);

                tv_country_mealName = itemView.findViewById(R.id.tv_country);
                button_transparentutton =itemView.findViewById(R.id.button_transparentButton_country);

            }
        }



    }





