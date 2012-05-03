package salutem.Utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Encrypter {

    private static final String METODO_ENCRIPTACAO = "AES";
    public static final byte[] CHAVE = {75, 4, 4, -23, 68, 88, 46, 37, 45, 48, 10, -1, -37, -45, 70, -16};

    public static String encrypt(String value) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(Encrypter.CHAVE, METODO_ENCRIPTACAO);

        Cipher cipher = Cipher.getInstance(METODO_ENCRIPTACAO);
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(value.getBytes());

        return new BASE64Encoder().encode(encrypted);
    }

    public static String decrypt(String encrypted) throws Exception {
        byte[] decrypted = null;

        SecretKeySpec skeySpec = new SecretKeySpec(Encrypter.CHAVE, METODO_ENCRIPTACAO);

        byte[] decoded = new BASE64Decoder().decodeBuffer(encrypted);

        Cipher cipher = Cipher.getInstance(METODO_ENCRIPTACAO);
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        decrypted = cipher.doFinal(decoded);

        return new String(decrypted);
    }
}
