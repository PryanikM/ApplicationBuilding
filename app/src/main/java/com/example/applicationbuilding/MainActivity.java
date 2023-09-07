package com.example.applicationbuilding;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout textInputLayout;
    private AutoCompleteTextView autoCompleteTextView;

    private ImageButton mapButton;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputLayout = findViewById(R.id.menu_drop);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        String [] cities = {"Уфа", "Москва", "СПБ"}; //ToDo: Подгузить возможные города

        ArrayAdapter<String> citiesAdapter = new ArrayAdapter<>(MainActivity.this,
                R.layout.drop_down_item, cities);

        autoCompleteTextView.setText(citiesAdapter.getItem(0).toString(), false);

        autoCompleteTextView.setAdapter(citiesAdapter);


        //Кнопка подгрузки карты
        mapButton = findViewById(R.id.map_button);
        mapButton.setOnClickListener(view -> {
            //ToDo: Сделать действие на кнопку старта.
            startActivity(new Intent(MainActivity.this, MapsActivity.class));

        });


    }
}