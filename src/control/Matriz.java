/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
/**
 *
 * @author paxx, Jhh
 */

public class Matriz {
    static BufferedReader entrada =new BufferedReader(new InputStreamReader(System.in));        
    public static int opc, fila, colum, fila2, colum2;
    public static double [][] m1;
    public static double [][] m2;
    
    public Matriz(double[][] m1, double[][] m2){
        this.m1 = m1;
        this.m2 = m2;
        this.fila = m1.length;
        this.fila2 = m2.length;
        this.colum = m1.length;
        this.colum2 = m2.length;
    }
    public void print(){
        System.out.println(fila + " " + colum + " " + fila2 +" "+ colum2 );
    }
    public void sumar() throws IOException {
        if(fila==fila2 && colum==colum2)
        {        
        for( int x=0;x<fila;x++)
        {
            for( int y=0;y<colum;y++)
            {
                System.out.print((m1[x][y])+(m2[x][y])+" , ");                
            }   
            System.out.print(" \n");
        }
 
        }else{
            System.out.print("no se pude sumar las matrices " );
        }
    }
 
    public void restar() {
        if(fila==fila2 && colum==colum2)
        {        
        for( int x=0;x<fila;x++)
        {
            for( int y=0;y<colum;y++)
            {
                System.out.print((m1[x][y])-(m2[x][y])+" , ");                
            }   
            System.out.print(" \n");
        }        
        }else{
            System.out.print("no se pude restar las matrices " );
        }
    }
 
    public void restar2() {
        if(fila==fila2 && colum==colum2)
        {        
        for( int x=0;x<fila;x++)
        {
            for( int y=0;y<colum;y++)
            {
                System.out.print((m2[x][y])-(m1[x][y])+" , ");                
            }   
            System.out.print(" \n");
        }        
        }else{
            System.out.print("no se pude sumar las matrices " );
        }
    }
 
    public double[][] multi() throws IOException {
        double [][] mult = new double[fila][colum];
        if(colum==fila2)
        {        
            double [][] r1=new double[fila][colum2];
            for(int x=0;x<fila;x++)
            {
                for(int y=0;y<colum2;y++)
                {
                    for(int m=0;m<colum;m++)
                    {
                        r1[x][y]+=m1[x][m]*m2[m][y];
                    }
                    mult[x][y] = r1[x][y];                
                }
            }                
        }else{
            System.out.print("No se puede multiplicar matrices");
        }
        return mult;
    }
 
    public void multi2() throws IOException {
        if(colum2==fila)
        {        
            double [][] r1=new double[fila2][colum];
            for(int x=0;x<fila2;x++)
            {
                for(int y=0;y<colum;y++)
                {
                    for(int m=0;m<colum2;m++)
                    {
                        r1[x][y]+=m2[x][m]*m1[m][y];
                    }
                    System.out.print(r1[x][y]+" , ");                
                }
                System.out.print(" \n");
            }                
        }else{
            System.out.print("No se puede multiplicar matrices");
            String a=entrada.readLine();
        }
    }
 
    public double deta() throws IOException {
        double det = 0;
        if(fila==colum){            
            det = determinante(m1);
        }else{
            System.out.print("La Matriz no tiene determinante");
        }
        return det;
    }
    
    public double detb() throws IOException {
        double det = 0;
        if(fila2==colum2){            
            det = determinante(m2); 
        }else{
            System.out.print("La Matriz no tiene determinante");
        }
        return det;
    }
 
    public double determinante(double[][] matriz){
        double det;
        if(matriz.length==2){
            det=(matriz[0][0]*matriz[1][1])-(matriz[1][0]*matriz[0][1]);
            return det;
        }
        double suma=0;
        for(int i=0; i<matriz.length; i++){
        double[][] nm=new double[matriz.length-1][matriz.length-1];
            for(int j=0; j<matriz.length; j++){
                if(j!=i){
                    for(int k=1; k<matriz.length; k++){
                    int indice=-1;
                    if(j<i)
                    indice=j;
                    else if(j>i)
                    indice=j-1;
                    nm[indice][k-1]=matriz[j][k];
                    }
                }
            }
            if(i%2==0)
            suma+=matriz[i][0] * determinante(nm);
            else
            suma-=matriz[i][0] * determinante(nm);
        }
        return suma;
    }
 
    
 
    public void traa() throws IOException {                
        System.out.print("La matriz original");
        System.out.print("\n");
        for(int x=0;x<fila;x++)
        {
            for(int y=0;y<colum;y++)
            {
                System.out.print(m1[x][y]+ " , ");     
            }   
            System.out.print("\n");
        }
        System.out.print("nn");
        System.out.print("La matriz transpuesta");
        System.out.print("\n");
        for(int x=0;x<colum;x++)
        {
            for(int y=0;y<fila;y++)
            {
                System.out.print(m1[y][x]+ " , ");     
            }   
            System.out.print("\n");
        }        
        String a=entrada.readLine();
    }
 
    public void trab() throws IOException {
        System.out.print("La matriz original");
        System.out.print("\n");
        for(int x=0;x<fila2;x++)
        {
            for(int y=0;y<colum2;y++)
            {
                System.out.print(m2[x][y]+ " , ");     
            }   
            System.out.print("\n");
        }
        System.out.print("nn");
        System.out.print("La matriz transpuesta");
        System.out.print("\n");
        for(int x=0;x<colum2;x++)
        {
            for(int y=0;y<fila2;y++)
            {
                System.out.print(m2[y][x]+ " , ");     
            }   
            System.out.print("\n");
        }        
        String a=entrada.readLine();
    }
 
    public double[][] inva() throws IOException {        
        double[][] res = new double[][] {{-1,-1},{-1,-1}};
        if(fila==colum && determinante(m1)!=0){
            res = matrizInversa(m1);
        }else{
            System.out.println("no tiene inversa");
        }
        return res;
    }
 
    public double[][] invb() throws IOException {
        double[][] res = null;
        if(fila2==colum2 && determinante(m1)!=0){
            res = matrizInversa(m2);
        }else{
            System.out.println("La matriz no tiene inversa");
        }
        return res;
    }
 
    public double[][] matrizInversa(double[][] matriz) {
        double det=1/determinante(matriz);
        double[][] nmatriz=matrizAdjunta(matriz);
        multiplicarMatriz(det,nmatriz);
        return nmatriz;
    }
 
    public void multiplicarMatriz(double n, double[][] matriz) {
        for(int i=0;i<matriz.length;i++)
        for(int j=0;j<matriz.length;j++)
        matriz[i][j]*=n;
    }
 
    public double[][] matrizAdjunta(double [][] matriz){
        return matrizTranspuesta(matrizCofactores(matriz));
    }
 
    public double[][] matrizCofactores(double[][] matriz){
        double[][] nm=new double[matriz.length][matriz.length];
        for(int i=0;i<matriz.length;i++) {
            for(int j=0;j<matriz.length;j++) {
                double[][] det=new double[matriz.length-1][matriz.length-1];        
                double detValor;
                for(int k=0;k<matriz.length;k++) {
                    if(k!=i) {
                        for(int l=0;l<matriz.length;l++) {
                            if(l!=j) {
                            int indice1=k<i ? k : k-1 ;
                            int indice2=l<j ? l : l-1 ;
                            det[indice1][indice2]=matriz[k][l];
                            }
                        }
                    }
                }
                //detValor=determinante(det);
                detValor=(det.length==1)? det[0][0]: determinante(det);
                nm[i][j]=detValor * (double)Math.pow(-1, i+j+2);
            }
        }
        return nm;
    }
 
    public double[][] matrizTranspuesta(double [][] matriz){
        double[][]nuevam=new double[matriz[0].length][matriz.length];
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz.length; j++)
                nuevam[i][j]=matriz[j][i];
        }
        return nuevam;
    }
    public static void main(String[] args) throws IOException {
        double[][] m1 = new double[][] {{11,8},{3,7}};
        double[][] m2 = new double[][] {{11,0},{15,0}};
        Matriz matriz = new Matriz(m1,m2);
        //System.out.println(Arrays.toString(matriz.multi()[0]));
        //System.out.println(Arrays.toString(matriz.multi()[1]));
        System.out.println(Arrays.toString(matriz.inva()[0]));
        System.out.println(Arrays.toString(matriz.inva()[1]));
       // System.out.println(Arrays.toString(matriz.inva()[2]));
    }
}