package com.br.allannacimento.gorjeta.dev.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.br.allannacimento.gorjeta.R;
import com.br.allannacimento.gorjeta.dev.apoio.UtilGorjeta;

public class MainActivity extends AppCompatActivity {

    EditText editValor;

    TextView txtGorjeta;
    TextView txtValorTotal;

    Button btnCalcular;

    double valorGorjeta;

    double gorjeta;
    double total;

    String gorjetaTotal;
    String valorTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editValor);

        txtGorjeta = findViewById(R.id.txtGorjeta);
        txtValorTotal = findViewById(R.id.textValorTotal);

        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(editValor.getText())) {
                    editValor.setError("* Obrigatório");
                    editValor.requestFocus();

                    Toast.makeText(MainActivity.this,
                            "Por favor, digite os dados obrigatórios do aplicativo...",
                            Toast.LENGTH_LONG).show();

                } else {
                    valorGorjeta = Double.parseDouble(editValor.getText().toString());

                    gorjeta = UtilGorjeta.calcularGorjeta(valorGorjeta);
                    gorjetaTotal = UtilGorjeta.formatarResultado(gorjeta);

                    total = UtilGorjeta.calcularTotal(valorGorjeta, gorjeta);
                    valorTotal = UtilGorjeta.formatarResultado(total);

                    txtGorjeta.setText(gorjetaTotal);
                    txtValorTotal.setText(valorTotal);
                }

            }
        });
    }
}