/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author QQ
 */
public final class CryptographyDemo {

    Cipher cipher;
    SecretKey key;

    public CryptographyDemo() {
        generateKey();
    }

    public void generateKey() {
        try {
            //Generate the secret key
            KeyGenerator generator = KeyGenerator.getInstance("DES");
            key = generator.generateKey();
            //Initialize the cipher instance to use DES algorithm, ECB mode
            //and PKCS5 padding scheme
            cipher = Cipher.getInstance("DES/ECB/PKCS5Padding"); 

        } catch (NoSuchAlgorithmException ex) {

        } catch (NoSuchPaddingException ex) {

        }
    }

    public byte[] doEncryption(String content) throws Exception {

        cipher.init(Cipher.ENCRYPT_MODE, key);          //Initialize the cipher with secret key
        byte[] test = content.getBytes();               //Read the data into byte array
        byte[] encryptedData = cipher.doFinal(test);    //Store encrypted data in a byte
        return encryptedData;

    }

    public String doDecryption(byte[] content) throws Exception {
        String result;
        cipher = Cipher.getInstance("DES"); //Initialize use des algorithm
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedText = cipher.doFinal(content);
        result = new String(decryptedText);
        return result;
    }

    public static void main(String[] args) throws Exception{
        String content;
        byte[] encryptedContent;
        CryptographyDemo demo = new CryptographyDemo();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter content: ");
        content = sc.nextLine();
        encryptedContent = demo.doEncryption(content);
        System.out.println("Encrypted Content: "+encryptedContent.toString());
        content = demo.doDecryption(encryptedContent);
        System.out.println("Decrypted Content: "+content);
    }
}
