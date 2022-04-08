    package com.alice.exercicioedi6;

    import android.content.Context;
    import android.database.sqlite.SQLiteDatabase;
    import android.database.sqlite.SQLiteOpenHelper;

    public class Conexao extends SQLiteOpenHelper {
        private static final String name = "banco.db";
        private static final int version = 1;
        public Conexao(Context context){
            super(context, name, null, version);
        }
        @Override
        public void onCreate(SQLiteDatabase db){

        db.execSQL("CREATE TABLE CLIENTE(ID INTEGER PRIMARY KEY AUTOINCREMENT,"  + "NOME VARCHAR(50), "+ "MATRICULA VARCHAR(50),"+ "ENDERECO VARCHAR(50), "+ "NUMERO VARCHAR(50), "+ "COMPLEMENTO VARCHAR(50), "+ "CIDADE VARCHAR(50)) ");
        }
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
        }
    }