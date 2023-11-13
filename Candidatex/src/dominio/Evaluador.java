package dominio;

import java.io.Serializable;

public class Evaluador extends Persona implements Serializable {

    private int anioIngreso;

    public Evaluador(String nombre, String cedula, String direccion, int anioIngreso) {
        super(nombre, cedula, direccion);
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
