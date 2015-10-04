/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

/**
 *
 * @author Jhh
 */
public class VigenereCipher extends Cryptosystem{
    private String key;
    
    public VigenereCipher(String text, boolean ciph, String key){
        if (ciph) plainText = new String(text);
        else cipherText = new String(text);
        this.key = key;
    }
    
    @Override
    public String cipher() {
        int[] textI = toNumbers(plainText);
        int[] keyI = toNumbers(key);
        for(int i=0; i<textI.length;i+=0){
            for(int j=0;j<keyI.length;j++){
                if(i>=textI.length) break;
                textI[i] = ((textI[i] - 97 + (keyI[j] - 97)) % 26) + 97;
                i++;
            }
        }
        cipherText = intToString(textI);
        return cipherText;
    }

    @Override
    public String decipher() {
        int[] textI = toNumbers(cipherText);
        int[] keyI = toNumbers(key);
        for(int i=0; i<textI.length;i+=0){
            for(int j=0;j<keyI.length;j++){
                if(i>=textI.length) break;
                textI[i] = ((textI[i] - 97 - (keyI[j] - 97)) < 0) ? (((26 - (Math.abs((textI[i] - 97 - (keyI[j] - 97))) % 26) ) %26)+97) : ((((textI[i] - 97 - (keyI[j] - 97)) % 26))+97);
                i++;
            }
        }
        plainText = intToString(textI);
        return plainText;
    }

    @Override
    public boolean validateKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
