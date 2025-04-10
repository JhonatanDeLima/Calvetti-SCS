import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Hash {
    public static String generateHash(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256"); 
        byte[] hashBytes = digest.digest(input.getBytes());
        return Base64.getEncoder().encodeToString(hashBytes);
    }
}
