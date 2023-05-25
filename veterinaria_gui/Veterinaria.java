package veterinaria_gui;
// Clase hija Perro
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

    
