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
public class AffineCipher extends Cryptosystem{
    private int[][] inverse = new int[][] {{1,1},{3,9},{5,21},{7,15},{11,19},{17,23},{25,25},
        {9,3},{21,5},{15,7},{19,11},{23,17}};
    public int[] key;
    
    public AffineCipher(String text, boolean ciph, int[] key){
        if (ciph) plainText = new String(text);
        else cipherText = new String(text);
        this.key = key;
    }
    @Override
    public String cipher() {
        int[] textI = toNumbers(plainText);
        int inverseA = findInverse(key[0]);
        if(inverseA==-1) return "nInverse";
        for(int i=0; i<textI.length;i++){
            textI[i] = (((((textI[i] - 97) * key[0])) + key[1])  % 26) + 97;
        }
        cipherText = intToString(textI);
        return cipherText;
    }

    @Override
    public String decipher() {
        int[] textI = toNumbers(cipherText);
        int inverseA = findInverse(key[0]);
        if(inverseA==-1) return "nInverse";
        for(int i=0; i<textI.length;i++){
            textI[i] = ((textI[i] - 97 - key[1]) < 0) ? (((26 - (((Math.abs((textI[i] - 97 - key[1])))*inverseA) % 26)) %26)+97) : (((((textI[i] - 97 - key[1])*inverseA) % 26))+97);
        }
        plainText = intToString(textI);
        return plainText;
    }

    @Override
    public boolean validateKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int findInverse(int i) {
        int inv = -1;
        for(int j=0; j<12;j++){
            if(inverse[j][0]==i)
                inv = inverse[j][1];
        }
        return inv;
    }
    
}
