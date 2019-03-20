package com.jonasrosendo.minhasanotacoes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edit_anotacao;
    private AnotacaoPreferencias preferencias;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_anotacao = findViewById(R.id.edit_anotacao);
        FloatingActionButton fab = findViewById(R.id.fab);

        preferencias = new AnotacaoPreferencias(getApplicationContext());

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String texto = edit_anotacao.getText().toString();
                if (texto.equals("")){
                    Snackbar.make(view, "Preencha Anotação", Snackbar.LENGTH_LONG).show();
                }else {
                    preferencias.salvarAnotacao(texto);
                    Snackbar.make(view, "Anotação salva com sucesso!", Snackbar.LENGTH_LONG).show();
                }

            }
        });

        String anotacao = preferencias.getAnotacao();
        if (!anotacao.equals("")){
            edit_anotacao.setText(anotacao);
        }
    }
}
