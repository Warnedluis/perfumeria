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
public class perfumes {
    private String nombre, familia_olfativa, tipo_producto, perfumista, descripcion, estado;
    private float costo_produccion, precio_venta;
    private int id_perfume;
    private Date fecha_creacion;
    
    public perfumes()
    {
        
    }
    
    public perfumes(String nombre, String familia_olfativa, String tipo_producto, String perfumista, String descripcion, String estado, float precio_venta, float costo_produccion, Date fecha_creacion, int id_perfume)
    {
        this.costo_produccion = costo_produccion;
        this.descripcion =descripcion;
        this.estado = estado;
        this.familia_olfativa = familia_olfativa;
        this.id_perfume = id_perfume;
        this.nombre = nombre;
        this.precio_venta = precio_venta;
        this.fecha_creacion = fecha_creacion;
        this.tipo_producto = tipo_producto;
        this.perfumista = perfumista;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFamilia_olfativa() {
        return familia_olfativa;
    }

    public String getTipo_producto() {
        return tipo_producto;
    }

    public String getPerfumista() {
        return perfumista;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public float getCosto_produccion() {
        return costo_produccion;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public int getId_perfume() {
        return id_perfume;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFamilia_olfativa(String familia_olfativa) {
        this.familia_olfativa = familia_olfativa;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public void setPerfumista(String perfumista) {
        this.perfumista = perfumista;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCosto_produccion(float costo_produccion) {
        this.costo_produccion = costo_produccion;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public void setId_perfume(int id_perfume) {
        this.id_perfume = id_perfume;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

 public void guardar() throws SQLException
 {
     Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria","root","");
     PreparedStatement RES = Con.prepareStatement("insert into perfumes values (?,?,?,?,?,?,?,?,?,?)");
     RES.setInt(1, id_perfume);
     RES.setString(2, nombre);
     RES.setString(3, familia_olfativa);
     RES.setString(4, tipo_producto);
     java.sql.Date fechaSQL = new java.sql.Date(fecha_creacion.getTime());
     RES.setDate(5, fechaSQL);
     RES.setString(6, perfumista);
     RES.setString(7, descripcion);
     RES.setFloat(8, precio_venta);
     RES.setFloat(9, costo_produccion);
     RES.setString(10, estado);
     RES.executeUpdate();
 }

    public ResultSet Mostrar () throws SQLException
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria","root","");
        PreparedStatement SQL = Con.prepareStatement("Select * from perfumes");
        return SQL.executeQuery();
    }
    
}
