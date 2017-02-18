/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_BYTE_BINARY;
import java.awt.image.WritableRaster;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Win7
 */
public class preprocessing {
    
    public static BufferedImage gray(BufferedImage img)
    {
        int height = img.getHeight();
        int width = img.getWidth();
        
        for(int i=0; i<height; i++){
         
            for(int j=0; j<width; j++){
            
               Color c = new Color(img.getRGB(j, i));
               int red = (int)(c.getRed() * 0.299);
               int green = (int)(c.getGreen() * 0.587);
               int blue = (int)(c.getBlue() *0.114);
               Color newColor = new Color(red+green+blue,red+green+blue,red+green+blue);
               img.setRGB(j,i,newColor.getRGB());
            }
         }
        return img;
    }
    
    public static int[] imageHistogram(BufferedImage input) {
 
        int[] histogram = new int[256];
 
        for(int i=0; i<histogram.length; i++) histogram[i] = 0;
 
        for(int i=0; i<input.getWidth(); i++) {
            for(int j=0; j<input.getHeight(); j++) {
                int red = new Color(input.getRGB (i, j)).getRed();
                histogram[red]++;
            }
        }
 
        return histogram;
 
    }
    
    private static int otsuTreshold(BufferedImage original) {
 
        int[] histogram = imageHistogram(original);
        int total = original.getHeight() * original.getWidth();
 
        float sum = 0;
        for(int i=0; i<256; i++) sum += i * histogram[i];
 
        float sumB = 0;
        int wB = 0;
        int wF = 0;
 
        float varMax = 0;
        int threshold = 0;
 
        for(int i=0 ; i<256 ; i++) {
            wB += histogram[i];
            if(wB == 0) continue;
            wF = total - wB;
 
            if(wF == 0) break;
 
            sumB += (float) (i * histogram[i]);
            float mB = sumB / wB;
            float mF = (sum - sumB) / wF;
 
            float varBetween = (float) wB * (float) wF * (mB - mF) * (mB - mF);
 
            if(varBetween > varMax) {
                varMax = varBetween;
                threshold = i;
            }
        }
 
        return threshold;
 
    }
    
    private static int colorToRGB(int alpha, int red, int green, int blue) {
 
        int newPixel = 0;
        newPixel += alpha;
        newPixel = newPixel << 8;
        newPixel += red; newPixel = newPixel << 8;
        newPixel += green; newPixel = newPixel << 8;
        newPixel += blue;
 
        return newPixel;
 
    }
     
    public static BufferedImage binarization(BufferedImage img)
    {
        
//        int threshold = 128;
//        int height = img.getHeight();
//        int width = img.getWidth();
//        int[][] result = new int[width][height];
//        
//        BufferedImage output = new BufferedImage(height, width, TYPE_BYTE_BINARY);
//        
//        for(int i = 0; i<height; i++)
//        {
//            for(int j = 0; j<width; j++)
//            {
//                result[i][j] = img.getRGB(i, j);
//                int finalvalue = result[i][j];
//                int alpha = 0;
//                int red = 0;
//                int green = 0;
//                int blue = 0;
//                int gray;
//                
//                alpha = (((int) finalvalue & 0xff) << 24); 
//                blue = ((int) finalvalue & 0xff); 
//                green = (((int) finalvalue & 0x00ff00) >> 8); 
//                red = (((int) finalvalue & 0xff0000) >> 16); 
//                gray = ( red + green + blue ) / 3;
//                
//                if ( gray > threshold )
//                {
//                    //background
//                    finalvalue = 0;
//                    output.setRGB(i, j, finalvalue);
//                }
//                else
//                {
//                    //foreground
//                    output.setRGB(i, j, 0xffffff);
//                }
//            }
//        }
//        return output;
        
        int red;
        int newPixel;
 
        int threshold = otsuTreshold(img);
 
        BufferedImage binarized = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
 
        for(int i=0; i<img.getWidth(); i++)
        {
            for(int j=0; j<img.getHeight(); j++)
            {
 
                // Get pixels
                red = new Color(img.getRGB(i, j)).getRed();
                int alpha = new Color(img.getRGB(i, j)).getAlpha();
                if(red > threshold)
                {
                    newPixel = 0;
                }
                else
                {
                    newPixel = 255;
                }
                
                newPixel = colorToRGB(alpha, newPixel, newPixel, newPixel);
                binarized.setRGB(i, j, newPixel); 
 
            }
        }
 
        return binarized;
 
    }
    
    public static void writeImageToPgm(BufferedImage image, String outputpgm) throws IOException {
           
        BufferedWriter pgmOut = null;
        int rows = image.getHeight();
        int cols = image.getWidth();
        File imginputforpgm;
        
        //String pgmfilename = "datapgm_";
        
        //BufferedImage image = new BufferedImage(rows,cols, BufferedImage.TYPE_BYTE_BINARY);
        
        WritableRaster raster = image.getRaster();
            
        int[][] arraypixel = new int[raster.getHeight()][raster.getWidth()];
        
         for(int i=0; i<raster.getHeight(); i++)
        {
            for(int j =0; j<raster.getWidth(); j++)
            {
                arraypixel[i][j] = raster.getSample(i, j, 0);
            }
        
        }
  
        
        try {
            
            pgmOut = new BufferedWriter(new FileWriter(outputpgm+".pgm"));

            //pgmOut.write("P2\n");
            //pgmOut.write("" + rows + " " + cols + " 255\n");
            for (int i = 0; i < cols; i++)
            {
                StringBuffer s = new StringBuffer();
                
                for (int j = 0; j < rows; j++)
                {
                    int gray = arraypixel[i][j];
                    
                    raster.setSample(i, j, 0, gray);

                    s.append(arraypixel[i][j]);
                    s.append(System.getProperty("line.separator"));
                }
                pgmOut.write(s.toString());
            }

            
            // Simpan citra dengan menggunakan format PNG
            //ImageIO.write(image,"PNG",new File(outputpgm+".png"));

        } finally {
            pgmOut.close();
        }

    }
     
}
