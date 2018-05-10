package br.com.jess.estimatecard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TelaInicialActivity extends AppCompatActivity {

    private String saldo;
    private String tarifa;
    private TextView saldoText;
    private TextView tarifaText;
    private Button botaoUsei;
    private Button botaoRecarregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        Intent intent = TelaInicialActivity.this.getIntent();

        saldo = intent.getStringExtra("saldo");
        tarifa = intent.getStringExtra("tarifa");

        saldoText = this.findViewById(R.id.TelaInicialActivity_saldo);
        saldoText.setText(saldo);

        tarifaText = this.findViewById(R.id.TelaInicialActivity_tarifa);
        tarifaText.setText(tarifa);

        botaoUsei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double s = Double.parseDouble(saldo);
                Double t = Double.parseDouble(tarifa);

                Double novoSaldo = s - t;
                saldoText.setText(String.valueOf(novoSaldo));
            }
        });

    }


}
