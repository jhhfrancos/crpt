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
public class Cryptos {
    private int algoritmo;
    private boolean ciph;
    private String text;
    private int keyShift;
    private int[] keyAffine;
    private char[][] keySubstitution;
    private String keyVigenere;
    public Cryptosystem cSystem;
    
    
    public Cryptos(int algoritmo, String text, boolean ciph){
        this.algoritmo = algoritmo;
        this.text = text;
        this.ciph = ciph;
        createCryptoSystem();
    }
    
    public Cryptos(int algoritmo, String text, boolean ciph, int keyShift){
        this.algoritmo = algoritmo;
        this.text = text;
        this.ciph = ciph;
        this.keyShift = keyShift;
        createCryptoSystem();
    }
    public Cryptos(int algoritmo, String text, boolean ciph, int[] keyAffine){
        this.algoritmo = algoritmo;
        this.text = text;
        this.ciph = ciph;
        this.keyAffine = keyAffine;
        createCryptoSystem();
    }
    public Cryptos(int algoritmo, String text, boolean ciph, char[][] keySubstitution){
        this.algoritmo = algoritmo;
        this.text = text;
        this.ciph = ciph;
        this.keySubstitution = keySubstitution;
        createCryptoSystem();
    }
    public Cryptos(int algoritmo, String text, boolean ciph, String keyVigenere){
        this.algoritmo = algoritmo;
        this.text = text;
        this.ciph = ciph;
        this.keyVigenere = keyVigenere;
        createCryptoSystem();
    }

    private void createCryptoSystem() {
        switch (algoritmo){
            case 0:
                cSystem = new ShiftCipher(text, ciph, keyShift);
                break;
            case 1:
                cSystem = new SubstitutionCipher(text, keySubstitution, ciph);
                break;
            case 2:
                cSystem = new AffineCipher(text, ciph, keyAffine);
                break;
            case 3:
                cSystem = new VigenereCipher(text, ciph, keyVigenere);
                break;
            case 5:
                cSystem = new PermutationCipher(text, ciph, keyAffine);
                break;
            case 6:
                cSystem = new DESSimpCipher(text, ciph, keyVigenere);
                break;
            case 7:
                cSystem = new DESCipher(text, ciph, keyVigenere);
                break;
            case 8:
                cSystem = new AESCipher(text, ciph, keyVigenere);
                break;
        }
    }
    
}
