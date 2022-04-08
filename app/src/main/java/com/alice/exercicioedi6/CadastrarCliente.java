package com.alice.exercicioedi6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CadastrarCliente extends AppCompatActivity {
    private EditText nome, matricula, endereco, numero, complemento, cidade;
    private ClienteDAO dao;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_cliente);
        Intent intent = getIntent();
        String nome2 = intent.getSerializableExtra("ParametroLogin").toString();
        TextView texto = (TextView) findViewById(R.id.txtRepeticao);
        texto.setText("Prezado(a) " + nome2 + ", seja bem-vindo ao app!");
        nome = (EditText) findViewById((R.id.txtNome));
        matricula = (EditText) findViewById((R.id.txtMatricula));
        endereco = (EditText) findViewById((R.id.txtEndereco));
        numero = (EditText) findViewById((R.id.txtNumero));
        complemento = (EditText) findViewById((R.id.txtComplemento));
        cidade = (EditText) findViewById((R.id.txtCidade));
        dao = new ClienteDAO(this);
    }

    public void salvar(View view) {
        String obj_nome = (nome.getText().toString());
        String obj_matricula = (matricula.getText().toString());
        String obj_endereco = (endereco.getText().toString());
        String obj_numero = (numero.getText().toString());
        String obj_complemento = (complemento.getText().toString());
        String obj_cidade = (cidade.getText().toString());
        Cliente c = new Cliente(obj_nome, obj_matricula, obj_endereco, obj_numero, obj_complemento, obj_cidade);
        long id = dao.inserir(c);
        Toast.makeText(this, "Cliente Cadastrado com id: " + id, Toast.LENGTH_SHORT).show();
    }
}
