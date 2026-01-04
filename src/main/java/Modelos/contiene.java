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
public class contiene {
    private int id_formula,id_ingrediente;
    private String nota;
    private float proporcion;
    
    public contiene()
    {
    }
    
    public contiene (int id_formula, int id_ingrediente, String nota, float proporcion)
    {
        this.id_formula = id_formula;
        this.id_ingrediente = id_ingrediente;
        this.nota = nota;
        this.proporcion = proporcion;
    }

    public int getId_formula() {
        return id_formula;
    }

    public int getId_ingrediente() {
        return id_ingrediente;
    }

    public String getNota() {
        return nota;
    }

    public float getProporcion() {
        return proporcion;
    }

    public void setId_formula(int id_formula) {
        this.id_formula = id_formula;
    }

    public void setId_ingrediente(int id_ingrediente) {
        this.id_ingrediente = id_ingrediente;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public void setProporcion(float proporcion) {
        this.proporcion = proporcion;
    }
    
   public void guardar() throws SQLException {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria","root","");
        PreparedStatement RES = Con.prepareStatement("insert into contiene values (?,?,?,?)");
        
        RES.setInt(1, id_formula);
        RES.setInt(2, id_ingrediente);
        RES.setString(3, nota);
        RES.setFloat(4,proporcion);
        RES.executeUpdate();
        Con.close();
    }
    
   public ResultSet Mostrar () throws SQLException
{
    Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria","root","");
    PreparedStatement SQL = Con.prepareStatement("Select * from contiene");
    return SQL.executeQuery();
}
}
