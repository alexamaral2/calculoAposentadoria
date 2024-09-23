package br.com.alexjr.calculoaposentadoria;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        TextView textContribuicaoMensal = findViewById(R.id.valor_contribuicao_mensal);
        TextView textValorFuturo = findViewById(R.id.valor_futuro);
        TextView textTaxaJuros = findViewById(R.id.taxa_juros);
        TextView textNumeroMeses = findViewById(R.id.numero_meses);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            double valorFuturo = Double.parseDouble(extras.getString("valorFuturo"));
            double taxaJurosAnual = Double.parseDouble(extras.getString("taxaJurosAnual"));
            int numeroAnos = Integer.parseInt(extras.getString("numeroAnos"));

            double i = (taxaJurosAnual / 100) / 12;
            int n = numeroAnos * 12;
            double contribuicaoMensal = valorFuturo * i / (Math.pow((1 + i), n) - 1);

            textContribuicaoMensal.setText("R$ " + String.format("%.2f", contribuicaoMensal));
            textValorFuturo.setText("R$ " + String.format("%.2f", valorFuturo));
            textTaxaJuros.setText(String.format("%.2f", i));
            textNumeroMeses.setText(String.format("%d", numeroAnos));
        }

        Button button = findViewById(R.id.btn_firstscreen);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
