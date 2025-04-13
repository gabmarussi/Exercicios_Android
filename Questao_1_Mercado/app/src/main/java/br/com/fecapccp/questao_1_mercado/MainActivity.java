package br.com.fecapccp.questao_1_mercado;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CheckBox checkArroz, checkLeite, checkCarne, checkFeijao, checkRefrigerante;
    Button btnCalcular;
    TextView textTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

       checkArroz = findViewById(R.id.checkArroz);
        checkLeite = findViewById(R.id.checkLeite);
        checkCarne = findViewById(R.id.checkCarne);
        checkFeijao = findViewById(R.id.checkFeijao);
        checkRefrigerante = findViewById(R.id.checkRefrigerante);

        btnCalcular = findViewById(R.id.btnCalcular);
        textTotal = findViewById(R.id.textTotal);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double total = 0;

                if (checkArroz.isChecked()) {
                    total += 2.69;
                }
                if (checkLeite.isChecked()) {
                    total += 2.70;
                }
                if (checkCarne.isChecked()) {
                    total += 16.70;
                }
                if (checkFeijao.isChecked()) {
                    total += 3.38;
                }
                if (checkRefrigerante.isChecked()) {
                    total += 3.00;
                }

                textTotal.setText("Total: R$ " + String.format("%.2f", total));
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}