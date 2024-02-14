package com.example.foodplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.NavigationUI;
import com.example.foodplanner.R;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import com.google.android.material.navigation.NavigationView;

public class Main_Activity extends AppCompatActivity {

    public static final String TAG = "TEAM1";

    /*
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
*/

    Button button_skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        button_skip=findViewById(R.id.button_skip);

        button_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main_Activity.this, Authentication_Activity.class));
            }
        });


    }

/*
        toolbar = findViewById(R.id.navigation_drawer_toolbar);
        drawerLayout = findViewById(R.id.navigation_drawer_drawer_layout);
        navigationView = findViewById(R.id.navigation_drawer_navigation_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.profile_item){
                    fragmentR(new Profile_Fragment());
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(Main_Activity.this, "Profile Fragment", Toast.LENGTH_SHORT).show();

                }else if(item.getItemId() == R.id.home_item){
                    fragmentR(new Home_Fragment());
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(Main_Activity.this, "Home Fragment", Toast.LENGTH_SHORT).show();

                }else if(item.getItemId() == R.id.favourites_item){
                    fragmentR(new Favourites_Fragment());
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(Main_Activity.this, "Favourite Fragment", Toast.LENGTH_SHORT).show();

                }else if(item.getItemId() == R.id.search_item){
                    fragmentR(new Search_Fragment());
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(Main_Activity.this, "Search Fragment", Toast.LENGTH_SHORT).show();

                }else if(item.getItemId() == R.id.current_week_item) {
                    fragmentR(new Current_Week_Fragment());
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(Main_Activity.this, "Current Week Fragment", Toast.LENGTH_SHORT).show();

                }else if(item.getItemId() == R.id.logout_item) {
                    fragmentR(new Logout_Fragment());
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(Main_Activity.this, "Logout Fragment", Toast.LENGTH_SHORT).show();

                }else{
                    Log.i(TAG, "No ids ARE FOUNDDDDDDDDDDDDDDDDDDDDDDDDDD");
                }

                return true;
            }
        });
    }

    private void fragmentR(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.navigation_drawer_frame_layout,fragment);
        fragmentTransaction.commit();
    }
*/
}

