package com.example.crud2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button elementOne = findViewById(R.id.elementOne);
        Button elementTwo = findViewById(R.id.elementTwo);
        Button elementThree = findViewById(R.id.elementThree);
        Button elementFour = findViewById(R.id.elementFour);

        elementOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ElementOne();
            }
        });
        elementTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ElementTwo();
            }
        });
        elementThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ElementThree();
            }
        });
        elementFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ElementFour();
            }
        });
        Button btn_open = findViewById(R.id.btn_open);
        Button btn_open2 = findViewById(R.id.btn_open2);
        Button btn_open3 = findViewById(R.id.btn_open3);
        Button btn_open4 = findViewById(R.id.btn_open4);
        btn_open.setOnClickListener(v->
        {
            Intent intent = new Intent(MainActivity.this,RVActivity.class);
            startActivity(intent);
        });

        //Button btn_open2 = findViewById(R.id.btn_open2);
        btn_open2.setOnClickListener(v->
        {
            Intent intent = new Intent(MainActivity.this,RVActivity2.class);
            startActivity(intent);
        });

        btn_open3.setOnClickListener(v->
        {
            Intent intent = new Intent(MainActivity.this,RVActivity3.class);
            startActivity(intent);
        });
        btn_open4.setOnClickListener(v->
        {
            Intent intent = new Intent(MainActivity.this,RVActivity4.class);
            startActivity(intent);
        });

    }
    public void ElementOne(){
        Intent intent = new Intent(this, openElementOne.class);
        startActivity(intent);
    }
    public void ElementTwo(){
        Intent intent = new Intent(this, openElementTwo.class);
        startActivity(intent);
    }
    public void ElementThree(){
        Intent intent = new Intent(this, openElementThree.class);
        startActivity(intent);
    }
    public void ElementFour(){
        Intent intent = new Intent(this, openElementFour.class);
        startActivity(intent);
    }


}