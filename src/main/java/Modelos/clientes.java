/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author avila
 */
public class clientes {
    private int id_cliente;
    private String rfc, nombre, ap_paterno, ap_materno, tipo, correo, telefono, direccion_envio;
    private Date fecha_registro; 
    
    public clientes()
    {
        
    }
    
    public clientes(String rfc, String nombre, String ap_paterno, String ap_materno, String tipo, String correo, String telefono, String direccion_envio, int id_cliente, Date fecha_registro)
    {
        this.ap_materno = ap_materno;
        this.ap_paterno = ap_paterno;
        this.correo = correo;
        this.direccion_envio = direccion_envio;
        this.fecha_registro = fecha_registro;
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.rfc = rfc;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public String getRfc() {
        return rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion_envio() {
        return direccion_envio;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion_envio(String direccion_envio) {
        this.direccion_envio = direccion_envio;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
     public void guardar() throws SQLException {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria","root","");
        PreparedStatement RES = Con.prepareStatement("insert into clientes values (?,?,?,?,?,?,?,?,?,?)");
        
        RES.setInt(1, id_cliente);
        RES.setString(2, rfc);
        java.sql.Date fechaSQL = new java.sql.Date(fecha_registro.getTime());
        RES.setString(4, nombre);
        RES.setString(4,ap_paterno);
        RES.setString(5, ap_materno);
        RES.setString(6,tipo);
        RES.setString(7,correo);
        RES.setString(8,telefono);
        RES.setString(9,direccion_envio);
        RES.setDate(10, fechaSQL);
        RES.executeUpdate();
        Con.close();
    }
     
    public ResultSet Mostrar () throws SQLException
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria","root","");
        PreparedStatement SQL = Con.prepareStatement("Select * from proveedores");
        return SQL.executeQuery();
    }
    
}
