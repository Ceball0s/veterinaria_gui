package veterinaria_gui;
// Clase madre animales
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
