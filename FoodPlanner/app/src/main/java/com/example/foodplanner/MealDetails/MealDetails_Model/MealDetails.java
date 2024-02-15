package com.example.foodplanner.MealDetails.MealDetails_Model;

public class MealDetails {

    private String idMeal;
    private String strMeal;
    private String strDrinkAlternate;
    private String strCategory;
    private String strArea;
    private String strInstructions;
    private String strMealThumb;
    private String strTags;
    private String strYoutube;
    private String strIngredient1;
    private String strMeasure1;
    private String strSource;
    private String strImageSource;
    private String strCreativeCommonsConfirmed;
    private String dateModified;


    public MealDetails(){
        
    }

    public MealDetails(String idMeal, String strMeal, String strDrinkAlternate, String strCategory, String strArea, String strInstructions, String strMealThumb, String strTags, String strYoutube, String strIngredient1, String strMeasure1, String strSource, String strImageSource, String strCreativeCommonsConfirmed, String dateModified) {
        this.idMeal = idMeal;
        this.strMeal = strMeal;
        this.strDrinkAlternate = strDrinkAlternate;
        this.strCategory = strCategory;
        this.strArea = strArea;
        this.strInstructions = strInstructions;
        this.strMealThumb = strMealThumb;
        this.strTags = strTags;
        this.strYoutube = strYoutube;
        this.strIngredient1 = strIngredient1;
        this.strMeasure1 = strMeasure1;
        this.strSource = strSource;
        this.strImageSource = strImageSource;
        this.strCreativeCommonsConfirmed = strCreativeCommonsConfirmed;
        this.dateModified = dateModified;
    }

    public String getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(String idMeal) {
        this.idMeal = idMeal;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrDrinkAlternate() {
        return strDrinkAlternate;
    }

    public void setStrDrinkAlternate(String strDrinkAlternate) {
        this.strDrinkAlternate = strDrinkAlternate;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrArea() {
        return strArea;
    }

    public void setStrArea(String strArea) {
        this.strArea = strArea;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public String getStrTags() {
        return strTags;
    }

    public void setStrTags(String strTags) {
        this.strTags = strTags;
    }

    public String getStrYoutube() {
        return strYoutube;
    }

    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }

    public String getStrIngredient1() {
        return strIngredient1;
    }

    public void setStrIngredient1(String strIngredient1) {
        this.strIngredient1 = strIngredient1;
    }

    public String getStrMeasure1() {
        return strMeasure1;
    }

    public void setStrMeasure1(String strMeasure1) {
        this.strMeasure1 = strMeasure1;
    }

    public String getStrSource() {
        return strSource;
    }

    public void setStrSource(String strSource) {
        this.strSource = strSource;
    }

    public String getStrImageSource() {
        return strImageSource;
    }

    public void setStrImageSource(String strImageSource) {
        this.strImageSource = strImageSource;
    }

    public String getStrCreativeCommonsConfirmed() {
        return strCreativeCommonsConfirmed;
    }

    public void setStrCreativeCommonsConfirmed(String strCreativeCommonsConfirmed) {
        this.strCreativeCommonsConfirmed = strCreativeCommonsConfirmed;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }
}
