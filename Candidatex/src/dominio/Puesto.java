/*
Autores:
Juan Manuel Reyes | Nro. Estudiante 316445
Facundo Layes | Nro. Estudiante 248464

Repositorio: https://github.com/JuanManuelReyes/Candidatex
 */
package dominio;

import java.io.Serializable;
import java.util.*;

public class Puesto implements Serializable{
    private String nombre;
    private String tipo; // remoto, presencial, mixto
    private ArrayList<Tematica> temasRequeridos; // Lista de temas requeridos para el puesto.

    public Puesto(String nombre, String tipo, ArrayList<Tematica> temasRequeridos) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.temasRequeridos = temasRequeridos;
    }

    // Metodo para añadir un tema requerido.
    public void anadirTemaRequerido(Tematica tema) {
        if (!temasRequeridos.contains(tema)) {
            temasRequeridos.add(tema);
        }
    }
    
    // Metodo para eliminar un tema de la lista de temas requeridos.
    public void eliminarTemaRequerido(Tematica tema) {
        temasRequeridos.remove(tema);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Tematica> getTemasRequeridos() {
        return temasRequeridos;
    }


    @Override
    public String toString() {
        return nombre;
    }
    
}
