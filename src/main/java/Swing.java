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
    //JLabel nome;



    JButton borrar,insertar,modificar,conectar;



    String [] columnas={"Nombre","Apellido","Curso"};
    DefaultTableModel modelo = new DefaultTableModel();

    JTable tabla = new JTable (modelo);



    public void run(){

        ventana = new JFrame();
        ventana.setBounds(1200,50,600,600);
        ventana.setLayout(null);

        panel = new JPanel();
        panel.setBounds(0,0,600,600);
        panel.setBackground(new Color(150, 150, 150));
        panel.setLayout(null);

        conectar = new JButton("Conect");
        conectar.setBounds(180,60,180,30);

        modificar = new JButton("Mod");
        modificar.setBounds(380,60,180,30);

        borrar = new JButton("DELETE");
        borrar.setBounds(180,140,180,30);

        insertar = new JButton("AGREGAR TABOA");
        insertar.setBounds(380,140,180,30);

        tabla.setBounds(50,250,500,270);
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Curso");
        modelo.setColumnIdentifiers(columnas);



        panel.add(modificar);
        panel.add(conectar);
        panel.add(borrar);
        panel.add(insertar);
        panel.add(tabla);


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
        if(e.getSource()==conectar){

            reSet=Metodos.Connecting();

            try {
                while(reSet.next()){

                    modelo.addRow(new Object[]{reSet.getString("ID"),reSet.getString("Nombre"),reSet.getString("Dorsal")});
                    System.out.println("++++++++++++++++++++");
                }
            }catch (SQLException ex){
                System.err.println("Error al conectar a la BD\n"+ex.getMessage());
            }
        }

        if(e.getSource()==borrar){

            reSet=Metodos.borrar();

        }



    }
}
