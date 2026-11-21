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
        // si id es null o esta vacio, lanzamos una excepcion IllegalArgumentException
        if (id == null || id.isBlank()) {
            // Lanzamos una excepcion porque el id no puede estar vacio
            throw new IllegalArgumentException("El id no puede estar vacio");
        }
        // esta parte se ejecuta si el id es valido: lo guardamos en el atributo
        //this sirve para referirnos al atributo de la clase, no a la variable local del constructor
        this.id = id;
        //set sirve para validar y guardar el nombre, hashNombre y contenidoCifrado
        setNombre(nombre);
        setHashNombre(hashNombre);
        setContenidoCifrado(contenidoCifrado);
    }

    // Getters o "obtenedores": permiten leer los atributos private desde afuera de la clasex
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

    // Setters O "asignadores": permiten cambiar los atributos private desde afuera de la clase)
    public final void setNombre(String nombre) {
        // Validamos que el nombre no sea null ni vacio
        if (nombre == null || nombre.isBlank()) {
            // Lanzamos una excepcion porque el nombre no puede estar vacio
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        // Si el nombre es valido, lo guardamos en el atributo
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
