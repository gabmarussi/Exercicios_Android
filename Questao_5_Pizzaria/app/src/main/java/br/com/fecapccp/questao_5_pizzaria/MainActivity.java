package br.com.fecapccp.questao_5_pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CheckBox checkCalabresa, checkMarguerita, checkPortuguesa;
    Button btnProximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        checkCalabresa = findViewById(R.id.checkCalabresa);
        checkMarguerita = findViewById(R.id.checkMarguerita);
        checkPortuguesa = findViewById(R.id.checkPortuguesa);
        btnProximo = findViewById(R.id.btnProximo);

        btnProximo.setOnClickListener(v -> {
            ArrayList<String> saboresSelecionados = new ArrayList<>();

            if (checkCalabresa.isChecked()) saboresSelecionados.add("Calabresa");
            if (checkMarguerita.isChecked()) saboresSelecionados.add("Marguerita");
            if (checkPortuguesa.isChecked()) saboresSelecionados.add("Portuguesa");

            Intent intent = new Intent(MainActivity.this, TamanhoPagamentoActivity.class);
            intent.putStringArrayListExtra("sabores", saboresSelecionados);
            startActivity(intent);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}