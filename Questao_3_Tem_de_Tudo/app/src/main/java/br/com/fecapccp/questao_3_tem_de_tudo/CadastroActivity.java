package br.com.fecapccp.questao_3_tem_de_tudo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class CadastroActivity extends AppCompatActivity {

    TextInputEditText setNome;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro);

        setNome = findViewById(R.id.setNome);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(v -> {
            String nome = setNome.getText().toString().trim();

            if (nome.isEmpty()) {
                setNome.setError("Por favor, digite seu nome.");
                return;
            }

            Intent intent = new Intent(CadastroActivity.this, ConfirmacaoActivity.class);
            intent.putExtra("NOME_CLIENTE", nome);
            startActivity(intent);
        });


    }
}