package veterinaria_gui;

import java.util.ArrayList; // Importar la clase ArrayList para manejar listas dinámicas
import java.util.Scanner; // Importar la clase Scanner para leer datos del teclado

public class Veterinaria {

   // Atributo para almacenar los animales en una lista
   private ArrayList<Animal> listaAnimales;

   // Constructor
   public Veterinaria() {
       listaAnimales = new ArrayList<>(); // Inicializar la lista vacía
   }

   // Método para agregar un animal a la lista
   public void agregarAnimal(Animal animal) {
       listaAnimales.add(animal); // Añadir el animal al final de la lista
       System.out.println("Animal agregado con éxito.");
   }
    // Método para agregar una mascota
    public void agregarMascota() {
        Scanner sc = new Scanner(System.in); // Crear un objeto Scanner para leer la entrada del usuario
        System.out.println("Ingrese el nombre de la mascota:");
        String nombre = sc.nextLine(); // Leer el nombre de la mascota
        System.out.println("Ingrese el tipo de animal (perro o gato):");
        String tipo = sc.nextLine(); // Leer el tipo de animal
        System.out.println("Ingrese el país de origen:");
        String pais = sc.nextLine(); // Leer el país de origen
        System.out.println("Ingrese el costo de la mascota:");
        double costo = sc.nextDouble(); // Leer el costo de la mascota
        System.out.println("Ingrese si tiene la vacuna malota (S/N):");
        char vacuna = sc.next().charAt(0); // Leer si tiene la vacuna malota
        boolean tieneVacuna = vacuna == 'S' || vacuna == 's'; // Convertir el caracter a un valor booleano
        Animal animal; // Declarar una variable de tipo Animal
        if (tipo.equalsIgnoreCase("perro")) { // Si el tipo es perro
            System.out.println("Ingrese la raza del perro:");
            String raza = sc.next(); // Leer la raza del perro
            animal = new Perro(nombre, tieneVacuna,costo, pais,  raza); // Crear un objeto Perro con los datos ingresados
            //animal = new Perro(nombre, vacunas, costo, pais, raza); // Crear un objeto Perro con los datos ingresados


        } else if (tipo.equalsIgnoreCase("gato")) { // Si el tipo es gato
            System.out.println("Ingrese el color del gato:");
            String color = sc.next(); // Leer el color del gato
            animal = new Gato(nombre, tieneVacuna,costo, pais, color); // Crear un objeto Gato con los datos ingresados
            //animal = new Gato(nombre, vacunas, costo, pais, color); // Crear un objeto Gato con los datos ingresados
        } else { // Si el tipo no es válido
            System.out.println("Tipo de animal inválido");
            return; // Terminar la función sin agregar nada a la lista
        }
        agregarAnimal(animal); // Llamar al método de la clase Veterinaria para agregar el animal a la lista
    }
    
    // Método para buscar un animal por su nombre en la lista
    public Animal buscarAnimal(String nombre) {
       for (Animal animal : listaAnimales) { // Recorrer la lista usando un bucle for-each
           if (animal.getNombre().equals(nombre)) { // Comparar el nombre del animal con el buscado
               return animal;
            }
        }
        return null; // Si no se encuentra el animal, devolver null
    }

    // Método para actualizar un animal de la lista
    public void actualizarAnimal(String nombre, Perro perro) {
        Animal animal = buscarAnimal(nombre); // Buscar el animal por su nombre
        Perro perro_lista = (Perro) animal; // Hacer un casting a Perro
        perro_lista = perro;
    }

    public void actualizarAnimal(String nombre, Gato gato) {
        Animal animal = buscarAnimal(nombre); // Buscar el animal por su nombre
        Gato gato_actuar = (Gato) animal; // Hacer un casting a Gato
        gato_actuar = gato;
    }

    public void actualizarAnimal(String nombre) {
        Animal animal = buscarAnimal(nombre); // Buscar el animal por su nombre
        if (animal != null) { // Si se encontró el animal
            Scanner sc = new Scanner(System.in); // Crear un objeto Scanner para leer datos del teclado
            System.out.println("Ingrese el nuevo nombre: ");
            String nuevoNombre = sc.nextLine(); // Leer el nuevo nombre
            System.out.println("Ingrese si tiene la vacuna malota (S/N):");
            char vacuna = sc.next().charAt(0); // Leer si tiene la vacuna malota
            boolean tieneVacuna = vacuna == 'S' || vacuna == 's'; // Convertir el caracter a un valor booleano
            System.out.println("Ingrese el nuevo costo: ");
            double nuevoCosto = sc.nextDouble(); // Leer el nuevo costo
            System.out.println("Ingrese el nuevo país: ");
            sc.nextLine(); // Limpiar el búfer de entrada
            String nuevoPais = sc.nextLine(); // Leer el nuevo país
            animal.setNombre(nuevoNombre); // Actualizar el nombre del animal
            animal.setVacunasMalota(tieneVacuna); // Actualizar las vacunas del animal
            animal.setCosto(nuevoCosto); // Actualizar el costo del animal
            animal.setPais(nuevoPais); // Actualizar el país del animal
            if (animal instanceof Perro) { // Si el animal es un perro
                Perro perro = (Perro) animal; // Hacer un casting a Perro
                System.out.println("Ingrese la nueva raza: ");
                String nuevaRaza = sc.nextLine(); // Leer la nueva raza
                perro.setRaza(nuevaRaza); // Actualizar la raza del perro
            } else if (animal instanceof Gato) { // Si el animal es un gato
                Gato gato = (Gato) animal; // Hacer un casting a Gato
                System.out.println("Ingrese el nuevo color: ");
                String nuevoColor = sc.nextLine(); // Leer el nuevo color
                gato.setColor(nuevoColor); // Actualizar el color del gato
            }
            System.out.println("Animal actualizado con éxito.");
        } else { // Si no se encontró el animal
            System.out.println("No se encontró ningún animal con ese nombre.");
        }
    }
 
    // Método para eliminar un animal de la lista
    public boolean eliminarAnimal(String nombre) {
        Animal animal = buscarAnimal(nombre); // Buscar el animal por su nombre
        if (animal != null) { // Si se encontró el animal
            listaAnimales.remove(animal); // Eliminar el animal de la lista
            return true;
        } else { // Si no se encontró el animal
            return false;
        }
    }
 
    // Método para listar todos los animales de la lista
    public void listarAnimales() {
        if (listaAnimales.isEmpty()) { // Si la lista está vacía
            System.out.println("No hay animales registrados.");
        } else { // Si la lista no está vacía
            for (Animal animal : listaAnimales) { // Recorrer la lista usando un bucle for-each
                System.out.println(animal.mostrarInfo()); // Mostrar la información de cada animal usando el método polimórfico mostrarInfo()
            }
        }
    }

    public ArrayList<Animal> get_listaAnimales(){
        return listaAnimales;
    }

    // Método para mostrar el menú principal
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 6) {
            System.out.println("Bienvenido a la veterinaria");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar mascota");
            System.out.println("2. Actualizar mascota");
            System.out.println("3. Eliminar mascota");
            System.out.println("4. Buscar mascota por nombre");
            System.out.println("5. Listar todas las mascotas");
            System.out.println("6. Salir");
            opcion = sc.nextInt();
            switch (opcion) {//
                case 1:
                    agregarMascota();
                    break;
                case 2:
                    // Pide al usuario el nombre del animal a actualizar
                    System.out.println("Ingrese el nombre del animal a actualizar:");
                    sc.nextLine();
                    String nombreActualizar = sc.nextLine();
                    // Llama al método actualizarAnimal() con el nombre como parámetro
                    actualizarAnimal(nombreActualizar);
                    break;
                case 3:
                    // Pide al usuario el nombre del animal a eliminar
                    System.out.println("Ingrese el nombre del animal a eliminar:");
                    sc.nextLine();
                    String nombreEliminar = sc.nextLine();
                    // Llama al método eliminarAnimal() con el nombre como parámetro
                    eliminarAnimal(nombreEliminar);
                    break;
                case 4:
                    // Pide al usuario el nombre del animal a buscar
                    System.out.println("Ingrese el nombre del animal a buscar:");
                    sc.nextLine();
                    String nombreBuscar = sc.nextLine();
                    // Llama al método buscarAnimal() con el nombre como parámetro
                    Animal animal_aBuscar= buscarAnimal(nombreBuscar);
                    System.out.println(animal_aBuscar.mostrarInfo());
                    break;
                case 5:
                    listarAnimales();
                    break;
                case 6:
                    System.out.println("Gracias por usar la veterinaria");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
        // Cierra el objeto Scanner
        sc.close();
    }
}
