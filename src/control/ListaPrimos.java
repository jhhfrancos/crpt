package control;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/**
 *
 * @author Jhh
 */
public class ListaPrimos extends Thread{
    
    int inicio, fin;
    BigInteger cuatro = new BigInteger("4");
    BigInteger tres = new BigInteger("3");
    BigInteger dos = new BigInteger("2");
    BigInteger uno = new BigInteger("1");
    
    public ListaPrimos(int inicio, int fin){
        
        this.inicio = inicio;
        this.fin = fin;
    }
    public void run(){
        int i = inicio; int k = 1;
        BigInteger iBig = new BigInteger(""+i);
        boolean j = true;
        while(j){
            if(restrictions(iBig)){
                BigInteger N = a(i);
                PollardRho pollardRho = new PollardRho(N);
                System.out.println((k+(inicio-1)) +") "+"n = " + i + " a(n) = " + N + " factores " + Arrays.toString(pollardRho.getFactors().toArray()));
                if(k == fin) j = false;
                k++;
            }
            i++;
            iBig = iBig.add(uno);
        }
        System.out.println("listo el que inicio en " + inicio);
    }
    public BigInteger a(int n){
        //double result = evaluador.evaluate("2^(n-1) * (2^n + 1) - 3^n");
        BigInteger result = ((dos.pow(n-1)).multiply((dos.pow(n)).add(uno))).subtract(tres.pow(n));
        return result;
    }
    public boolean restrictions(BigInteger n){
        BigInteger result = n.mod(cuatro);
        return result.compareTo(dos) == 0;
    }
    public static void main(String[] args) {
        ListaPrimos listaPrimos1 = new ListaPrimos(1,250);
        ListaPrimos listaPrimos2 = new ListaPrimos(250,500);
        ListaPrimos listaPrimos3 = new ListaPrimos(500,750);
        ListaPrimos listaPrimos4 = new ListaPrimos(750,1000);
        listaPrimos1.start(); //run 4
        //listaPrimos2.start(); run 2
        //listaPrimos3.start(); run 3
        //listaPrimos4.start(); run
    }
}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*package control;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/**
 *
 * @author Jhh
 */
/*public class ListaPrimos {
    int iteraciones;
    
    MathEval evaluador;
    public ListaPrimos(int iteraciones){
        this.iteraciones = iteraciones;
        evaluador = new MathEval();
    }
    public void generateList(){
        double i = 1; int k = 1;
        
        boolean j = true;
        while(j){
            if(restrictions((int)i)){
                BigInteger N = a(i);
                PollardRho pollardRho = new PollardRho(N);
                System.out.println(k +") "+"n = " + i + " a(n) = " + N + " factores " + Arrays.toString(pollardRho.getFactors().toArray()));
                if(k == iteraciones) j = false;
                k++;
            }
            i++;
        }
    }
    public BigInteger a(double n){
        evaluador.setVariable("n", n);
        double result = evaluador.evaluate("2^(n-1) * (2^n + 1) - 3^n");
        BigInteger k = new BigDecimal(result).toBigInteger();
        return k;
    }
    public boolean restrictions(double n){
        evaluador.setVariable("n", n);
        double result = evaluador.evaluate("n % 4");
        return result == 2;
    }
    public static void main(String[] args) {
        ListaPrimos listaPrimos = new ListaPrimos(1000);
        listaPrimos.generateList();
    }
}*/
