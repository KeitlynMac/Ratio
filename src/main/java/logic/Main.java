package logic;


import database.Conexion;

public class Main {
    
    public static void main(String[] args) {
        Conexion conexion = Conexion.getInstance();

        conexion.conectarBaseDatos();
    }
}
