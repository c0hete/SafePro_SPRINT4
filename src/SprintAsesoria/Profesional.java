/**
 * Esta clase representa a un profesional.
 * Hereda de la clase Usuario y agrega información adicional como título y fecha de ingreso.
 */
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
    @Override
    public String toString() {
        return "Profesional\n" +
                "Rut: " + getRut() + "\n" +
                "Nombre: " + getNombre() + "\n" +
                "Fecha de Nacimiento: " + getFechaNacimiento() + "\n" +
                "Edad: " + mostrarEdad() + "\n" +
                "Título: " + getTitulo() + "\n" +
                "Fecha de Ingreso: " + getFechaIngreso() + "\n------";
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


