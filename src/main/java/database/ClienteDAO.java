package database;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import logic.Cliente;

public class ClienteDAO {

    public ClienteDAO(){}
    
    public void guardarCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (nombre, ruc) VALUES (?, ?)";
        
        // PASO CLAVE: Llamas a getInstance() y luego a getConnection()
        Connection conn = Conexion.getInstance().getConnection();
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getNombreApellido());
            pstmt.setString(2, cliente.getCedulaRuc());
            pstmt.executeUpdate();
            System.out.println("Cliente guardado.");
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> listar(){
            
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Clientes;";

        Connection conn = Conexion.getInstance().getConnection();
        
        try(PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente();

                c.setId(rs.getInt("Id"));
                c.setNombreApellido(rs.getString("Nombre_Apellido"));
                c.setCedulaRuc(rs.getString("Cedula_Ruc"));

            }
            
        } catch (Exception e) {

        }

        return lista;

    }
}
