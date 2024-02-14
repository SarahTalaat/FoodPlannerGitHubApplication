package com.example.foodplanner.Category.View_Category;
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
import com.example.foodplanner.Category.View_Category.OnCategoryClickListener;
import com.example.foodplanner.Model_Category.Category;
import com.example.foodplanner.R;

import java.util.ArrayList;
import java.util.List;

public class AllCategoryAdapter extends RecyclerView.Adapter<AllCategoryAdapter.MyViewHolder> {
    private static final String TAG ="team";

    Context context;
    OnCategoryClickListener onProductClickListener;

    ArrayList<Category> categoryList =new ArrayList<>();
    public AllCategoryAdapter(Context context, OnCategoryClickListener onProductClickListener){
      //  this.categoryList=categoryList;
        this.context=context;
        this.onProductClickListener=onProductClickListener;
        Log.i("X", "AllProducts Adapter constructor ");
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_category_details_card_view,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        Log.i("X", "AllProducts Adapter add card view ");
        return myViewHolder;
    }


    public void setProductList(List<Category> categoryList) { // update
        Log.i(TAG, "setProductList: ");
        this.categoryList.addAll(categoryList);
        notifyDataSetChanged();
    }



    public void onBindViewHolder(@NonNull MyViewHolder holder , int position) {

        /*
            private int id;
    private String categoryName;
    private String categoryDescription;
    private String categoryThumbnail;
         */

        TextView id;
        TextView category;
        TextView description;
        Button buttonAddToFavourites;


        ImageView image;
        String imageURL= categoryList.get(position).getStrCategoryThumb();

        Category current = categoryList.get(position);
        holder.tv_category_value.setText(current.getStrCategory());
        holder.tv_id_value.setText(""+current.getIdCategory());
        holder.tv_description_value.setText(current.getStrCategoryDescription());
        Glide.with(context)
                .load(imageURL)
                .into(holder.img_product);
        holder.button_AddToFavourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onProductClickListener.onFavClick(current);
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_id_value;
        TextView tv_description_value;
        TextView tv_category_value;

        ImageView img_product;
        Button button_AddToFavourites;


        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            tv_id_value = itemView.findViewById(R.id.tv_inspirationalMealDetails_id);
            tv_category_value = itemView.findViewById(R.id.tv_inspirationalMealDetails_category);
            tv_description_value =itemView.findViewById(R.id.tv_inspirationalMealDetails_description);
            img_product = itemView.findViewById(R.id.img_inspirationalMealDetails);
            button_AddToFavourites =itemView.findViewById(R.id.button_inspirationalMealDetails_addToFavourites);

        }
    }

}