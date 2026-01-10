
package Modelos;
import java.sql.*;

/**
 * @author david
 */
public class Proveedores {
    // Atributos basados en tu DER
    private String nombre_proveedor, tipo_servicio, contacto_nombre, contacto_ap_paterno, contacto_ap_materno, telefono, direccion, condiciones_de_pago;
    private int id_proveedor;
    private float calificacion;
 

    public Proveedores() 
    {
    }

    public Proveedores(String nombre_proveedor, String tipo_servicio, String contacto_nombre, String contacto_ap_paterno, String contacto_ap_materno, String telefono, String direccion, String condiciones_de_pago, int id_proveedor, float calificacion) 
    {
        this.nombre_proveedor = nombre_proveedor;
        this.tipo_servicio = tipo_servicio;
        this.contacto_nombre = contacto_nombre;
        this.contacto_ap_paterno = contacto_ap_paterno;
        this.contacto_ap_materno = contacto_ap_materno;
        this.telefono = telefono;
        this.direccion = direccion;
        this.condiciones_de_pago = condiciones_de_pago;
        this.id_proveedor = id_proveedor;
        this.calificacion = calificacion;
    }
public String getNombre_proveedor() { return nombre_proveedor; }
    public String getTipo_servicio() { return tipo_servicio; }
    public String getContacto_nombre() { return contacto_nombre; }
    public String getContacto_ap_paterno() { return contacto_ap_paterno; }
    public String getContacto_ap_materno() { return contacto_ap_materno; }
    public String getTelefono() { return telefono; }
    public String getDireccion() { return direccion; }
    public String getCondiciones_de_pago() { return condiciones_de_pago; }
    public int getId_proveedor() { return id_proveedor; }
    public float getCalificacion() { return calificacion; }

public void setNombre_proveedor(String nombre_proveedor) { this.nombre_proveedor = nombre_proveedor; }
    public void setTipo_servicio(String tipo_servicio) { this.tipo_servicio = tipo_servicio; }
    public void setContacto_nombre(String contacto_nombre) { this.contacto_nombre = contacto_nombre; }
    public void setContacto_ap_paterno(String contacto_ap_paterno) { this.contacto_ap_paterno = contacto_ap_paterno; }
    public void setContacto_ap_materno(String contacto_ap_materno) { this.contacto_ap_materno = contacto_ap_materno; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setCondiciones_de_pago(String condiciones_de_pago) { this.condiciones_de_pago = condiciones_de_pago; }
    public void setId_proveedor(int id_proveedor) { this.id_proveedor = id_proveedor; }
    public void setCalificacion(float calificacion) { this.calificacion = calificacion; }

 
public void guardar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("insert into proveedores values (?,?,?,?,?,?,?,?,?,?)");
        RES.setInt(1, id_proveedor);
        RES.setString(2, nombre_proveedor);
        RES.setString(3, tipo_servicio);
        RES.setString(4, contacto_nombre);
        RES.setString(5, contacto_ap_paterno);
        RES.setString(6, contacto_ap_materno);
        RES.setString(7, telefono);
        RES.setString(8, direccion);
        RES.setString(9, condiciones_de_pago);
        RES.setFloat(10, calificacion);
        RES.executeUpdate();
    }
 
public void Borrar(int id) throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("DELETE from proveedores WHERE id_proveedor=?");
        RES.setInt(1, id);
        RES.executeUpdate();
    }

 public void Modificar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement RES = Con.prepareStatement("UPDATE proveedores SET nombre_proveedor=?, tipo_servicio=?, contacto_nombre=?, contacto_ap_paterno=?, contacto_ap_materno=?, telefono=?, direccion=?, condiciones_de_pago=?, calificacion=? WHERE id_proveedor=?");
        RES.setString(1, nombre_proveedor);
        RES.setString(2, tipo_servicio);
        RES.setString(3, contacto_nombre);
        RES.setString(4, contacto_ap_paterno);
        RES.setString(5, contacto_ap_materno);
        RES.setString(6, telefono);
        RES.setString(7, direccion);
        RES.setString(8, condiciones_de_pago);
        RES.setFloat(9, calificacion);
        RES.setInt(10, id_proveedor);
        RES.executeUpdate();
    }
 
 public boolean Buscar(int id) throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement SQL = Con.prepareStatement("Select * From proveedores where id_proveedor=?");
        SQL.setInt(1, id);
        ResultSet Res = SQL.executeQuery();
        if (Res.next()) {
            id_proveedor = Res.getInt("id_proveedor");
            nombre_proveedor = Res.getString("nombre_proveedor");
            tipo_servicio = Res.getString("tipo_servicio");
            contacto_nombre = Res.getString("contacto_nombre");
            contacto_ap_paterno = Res.getString("contacto_ap_paterno");
            contacto_ap_materno = Res.getString("contacto_ap_materno");
            telefono = Res.getString("telefono");
            direccion = Res.getString("direccion");
            condiciones_de_pago = Res.getString("condiciones_de_pago");
            calificacion = Res.getFloat("calificacion");
            return true;
        } 
        else 
        {
            return false;
        }
    }
 
 public ResultSet Mostrar() throws SQLException 
    {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfumeria", "root", "");
        PreparedStatement SQL = Con.prepareStatement("Select * from proveedores");
        return SQL.executeQuery();
    }
}