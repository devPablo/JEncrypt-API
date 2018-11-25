package org.bonilla.crypto;

import org.bonilla.manager.JEncryptManager;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Message Digest 5 (MD5)
 * Implementation of the hash function.
 *
 * @author  Pablo Bonilla G.
 * @version 1.0
 * @since   2018-11-24
 */

public class MD5 {
    private JEncryptManager jem;
    private String message;
    private String salt;
    private String hash;

    public MD5(JEncryptManager jem, String salt) {
        this.jem = jem;
        this.salt = salt;
    }

    public MD5(JEncryptManager jem) {
        this.jem = jem;
    }

    public String encrypt(String message) {
        return encrypt(message, salt);
    }

    public String encrypt(String message, String salt) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        String combined = salt + message;
        byte[] hashInBytes = md.digest(combined.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }

    public boolean compareHash(String message, String hash) {
        return compareHash(message, salt, hash);
    }

    public boolean compareHash(String message, String salt, String hash) {
        String encrypted = encrypt(message, salt);
        return encrypted.equals(hash);
    }
}
