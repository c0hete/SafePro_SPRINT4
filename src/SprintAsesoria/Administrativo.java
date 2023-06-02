/**
 * Esta clase representa a un administrativo.
 * Hereda de la clase Usuario y agrega información adicional como área y experiencia previa.
 */
package SprintAsesoria;

import java.time.LocalDate;

public class Administrativo extends Usuario {
    private String area;
    private String experienciaPrevia;

    public Administrativo(String nombre, int rut, LocalDate fechaNacimiento, String area, String experienciaPrevia) {
        super(nombre, rut, fechaNacimiento);
        this.area = area;
        this.experienciaPrevia = experienciaPrevia;
    }
    
    @Override
    public String toString() {
        return "Administrativo\n" +
                "Rut: " + getRut() + "\n" +
                "Nombre: " + getNombre() + "\n" +
                "Fecha de Nacimiento: " + getFechaNacimiento() + "\n" +
                "Edad: " + mostrarEdad() + "\n" +
                "Título: " + getArea() + "\n" +
                "Fecha de Ingreso: " + getExperienciaPrevia() + "\n------";
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getExperienciaPrevia() {
        return experienciaPrevia;
    }

    public void setExperienciaPrevia(String experienciaPrevia) {
        this.experienciaPrevia = experienciaPrevia;
    }

    @Override
    public void analizarUsuario() {
        System.out.println("Datos del administrativo:");
        System.out.println("Nombre: " + getNombre());
        System.out.println("RUN: " + getRut());
        System.out.println("Área: " + area);
        System.out.println("Experiencia previa: " + experienciaPrevia);
    }
}
