package com.example.foodplanner.Search.Search_Model;



import com.example.foodplanner.AllCategory.AllCategory_Model.AllCategoryResponse;
import com.example.foodplanner.AllCountry.AllCountry_Model.CountryResponse;
import com.example.foodplanner.CategoryMeals.CategoryMeals_Model.CategoryMealsResponse;
import com.example.foodplanner.CountryMeals.CountryMeals_Model.CountryMealsResponse;
import com.example.foodplanner.Network.ConnetionRemoteDataSource;
import com.example.foodplanner.Network.ConnetionRemoteDataSourceImplementation;

import io.reactivex.rxjava3.core.Observable;

public class SearchRepositoryImplementation implements SearchRepository {


    ConnetionRemoteDataSource connetionRemoteDataSource;
    private static SearchRepositoryImplementation instance = null;


    private SearchRepositoryImplementation(ConnetionRemoteDataSource _connetionRemoteDataSource){
        this.connetionRemoteDataSource = _connetionRemoteDataSource;
    }


    public static SearchRepositoryImplementation getInstance(ConnetionRemoteDataSource _connetionRemoteDataSource){
        if(instance==null){
            instance = new SearchRepositoryImplementation(_connetionRemoteDataSource);
        }
        return instance;
    }

    @Override
    public Observable<AllCategoryResponse> getCategories() {

        return connetionRemoteDataSource.makeNetworkCallBackCategory();
    }

    @Override
    public Observable<IngredientResponse> getIngredients() {
        return connetionRemoteDataSource.makeNetworkCallBackIngredients();
    }

    @Override
    public Observable<CountryResponse> getCountries() {
        return connetionRemoteDataSource.makeNetworkCallBackCountry();
    }

    @Override
    public Observable<CategoryMealsResponse> getCategoriesMeals(String categoriesMeal) {
        return connetionRemoteDataSource.makeNetworkCallBackCategoryMeals(categoriesMeal);
    }

    @Override
    public Observable<MealResponse> getIngredientsMeals(String ingredientMeal) {
        return connetionRemoteDataSource.makeNetworkCallBackIngredientMeals(ingredientMeal);
    }

    @Override
    public Observable<CountryMealsResponse> getCountriesMeals(String countriesMeal) {
        return connetionRemoteDataSource.makeNetworkCallBackCountryMeals(countriesMeal);
    }

    @Override
    public Observable<MealResponse> getMealsByName(String mealName) {
        return connetionRemoteDataSource.makeNetworkCallBackByName(mealName);
    }


}





