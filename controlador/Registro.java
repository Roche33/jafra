package controlador;
import modelo.Producto;
import java.util.ArrayList;

public class Registro {
    
    private final ArrayList<Producto> productos;
    private final Archivo archivoProductos;

    public Registro(){
        archivoProductos = new Archivo("productos.dat");
        productos = archivoProductos.leerRegistros();
    }
    public void guardarRegistros() {
        archivoProductos.guardarRegistros(productos);
    }
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        guardarRegistros();
    }

    public ArrayList<Producto> getProducto() {
        return productos;
    }
}
