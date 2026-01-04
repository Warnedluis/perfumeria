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
public class materiaprima {
    
    private int id_inventario,id_ingredientes;
    
    public materiaprima()
    {
        
    }
    
    public materiaprima(int id_inventario, int id_ingrediente)
    {
        this.id_ingredientes = id_ingrediente;
        this.id_inventario = id_inventario;
    }

    public int getId_inventario() {
        return id_inventario;
    }

    public int getId_ingredientes() {
        return id_ingredientes;
    }

    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }

    public void setId_ingredientes(int id_ingredientes) {
        this.id_ingredientes = id_ingredientes;
    }
    
    public void guardar() throws SQLException {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prefumeria","root","");
        PreparedStatement RES = Con.prepareStatement("insert into materia_prima values (?,?)");
        
        RES.setInt(1, id_inventario);
        RES.setInt(2, id_ingredientes);
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
