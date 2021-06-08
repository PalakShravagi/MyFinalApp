package com.example.e_assess;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class navActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    TextView textView;
    NavigationView navigationView;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;
    TextView txt1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_nav);

        // for gettig mail of user
        user = FirebaseAuth.getInstance().getCurrentUser();
        String mailid = user.getEmail().toString();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        txt1 = (TextView) headerView.findViewById(R.id.textView);
        txt1.setText(mailid);


       // reference = FirebaseDatabase.getInstance().getReference("Users");
       // userID = user.getUid();

       // String mailll = reference.

       /* reference.child(userID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Map<String, Object> td = (HashMap<String, Object>) snapshot.getValue();
                if (td==null)return;
                String code = td.get("code").toString() ;
                Toast.makeText(navActivity.this, "hii " + code, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
*/
        // Log out option
        NavigationView naviview = findViewById(R.id.nav_view);
        naviview.getMenu().findItem(R.id.log_out).setOnMenuItemClickListener(menuItem -> {
            logout();
            return true;
        });
        //fab
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // FloatingActionButton fab = findViewById(R.id.fab);


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
        startActivity(new Intent(navActivity.this, FeedbackAct.class));
    }


    //public void logoutMethod(){
    //    Toast.makeText(this, "Logout button clicked!!", Toast.LENGTH_SHORT).show();
  //  }
}