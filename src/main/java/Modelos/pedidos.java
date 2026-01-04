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
public class pedidos {
    private int id_pedidos, id_cliente;
    private String estado;
    private Date fecha_pedido, fecha_entrega;
    private float total;
    
    public pedidos()
    {
        
    }
    
    public pedidos(String estado, int id_pedidos, int id_cliente, Date fecha_pedido, Date fecha_entrega, float total)
    {
        this.estado = estado;
        this.fecha_entrega = fecha_entrega;
        this.fecha_pedido = fecha_pedido;
        this.id_cliente = id_cliente;
        this.id_pedidos = id_pedidos;
        this.total = total;
    }

    public int getId_pedidos() {
        return id_pedidos;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public String getEstado() {
        return estado;
    }

    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public float getTotal() {
        return total;
    }

    public void setId_pedidos(int id_pedidos) {
        this.id_pedidos = id_pedidos;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
         public void guardar() throws SQLException {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prefumeria","root","");
        PreparedStatement RES = Con.prepareStatement("insert into pedidos values (?,?,?,?,?,?)");
        
        RES.setInt(1, id_pedidos);
        java.sql.Date fechaSQL = new java.sql.Date(fecha_pedido.getTime());
        java.sql.Date fechaSQL2 = new java.sql.Date(fecha_entrega.getTime());
        RES.setDate(2, fechaSQL);
        RES.setDate(3, fechaSQL2);
        RES.setString(4, estado);
        RES.setFloat(6,total);
        RES.executeUpdate();
        Con.close();
    }
     
    public ResultSet Mostrar () throws SQLException
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria","root","");
        PreparedStatement SQL = Con.prepareStatement("Select * from pedidos");
        return SQL.executeQuery();
    }
    
}
