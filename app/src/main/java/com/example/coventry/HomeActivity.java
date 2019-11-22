package com.example.coventry;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.coventry.Aboutus.AboutFrag;
import com.example.coventry.AddStudent.AddStudentFrag;
import com.example.coventry.Home.HomeFrag;
import com.example.coventry.Model.Students;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    public static List<Students> studentsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListner);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFrag()).commit();


        studentsList = new ArrayList<>();

        studentsList.add(new Students("Santosh Maharjan","Lalitpur","Male",24,R.drawable.boy));
        studentsList.add(new Students("Urusha Prajapati","Bhaktapur","Female",23,R.drawable.girl));


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectFragment = null;
                    switch (item.getItemId()){

                        case R.id.nav_home:
                            selectFragment = new HomeFrag();
                            break;
                        case R.id.nav_add:
                            selectFragment = new AddStudentFrag();
                            break;
                        case R.id.nav_about:
                            selectFragment = new AboutFrag();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectFragment).commit();
                    return true;
                }
            };
}


