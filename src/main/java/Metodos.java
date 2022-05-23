import javax.swing.*;
import java.io.File;
import java.sql.*;

public class Metodos {


    public static void Connecting() {
        String url = "jdbc:sqlite:src" + File.separator + "main" + File.separator + "BaseDatos.db";

        try {
            Connection conex = DriverManager.getConnection(url);

            Statement dec = conex.createStatement();

            ResultSet reSet = dec.executeQuery("Select * from Legend");

            if (conex != null) {
                System.out.println("Conectado");
            }

            for (int i = 0; i < 5; i++) {
                System.out.println("+++++++++");
            }
            while(reSet.next()){
                System.out.println(reSet.getString("ID")+" - "+reSet.getString("Nombre")+" tiene el dorsal Nr. "+reSet.getString("Dorsal"));
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("+++++++++");
            }

        } catch (SQLException ex) {
            System.err.println("Error al conectar a la BD\n" + ex.getMessage());
        }


    }

    public static void insertar() {

        String url = "jdbc:sqlite:src" + File.separator + "main" + File.separator + "BaseDatos.db";

        try {
            Connection conex = DriverManager.getConnection(url);

            Statement dec = conex.createStatement();

            PreparedStatement pre = conex.prepareStatement("INSERT INTO Legend(ID,Nombre,Equipo,Dorsal) VALUES(?,?,?,?)");
            {
                pre.setString(1, JOptionPane.showInputDialog("ID?"));
                pre.setString(2, JOptionPane.showInputDialog("name?"));
                pre.setString(3, JOptionPane.showInputDialog("Equipo?"));
                pre.setString(4, JOptionPane.showInputDialog("Dorsal?"));
                pre.executeUpdate();
            }

            ResultSet reSet = dec.executeQuery("Select * from Legend");

            for (int i = 0; i < 5; i++) {
                System.out.println("+++++++++");
            }
            while(reSet.next()){
                System.out.println(reSet.getString("ID")+" - "+reSet.getString("Nombre")+" tiene el dorsal Nr. "+reSet.getString("Dorsal"));
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("+++++++++");
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    public static void update() {

        String url = "jdbc:sqlite:src" + File.separator + "main" + File.separator + "BaseDatos.db";
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

            for (int i = 0; i < 5; i++) {
                System.out.println("+++++++++");
            }
            while(reSet.next()){
                System.out.println(reSet.getString("ID")+" - "+reSet.getString("Nombre")+" tiene el dorsal Nr. "+reSet.getString("Dorsal"));
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("+++++++++");
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    public static void borrar() {

        String url = "jdbc:sqlite:src" + File.separator + "main" + File.separator + "BaseDatos.db";
        try {
            Connection conex = DriverManager.getConnection(url);

            Statement dec = conex.createStatement();

            PreparedStatement pre = conex.prepareStatement("Delete FROM Legend WHERE ID=?");
            {
                pre.setString(1, JOptionPane.showInputDialog("ID??"));
                pre.executeUpdate();
            }

            ResultSet reSet = dec.executeQuery("Select * from Legend");

            for (int i = 0; i < 5; i++) {
                System.out.println("+++++++++");
            }
            while(reSet.next()){
                System.out.println(reSet.getString("ID")+" - "+reSet.getString("Nombre")+" tiene el dorsal Nr. "+reSet.getString("Dorsal"));
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("+++++++++");
            }


        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
}
