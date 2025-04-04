package com.storaritech.recyclerview;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        FragmentoLista.OnFragmentInteractionListener, FragmentDetalhes.OnFragmentInteractionListener,
        IcomunicaFragments
{

    ArrayList<Itens>ListaDados;
    RecyclerView recycler;
    Activity activity;
    IcomunicaFragments interfaceComunFrag;

    FragmentoLista  listaFragmentos;
    FragmentDetalhes detalhesitensFrag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaFragmentos = new FragmentoLista();


        getSupportFragmentManager().beginTransaction().replace(R.id.conteudoFragmento, listaFragmentos).commit();

        //construirRecycler();


        }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void enviarItens(Itens itens) {
        detalhesitensFrag = new FragmentDetalhes();
        Bundle bundle = new Bundle();
        bundle.putSerializable("objeto", itens);
        detalhesitensFrag.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.conteudoFragmento, detalhesitensFrag).addToBackStack(null).commit();
    }

    /*private void chamarItens() {
        ListaDados.add(new Itens(
                "Paula",
                "Descrição do Texto",
                R.drawable.img_pequena_pygame, "Desc",
                R.drawable.img_pequena_pygame));

        ListaDados.add(new Itens(
                "Marcia",
                "Descrição do Texto",
                R.drawable.img_pequena_revit, "Desc",
                R.drawable.img_pequena_revit));

        ListaDados.add(new Itens(
                "Pedro",
                "Descrição do Texto",
                R.drawable.img_pequena_after, "Desc",
                R.drawable.img_pequena_after));
        }


    public void onClick(View view) {

        switch (view.getId()){
            case  R.id.btnList:
                Utilidades.VISUALIZACAO = Utilidades.LIST;
                break;

            case  R.id.btnGrid:
                Utilidades.VISUALIZACAO = Utilidades.GRID;
                break;
        }


        construirRecycler();
    }

    private void construirRecycler() {


        ListaDados = new ArrayList<>();

        recycler = findViewById(R.id.recyclerId);
        //recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        if (Utilidades.VISUALIZACAO == Utilidades.LIST){
            recycler.setLayoutManager(new LinearLayoutManager(this));
        }
        else if(Utilidades.VISUALIZACAO == Utilidades.GRID){
            recycler.setLayoutManager(new GridLayoutManager(this,2 ));
        }




        chamarItens();




        /*for (int i=0; i<=50; i++){
            ListaDados.add("Dado "+ i +" ");
        }*/ /*

        AdapterDados adapter = new AdapterDados(ListaDados);

        adapter.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Selecionou " + ListaDados.get(recycler.getChildAdapterPosition(view))
                        .getTitulo(),
                        Toast.LENGTH_LONG).show();



            }
        });
        recycler.setAdapter(adapter);

    }*/
}

