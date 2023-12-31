/*
Autores:
Juan Manuel Reyes | Nro. Estudiante 316445
Facundo Layes | Nro. Estudiante 248464

Repositorio: https://github.com/JuanManuelReyes/Candidatex
 */
package dominio;

import java.io.*;
import java.util.*;

public class Postulante extends Persona implements Serializable {

    private String telefono;
    private String mail;
    private String linkedin;
    private String formato; // remoto, presencial, mixto
    private Map<Tematica, Integer> conocimientos; // Tematica y nivel

    public Postulante(String nombre, String cedula, String direccion, String telefono, String mail, String linkedin, String formato, Map<Tematica, Integer> conocimientos) {
        super(nombre, cedula, direccion); // Llama al constructor de la clase padre (Persona).
        this.telefono = telefono;
        this.mail = mail;
        this.linkedin = linkedin;
        this.formato = formato;
        this.conocimientos = conocimientos;
    }

    // Metodo para agregar un conocimiento a la lista del postulante.
    public void agregarConocimiento(Tematica tematica, int nivel) {
        if (nivel >= 1 && nivel <= 10) {
            conocimientos.put(tematica, nivel);
        } else {
            System.out.println("El nivel debe estar entre 1 y 10.");
        }
    }

    // Metodo para eliminar un conocimiento de la lista del postulante.
    public void eliminarConocimiento(Tematica tematica) {
        conocimientos.remove(tematica);
    }

    public Map<Tematica, Integer> getConocimientos() {
        return conocimientos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public void setConocimientos(Map<Tematica, Integer> conocimientos) {
        this.conocimientos = conocimientos;
    }

    // Metodo para obtener las entrevistas asociadas a un postulante en el sistema.
    public List<Entrevista> getEntrevistas(Sistema sistema) {
        List<Entrevista> entrevistasDelPostulante = new ArrayList<>();

        // Recorre todas las entrevistas y selecciona las del postulante.
        for (Entrevista entrevista : sistema.getListaEntrevistas()) {
            if (entrevista.getPostulante().equals(this)) { // Verifica si el postulante tiene conocimientos en el tema.
                entrevistasDelPostulante.add(entrevista);
            }
        }
        return entrevistasDelPostulante;
    }
    
    // Metodo para obtener el nivel de conocimiento en una tematica especifica.
    public int getNivelEnTema(Tematica tema) {
        int nivel = 0;
        if (conocimientos.containsKey(tema)) {
            nivel = conocimientos.get(tema);
        }
        return nivel;
    }
    
    // Metodo para obtener el puntaje de la ultima entrevista del postulante.
    public int getPuntajeUltimaEntrevista(Sistema sistema) {
        List<Entrevista> entrevistas = getEntrevistas(sistema);
        int puntaje = 0; 

        if (!entrevistas.isEmpty()) {
            // Encuentra la ultima entrevista segun el numero de entrevista y obtiene su puntaje.
            Entrevista ultimaEntrevista = Collections.max(entrevistas, Comparator.comparing(Entrevista::getNumero));
            puntaje = ultimaEntrevista.getPuntaje();
        }

        return puntaje;
    }
        
    @Override
    public String toString() {
        return super.getNombre();
    }
}
