/*
Autores:
Juan Manuel Reyes | Nro. Estudiante 316445
Facundo Layes | Nro. Estudiante 248464

Repositorio: https://github.com/JuanManuelReyes/Candidatex
 */
package dominio;

import java.io.Serializable;

public class Evaluador extends Persona implements Serializable {

    private int anioIngreso;

    public Evaluador(String nombre, String cedula, String direccion, int anioIngreso) {
        super(nombre, cedula, direccion); // Llamada al constructor de la clase padre (Persona).
        this.anioIngreso = anioIngreso;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(int anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    @Override
    public String toString() {
        return super.getNombre();
    }

}
