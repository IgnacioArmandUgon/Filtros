package domain;

import java.util.Date;

public class Factura{
    String descripcion;
    int precio;
    int cantidad;
    Date fecha;
    String codigo;

    public Factura(String descripcion,int precio, int cantidad, Date fecha, String codigo){
        this.descripcion=descripcion;
        this.precio=precio;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.codigo = codigo;
    }

    public int getImporte(){
        return this.precio;
    }

    public int getCantidad() {
        return this.cantidad;
    }
    public Date getFecha() {
        return this.fecha;
    }

    public String getCodigo() {
        return this.codigo;
    }
}
