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
public class Facturas {
    private int id_factura, folio, id_pedidos;
    private Date fecha_emision;
    private float monto_total, impuestos;
    private String metodo_pago, estado;
    
    public Facturas()
    {
        
    }
    
    public Facturas(int id_factura, int folio, int id_pedidos, Date fecha_emision, float monto_total, float impuestos, String metodo_pago, String estado)
    {
        this.estado = estado;
        this.fecha_emision = fecha_emision;
        this.folio = folio;
        this.id_factura = id_factura;
        this.id_pedidos = id_pedidos;
        this.impuestos = impuestos;
        this.metodo_pago = metodo_pago;
        this.monto_total = monto_total;
    }

    public int getId_factura() {
        return id_factura;
    }

    public int getFolio() {
        return folio;
    }

    public int getId_pedidos() {
        return id_pedidos;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public float getMonto_total() {
        return monto_total;
    }

    public float getImpuestos() {
        return impuestos;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public String getEstado() {
        return estado;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public void setId_pedidos(int id_pedidos) {
        this.id_pedidos = id_pedidos;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public void setMonto_total(float monto_total) {
        this.monto_total = monto_total;
    }

    public void setImpuestos(float impuestos) {
        this.impuestos = impuestos;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
public void guardar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("insert into facturas values (?,?,?,?,?,?,?,?)");
        
        RES.setInt(1, id_factura);
        RES.setInt(2, folio);
        // Conversión de fecha de Java a SQL
        java.sql.Date fechaSQL = new java.sql.Date(fecha_emision.getTime());
        RES.setDate(3, fechaSQL);
        RES.setFloat(4, monto_total);
        RES.setFloat(5, impuestos);
        RES.setString(6, metodo_pago);
        RES.setString(7, estado);
        RES.setInt(8, id_pedidos);
        
        RES.executeUpdate();
        Con.close();
    }

    public boolean Buscar(int id) throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement SQL = Con.prepareStatement("Select * From facturas where id_factura=?");
        SQL.setInt(1, id);
        ResultSet Res = SQL.executeQuery();
        
        if (Res.next()) {
            this.id_factura = Res.getInt("id_factura");
            this.folio = Res.getInt("folio");
            this.fecha_emision = Res.getDate("fecha_emision");
            this.monto_total = Res.getFloat("monto_total");
            this.impuestos = Res.getFloat("impuestos");
            this.metodo_pago = Res.getString("metodo_pago");
            this.estado = Res.getString("estado");
            this.id_pedidos = Res.getInt("id_pedidos");
            Con.close();
            return true;
        }
        Con.close();
        return false;
    }

    public void Modificar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("UPDATE facturas SET folio=?, fecha_emision=?, monto_total=?, impuestos=?, metodo_pago=?, estado=?, id_pedidos=? WHERE id_factura=?");
        
        RES.setInt(1, folio);
        RES.setDate(2, new java.sql.Date(fecha_emision.getTime()));
        RES.setFloat(3, monto_total);
        RES.setFloat(4, impuestos);
        RES.setString(5, metodo_pago);
        RES.setString(6, estado);
        RES.setInt(7, id_pedidos);
        RES.setInt(8, id_factura);
        
        RES.executeUpdate();
        Con.close();
    }

    public void Borrar(int id) throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("DELETE from facturas WHERE id_factura=?");
        RES.setInt(1, id);
        RES.executeUpdate();
        Con.close();
    }

    public ResultSet Mostrar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement SQL = Con.prepareStatement("Select * from facturas");
        return SQL.executeQuery();
    }
}
