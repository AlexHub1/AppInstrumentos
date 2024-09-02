
package appinstrumentos;

import java.time.LocalDate;


public class Prestamo {
   
    private Instrumento instrumento;
    private String miembro;
    private LocalDate fechaInicio;
    private LocalDate fechaDevolucion;

    public Prestamo(Instrumento instrumento, String miembro, LocalDate fechaInicio, LocalDate fechaDevolucion) {
        this.instrumento = instrumento;
        this.miembro = miembro;
        this.fechaInicio = fechaInicio;
        this.fechaDevolucion = fechaDevolucion;
    }

    // Getters y Setters
    public Instrumento getInstrumento() { return instrumento; }
    public void setInstrumento(Instrumento instrumento) { this.instrumento = instrumento; }

    public String getMiembro() { return miembro; }
    public void setMiembro(String miembro) { this.miembro = miembro; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(LocalDate fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }

    @Override
    public String toString() {
        return "Préstamo: " + instrumento.getNombre() + " a " + miembro + ", Fecha de inicio: " + fechaInicio + ", Fecha de devolución: " + fechaDevolucion;
    }
}
