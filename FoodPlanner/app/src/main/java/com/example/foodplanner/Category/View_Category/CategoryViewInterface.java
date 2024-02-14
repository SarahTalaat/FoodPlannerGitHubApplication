
package com.example.foodplanner.Category.View_Category;

import com.example.foodplanner.Model_Category.Category;

import java.util.List;

public interface CategoryViewInterface {
    public void showData(List<Category> categories);
    public void showErrorMsg(String error);
    public void addProduct(Category category);
}
