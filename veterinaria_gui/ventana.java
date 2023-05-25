package veterinaria_gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

import javax.swing.JList; 
import javax.swing.DefaultListModel;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ListCellRenderer;


import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;




public class ventana extends JFrame{
    private JList<Animal> listaAnimales;
    private DefaultListModel<Animal> modelo; 
    public JPanel panelBprincipales;
    public JPanel panelBotones;

    public JPanel panel_crear_perro;
    public JPanel panel_crear_gato;
    public JPanel panel_lista_animal;

    public JPanel panelLogin;
    public JPanel panelMesas;
    public JPanel listaCompras;


    //CrearMesas manejoM = new CrearMesas();

    JButton botonMesas = new JButton();
    JButton botonVend = new JButton();
    JButton usuarios  = new JButton();
    JButton botonLogin = new JButton();

    
    public ventana(){  //Creamos el constructor y dentro de este creamos el JFrame

        setTitle("Veterinaria");
        setSize(700, 450);
        setLocationRelativeTo(null);  
        
        iniciarComponentes();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setVisible(true); //Hacemos visible la ventana
    }    

//============================================================================
    private void iniciarComponentes(){
        listaAnimales = new JList<>(new DefaultListModel<>());
        modelo = (DefaultListModel<Animal>) listaAnimales.getModel(); // Asigna el modelo al atributo de la clase
        iniciarPaneles();
        iniciarBotones();
        crearPanelPerro();
        crearPanelgato();
        crearPanelLista();

        
    }
//============================================================================
    private void iniciarPaneles(){
        panelBprincipales = new JPanel();
        panelBprincipales.setLayout(null);//desactivamos el layout por defecto que esta centrado
        panelBprincipales.setBackground(Color.WHITE);
        // establecemos el color del panel
        panelBprincipales.setSize(300, 600);
        this.getContentPane().add(panelBprincipales);//agregamos el panel a la ventana

        //panel donde se agregan los botones principales
        panelBotones = new JPanel();
        panelBotones.setLayout(null);
        panelBotones.setSize(150, 600);
        panelBotones.setBackground(new Color(30, 136, 229));

        panelBprincipales.add(panelBotones);
      
        
    }

    private void iniciarBotones(){
        botonLogin.setText("Crear perro");
        botonLogin.setBounds(20, 20, 100, 30);
        botonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               //llamamos el metodo que creamos para el panel
                mostrar_crear_perro();
            }
        });
        panelBotones.add(botonLogin);


        
        botonMesas.setText("Crear Gato");
        botonMesas.setBounds(20, 60, 100, 30);
        botonMesas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               //llamamos el metodo que creamos para el panel
                mostrar_crear_gatos();
            }
        });
        panelBotones.add(botonMesas);


        
        botonVend.setText("Lista Animales");
        botonVend.setBounds(20, 100, 100, 30);
        botonVend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MostrarLista();
            }
        });
        panelBotones.add(botonVend);

        
        
        usuarios .setText("Proximamente 2");
        usuarios .setBounds(20, 140, 100, 30);
        //panelBotones.add(usuarios);

        
       //creamos el boton cerrar y configuramos su funcionamiento
        JButton botonCe = new JButton();
        botonCe.setText("Cerrar");
        botonCe.setBounds(20, 180, 100, 30);

       
        botonCe.addActionListener(new ActionListener() {  //agregamos el addAcionlistener al boton para que al precionarlo funcione

            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(null, "desea salir de la APP", "SALIR", JOptionPane.YES_NO_OPTION);
                if(respuesta == JOptionPane.YES_OPTION){ //creamos el bucle que se encarga de evaluar la desicion de usiario
                    System.exit(0);
                }
                
            }
            
        });

        panelBotones.add(botonCe);
 
    }

//============================================================================

    public void crearPanelPerro() {
        // Crear un panel
        panel_crear_perro = new JPanel();

        // Crear los componentes del panel
        JLabel titulo = new JLabel("Agregar perro");

        // Cambiar la fuente del título a Arial negrita de 18 puntos
        titulo.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel nombreLabel = new JLabel("Nombre:");
        JTextField nombreField = new JTextField(10);
        JLabel vacunasLabel = new JLabel("Vacunado:");
        JCheckBox vacunasCheck = new JCheckBox();
        JLabel costoLabel = new JLabel("Costo:");
        JTextField costoField = new JTextField(10);
        JLabel paisLabel = new JLabel("Pais:");
        JTextField paisField = new JTextField(10);
        JLabel razaLabel = new JLabel("Raza:");
        JTextField razaField = new JTextField(10);
        JButton crearButton = new JButton("Crear");

        // Agregar un listener al botón crear
        crearButton.addActionListener(e -> {
        // Obtener los datos del panel
        String nombre = nombreField.getText();
        boolean vacunas = vacunasCheck.isSelected();
        double costo = Double.parseDouble(costoField.getText());
        String pais = paisField.getText();
        String raza = razaField.getText();

        // Crear un objeto perro con los datos
        Perro perro = new Perro(nombre, vacunas, costo, pais, raza);
        modelo.addElement(perro);
        // Mostrar la información del perro en una ventana emergente
        //JOptionPane.showMessageDialog(panel_crear_perro, perro.mostrarInfo(), "Perro creado", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(panel_crear_perro, "Perro creado","perro hecho puto", JOptionPane.INFORMATION_MESSAGE);
        // Limpiar los campos del panel
        nombreField.setText("");
        vacunasCheck.setSelected(false);
        costoField.setText("");
        paisField.setText("");
        razaField.setText("");
        });

        // Agregar los componentes al panel
        panel_crear_perro.add(titulo);
        panel_crear_perro.add(new JLabel(""));
        panel_crear_perro.add(nombreLabel);
        panel_crear_perro.add(nombreField);
        panel_crear_perro.add(vacunasLabel);
        panel_crear_perro.add(vacunasCheck);
        panel_crear_perro.add(costoLabel);
        panel_crear_perro.add(costoField);
        panel_crear_perro.add(paisLabel);
        panel_crear_perro.add(paisField);
        panel_crear_perro.add(razaLabel);
        panel_crear_perro.add(razaField);
        panel_crear_perro.add(crearButton);

        // Establecer el tamaño y el layout del panel
        //panel_crear_perro.setPreferredSize(new Dimension(300, 200));

        // Usar un GridLayout de 5 filas y 2 columnas para el panel
        panel_crear_perro.setLayout(new GridLayout(7, 1));
        panel_crear_perro.setBackground(Color.WHITE);
        panel_crear_perro.setSize(300, 300);
        panel_crear_perro.setVisible(true);
        panel_crear_perro.setBounds(200, 0, 300, 300);
        // Establecer la operación de cierre del JFrame
        panelBprincipales.add(panel_crear_perro);

    }

    public void crearPanelgato() {
        // Crear un panel
        panel_crear_gato = new JPanel();

        // Crear los componentes del panel
        JLabel titulo = new JLabel("Agregar Gato");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel nombreLabel = new JLabel("Nombre:");
        JTextField nombreField = new JTextField(10);
        JLabel vacunasLabel = new JLabel("Vacunado:");
        JCheckBox vacunasCheck = new JCheckBox();
        JLabel costoLabel = new JLabel("Costo:");
        JTextField costoField = new JTextField(10);
        JLabel paisLabel = new JLabel("Pais:");
        JTextField paisField = new JTextField(10);
        JLabel colorLabel = new JLabel("Color:");
        JTextField razaField = new JTextField(10);
        JButton crearButton = new JButton("Crear");

        // Agregar un listener al botón crear
        crearButton.addActionListener(e -> {
            // Obtener los datos del panel
            String nombre = nombreField.getText();
            boolean vacunas = vacunasCheck.isSelected();
            double costo = Double.parseDouble(costoField.getText());
            String pais = paisField.getText();
            String color = colorLabel.getText();

            // Crear un objeto perro con los datos
            Gato gatoNuevo = new Gato(nombre, vacunas, costo, pais, color);
            modelo.addElement(gatoNuevo); // Agrega el elemento
            // Mostrar la información del perro en una ventana emergente
            JOptionPane.showMessageDialog(panel_crear_gato, gatoNuevo.mostrarInfo(), "Gato creado", JOptionPane.INFORMATION_MESSAGE);

            // Limpiar los campos del panel
            nombreField.setText("");
            vacunasCheck.setSelected(false);
            costoField.setText("");
            paisField.setText("");
            razaField.setText("");
        });

        // Agregar los componentes al panel
        panel_crear_gato.add(titulo);
        panel_crear_gato.add(new JLabel(""));
        panel_crear_gato.add(nombreLabel);
        panel_crear_gato.add(nombreField);
        panel_crear_gato.add(vacunasLabel);
        panel_crear_gato.add(vacunasCheck);
        panel_crear_gato.add(costoLabel);
        panel_crear_gato.add(costoField);
        panel_crear_gato.add(paisLabel);
        panel_crear_gato.add(paisField);
        panel_crear_gato.add(colorLabel);
        panel_crear_gato.add(razaField);
        panel_crear_gato.add(crearButton);

        // Establecer el tamaño y el layout del panel
        panel_crear_gato.setLayout(new GridLayout(7, 1));
        panel_crear_gato.setBackground(Color.WHITE);
        panel_crear_gato.setSize(300, 300);
        panel_crear_gato.setVisible(false);
        panel_crear_gato.setBounds(200, 0, 300, 300);

        panelBprincipales.add(panel_crear_gato);
    }

    public void crearPanelLista() {
        // Inicializar el JList con un modelo de lista que contenga los animales
        //listaAnimales = new JList<>(new DefaultListModel<>());
        // Agregar un renderizador personalizado al JList para que muestre el nombre y el tipo de animal
        listaAnimales.setCellRenderer(new AnimalRenderer());

        // Crear un panel y agregar el JList al panel
        panel_lista_animal = new JPanel();

        // Crear un botón de modificar
        JButton botonModificar = new JButton("Modificar");

        // Agregar un escuchador de eventos al botón para que se ejecute una acción cuando se haga clic en él
        botonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el objeto seleccionado en el JList y verificar que no sea nulo
                Animal animal = listaAnimales.getSelectedValue();
                if (animal != null) {
                    // Crear una ventana emergente con campos de texto para ingresar los nuevos datos del objeto
                    JTextField nombreField = new JTextField(animal.getNombre());
                    JTextField costoField = new JTextField(String.valueOf(animal.getCosto()));
                    JTextField paisField = new JTextField(animal.getPais());
                    JTextField atributoField;
                    if (animal instanceof Perro) {
                        atributoField = new JTextField(((Perro) animal).getRaza());
                    } else {
                        atributoField = new JTextField(((Gato) animal).getColor());
                    }
                    Object[] campos = {
                            "Nombre:", nombreField,
                            "Costo:", costoField,
                            "Pais:", paisField,
                            animal instanceof Perro ? "Raza:" : "Color:", atributoField
                    };
                    int opcion = JOptionPane.showConfirmDialog(null, campos, "Modificar animal", JOptionPane.OK_CANCEL_OPTION);
                    // Si se presiona el botón OK, asignar los nuevos datos al objeto y actualizar el modelo de la lista
                    if (opcion == JOptionPane.OK_OPTION) {
                        animal.setNombre(nombreField.getText());
                        animal.setCosto(Double.parseDouble(costoField.getText()));
                        animal.setPais(paisField.getText());
                        if (animal instanceof Perro) {
                            ((Perro) animal).setRaza(atributoField.getText());
                        } else {
                            ((Gato) animal).setColor(atributoField.getText());
                        }
                        listaAnimales.repaint();
                    }
                }
            }
        });

        // Crear un botón con un texto que indique la acción de eliminar
        JButton botonEliminar = new JButton("Eliminar");

        // Agregar un escuchador de eventos al botón para que se ejecute una acción cuando se haga clic en él
        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el objeto seleccionado en el JList y verificar que no sea nulo
                Animal animal = listaAnimales.getSelectedValue();
                if (animal != null) {
                    // Eliminar el objeto del modelo de la lista
                    DefaultListModel<Animal> modelo = (DefaultListModel<Animal>) listaAnimales.getModel();
                    modelo.removeElement(animal);
                }
            }
        });

        // Crear una caja de texto con un texto vacío
        JTextField campoBuscar = new JTextField();
        campoBuscar.setSize(100, 300);
        campoBuscar.setPreferredSize(new Dimension(80, 50));
        // Crear un botón con un texto que indique la acción de buscar
        JButton botonBuscar = new JButton("Buscar");
        botonBuscar.setPreferredSize(new Dimension(80, 50));
        // Agregar un escuchador de eventos al botón para que se ejecute una acción cuando se haga clic en él
        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el texto de la caja de texto y verificar que no sea vacío
                String nombre = campoBuscar.getText();
                if (!nombre.isEmpty()) {
                    // Recorrer el modelo de la lista y comparar el nombre de cada animal con el texto de la caja de texto
                    DefaultListModel<Animal> modelo = (DefaultListModel<Animal>) listaAnimales.getModel();
                    boolean encontrado = false;
                    for (int i = 0; i < modelo.getSize(); i++) {
                        Animal animal = modelo.getElementAt(i);
                        if (animal.getNombre().equals(nombre)) {
                            // Si se encuentra una coincidencia, seleccionar el animal en el JList y mostrar un mensaje de éxito
                            listaAnimales.setSelectedIndex(i);
                            JOptionPane.showMessageDialog(null, "Animal encontrado: " + animal.mostrarInfo());
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        // Si no se encuentra ninguna coincidencia, mostrar un mensaje de error
                        JOptionPane.showMessageDialog(null, "No se encontró ningún animal con ese nombre.");
                    }
                }
            }
        });
        
        
        // Agregar la caja de texto y el botón al panel
        // Crear un GridLayout con dos filas y una columna




        // Crear un panel principal y agregar el JList al panel
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new FlowLayout());
        panelPrincipal.setSize(100, 100);
        panelPrincipal.setVisible(true);
        
        panelPrincipal.add(campoBuscar);
        panelPrincipal.add(botonBuscar);

        JPanel panel_eliminar_modificar = new JPanel();
        panel_eliminar_modificar.setLayout(new BorderLayout());
        // Agregar el panel al GridLayout
        // Agregar el panel secundario y la lista al panel principal
        
        panel_eliminar_modificar.add(botonEliminar,BorderLayout.WEST);
        panel_eliminar_modificar.add(botonModificar,BorderLayout.EAST);

        //panel_lista_animal.setLayout( new BorderLayout());
        panel_lista_animal.setLayout(new BorderLayout());

        // Configurar el tamaño y la ubicación del panel
        panel_lista_animal.setSize(450, 400);
        //panel_lista_animal.setPreferredSize(new Dimension(500, 500));
        panel_lista_animal.setBounds(200, 0, 450, 400);
        panel_lista_animal.setVisible(false);
        // Agregar el panel al JFrame y hacerlo visible
        
        panel_lista_animal.add(panelPrincipal,BorderLayout.NORTH);
        panel_lista_animal.add(listaAnimales,BorderLayout.CENTER);
        panel_lista_animal.add(panel_eliminar_modificar,BorderLayout.SOUTH);
        //panel_crear_gato.setLayout(new GridLayout(7, 1));
        //panel_crear_gato.setBackground(Color.WHITE);
        //panel_crear_gato.setSize(300, 300);
        //panel_crear_gato.setVisible(false);
        //panel_crear_gato.setBounds(200, 0, 300, 300);

        panelBprincipales.add(panel_lista_animal);  
    }
     
    // Clase interna que implementa la interfaz ListCellRenderer
    private class AnimalRenderer implements ListCellRenderer<Animal> {

        @Override
        public Component getListCellRendererComponent(JList<? extends Animal> list, Animal value, int index,boolean isSelected, boolean cellHasFocus) {
            // Crear un JLabel con el nombre y el tipo de animal
            JLabel label = new JLabel(value.getNombre() + " (" + value.getClass().getSimpleName() + ")");
            label.setOpaque(true);

            // Cambiar el color del fondo y del texto según si el elemento está seleccionado o no
            if (isSelected) {
                label.setBackground(list.getSelectionBackground());
                label.setForeground(list.getSelectionForeground());
            } else {
                label.setBackground(list.getBackground());
                label.setForeground(list.getForeground());
            }

            return label;
        }
    }

   
//============================================================================    
    
    
    private void apagarTodo(){
        panel_crear_gato.setVisible(false);
        panel_crear_perro.setVisible(false);
        panel_lista_animal.setVisible(false);
    }

    private void mostrar_crear_gatos(){
        apagarTodo();
        panel_crear_gato.setVisible(true);
        revalidate();
        repaint();
    }

    private void mostrar_crear_perro(){
        apagarTodo();
        panel_crear_perro.setVisible(true);
        revalidate();
        repaint();
    }
    private void MostrarLista(){
        apagarTodo();
        panel_lista_animal.setVisible(true);
        revalidate();
        repaint();
    }
}


