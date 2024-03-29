package com.example.foodplanner.MealDetails.MealDetails_Model;

import android.util.Log;

import com.example.foodplanner.Database.MealDetailsLocalDataSourceImpl;
import com.example.foodplanner.Network.ConnetionRemoteDataSource;
import com.example.foodplanner.Network.ConnetionRemoteDataSourceImplementation;
import com.example.foodplanner.Plan.Plan_Model.Plan;

import java.util.List;


import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public class MealDetailsRepositoryImplementation implements MealDetailsRepository {


    public static final String DB ="DB";

    private static MealDetailsRepositoryImplementation repository = null;
    ConnetionRemoteDataSource connetionRemoteDataSource; //ntwork connection and get data
    MealDetailsLocalDataSourceImpl mealDetailsLocalDataSourceImp;

    public MealDetailsRepositoryImplementation(ConnetionRemoteDataSourceImplementation connetionRemoteDataSource,MealDetailsLocalDataSourceImpl mealDetailsLocalDataSourceImp) {
        this.connetionRemoteDataSource = connetionRemoteDataSource;
        this.mealDetailsLocalDataSourceImp = mealDetailsLocalDataSourceImp;
    }

    //    CountryLocalDataSource countryLocalDataSource; //insert delete getpro interface
/*
    private AllCountryRepositoryImplementation(ConnetionRemoteDataSource connetionRemoteDataSource, CountryLocalDataSource countryLocalDataSource) {
        this.connetionRemoteDataSource = connetionRemoteDataSource;
        this.countryLocalDataSource = countryLocalDataSource;
    }
*/
    public static MealDetailsRepositoryImplementation getInstance(ConnetionRemoteDataSourceImplementation connetionRemoteDataSourceImplementation,MealDetailsLocalDataSourceImpl mealDetailsLocalDataSourceImp ) {
        if (repository == null) {
            repository = new MealDetailsRepositoryImplementation(connetionRemoteDataSourceImplementation,mealDetailsLocalDataSourceImp);
        }
        return repository;
    }

    @Override
    public Flowable<List<MealDetails>> getStoredMealDetails() {

        return mealDetailsLocalDataSourceImp.getStoredProducts() ;
    }

    /*
        public static AllCountryRepositoryImplementation getInstance(ConnetionRemoteDataSource connetionRemoteDataSource, CountryLocalDataSource countryLocalDataSource) {
            if (repository == null) {
                repository = new AllCountryRepositoryImplementation(connetionRemoteDataSource, countryLocalDataSource);
            }
            return repository;
        }

        */
/*
    @Override
    public Flowable<List<AllCountry>> getStoredProducts() {
        return countryLocalDataSource.getAllStoredProducts();
    }


 */
    @Override
    public Observable<MealDetailsResponse> getAllMealDetails(String mealDetails) {
        Log.i("MealDtailsRepoImp", "getAllMealDetails: "+ mealDetails);
        return connetionRemoteDataSource.makeNetworkCallBackMealDetails(mealDetails);
    }


    @Override
    public Completable insertMealDetails(MealDetails mealDetails) {


        Log.i(DB, "-- repoImp insertttt -- "+
                "Meal id: " + mealDetails.getIdMeal() +
                "Meal name: " + mealDetails.getStrMeal() +
                "Meal Area: " + mealDetails.getStrArea() +
                "Meal Instructions: " + mealDetails.getStrInstructions() +
                "Meal YoutubeURL: " + mealDetails.getStrYoutube()
        );

        return mealDetailsLocalDataSourceImp.insert(mealDetails) ;

    }

    @Override
    public Completable deleteMealDetails(MealDetails mealDetails) {

        return mealDetailsLocalDataSourceImp.delete(mealDetails);
    }

    @Override
    public Flowable<List<Plan>> getStoredPlan() {
        return mealDetailsLocalDataSourceImp.getStoredPlan() ;
    }

    @Override
    public Completable insertPlan(Plan plan) {
        Log.i(DB, "-- repoImp insertttt plan -- "+
                "Meal id: " + plan.getIdMeal() +
                "Meal name: " + plan.getStrMeal() +
                "Meal Area: " + plan.getStrArea() +
                "Meal Instructions: " + plan.getStrInstructions() +
                "Meal YoutubeURL: " + plan.getStrYoutube()
        );

        return mealDetailsLocalDataSourceImp.insertPlan(plan) ;
    }

    @Override
    public Completable deletePlan(Plan plan) {

        Log.i(DB, "-- repoImp delete plan -- "+
                "Plan Meal id: " + plan.getIdMeal() +
                "Plan Meal name: " + plan.getStrMeal() +
                "Plan Meal Area: " + plan.getStrArea() +
                "Plan Meal Instructions: " + plan.getStrInstructions() +
                "Plan Meal YoutubeURL: " + plan.getStrYoutube()
        );
        return mealDetailsLocalDataSourceImp.deletePlan(plan);
    }


}
