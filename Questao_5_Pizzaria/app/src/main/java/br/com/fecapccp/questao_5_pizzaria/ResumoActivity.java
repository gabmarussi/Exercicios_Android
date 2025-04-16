package br.com.fecapccp.questao_5_pizzaria;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResumoActivity extends AppCompatActivity {

    TextView txtResumo;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumo);

        txtResumo = findViewById(R.id.txtResumo);
        btnVoltar = findViewById(R.id.btnVoltar);

        ArrayList<String> sabores = getIntent().getStringArrayListExtra("sabores");
        String tamanho = getIntent().getStringExtra("tamanho");
        String pagamento = getIntent().getStringExtra("pagamento");
        int valor = getIntent().getIntExtra("valor", 0);

        String resumo = "Resumo do Pedido:\n\n";
        resumo += "Sabores: " + sabores + "\n";
        resumo += "Tamanho: " + tamanho + "\n";
        resumo += "Pagamento: " + pagamento + "\n";
        resumo += "Valor Total: R$" + valor;

        txtResumo.setText(resumo);

        btnVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(ResumoActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}