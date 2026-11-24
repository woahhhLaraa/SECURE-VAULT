package vault;

import java.io.IOException;
import java.lang.reflect.Field;
//Para manejar alertas de excepciones
import java.nio.file.Files;
//Ejecuta las acciones sobre las rutas o carpetas
import java.nio.file.Path;
//Representa la dirección de la ruta o carpeta
import java.nio.file.Paths;
//Se usa para construir el objeto a partir del texto


public class GestorBoveda {

    public enum Tipo {
        CREDENCIAL, NOTA
    }

    //definimos las rutas sobre las cuales se va a almacenar el GestorBoveda
    private final Path carpetaDatos = Paths.get("vaul_data");
    private final Path carpetaSecretos = carpetaDatos.resolve("secretos");
    private final Path archivoMaestro = carpetaDatos.resolve("maestro.hash");


    private final Cifrable cifrador;

    public GestorBoveda(Cifrable cifrador) {
        this.cifrador = cifrador;
        try {
            Files.createDirectories(carpetaSecretos);
        } catch (IOException e) {
            throw new RuntimeException("No se pudieron crear las carpetas de la boveda", e);
        }
    }

    public boolean existeBoveda() {
        return Files.exists(archivoMaestro);
    }

    public void crearBoveda(String claveMaestra){
        if (claveMaestra == null || claveMaestra.trim().isEmpty()) {
            throw new IllegalArgumentException("La clave maestra no puede estar vacia");
        }    
        String hash = Hasheador.hasheador(claveMaestra);
        try{
            Files.writeString(archivoMaestro, hash); 
        } catch (IOException e) {
            throw new RuntimeException("No se pudo guardar", e);
        }
    }

    public boolean login(String claveIngresada){
        if (claveIngresada == null || !existeBoveda()) {
            return false;
        }
        try {
            String hashGuardado = Files.readString(archivoMaestro).trim();
            String hashIngresado = Hasheador.hasheador(claveIngresada);
            return hashGuardado.equals(hashIngresado);
        } catch (IOException e){
            throw new RuntimeException("Error al leer maestro hash", e);
        }
    }

    public void cambiarClaveMaestra(String claveActual, String claveNueva){
        if (!login(claveActual)) {
            throw new IllegalArgumentException("La clave actual es incorrecta");
        }
        if (claveNueva == null || claveNueva.trim().isEmpty()) {
            throw new IllegalArgumentException("La nueva clave no puede estar vacia");
        }

        try (var archivos = Files.list(carpetaSecretos)){
            for (Path archivo: archivos.toList()) {
                if (archivo.toString().endsWith(".txt")){
                    var lineas = Files.readAllLines(archivo);
                    for (int i = 0; i < lineas.size(); i++){
                       if (lineas.get(i).startsWith("contenidoCifrado=")){
                            String cifradoViejo = lineas.get(i).substring("contenidoCifrado=".length());
                            String textoPlano = cifrador.descifrar(cifradoViejo, claveActual);
                            String cifradoNuevo = cifrador.cifrar(textoPlano, claveNueva);
                            lineas.set(i, "contenidoCifrado=" + cifradoNuevo);
                        }
                    }
                    Files.write(archivo, lineas);
                }
            }
            crearBoveda(claveNueva);
        } catch (IOException e){
            throw new RuntimeException("Error al recifrar la boveda", e);
        }
    }


}

