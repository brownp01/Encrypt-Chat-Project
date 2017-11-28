package sample;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.*;
import javax.crypto.*;
import java.util.Scanner;

import java.util.Base64;

//
// Public Key cryptography using the RSA algorithm.
public class Encrypt {

     Cipher cipher; //cipher object
     byte[] cipherText; //encrypted message stored in byte format

    public Encrypt(){}

    // function to encrypt a message
    // pass KeyPair to encrypt with and message to encrypt
    // return encrypted message in byte format
    public byte[] encrypt(String message, KeyPair pk) throws Exception{


        byte[] plainText = message.getBytes("UTF8");
        cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, pk.getPublic());
        cipherText = cipher.doFinal(plainText);

        return cipherText;
    }

    // function to decrypt a message
    // pass KeyPair to decrypt with and message in byte format to decrypt
    // return decrypted message as a string
    public String decrypt(byte[] message, KeyPair pk) throws Exception{

        cipher.init(Cipher.DECRYPT_MODE, pk.getPrivate());
        byte[] newPlainText = cipher.doFinal(message);  //Here is where encrypted message is required in byte format for Cipher

        return new String(newPlainText, "UTF8");
    }


    // function to decrypt a message with public keys (FOR FAIL DECRYPTION EXAMPLE)
    // pass KeyPair to decrypt with and message in byte format to decrypt
    // return decrypted message as a string
    public String decrypt_pub(byte[] message, KeyPair pk) throws Exception{

        cipher.init(Cipher.ENCRYPT_MODE, pk.getPublic());
        byte[] newPlainText = cipher.doFinal(message);  //Here is where encrypted message is required in byte format for Cipher

        return new String(newPlainText, "UTF8");
    }

    // generate keypair
    // returns new key pair
    public KeyPair generateRSA() throws Exception{

        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        KeyPair key = keyGen.generateKeyPair();

        return key;
    }

    // get public key from a KeyPair object
    // return public key encoded as string
    public String publicToString(KeyPair keypair){

        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(keypair.getPublic().getEncoded());
    }

    // get private key from a KeyPair object
    // return private key encoded as string
    public String privateToString(KeyPair keypair){

        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(keypair.getPrivate().getEncoded());
    }
}
