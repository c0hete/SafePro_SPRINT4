/**
 * Esta clase actúa como un contenedor para almacenar y gestionar usuarios y capacitaciones.
 * Proporciona métodos para almacenar, eliminar y listar usuarios, así como también para almacenar y listar capacitaciones.
 */
package SprintAsesoria;

import java.util.ArrayList;
import java.util.List;

public class Contenedor {
    private List<Asesoria> asesorias;
    private List<Capacitacion> capacitaciones;

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

    public List<Capacitacion> getCapacitaciones() {
        return capacitaciones;
    }

    public List<Usuario> getUsuariosPorTipo(String tipo) {
        List<Usuario> usuariosPorTipo = new ArrayList<>();
        for (Asesoria asesoria : asesorias) {
            if (asesoria.getClass().getSimpleName().equalsIgnoreCase(tipo) && asesoria instanceof Usuario) {
                usuariosPorTipo.add((Usuario) asesoria);
            }
        }
        return usuariosPorTipo;
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
        List<Usuario> usuariosPorTipo = getUsuariosPorTipo(tipo);
        for (Usuario usuario : usuariosPorTipo) {
            System.out.println(usuario.toString());
        }
    }

    public void listarCapacitaciones() {
        for (Capacitacion capacitacion : capacitaciones) {
            System.out.println(capacitacion.toString());
            int rutCliente = capacitacion.getRutCliente();
            for (Asesoria asesoria : asesorias) {
                if (asesoria instanceof Cliente) {
                    Cliente cliente = (Cliente) asesoria;
                    if (cliente.getRut() == rutCliente) {
                        System.out.println(cliente.toString());
                        break;
                    }
                }
            }
        }
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

    public Cliente getClientePorRut(int rut) {
        for (Asesoria asesoria : asesorias) {
            if (asesoria instanceof Cliente) {
                Cliente cliente = (Cliente) asesoria;
                if (cliente.getRut() == rut) {
                    return cliente;
                }
            }
        }
        return null; // Retorna null si no se encuentra el cliente
    }
}



