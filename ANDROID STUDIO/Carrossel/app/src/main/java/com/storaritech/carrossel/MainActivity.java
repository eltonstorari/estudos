package com.storaritech.carrossel;



import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ViewPager2 viewPager;
    private CarrosselAdapter carrosselAdapter;
    private List<Integer> images;
    private Handler sliderHandler;
    private int currentPage = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);

        List<Integer> images = Arrays.asList(
                R.drawable.propaganda1,
                R.drawable.propaganda2
        );

        // Configurando o adaptador
        carrosselAdapter = new CarrosselAdapter(this, images);
        viewPager.setAdapter(carrosselAdapter);

        // Iniciar o Handler para troca automática de páginas
        sliderHandler = new Handler(Looper.getMainLooper());
        startAutoSlide();

        // Configura o comportamento de resetar o slide após atingir a última imagem
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                // Reseta o handler toda vez que o usuário troca de página manualmente
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000); // Reseta o delay após rolagem manual
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });
    }


    // Inicia o processo de mudança automática de slides
    private void startAutoSlide() {
        sliderHandler.postDelayed(sliderRunnable, 3000); // Intervalo de 3 segundos para cada slide
    }

    // Runnable que será executado a cada intervalo para mudar a página
    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {

            List<Integer> images = Arrays.asList(
                    R.drawable.propaganda1,
                    R.drawable.propaganda2
            );
            // Se chegou à última página, volta à primeira
            if (currentPage == images.size()) {
                currentPage = 0;
            }
            viewPager.setCurrentItem(currentPage++, true);
            sliderHandler.postDelayed(this, 3000); // Configura o próximo slide para depois de 3 segundos
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        // Pausa o auto slide quando a atividade não está visível
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Retoma o auto slide quando a atividade fica visível novamente
        sliderHandler.postDelayed(sliderRunnable, 3000);
    }
}




