package com.example.foodplanner.Search.Search_Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IngredientResponse {


        @SerializedName("meals")
        private List<IngredientDTO> ingredients;
        public  List<IngredientDTO> getAllIngredients(){
            return ingredients;}


}
