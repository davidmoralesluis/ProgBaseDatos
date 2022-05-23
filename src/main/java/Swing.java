import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Swing implements ActionListener {

    JFrame ventana;
    JPanel panel;
    JLabel titulo;



    JButton borrar,insertar,modificar,conectar;




    public void run(){

        ventana = new JFrame();
        ventana.setBounds(1200,50,500,300);
        ventana.setLayout(null);

        panel = new JPanel();
        panel.setBounds(0,0,500,300);
        panel.setBackground(new Color(150, 150, 150));
        panel.setLayout(null);

        conectar = new JButton("Conect");
        conectar.setBounds(20,100,180,50);

        modificar = new JButton("Mod");
        modificar.setBounds(300,100,180,50);

        borrar = new JButton("DELETE");
        borrar.setBounds(20,200,180,50);

        insertar = new JButton("AGREGAR TABOA");
        insertar.setBounds(300,200,180,50);

        titulo = new JLabel("BASE DE DATOS");
        titulo.setBounds(200,20,100,50);


        panel.add(modificar);
        panel.add(conectar);
        panel.add(borrar);
        panel.add(insertar);
        panel.add(titulo);


        ventana.add(panel);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra Aplicacion cuando X;
        ventana.setVisible(true);

        conectar.addActionListener(this);
        borrar.addActionListener(this);
        insertar.addActionListener(this);
        modificar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ResultSet reSet;


        if(e.getSource()==borrar){
            Metodos.borrar();
        }

        if(e.getSource()==conectar){
            Metodos.Connecting();
        }

        if(e.getSource()==modificar){
            Metodos.update();
        }

        if(e.getSource()==insertar){
            Metodos.insertar();
        }





    }
}
