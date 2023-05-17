
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
// Clase que extiende de JFrame
public class PanelAnimales extends JFrame {

    // Atributo de tipo JList
    private JList<Animal> listaAnimales;


    
    public PanelAnimales() {
        // Inicializar el JFrame con un título
        super("Lista de animales");

        // Crear un arreglo de animales para mostrar
        Animal[] animales = {
                new Perro("Firulais", true, 100.0, "Colombia", "Labrador"),
                new Gato("Pelusa", false, 50.0, "Peru", "Siames"),
                new Perro("Rocky", true, 150.0, "Chile", "Pastor aleman"),
                new Gato("Luna", true, 80.0, "Argentina", "Persa")
        };

        // Inicializar el JList con un modelo de lista que contenga los animales
        listaAnimales = new JList<>(new DefaultListModel<>());
        DefaultListModel<Animal> modelo = (DefaultListModel<Animal>) listaAnimales.getModel();
        for (Animal animal : animales) {
            modelo.addElement(animal);
        }

        // Agregar un renderizador personalizado al JList para que muestre el nombre y el tipo de animal
        listaAnimales.setCellRenderer(new AnimalRenderer());

        // Crear un panel y agregar el JList al panel
        JPanel panel = new JPanel();
        panel.setLayout( new BorderLayout());
        

        // Configurar el tamaño y la ubicación del panel
        panel.setSize(400, 300);
        panel.setPreferredSize(new Dimension(300, 300));
        //panel.setLocation(100, 100);

        

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
        
        listaAnimales.setSize(400, 400);
        // Agregar la caja de texto y el botón al panel
        // Crear un GridLayout con dos filas y una columna




        // Crear un panel principal y agregar el JList al panel
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new FlowLayout());
        panelPrincipal.setSize(100, 100);
        panelPrincipal.setVisible(true);
        


        JPanel panel_eliminar_modificar = new JPanel();
        panel_eliminar_modificar.setLayout(new BorderLayout());
        // Agregar el panel al GridLayout
        // Agregar el panel secundario y la lista al panel principal
        panelPrincipal.add(campoBuscar);
        panelPrincipal.add(botonBuscar);
        panel_eliminar_modificar.add(botonEliminar,BorderLayout.WEST);
        panel_eliminar_modificar.add(botonModificar,BorderLayout.EAST);

        panel.add(panelPrincipal,BorderLayout.NORTH);
        panel.add(listaAnimales,BorderLayout.CENTER);
        panel.add(panel_eliminar_modificar,BorderLayout.SOUTH);

        // Agregar el panel al JFrame y hacerlo visible
        add(panel);
        pack();
        setVisible(true);
    }
     
    // Clase interna que implementa la interfaz ListCellRenderer
    private class AnimalRenderer implements ListCellRenderer<Animal> {

        @Override
        public Component getListCellRendererComponent(JList<? extends Animal> list, Animal value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
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

    // Método principal para probar el código
    public static void main(String[] args) {
        new PanelAnimales();
    }
}



public abstract class Animal {
    // Atributos comunes
    private String nombre;
    private boolean vacunasMalota;
    private double costo;
    private String pais;

    // Constructor
    public Animal(String nombre, boolean vacunasMalota, double costo, String pais) {
        this.nombre = nombre;
        this.vacunasMalota = vacunasMalota; // Declarar un arreglo de strings para las vacunas
        this.costo = costo;
        this.pais = pais;
    }

    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    public boolean getVacunasMalota() {
        // Retornar el arreglo de vacunas
        return vacunasMalota;
    }
    
    public void setVacunasMalota(boolean vacunasMalota) {
        // Asignar el arreglo de vacunas
        this.vacunasMalota = vacunasMalota;
    }
    
    // mostrar la información del animal
    public String infogeneral() { 
        String info = "Nombre: " + getNombre() + "\n"; 
        if(getVacunasMalota()){ 
            info += "Esta vacunado\n";
        }else{ 
            info += "no Esta vacunado\n";
        } 
        info += "Costo: " + getCosto() + "\n"; 
        info += "Pais: " + getPais() + "\n"; 
        return info; 
    }
    // Método abstracto para mostrar la información del animal
    public abstract String mostrarInfo();
} 

public class Gato extends Animal {
    // Atributo especifico
    private String color;

    // Constructor
    public Gato(String nombre, boolean vacunas, double costo, String pais, String color) {
        super(nombre, vacunas, costo, pais); // Llamada al constructor de la clase madre
        this.color = color;
    }

    // Método getter y setter
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String mostrarInfo(){
        String info = super.infogeneral();
        info += "Color: " + getColor() + "\n"; 
        return info;
    }
    
}
public class Perro extends Animal {
    // Atributo específico
    private String raza;

    // Constructor
    public Perro(String nombre, boolean vacunas, double costo, String pais, String raza) {
        super(nombre, vacunas, costo, pais); // Llamada al constructor de la clase madre
        this.raza = raza;
    }

    // Método getter y setter
    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override // Método para mostrar la información del gato
    public String mostrarInfo(){
        String info = super.infogeneral();
        info += "Raza: " + getRaza() + "\n"; 
        return info;
    }
}

