package com.example.user.e_gigi.controlador;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.user.e_gigi.controlador.fragments.ECommerce;
import com.example.user.e_gigi.controlador.fragments.FragmentOrders;
import com.example.user.e_gigi.controlador.fragments.FragmentProductos;

/**
 * Created by Aranza on 14/02/2017.
 */

public class TabAdapter extends FragmentPagerAdapter {

   final int PAGE_COUNT = 3;
    boolean fragmentTransaction = false;
    private String tabTitles[] =
            new String[] {"Productos", "E-Commerce","Pedidos"};


    public TabAdapter(FragmentManager fm ) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        switch (position){
           case 0:
                frag= FragmentProductos.newInstance();
                fragmentTransaction = true;
                break;
            case 1:
                frag= ECommerce.newInstance();
                fragmentTransaction = true;
                break;
            case 2:
                frag= FragmentOrders.newInstance();
                fragmentTransaction=true;
                break;
        }
        return frag;
    }
    public CharSequence getPageTitle(int position){
        return tabTitles[position];
    }
}
