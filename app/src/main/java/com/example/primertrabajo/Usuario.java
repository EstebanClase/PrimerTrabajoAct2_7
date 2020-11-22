package com.example.primertrabajo;

public class Usuario {
    int Id;
    String usuario, nombre, email, password;

    public Usuario() {
    }

    public Usuario(String nombre, String email, String usuario, String password) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    public boolean isNull(){
        if(nombre.equals("") && email.equals("") && usuario.equals("") && password.equals("")){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "Id=" + Id +
                ", usuario='" + usuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
