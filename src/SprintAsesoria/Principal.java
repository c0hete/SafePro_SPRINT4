	package SprintAsesoria;
	
	import java.time.LocalDate;
import java.time.LocalTime;
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
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Inicializar el formatter aquí
	
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
	        	System.out.println("6. Listar Usuarios");
	        	System.out.println("7. Listar Usuarios por Tipo");
	        	System.out.println("8. Listar Capacitaciones");
	        	System.out.println("9. Salir");
	        	System.out.print("Ingrese una opción: ");
	
	            // Leer la opción seleccionada por el usuario
	            opcion = scanner.nextInt();
	            scanner.nextLine(); // Limpiar el buffer
	
	            // Realizar la acción correspondiente según la opción seleccionada
	            switch (opcion) {
//CLIENTE*************************************************************************************************************************************************	            
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
	                            if (!Validaciones.validarCampoTexto(nombre, 5, 50)) {
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
	                                System.out.println("Cliente registrado exitosamente.");
	                                
	                                ingresoCorrecto = true; // El ingreso de datos fue exitoso
	                            }
	                            break;
	                            
	                        default:
	                            break;
	                    }
	                }
	                
	                break;
	                
//PROFESIONAL************************************************************************************************************************************************	                
	            case 2:
	                int rutProfesional = 0;
	                String titulo = "";
	                LocalDate fechaIngreso = null;
	                LocalDate fechaNacimientoProfesional = null;
	                String nombreProfesional = "";
	                boolean ingresoCorrecto2 = false;
	                int campoActual2 = 1;

	                while (!ingresoCorrecto2) {
	                    switch (campoActual2) {
	                    case 1:
                            // Solicitar el Nombre del Cliente al usuario
                            System.out.print("Ingrese el Nombre del Profesional: ");
                            nombreProfesional = scanner.nextLine();
                            
                            // Validar el Nombre del Cliente
                            if (!Validaciones.validarCampoTexto(nombreProfesional, 5, 50)) {
                                System.out.println("Nombre inválido. Por favor, ingrese un nombre válido.");
                            } else {
                                campoActual2++; // Pasar al siguiente campo
                            }
                            break;
	                        case 2:
	                            // Solicitar el Rut del Profesional al usuario
	                            System.out.print("Ingrese el Rut del Profesional: ");
	                            String rutProfesionalStr = scanner.nextLine();

	                            // Validar que el Rut sea un número válido
	                            if (!Validaciones.validarNumeroEntero(rutProfesionalStr)) {
	                                System.out.println("Rut inválido. Por favor, ingrese un Rut válido.");
	                            } else {
	                                rutProfesional = Integer.parseInt(rutProfesionalStr);
	                                campoActual2++; // Pasar al siguiente campo
	                            }
	                            break;

	                        case 3:
	                            // Solicitar la Fecha de Nacimiento del Profesional al usuario
	                            System.out.print("Ingrese la Fecha de Nacimiento del Profesional (formato: DD/MM/AAAA): ");
	                            String fechaNacimientoProfesionalStr = scanner.nextLine();

	                            // Validar el formato de la Fecha de Nacimiento
	                            if (!Validaciones.validarFormatoFecha(fechaNacimientoProfesionalStr, "dd/MM/yyyy")) {
	                                System.out.println("Fecha de Nacimiento inválida. Por favor, ingrese una fecha válida en formato DD/MM/AAAA.");
	                            } else {
	                                try {
	                                    fechaNacimientoProfesional = LocalDate.parse(fechaNacimientoProfesionalStr, formatter);
	                                    campoActual2++; // Pasar al siguiente campo
	                                } catch (DateTimeParseException e) {
	                                    System.out.println("Fecha de Nacimiento inválida. Por favor, ingrese una fecha de nacimiento válida.");
	                                }
	                            }
	                            break;

	                        case 4:
	                            // Solicitar el Título del Profesional al usuario
	                            System.out.print("Ingrese el Título del Profesional: ");
	                            titulo = scanner.nextLine();

	                            // Validar el Título del Profesional
	                            if (!Validaciones.validarCampoTexto(titulo, 10, 50)) {
	                                System.out.println("Título inválido. Por favor, ingrese un título válido.");
	                            } else {
	                                campoActual2++; // Pasar al siguiente campo
	                            }
	                            break;

	                        case 5:
	                            // Solicitar la Fecha de Ingreso del Profesional al usuario
	                            System.out.print("Ingrese la Fecha de Ingreso del Profesional (formato: DD/MM/AAAA): ");
	                            String fechaIngresoStr = scanner.nextLine();

	                            // Validar el formato de la Fecha de Ingreso
	                            if (!Validaciones.validarFormatoFecha(fechaIngresoStr, "dd/MM/yyyy")) {
	                                System.out.println("Fecha de Ingreso inválida. Por favor, ingrese una fecha válida en formato DD/MM/AAAA.");
	                            } else {
	                                try {
	                                    fechaIngreso = LocalDate.parse(fechaIngresoStr, formatter);
	                                    ingresoCorrecto2 = true; // El ingreso de datos fue exitoso
	                                } catch (DateTimeParseException e) {
	                                    System.out.println("Fecha de Ingreso inválida. Por favor, ingrese una fecha de ingreso válida.");
	                                }
	                            }
	                            break;

	                        default:
	                            break;
	                    }
	                }

	                // Crear la instancia de Profesional y almacenarla en el Contenedor
	                Profesional profesional = new Profesional(nombreProfesional, rutProfesional, fechaNacimientoProfesional, titulo, fechaIngreso);
	                contenedor.almacenarProfesional(profesional);

	                System.out.println("Profesional registrado exitosamente.");
	                break;

//ADMINISTRATIVO*********************************************************************************************************************************************************
	            case 3:
	                int rutAdministrativo = 0;
	                String nombreAdministrativo = "";
	                LocalDate fechaNacimientoAdministrativo = null;
	                String area = "";
	                String experienciaPrevia = "";
	                boolean ingresoCorrecto3 = false;
	                int campoActual3 = 1;
	                

	                while (!ingresoCorrecto3) {
	                    switch (campoActual3) {
	                        case 1:
	                            // Solicitar el Rut del Administrativo al usuario
	                            System.out.print("Ingrese el Rut del Administrativo: ");
	                            String rutAdministrativoStr = scanner.nextLine();

	                            // Validar que el Rut sea un número válido
	                            if (!Validaciones.validarNumeroEntero(rutAdministrativoStr)) {
	                                System.out.println("Rut inválido. Por favor, ingrese un Rut válido.");
	                            } else {
	                                rutAdministrativo = Integer.parseInt(rutAdministrativoStr);
	                                campoActual3++; // Pasar al siguiente campo
	                            }
	                            break;

	                        case 2:
	                            // Solicitar la Fecha de Nacimiento del Administrativo al usuario
	                            System.out.print("Ingrese la Fecha de Nacimiento del Administrativo (formato: DD/MM/AAAA): ");
	                            String fechaNacimientoAdministrativoStr = scanner.nextLine();

	                            // Validar el formato de la Fecha de Nacimiento
	                            if (!Validaciones.validarFormatoFecha(fechaNacimientoAdministrativoStr, "dd/MM/yyyy")) {
	                                System.out.println("Fecha de Nacimiento inválida. Por favor, ingrese una fecha válida en formato DD/MM/AAAA.");
	                            } else {
	                                try {
	                                    fechaNacimientoAdministrativo = LocalDate.parse(fechaNacimientoAdministrativoStr, formatter);
	                                    campoActual3++; // Pasar al siguiente campo
	                                } catch (DateTimeParseException e) {
	                                    System.out.println("Fecha de Nacimiento inválida. Por favor, ingrese una fecha de nacimiento válida.");
	                                }
	                            }
	                            break;

	                        case 3:
	                            // Solicitar el Área del Administrativo al usuario
	                            System.out.print("Ingrese el Área del Administrativo: ");
	                            area = scanner.nextLine();

	                            // Validar el Área del Administrativo
	                            if (!Validaciones.validarCampoTexto(area, 5, 20)) {
	                                System.out.println("Área inválida. Por favor, ingrese un área válida (mínimo 5 caracteres, máximo 20 caracteres).");
	                            } else {
	                                campoActual3++; // Pasar al siguiente campo
	                            }
	                            break;

	                        case 4:
	                            // Solicitar la Experiencia previa del Administrativo al usuario
	                            System.out.print("Ingrese la Experiencia previa del Administrativo: ");
	                            experienciaPrevia = scanner.nextLine();

	                            // Validar la Experiencia previa del Administrativo
	                            if (!Validaciones.validarCampoTexto(experienciaPrevia, 0, 100)) {
	                                System.out.println("Experiencia previa inválida. Por favor, ingrese una experiencia válida (máximo 100 caracteres).");
	                            } else {
	                                ingresoCorrecto3 = true; // El ingreso de datos fue exitoso
	                            }
	                            break;

	                        default:
	                            break;
	                    }
	                }

	                // Crear la instancia de Administrativo y almacenarla en el Contenedor
	                Administrativo administrativo = new Administrativo(nombreAdministrativo, rutAdministrativo, fechaNacimientoAdministrativo, area, experienciaPrevia);
	                contenedor.almacenarAdministrativo(administrativo);

	                System.out.println("Administrativo registrado exitosamente.");

	                break;
	                
//CAPACITACIÓN ********************************************************************************************************************************************
	            case 4:
	                int rutCliente = 0;
	                String diaCapacitacion = "";
	                String horaCapacitacion = "";
	                String lugarCapacitacion = "";
	                String duracionCapacitacion = "";
	                int cantidadAsistentes = 0;

	                boolean ingresoCorrecto4 = false;
	                int campoActual4 = 1;

	                while (!ingresoCorrecto4) {
	                    switch (campoActual4) {
	                        case 1:
	                            // Solicitar el RUT del Cliente al usuario
	                            System.out.print("Ingrese el RUT del Cliente: ");
	                            String rutClienteStr = scanner.nextLine();

	                            // Validar que el RUT sea un número válido
	                            if (!Validaciones.validarNumeroEntero(rutClienteStr)) {
	                                System.out.println("RUT inválido. Por favor, ingrese un RUT válido.");
	                            } else {
	                                rutCliente = Integer.parseInt(rutClienteStr);
	                                campoActual4++; // Pasar al siguiente campo
	                            }
	                            break;

	                        case 2:
	                            // Solicitar el Día de la Capacitación al usuario
	                            System.out.print("Ingrese el Día de la Capacitación (formato: lunes a domingo): ");
	                            diaCapacitacion = scanner.nextLine();

	                            // Validar el Día de la Capacitación
	                            if (!Validaciones.validarDiaCapacitacion(diaCapacitacion)) {
	                                System.out.println("Día inválido. Por favor, ingrese un día válido (lunes a domingo).");
	                            } else {
	                                campoActual4++; // Pasar al siguiente campo
	                            }
	                            break;

	                        case 3:
	                            // Solicitar la Hora de la Capacitación al usuario
	                            System.out.print("Ingrese la Hora de la Capacitación (formato: HH:MM): ");
	                            horaCapacitacion = scanner.nextLine();

	                            // Validar la Hora de la Capacitación
	                            if (!Validaciones.validarHoraCapacitacion(horaCapacitacion)) {
	                                System.out.println("Hora inválida. Por favor, ingrese una hora válida (formato: HH:MM).");
	                            } else {
	                                campoActual4++; // Pasar al siguiente campo
	                            }
	                            break;

	                        case 4:
	                            // Solicitar el Lugar de la Capacitación al usuario
	                            System.out.print("Ingrese el Lugar de la Capacitación: ");
	                            lugarCapacitacion = scanner.nextLine();

	                            // Validar el Lugar de la Capacitación
	                            if (!Validaciones.validarCampoTexto(lugarCapacitacion, 10, 50)) {
	                                System.out.println("Lugar inválido. Por favor, ingrese un lugar válido (mínimo 10 caracteres, máximo 50 caracteres).");
	                            } else {
	                                campoActual4++; // Pasar al siguiente campo
	                            }
	                            break;

	                        case 5:
	                            // Solicitar la Duración de la Capacitación al usuario
	                            System.out.print("Ingrese la Duración de la Capacitación: ");
	                            duracionCapacitacion = scanner.nextLine();

	                            // Validar la Duración de la Capacitación
	                            if (!Validaciones.validarCampoTexto(duracionCapacitacion, 0, 70)) {
	                                System.out.println("Duración inválida. Por favor, ingrese una duración válida (máximo 70 caracteres).");
	                            } else {
	                                campoActual4++; // Pasar al siguiente campo
	                            }
	                            break;

	                        case 6:
	                            // Solicitar la Cantidad de Asistentes de la Capacitación al usuario
	                            System.out.print("Ingrese la Cantidad de Asistentes: ");
	                            String cantidadAsistentesStr = scanner.nextLine();

	                            // Validar que la Cantidad de Asistentes sea un número válido
	                            if (!Validaciones.validarNumeroEntero(cantidadAsistentesStr)) {
	                                System.out.println("Cantidad de Asistentes inválida. Por favor, ingrese una cantidad válida.");
	                            } else {
	                                cantidadAsistentes = Integer.parseInt(cantidadAsistentesStr);
	                                campoActual4++; // Pasar al siguiente campo
	                                ingresoCorrecto4 = true; // Actualizar la variable de control
	                            }
	                            break;
	                    }
	                }

	                // Crear la instancia de Capacitacion con generación automática del identificador
	                Capacitacion capacitacion = new Capacitacion(rutCliente, diaCapacitacion, horaCapacitacion, lugarCapacitacion, duracionCapacitacion, cantidadAsistentes);

	                // Almacenar la capacitación en el Contenedor
	                contenedor.almacenarCapacitacion(capacitacion);

	                System.out.println("Capacitación registrada exitosamente.");
	                break;
//ELIMINAR USUARIO*******************************************************************************************************************************
	
	                case 5:
	                    // Solicitar el Rut del usuario a eliminar
	                    System.out.print("Ingrese el Rut del Usuario a eliminar: ");
	                    int rutEliminar = scanner.nextInt();
	                    scanner.nextLine(); // Limpiar el buffer
	                    // Eliminar el usuario del Contenedor
	                    contenedor.eliminarUsuario(rutEliminar);
	                    break;
	                    
	                case 6:
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
	
	                case 7:
	                    // Solicitar el tipo de usuario a listar
	                    System.out.print("Ingrese el tipo de Usuario a listar (Cliente, Profesional, Administrativo): ");
	                    String tipoUsuario = scanner.nextLine();
	                    // Listar los usuarios del tipo especificado
	                    contenedor.listarUsuariosPorTipo(tipoUsuario);
	                    break;
	                case 8:
	                    List<Capacitacion> capacitacionesList = contenedor.getCapacitaciones();
	                    if (capacitacionesList.isEmpty()) {
	                        System.out.println("No hay capacitaciones registradas.");
	                    } else {
	                        System.out.println("----- LISTA DE CAPACITACIONES -----");
	                        for (Capacitacion capacitacion1 : capacitacionesList) {
	                            System.out.println("Capacitación ID: " + capacitacion1.getIdentificador());
	                            Cliente cliente = contenedor.getClientePorRut(capacitacion1.getRutCliente());
	                            if (cliente != null) {
	                                System.out.println("Cliente asociado: " + cliente.toString());
	                            } else {
	                                System.out.println("Cliente asociado: No se encontró el cliente.");
	                            }
	                            System.out.println("Lugar: " + capacitacion1.getLugar());
	                            System.out.println("Hora: " + capacitacion1.getHora());
	                            System.out.println("Día: " + capacitacion1.getDia());
	                            System.out.println("Duración: " + capacitacion1.getDuracion());
	                            System.out.println("-----------------------------------");
	                        }
	                    }
	                    break;

	                case 9:
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
