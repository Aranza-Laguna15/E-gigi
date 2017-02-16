package com.example.user.e_gigi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private long lastPress=0;
    private long timeLimit=2000;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(conexionInternet()){
            //Permiso para mantener una conexion externa abierta
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
            setToolbar(); // Añadir la toolbar

            viewPager = (ViewPager)findViewById(R.id.pager);
            viewPager.setAdapter(new TabAdapter(getSupportFragmentManager()));

            //   setupViewPager(viewPager);
            TabLayout tabs = (TabLayout)findViewById(R.id.tabs);
            tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
            tabs.setupWithViewPager(viewPager);

        }else{
            Toast toastBack = Toast.makeText(this, "Sin conexión a internet", Toast.LENGTH_SHORT);
            toastBack.show();
        }



    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
    return super.onOptionsItemSelected(item);

    }
     public void onBackPressed() {
         Toast toastBack = Toast.makeText(this, "Pulse de nuevo para salir.", Toast.LENGTH_SHORT);
         long currentTime = System.currentTimeMillis();

         if (currentTime - lastPress > timeLimit) {
                 toastBack.show();
                 lastPress = currentTime;
             } else {
                 toastBack.cancel();
                 super.onBackPressed();

             }
         }
    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            ab.setHomeAsUpIndicator(R.drawable.ic_logo);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

        public boolean conexionInternet(){
            ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo=cm.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

} //END
