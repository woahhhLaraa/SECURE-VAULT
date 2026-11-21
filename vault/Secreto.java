package vault;

// Clase abstracta: es el "molde" general de cualquier secreto.
// No se puede hacer new Secreto(), solo new Credencial() o new NotaTexto().
public abstract class Secreto {

    // Atributos private: solo esta clase los puede tocar directamente
    private String id;
    private String nombre;
    private String hashNombre;
    private String contenidoCifrado;

    // Constructor: lo usan las clases hijas con super([parametros extras])
    public Secreto(String id, String nombre, String hashNombre, String contenidoCifrado) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El id no puede estar vacio");
        }
        this.id = id;
        setNombre(nombre);
        setHashNombre(hashNombre);
        setContenidoCifrado(contenidoCifrado);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getHashNombre() {
        return hashNombre;
    }

    public String getContenidoCifrado() {
        return contenidoCifrado;
    }

    // Setters final: las clases hijas no los pueden cambiar (sobrescribir)
    public final void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        this.nombre = nombre;
    }

    public final void setHashNombre(String hashNombre) {
        if (hashNombre == null || hashNombre.isBlank()) {
            throw new IllegalArgumentException("El hash del nombre no puede estar vacio");
        }
        this.hashNombre = hashNombre;
    }

    public final void setContenidoCifrado(String contenidoCifrado) {
        if (contenidoCifrado == null || contenidoCifrado.isBlank()) {
            throw new IllegalArgumentException("El contenido cifrado no puede estar vacio");
        }
        this.contenidoCifrado = contenidoCifrado;
    }

    // Metodo abstracto: no tiene cuerpo aqui.
    // Cada clase hija lo escribe a su manera con @Override.
    public abstract void mostrarDetalle(String contenidoPlano);
}
