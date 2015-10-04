/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author JhhToshiba
 */
public class ShiftCipher extends Cryptosystem{
    public int key;
    public ShiftCipher(String text, boolean ciph, int key) {
        if (ciph) plainText = new String(text);
        else cipherText = new String(text);
        this.key = key;
    }
    @Override
    public String cipher() {
        int[] textI = toNumbers(plainText);
        for(int i=0; i<textI.length;i++){
            textI[i] = ((textI[i] - 97 + key) % 26) + 97;
        }
        cipherText = intToString(textI);
        return cipherText;
    }

    @Override
    public String decipher() {
        int[] textI = toNumbers(cipherText);
        for(int i=0; i<textI.length;i++){
            textI[i] = ((textI[i] - 97 - key) < 0) ? (((26 - (Math.abs((textI[i] - 97 - key)) % 26) ) %26)+97) : ((((textI[i] - 97 - key) % 26))+97);
        }
        plainText = intToString(textI);
        return plainText;
    }
    
    public String[] posibilities(){
        String[] posi = new String[26];
        int[] textI = toNumbers(cipherText);
        int[] textI2 = new int[textI.length];
        for (int _key = 0; _key<26;_key++){
            for(int i=0; i<textI.length;i++){
                textI2[i] = ((textI[i] - 97 - _key) < 0) ? (((26 - (Math.abs((textI[i] - 97 - _key)) % 26) ) %26)+97) : ((((textI[i] - 97 - _key) % 26))+97);
            }
            posi[_key] = intToString(textI2);
        }
        return posi;
    }

    @Override
    public boolean validateKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
