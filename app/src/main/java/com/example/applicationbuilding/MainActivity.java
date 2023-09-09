package com.example.applicationbuilding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout textInputLayout;
    private AutoCompleteTextView autoCompleteTextView;

    private ImageButton mapButton;

    private RecyclerView.Adapter adapterTable;
    private RecyclerView recyclerViewTable;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();

        textInputLayout = findViewById(R.id.menu_drop);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        String[] cities = {"Уфа", "Москва", "СПБ"}; //ToDo: Подгузить возможные города

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

    private void initRecyclerView() {
        ArrayList<ItemDomain> itemsArray = new ArrayList<>();

        itemsArray.add(new ItemDomain("цукп цукпацкупук пук пукпу кпукп\n укп укпукп ук пук пукп ",
                "wefwegf `123 d", "23r23r23r", 13123123, "pic1"));

        itemsArray.add(new ItemDomain("цукп цукпацкупук пук пукпу кпукп\n укп укпукп ук пук пукп ",
                "wefwegf `123 d", "23gergerge", 43252133, "pic2"));

        itemsArray.add(new ItemDomain("цукп цукпацкупук пук пукпу кпукп\n укп укпукп ук пук пукп ",
                "wefwegf `123 d", "234g432g4rte", 35241232, "pic1"));

        recyclerViewTable = findViewById(R.id.view_table);
        recyclerViewTable.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));

        adapterTable = new ItemsAdapter(itemsArray);
        recyclerViewTable.setAdapter(adapterTable);


    }
}