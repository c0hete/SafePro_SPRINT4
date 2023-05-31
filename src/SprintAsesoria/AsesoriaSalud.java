package SprintAsesoria;

import java.util.*;

//Clase AsesoríaSalud que implementa la interfaz Asesoría
class AsesoriaSalud implements Asesoria {
 private Profesional profesional;
 private List<Cliente> clientes;

 public AsesoriaSalud(Profesional profesional, List<Cliente> clientes) {
     this.profesional = profesional;
     this.clientes = clientes;
 }

 @Override
 public void analizarUsuario() {
     profesional.analizarUsuario();

     for (Cliente cliente : clientes) {
         cliente.analizarUsuario();
     }
 }

 public void mostrarClientesPorEdad() {
     // Implementación del método mostrarClientesPorEdad
 }

 public void mostrarClientesPorSistemaSalud() {
     // Implementación del método mostrarClientesPorSistemaSalud
 }

 // Otros métodos relevantes
}
