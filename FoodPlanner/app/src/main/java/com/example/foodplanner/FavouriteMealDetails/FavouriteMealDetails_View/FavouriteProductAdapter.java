/*
package com.example.foodplanner.FavouriteMealDetails.FavouriteMealDetails_View;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.productappmvp.Model.Product;
import com.example.productappmvp.R;

import java.util.List;

public class FavouriteProductAdapter extends RecyclerView.Adapter<FavouriteProductAdapter.MyViewHolder> {
    private static final String TAG ="team";

    Context context;
    OnProductClickListenerDelete onProductClickListenerDelete;

    List<Product> productList;
    public FavouriteProductAdapter(Context context, List<Product>  productList,  OnProductClickListenerDelete onProductClickListenerDelete){
        this.productList=productList;
        this.context=context;
        this.onProductClickListenerDelete=onProductClickListenerDelete;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_product_description_favourites,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }


    public void setProductList(List<Product> productList) { // update
        Log.i(TAG, "setProductList: ");
      //  this.productList.addAll(productList);
        this.productList=productList;
        notifyDataSetChanged();
    }



    public void onBindViewHolder(@NonNull MyViewHolder holder , int position) {

        ImageView image;
        String imageURL=productList.get(position).getThumbnail();

        Product current = productList.get(position);
        holder.tv_title_value.setText(current.getTitle());
        holder.tv_price_value.setText(""+current.getPrice());
        holder.tv_description_value.setText(current.getDescription());
        holder.tv_brand_value.setText(current.getBrand());
        holder.rating_bar.setRating(current.getRating());
        Glide.with(context)
                .load(imageURL)
                .into(holder.img_product);
        holder.addToFavourteButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onProductClickListenerDelete.onDeleteClick(current);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title_value;
        TextView tv_description_value;
        TextView tv_brand_value;
        TextView tv_price_value;
        RatingBar rating_bar;

        ImageView img_product;
        Button addToFavourteButon;


        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            tv_title_value = itemView.findViewById(R.id.tv_title_value);
            tv_price_value = itemView.findViewById(R.id.tv_price_value);
            tv_brand_value = itemView.findViewById(R.id.tv_brand_value);
            tv_description_value =itemView.findViewById(R.id.tv_description_value);
            rating_bar = itemView.findViewById(R.id.ratingBar_value);
            img_product = itemView.findViewById(R.id.img_product);
            addToFavourteButon=itemView.findViewById(R.id.btn_remove);

        }
    }

}

 */