package com.storaritech.layoutcomposto.Fragmentos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.storaritech.layoutcomposto.Classes.Utilidades;
import com.storaritech.layoutcomposto.R;
import com.storaritech.layoutcomposto.adapters.SessaoAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ConteudoFragmentos.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ConteudoFragmentos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConteudoFragmentos extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private AppBarLayout appBar;
    private TabLayout janelas;
    private ViewPager viewPager;
    View vista;

    private OnFragmentInteractionListener mListener;

    public ConteudoFragmentos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConteudoFragmentos.
     */
    // TODO: Rename and change types and number of parameters
    public static ConteudoFragmentos newInstance(String param1, String param2) {
        ConteudoFragmentos fragment = new ConteudoFragmentos();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (Utilidades.rotacao == 0) {
            appBar.removeView(janelas);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_conteudo_fragmentos, container, false);

        if (Utilidades.rotacao == 0 ) {


        View parent = (View) container.getParent();
        if (appBar==null) {
            appBar = parent.findViewById(R.id.appBar);
            janelas = new TabLayout(getActivity());
            appBar.addView(janelas);

            viewPager = vista.findViewById(R.id.viewPageInfo);
            gerarViewPage(viewPager);

            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {

                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
            janelas.setupWithViewPager(viewPager);
        }

        janelas.setTabGravity(TabLayout.GRAVITY_FILL);
        }else {
            Utilidades.rotacao = 1;
         }

        return vista;
    }

    private void gerarViewPage(ViewPager viewPager) {
        SessaoAdapter adapter = new SessaoAdapter(getFragmentManager());
        adapter.addFragment(new FragAzul(), "Azul");
        adapter.addFragment(new FragVermelho(), "Vermelho");
        adapter.addFragment(new FragVerde(), "Verde");

        viewPager.setAdapter(adapter);


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
