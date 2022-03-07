
import dao.Autores;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    private static EntityManager manager;
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenciaMySQL");

    public static void main(String[] args) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        
        manager.getTransaction().commit();
        manager.close();

    }

    private static void menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Crear autor");
        System.out.println("2. Crear libro");
        System.out.println("3. Borrar autor");
        System.out.println("4. Borrar libro");
        System.out.println("5. Info libro por titulo");
        System.out.println("6. Libros de un autor");
        System.out.println("7. Ver todos los libros");
        System.out.println("8. Todos los autores con sus libros");
    }

    private void crearLibro() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce el DNI");
        String dni = scan.nextLine();
        System.out.println("Intorduce el nombre:");
        String nombre = scan.nextLine();
        System.out.println("Nacionalidad");
        String nacionalidad = scan.nextLine();
        Autores autor = new Autores(dni, nombre, nacionalidad);

    }
}
