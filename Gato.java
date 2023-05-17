package veterinaria_gui;
//import veterinaria.Animal; // Descomentar esta linea si Animal esta en otro paquete

// Clase hija gatos
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