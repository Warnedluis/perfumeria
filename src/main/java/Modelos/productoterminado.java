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
public class productoterminado {
    
    private int id_inventario,id_perfume;
    
    public productoterminado()
    {
        
    }
    
    public productoterminado(int id_inventario, int id_perfume)
    {
        this.id_inventario = id_inventario;
        this.id_perfume = id_perfume;
    }

    public int getId_inventario() {
        return id_inventario;
    }

    public int getId_perfume() {
        return id_perfume;
    }

    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }

    public void setId_perfume(int id_perfume) {
        this.id_perfume = id_perfume;
    }
    
    public void guardar() throws SQLException {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria","root","");
        PreparedStatement RES = Con.prepareStatement("insert into materia_prima values (?,?)");
        
        RES.setInt(1, id_inventario);
        RES.setInt(2, id_perfume);
        RES.executeUpdate();
        Con.close();
    }
    
    public ResultSet Mostrar () throws SQLException
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria","root","");
        PreparedStatement SQL = Con.prepareStatement("Select * from materia_prima");
        return SQL.executeQuery();
    }
}