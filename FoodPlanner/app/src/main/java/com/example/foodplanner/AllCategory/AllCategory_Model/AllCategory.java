/*
package com.example.foodplanner.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "product")
public class AllCategory {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    int id;
    String title;
    String description;
    int price;
    float rating;
    String thumbnail;
    String brand;

    public AllCategory(){

    }


    public AllCategory(int id, String title, String description, int price, float rating, String thumbnail, String brand) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.thumbnail = thumbnail;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
}
*/

package com.example.foodplanner.AllCategory.AllCategory_Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "category")
public class AllCategory {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int idCategory;
    private String strCategory;
    private String strCategoryDescription;
    private String strCategoryThumb;

    /*
    "idCategory": "1",
            "strCategory": "Beef",
            "strCategoryThumb": "https://www.themealdb.com/images/category/beef.png",
            "strCategoryDescription":
     */

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrCategoryDescription() {
        return strCategoryDescription;
    }

    public void setStrCategoryDescription(String strCategoryDescription) {
        this.strCategoryDescription = strCategoryDescription;
    }

    public String getStrCategoryThumb() {
        return strCategoryThumb;
    }

    public void setStrCategoryThumb(String strCategoryThumb) {
        this.strCategoryThumb = strCategoryThumb;
    }

    public AllCategory(int idCategory, String strCategory, String strCategoryDescription, String strCategoryThumb) {
        this.idCategory = idCategory;
        this.strCategory = strCategory;
        this.strCategoryDescription = strCategoryDescription;
        this.strCategoryThumb = strCategoryThumb;
    }


}
