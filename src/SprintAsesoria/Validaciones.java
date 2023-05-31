package SprintAsesoria;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class Validaciones {

    public static boolean validarCampoTexto(String texto, int longitudMinima, int longitudMaxima) {
        // Validar que el texto no esté vacío
        if (texto.isEmpty()) {
            return false;
        }

        // Validar longitud mínima y máxima del texto
        if (texto.length() < longitudMinima || texto.length() > longitudMaxima) {
            return false;
        }

        return true;
    }

    public static boolean validarRut(int rut) {
        // Validar que el rut sea un número válido
        int rutMinimo = 0;
        int rutMaximo = 99999999;
        if (rut < rutMinimo || rut > rutMaximo) {
            return false;
        }

        return true;
    }

    public static boolean validarFormatoFecha(String fecha, String formatoFecha) {
        // Modificar la expresión regular para validar el formato de fecha "dd/MM/yyyy"
        String formatoFechaValido = "\\d{2}/\\d{2}/\\d{4}";

        // Validar que la fecha tenga el formato especificado
        if (!fecha.matches(formatoFechaValido)) {
            return false;
        }

        return true;
    }


    public static boolean validarDiaSemana(String diaSemana) {
        // Validar que el día de la semana sea válido
        String[] diasValidos = { "lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo" };
        for (String dia : diasValidos) {
            if (dia.equalsIgnoreCase(diaSemana)) {
                return true;
            }
        }

        return false;
    }

    public static boolean validarHora(String hora) {
        // Validar que la hora tenga el formato HH:MM
        String formatoHora = "\\d{2}:\\d{2}";
        if (!hora.matches(formatoHora)) {
            return false;
        }

        // Obtener las horas y minutos de la hora
        String[] partesHora = hora.split(":");
        int horas = Integer.parseInt(partesHora[0]);
        int minutos = Integer.parseInt(partesHora[1]);

        // Validar rango de horas y minutos
        int horasMinimas = 0;
        int horasMaximas = 23;
        int minutosMinimos = 0;
        int minutosMaximos = 59;
        if (horas < horasMinimas || horas > horasMaximas || minutos < minutosMinimos || minutos > minutosMaximos) {
            return false;
        }

        return true;
    }

    public static boolean validarTitulo(String titulo) {
        // Validar que el título no esté vacío
        if (titulo.isEmpty()) {
            return false;
        }

        // Validar longitud mínima y máxima del título
        int longitudMinima = 10;
        int longitudMaxima = 50;
        if (titulo.length() < longitudMinima || titulo.length() > longitudMaxima) {
            return false;
        }

        return true;
    }
    
    public static boolean validarOpcionSalud(int opcionSalud) {
        // Validar que la opción de salud sea 1 o 2
        if (opcionSalud != 1 && opcionSalud != 2) {
            return false;
        }
        return true;
    }


    public static boolean validarLugar(String lugar) {
        // Validar que el lugar no esté vacío
        if (lugar.isEmpty()) {
            return false;
        }

        // Validar longitud mínima y máxima del lugar
        int longitudMinima = 10;
        int longitudMaxima = 50;
        if (lugar.length() < longitudMinima || lugar.length() > longitudMaxima) {
            return false;
        }

        return true;
    }

    public static boolean validarDuracion(String duracion) {
        // Validar longitud máxima de la duración
        int longitudMaxima = 70;
        if (duracion.length() > longitudMaxima) {
            return false;
        }

        return true;
    }

    public static boolean validarCantidadAsistentes(int cantidadAsistentes) {
        // Validar que la cantidad de asistentes sea un número válido
        int cantidadMinima = 0;
        int cantidadMaxima = 999;
        if (cantidadAsistentes < cantidadMinima || cantidadAsistentes > cantidadMaxima) {
            return false;
        }

        return true;
    }

    public static boolean validarIdentificadorAccidente(int identificadorAccidente) {
        // Validar que el identificador del accidente sea un número válido
        int identificadorMinimo = 0;
        int identificadorMaximo = Integer.MAX_VALUE;
        if (identificadorAccidente < identificadorMinimo || identificadorAccidente > identificadorMaximo) {
            return false;
        }

        return true;
    }

    public static boolean validarIdentificadorVisita(int identificadorVisita) {
        // Validar que el identificador de la visita sea un número válido
        int identificadorMinimo = 0;
        int identificadorMaximo = Integer.MAX_VALUE;
        if (identificadorVisita < identificadorMinimo || identificadorVisita > identificadorMaximo) {
            return false;
        }

        return true;
    }

    public static boolean validarIdentificadorRevision(int identificadorRevision) {
        // Validar que el identificador de la revisión sea un número válido
        int identificadorMinimo = 0;
        int identificadorMaximo = Integer.MAX_VALUE;
        if (identificadorRevision < identificadorMinimo || identificadorRevision > identificadorMaximo) {
            return false;
        }

        return true;
    }
    
    public static boolean validarNumeroEntero(String numero) {
        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static boolean validarEstadoRevision(int estadoRevision) {
        // Validar que el estado de la revisión sea válido (1, 2 o 3)
        int[] estadosValidos = { 1, 2, 3 };
        for (int estado : estadosValidos) {
            if (estado == estadoRevision) {
                return true;
            }
        }

        return false;
    }


public static boolean validarDiaCapacitacion(String dia) {
    String[] diasPermitidos = { "lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo" };
    for (String diaPermitido : diasPermitidos) {
        if (dia.equalsIgnoreCase(diaPermitido)) {
            return true;
        }
    }
    return false;
}

public static boolean validarHoraCapacitacion(String hora) {
    try {
        LocalTime.parse(hora);
        return true;
    } catch (DateTimeParseException e) {
        return false;
    }
}}




