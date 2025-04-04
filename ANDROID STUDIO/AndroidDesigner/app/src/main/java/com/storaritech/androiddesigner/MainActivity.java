package com.storaritech.androiddesigner;

import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements FragmentoVermelho.OnFragmentInteractionListener, FragmentoAzul.OnFragmentInteractionListener, FragmentoVerde.OnFragmentInteractionListener {

    FragmentoAzul fragmentoAzul;
    FragmentoVermelho fragmentoVermelho;
    FragmentoVerde fragmentoVerde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentoAzul = new FragmentoAzul();
        fragmentoVermelho = new FragmentoVermelho();
        fragmentoVerde = new FragmentoVerde();

        getSupportFragmentManager().beginTransaction().add(R.id.conteudoFragmento, fragmentoAzul).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void onClick(View view) {


        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();



        switch(view.getId()){
            case R.id.btn_1:

                transaction.replace(R.id.conteudoFragmento, fragmentoAzul);

                break;

            case R.id.btn_2:

                transaction.replace(R.id.conteudoFragmento, fragmentoVermelho);

                break;


            case R.id.btn_3:

                transaction.replace(R.id.conteudoFragmento, fragmentoVerde);

                break;






        }
        transaction.commit();
    }
}
