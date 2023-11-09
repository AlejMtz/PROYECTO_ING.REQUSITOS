
package Modelo;

public class CabeceraVenta {
    //atributos
    
    private int idCabeceravaneta;
    private int idCliente;
    private double valorPagar;
    private String fechaVenta;
    private int estado;
    
    //constructor
    public CabeceraVenta(){
        this.idCabeceravaneta=0;
        this.idCliente=0;
        this.valorPagar=0.0;
        this.fechaVenta="";
        this.estado=0;
    }
    //sobrecargado

    public CabeceraVenta(int idCabeceravaneta, int idCliente, double valorPagar, String fechaVenta, int estado) {
        this.idCabeceravaneta = idCabeceravaneta;
        this.idCliente = idCliente;
        this.valorPagar = valorPagar;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
    }
    
    //gett and setter

    public int getIdCabeceravaneta() {
        return idCabeceravaneta;
    }

    public void setIdCabeceravaneta(int idCabeceravaneta) {
        this.idCabeceravaneta = idCabeceravaneta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    //toString

    @Override
    public String toString() {
        return "CabeceraVenta{" + "idCabeceravaneta=" + idCabeceravaneta + ", idCliente=" + idCliente + ", valorPagar=" + valorPagar + ", fechaVenta=" + fechaVenta + ", estado=" + estado + '}';
    }
    
            
    
    
}
