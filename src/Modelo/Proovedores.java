package Modelo;

public class Proovedores {

    private int idproovedor;
    private String nombreproovedor;
    private String direccionproovedor;
    private String telefonoproovedor;
    private int estado;

    public Proovedores() {
        this.idproovedor = 0;
        this.nombreproovedor = "";
        this.direccionproovedor = "";
        this.telefonoproovedor = "";
        this.estado = 0;
    }

    public Proovedores(int idproovedor, String nombreproovedor, String direccionproovedor, String telefonoproovedor, int estado) {
        this.idproovedor = idproovedor;
        this.nombreproovedor = nombreproovedor;
        this.direccionproovedor = direccionproovedor;
        this.telefonoproovedor = telefonoproovedor;
        this.estado = estado;
    }

    public int getIdproovedor() {
        return idproovedor;
    }

    public void setIdproovedor(int idproovedor) {
        this.idproovedor = idproovedor;
    }

    public String getNombreproovedor() {
        return nombreproovedor;
    }

    public void setNombreproovedor(String nombreproovedor) {
        this.nombreproovedor = nombreproovedor;
    }

    public String getDireccionproovedor() {
        return direccionproovedor;
    }

    public void setDireccionproovedor(String direccionproovedor) {
        this.direccionproovedor = direccionproovedor;
    }

    public String getTelefonoproovedor() {
        return telefonoproovedor;
    }

    public void setTelefonoproovedor(String telefonoproovedor) {
        this.telefonoproovedor = telefonoproovedor;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
