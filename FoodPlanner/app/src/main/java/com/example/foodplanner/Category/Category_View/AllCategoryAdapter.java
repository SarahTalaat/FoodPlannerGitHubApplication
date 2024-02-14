package com.example.foodplanner.Category.Category_View;
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
import com.example.foodplanner.Category_Model.Category;
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
        View view = inflater.inflate(R.layout.fragment_category_card_view_fragmet,parent,false);
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


        TextView category;
        Button buttonTransparentButton;
        ImageView image;


        String imageURL= categoryList.get(position).getStrCategoryThumb();

        Category current = categoryList.get(position);
        holder.tv_category_value.setText(current.getStrCategory());


        Glide.with(context)
                .load(imageURL)
                .into(holder.img_category);
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

        TextView tv_category_value;

        ImageView img_category;
        Button button_AddToFavourites;


        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            tv_category_value = itemView.findViewById(R.id.tv_category);

            img_category = itemView.findViewById(R.id.img_category);
            button_AddToFavourites =itemView.findViewById(R.id.button_transparentButton_catgory);

        }
    }

}