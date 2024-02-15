
package com.example.foodplanner.AllCategory.AllCategory_View;

import com.example.foodplanner.AllCategory.AllCategory_Model.AllCategory;

import java.util.List;

public interface AllCategoryViewInterface {
    public void showData(List<AllCategory> categories);
    public void showErrorMsg(String error);
    public void addProduct(AllCategory allCategory);

}
