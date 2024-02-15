
package com.example.foodplanner.Chicken.Chicken_View;

import com.example.foodplanner.Chicken_Model.Chicken;

import java.util.ArrayList;
import java.util.List;


public interface ChickenViewInterface {

    public void showDataChicken(ArrayList<Chicken> chicken);
    public void showErrorMsgChicken(String error);
    public void addChicken(Chicken chicken);


}

