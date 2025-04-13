package br.com.fecapccp.questao_2_ajustesalarial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textTitulo, resultSalario;
    EditText setSalario;
    RadioGroup rgPercentual;
    RadioButton rb40, rb45, rb50;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textTitulo = findViewById(R.id.textTitulo);
        resultSalario = findViewById(R.id.resultSalario);
        setSalario = findViewById(R.id.setSalario);
        rgPercentual = findViewById(R.id.rgPercentual);
        rb40 = findViewById(R.id.rb40);
        rb45 = findViewById(R.id.rb45);
        rb50 = findViewById(R.id.rb50);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String salarioStr = setSalario.getText().toString();

                if (salarioStr.isEmpty() || rgPercentual.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(MainActivity.this, "Preencha o salário e selecione um percentual.", Toast.LENGTH_SHORT).show();
                    return;
                }

                double salario = Double.parseDouble(salarioStr);
                double percentual = 0;

                int selectedId = rgPercentual.getCheckedRadioButtonId();

                if (selectedId == R.id.rb40) {
                    percentual = 0.40;
                } else if (selectedId == R.id.rb45) {
                    percentual = 0.45;
                } else if (selectedId == R.id.rb50) {
                    percentual = 0.50;
                }

                double novoSalario = salario + (salario * percentual);
                resultSalario.setText(String.format("Salário Reajustado: R$ %.2f", novoSalario));
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}