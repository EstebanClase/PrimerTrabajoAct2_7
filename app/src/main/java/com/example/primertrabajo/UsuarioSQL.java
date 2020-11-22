package com.example.primertrabajo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class UsuarioSQL {
    Context c;
    Usuario u;
    ArrayList<Usuario> lista;
    SQLiteDatabase sql;
    String bd = "bd";
    String tabla = "create table if not exists usuarios(id integer primary key autoincrement, usuario text, nombre text, email text, pass text)";

    public UsuarioSQL(Context c) {
        this.c = c;
        sql = c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        u = new Usuario();
    }

    public boolean insertUsuario(Usuario u) {
        if (buscar(u.getUsuario()) == 0) {
            ContentValues cv = new ContentValues();
            cv.put("usuario", u.getUsuario());
            cv.put("nombre", u.getNombre());
            cv.put("email", u.getEmail());
            cv.put("pass", u.getPassword());
            return (sql.insert("usuarios", null, cv) > 0);
        } else {
            return false;
        }
    }

    public int buscar(String u) {
        int x = 0;
        lista = selectUsuario();
        for (Usuario us : lista) {
            if (us.getUsuario().equals(u)) {
                x++;
            }
        }
        return x;
    }

    public ArrayList<Usuario> selectUsuario() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        lista.clear();
        Cursor cr = sql.rawQuery("select * from usuarios", null);
        if (cr != null && cr.moveToFirst()) {
            do {
                Usuario u = new Usuario();
                u.setId(cr.getInt(0));
                u.setUsuario(cr.getString(1));
                u.setNombre(cr.getString(2));
                u.setEmail(cr.getString(3));
                u.setPassword(cr.getString(4));
                lista.add(u);
            } while (cr.moveToNext());

        }
        return lista;
    }

    public int login(String u, String p) {
        int i = 0;
        Cursor cr = sql.rawQuery("select * from usuarios", null);
        if (cr != null && cr.moveToFirst()) {
            do {
                if (cr.getString(1).equals(u) && cr.getString(4).equals(p)) {
                    i++;

                }
            } while (cr.moveToNext());

        }
        return i;
    }

    public Usuario getUsuario(String u, String p) {
        lista = selectUsuario();
        for(Usuario i:lista){
            if(i.getUsuario().equals(u) && i.getPassword().equals(p)){
                return i;
            }

        }
        return null;
    }

    public Usuario getUsuarioId(int id) {
        lista = selectUsuario();
        for(Usuario i:lista){
            if(i.getId()==id){
                return i;
            }

        }
        return null;
    }
}


