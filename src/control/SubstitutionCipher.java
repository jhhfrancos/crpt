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
public class SubstitutionCipher extends Cryptosystem{
    private char[][] diccionary;
    
    public SubstitutionCipher(String text, char[][] diccionary, boolean ciph){
        if (ciph) plainText = new String(text);
        else cipherText = new String(text);
        this.diccionary = diccionary;
    }
    
    @Override
    public String cipher() {
        int[] textC = toNumbers(plainText);
        for(int i=0; i<textC.length;i++){
            textC[i] = diccionary[textC[i]-97][0];
        }
        cipherText = intToString(textC);
        return cipherText;
    }

    @Override
    public String decipher() {
        char[] textC = cipherText.toCharArray();
        for(int i=0; i<textC.length;i++){
            for(int j=0; j<26;j++)
                if (diccionary[j][0] == textC[i]){
                    textC[i] = diccionary[j][1];
                    break;
                }
        }
        plainText = new String(textC);
        return plainText;
    }

    @Override
    public boolean validateKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
