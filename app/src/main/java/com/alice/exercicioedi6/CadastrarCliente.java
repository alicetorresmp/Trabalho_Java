package com.alice.exercicioedi6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CadastrarCliente extends AppCompatActivity {
    EditText nome, matricula, endereco, numero, complemento, cidade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_cliente);

        Intent intent = getIntent();
        String nome2 = intent.getSerializableExtra("ParametroLogin").toString();
        TextView texto = (TextView) findViewById(R.id.txtRepeticao);
        texto.setText("Prezado(a) " + nome2 + ", seja bem-vindo ao app!");

        nome = findViewById((R.id.txtNome));
        matricula = findViewById((R.id.txtMatricula));
        endereco = findViewById((R.id.txtEndereco));
        numero = findViewById((R.id.txtNumero));
        complemento = findViewById((R.id.txtComplemento));
        cidade = findViewById((R.id.txtCidade));


    }




    public void salvar(View view) {
        Button button = findViewById(R.id.cadastrar);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(CadastrarCliente.this, ListarClientes.class);
                Bundle extras = new Bundle();
                extras.putString("nome", String.valueOf(nome));
                extras.putString("matricula", String.valueOf(matricula));
                extras.putString("endereco", String.valueOf(endereco));
                extras.putString("numero", String.valueOf(numero));
                extras.putString("complemento", String.valueOf(complemento));
                extras.putString("cidade", String.valueOf(cidade));
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }
}
