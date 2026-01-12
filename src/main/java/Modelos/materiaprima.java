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
public class MateriaPrima {
    
    private int id_inventario,id_ingredientes;
    
    public MateriaPrima()
    {
        
    }
    
    public MateriaPrima(int id_inventario, int id_ingrediente)
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
    
public void guardar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("insert into materia_prima values (?,?)");
        
        RES.setInt(1, id_inventario);
        RES.setInt(2, id_ingredientes);
        RES.executeUpdate();
        Con.close();
    }

    public boolean Buscar(int idInv, int idIng) throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement SQL = Con.prepareStatement("Select * From materia_prima where id_inventario=? AND id_ingredientes=?");
        SQL.setInt(1, idInv);
        SQL.setInt(2, idIng);
        ResultSet Res = SQL.executeQuery();
        
        if (Res.next()) {
            this.id_inventario = Res.getInt("id_inventario");
            this.id_ingredientes = Res.getInt("id_ingredientes");
            Con.close();
            return true;
        }
        Con.close();
        return false;
    }

    // Nota: En tablas de relación pura, "Modificar" suele implicar actualizar un vínculo existente.
    public void Modificar(int idInvViejo, int idIngViejo) throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("UPDATE materia_prima SET id_inventario=?, id_ingredientes=? WHERE id_inventario=? AND id_ingredientes=?");
        
        RES.setInt(1, id_inventario);
        RES.setInt(2, id_ingredientes);
        RES.setInt(3, idInvViejo);
        RES.setInt(4, idIngViejo);
        
        RES.executeUpdate();
        Con.close();
    }

    public void Borrar(int idInv, int idIng) throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("DELETE from materia_prima WHERE id_inventario=? AND id_ingredientes=?");
        RES.setInt(1, idInv);
        RES.setInt(2, idIng);
        RES.executeUpdate();
        Con.close();
    }

    public ResultSet Mostrar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement SQL = Con.prepareStatement("Select * from materia_prima");
        return SQL.executeQuery();
    }
}
