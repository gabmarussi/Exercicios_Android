package br.com.fecapccp.questao_5_pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;

public class TamanhoPagamentoActivity extends AppCompatActivity {

    RadioGroup radioTamanho, radioPagamento;
    Button btnResumo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tamanho_pagamento);

        radioTamanho = findViewById(R.id.radioTamanho);
        radioPagamento = findViewById(R.id.radioPagamento);
        btnResumo = findViewById(R.id.btnResumo);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<String> sabores = getIntent().getStringArrayListExtra("sabores");

        btnResumo.setOnClickListener(v -> {
            int valor = 0;
            String tamanho = "", pagamento = "";

            if (radioTamanho.getCheckedRadioButtonId() == R.id.radioPequena) {
                tamanho = "Pequena";
                valor = 20;
            } else if (radioTamanho.getCheckedRadioButtonId() == R.id.radioMedia) {
                tamanho = "Média";
                valor = 30;
            } else if (radioTamanho.getCheckedRadioButtonId() == R.id.radioGrande) {
                tamanho = "Grande";
                valor = 40;
            }

            if (radioPagamento.getCheckedRadioButtonId() == R.id.radioDinheiro) {
                pagamento = "Dinheiro";
            } else if (radioPagamento.getCheckedRadioButtonId() == R.id.radioCartao) {
                pagamento = "Cartão";
            }

            Intent intent = new Intent(TamanhoPagamentoActivity.this, ResumoActivity.class);
            intent.putStringArrayListExtra("sabores", sabores);
            intent.putExtra("tamanho", tamanho);
            intent.putExtra("pagamento", pagamento);
            intent.putExtra("valor", valor);
            startActivity(intent);
        });
    }
}
