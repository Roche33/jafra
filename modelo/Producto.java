package modelo;

import java.io.Serializable;

public class Producto implements Serializable{
    String clave;
    String descripcion;
    String fechaEntrada;
    String cantidad;

    public Producto(String clave,String descripcion,String fechaEntrada,String cantidad){
        this.clave = clave;
        this.descripcion = descripcion;
        this.fechaEntrada = fechaEntrada;
        this.cantidad = cantidad;

    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDesceipcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getfechaEntrada() {
        return fechaEntrada;
    }
    public void setfechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
    public String getCantidad() {
        return cantidad;
    }
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
    @Override
        public String toString(){
            return "Clave: "+clave+"\nDescripcion: "+descripcion+"\nFecha de entrada: "+fechaEntrada+"\nCantidad: "+cantidad;
        }
    
}
