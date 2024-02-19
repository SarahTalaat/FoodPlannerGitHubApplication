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

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.foodplanner.FavouriteMealDetails.FavouriteMealDetails_View.FavouriteMealDetails_Fragment;
import com.example.foodplanner.Plan.Plan_View.Plan_Fragment_RecyclerView;
import com.example.foodplanner.Search.Search_View.Search_Fragment;
import com.google.android.material.navigation.NavigationView;

public class NavigationDrawer_Activity extends AppCompatActivity {
    public static final String TAG = "TEAM1";


    String receivedNameFromSignIn , receivedEmailFromSignIn , receivedUsernameFromSignIn , receivedPasswordFromSignIn, receivedIdFromSignIn;

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    Menu menu;
    MenuItem menuItem;

    int itemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        Intent intent = getIntent();
        receivedNameFromSignIn = intent.getStringExtra("name");
        receivedEmailFromSignIn = intent.getStringExtra("email");
        receivedUsernameFromSignIn=intent.getStringExtra("username");
        receivedPasswordFromSignIn = intent.getStringExtra("password");
        receivedIdFromSignIn=intent.getStringExtra("id");


        Bundle profileBundle = new Bundle();

        profileBundle.putString("name",receivedNameFromSignIn);
        profileBundle.putString("email",receivedEmailFromSignIn);
        profileBundle.putString("username",receivedUsernameFromSignIn);
        profileBundle.putString("password", receivedPasswordFromSignIn);
        profileBundle.putString("id",receivedIdFromSignIn);

        Profile_Fragment profile_fragment=new Profile_Fragment();
        profile_fragment.setArguments(profileBundle);


/*

        // Create a bundle and put data in it
        Bundle bundleProfile = new Bundle();
        bundleProfile.putString("name", receivedNameFromSignIn);
        bundleProfile.putString("email",receivedEmailFromSignIn);
        bundleProfile.putString("username",receivedUsernameFromSignIn);
        bundleProfile.putString("password",receivedPasswordFromSignIn);
        bundleProfile.putString("id",receivedIdFromSignIn);

*/

        /*
        // Create a new fragment instance
        Profile_Fragment profile_fragment = new Profile_Fragment(
                receivedNameFromSignIn,
                receivedEmailFromSignIn,
                receivedUsernameFromSignIn,
                receivedPasswordFromSignIn,
                receivedIdFromSignIn
        );


         */
 //       profile_fragment.setArguments(bundleProfile);





        toolbar=findViewById(R.id.navigation_drawer_toolbar);
        drawerLayout=findViewById(R.id.navigation_drawer_drawer_layout);
        navigationView=findViewById(R.id.navigation_drawer_navigation_view);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.profile_item){
                    fragmentR(new Profile_Fragment(receivedNameFromSignIn,receivedEmailFromSignIn,receivedUsernameFromSignIn,receivedPasswordFromSignIn,receivedIdFromSignIn));
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(NavigationDrawer_Activity.this, "Profile Fragment", Toast.LENGTH_SHORT).show();

                }else if(item.getItemId() == R.id.home_item){
                    fragmentR(new Home_Fragment());
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(NavigationDrawer_Activity.this, "Home Fragment", Toast.LENGTH_SHORT).show();

                }else if(item.getItemId() == R.id.favourites_item){
                    fragmentR(new FavouriteMealDetails_Fragment());
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(NavigationDrawer_Activity.this, "Favourite Fragment", Toast.LENGTH_SHORT).show();

                }else if(item.getItemId() == R.id.search_item){
                    fragmentR(new Search_Fragment());
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(NavigationDrawer_Activity.this, "IngredientDTO Fragment", Toast.LENGTH_SHORT).show();

                }else if(item.getItemId() == R.id.current_week_item) {
                    fragmentR(new Plan_Fragment_RecyclerView());
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(NavigationDrawer_Activity.this, "Current Week Fragment", Toast.LENGTH_SHORT).show();

                }else if(item.getItemId() == R.id.logout_item) {
                    fragmentR(new Logout_Fragment());
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(NavigationDrawer_Activity.this, "Logout Fragment", Toast.LENGTH_SHORT).show();

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

}
