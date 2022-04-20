package com.alice.exercicioedi6;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ClienteDAO {
    public Conexao conexao;
    public SQLiteDatabase banco;


    public ClienteDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }
    public long inserir(Cliente cliente){
        ContentValues values = new ContentValues();
        values.put("NOME", cliente.getNome());
        values.put("MATRICULA", cliente.getMatricula());
        values.put("ENDERECO", cliente.getEndereco());
        values.put("NUMERO", cliente.getNumero());
        values.put("COMPLEMENTO", cliente.getComplemento());
        values.put("CIDADE", cliente.getCidade());
        return banco.insert("CLIENTES", null, values);

    }
}
