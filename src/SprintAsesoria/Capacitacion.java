package SprintAsesoria;

public class Capacitacion {
    private int rutCliente;
    private String nombre;
    private String fecha;
    private int duracion;
    private int cupos;
    private int cuposDisponibles;

    public Capacitacion(int rutCliente, String nombre, String fecha, int duracion, int cupos) {
        this.rutCliente = rutCliente;
        this.nombre = nombre;
        this.fecha = fecha;
        this.duracion = duracion;
        this.cupos = cupos;
        this.cuposDisponibles = cupos;
    }

    public int getRutCliente() {
        return rutCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getCupos() {
        return cupos;
    }

    public int getCuposDisponibles() {
        return cuposDisponibles;
    }

    public void reducirCupo() {
        if (cuposDisponibles > 0) {
            cuposDisponibles--;
        }
    }

    // Otros métodos de la clase

    @Override
    public String toString() {
        return "Capacitacion{" +
                "rutCliente='" + rutCliente + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fecha='" + fecha + '\'' +
                ", duracion=" + duracion +
                ", cupos=" + cupos +
                ", cuposDisponibles=" + cuposDisponibles +
                '}';
    }
}
