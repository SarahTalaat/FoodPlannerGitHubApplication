package com.example.foodplanner.Search.Search_View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
//
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodplanner.AllCategory.AllCategory_Model.AllCategory;
import com.example.foodplanner.AllCountry.AllCountry_Model.Country;
import com.example.foodplanner.CategoryMeals.CategoryMeals_Model.CategoryMeals;
import com.example.foodplanner.CountryMeals.CountryMeals_Model.CountryMeals;
import com.example.foodplanner.R;
import com.example.foodplanner.Search.Search_Model.IngredientDTO;
import com.example.foodplanner.Search.Search_Model.Meals;
import com.example.foodplanner.Search.Search_Presenter.SearchPresenterImplementation;
import com.example.foodplanner.Search.Search_Presenter.SearchPresenterInterface;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;

public class Search_Fragment extends Fragment implements  SearchViewInterface {


    Button button_name;
    SearchCategoryMealsAdapter searchCategoryMealsAdapter;
    SearchCountryMealsAdapter searchCountryMealsAdapter;
    SearchMealsAdapter searchMealsAdapter;



    private RecyclerView recycleView;
    private EditText seachBar;
    private Button areaBtn, cateBtn, ingrBtn;
    private ChipGroup chipGroup;
    private SearchPresenterInterface presenter;
    private boolean isAreaBtnClicked = false;
    private boolean isCateBtnClicked = false;
    private boolean isIngrBtnClicked = false;
    private boolean isNameBtnSelected = false;
    private ArrayList<AllCategory> categories;
    private ArrayList<Country> areas;
    private List<IngredientDTO> ingredients;
    LinearLayoutManager manager;



    public Search_Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        seachBar = view.findViewById(R.id.et_search);
        areaBtn = view.findViewById(R.id.button_country_search);
        cateBtn = view.findViewById(R.id.button_category_search);
        ingrBtn = view.findViewById(R.id.button_ingredient_search);
        button_name = view.findViewById(R.id.button_name_search);
        chipGroup  = view.findViewById(R.id.chipGroup_search);
        recycleView = view.findViewById(R.id.rv_search);

        manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recycleView.setLayoutManager(manager);
        searchCategoryMealsAdapter = new SearchCategoryMealsAdapter(getContext());
        recycleView.setAdapter(searchCategoryMealsAdapter);

        presenter = new SearchPresenterImplementation( this);
        editSearchBar();

        areas = new ArrayList<>();
        categories = new ArrayList<>();
        ingredients = new ArrayList<>();

        areaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isIngrBtnClicked = false;
                isCateBtnClicked = false;
                isNameBtnSelected = false;
                showMeals(new ArrayList<>());
                chipGroup.removeAllViews();
                if(!isAreaBtnClicked){
                    areaBtn.setBackgroundColor(getResources().getColor(R.color.orange_2));
                    cateBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                    ingrBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                    button_name.setBackgroundColor(getResources().getColor(R.color.grey));
                    if(areas.isEmpty()){
                        seachBar.setEnabled(false);
                        presenter.getCountries();
                    }
                }
                else
                    areaBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                isAreaBtnClicked = !isAreaBtnClicked;
            }
        });
        cateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isIngrBtnClicked = false;
                isAreaBtnClicked = false;
                isNameBtnSelected=false;
                showMeals(new ArrayList<>());
                chipGroup.removeAllViews();
                if(!isCateBtnClicked) {
                    areaBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                    cateBtn.setBackgroundColor(getResources().getColor(R.color.orange_2));
                    ingrBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                    button_name.setBackgroundColor(getResources().getColor(R.color.grey));
                    if(categories.isEmpty()){
                        seachBar.setEnabled(false);
                        presenter.getCategories();
                    }
                }
                else
                    cateBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                isCateBtnClicked = !isCateBtnClicked;
            }
        });
        ingrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAreaBtnClicked = false;
                isCateBtnClicked = false;
                isNameBtnSelected = false;
                showMeals(new ArrayList<>());
                chipGroup.removeAllViews();
                if(!isIngrBtnClicked) {
                    areaBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                    cateBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                    ingrBtn.setBackgroundColor(getResources().getColor(R.color.orange_2));
                    button_name.setBackgroundColor(getResources().getColor(R.color.grey));
                    if(ingredients.isEmpty()){
                        seachBar.setEnabled(false);
                        presenter.getIngredients();
                    }
                }
                else
                    ingrBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                isIngrBtnClicked = !isIngrBtnClicked;
            }
        });

        button_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAreaBtnClicked = false;
                isCateBtnClicked = false;
                isIngrBtnClicked = false;
                showMeals(new ArrayList<>());
                chipGroup.removeAllViews();
                if(!isNameBtnSelected) {
                    areaBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                    cateBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                    ingrBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                    button_name.setBackgroundColor(getResources().getColor(R.color.orange_2));

                }
                else
                    button_name.setBackgroundColor(getResources().getColor(R.color.grey));
                    isNameBtnSelected = !isNameBtnSelected;
            }
        });
    }

    private void editSearchBar(){
        seachBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                chipGroup.removeAllViews();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(isAreaBtnClicked){
                    Observable.create(emitter -> emitter.onNext(s))
                            .map(i -> i.toString().toLowerCase())
                            .debounce(1, TimeUnit.SECONDS)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(item -> {
                                List<String> filteredAreas = areas.stream()
                                        .map(i -> i.getStrArea())
                                        .filter(name -> name.toLowerCase().startsWith(item)||name.toLowerCase().contains(item))
                                        .collect(Collectors.toList());
                                showChips(filteredAreas);
                            });
                }
                else if (isCateBtnClicked){
                    Observable.create(emitter -> emitter.onNext(s))
                            .map(i -> i.toString().toLowerCase())
                            .debounce(1, TimeUnit.SECONDS)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(item -> {
                                List<String> filteredAreas = categories.stream()
                                        .map(i -> i.getStrCategory())
                                        .filter(name -> name.toLowerCase().startsWith(item)||name.toLowerCase().contains(item))
                                        .collect(Collectors.toList());
                                showChips(filteredAreas);
                            });
                }
                else if(isIngrBtnClicked){
                    Observable.create(emitter -> emitter.onNext(s))
                            .map(i -> i.toString().toLowerCase())
                            .debounce(1, TimeUnit.SECONDS)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(item -> {
                                List<String> filteredAreas = ingredients.stream()
                                        .map(i -> i.getName())
                                        .filter(name -> name.toLowerCase().startsWith(item)||name.toLowerCase().contains(item))
                                        .collect(Collectors.toList());
                                showChips(filteredAreas);
                            });
                }
                else {
                    presenter.getMealsByName(s.toString().toLowerCase());
                }
            }
        });
    }

    private void showChips(List<String> names) {
        chipGroup.removeAllViews();
        if(names.isEmpty())
            showMessage("NO MATCH");
        else {
            for (String name : names) {
                Chip chip = new Chip(getContext());
                chip.setText(name);
                chip.setCheckable(true);
                chip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            chipGroup.clearCheck();
                            chip.setChecked(true);

                            if (isAreaBtnClicked)
                                presenter.getCountriesMeals(name);
                            else if (isCateBtnClicked)
                                presenter.getCategoriesMeals(name);
                            else if (isIngrBtnClicked)
                                presenter.getIngredientsMeals(name);

                        } else {
                            showMeals(new ArrayList<>());
                        }
                    }
                });
                chipGroup.addView(chip);
            }
        }
    }


    @Override
    public void showCountries(ArrayList<Country> allCountryArrayList) {
        areas = allCountryArrayList;
        seachBar.setEnabled(true);
    }

    @Override
    public void showCategories(ArrayList<AllCategory> categoriesArrayList) {
        categories=categoriesArrayList;
        seachBar.setEnabled(true);
    }

    @Override
    public void showIngredient(List<IngredientDTO> ingredientList) {
        ingredients=ingredientList;
        seachBar.setEnabled(true);
    }

    @Override
    public void showCountriesMeals(ArrayList<CountryMeals> allCountryMealsArrayList) {
        searchCountryMealsAdapter = new SearchCountryMealsAdapter(getContext());
        searchCountryMealsAdapter.setCountryMealsList(allCountryMealsArrayList);
        recycleView.setAdapter(searchCountryMealsAdapter);
    }

    @Override
    public void showCategoriesMeals(ArrayList<CategoryMeals> categoriesMealsArrayList) {
        searchCategoryMealsAdapter=new SearchCategoryMealsAdapter(getContext());
        searchCategoryMealsAdapter.setCategoryMealsList(categoriesMealsArrayList);
        recycleView.setAdapter(searchCategoryMealsAdapter);
    }

    @Override
    public void showMeals(List<Meals> mealsList) {
        searchMealsAdapter=new SearchMealsAdapter(getContext());
        searchMealsAdapter.setMealsList(mealsList);
        recycleView.setAdapter(searchMealsAdapter);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }
}


