package veterinaria_gui;

// Clase Controlador
public class Controlador {

    // Atributos para el modelo y la vista
    private Veterinaria modelo;
    private Vista vista;

    // Constructor
    public Controlador(Veterinaria modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setControlador(this); // Asignar el controlador a la vista
    }

    // Método para inicializar la vista
    public void iniciarVista() {
        vista.setVisible(true); // Hacer visible la ventana
        vista.actualizarLista(modelo.get_listaAnimales()); // Actualizar la lista de animales con los datos del modelo
    }

    // Método para agregar un animal al modelo y a la vista
    public void agregarAnimal(String nombre, String tipo, String pais, double costo, boolean vacuna, String raza, String color) {
        Animal animal; // Declarar una variable de tipo Animal
        if (tipo.equalsIgnoreCase("perro")) { // Si el tipo es perro
            animal = new Perro(nombre, vacuna,costo, pais,  raza); // Crear un objeto Perro con los datos ingresados
        } else if (tipo.equalsIgnoreCase("gato")) { // Si el tipo es gato
            animal = new Gato(nombre, vacuna,costo, pais, color); // Crear un objeto Gato con los datos ingresados
        } else { // Si el tipo no es válido
            vista.mostrarMensaje("Tipo de animal inválido"); // Mostrar un mensaje de error en la vista
            return; // Terminar la función sin agregar nada al modelo ni a la vista
        }
        modelo.agregarAnimal(animal); // Llamar al método del modelo para agregar el animal a la lista
        vista.actualizarLista(modelo.get_listaAnimales()); // Llamar al método de la vista para actualizar la lista de animales con los datos del modelo
        vista.mostrarMensaje("Animal agregado con éxito."); // Mostrar un mensaje de confirmación en la vista
    }

    // Método para buscar un animal por su nombre en el modelo y mostrarlo en la vista
    public void buscarAnimal(String nombre) {
        Animal animal = modelo.buscarAnimal(nombre); // Llamar al método del modelo para buscar el animal por su nombre
        if (animal != null) { // Si se encontró el animal
            vista.mostrarAnimal(animal); // Llamar al método de la vista para mostrar los datos del animal en los campos de texto
            vista.mostrarMensaje("Animal encontrado."); // Mostrar un mensaje de confirmación en la vista

        } else { // Si no se encontró el animal
            vista.mostrarMensaje("No se encontró ningún animal con ese nombre."); // Mostrar un mensaje de error en la vista
        }
    }

    // Método para actualizar un animal del modelo y de la vista
    public void actualizarAnimal(String nombre, String tipo, String pais, double costo, boolean vacuna, String raza, String color) {
        Animal animal = modelo.buscarAnimal(nombre); // Llamar al método del modelo para buscar el animal por su nombre
        if (animal != null) { // Si se encontró el animal
            if (animal instanceof Perro) { // Si el animal es un perro
                Perro perro = (Perro) animal; // Hacer un casting a Perro
                perro.setNombre(nombre); // Actualizar el nombre del perro
                perro.setVacunasMalota(vacuna); // Actualizar las vacunas del perro
                perro.setCosto(costo); // Actualizar el costo del perro
                perro.setPais(pais); // Actualizar el país del perro
                perro.setRaza(raza); // Actualizar la raza del perro

            } else if (animal instanceof Gato) { // Si el animal es un gato
                Gato gato = (Gato) animal; // Hacer un casting a Gato
                gato.setNombre(nombre); // Actualizar el nombre del gato
                gato.setVacunasMalota(vacuna); // Actualizar las vacunas del gato
                gato.setCosto(costo); // Actualizar el costo del gato
                gato.setPais(pais); // Actualizar el país del gato
                gato.setColor(color); // Actualizar el color del gato
            }
            vista.actualizarLista(modelo.get_listaAnimales()); // Llamar al método de la vista para actualizar la lista de animales con los datos del modelo
            vista.mostrarMensaje("Animal actualizado con éxito."); // Mostrar un mensaje de confirmación en la vista
        } else { // Si no se encontró el animal
            vista.mostrarMensaje("No se encontró ningún animal con ese nombre."); // Mostrar un mensaje de error en la vista
        }
    }

    // Método para mostrar los datos de un animal en la vista
    public void mostrarAnimal(String nombre) {
        Animal animal = modelo.buscarAnimal(nombre); // Llamar al método del modelo para buscar el animal por su nombre
        vista.mostrarAnimal(animal); // Llamar al método de la vista para mostrar los datos del animal en los campos de texto
    }
    // Método para eliminar un animal de la lista
    public boolean eliminarAnimal(String nombre) {
        return modelo.eliminarAnimal(nombre); // Buscar el animal por su nombre
    }
}
