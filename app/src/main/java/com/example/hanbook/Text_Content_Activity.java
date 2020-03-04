package com.example.hanbook;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Text_Content_Activity extends AppCompatActivity {
    private TextView text_content;
    private Typeface face1;
    private ImageView imContent;
    private SharedPreferences def_pref;
    private ActionBar actionBar;
    private int category=0;
    private int position=0;
    private int [] array_menu_1_text = {R.string.menu_1_text_1,R.string.menu_1_text_2,R.string.menu_1_text_3,R.string.menu_1_text_4};
    private int [] array_menu_2_text = {R.string.menu_2_text_1,R.string.menu_2_text_2,R.string.menu_2_text_3,R.string.menu_2_text_4};
    private int [] array_menu_3_text = {R.string.menu_3_text_1,R.string.menu_3_text_2,R.string.menu_3_text_3,R.string.menu_3_text_4};
    private int [] array_menu_4_text = {R.string.menu_4_text_1,R.string.menu_4_text_2};
    private int [] array_menu_5_text = {R.string.menu_5_text_1,R.string.menu_5_text_2,R.string.menu_5_text_3};
    private int [] array_menu_6_text = {R.string.menu_6_text_1,R.string.menu_6_text_2,R.string.menu_6_text_3};
    private int [] array_menu_1_image = {R.drawable.wroclaw,R.drawable.wroclaw,R.drawable.wroclaw,R.drawable.wroclaw};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);

        text_content = findViewById(R.id.text_main_content);
        imContent = findViewById(R.id.imageContent);
        init();
        reciveIntent();
    }

    private void reciveIntent(){
        Intent i = getIntent();
        if(i != null){
            category = i.getIntExtra("category",0);
            position = i.getIntExtra("position",0);
        }
        switch (category){
            case 0:
                imContent.setImageResource(array_menu_1_image[position]);
                text_content.setText(array_menu_1_text[position]);
                actionBar.setTitle(getResources().getStringArray(R.array.first_array)[position]);
                break;
            case 1:
                text_content.setText(array_menu_2_text[position]);
                actionBar.setTitle(getResources().getStringArray(R.array.second_array)[position]);
                break;
            case 2:
                text_content.setText(array_menu_3_text[position]);
                actionBar.setTitle(getResources().getStringArray(R.array.third_array)[position]);
                break;
            case 3:
                text_content.setText(array_menu_4_text[position]);
                actionBar.setTitle(getResources().getStringArray(R.array.fourth_array)[position]);
                break;
            case 4:
                text_content.setText(array_menu_5_text[position]);
                actionBar.setTitle(getResources().getStringArray(R.array.fifth_array)[position]);
                break;
            case 5:
                text_content.setText(array_menu_6_text[position]);
                actionBar.setTitle(getResources().getStringArray(R.array.sixth_array)[position]);

                break;
            case 6:
                text_content.setText(R.string.text_for_example_1);
                actionBar.setTitle(getResources().getStringArray(R.array.for_example_menu_array)[position]);
                break;
            case 7:
                text_content.setText(R.string.text_for_example_2);
                actionBar.setTitle(getResources().getStringArray(R.array.for_example_menu_array)[position]);
                break;
            case 8:
                text_content.setText(R.string.text_for_example_1);
                actionBar.setTitle(getResources().getStringArray(R.array.for_example_menu_array)[position]);
                break;
            case 9:
                text_content.setText(R.string.text_for_example_2);
                actionBar.setTitle(getResources().getStringArray(R.array.for_example_menu_array)[position]);
                break;
            case 10:
                text_content.setText(R.string.text_for_example_1);
                actionBar.setTitle(getResources().getStringArray(R.array.for_example_menu_array)[position]);
                break;
            case 11:
                text_content.setText(R.string.text_for_example_2);
                actionBar.setTitle(getResources().getStringArray(R.array.for_example_menu_array)[position]);
                break;
            case 12:
                text_content.setText(R.string.text_for_example_1);
                actionBar.setTitle(getResources().getStringArray(R.array.for_example_menu_array)[position]);
                break;
            case 13:
                text_content.setText(R.string.text_for_example_2);
                actionBar.setTitle(getResources().getStringArray(R.array.for_example_menu_array)[position]);
                break;
            case 14:
                text_content.setText(R.string.text_for_example_1);
                actionBar.setTitle(getResources().getStringArray(R.array.for_example_menu_array)[position]);
                break;
            case 15:
                break;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return true;
    }
    private void init(){
        def_pref = PreferenceManager.getDefaultSharedPreferences(this);
        text_content = findViewById(R.id.text_main_content);
        imContent = findViewById(R.id.imageContent);
        face1 = Typeface.createFromAsset(this.getAssets(),"fonts/PlayfairDisplay-Regular.ttf");
        text_content.setTypeface(face1);
        if(getSupportActionBar() != null){
        actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        }
        String text = def_pref.getString("settings_text_size_key","Średni");

        if(text !=null){
        switch (text){
            case "Duży":
                text_content.setTextSize(24);
                break;
            case "Średni":
                text_content.setTextSize(18);
                break;
            case "Mały":
                text_content.setTextSize(14);
                break;
        }
        }
    }
}
