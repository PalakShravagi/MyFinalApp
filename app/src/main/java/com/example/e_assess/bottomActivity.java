package com.example.e_assess;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.e_assess.ui.dashboard.AdapterDashboard;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import java.io.File;
import java.io.FileOutputStream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class bottomActivity extends AppCompatActivity {
    private DatabaseReference reference;
    private AdapterDashboard adapter;
    private EditText editTextExcel;
    private File filePath = new File(Environment.getExternalStorageDirectory() + "/Demo.xls");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home_admin, R.id.navigation_dashboard)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


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
            case R.id.download:
               // startActivity(new Intent(bottomActivity.this,ProfileAdmin.class));
                Toast.makeText(this, "downloading !! ", Toast.LENGTH_SHORT).show();
             /*   reference = FirebaseDatabase.getInstance().getReference().child("Marks");

                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //Log.i("value",snapshot.getValue().toString());
                        for(DataSnapshot datas : snapshot.getChildren()){
                            Log.i("parent name",datas.getKey());//gives name of student
                          //  Log.i("innerchild",datas.getValue().toString());// whole object i.e : ISE1,ISE2,ESE,MSE
                            for(DataSnapshot data : datas.getChildren()){
                          //      Log.i("student name",datas.getKey());
                                Log.i("exaam name",data.getKey());
                                Log.i("data",data.child("Total").getValue().toString());
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
*/
                   callexcel();





                return true;
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

    private void callexcel() {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("Custom Sheet");


        HSSFRow hssfRow = hssfSheet.createRow(0);
        HSSFCell hssfCell = hssfRow.createCell(0);


        hssfCell.setCellValue(editTextExcel.getText().toString());


        try {
            if (!filePath.exists()){
                filePath.createNewFile();
            }


            FileOutputStream fileOutputStream= new FileOutputStream(filePath);
            hssfWorkbook.write(fileOutputStream);


            if (fileOutputStream!=null){
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void fabclick(View view) {
      //  Toast.makeText(this, "hii this is onclick method", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(bottomActivity.this,addStudent.class));
    }
}










