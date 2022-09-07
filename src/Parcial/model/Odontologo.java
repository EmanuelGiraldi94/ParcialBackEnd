package Parcial.model;

public class Odontologo {

    private int Matricula;
    private String nombre;
    private String apelllido;

    public Odontologo(int matricula, String nombre, String apelllido) {
        Matricula = matricula;
        this.nombre = nombre;
        this.apelllido = apelllido;
    }

    public int getMatricula() {
        return Matricula;
    }

    public void setMatricula(int matricula) {
        Matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelllido() {
        return apelllido;
    }

    public void setApelllido(String apelllido) {
        this.apelllido = apelllido;
    }
}
