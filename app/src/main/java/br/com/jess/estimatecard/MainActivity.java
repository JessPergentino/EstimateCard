package br.com.jess.estimatecard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText saldo;
    private EditText tarifa;
    private Button botaoEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saldo = findViewById(R.id.mainActivity_saldo);
        tarifa = findViewById(R.id.mainActivity_tarifa);
        botaoEntrar = findViewById(R.id.mainActivity_button);

        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (saldo.getText().length() == 0 || tarifa.length() == 0){
                    Toast.makeText(MainActivity.this, "Por favor, Preencha os Campos!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, TelaInicialActivity.class);
                    intent.putExtra("saldo", saldo.getText().toString());
                    intent.putExtra("tarifa", tarifa.getText().toString());
                    startActivity(intent);
                    finish();
                }
            }

        }

        );

    }
}
