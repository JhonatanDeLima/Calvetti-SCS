public class Teste {
    public static void main(String[] args) throws Exception {
        String textoOriginal = "Mensagem secreta para o Professor Calvetti";
        
        //Teste chave simétrica
        ChaveSimetrica aes = new ChaveSimetrica();
        String textoCriptografadoAES = aes.encrypt(textoOriginal);
        String textoDescriptografadoAES = aes.decrypt(textoCriptografadoAES);

        System.out.println("AES (Simétrica)");
        System.out.println("Texto Criptografado: " + textoCriptografadoAES);
        System.out.println("Texto Descriptografado: " + textoDescriptografadoAES);

        //Teste chave assimétrica
        ChaveAssimetrica rsa = new ChaveAssimetrica();
        String textoCriptografadoRSA = rsa.encrypt(textoOriginal);
        String textoDescriptografadoRSA = rsa.decrypt(textoCriptografadoRSA);

        System.out.println("\nRSA (Assimétrica)");
        System.out.println("Texto Criptografado: " + textoCriptografadoRSA);
        System.out.println("Texto Descriptografado: " + textoDescriptografadoRSA);

        //Teste hash
        String hash = Hash.generateHash(textoOriginal);
        System.out.println("\nHASH (SHA-256)");
        System.out.println("Texto Original: " + textoOriginal);
        System.out.println("Hash gerado:    " + hash);
    }
}
