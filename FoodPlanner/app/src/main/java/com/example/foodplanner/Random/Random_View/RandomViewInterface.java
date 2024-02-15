
package com.example.foodplanner.Random.Random_View;

import com.example.foodplanner.Random.Random_Model.Random;

import java.util.ArrayList;


public interface RandomViewInterface {

    public void showDataRandom(ArrayList<Random> random);
    public void showErrorMsgRandom(String error);
    public void addRandom(Random random);


}

