
package appinstrumentos;

import java.time.LocalDate;
import java.util.Scanner;

public class AppInstrumentos {

    
    public static void main(String[] args) {
       
        GestionInstrumentos gestionInstrumentos = new GestionInstrumentos();
        GestionPrestamos gestionPrestamos = new GestionPrestamos();
        Scanner scanner = new Scanner(System.in);

        // Ejemplos de instrumentos
        gestionInstrumentos.agregarInstrumento(new Instrumento("Guitarra", "Cuerdas", "Nuevo", 5));
        gestionInstrumentos.agregarInstrumento(new Instrumento("Violín", "Cuerdas Frotadas", "Usado", 3));
        gestionInstrumentos.agregarInstrumento(new Instrumento("Flauta", "Vientos o Maderas", "Nuevo", 2));

        int opcion;
        do {
            System.out.println("Sistema de Gestión de Préstamos de Instrumentos Musicales");
            System.out.println("1. Agregar Instrumento");
            System.out.println("2. Eliminar Instrumento");
            System.out.println("3. Actualizar Estado de Instrumento");
            System.out.println("4. Actualizar Cantidad Disponible");
            System.out.println("5. Mostrar Inventario");
            System.out.println("6. Realizar Préstamo");
            System.out.println("7. Devolver Instrumento");
            System.out.println("8. Mostrar Historial de Préstamos");
            System.out.println("9. Mostrar Instrumentos No Devueltos a Tiempo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del instrumento: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el grupo (Cuerdas, Cuerdas Frotadas, Vientos o Maderas, Metales, Percusión): ");
                    String grupo = scanner.nextLine();
                    System.out.print("Ingrese el estado (Nuevo, Usado, En reparación): ");
                    String estado = scanner.nextLine();
                    System.out.print("Ingrese la cantidad disponible: ");
                    int cantidad = scanner.nextInt();
                    gestionInstrumentos.agregarInstrumento(new Instrumento(nombre, grupo, estado, cantidad));
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del instrumento a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    gestionInstrumentos.eliminarInstrumento(nombreEliminar);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del instrumento: ");
                    String nombreActualizar = scanner.nextLine();
                    System.out.print("Ingrese el nuevo estado: ");
                    String nuevoEstado = scanner.nextLine();
                    gestionInstrumentos.actualizarEstadoInstrumento(nombreActualizar, nuevoEstado);
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del instrumento: ");
                    String nombreCantidad = scanner.nextLine();
                    System.out.print("Ingrese la nueva cantidad disponible: ");
                    int nuevaCantidad = scanner.nextInt();
                    gestionInstrumentos.actualizarCantidadDisponible(nombreCantidad, nuevaCantidad);
                    break;
                case 5:
                    gestionInstrumentos.mostrarInventario();
                    break;
                case 6:
                    System.out.print("Ingrese el nombre del instrumento a prestar: ");
                    String nombrePrestamo = scanner.nextLine();
                    System.out.print("Ingrese el nombre del miembro: ");
                    String miembro = scanner.nextLine();
                    System.out.print("Ingrese la fecha de inicio (YYYY-MM-DD): ");
                    LocalDate fechaInicio = LocalDate.parse(scanner.nextLine());
                    System.out.print("Ingrese la fecha de devolución (YYYY-MM-DD): ");
                    LocalDate fechaDevolucion = LocalDate.parse(scanner.nextLine());
                    Instrumento instrumento = gestionInstrumentos.buscarInstrumento(nombrePrestamo);
                    if (instrumento != null) {
                        gestionPrestamos.realizarPrestamo(instrumento, miembro, fechaInicio, fechaDevolucion);
                    } else {
                        System.out.println("Instrumento no encontrado.");
                    }
                    break;
                case 7:
                    System.out.print("Ingrese el nombre del instrumento a devolver: ");
                    String nombreDevolver = scanner.nextLine();
                    System.out.print("Ingrese el nombre del miembro: ");
                    String miembroDevolver = scanner.nextLine();
                    gestionPrestamos.devolverInstrumento(nombreDevolver, miembroDevolver);
                    break;
                case 8:
                    gestionPrestamos.mostrarHistorialPrestamos();
                    break;
                case 9:
                    gestionPrestamos.mostrarInstrumentosNoDevueltos();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}
        
 
