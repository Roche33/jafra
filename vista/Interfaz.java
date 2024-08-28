package vista;
import modelo.Producto;
import controlador.Registro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame{
    private Registro registroProducto;
    private JTextField campoClave;
    private JTextField campoDescripcion;
    private JTextField campoFecha;
    private JTextField campoCantidad;

    public Interfaz() {
        registroProducto = new Registro();
        //FRAME
        setTitle("Inventario Jafra");
        setSize(700, 225);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocation(140, 75);

        //Panel1
        JPanel panelito = new JPanel();
        JButton botonAgregar = new JButton("Agregar Producto");
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                panelAgregar();
            }
        });
        panelito.add(botonAgregar);
        JButton botonBorrar = new JButton("Eliminar Producto");
        botonBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                panelEliminar();
            }
        });
        panelito.add(botonBorrar);

        add(panelito, BorderLayout.CENTER);

        setVisible(true);
    }

    private void agregarProducto() {
        try {
            String clave = campoClave.getText();
            String descripcion = campoDescripcion.getText();
            String fechaEntrada = campoFecha.getText();
            String cantidad = campoCantidad.getText();
            
            Producto producto = new Producto(clave,descripcion, fechaEntrada, cantidad);
            registroProducto.agregarProducto(producto);

            campoClave.setText("");
            campoDescripcion.setText("");
            campoFecha.setText("");
            campoCantidad.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Agregar datos correctos", "Error", JOptionPane.ERROR_MESSAGE);
            //mensajeError();
        }
    }
    private void baseDatos() {
        JFrame dataFrame = new JFrame("Base de Datos de Carros");
        dataFrame.setSize(700, 400);
        dataFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dataFrame.setLayout(new BorderLayout());

        DefaultTableModel tablaModelo = new DefaultTableModel(new String[]{"Clave", "Descripcion", "Fecha de entrada", "Cantidad"}, 0);
        JTable carroTabla = new JTable(tablaModelo);
        JScrollPane scrollPane = new JScrollPane(carroTabla);
        dataFrame.add(scrollPane, BorderLayout.CENTER);

        for (Producto pro : registroProducto.getProducto()) {
            tablaModelo.addRow(new Object[]{pro.getClave(), pro.getDescripcion(), pro.getfechaEntrada(), pro.getCantidad()});
        }

        dataFrame.setVisible(true);
    }

    private void panelEliminar(){
        JPanel panelEliminar = new JPanel();
        panelEliminar.setBackground(Color.GREEN);
        panelEliminar.setLayout(new FlowLayout());
        panelEliminar.add(new JLabel("Eliminar producto"));
        
        panelEliminar.setVisible(true);
    }

    private void panelAgregar(){
        //PANEL
        JFrame panel = new JFrame();
        panel.setSize(700, 225);
        panel.setLocation(140, 75);
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("Clave:"));
        campoClave = new JTextField();
        panel.add(campoClave);

        panel.add(new JLabel("Descripcion:"));
        campoDescripcion = new JTextField();
        panel.add(campoDescripcion);

        panel.add(new JLabel("Fecha de entrada:"));
        campoFecha = new JTextField();
        panel.add(campoFecha);

        panel.add(new JLabel("Cantidad:"));
        campoCantidad = new JTextField();
        panel.add(campoCantidad);
        
        //BOTONES
        JButton Boton = new JButton("Agregar Producto");
        Boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });
        panel.add(Boton);
        
        JButton Boton2 = new JButton("Ver base de datos");
        Boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                baseDatos();
            }
        });
        panel.add(Boton2);
        
        panel.setVisible(true);
    }
    public static void main(String[] args) {
        new Interfaz();
    }
}

