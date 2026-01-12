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
public class Lotesproduccion {
    private int id_lote, id_perfume, id_empleado, cantidad_producida;
    private Date fecha_inicio, fecha_fin;
    private String control_calidad, observaciones;
    private float costo_total;
    
    public Lotesproduccion()
    {
        
    }
    
    public Lotesproduccion(String control_calidad, String observaciones, int id_lote, int id_perfume, int id_empleado, int cantidad_producida, Date fecha_inicio, Date fecha_fin, float costo_total)
    {
        this.cantidad_producida = cantidad_producida;
        this.control_calidad = control_calidad;
        this.costo_total = costo_total;
        this.fecha_fin = fecha_fin;
        this.fecha_inicio = fecha_inicio;
        this.id_empleado = id_empleado;
        this.id_lote = id_lote;
        this.id_perfume = id_perfume;
        this.observaciones = observaciones;
    }

    public int getId_lote() {
        return id_lote;
    }

    public int getId_perfume() {
        return id_perfume;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public int getCantidad_producida() {
        return cantidad_producida;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public String getControl_calidad() {
        return control_calidad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public float getCosto_total() {
        return costo_total;
    }

    public void setId_lote(int id_lote) {
        this.id_lote = id_lote;
    }

    public void setId_perfume(int id_perfume) {
        this.id_perfume = id_perfume;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public void setCantidad_producida(int cantidad_producida) {
        this.cantidad_producida = cantidad_producida;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public void setControl_calidad(String control_calidad) {
        this.control_calidad = control_calidad;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setCosto_total(float costo_total) {
        this.costo_total = costo_total;
    }
    
public void guardar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("insert into lotes_produccion values (?,?,?,?,?,?,?,?,?)");
        
        RES.setInt(1, id_lote);
        RES.setDate(2, new java.sql.Date(fecha_inicio.getTime()));
        RES.setDate(3, new java.sql.Date(fecha_fin.getTime()));
        RES.setInt(4, cantidad_producida);
        RES.setFloat(5, costo_total);
        RES.setString(6, control_calidad);
        RES.setString(7, observaciones);
        RES.setInt(8, id_perfume);
        RES.setInt(9, id_empleado);
        
        RES.executeUpdate();
        Con.close();
    }

    public boolean Buscar(int id) throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement SQL = Con.prepareStatement("Select * From lotes_produccion where id_lote=?");
        SQL.setInt(1, id);
        ResultSet Res = SQL.executeQuery();
        
        if (Res.next()) {
            this.id_lote = Res.getInt("id_lote");
            this.fecha_inicio = Res.getDate("fecha_inicio");
            this.fecha_fin = Res.getDate("fecha_fin");
            this.cantidad_producida = Res.getInt("cantidad_producida");
            this.costo_total = Res.getFloat("costo_total");
            this.control_calidad = Res.getString("control_calidad");
            this.observaciones = Res.getString("observaciones");
            this.id_perfume = Res.getInt("perfumes_id_perfume");
            this.id_empleado = Res.getInt("empleados_id_empleado");
            Con.close();
            return true;
        }
        Con.close();
        return false;
    }

    public void Modificar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("UPDATE lotes_produccion SET fecha_inicio=?, fecha_fin=?, cantidad_producida=?, costo_total=?, control_calidad=?, observaciones=?, perfumes_id_perfume=?, empleados_id_empleado=? WHERE id_lote=?");
        
        RES.setDate(1, new java.sql.Date(fecha_inicio.getTime()));
        RES.setDate(2, new java.sql.Date(fecha_fin.getTime()));
        RES.setInt(3, cantidad_producida);
        RES.setFloat(4, costo_total);
        RES.setString(5, control_calidad);
        RES.setString(6, observaciones);
        RES.setInt(7, id_perfume);
        RES.setInt(8, id_empleado);
        RES.setInt(9, id_lote);
        
        RES.executeUpdate();
        Con.close();
    }

    public void Borrar(int id) throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("DELETE from lotes_produccion WHERE id_lote=?");
        RES.setInt(1, id);
        RES.executeUpdate();
        Con.close();
    }

    public ResultSet Mostrar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement SQL = Con.prepareStatement("Select * from lotes_produccion");
        return SQL.executeQuery();
    }
       
}
