package database;

import java.sql.Statement;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Conexion instancia;
    private Connection connection ;
    private static final String NOMBRE_CARPETA = "Ratio"; //Nombre de la carpeta donde se guarda la base de datos
    private static final String NOMBRE_BASEDATOS = "ratio.db"; //Nombre de la base de datos

    private Conexion(){
        conectarBaseDatos();
    }

    public static Conexion getInstance(){
        if (instancia == null) {
            instancia = new Conexion();
        }else{
            try {
                if (instancia.connection == null || instancia.connection.isClosed()) {
                    instancia.conectarBaseDatos();
                }               
            } catch (Exception e) {
                System.out.println("No se pudo conectar " + e.toString());
            }
        }

        return instancia;
    }

    public void conectarBaseDatos(){
        try {
            String userHome = System.getProperty("user.home");
            String rutaCarpeta = userHome + File.separator + NOMBRE_CARPETA;
            
            // Crear carpetas
            File carpeta = new File(rutaCarpeta);
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }

            String url = "jdbc:sqlite:" + rutaCarpeta + File.separator + NOMBRE_BASEDATOS;

            this.connection = DriverManager.getConnection(url);

            crearTablasSiNoExisten();

            System.out.println(">>> Conexión establecida (Singleton): " + url);

        } catch (SQLException e) {
            System.out.println("Error al conectar la base de datos " + e.toString());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    private void crearTablasSiNoExisten() {
        try (Statement stmt = this.connection.createStatement()) {
            
            String sqlClientes = """
                CREATE TABLE IF NOT EXISTS Usuarios (
                    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                    User TEXT NOT NULL,
                    Clave TEXT NOT NULL
                );
            """;
             
            stmt.execute(sqlClientes);
            
        } catch (SQLException e) {
            System.out.println("Error verificando tablas: " + e.getMessage());
        }
    }

    public void cerrarConexion() {
    try {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Conexión cerrada correctamente.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
