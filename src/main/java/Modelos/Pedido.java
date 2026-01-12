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
public class Pedido {
    private int id_pedidos, id_cliente;
    private String estado;
    private Date fecha_pedido, fecha_entrega;
    private float total;
    
    public Pedido()
    {
        
    }
    
    public Pedido(String estado, int id_pedidos, int id_cliente, Date fecha_pedido, Date fecha_entrega, float total)
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
    
public void guardar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("insert into pedidos values (?,?,?,?,?,?)");
        
        RES.setInt(1, id_pedidos);
        RES.setDate(2, new java.sql.Date(fecha_pedido.getTime()));
        RES.setDate(3, new java.sql.Date(fecha_entrega.getTime()));
        RES.setString(4, estado);
        RES.setFloat(5, total);
        RES.setInt(6, id_cliente); // Faltaba este campo en tu código original
        
        RES.executeUpdate();
        Con.close();
    }

    public boolean Buscar(int id) throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement SQL = Con.prepareStatement("Select * From pedidos where id_pedidos=?");
        SQL.setInt(1, id);
        ResultSet Res = SQL.executeQuery();
        
        if (Res.next()) {
            this.id_pedidos = Res.getInt("id_pedidos");
            this.fecha_pedido = Res.getDate("fecha_pedido");
            this.fecha_entrega = Res.getDate("fecha_entrega");
            this.estado = Res.getString("estado");
            this.total = Res.getFloat("total");
            this.id_cliente = Res.getInt("clientes_id_cliente");
            Con.close();
            return true;
        }
        Con.close();
        return false;
    }

    public void Modificar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("UPDATE pedidos SET fecha_pedido=?, fecha_entrega=?, estado=?, total=?, clientes_id_cliente=? WHERE id_pedidos=?");
        
        RES.setDate(1, new java.sql.Date(fecha_pedido.getTime()));
        RES.setDate(2, new java.sql.Date(fecha_entrega.getTime()));
        RES.setString(3, estado);
        RES.setFloat(4, total);
        RES.setInt(5, id_cliente);
        RES.setInt(6, id_pedidos);
        
        RES.executeUpdate();
        Con.close();
    }

    public void Borrar(int id) throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("DELETE from pedidos WHERE id_pedidos=?");
        RES.setInt(1, id);
        RES.executeUpdate();
        Con.close();
    }

    public ResultSet Mostrar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement SQL = Con.prepareStatement("Select * from pedidos");
        return SQL.executeQuery();
    }
}
