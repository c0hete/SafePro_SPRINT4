/**
 * Esta clase representa a un cliente.
 * Hereda de la clase Usuario y agrega información adicional como apellido, dirección y sistema de salud.
 */
package SprintAsesoria;

import java.time.LocalDate;

public class Cliente extends Usuario {
    private String telefono;
    private String afp;
    private boolean esFonasa;
    private String direccion;
    private String comuna;
    private String apellido;

    public Cliente(String nombre, int rut, LocalDate fechaNacimiento, String telefono, String afp, boolean esFonasa, String direccion, String comuna, String apellido) {
        super(nombre, rut, fechaNacimiento);
        setTelefono(telefono);
        setAfp(afp);
        this.esFonasa = esFonasa;
        setDireccion(direccion);
        setComuna(comuna);
        setApellido(apellido);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        // Validar que el teléfono no esté vacío y cumpla con las reglas establecidas
        if (!Validaciones.validarCampoTexto(telefono, 8, 15)) {
            throw new IllegalArgumentException("Teléfono inválido");
        }
        this.telefono = telefono;
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        // Validar que el AFP no esté vacío y cumpla con las reglas establecidas
        if (!Validaciones.validarCampoTexto(afp, 4, 30)) {
            throw new IllegalArgumentException("AFP inválido");
        }
        this.afp = afp;
    }

    public boolean isEsFonasa() {
        return esFonasa;
    }

    public void setEsFonasa(boolean esFonasa) {
        this.esFonasa = esFonasa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        // Validar que la dirección no esté vacía y cumpla con las reglas establecidas
        if (!Validaciones.validarCampoTexto(direccion, 1, 70)) {
            throw new IllegalArgumentException("Dirección inválida");
        }
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        // Validar que la comuna no esté vacía y cumpla con las reglas establecidas
        if (!Validaciones.validarCampoTexto(comuna, 1, 50)) {
            throw new IllegalArgumentException("Comuna inválida");
        }
        this.comuna = comuna;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        // Validar que el apellido no esté vacío y cumpla con las reglas establecidas
        if (!Validaciones.validarCampoTexto(apellido, 5, 50)) {
            throw new IllegalArgumentException("Apellido inválido");
        }
        this.apellido = apellido;
    }
    

    @Override
    public void analizarUsuario() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("RUN: " + getRut());
    }

    @Override
    public String toString() {
        return "Cliente\n" +
                "Rut: " + getRut() + "\n" +
                "Nombre: " + getNombre() + "\n" +
                "Apellido: " + getApellido() + "\n" +
                "Fecha de Nacimiento: " + getFechaNacimiento() + "\n" +
                "Edad: " + mostrarEdad() + "\n" +
                "Dirección: " + getDireccion() + "\n" +
                "Comuna: " + getComuna() + "\n" +
                "Sistema de Salud: " + (isEsFonasa() ? "Fonasa" : "Isapre") + "\n------";
    }
}

