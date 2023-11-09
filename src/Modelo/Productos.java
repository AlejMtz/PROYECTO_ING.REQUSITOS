
package Modelo;


public class Productos {
    
    //atributos de la clase
    private int idProducto;
    private String nombreProducto;
    private int cantidadProducto;
    private double precioProducto;
    private String descripcionProducto;
    private int porcentajeIVA;
    private int idProovedor;
    private int estado;
    
    //constructor
    public Productos(){
       this.idProducto=0;
       this.nombreProducto="";
       this.cantidadProducto=0;
       this.precioProducto=0.0;
       this.descripcionProducto="";
       this.porcentajeIVA=0;
       this.idProovedor=0;
       this.estado=0;
     }
//constructor sobre cargado
    public Productos(int idProducto, String nombreProducto, int cantidadProducto, double precioProducto, String descripcionProducto, int porcentajeIVA, int idProovedor, int estado) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioProducto = precioProducto;
        this.descripcionProducto = descripcionProducto;
        this.porcentajeIVA = porcentajeIVA;
        this.idProovedor = idProovedor;
        this.estado = estado;
    }
//sett and getter
    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public int getPorcentajeIVA() {
        return porcentajeIVA;
    }

    public void setPorcentajeIVA(int porcentajeIVA) {
        this.porcentajeIVA = porcentajeIVA;
    }

    public int getIdProovedor() {
        return idProovedor;
    }

    public void setIdProovedor(int idProovedor) {
        this.idProovedor = idProovedor;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
}

