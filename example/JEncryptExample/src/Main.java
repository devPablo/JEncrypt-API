import org.bonilla.crypto.AES;
import org.bonilla.manager.JEncryptManager;
import org.bonilla.manager.JEncryptType;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        // JEncryptorData & Message
            File data = new File("src/JEncryptData.json");
            String message = "JEncrypt by Pablo";



        // AES
            // with file
                JEncryptManager jem = new JEncryptManager(JEncryptType.AES, data);
                AES crypto = (AES) jem.getInstance();
                String encrypted = crypto.encrypt(message);

            // no file
                // JEncryptManager jem = new JEncryptManager(JEncryptType.AES);
                // AES crypto = (AES) jem.getInstance();
                // String secretKey = "770A8A65DA156D24EE2A093277530142";
                // String initVector = "b34afd4a9d7fc1e9";
                // String encrypted = crypto.encrypt(message, secretKey, initVector);



        // MD5
            // with file
                // JEncryptManager jem = new JEncryptManager(JEncryptType.MD5, data);
                // MD5 crypto = (MD5) jem.getInstance();
                // String encrypted = crypto.encrypt(message);

            // no file
                // JEncryptManager jem = new JEncryptManager(JEncryptType.MD5);
                // MD5 crypto = (MD5) jem.getInstance();
                // String salt = "0fb09c95";
                // String encrypted = crypto.encrypt(message, salt);



        // Encrypted output
            System.out.println("Encrypted: " + encrypted);



        // AES output (with file)
            String decrypted = crypto.decrypt(encrypted);
            System.out.println("Decrypted: " + decrypted);

        // AES output (no file)
            // String decrypted = crypto.decrypt(encrypted, secretKey, initVector);
            // System.out.println("Decrypted: " + decrypted);



        // MD5 ouput (with file)
            // String hash = "eb4af72f1334abb33cddbdadf3d48295";
            // boolean isEqual = crypto.compareHash(message, hash);
            // System.out.println("Is hash equal: " + isEqual);

        // MD5 output (no file)
            // String hash = "eb4af72f1334abb33cddbdadf3d48295";
            // boolean isEqual = crypto.compareHash(message, salt, hash);
            // System.out.println("Is hashed message equal to hash: " + isEqual);
    }
}
