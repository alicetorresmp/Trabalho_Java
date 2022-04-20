package com.alice.exercicioedi6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListarClientes extends AppCompatActivity {

    private ClienteDAO dao;
    CriarArrayList arrayList;
    String nome, matricula, endereco, cidade, complemento, numero;
    ArrayList<Cliente> clientes;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_clientes);

        Bundle extras = getIntent().getExtras();
        nome = extras.getString("nome");
        matricula = extras.getString("matricula");
        endereco = extras.getString("endereco");
        complemento = extras.getString("complemento");
        numero = extras.getString("numero");
        cidade = extras.getString("cidade");

        adicionarCliente(nome, matricula, endereco, complemento, numero, cidade);
        criarAdapter();

        dao = new ClienteDAO(this);



    }
    public class CriarArrayList {

        ArrayList<Cliente> clientes = new ArrayList<>();

        void addList(Cliente c){
            this.clientes.add(c);

        }
        ArrayList<Cliente> returnList(){
            return clientes;
        }

    }

    void criarAdapter(){

        ArrayAdapter<Cliente> adapter = new ClienteAdapter(this, arrayList.returnList());
        ListView lista = findViewById(R.id.listview);
        lista.setAdapter(adapter);
    }

     void adicionarCliente(String nome, String matricula,String endereco,String numero,String complemento,String cidade) {

        Cliente c = new Cliente(nome, matricula, endereco, numero, complemento, cidade);

        long id = dao.inserir(c);
        Toast.makeText(this, "Cliente Cadastrado com id: " + id, Toast.LENGTH_SHORT).show();

        CriarArrayList arrayList = new CriarArrayList();
        arrayList.addList(c);


    }

    }
