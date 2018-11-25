package org.bonilla.manager;

/**
 * Includes all cryptographic algorithms as int values.
 *
 * @author  Pablo Bonilla G.
 * @version 1.0
 * @since   2018-11-24
 */

public final class JEncryptType {
    public static final int AES = 0;
    public static final int MD5 = 1;

    private JEncryptType() {
        throw new UnsupportedOperationException();
    }
}
