package com.example.expandablerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    VersionAdapter versionAdapter;
    List<Model> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);

        prepareData();

        setRecyclerView();
    }

    private void setRecyclerView() {
        versionAdapter = new VersionAdapter(modelList);
        recyclerView.setAdapter(versionAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void prepareData() {
        modelList = new ArrayList<>();

        Model model = new Model("Android 10","Version 10.0",
                "api Level 29","I love Android 10.0");
        modelList.add(model);

        model = new Model("Pie","Version 9.0",
                "api Level 28","I love Android 9.0");
        modelList.add(model);

        model = new Model("Oreo","Version 8.0",
                "api Level 27","I love android 8.0");
        modelList.add(model);

        model = new Model("Nougat","Version 7.0",
                "api Level 24","I love android 7.0");
        modelList.add(model);

        model = new Model("Marshmallow","Version 6.0",
                "api Level 23","I love android 6.0");
        modelList.add(model);

        model = new Model("Lollipop","Version 5.0",
                "api Level 21","I love android 5.0");
        modelList.add(model);

        model = new Model("Kit Kat","Version 4.4",
                "api Level 19","I love android 4.4");
        modelList.add(model);

    }
}