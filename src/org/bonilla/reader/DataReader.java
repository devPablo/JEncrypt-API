package org.bonilla.reader;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.*;

/**
 * Class for cryptography algorithm configuration &
 * data retrieval for usage in application.
 *
 * @author  Pablo Bonilla G.
 * @version 1.0
 * @since   2018-11-24
 */

public class DataReader {
    private static File JENCRYPT_DATA = new File("src/JEncryptData.json");
    private static JsonParser jsonParser = new JsonParser();

    public DataReader(File file) {
        JENCRYPT_DATA = file;
    }

    public DataReader() {}



    /**
     * Extracts the identifier's value from
     * the JSON file through a keyword.
     *
     * @param encryptionType Keyword representing the cryptographic algorithm's name.
     * @param identifier Keyword representing the identifier within the encryptionType.
     * @return Identifier's value.
     */
    private String getJEncryptorData(String encryptionType, String identifier) {
        JsonElement jsonData;
        Object obj;
        JsonObject jsonObj;
        String data = "";
        try {
            obj = jsonParser.parse(new FileReader(JENCRYPT_DATA));
            jsonObj = (JsonObject) obj;

            jsonObj = jsonObj.getAsJsonObject(encryptionType);
            jsonData = jsonObj.get(identifier);
            data = jsonData.getAsString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * @return Identifier value of "secretKey".
     */
    public String getSecretKey(String encryptionType) {
        return getJEncryptorData(encryptionType, "secretKey");
    }

    /**
     * @return Identifier value of "initVector".
     */
    public String getInitVector(String encryptionType) {
        return getJEncryptorData(encryptionType, "initVector");
    }

    /**
     * @return Identifier value of "salt".
     */
    public String getSalt(String encryptionType) {
        return getJEncryptorData(encryptionType, "salt");
    }
}