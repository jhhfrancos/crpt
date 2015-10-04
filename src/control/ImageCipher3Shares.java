/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Jhh
 */
public class ImageCipher3Shares {
    BufferedImage imageOrig = null;
    BufferedImage imageOrig1 = null;
    BufferedImage image1 = null;
    BufferedImage image1Rotate = null;
    BufferedImage image2 = null;
    String pathRoot;
    File imageOrigFile;
    File imageOrig1File;
    File image1File;
    File image2File;
    
    
    public ImageCipher3Shares(String filePath,String filePath2, String pathRoot, boolean nothing){
        //initialImage = new File("imagenes/AAA.jpg");
        this.pathRoot = pathRoot;
        imageOrigFile = new File(filePath);
        imageOrig1File = new File(filePath2);
        try {
            imageOrig = ImageIO.read(imageOrigFile);
            imageOrig1 = ImageIO.read(imageOrig1File);
        } catch (Exception ex) {
            System.out.println("no se encontro la imagen " + ex);
        }
    }
    
    public ImageCipher3Shares(String filePath1, String filePath2, String pathRoot, int nothing){
        //initialImage = new File("imagenes/AAA.jpg");
        this.pathRoot = pathRoot;
        image1File = new File(filePath1);
        image2File = new File(filePath2);
        try {
            image1 = ImageIO.read(image1File);
            image2 = ImageIO.read(image2File);
        } catch (Exception ex) {
            System.out.println("no se encontro la imagen " + ex);
        }
    }
    public String getPathRoot(){
        return pathRoot;
    }

    public boolean cipher(){
        try {
            image1 = ImageIO.read(imageOrigFile);
            image2 = ImageIO.read(imageOrigFile);
            if((imageOrig.getWidth() != imageOrig1.getWidth()) || (imageOrig.getHeight() != imageOrig1.getHeight()) 
                    || (imageOrig.getWidth() != imageOrig.getHeight()) || (imageOrig1.getWidth() != imageOrig1.getHeight())){ 
                System.out.println("Las imagenes no coinciden en tamaños");
                return false;
            }
            BufferedImage temp1 = new BufferedImage(image1.getWidth()*2, image1.getHeight()*2, BufferedImage.TYPE_INT_RGB);
            BufferedImage temp2 = new BufferedImage(image1.getWidth()*2, image1.getHeight()*2, BufferedImage.TYPE_INT_RGB);
            Color white = new Color(255, 255, 255);
            Color black = new Color(0, 0, 0);
            Random rn = new Random();
            int range = 1 - 0 + 1;
            int randomNum =  rn.nextInt(range) + 0;
             for (int i=0; i<image1.getWidth(); i++){
                 for (int j=0; j<image1.getHeight(); j++){
                    randomNum =  rn.nextInt(range) + 0;
                    
                    Color pixelColor = new Color(imageOrig.getRGB(i, j));
                    Color pixelColor1 = new Color(imageOrig1.getRGB(i, j));
                    if(evaluateColor(pixelColor)==0 && evaluateColor(pixelColor1)==0){
                        if(randomNum<0.5){
                            //FOTO 1 
                            temp1.setRGB(i*2, j*2, black.getRGB());
                            temp1.setRGB(i*2+1, j*2, black.getRGB());
                            temp1.setRGB(i*2, j*2+1, black.getRGB());
                            temp1.setRGB(i*2+1, j*2+1, white.getRGB());
                            
                            //FOTO 2
                            temp2.setRGB(i*2, j*2, black.getRGB());
                            temp2.setRGB(i*2+1, j*2, white.getRGB());
                            temp2.setRGB(i*2, j*2+1, black.getRGB());
                            temp2.setRGB(i*2+1, j*2+1, white.getRGB());
                        } else{
                            //FOTO 1 
                            temp1.setRGB(i*2, j*2, black.getRGB());
                            temp1.setRGB(i*2+1, j*2, black.getRGB());
                            temp1.setRGB(i*2, j*2+1, white.getRGB());
                            temp1.setRGB(i*2+1, j*2+1, black.getRGB());
                            
                            //FOTO 2
                            temp2.setRGB(i*2, j*2, black.getRGB());
                            temp2.setRGB(i*2+1, j*2, black.getRGB());
                            temp2.setRGB(i*2, j*2+1, white.getRGB());
                            temp2.setRGB(i*2+1, j*2+1, white.getRGB());
                        }
                    } else if(evaluateColor(pixelColor)==0 && evaluateColor(pixelColor1)==1){
                        if(randomNum<0.5){
                            //FOTO 1 
                            temp1.setRGB(i*2, j*2, black.getRGB());
                            temp1.setRGB(i*2+1, j*2, black.getRGB());
                            temp1.setRGB(i*2, j*2+1, black.getRGB());
                            temp1.setRGB(i*2+1, j*2+1, white.getRGB());
                            
                            //FOTO 2
                            temp2.setRGB(i*2, j*2, black.getRGB());
                            temp2.setRGB(i*2+1, j*2, black.getRGB());
                            temp2.setRGB(i*2, j*2+1, white.getRGB());
                            temp2.setRGB(i*2+1, j*2+1, white.getRGB());
                        } else{
                            //FOTO 1 
                            temp1.setRGB(i*2, j*2, black.getRGB());
                            temp1.setRGB(i*2+1, j*2, black.getRGB());
                            temp1.setRGB(i*2, j*2+1, white.getRGB());
                            temp1.setRGB(i*2+1, j*2+1, black.getRGB());
                            
                            //FOTO 2
                            temp2.setRGB(i*2, j*2, white.getRGB());
                            temp2.setRGB(i*2+1, j*2, black.getRGB());
                            temp2.setRGB(i*2, j*2+1, white.getRGB());
                            temp2.setRGB(i*2+1, j*2+1, black.getRGB());
                        }
                    } else if(evaluateColor(pixelColor)==1 && evaluateColor(pixelColor1)==1){
                        if(randomNum<0.5){
                            //FOTO 1 
                            temp1.setRGB(i*2, j*2, black.getRGB());
                            temp1.setRGB(i*2+1, j*2, black.getRGB());
                            temp1.setRGB(i*2, j*2+1, black.getRGB());
                            temp1.setRGB(i*2+1, j*2+1, white.getRGB());
                            
                            //FOTO 2
                            temp2.setRGB(i*2, j*2, white.getRGB());
                            temp2.setRGB(i*2+1, j*2, black.getRGB());
                            temp2.setRGB(i*2, j*2+1, white.getRGB());
                            temp2.setRGB(i*2+1, j*2+1, black.getRGB());
                        } else{
                            //FOTO 1 
                            temp1.setRGB(i*2, j*2, black.getRGB());
                            temp1.setRGB(i*2+1, j*2, black.getRGB());
                            temp1.setRGB(i*2, j*2+1, white.getRGB());
                            temp1.setRGB(i*2+1, j*2+1, black.getRGB());
                            
                            //FOTO 2
                            temp2.setRGB(i*2, j*2, white.getRGB());
                            temp2.setRGB(i*2+1, j*2, white.getRGB());
                            temp2.setRGB(i*2, j*2+1, black.getRGB());
                            temp2.setRGB(i*2+1, j*2+1, black.getRGB());
                        }
                    } else if(evaluateColor(pixelColor)==1 && evaluateColor(pixelColor1)==0){
                        if(randomNum<0.5){
                            //FOTO 1 
                            temp1.setRGB(i*2, j*2, black.getRGB());
                            temp1.setRGB(i*2+1, j*2, black.getRGB());
                            temp1.setRGB(i*2, j*2+1, black.getRGB());
                            temp1.setRGB(i*2+1, j*2+1, white.getRGB());
                            
                            //FOTO 2
                            temp2.setRGB(i*2, j*2, white.getRGB());
                            temp2.setRGB(i*2+1, j*2, white.getRGB());
                            temp2.setRGB(i*2, j*2+1, black.getRGB());
                            temp2.setRGB(i*2+1, j*2+1, black.getRGB());
                        } else{
                            //FOTO 1 
                            temp1.setRGB(i*2, j*2, black.getRGB());
                            temp1.setRGB(i*2+1, j*2, black.getRGB());
                            temp1.setRGB(i*2, j*2+1, white.getRGB());
                            temp1.setRGB(i*2+1, j*2+1, black.getRGB());
                            
                            //FOTO 2
                            temp2.setRGB(i*2, j*2, black.getRGB());
                            temp2.setRGB(i*2+1, j*2, white.getRGB());
                            temp2.setRGB(i*2, j*2+1, black.getRGB());
                            temp2.setRGB(i*2+1, j*2+1, white.getRGB());
                        }
                    }
                 }
             }
             
            ImageIO.write(temp1, "jpg", new File(pathRoot+"\\image1.jpg"));
            ImageIO.write(temp2, "jpg", new File(pathRoot+"\\image2.jpg"));
        } catch (Exception ex) {
            System.out.println("no se encontro la imagen (cipher)" + ex);
        }
        return true;
    }
    public void decipher(){
        BufferedImage temp = stockImages(image1, image2);
        AffineTransform transform = new AffineTransform();
        transform.rotate(-Math.PI/2, image1.getWidth()/2, image1.getHeight()/2);
        AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
        image1Rotate = op.filter(image1, null);
        BufferedImage temp2 = stockImages(image1Rotate, image2);
        try {
            ImageIO.write(temp, "jpg", new File(pathRoot+"\\imageResult.jpg"));
            ImageIO.write(temp2, "jpg", new File(pathRoot+"\\imageResult2.jpg"));
        } catch (Exception ex) {
            System.out.println("Error al crear el archivo imageResult " + ex);;
        }
    }
    
    public BufferedImage stockImages(BufferedImage image1, BufferedImage image2){
        BufferedImage temp = new BufferedImage(image1.getWidth(), image1.getHeight(), BufferedImage.TYPE_INT_RGB);
        Color white = new Color(255, 255, 255);
        Color black = new Color(0, 0, 0);
        for (int i=0; i<image1.getWidth(); i++){
            for (int j=0; j<image1.getHeight(); j++){
                Color pixelColor1 = new Color(image1.getRGB(i, j));
                Color pixelColor2 = new Color(image2.getRGB(i, j));
                if(evaluateColor(pixelColor1)==1 && evaluateColor(pixelColor2)==1){
                    temp.setRGB(i, j, black.getRGB());
                } else if(evaluateColor(pixelColor1)==0 && evaluateColor(pixelColor2)==0){
                    temp.setRGB(i, j, white.getRGB());
                } else if((evaluateColor(pixelColor1)==0 && evaluateColor(pixelColor2)==1) || (evaluateColor(pixelColor1)==1 && evaluateColor(pixelColor2)==0)){
                    temp.setRGB(i, j, black.getRGB());
                }
            }
        }
        return temp;
    }
    
    public int evaluateColor(Color color){
        int R = color.getRed();
        int G = color.getGreen();
        int B = color.getBlue();
        if(R<255/2 && G<255/2 && B<255/2)
            return 1;
        else if (R>=255/2 && G>=255/2 && B>=255/2)
            return 0;
        return 1;
    }
    public boolean dimensions(){
        return (image1.getWidth() == image2.getWidth() && image1.getHeight() == image2.getHeight());
    }
}