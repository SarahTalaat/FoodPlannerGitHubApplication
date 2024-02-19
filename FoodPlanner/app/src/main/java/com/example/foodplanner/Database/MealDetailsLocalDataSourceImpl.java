package com.example.foodplanner.Database;

import android.content.Context;

import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;
import com.example.foodplanner.Plan.Plan_Model.Plan;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MealDetailsLocalDataSourceImpl implements MealDetailsLocalDataSource {
    private MealDetailsDAO mealDetailsDAO;
    private PlanDAO planDAO;
    private static MealDetailsLocalDataSourceImpl instance=null;
  //  private Flowable<List<Product>> productsList;
    private MealDetailsLocalDataSourceImpl(Context context){
        AppDataBase appDataBase= AppDataBase.getInstance(context.getApplicationContext());
        mealDetailsDAO = appDataBase.getProductDAO();
        planDAO = appDataBase.getPlanDAO();

    //    productsList = mealDetailsDAO.getAllProducts();
    }

    public static MealDetailsLocalDataSourceImpl getInstance(Context context) {
        if(instance == null){
            instance=new MealDetailsLocalDataSourceImpl(context);
        }
        return instance;
    }

    @Override
    public Completable insert(MealDetails mealDetails) {
        Completable completable= mealDetailsDAO.insert(mealDetails).subscribeOn(Schedulers.io());
        return  completable;
    }


    @Override
    public Completable delete(MealDetails mealDetails) {
        return mealDetailsDAO.delete(mealDetails).subscribeOn(Schedulers.io());

    }

    @Override
    public Flowable<List<MealDetails>> getStoredProducts() {

        return mealDetailsDAO.getAllProducts().subscribeOn(Schedulers.io()) ;
    }

    @Override
    public Completable insertPlan(Plan plan) {
        return planDAO.insertPlans(plan).subscribeOn(Schedulers.io());
    }

    @Override
    public Completable deletePlan(Plan plan) {
        return planDAO.deletePlan(plan).subscribeOn(Schedulers.io());
    }

    @Override
    public Flowable<List<Plan>> getStoredPlan() {
        return planDAO.getAllPlan();
    }
}
