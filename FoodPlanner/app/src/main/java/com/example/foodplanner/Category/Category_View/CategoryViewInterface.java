
package com.example.foodplanner.Category.Category_View;

import com.example.foodplanner.Category_Model.Category;

import java.util.List;

public interface CategoryViewInterface {
    public void showData(List<Category> categories);
    public void showErrorMsg(String error);
    public void addProduct(Category category);
}
