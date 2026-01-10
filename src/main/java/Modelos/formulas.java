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
public class formulas {
    private int id_formula,id_perfume;
    private String version, observaciones;
    private Date fecha_registro;
    
    public formulas()
    {
        
    }
    
    public formulas(String version, String observaciones, Date fecha_registro, int id_formula, int id_perfume)
    {
        this.fecha_registro = fecha_registro;
        this.id_formula = id_formula;
        this.id_perfume = id_perfume;
        this.observaciones = observaciones;
        this.version = version;
    }

    public int getId_formula() {
        return id_formula;
    }

    public int getId_perfume() {
        return id_perfume;
    }

    public String getVersion() {
        return version;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setId_formula(int id_formula) {
        this.id_formula = id_formula;
    }

    public void setId_perfume(int id_perfume) {
        this.id_perfume = id_perfume;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
public void guardar() throws SQLException {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("insert into formulas values (?,?,?,?,?)");
        
        RES.setInt(1, id_formula);
        RES.setString(2, version);
        java.sql.Date fechaSQL = new java.sql.Date(fecha_registro.getTime());
        RES.setDate(3, fechaSQL);
        RES.setString(4, observaciones);
        RES.setInt(5, id_perfume);
        
        RES.executeUpdate();
        Con.close();
    }

    public boolean Buscar(int id) throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement SQL = Con.prepareStatement("Select * From formulas where id_formula=?");
        SQL.setInt(1, id);
        ResultSet Res = SQL.executeQuery();
        
        if (Res.next()) {
            this.id_formula = Res.getInt("id_formula");
            this.version = Res.getString("version");
            this.fecha_registro = Res.getDate("fecha_registro");
            this.observaciones = Res.getString("observaciones");
            this.id_perfume = Res.getInt("id_perfume");
            Con.close();
            return true;
        }
        Con.close();
        return false;
    }

    public void Modificar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("UPDATE formulas SET version=?, fecha_registro=?, observaciones=?, id_perfume=? WHERE id_formula=?");
        
        RES.setString(1, version);
        RES.setDate(2, new java.sql.Date(fecha_registro.getTime()));
        RES.setString(3, observaciones);
        RES.setInt(4, id_perfume);
        RES.setInt(5, id_formula);
        
        RES.executeUpdate();
        Con.close();
    }

    public void Borrar(int id) throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("DELETE from formulas WHERE id_formula=?");
        RES.setInt(1, id);
        RES.executeUpdate();
        Con.close();
    }

    public ResultSet Mostrar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement SQL = Con.prepareStatement("Select * from formulas");
        return SQL.executeQuery();
    }
}
