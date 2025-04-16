package br.com.fecapccp.questao_4_lanche_facil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResumoPedidoActivity extends AppCompatActivity {
    private TextView textResumo;
    private Button btnNovoPedido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumo_pedido);

        textResumo = findViewById(R.id.textResumo);
        btnNovoPedido = findViewById(R.id.btnNovoPedido);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        String lanche = intent.getStringExtra("lanche");

        String resumo = nome + ", Obrigado pela Preferência!!\n" + "O seu " + lanche + " está sendo preparado.";
        textResumo.setText(resumo);

        btnNovoPedido.setOnClickListener(v -> {
            Intent voltar = new Intent(this, MainActivity.class);
            startActivity(voltar);
        });
    }
}