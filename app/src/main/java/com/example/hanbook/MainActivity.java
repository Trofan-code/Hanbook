package com.example.hanbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hanbook.settings.SettingsActivity;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Arrays;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    private ListView list;
    private String[] array;
    private ArrayAdapter<String> adapter;
    private  Toolbar toolbar;
    private int category_index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.listView);
        array = getResources().getStringArray(R.array.first_array);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,new ArrayList(Arrays.asList(array)));
        list.setAdapter(adapter);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,Text_Content_Activity.class);
                intent.putExtra("category",category_index);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
         toolbar.setTitle(R.string.name_menu_1);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_settings) {

           Intent i = new Intent(MainActivity.this, SettingsActivity.class);
           startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if(id == R.id.id_menu_first){
            fillArray(R.string.name_menu_1,R.array.first_array,0);
        } else if(id == R.id.id_menu_second){
            fillArray(R.string.name_menu_2,R.array.second_array,1);
        }else if(id == R.id.id_menu_third){
            fillArray(R.string.name_menu_3,R.array.third_array,2);
        }else if(id == R.id.id_menu_fourth){
            fillArray(R.string.name_menu_4,R.array.fourth_array,3);
        }else if(id == R.id.id_menu_fifth){
            fillArray(R.string.name_menu_5,R.array.fifth_array,4);
        }else if(id == R.id.id_menu_sixth) {
            fillArray(R.string.name_menu_6,R.array.sixth_array,5);
        } else if(id == R.id.id_menu_seventh) {
            fillArray(R.string.name_menu_7,R.array.for_example_menu_array,6);
        } else if(id == R.id.id_menu_eighth) {
            fillArray(R.string.name_menu_8,R.array.for_example_menu_array,7);
        } else if(id == R.id.id_menu_ninth) {
            fillArray(R.string.name_menu_9,R.array.for_example_menu_array,8);
        } else if(id == R.id.id_menu_tenth) {
            fillArray(R.string.name_menu_10,R.array.for_example_menu_array,9);
        } else if(id == R.id.id_menu_eleventh) {
            fillArray(R.string.name_menu_11,R.array.for_example_menu_array,10);
        } else if(id == R.id.id_menu_twelfth) {
            fillArray(R.string.name_menu_12,R.array.for_example_menu_array,11);
        } else if(id == R.id.id_menu_thirteenth) {
            fillArray(R.string.name_menu_13,R.array.for_example_menu_array,12);
        } else if(id == R.id.id_menu_fourteenth) {
            fillArray(R.string.name_menu_14,R.array.for_example_menu_array,13);
        } else if(id == R.id.id_menu_fifteenth) {
            fillArray(R.string.name_menu_15,R.array.for_example_menu_array,14);
        } else if(id == R.id.id_menu_sixteenth) {
            fillArray(R.string.name_menu_16,R.array.for_example_menu_array,15);
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void fillArray(int title,int arrayList,int index){
        toolbar.setTitle(title);
        array = getResources().getStringArray(arrayList);
        adapter.clear();
        adapter.addAll(array);
        adapter.notifyDataSetChanged();
        category_index = index;
    }

}

