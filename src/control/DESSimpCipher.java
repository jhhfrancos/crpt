/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.util.Arrays;
import org.omg.CORBA.INTERNAL;

/**
 *
 * @author Jhh
 */
public class DESSimpCipher extends Cryptosystem{
    byte[][] by = {{11,000,001,010,011,100,101,110,111},{0,1}};
    int[][] S1 = {{2222,000,001,010,011,100,101,110,111},{0,101,010,001,110,011,100,111,000},{1,001,100,110,010,000,111,101,011}};
    int[][] S2 = {{2222,000,001,010,011,100,101,110,111},{0,100,000,110,101,111,001,011,010},{1,101,011,000,111,110,010,001,100}};
    int[] key = new int[9];
    int[][] keys = new int[9][9];

    
    public DESSimpCipher(String text, boolean ciph, String key){
        if (ciph) {
            plainText = text;
            cipherText = "";
        } else {
            cipherText = text;
            plainText = "";
        }
        int[] tempKey = stringtoBinary(key);
        
        int k = tempKey.length-1;
        for(int i = 8; i >= 0; i--){
            this.key[i] = (k>=0)? tempKey[k]:0;
            k--;
        }
        
    }
    @Override
    public String cipher() {
        if(!validateKey()) return "-1";
        generateKeys();
        return Arrays.toString(key);
    }

    @Override
    public String decipher() {
        if(!validateKey()) return "-1";
        invKey();
        char[] cCipherText = cipherText.toCharArray();
        char[] cPlainText = new char[cipherText.length()];
        char[] cTemp = new char[key.length-1];
        int k = 0;
        for(int i = 0; i < cCipherText.length; i=i+(key.length-1)){
            for(int j = 0; j < (key.length-1) ; j++){
                cTemp[j] = cCipherText[i+j];
            }
            cTemp = permutar(cTemp, key);
            int y = 0;
            for(int x = k; y < cTemp.length; x++){
                cPlainText[x] = cTemp[y];
                y++;
                k++;
            }
        }
        plainText = new String(cPlainText);
        return plainText;
    }
public void invKey(){
        int value;
        for(int i = 1; i<key.length; i++){
            value = key[i];
        }
    }
    public char[] permutar(char[] cadena, int[] key){
        char[] cTemp = new char[cadena.length];
        for(int i = 0; i <(key.length-1) ; i++){
            cTemp[i] = cadena[key[i+1]-1]; 
        }
        return cTemp;
    }
    
    @Override
    public boolean validateKey() {
        for(int i = 0; i < key.length; i++){
            if(key[i] != 0 && key[i] != 1)
                return false;
        }
        return true;
    }

    private void generateKeys() {
        
    }
    
}
