import java.io.File;
import java.sql.*;

public class BaseD {


    public BaseD() {
        String url = "jdbc:sqlite:src" + File.separator + "main" + File.separator + "BaseDatos.db";
        try {
            Connection conex = DriverManager.getConnection(url);

            Statement dec = conex.createStatement();

            ResultSet reSet = dec.executeQuery("Select * from Legend");

            if (conex != null) {
                System.out.println("Conectado");
            }

        } catch (
                SQLException ex) {
            System.err.println("Error al conectar a la BD\n" + ex.getMessage());
        }

    }



}
