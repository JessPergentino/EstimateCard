package br.com.jess.estimatecard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TelaInicialActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();
    private String saldo = "";
    private String tarifa = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        Intent intent = TelaInicialActivity.this.getIntent();

        saldo = intent.getStringExtra("saldo");
        tarifa = intent.getStringExtra("tarifa");

        this.mViewHolder.saldoText = this.findViewById(R.id.TelaInicialActivity_saldo);
        this.mViewHolder.saldoText.setText(saldo);

        this.mViewHolder.tarifaText = this.findViewById(R.id.TelaInicialActivity_tarifa);
        this.mViewHolder.tarifaText.setText(tarifa);

        this.mViewHolder.botaoUsar = findViewById(R.id.TelaInicialActivity_buttonUsar);
        this.mViewHolder.botaoUsar.setOnClickListener(this);

        this.mViewHolder.botaoRecarregar = findViewById(R.id.TelaInicialActivity_buttonRecarregar);
        this.mViewHolder.botaoRecarregar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.TelaInicialActivity_buttonUsar){
            Double s = Double.valueOf(saldo);
            Double t = Double.valueOf(tarifa);

            Double novoSaldo = s - t;
            this.mViewHolder.saldoText.setText(String.format("%.2f", novoSaldo));
        }


    }

    private static class ViewHolder{
        TextView saldoText;
        TextView tarifaText;
        Button botaoUsar;
        Button botaoRecarregar;
    }

}
