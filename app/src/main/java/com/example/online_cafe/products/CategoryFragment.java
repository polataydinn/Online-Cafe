package com.example.online_cafe.products;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.example.online_cafe.R;
import java.util.ArrayList;
import java.util.List;


public class CategoryFragment extends Fragment {
    private Button fastFoodButton;
    private Button drinkButton;
    private Button dessertButton;
    private Button mealButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fastFoodButton = view.findViewById(R.id.fast_food_button);
        drinkButton = view.findViewById(R.id.drink_button);
        dessertButton = view.findViewById(R.id.dessert_button);
        mealButton = view.findViewById(R.id.meal_button);

        fastFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<ProductData> data = setFastFoodItems();
                startFragment(data);
            }
        });

        drinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<ProductData> data = setDrinkItems();
                startFragment(data);
            }
        });

        dessertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<ProductData> data = setDessertItems();
                startFragment(data);
            }
        });

        mealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<ProductData> data = setMealItems();
                startFragment(data);
            }
        });
    }

    private void startFragment(List<ProductData> data) {
        ProductListFragment fragment = new ProductListFragment(data);
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer,fragment, "FragmentReplaced")
                .addToBackStack(null)
                .commit();

    }


    public List<ProductData> setFastFoodItems(){
        List<ProductData> data = new ArrayList<>();

        data.add(new ProductData(R.drawable.hamburger,"Hamburger",15));
        data.add(new ProductData(R.drawable.pizza,"Pizza",20));
        data.add(new ProductData(R.drawable.french_fries,"Cips",5));
        data.add(new ProductData(R.drawable.sandwich,"Sandaviç",10));
        data.add(new ProductData(R.drawable.toast,"Tost",10));
        data.add(new ProductData(R.drawable.spaghetti,"Spaghetti",12));
        return data;
    }

    private List<ProductData> setDrinkItems() {
        List<ProductData> data = new ArrayList<>();

        data.add(new ProductData(R.drawable.lemonade,"Limonata",5));
        data.add(new ProductData(R.drawable.coke,"Kola",3));
        data.add(new ProductData(R.drawable.smoothi,"Smoothi",8));
        data.add(new ProductData(R.drawable.orange_juice,"Portakal Suyu",8));
        data.add(new ProductData(R.drawable.coffe,"Kahve",5));
        data.add(new ProductData(R.drawable.tea,"Çay",2));
        data.add(new ProductData(R.drawable.buttermilk,"Ayran",3));
        return data;
    }

    private List<ProductData> setDessertItems() {
        List<ProductData> data = new ArrayList<>();

        data.add(new ProductData(R.drawable.apple_pie,"Elmalı Turta",12));
        data.add(new ProductData(R.drawable.ice_cream,"Dondurma",8));
        data.add(new ProductData(R.drawable.cookie,"Kurabiye",4));
        data.add(new ProductData(R.drawable.cheescake,"Cheesecake",15));
        data.add(new ProductData(R.drawable.pudding,"Pudding",8));
        data.add(new ProductData(R.drawable.pancake,"Pancake",10));
        data.add(new ProductData(R.drawable.baklava,"Baklava",7));
        return data;
    }

    private List<ProductData> setMealItems() {
        List<ProductData> data = new ArrayList<>();
        return data;
    }
}