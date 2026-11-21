package vault;

import java.nio.file.Files; // para preguntar cosas del archivo por ejemplo ahorita es maestro.hash
import java.nio.file.Path;  // para crear la ruta del archivo en este caso es maestro.hash
import java.util.Scanner;   // para leer lo que el usuario escribe en la consola

public class Main {

    //String[] args: argumentos de la línea de comandos. No los usamos, pero Java exige que estén.
    public static void main(String[] args) {
        //scanner crea el lector de teclado. System.in es "la entrada estándar", es decir, el teclado. Se crea una sola vez y se reutiliza todo el programa
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== SECURE VAULT =====");

        // 1. Vemos si la boveda ya existe (si ya hay un archivo maestro.hash)
        Path archivoMaestro = Path.of("vault_data", "maestro.hash");

        if (Files.exists(archivoMaestro)) {
            // Ya existe: pedimos la clave para entrar
            System.out.print("Escribe tu clave maestra: ");
            String clave = scanner.nextLine();
            // TODO (lunes): if (!gestor.login(clave)) { ... } cuando C termine el login
            System.out.println("Bienvenido de nuevo.");
        } else {
            // No existe: creamos una boveda nueva
            System.out.println("No hay boveda todavia. Vamos a crear una.");
            System.out.print("Elige una clave maestra: ");
            String clave = scanner.nextLine();
            // TODO (lunes): gestor.crearBoveda(clave) cuando C termine esa parte
            System.out.println("Boveda creada.");
        }

        // Mientras la opcion sea diferente de 9 el menu se repite  
        int opcion = 0;
        while (opcion != 9) {
            System.out.println();
            System.out.println("===== MENU PRINCIPAL =====");
            System.out.println("1. Crear secreto");
            System.out.println("2. Listar secretos");
            System.out.println("3. Ver secreto por ID");
            System.out.println("4. Modificar secreto");
            System.out.println("5. Eliminar secreto");
            System.out.println("6. Buscar por nombre");
            System.out.println("7. Buscar por tipo");
            System.out.println("8. Cambiar clave maestra");
            System.out.println("9. Salir");
            System.out.print("Elige una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // limpia el Enter que queda despues del numero

            // Falta conectar todas las opciones con GestorBoveda
            switch (opcion) {
                case 1:
                    System.out.println("[Crear secreto] Pendiente");
                    break;
                case 2:
                    System.out.println("[Listar secretos] Pendiente");
                    break;
                case 3:
                    System.out.println("[Ver secreto por ID] Pendiente");
                    break;
                case 4:
                    System.out.println("[Modificar secreto] Pendiente");
                    break;
                case 5:
                    System.out.println("[Eliminar secreto] Pendiente");
                    break;
                case 6:
                    System.out.println("[Buscar por nombre] Pendiente");
                    break;
                case 7:
                    System.out.println("[Buscar por tipo] Pendiente");
                    break;
                case 8:
                    System.out.println("[Cambiar clave maestra] Pendiente");
                    break;
                case 9:
                    System.out.println("Adios.");
                    break;
                default:
                    System.out.println("Opcion no valida, elige del 1 al 9.");
            }
        }

        scanner.close();
    }
}
