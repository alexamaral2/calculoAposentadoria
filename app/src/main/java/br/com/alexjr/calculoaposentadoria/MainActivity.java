package br.com.alexjr.calculoaposentadoria;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText valorFuturo;
    private EditText taxaJurosAnual;
    private EditText numeroAnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Button button = findViewById(R.id.btn_secondscreen);
        valorFuturo = findViewById(R.id.valor_futuro);
        taxaJurosAnual = findViewById(R.id.taxa_juros_anual);
        numeroAnos = findViewById(R.id.numero_anos);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("valorFuturo", valorFuturo.getText().toString());
                intent.putExtra("taxaJurosAnual", taxaJurosAnual.getText().toString());
                intent.putExtra("numeroAnos", numeroAnos.getText().toString());

                startActivity(intent);
            }
        });

    }
}
