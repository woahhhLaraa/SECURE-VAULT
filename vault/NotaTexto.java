package vault;

// NotaTexto ES UN Secreto y agrega una categoria.
// Ejemplo: categoria = "Escuela", contenido = el texto de la nota.
public class NotaTexto extends Secreto {

    private String categoria;

    public NotaTexto(String id, String nombre, String hashNombre, String contenidoCifrado,
                     String categoria) {
        super(id, nombre, hashNombre, contenidoCifrado);
        setCategoria(categoria);
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria == null || categoria.isBlank()) {
            throw new IllegalArgumentException("La categoria no puede estar vacia");
        }
        this.categoria = categoria;
    }

    @Override
    public void mostrarDetalle(String contenidoPlano) {
        System.out.println("----- NOTA -----");
        System.out.println("ID:        " + getId());
        System.out.println("Nombre:    " + getNombre());
        System.out.println("Categoria: " + categoria);
        System.out.println("Nota:      " + contenidoPlano);
        System.out.println("----------------");
    }
}
