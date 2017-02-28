package com.example.user.e_gigi.controlador.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.user.e_gigi.R;
import com.example.user.e_gigi.controlador.fragments.DetProduct;
import com.example.user.e_gigi.tools.Constantes;

/**
 * Created by User on 27/02/2017.
 */

public class ProductsActivity extends AppCompatActivity {

    private String idProduct;

    public static void launch(Activity context, String idProduct) {
        Intent intent = getLaunchIntent(context,idProduct);
        context.startActivityForResult(intent, Constantes.CODIGO_DETALLE);
    }

    public static Intent getLaunchIntent(Context context, String idProduct){
        Intent intent = new Intent(context, ProductsActivity.class);
        intent.putExtra(Constantes.EXTRA_ID,idProduct);
        return intent;
    }
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow);
        }
             if(getIntent().getStringExtra(Constantes.EXTRA_ID)!=null)
                 idProduct=getIntent().getStringExtra(Constantes.EXTRA_ID);
        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.pager, DetProduct.createInstance(idProduct),"ProductsDetail")
                    .commit();
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id= item.getItemId();
        switch (id){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}// END