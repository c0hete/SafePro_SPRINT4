	package SprintAsesoria;
	
	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;
	import java.time.format.DateTimeParseException;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;
	
	// Clase Principal para probar la funcionalidad
	@SuppressWarnings("unused")
	public class Principal {
	    public static void main(String[] args) {
	        // Crear objeto de Contenedor
	        Contenedor contenedor = new Contenedor();
	
	        // Crear objeto Scanner para leer la entrada del usuario
	        Scanner scanner = new Scanner(System.in);
	
	        // Variable para almacenar la opción seleccionada por el usuario
	        int opcion;
	
	        do {
	            // Mostrar el menú de opciones
	            System.out.println("----- MENÚ -----");
	            System.out.println("1. Almacenar Cliente");
	            System.out.println("2. Almacenar Profesional");
	            System.out.println("3. Almacenar Administrativo");
	            System.out.println("4. Almacenar Capacitación");
	            System.out.println("5. Eliminar Usuario");
	            System.out.println("6. Eliminar Capacitación");
	            System.out.println("7. Listar Usuarios");
	            System.out.println("8. Listar Usuarios por Tipo");
	            System.out.println("9. Listar Capacitaciones");
	            System.out.println("10. Salir");
	            System.out.print("Ingrese una opción: ");
	
	            // Leer la opción seleccionada por el usuario
	            opcion = scanner.nextInt();
	            scanner.nextLine(); // Limpiar el buffer
	
	            // Realizar la acción correspondiente según la opción seleccionada
	            switch (opcion) {
	            case 1:
	                boolean ingresoCorrecto = false;
	                int campoActual = 1; // Variable para realizar un seguimiento del campo actual
	                
	                int rut = 0;
	                String nombre = "";
	                String apellido = "";
	                LocalDate fechaNacimiento = null;
	                String telefono = "";
	                String afp = "";
	                boolean esFonasa = false;
	                String direccion = "";
	                String comuna = "";
	                
	                while (!ingresoCorrecto) {
	                    switch (campoActual) {
	                        case 1:
	                            // Solicitar el Rut del Cliente al usuario
	                            System.out.print("Ingrese el Rut del Cliente: ");
	                            String rutStr = scanner.nextLine();
	                            
	                            // Validar que el Rut sea un número válido
	                            if (!Validaciones.validarNumeroEntero(rutStr)) {
	                                System.out.println("Rut inválido. Por favor, ingrese un Rut válido.");
	                            } else {
	                                rut = Integer.parseInt(rutStr);
	                                
	                                // Validar el Rut del Cliente
	                                if (!Validaciones.validarRut(rut)) {
	                                    System.out.println("Rut inválido. Por favor, ingrese un Rut válido.");
	                                } else {
	                                    campoActual++; // Pasar al siguiente campo
	                                }
	                            }
	                            break;
	                            
	                        case 2:
	                            // Solicitar el Nombre del Cliente al usuario
	                            System.out.print("Ingrese el Nombre del Cliente: ");
	                            nombre = scanner.nextLine();
	                            
	                            // Validar el Nombre del Cliente
	                            if (!Validaciones.validarCampoTexto(nombre, 1, 50)) {
	                                System.out.println("Nombre inválido. Por favor, ingrese un nombre válido.");
	                            } else {
	                                campoActual++; // Pasar al siguiente campo
	                            }
	                            break;
	                            
	                        case 3:
	                            // Solicitar el Apellido del Cliente al usuario
	                            System.out.print("Ingrese el Apellido del Cliente: ");
	                            apellido = scanner.nextLine();
	                            
	                            // Validar el Apellido del Cliente
	                            if (!Validaciones.validarCampoTexto(apellido, 5, 50)) {
	                                System.out.println("Apellido inválido. Por favor, ingrese un apellido válido.");
	                            } else {
	                                campoActual++; // Pasar al siguiente campo
	                            }
	                            break;
	                            
	                        case 4:
	                            // Solicitar la Fecha de Nacimiento del Cliente al usuario
	                            System.out.print("Ingrese la Fecha de Nacimiento del Cliente (formato: DD/MM/AAAA): ");
	                            String fechaNacimientoStr = scanner.nextLine();
	                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	                            
	                            // Validar el formato de la Fecha de Nacimiento
	                            if (!Validaciones.validarFormatoFecha(fechaNacimientoStr, "dd/MM/yyyy")) {
	                                System.out.println("Fecha de Nacimiento inválida. Por favor, ingrese una fecha válida en formato DD/MM/AAAA.");
	                            } else {
	                                try {
	                                    fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);
	                                    
	                                    campoActual++; // Pasar al siguiente campo
	                                } catch (DateTimeParseException e) {
	                                    System.out.println("Fecha de Nacimiento inválida. Por favor, ingrese una fecha de nacimiento válida.");
	                                }
	                            }
	                            break;
	                            
	                        case 5:
	                            // Solicitar el Teléfono del Cliente al usuario
	                            System.out.print("Ingrese el Teléfono del Cliente: ");
	                            telefono = scanner.nextLine();
	                            
	                            // Validar el Teléfono del Cliente
	                            if (!Validaciones.validarCampoTexto(telefono, 8, 15)) {
	                                System.out.println("Teléfono inválido. Por favor, ingrese un teléfono válido.");
	                            } else {
	                                campoActual++; // Pasar al siguiente campo
	                            }
	                            break;
	                            
	                        case 6:
	                            // Solicitar la AFP del Cliente al usuario
	                            System.out.print("Ingrese la AFP del Cliente: ");
	                            afp = scanner.nextLine();
	                            
	                            // Validar la AFP del Cliente
	                            if (!Validaciones.validarCampoTexto(afp, 4, 30)) {
	                                System.out.println("AFP inválida. Por favor, ingrese una AFP válida.");
	                            } else {
	                                campoActual++; // Pasar al siguiente campo
	                            }
	                            break;
	                            
	                        case 7:
	                            // Solicitar el sistema de Salud del Cliente al usuario
	                            System.out.println("Seleccione el sistema de Salud:");
	                            System.out.println("1. Fonasa");
	                            System.out.println("2. Isapre");
	                            int opcionSalud = scanner.nextInt();
	                            scanner.nextLine(); // Limpiar el buffer
	                            
	                            // Validar la opción de salud
	                            if (!Validaciones.validarOpcionSalud(opcionSalud)) {
	                                System.out.println("Opción de salud inválida. Por favor, ingrese una opción válida (1 o 2).");
	                            } else {
	                                esFonasa = opcionSalud == 1;
	                                campoActual++; // Pasar al siguiente campo
	                            }
	                            break;
	                            
	                        case 8:
	                            // Solicitar la Dirección del Cliente al usuario
	                            System.out.print("Ingrese la Dirección del Cliente: ");
	                            direccion = scanner.nextLine();
	                            
	                            // Validar la Dirección del Cliente
	                            if (!Validaciones.validarCampoTexto(direccion, 1, 70)) {
	                                System.out.println("Dirección inválida. Por favor, ingrese una dirección válida.");
	                            } else {
	                                campoActual++; // Pasar al siguiente campo
	                            }
	                            break;
	                            
	                        case 9:
	                            // Solicitar la Comuna del Cliente al usuario
	                            System.out.print("Ingrese la Comuna del Cliente: ");
	                            comuna = scanner.nextLine();
	                            
	                            // Validar la Comuna del Cliente
	                            if (!Validaciones.validarCampoTexto(comuna, 1, 50)) {
	                                System.out.println("Comuna inválida. Por favor, ingrese una comuna válida.");
	                            } else {
	                                Cliente cliente = new Cliente(nombre, rut, fechaNacimiento, telefono, afp, esFonasa, direccion, comuna, apellido);
	                                
	                                // Almacenar el cliente en el Contenedor
	                                contenedor.almacenarCliente(cliente);
	                                
	                                ingresoCorrecto = true; // El ingreso de datos fue exitoso
	                            }
	                            break;
	                            
	                        default:
	                            break;
	                    }
	                }
	                
	                break;

	
	                case 2:
	                    // Solicitar los datos del profesional al usuario
	                    System.out.print("Ingrese el Nombre del Profesional: ");
	                    String nombreProfesional = scanner.nextLine();
	                    System.out.print("Ingrese el Rut del Profesional: ");
	                    int rutProfesional = scanner.nextInt();
	                    System.out.print("Ingrese la Fecha de Nacimiento del Profesional (formato DD/MM/AAAA): ");
	                    String fechaNacimientoProfesionalStr = scanner.nextLine();
	                    LocalDate fechaNacimientoProfesional = LocalDate.parse(fechaNacimientoProfesionalStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	                    System.out.print("Ingrese el Título del Profesional: ");
	                    String tituloProfesional = scanner.nextLine();
	                    System.out.print("Ingrese la Fecha de Ingreso del Profesional (formato DD/MM/AAAA): ");
	                    String fechaIngresoProfesionalStr = scanner.nextLine();
	                    LocalDate fechaIngresoProfesional = LocalDate.parse(fechaIngresoProfesionalStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	
	                    // Crear un objeto Profesional con los datos ingresados
	                    Profesional profesional = new Profesional(nombreProfesional, rutProfesional, fechaNacimientoProfesional, tituloProfesional, fechaIngresoProfesional);
	
	                    // Almacenar el profesional en el Contenedor
	                    contenedor.almacenarProfesional(profesional);
	                    break;
	
	                case 3:
	                    // Solicitar los datos del administrativo al usuario
	                    System.out.print("Ingrese el Nombre del Administrativo: ");
	                    String nombreAdministrativo = scanner.nextLine();
	                    System.out.print("Ingrese el Rut del Administrativo: ");
	                    int rutAdministrativo = scanner.nextInt();
	                    scanner.nextLine(); // Limpiar el buffer
	                    System.out.print("Ingrese la Fecha de Nacimiento del Administrativo (formato DD/MM/AAAA): ");
	                    String fechaNacimientoAdministrativoStr = scanner.nextLine();
	                    LocalDate fechaNacimientoAdministrativo = LocalDate.parse(fechaNacimientoAdministrativoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	                    System.out.print("Ingrese el Área del Administrativo: ");
	                    String areaAdministrativo = scanner.nextLine();
	                    System.out.print("Ingrese la Experiencia Previa del Administrativo: ");
	                    String experienciaPreviaAdministrativo = scanner.nextLine();
	
	                    // Crear un objeto Administrativo con los datos ingresados
	                    Administrativo administrativo = new Administrativo(nombreAdministrativo, rutAdministrativo, fechaNacimientoAdministrativo, areaAdministrativo, experienciaPreviaAdministrativo);
	                    // Almacenar el administrativo en el Contenedor
	                    contenedor.almacenarAdministrativo(administrativo);
	                    break;
	
	                case 4:
	                    // Solicitar los datos de la capacitación al usuario
	                    System.out.print("Ingrese el Rut del Cliente: ");
	                    int rutCliente = scanner.nextInt();
	                    System.out.print("Ingrese el Nombre de la Capacitación: ");
	                    String nombreCapacitacion = scanner.nextLine();
	                    System.out.print("Ingrese la Fecha de la Capacitación (formato DD/MM/AAAA): ");
	                    String fechaCapacitacionStr = scanner.nextLine();
	                    System.out.print("Ingrese la Duración de la Capacitación (en horas): ");
	                    int duracionCapacitacion = scanner.nextInt();
	                    System.out.print("Ingrese la Cantidad de Cupos para la Capacitación: ");
	                    int cuposCapacitacion = scanner.nextInt();
	                    scanner.nextLine(); // Limpiar el buffer
	
	                    // Crear un objeto Capacitación con los datos ingresados
	                    Capacitacion capacitacion = new Capacitacion(rutCliente, nombreCapacitacion, fechaCapacitacionStr, duracionCapacitacion, cuposCapacitacion);
	
	                    // Almacenar la capacitación en el Contenedor
	                    contenedor.almacenarCapacitacion(capacitacion);
	                    break;
	
	                case 5:
	                    // Solicitar el Rut del usuario a eliminar
	                    System.out.print("Ingrese el Rut del Usuario a eliminar: ");
	                    int rutEliminar = scanner.nextInt();
	                    scanner.nextLine(); // Limpiar el buffer
	                    // Eliminar el usuario del Contenedor
	                    contenedor.eliminarUsuario(rutEliminar);
	                    break;
	                case 6:
	                    // Solicitar el ID de la capacitación a eliminar
	                    System.out.print("Ingrese el ID de la Capacitación a eliminar: ");
	                    int idEliminar = scanner.nextInt();
	                    scanner.nextLine(); // Limpiar el buffer
	                    // Eliminar la capacitación del Contenedor
	                    contenedor.eliminarCapacitacion(idEliminar);
	                    break;
	                case 7:
	                    // Listar todos los usuarios
	                    contenedor.listarUsuarios();
	
	                    // Obtener la lista de usuarios del contenedor
	                    List<Usuario> usuarios = contenedor.getUsuarios();
	
	                    // Recorrer la lista de usuarios
	                    for (Usuario usuario : usuarios) {
	                        // Verificar si el usuario es de tipo Cliente
	                        if (usuario instanceof Cliente) {
	                            Cliente clienteUsuario = (Cliente) usuario;
	                            // Imprimir los datos del cliente
	                            System.out.println("Rut: " + clienteUsuario.getRut());
	                            System.out.println("Nombre: " + clienteUsuario.getNombre());
	                            System.out.println("Apellido: " + clienteUsuario.getApellido());
	                            System.out.println("Fecha de Nacimiento: " + clienteUsuario.getFechaNacimiento());
	                            System.out.println("Edad: " + clienteUsuario.mostrarEdad());
	                            System.out.println("Dirección: " + clienteUsuario.getDireccion());
	                            System.out.println("Comuna: " + clienteUsuario.getComuna());
	                            System.out.println("Sistema de Salud: " + (clienteUsuario.isEsFonasa() ? "Fonasa" : "Isapre"));
	                            System.out.println("------");
	                        }
	                        // Verificar si el usuario es de tipo Profesional
	                        else if (usuario instanceof Profesional) {
	                            Profesional profesionalUsuario = (Profesional) usuario;
	                            // Imprimir los datos del profesional
	                            System.out.println("Rut: " + profesionalUsuario.getRut());
	                            System.out.println("Nombre: " + profesionalUsuario.getNombre());
	                            System.out.println("Fecha de Nacimiento: " + profesionalUsuario.getFechaNacimiento());
	                            System.out.println("Edad: " + profesionalUsuario.mostrarEdad());
	                            System.out.println("Título: " + profesionalUsuario.getTitulo());
	                            System.out.println("Fecha de Ingreso: " + profesionalUsuario.getFechaIngreso());
	                            System.out.println("------");
	                        }
	                        // Verificar si el usuario es de tipo Administrativo
	                        else if (usuario instanceof Administrativo) {
	                            Administrativo administrativoUsuario = (Administrativo) usuario;
	                            System.out.println("Rut: " + administrativoUsuario.getRut());
	                            System.out.println("Nombre: " + administrativoUsuario.getNombre());
	                            System.out.println("Fecha de Nacimiento: " + administrativoUsuario.getFechaNacimiento());
	                            System.out.println("Edad: " + administrativoUsuario.mostrarEdad());
	                            System.out.println("Título: " + administrativoUsuario.getArea());
	                            System.out.println("Fecha de Ingreso: " + administrativoUsuario.getExperienciaPrevia());
	                            System.out.println("------");
	                        }
	                    }
	                    break;
	
	                case 8:
	                    // Solicitar el tipo de usuario a listar
	                    System.out.print("Ingrese el tipo de Usuario a listar (Cliente, Profesional, Administrativo): ");
	                    String tipoUsuario = scanner.nextLine();
	                    // Listar los usuarios del tipo especificado
	                    contenedor.listarUsuariosPorTipo(tipoUsuario);
	                    break;
	                case 9:
	                    // Listar todas las capacitaciones
	                    contenedor.listarCapacitaciones();
	                    break;
	                case 10:
	                    // Salir del programa
	                    System.out.println("¡Hasta luego!");
	                    break;
	                default:
	                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
	                    break;
	            }
	        } while (opcion != 10);
	
	        // Cerrar el objeto Scanner
	        scanner.close();
	    }
	}
