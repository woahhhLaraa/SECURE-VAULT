package vault;

public interface Cifrable {
    String cifrar(String textoPlano, String claveMaestra);
    String descifrar(String textoCifradoBase64, String claveMaestra);
}
