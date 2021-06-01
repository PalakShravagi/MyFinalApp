package com.example.e_assess;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.e_assess.ui.dashboard.DashboardFragment;
import com.example.e_assess.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class bottomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);




        ///

    }



   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_for_admin,menu);
       return true;
   }


   @Override
   public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.Feedback:
                 startActivity(new Intent(bottomActivity.this,FeedbackAdmin.class));
                return true;
            case R.id.Logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(bottomActivity.this, choiceActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
                finish();
                return true;
            case R.id.Profile:
                startActivity(new Intent(bottomActivity.this,ProfileAdmin.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

   }

}










