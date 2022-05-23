import javax.swing.*;
import java.io.File;
import java.sql.*;

public class Metodos {



    public static ResultSet Connecting(){
        String url = "jdbc:sqlite:src" + File.separator + "main" + File.separator + "BaseDatos.db";
        ResultSet result=null;
        try {
            Connection conex = DriverManager.getConnection(url);

            Statement dec = conex.createStatement();

            ResultSet reSet = dec.executeQuery("Select * from Legend");

            if (conex!=null) {
                System.out.println("Conectado");
            }

            result=reSet;

        }catch (SQLException ex) {
            System.err.println("Error al conectar a la BD\n"+ex.getMessage());
        }

        return result;
    }

    public static ResultSet insertar(){

        String url = "jdbc:sqlite:src" + File.separator + "main" + File.separator + "BaseDatos.db";
        ResultSet result=null;
        try {
            Connection conex = DriverManager.getConnection(url);

            Statement dec = conex.createStatement();

            PreparedStatement pre = conex.prepareStatement("INSERT INTO Legend(Nombre,Equipo,Dorsal) VALUES(?,?,?)");
            {
                pre.setString(1, JOptionPane.showInputDialog("name?"));
                pre.setString(2, JOptionPane.showInputDialog("Equipo?"));
                pre.setString(3, JOptionPane.showInputDialog("Dorsal?"));
                pre.executeUpdate();
            }

            ResultSet reSet = dec.executeQuery("Select * from Legend");

            result=reSet;
        }catch (SQLException err){
            System.out.println(err.getMessage());
        }
        return result;
    }

    public static ResultSet update(){

        String url = "jdbc:sqlite:src" + File.separator + "main" + File.separator + "BaseDatos.db";
        ResultSet result=null;
        try {
            Connection conex = DriverManager.getConnection(url);

            Statement dec = conex.createStatement();

            PreparedStatement pre = conex.prepareStatement("UPDATE Legend SET Nombre=?,Equipo=?,Dorsal=? WHERE ID=?");
            {
                pre.setString(4, JOptionPane.showInputDialog("ID??"));
                pre.setString(1, JOptionPane.showInputDialog("Intro Nombre"));
                pre.setString(2, JOptionPane.showInputDialog("Intro Equipo"));
                pre.setString(3, JOptionPane.showInputDialog("Intro Dorsal"));
                pre.executeUpdate();
            }

            ResultSet reSet = dec.executeQuery("Select * from Legend");

            result=reSet;
        }catch (SQLException err){
            System.out.println(err.getMessage());
        }
        return result;
    }

    public static ResultSet borrar(){

        String url = "jdbc:sqlite:src" + File.separator + "main" + File.separator + "BaseDatos.db";
        ResultSet result=null;
        try {
            Connection conex = DriverManager.getConnection(url);

            Statement dec = conex.createStatement();

            PreparedStatement pre = conex.prepareStatement("DELETE FROM Legend WHERE ID=?");
            {
                pre.setString(1, JOptionPane.showInputDialog("ID??"));
                pre.executeUpdate();
            }

            ResultSet reSet = dec.executeQuery("Select * from Legend");

            result=reSet;
        }catch (SQLException err){
            System.out.println(err.getMessage());
            System.out.println("borrar");
        }
        return result;
    }
}
