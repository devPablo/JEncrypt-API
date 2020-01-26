package org.bonilla.crypto;

import org.bonilla.manager.JEncryptManager;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * Advanced Encryption Standard (AES)
 * Implementation of the symmetric block cipher.
 *
 * @author  Pablo Bonilla G.
 * @version 1.0
 * @since   2018-11-24
 */

public class AES {
    private JEncryptManager jem;
    private String message;
    private String key;
    private String initVector;

    public AES(JEncryptManager jem, String key, String initVector) {
        this.jem = jem;
        this.key = key;
        this.initVector = initVector;
    }

    public AES(JEncryptManager jem) {
        this.jem = jem;
    }

    public String encrypt(String message) {
        return encrypt(message, key, initVector);
    }

    public String encrypt(String message, String key, String initVector) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            System.out.println("Hola");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(message.getBytes());

            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public String decrypt(String encrypted) {
        return decrypt(encrypted, key, initVector);
    }

    public String decrypt(String encrypted, String key, String initVector) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}