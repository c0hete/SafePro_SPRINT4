package SprintAsesoria;

public class Capacitacion {
    private static int contadorIdentificador = 1;
    private int identificador;
    private int rutCliente;
    private String dia;
    private String hora;
    private String lugar;
    private String duracion;
    private int cantidadAsistentes;

    public Capacitacion(int rutCliente, String dia, String hora, String lugar, String duracion, int cantidadAsistentes) {
        this.identificador = generarIdentificador();
        this.rutCliente = rutCliente;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.duracion = duracion;
        this.cantidadAsistentes = cantidadAsistentes;
    }

    public int getIdentificador() {
        return identificador;
    }

    public int getRutCliente() {
        return rutCliente;
    }

    public String getDia() {
        return dia;
    }

    public String getHora() {
        return hora;
    }

    public String getLugar() {
        return lugar;
    }

    public String getDuracion() {
        return duracion;
    }

    public int getCantidadAsistentes() {
        return cantidadAsistentes;
    }

    private static int generarIdentificador() {
        int identificador = contadorIdentificador;
        contadorIdentificador++;
        return identificador;
    }

    @Override
    public String toString() {
        return "Capacitacion{" +
                "identificador=" + identificador +
                ", rutCliente=" + rutCliente +
                ", dia='" + dia + '\'' +
                ", hora='" + hora + '\'' +
                ", lugar='" + lugar + '\'' +
                ", duracion='" + duracion + '\'' +
                ", cantidadAsistentes=" + cantidadAsistentes +
                '}';
    }
}

