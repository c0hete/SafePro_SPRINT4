package SprintAsesoria;

import java.time.LocalDate;
import java.time.Period;

public class Profesional extends Usuario {
    private String titulo;
    private LocalDate fechaIngreso;

    // Constructor
    public Profesional(String nombre, int rut, LocalDate fechaNacimiento, String titulo, LocalDate fechaIngreso) {
        super(nombre, rut, fechaNacimiento);
        this.titulo = titulo;
        this.fechaIngreso = fechaIngreso;
    }

    // Getter y setter para titulo y fechaIngreso

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    // Método obtenerNombre()
    public String obtenerNombre() {
        return nombre;
    }

    // Método obtenerAniosExperiencia()
    public int obtenerAniosExperiencia() {
        int aniosExperiencia = Period.between(fechaIngreso, LocalDate.now()).getYears();
        return aniosExperiencia;
    }

    // Implementación del método analizarUsuario() de la clase Usuario
    @Override
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("Título: " + titulo);
        System.out.println("Años de experiencia: " + obtenerAniosExperiencia());
        System.out.println(mostrarEdad());
    }
}

