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
public class Inventarios {
    private String ubicacion;
    private float cantidad;
    private int id_inventario;
    private Date fecha_actualizacion;
    
   public Inventarios()
   {
       
   }
   
   public Inventarios(String ubicacion, float cantidad, int id_inventario, Date fecha_actualizacion)
   {
       this.cantidad =cantidad;
       this.fecha_actualizacion = fecha_actualizacion;
       this.id_inventario = id_inventario;
       this.ubicacion = ubicacion;
   }

    public String getUbicacion() {
        return ubicacion;
    }

    public float getCantidad() {
        return cantidad;
    }

    public int getId_inventario() {
        return id_inventario;
    }

    public Date getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }

    public void setFecha_actualizacion(Date fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }
   
public void guardar() throws SQLException 
{
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("insert into inventario values (?,?,?,?)");
        
        RES.setInt(1, id_inventario);
        RES.setFloat(2, cantidad);
        RES.setString(3, ubicacion);
        // Conversión de fecha de Java a SQL
        java.sql.Date fechaSQL = new java.sql.Date(fecha_actualizacion.getTime());
        RES.setDate(4, fechaSQL);
        
        RES.executeUpdate();
        Con.close();
    }

    public boolean Buscar(int id) throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement SQL = Con.prepareStatement("Select * From inventario where id_inventario=?");
        SQL.setInt(1, id);
        ResultSet Res = SQL.executeQuery();
        
        if (Res.next()) {
            this.id_inventario = Res.getInt("id_inventario");
            this.cantidad = Res.getFloat("cantidad");
            this.ubicacion = Res.getString("ubicacion");
            this.fecha_actualizacion = Res.getDate("fecha_actualizacion");
            Con.close();
            return true;
        }
        Con.close();
        return false;
    }

    public void Modificar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("UPDATE inventario SET cantidad=?, ubicacion=?, fecha_actualizacion=? WHERE id_inventario=?");
        
        RES.setFloat(1, cantidad);
        RES.setString(2, ubicacion);
        RES.setDate(3, new java.sql.Date(fecha_actualizacion.getTime()));
        RES.setInt(4, id_inventario);
        
        RES.executeUpdate();
        Con.close();
    }

    public void Borrar(int id) throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("DELETE from inventario WHERE id_inventario=?");
        RES.setInt(1, id);
        RES.executeUpdate();
        Con.close();
    }

    public ResultSet Mostrar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement SQL = Con.prepareStatement("Select * from inventario");
        return SQL.executeQuery();
    }
}
