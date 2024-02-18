package com.example.foodplanner.Plan.Plan_View;

import android.icu.util.ULocale;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodplanner.AllCountry.AllCountry_Model.CountryRepositoryImplementation;
import com.example.foodplanner.AllCountry.AllCountry_Presenter.CountryPresenterImplementation;
import com.example.foodplanner.Database.MealDetailsLocalDataSourceImpl;
import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetails;
import com.example.foodplanner.MealDetails.MealDetails_Model.MealDetailsRepositoryImplementation;
import com.example.foodplanner.MealDetails.MealDetails_Presenter.MealDetailsPresenterImplementation;
import com.example.foodplanner.MealDetails.MealDetails_View.OnMealDetailsClickListener;
import com.example.foodplanner.Network.ConnetionRemoteDataSource;
import com.example.foodplanner.Network.ConnetionRemoteDataSourceImplementation;
import com.example.foodplanner.Plan.Plan_Model.Plan;
import com.example.foodplanner.Plan.Plan_Presenter.PlanPresenterImplementation;
import com.example.foodplanner.Plan.Plan_View.PlanAdapter;
import com.example.foodplanner.Plan.Plan_View.PlanViewInterface;
import com.example.foodplanner.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Plan_Fragment_RecyclerView extends Fragment implements PlanViewInterface , OnMealDetailsClickListener {
    RecyclerView  sundayRV;
    RecyclerView mondayRV;
    RecyclerView tuesdayRV;
    RecyclerView wednesdayRV;
    RecyclerView thursdayRV;
    RecyclerView fridayRV;

    RecyclerView saturdayRV;

    PlanAdapter saturdayAdapter;
    PlanAdapter   sundayAdapter;
    PlanAdapter  mondayAdapter;
    PlanAdapter  tuesdayAdapter;
    PlanAdapter   wednesdayAdapter;
    PlanAdapter thursdayAdapter;
    PlanAdapter  fridayAdapter;

    PlanViewInterface viewInterface;

    PlanPresenterImplementation presenter;

    LinearLayoutManager layoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_plan_recycler_view, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sundayRV=view.findViewById(R.id.sundayRV);
        mondayRV=view.findViewById(R.id.mondayRV);
        tuesdayRV=view.findViewById(R.id.tuesdayRV);
        wednesdayRV=view.findViewById(R.id.wednesdayRV);
        thursdayRV=view.findViewById(R.id.ThursdayRV);
        fridayRV=view.findViewById(R.id.fridayRV);
        saturdayRV=view.findViewById(R.id.saturdayRV);
        layoutManager=new LinearLayoutManager(view.getContext());
        saturdayAdapter=new PlanAdapter(view.getContext(),new ArrayList<>(),this);
        sundayAdapter=new PlanAdapter(view.getContext(),new ArrayList<>(),this);
        mondayAdapter=new PlanAdapter(view.getContext(),new ArrayList<>(),this);
        tuesdayAdapter=new PlanAdapter(view.getContext(),new ArrayList<>(),this);
        wednesdayAdapter=new PlanAdapter(view.getContext(),new ArrayList<>(),this);
        thursdayAdapter=new PlanAdapter(view.getContext(),new ArrayList<>(),this);
        fridayAdapter=new PlanAdapter(view.getContext(),new ArrayList<>(),this);
        LinearLayoutManager saturdayLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        saturdayRV.setLayoutManager(saturdayLayoutManager);
        LinearLayoutManager sundayLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        sundayRV.setLayoutManager(sundayLayoutManager);
        LinearLayoutManager mondayLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mondayRV.setLayoutManager(mondayLayoutManager);
        LinearLayoutManager tuesdayLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        tuesdayRV.setLayoutManager(tuesdayLayoutManager);
        LinearLayoutManager wednesdayLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        wednesdayRV.setLayoutManager(wednesdayLayoutManager);
        LinearLayoutManager thursdayLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        thursdayRV.setLayoutManager(thursdayLayoutManager);
        LinearLayoutManager fridayLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        fridayRV.setLayoutManager(fridayLayoutManager);
        sundayRV.setAdapter(sundayAdapter);
        mondayRV.setAdapter( mondayAdapter);
        tuesdayRV.setAdapter( tuesdayAdapter);
        wednesdayRV.setAdapter(wednesdayAdapter);
        thursdayRV.setAdapter(thursdayAdapter);
        fridayRV.setAdapter(fridayAdapter);
        saturdayRV.setAdapter(saturdayAdapter);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        presenter = new PlanPresenterImplementation(this, MealDetailsRepositoryImplementation.getInstance(ConnetionRemoteDataSourceImplementation.getInstance(), MealDetailsLocalDataSourceImpl.getInstance(getContext())));


        showdatamealplan();
    }

    @Override
    public void deleltemealplan(Plan mealPlan) {
        presenter.removemealplan(mealPlan);
    }

    private List<Plan> filterMealsByDay(List<Plan> meals, String day) {
        List<Plan> filteredMeals = new ArrayList<>();
        for (Plan meal : meals) {
            if (meal.getNameOfDay().equalsIgnoreCase(day)) {
                filteredMeals.add(meal);
            }
        }
        return filteredMeals;}
    @Override
    public void showdatamealplan() {

        Flowable<List<Plan>> myFavProducts =presenter.getMealplan();
        myFavProducts.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(meals -> {
                    saturdayAdapter.setMealplanList(filterMealsByDay(meals, "saturday"));
                    sundayAdapter.setMealplanList(filterMealsByDay(meals, "sunday"));
                    mondayAdapter.setMealplanList(filterMealsByDay(meals, "monday"));
                    tuesdayAdapter.setMealplanList(filterMealsByDay(meals, "tuesday"));
                    wednesdayAdapter.setMealplanList(filterMealsByDay(meals, "wednesday"));
                    thursdayAdapter.setMealplanList(filterMealsByDay(meals, "thursday"));
                    fridayAdapter.setMealplanList(filterMealsByDay(meals, "friday"));});
    }

    @Override
    public void showerrormealplan(String errormsg) {
        viewInterface.showerrormealplan(errormsg);
    }

    @Override
    public void onFavClickMealDetails(MealDetails mealDetails) {

    }

    @Override
    public void onDeleteClickMealDetails(MealDetails mealDetails) {

    }

    @Override
    public void onPlanClick(Plan mealPlan) {

    }
}