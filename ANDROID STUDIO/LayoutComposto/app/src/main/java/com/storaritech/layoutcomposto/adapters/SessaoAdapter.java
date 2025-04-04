package com.storaritech.layoutcomposto.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SessaoAdapter  extends FragmentStatePagerAdapter{


    private final List <Fragment> listaFragmentos = new ArrayList<>();
    private final List <String> listaTitulos = new ArrayList<>();

    public void addFragment(Fragment fragment, String titulo){
        listaFragmentos.add(fragment);
        listaTitulos.add(titulo);
    }


    public SessaoAdapter(FragmentManager fm) {
        super(fm);
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listaTitulos.get(position);
}

    @Override
    public Fragment getItem(int position) {
        return listaFragmentos.get(position);
    }

    @Override
    public int getCount() {
        return listaFragmentos.size();
    }
}
