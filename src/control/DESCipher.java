/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import gui.DialogError;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
/**
 *
 * @author Jhh
 */
public class DESCipher extends Cryptosystem{
    Cipher ecipher;

    Cipher dcipher;
    
    DESCipher(String text, boolean ciph, String key){
        this(text,ciph,stringToSecretKey(key));
    }
    
    DESCipher(String text, boolean ciph, SecretKey key) {
        try {
            if (ciph) plainText = new String(text);
            else cipherText = new String(text);
            ecipher = Cipher.getInstance("DES");
            dcipher = Cipher.getInstance("DES");
            ecipher.init(Cipher.ENCRYPT_MODE, key);
            dcipher.init(Cipher.DECRYPT_MODE, key);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(DESCipher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(DESCipher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(DESCipher.class.getName()).log(Level.SEVERE, null, ex);
        }
  }

    @Override
    public String cipher() {
        try {
            byte[] utf8 = plainText.getBytes("UTF8");
            byte[] enc = ecipher.doFinal(utf8);
            return new sun.misc.BASE64Encoder().encode(enc);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DESCipher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(DESCipher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(DESCipher.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    @Override
    public String decipher() {
        try {
            byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(cipherText);
            byte[] utf8 = dcipher.doFinal(dec);
            return new String(utf8, "UTF8");
        } catch (IOException ex) {
            DialogError dialogError = new DialogError(new javax.swing.JFrame(), true, "Error en la Clave");
            dialogError.setVisible(true);
        } catch (IllegalBlockSizeException ex) {
            DialogError dialogError = new DialogError(new javax.swing.JFrame(), true, "Error en la Clave");
            dialogError.setVisible(true);
        } catch (BadPaddingException ex) {
            DialogError dialogError = new DialogError(new javax.swing.JFrame(), true, "Error en la Clave");
            dialogError.setVisible(true);
        }
        return "";
    }
    public static String secretKeyToString(SecretKey key){
        String stringKey = Base64.encode(key.getEncoded());
        return stringKey;
    }
    public static SecretKey stringToSecretKey(String key){
        byte[] encodedKey     = Base64.decode(key);
        SecretKey originalKey = new SecretKeySpec(encodedKey, 0, encodedKey.length, "DES");
        return originalKey;
    }
    @Override
    public boolean validateKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] argv) throws Exception {
        SecretKey key = KeyGenerator.getInstance("DES").generateKey();
        DESCipher encrypter = new DESCipher("at at mid",true,key);
        String encrypted = encrypter.cipher();
        encrypter = new DESCipher(encrypted,false,key);
        String decrypted = encrypter.decipher();
        System.out.println(encrypted + "\n" + decrypted + "\n" + encrypter.secretKeyToString(key) + "\n" + encrypter.secretKeyToString(encrypter.stringToSecretKey(encrypter.secretKeyToString(key))));
    }
}