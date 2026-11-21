package vault;

// Credencial ES UN Secreto (hereda todo de Secreto) y agrega usuario y servicio.
// Ejemplo: servicio = "Gmail", usuario = "lara123", contenido = la contraseña.
public class Credencial extends Secreto {

    // Atributos private: solo esta clase los puede tocar directamente
    private String usuario;
    private String servicio;

    // Constructor: lo usan las clases hijas con super([parametros extras])
    public Credencial(String id, String nombre, String hashNombre, String contenidoCifrado,
                      String usuario, String servicio) {
        // super sirve para llamar al constructor de la clase padre (Secreto) y pasarle los parametros que necesita
        super(id, nombre, hashNombre, contenidoCifrado);
        setUsuario(usuario);
        setServicio(servicio);
    }

    // Getters o "obtenedores": permiten leer los atributos private desde afuera de la clases
    public String getUsuario() {
        return usuario;
    }

    public String getServicio() {
        return servicio;
    }

    // Setters O "asignadores": permiten cambiar los atributos private desde afuera de la clase)
    public void setUsuario(String usuario) {
        if (usuario == null || usuario.isBlank()) {
            throw new IllegalArgumentException("El usuario no puede estar vacio");
        }
        this.usuario = usuario;
    }

    public void setServicio(String servicio) {
        if (servicio == null || servicio.isBlank()) {
            throw new IllegalArgumentException("El servicio no puede estar vacio");
        }
        this.servicio = servicio;
    }

    // @Override indica que este metodo reemplaza al metodo mostrarDetalle de la clase padre (Secreto)
    @Override
    public void mostrarDetalle(String contenidoPlano) {
        System.out.println("----- CREDENCIAL -----");
        System.out.println("ID:         " + getId());
        System.out.println("Nombre:     " + getNombre());
        System.out.println("Servicio:   " + servicio);
        System.out.println("Usuario:    " + usuario);
        System.out.println("Contrasena: " + contenidoPlano);
        System.out.println("----------------------");
    }
}
