/*
Autores:
Juan Manuel Reyes | Nro. Estudiante 316445
Facundo Layes | Nro. Estudiante 248464

Repositorio: https://github.com/JuanManuelReyes/Candidatex
 */
package dominio;

import java.io.Serializable;

public class Entrevista implements Serializable{
    private static int contador = 0;
    private final int numero; 
    private Evaluador evaluador;
    private Postulante postulante;
    private int puntaje;
    private String comentarios;


    public Entrevista(Evaluador evaluador, Postulante postulante, int puntaje, String comentarios) {
        this.numero = ++contador;
        this.evaluador = evaluador;
        this.postulante = postulante;
        this.puntaje = puntaje;
        this.comentarios = comentarios;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public Evaluador getEvaluador() {
        return evaluador;
    }

    public void setEvaluador(Evaluador evaluador) {
        this.evaluador = evaluador;
    }

    public Postulante getPostulante() {
        return postulante;
    }

    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "Entrevista{"+ "numero=" + numero + "evaluador=" + evaluador + ", postulante=" + postulante + ", puntaje=" + puntaje + ", comentarios=" + comentarios + '}';
    }
    
}
