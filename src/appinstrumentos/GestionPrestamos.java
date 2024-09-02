
package appinstrumentos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestionPrestamos {
   
    
    private List<Prestamo> prestamos;

    public GestionPrestamos() {
        this.prestamos = new ArrayList<>();
    }

    public void realizarPrestamo(Instrumento instrumento, String miembro, LocalDate fechaInicio, LocalDate fechaDevolucion) {
        if (instrumento.getCantidadDisponible() > 0) {
            Prestamo prestamo = new Prestamo(instrumento, miembro, fechaInicio, fechaDevolucion);
            prestamos.add(prestamo);
            instrumento.decrementarCantidad(1);
            System.out.println("Préstamo realizado con éxito.");
        } else {
            System.out.println("Instrumento no disponible.");
        }
    }

    public void devolverInstrumento(String nombreInstrumento, String miembro) {
        Prestamo prestamoAEliminar = null;
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getInstrumento().getNombre().equalsIgnoreCase(nombreInstrumento) && prestamo.getMiembro().equalsIgnoreCase(miembro)) {
                prestamo.getInstrumento().incrementarCantidad(1);
                prestamoAEliminar = prestamo;
                System.out.println("Instrumento devuelto con éxito.");
                break;
            }
        }
        if (prestamoAEliminar != null) {
            prestamos.remove(prestamoAEliminar);
        }
    }

    public void mostrarHistorialPrestamos() {
        for (Prestamo prestamo : prestamos) {
            System.out.println(prestamo);
        }
    }

    public void mostrarInstrumentosNoDevueltos() {
        LocalDate hoy = LocalDate.now();
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getFechaDevolucion().isBefore(hoy)) {
                System.out.println("Instrumento no devuelto a tiempo: " + prestamo);
            }
        }
    }
}
