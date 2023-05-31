package SprintAsesoria;

import java.util.ArrayList;
import java.util.List;

public class Contenedor {
    private List<Asesoria> asesorias;
    private List<Capacitacion> capacitaciones;

    public Contenedor(List<Asesoria> asesorias, List<Capacitacion> capacitaciones) {
        this.asesorias = asesorias;
        this.capacitaciones = capacitaciones;
    }

    public Contenedor() {
        asesorias = new ArrayList<>();
        capacitaciones = new ArrayList<>();
    }

    public void almacenarCliente(Cliente cliente) {
        asesorias.add(cliente);
    }

    public void almacenarProfesional(Profesional profesional) {
        asesorias.add(profesional);
    }

    public void almacenarAdministrativo(Administrativo administrativo) {
        asesorias.add(administrativo);
    }

    public void almacenarCapacitacion(Capacitacion capacitacion) {
        capacitaciones.add(capacitacion);
    }

    public void eliminarUsuario(int rutEliminar) {
        for (Asesoria asesoria : asesorias) {
            if (asesoria instanceof Usuario) {
                Usuario usuario = (Usuario) asesoria;
                if (usuario.getRut() == rutEliminar) {
                    asesorias.remove(asesoria);
                    break;
                }
            }
        }
    }

    public void listarUsuarios() {
        for (Asesoria asesoria : asesorias) {
            if (asesoria instanceof Usuario) {
                Usuario usuario = (Usuario) asesoria;
                System.out.println(usuario.toString());
            }
        }
    }

    public void listarUsuariosPorTipo(String tipo) {
        for (Asesoria asesoria : asesorias) {
            if (asesoria.getClass().getSimpleName().equalsIgnoreCase(tipo)) {
                System.out.println(asesoria.toString());
            }
        }
    }

    public void listarCapacitaciones() {
        for (Capacitacion capacitacion : capacitaciones) {
            System.out.println(capacitacion.toString());
            int rutCliente = capacitacion.getRutCliente();
            for (Asesoria asesoria : asesorias) {
                if (asesoria instanceof Cliente) {
                    Cliente cliente = (Cliente) asesoria;
                    if (cliente.getRut() == rutCliente) {  // Corregir el uso de getRut()
                        System.out.println(cliente.toString());
                        break;
                    }
                }
            }
        }
    }


    public void eliminarCapacitacion(int idEliminar) {
        // TODO: Implement code to remove capacitacion from the list
    }

    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        for (Asesoria asesoria : asesorias) {
            if (asesoria instanceof Usuario) {
                usuarios.add((Usuario) asesoria);
            }
        }
        return usuarios;
    }
}

