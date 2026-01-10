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
public class ingredientes {
    private String nombre, tipo,unidad_medida;
    private int id_ingrediente,id_proveedor;
    private float stock_actual, costo_unitario, nivel_reorden;
    
    public ingredientes()
    {
        
    }
    
    public ingredientes (String nombre, String tipo, String unidad_medida, int stock_actual, int costo_unitario, int nivel_reorden, int id_proveedor, int id_ingrediente)
    {
        this.costo_unitario = costo_unitario;
        this.id_ingrediente = id_ingrediente;
        this.id_proveedor = id_proveedor;
        this.nivel_reorden = nivel_reorden;
        this.nombre = nombre;
        this.stock_actual = stock_actual;
        this.tipo = tipo;
        this.unidad_medida = unidad_medida;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public int getId_ingrediente() {
        return id_ingrediente;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public float getStock_actual() {
        return stock_actual;
    }

    public float getCosto_unitario() {
        return costo_unitario;
    }

    public float getNivel_reorden() {
        return nivel_reorden;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public void setId_ingrediente(int id_ingrediente) {
        this.id_ingrediente = id_ingrediente;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public void setStock_actual(float stock_actual) {
        this.stock_actual = stock_actual;
    }

    public void setCosto_unitario(float costo_unitario) {
        this.costo_unitario = costo_unitario;
    }

    public void setNivel_reorden(float nivel_reorden) {
        this.nivel_reorden = nivel_reorden;
    }
    
public void guardar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("insert into ingredientes values (?,?,?,?,?,?,?,?)");

        RES.setInt(1, id_ingrediente);
        RES.setString(2, nombre);
        RES.setString(3, tipo);
        RES.setString(4, unidad_medida);
        RES.setFloat(5, stock_actual);
        RES.setFloat(6, costo_unitario);
        RES.setFloat(7, nivel_reorden);
        RES.setInt(8, id_proveedor);
        
        RES.executeUpdate();
        Con.close();
    }

    public boolean Buscar(int id) throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement SQL = Con.prepareStatement("Select * From ingredientes where id_ingrediente=?");
        SQL.setInt(1, id);
        ResultSet Res = SQL.executeQuery();
        
        if (Res.next()) {
            this.id_ingrediente = Res.getInt("id_ingrediente");
            this.nombre = Res.getString("nombre");
            this.tipo = Res.getString("tipo");
            this.unidad_medida = Res.getString("unidad_medida");
            this.stock_actual = Res.getFloat("stock_actual");
            this.costo_unitario = Res.getFloat("costo_unitario");
            this.nivel_reorden = Res.getFloat("nivel_reorden");
            this.id_proveedor = Res.getInt("proveedores_id_proveedor");
            Con.close();
            return true;
        }
        Con.close();
        return false;
    }

    public void Modificar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("UPDATE ingredientes SET nombre=?, tipo=?, unidad_medida=?, stock_actual=?, costo_unitario=?, nivel_reorden=?, proveedores_id_proveedor=? WHERE id_ingrediente=?");
        
        RES.setString(1, nombre);
        RES.setString(2, tipo);
        RES.setString(3, unidad_medida);
        RES.setFloat(4, stock_actual);
        RES.setFloat(5, costo_unitario);
        RES.setFloat(6, nivel_reorden);
        RES.setInt(7, id_proveedor);
        RES.setInt(8, id_ingrediente);
        
        RES.executeUpdate();
        Con.close();
    }

    public void Borrar(int id) throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("DELETE from ingredientes WHERE id_ingrediente=?");
        RES.setInt(1, id);
        RES.executeUpdate();
        Con.close();
    }

    public ResultSet Mostrar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement SQL = Con.prepareStatement("Select * from ingredientes");
        return SQL.executeQuery();
    }
    
}
