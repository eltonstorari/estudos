package com.storaritech.testes.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.storaritech.testes.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        final RadioGroup radioGroup = binding.radioGroup;
        final Button btnMsg = binding.btnMsg;
        final RadioButton[] radioButton = new RadioButton[1];

        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Toast.makeText(getContext(), "" + checkedId, Toast.LENGTH_SHORT).show();
            }
        });


        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Obter o ID do botão de rádio selecionado
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // Verificar se uma opção foi selecionada
                if (selectedId != -1) {


                    radioButton[0] = radioButton[0].findViewById(selectedId);
                    String opcaoSelecionada = radioButton[0].getText().toString();
                    textView.setText("Opção selecionada: " + opcaoSelecionada);
                } else {
                    textView.setText("Selecione uma opção");
                }


            }


        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}