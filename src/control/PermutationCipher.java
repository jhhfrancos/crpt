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
public class PermutationCipher extends Cryptosystem{
    int[] key;
    int[] inverseKey;

    PermutationCipher(String text, boolean ciph, int[] key) {
        if (ciph) {
            plainText = text;
            cipherText = "";
        } else {
            cipherText = text;
            plainText = "";
        }
        this.key = key;
    }
    @Override
    public String cipher() {
        if(!validateKey()) return "-1";
        char[] cPlainText = plainText.toCharArray();
        char[] cCipherText = new char[plainText.length()];
        char[] cTemp = new char[key.length-1];
        int k = 0;
        for(int i = 0; i < cPlainText.length; i=i+(key.length-1)){
            for(int j = 0; j < (key.length-1) ; j++){
                cTemp[j] = cPlainText[i+j];
            }
            cTemp = permutar(cTemp, key);
            int y = 0;
            for(int x = k; y < cTemp.length; x++){
                cCipherText[x] = cTemp[y];
                y++;
                k++;
            }
        }
        cipherText = new String(cCipherText);
        return cipherText;
    }
    
    @Override
    public String decipher(){
        if(!validateKey()) return "-1";
        invKey();
        char[] cCipherText = cipherText.toCharArray();
        char[] cPlainText = new char[cipherText.length()];
        char[] cTemp = new char[inverseKey.length-1];
        int k = 0;
        for(int i = 0; i < cCipherText.length; i=i+(inverseKey.length-1)){
            for(int j = 0; j < (inverseKey.length-1) ; j++){
                cTemp[j] = cCipherText[i+j];
            }
            cTemp = permutar(cTemp, inverseKey);
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
        inverseKey = new int[key.length];
        int value;
        for(int i = 1; i<key.length; i++){
            value = key[i];
            inverseKey[value] = i;
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
        if(!plainText.isEmpty())
            if((plainText.length() % (key.length - 1)) != 0) return false;
        if(!cipherText.isEmpty())
            if((cipherText.length() % (key.length - 1)) != 0) return false;
        for(int i = 1; i<key.length; i++){
            for(int j = i+1; j < key.length; j++)
                if(i == j) return false;
            if(i > key.length - 1 || i <= 0) return false;
        }
        return true;
    }
}
