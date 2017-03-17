package com.sunil.examplesofandroid2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] country = {"India", "Usa", "China", "England", "Japan", "Other",};
    String[] name = {"sunil", "mewada", "vivek", "sai", "shri"};
    String[] year2 = {"2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018"};
    String[] subject={"Maths","Physics","Chemistry","Android","Ios","Java"};
    String[] language={"c","c++","java",".net","iPhone","Android","Asp.Net","Php"};
    private Spinner spinner1, spinner2, spinner3,spinner4;
    private Button btnSubmit;
    RatingBar R1;
    Button RatingBarCount;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        R1 = (RatingBar)findViewById(R.id.ratingBar);
        RatingBarCount = (Button)findViewById(R.id.button);

        RatingBarCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rating = String.valueOf(R1.getRating());
                Toast.makeText(getApplicationContext(),rating,Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,language);
        AutoCompleteTextView actv = (AutoCompleteTextView)findViewById(R.id.actView);
        actv.setThreshold(1);
        actv.setAdapter(adapter);
        actv.setTextColor(Color.RED);

        addListenerOnButton();
        addListenerOnSpinnerItemSelection();

    }

    private void addListenerOnSpinnerItemSelection() {
        spinner1= (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter array = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(array);

        spinner2=(Spinner)findViewById(R.id.spinner2);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,name);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);

        spinner3=(Spinner)findViewById(R.id.spinner3);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,year2);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(aa);

        spinner4=(Spinner)findViewById(R.id.spinner4);
        ArrayAdapter arr = new ArrayAdapter(this,android.R.layout.simple_spinner_item,subject);
        arr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(arr);
    }

    private void addListenerOnButton() {
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner3 = (Spinner)findViewById(R.id.spinner3);
        spinner4 = (Spinner)findViewById(R.id.spinner4);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"OnClickListener : " + "\nSpinner 1 :" +  String.valueOf(spinner1.getSelectedItem()) + "\n Spinner 2 :" + String.valueOf(spinner2.getSelectedItem()) + "\n Spinner 3 : "+ String.valueOf(spinner3.getSelectedItem())
                        + "\nSpinner 4 : " + String.valueOf(spinner4.getSelectedItem()),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}