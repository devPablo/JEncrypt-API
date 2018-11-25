package org.bonilla.manager;

import org.bonilla.crypto.AES;
import org.bonilla.crypto.MD5;
import org.bonilla.reader.DataReader;

import java.io.File;

/**
 * Class for encryption type management.
 *
 * @author  Pablo Bonilla G.
 * @version 1.0
 * @since   2018-11-24
 */

public class JEncryptManager {
    private int encryptionType;
    private DataReader dr = null;

    /**
     * Declares the encryption type and file.
     *
     * @param encryptionType Cryptographic algorithm that will be used.
     * @param file JSON file that contains the JEncrypt data.
     */
    public JEncryptManager(int encryptionType, File file) {
        this.encryptionType = encryptionType;
        this.dr = new DataReader(file);
    }

    /**
     *
     * @param encryptionType Cryptographic algorithm that will be used.
     */
    public JEncryptManager(int encryptionType) {
        this.encryptionType = encryptionType;
    }

    /**
     *
     * @return Object Encryption type initialized with or
     *         without values (depends on file value).
     */
    public Object getInstance() {
        if (encryptionType == JEncryptType.AES) {
            return (dr == null) ? new AES(this) : new AES(this, dr.getSecretKey("aes"), dr.getInitVector("aes"));
        }
        if (encryptionType == JEncryptType.MD5) {
            return (dr == null) ? new MD5(this) : new MD5(this, dr.getSalt("md5"));
        }
        return null;
    }
}
