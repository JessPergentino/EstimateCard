package br.com.jess.estimatecard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.saldo = findViewById(R.id.mainActivity_saldo);
        this.mViewHolder.tarifa = findViewById(R.id.mainActivity_tarifa);
        this.mViewHolder.botaoEntrar = findViewById(R.id.mainActivity_button);
        this.mViewHolder.botaoEntrar.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.mainActivity_button)
            if (this.mViewHolder.saldo.getText().length() == 0 || this.mViewHolder.tarifa.length() == 0) {
                Toast.makeText(MainActivity.this, "Por favor, Preencha os Campos!", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(MainActivity.this, TelaInicialActivity.class);
                intent.putExtra("saldo", this.mViewHolder.saldo.getText().toString());
                intent.putExtra("tarifa", this.mViewHolder.tarifa.getText().toString());
                startActivity(intent);
                finish();
            }
    }

    private static class ViewHolder{
        EditText saldo;
        EditText tarifa;
        Button botaoEntrar;
    }
}
