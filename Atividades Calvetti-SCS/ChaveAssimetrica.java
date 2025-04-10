import java.security.*;
import javax.crypto.Cipher;
import java.util.Base64;

public class ChaveAssimetrica {
    private KeyPair keyPair;

    public ChaveAssimetrica() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048); // Tamanho da chave
        keyPair = generator.generateKeyPair();
    }

    public String encrypt(String plainText) throws Exception {
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        byte[] cipherText = encryptCipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(cipherText);
    }

    public String decrypt(String encryptedText) throws Exception {
        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        byte[] decryptedBytes = decryptCipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes);
    }
}
