
package com.example.foodplanner.Chicken_Search.Chicken_View;

import com.example.foodplanner.Chicken_Search.Chicken_Model.Chicken;

import java.util.ArrayList;


public interface ChickenViewInterface {

    public void showDataChicken(ArrayList<Chicken> chicken);
    public void showErrorMsgChicken(String error);
    public void addChicken(Chicken chicken);


}

