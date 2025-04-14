package br.com.fecapccp.questao_3_tem_de_tudo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfirmacaoActivity extends AppCompatActivity {

    TextView textMensagem;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_confirmacao);

        textMensagem = findViewById(R.id.textMensagem);
        btnVoltar = findViewById(R.id.btnVoltar);

        String nome = getIntent().getStringExtra("NOME_CLIENTE");
        textMensagem.setText("Seja Bem-vindo, " + nome + "!!! \n\n Seu cadastro foi efetuado com sucesso.");

        btnVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(ConfirmacaoActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}