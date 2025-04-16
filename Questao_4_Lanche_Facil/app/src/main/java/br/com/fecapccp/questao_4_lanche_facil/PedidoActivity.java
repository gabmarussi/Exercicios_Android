package br.com.fecapccp.questao_4_lanche_facil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class PedidoActivity extends AppCompatActivity {

    private TextInputEditText inputNome;
    private RadioGroup groupLanches;
    private Button btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pedido);

        inputNome = findViewById(R.id.inputNome);
        groupLanches = findViewById(R.id.groupLanches);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        btnConfirmar.setOnClickListener(v -> {
            String nome = inputNome.getText().toString();
            int idLanche = groupLanches.getCheckedRadioButtonId();
            if (idLanche != -1 && !nome.isEmpty()) {
                RadioButton lancheSelecionado = findViewById(idLanche);
                String lanche = lancheSelecionado.getText().toString();

                Intent intent = new Intent(this, ResumoPedidoActivity.class);
                intent.putExtra("nome", nome);
                intent.putExtra("lanche", lanche);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Por favor, preencha seu nome e selecione um lanche", Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}