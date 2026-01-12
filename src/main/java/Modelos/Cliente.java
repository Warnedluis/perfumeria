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
public class Cliente {
    private int id_cliente;
    private String rfc, nombre, ap_paterno, ap_materno, tipo, correo, telefono, direccion_envio;
    private Date fecha_registro; 
    
    public Cliente()
    {
        
    }
    
    public Cliente(String rfc, String nombre, String ap_paterno, String ap_materno, String tipo, String correo, String telefono, String direccion_envio, int id_cliente, Date fecha_registro)
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
    
public void guardar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("insert into clientes values (?,?,?,?,?,?,?,?,?,?)");
        
        RES.setInt(1, id_cliente);
        RES.setString(2, rfc);
        RES.setString(3, nombre);
        RES.setString(4, ap_paterno);
        RES.setString(5, ap_materno);
        RES.setString(6, tipo);
        RES.setString(7, correo);
        RES.setString(8, telefono);
        RES.setString(9, direccion_envio);
        // Conversión de fecha de Java a SQL
        java.sql.Date fechaSQL = new java.sql.Date(fecha_registro.getTime());
        RES.setDate(10, fechaSQL);
        
        RES.executeUpdate();
        Con.close();
    }
     
public boolean Buscar(int id) throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement SQL = Con.prepareStatement("Select * From clientes where id_cliente=?");
        SQL.setInt(1, id);
        ResultSet Res = SQL.executeQuery();
        
        if (Res.next()) {
            this.id_cliente = Res.getInt("id_cliente");
            this.rfc = Res.getString("rfc");
            this.nombre = Res.getString("nombre");
            this.ap_paterno = Res.getString("ap_paterno");
            this.ap_materno = Res.getString("ap_materno");
            this.tipo = Res.getString("tipo");
            this.correo = Res.getString("correo");
            this.telefono = Res.getString("telefono");
            this.direccion_envio = Res.getString("direccion_envio");
            this.fecha_registro = Res.getDate("fecha_registro");
            Con.close();
            return true;
        }
        Con.close();
        return false;
    }

public void Modificar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("UPDATE clientes SET rfc=?, nombre=?, ap_paterno=?, ap_materno=?, tipo=?, correo=?, telefono=?, direccion_envio=?, fecha_registro=? WHERE id_cliente=?");
        
        RES.setString(1, rfc);
        RES.setString(2, nombre);
        RES.setString(3, ap_paterno);
        RES.setString(4, ap_materno);
        RES.setString(5, tipo);
        RES.setString(6, correo);
        RES.setString(7, telefono);
        RES.setString(8, direccion_envio);
        RES.setDate(9, new java.sql.Date(fecha_registro.getTime()));
        RES.setInt(10, id_cliente);
        
        RES.executeUpdate();
        Con.close();
    }

public void Borrar(int id) throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("DELETE from clientes WHERE id_cliente=?");
        RES.setInt(1, id);
        RES.executeUpdate();
        Con.close();
    }

public ResultSet Mostrar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement SQL = Con.prepareStatement("Select * from clientes");
        return SQL.executeQuery();
    }
    
}
