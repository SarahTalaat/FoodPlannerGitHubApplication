
package com.example.foodplanner.Fish.Fish_View;

import com.example.foodplanner.Fish_Model.Fish;

import java.util.ArrayList;
import java.util.List;


public interface FishViewInterface {

    public void showDataFish(ArrayList<Fish> fish);
    public void showErrorMsgFish(String error);
    public void addFish(Fish fish);


}

