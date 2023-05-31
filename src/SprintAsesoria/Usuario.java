package SprintAsesoria;

import java.time.LocalDate;
import java.time.Period;

public abstract class Usuario implements Asesoria {
    protected String nombre;
    protected int rut;
    protected LocalDate fechaNacimiento;

    // Constructor
    public Usuario(String nombre, int rut, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.rut = rut;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    // Método mostrarEdad()
    public String mostrarEdad() {
        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        return "El usuario tiene " + edad + " años.";
    }

    // Implementación del método analizarUsuario() de la interfaz Asesoria
    @Override
    public void analizarUsuario() {
        System.out.println("Nombre: " + nombre);
        System.out.println("RUN: " + rut);
    }
}
