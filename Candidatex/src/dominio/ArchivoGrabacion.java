/*
Autores:
Juan Manuel Reyes | Nro. Estudiante 316445
Facundo Layes | Nro. Estudiante 248464

Repositorio: https://github.com/JuanManuelReyes/Candidatex
 */
package dominio;

import java.io.*;
import java.util.*;

public class ArchivoGrabacion {
    private Formatter out;

    public ArchivoGrabacion(String unNombre) {
        try {
            out = new Formatter(unNombre);
        } catch (FileNotFoundException e) {
            System.out.println("No se ha podido crear el archivo.");
            System.exit(1);
        } catch (SecurityException e) {
            System.out.println("No se tienen los permisos necesarios para crear el archivo.");
            System.exit(1);
        }
    }

    public ArchivoGrabacion(String unNombre, boolean ext) {
        try {
            FileWriter f = new FileWriter(unNombre, ext);
            out = new Formatter(f);
        } catch (IOException e) {
            System.out.println("No se ha podido crear o modificar el archivo.");
            System.exit(1);
        }
    }

    public void grabarLinea(String linea) {
        out.format("%s%n", linea);
    }

    public void cerrar() {
        out.close();
    }
}
