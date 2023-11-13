package dominio;

import java.io.*;

public class Tematica implements Serializable {

    private String nombre;
    private String descripcion;

    public Tematica(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return nombre;
    }
     

}
