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
public class Empleados {
    private int id_empleado, activo;
    private String nombre, ap_paterno, ap_materno, puesto, correo, telefono, usuario, contrasenia;
    
    public Empleados( )
    {
        
    }
    
    public Empleados( String nombre, String ap_paterno, String ap_materno, String puesto, String correo, String telefono, String usuario, String contrasenia, int activo, int id_empleado)
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
    
public void guardar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
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
        
public boolean Buscar(int id) throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement SQL = Con.prepareStatement("Select * From empleados where id_empleado=?");
        SQL.setInt(1, id);
        ResultSet Res = SQL.executeQuery();
        if (Res.next()) {
            this.id_empleado = Res.getInt("id_empleado");
            this.nombre = Res.getString("nombre");
            this.ap_paterno = Res.getString("ap_paterno");
            this.ap_materno = Res.getString("ap_materno");
            this.puesto = Res.getString("puesto");
            this.correo = Res.getString("correo");
            this.telefono = Res.getString("telefono");
            this.usuario = Res.getString("usuario");
            this.contrasenia = Res.getString("contrasenia");
            this.activo = Res.getInt("activo");
            Con.close();
            return true;
        }
        Con.close();
        return false;
    }

public void Modificar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("UPDATE empleados SET nombre=?, ap_paterno=?, ap_materno=?, puesto=?, correo=?, telefono=?, usuario=?, contrasenia=?, activo=? WHERE id_empleado=?");
        RES.setString(1, nombre);
        RES.setString(2, ap_paterno);
        RES.setString(3, ap_materno);
        RES.setString(4, puesto);
        RES.setString(5, correo);
        RES.setString(6, telefono);
        RES.setString(7, usuario);
        RES.setString(8, contrasenia);
        RES.setInt(9, activo);
        RES.setInt(10, id_empleado);
        RES.executeUpdate();
        Con.close();
    }

public void Borrar(int id) throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("DELETE from empleados WHERE id_empleado=?");
        RES.setInt(1, id);
        RES.executeUpdate();
        Con.close();
    }

    public ResultSet Mostrar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement SQL = Con.prepareStatement("Select * from empleados");
        return SQL.executeQuery();
    }
}
