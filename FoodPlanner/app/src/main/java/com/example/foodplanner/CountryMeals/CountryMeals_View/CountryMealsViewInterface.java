
package com.example.foodplanner.CountryMeals.CountryMeals_View;

import com.example.foodplanner.CountryMeals.CountryMeals_Model.CountryMeals;

import java.util.ArrayList;


public interface CountryMealsViewInterface {

    public void showDataCountryMeals(ArrayList<CountryMeals> countryMeals);
    public void showErrorMsgCountryMeals(String error);
    public void addCountryMeals(CountryMeals countryMeals);


}

