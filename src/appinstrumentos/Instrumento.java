
package appinstrumentos;

class Instrumento {
   
    private String nombre;
    private String grupo;
    private String estado; // nuevo, usado, en reparación
    private int cantidadDisponible;

    public Instrumento(String nombre, String grupo, String estado, int cantidadDisponible) {
        this.nombre = nombre;
        this.grupo = grupo;
        this.estado = estado;
        this.cantidadDisponible = cantidadDisponible;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getGrupo() { return grupo; }
    public void setGrupo(String grupo) { this.grupo = grupo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public int getCantidadDisponible() { return cantidadDisponible; }
    public void setCantidadDisponible(int cantidadDisponible) { this.cantidadDisponible = cantidadDisponible; }

    public void incrementarCantidad(int cantidad) {
        this.cantidadDisponible += cantidad;
    }

    public void decrementarCantidad(int cantidad) {
        if (this.cantidadDisponible >= cantidad) {
            this.cantidadDisponible -= cantidad;
        } else {
            System.out.println("Cantidad insuficiente de " + this.nombre);
        }
    }

    @Override
    public String toString() {
        return "Instrumento: " + nombre + ", Grupo: " + grupo + ", Estado: " + estado + ", Cantidad Disponible: " + cantidadDisponible;
    }

}
