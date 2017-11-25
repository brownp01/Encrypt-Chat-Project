package sample;
import java.security.*;
import javax.crypto.*;
import java.util.Scanner;

//
// Public Key cryptography using the RSA algorithm.
public class Encrypt {

     String publickey;
     String privatekey;

    public Encrypt(){

    }

    public void generateRSA() throws Exception{
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        KeyPair key = keyGen.generateKeyPair();
        publickey = new String(key.getPublic().getEncoded());
        privatekey = new String(key.getPrivate().getEncoded());


    }

    public void message(String input) throws Exception {


        byte[] plainText = input.getBytes("UTF8");
        //
        // generate an RSA key
        System.out.println("\nStart generating RSA key");
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        KeyPair key = keyGen.generateKeyPair();
        System.out.println("Finish generating RSA key");
        //
        // get an RSA cipher object and print the provider
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        System.out.println("\n" + cipher.getProvider().getInfo());
        //
        // encrypt the plaintext using the public key
        System.out.println("\nStart encryption");
        cipher.init(Cipher.ENCRYPT_MODE, key.getPublic());
        byte[] cipherText = cipher.doFinal(plainText);
        System.out.println("Finish encryption: ");
        System.out.println(new String(cipherText, "UTF8"));
        //
        // decrypt the ciphertext using the private key
        System.out.println("\nStart decryption");
        cipher.init(Cipher.DECRYPT_MODE, key.getPrivate());
        byte[] newPlainText = cipher.doFinal(cipherText);
        System.out.println("Finish decryption: ");
        System.out.println(new String(newPlainText, "UTF8"));
    }
}
