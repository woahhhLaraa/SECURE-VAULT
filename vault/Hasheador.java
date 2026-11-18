//Recibe un STRING, lo hashea (SHA-256) y lo devuelve en un STRING

package vault;
import java.security.MessageDigest;

public class Hasheador {
    
    public static String hasheador(String palabraClave) {
   try{
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        final byte[] hash = digest.digest(palabraClave.getBytes("UTF-8"));
        final StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            final String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) 
              hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    } catch(Exception ex){
       throw new RuntimeException(ex);
    }
}
    }


