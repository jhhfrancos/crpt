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
public abstract class Cryptosystem {
    protected char[] alphabetZ26 = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t',
                                 'u','v','w','x','y','z'};
    protected String plainText;
    protected String cipherText;
    
    public int[] toNumbers(String text){
        char[] textC;
        int[] textI = new int[text.length()];
        text = text.replaceAll("\\s","");
        text = text.toLowerCase();
        textC = text.toCharArray().clone();
        for (int i = 0; i<textC.length; i++){
            textI[i] = (int)textC[i];
        }
        return textI;
    }
    public String intToString(int[] textI){
        char[] textC = new char[textI.length];
        for (int i = 0; i<textI.length; i++){
            textC[i] = (char)textI[i];
        }
        return new String(textC);
    }
    public int[] stringtoBinary(String text){
        int[] resultBin = new int[text.length()];
        for(int i = 0; i < resultBin.length; i++){
            resultBin[i] = Integer.parseInt(""+text.charAt(i));
        }
        return resultBin;
    }
    public abstract String cipher();
    public abstract String decipher();
    public abstract boolean validateKey();
}
