
package appinstrumentos;

import java.util.ArrayList;
import java.util.List;


public class GestionInstrumentos {
    
     private List<Instrumento> inventario;

    public GestionInstrumentos() {
        this.inventario = new ArrayList<>();
    }

    public void agregarInstrumento(Instrumento instrumento) {
        inventario.add(instrumento);
    }

    public void eliminarInstrumento(String nombre) {
        inventario.removeIf(instrumento -> instrumento.getNombre().equalsIgnoreCase(nombre));
    }

    public void actualizarEstadoInstrumento(String nombre, String nuevoEstado) {
        for (Instrumento instrumento : inventario) {
            if (instrumento.getNombre().equalsIgnoreCase(nombre)) {
                instrumento.setEstado(nuevoEstado);
                break;
            }
        }
    }

    public void actualizarCantidadDisponible(String nombre, int nuevaCantidad) {
        for (Instrumento instrumento : inventario) {
            if (instrumento.getNombre().equalsIgnoreCase(nombre)) {
                instrumento.setCantidadDisponible(nuevaCantidad);
                break;
            }
        }
    }

    public Instrumento buscarInstrumento(String nombre) {
        for (Instrumento instrumento : inventario) {
            if (instrumento.getNombre().equalsIgnoreCase(nombre)) {
                return instrumento;
            }
        }
        return null;
    }

    public List<Instrumento> obtenerInstrumentosPorGrupo(String grupo) {
        List<Instrumento> lista = new ArrayList<>();
        for (Instrumento instrumento : inventario) {
            if (instrumento.getGrupo().equalsIgnoreCase(grupo)) {
                lista.add(instrumento);
            }
        }
        return lista;
    }

    public void mostrarInventario(){
        for (Instrumento instrumento : inventario) {
            System.out.println(instrumento);
        }
    }
}


