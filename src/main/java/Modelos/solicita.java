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
public class Solicita {
    private int id_pedidos, id_perfume, cantidad;
    private float subtotal, precio_unitario;
    
    public Solicita()
    {
        
    }
    
    public Solicita(int id_pedidos, int id_perfume, int cantidad, float subtotal, float precio_unitario)
    {
        this.cantidad = cantidad;
        this.id_pedidos = id_pedidos;
        this.id_perfume = id_perfume;
        this.precio_unitario = precio_unitario;
        this.subtotal = subtotal;
    }

    public int getId_pedidos() {
        return id_pedidos;
    }

    public int getId_perfume() {
        return id_perfume;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public float getPrecio_unitario() {
        return precio_unitario;
    }

    public void setId_pedidos(int id_pedidos) {
        this.id_pedidos = id_pedidos;
    }

    public void setId_perfume(int id_perfume) {
        this.id_perfume = id_perfume;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public void setPrecio_unitario(float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }
    
public void guardar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("insert into solicita values (?,?,?,?,?)");
        
        RES.setInt(1, id_pedidos);
        RES.setInt(2, id_perfume);
        RES.setFloat(3, subtotal);
        RES.setFloat(4, precio_unitario);
        RES.setInt(5, cantidad);
        
        RES.executeUpdate();
        Con.close();
    }

    public boolean Buscar(int idP, int idPerf) throws SQLException {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement SQL = Con.prepareStatement("Select * From solicita where id_pedidos=? AND id_perfume=?");
        SQL.setInt(1, idP);
        SQL.setInt(2, idPerf);
        ResultSet Res = SQL.executeQuery();
        
        if (Res.next()) 
        {
            this.id_pedidos = Res.getInt("id_pedidos");
            this.id_perfume = Res.getInt("id_perfume");
            this.subtotal = Res.getFloat("subtotal");
            this.precio_unitario = Res.getFloat("precio_unitario");
            this.cantidad = Res.getInt("cantidad");
            Con.close();
            return true;
        }
        Con.close();
        return false;
    }

    public void Modificar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("UPDATE solicita SET subtotal=?, precio_unitario=?, cantidad=? WHERE id_pedidos=? AND id_perfume=?");
        
        RES.setFloat(1, subtotal);
        RES.setFloat(2, precio_unitario);
        RES.setInt(3, cantidad);
        RES.setInt(4, id_pedidos);
        RES.setInt(5, id_perfume);
        
        RES.executeUpdate();
        Con.close();
    }

    public void Borrar(int idP, int idPerf) throws SQLException {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("DELETE from solicita WHERE id_pedidos=? AND id_perfume=?");
        RES.setInt(1, idP);
        RES.setInt(2, idPerf);
        RES.executeUpdate();
        Con.close();
    }

    public ResultSet Mostrar() throws SQLException {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement SQL = Con.prepareStatement("Select * from solicita");
        return SQL.executeQuery();
    }
    
}
