package vault;

// Credencial ES UN Secreto (hereda todo de Secreto) y agrega usuario y servicio.
// Ejemplo: servicio = "Gmail", usuario = "lara123", contenido = la contraseña.
public class Credencial extends Secreto {

    private String usuario;
    private String servicio;

    public Credencial(String id, String nombre, String hashNombre, String contenidoCifrado,
                      String usuario, String servicio) {
        // super(...) llama al constructor de Secreto
        super(id, nombre, hashNombre, contenidoCifrado);
        setUsuario(usuario);
        setServicio(servicio);
    }

    public String getUsuario() {
        return usuario;
    }

    public String getServicio() {
        return servicio;
    }

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

    // @Override: estamos escribiendo el metodo abstracto que pidio Secreto
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
