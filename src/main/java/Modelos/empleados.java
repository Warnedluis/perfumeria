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

/**
 *
 * @author avila
 */
public class empleados {
    private int id_empleado, activo;
    private String nombre, ap_paterno, ap_materno, puesto, correo, telefono, usuario, contrasenia;
    
    public empleados( )
    {
        
    }
    
    public empleados( String nombre, String ap_paterno, String ap_materno, String puesto, String correo, String telefono, String usuario, String contrasenia, int activo, int id_empleado)
    {
        this.activo = activo;
        this.ap_materno = ap_materno;
        this.ap_paterno = ap_paterno;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.puesto = puesto;
        this.telefono = telefono;
        this.usuario = usuario;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public int getActivo() {
        return activo;
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

    public String getPuesto() {
        return puesto;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public void setActivo(int activo) {
        this.activo = activo;
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

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
        public void guardar() throws SQLException {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria","root","");
        PreparedStatement RES = Con.prepareStatement("insert into empleados values (?,?,?,?,?,?,?,?,?,?)");
        
        RES.setInt(1, id_empleado);
        RES.setString(2, nombre);
        RES.setString(3, ap_paterno);
        RES.setString(4, ap_materno);
        RES.setString(5, puesto);
        RES.setString(6, correo);
        RES.setString(7, telefono);
        RES.setString(8, usuario);
        RES.setString(9, contrasenia);
        RES.setInt(10, activo);
        RES.executeUpdate();
        Con.close();
    }
        
public ResultSet Mostrar () throws SQLException
{
    Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria","root","");
    PreparedStatement SQL = Con.prepareStatement("Select * from empleados");
    return SQL.executeQuery();
}

}
