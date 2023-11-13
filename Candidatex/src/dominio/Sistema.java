/*
Autores:
Juan Manuel Reyes | Nro. Estudiante 316445
Facundo Layes | Nro. Estudiante 248464

Repositorio: https://github.com/JuanManuelReyes/Candidatex
 */
package dominio;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Sistema extends Observable implements Serializable {

    private ArrayList<Tematica> listaTematica;
    private ArrayList<Postulante> listaPostulantes;
    private ArrayList<Evaluador> listaEvaluador;
    private ArrayList<Puesto> listaPuestos;
    private ArrayList<Entrevista> listaEntrevistas;

    public Sistema() {
        listaTematica = new ArrayList<>();
        listaPostulantes = new ArrayList<>();
        listaEvaluador = new ArrayList<>();
        listaPuestos = new ArrayList<>();
        listaEntrevistas = new ArrayList<>();
    }

    public ArrayList<Tematica> getListaTematica() {
        return listaTematica;
    }

    public ArrayList<Postulante> getListaPostulantes() {
        return listaPostulantes;
    }

    public ArrayList<Puesto> getListaPuestos() {
        return listaPuestos;
    }

    public ArrayList<Evaluador> getListaEvaluador() {
        return listaEvaluador;
    }

    public ArrayList<Entrevista> getListaEntrevistas() {
        return listaEntrevistas;
    }

    public boolean temaRepetido(Tematica tematica) {
        boolean res = false;
        for (Tematica elem : listaTematica) {
            if (elem.getNombre().toLowerCase().equals(tematica.getNombre().toLowerCase())) {
                res = true;
            }
        }
        return res;
    }

    public boolean puestoRepetido(Puesto puesto) {
        boolean res = false;
        for (Puesto elem : listaPuestos) {
            if (elem.getNombre().toLowerCase().equals(puesto.getNombre().toLowerCase())) {
                res = true;
            }
        }
        return res;
    }

    public void agregarTematica(Tematica tematica) {
        listaTematica.add(tematica);
        setChanged();
        notifyObservers();
    }

    public void agregarPostulante(Postulante post) {
        listaPostulantes.add(post);
        setChanged();
        notifyObservers();
    }

    public void agregarPuesto(Puesto puesto) {
        listaPuestos.add(puesto);
        setChanged();
        notifyObservers();
    }

    public void agregarEvaluador(Evaluador eva) {
        listaEvaluador.add(eva);
        setChanged();
        notifyObservers();
    }

    public void agregarEntrevista(Entrevista entrevista) {
        listaEntrevistas.add(entrevista);
        setChanged();
        notifyObservers();
    }

    public Puesto buscarPuestoPorNombre(String nombrePuesto) {
        for (Puesto puesto : listaPuestos) {
            if (puesto.getNombre().equals(nombrePuesto)) {
                return puesto;
            }
        }
        return null;
    }

    public Tematica buscarTematicaPorNombre(String nombreTematica) {
        for (Tematica tematica : listaTematica) {
            if (tematica.getNombre().equals(nombreTematica)) {
                return tematica;
            }
        }
        return null;
    }

    public void eliminarPostulante(Postulante post) {
        listaPostulantes.remove(post);

        for (Entrevista entre : listaEntrevistas) {
            if (entre.getPostulante().equals(post)) {
                listaEntrevistas.remove(entre);
                break;
            }
        }
        setChanged();
        notifyObservers();

    }

    public boolean cedulaRepetida(String unaCedula) {
        boolean res = false;
        for (Postulante post : listaPostulantes) {
            if (post.getCedula().equals(unaCedula)) {
                res = true;
            }
        }
        for (Evaluador eva : listaEvaluador) {
            if (eva.getCedula().equals(unaCedula)) {
                res = true;
            }
        }
        return res;
    }

    public boolean cedulaInvalida(String cedula) {
        return cedula.contains("-") || cedula.contains(".") || cedula.length() != 8 || esInt(cedula);
    }

    public boolean telefonoInvalido(String telefono) {
        return telefono.length() < 8 || telefono.length() > 9 || esInt(telefono);
    }

    public boolean mailValido(String mail) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mail);

        return matcher.matches();
    }

    public boolean linkValido(String link) {
        return link.startsWith("linkedin.com") || link.startsWith("https://linkedin.com") || link.startsWith("https://www.linkedin.com") || link.startsWith("https://uy.linkedin.com/");
    }

    public boolean esInt(String numero) {
        try {
            Integer.parseInt(numero);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

}
