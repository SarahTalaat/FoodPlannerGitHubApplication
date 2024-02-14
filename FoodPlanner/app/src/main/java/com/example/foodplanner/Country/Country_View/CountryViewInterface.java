package com.example.foodplanner.Country.Country_View;

import com.example.foodplanner.Country_Model.Country;

import java.util.ArrayList;

public interface CountryViewInterface {

    public void showDataCountry(ArrayList<Country> country);
    public void showErrorMsgCountry(String error);
    public void addCountry(Country country);



}
