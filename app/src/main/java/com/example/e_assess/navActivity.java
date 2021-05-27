package com.example.e_assess;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Set;

public class navActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    TextView textView;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_nav);

        // for geting mail if user login
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.textView);
        Intent intent = getIntent();
        String mailid = intent.getStringExtra(LoginActivity.EXTRA_NAME);
        navUsername.setText(mailid);

        // for geting mail if user register for 1st time
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerVw = navigationView.getHeaderView(0);
        TextView navUsrname = (TextView) headerVw.findViewById(R.id.textView);
        Intent intnt = getIntent();
        String mail = intnt.getStringExtra(RegisterActivity.EXTRA_NAME);
        navUsrname.setText(mail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);

        // Log out option
        NavigationView naviview = findViewById(R.id.nav_view);
        naviview.getMenu().findItem(R.id.log_out).setOnMenuItemClickListener(menuItem -> {
            logout();
            return true;
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(navActivity.this, choiceActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity3, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void feedbackAct(MenuItem item) {
        startActivity(new Intent(navActivity.this, SettingAct.class));
    }


    //public void logoutMethod(){
    //    Toast.makeText(this, "Logout button clicked!!", Toast.LENGTH_SHORT).show();
  //  }
}