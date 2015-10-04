/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;
import gui.mainGui;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;

/**
 *
 * @author JhhToshiba
 */
public class Crypto {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        mainGui main = new mainGui();
        main.setVisible(true);
        //imageIoWrite();
    }
   
    public static void imageIoWrite() {
         BufferedImage bImage = null;
         try {
             File initialImage = new File("imagenes/AAA.jpg");
             bImage = ImageIO.read(initialImage);
             //System.out.println((new Color(bImage.getRGB(17, 39))).getRed());
             Color myColor = new Color(0, 0, 0);
             for (int i=18; i<80; i=i+2)
                 for (int j=39; j<100; j=j+2)
                    bImage.setRGB(i, j, myColor.getRGB());
             /*ImageIO.write(bImage, "gif", new File("imagenes/image.gif"));
             ImageIO.write(bImage, "jpg", new File("imagenes/image.png"));
             ImageIO.write(bImage, "bmp", new File("imagenes/image.bmp"));
             ImageIO.write(bImage, "jpg", initialImage);*/
         } catch (IOException e) {
               System.out.println("Exception occured :" + e.getMessage());
         }
         //System.out.println("Images were written succesfully.");
    }
}
