/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import boundary.formPreprocessing;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Win7
 */
public class image {
    
    //private int[] tempbariss = new int[784]; //28x28
    private int[][] testValue;
    //private int[][] binaryValue = new int[28][28];
    //private int[][] pixelvalue = new int[28][28];
    private int[] tempbaris = new int[1024];
    private int[][] PixelInput = new int[32][32];
    private int[] Label_Image;
    private int[] Label_ImageTest;
    private File file,fileimg;
    private image_entity imagee;
	
    public image(){
		
        imagee = new image_entity();
    }

    
    public void pilpp(int idxpil, formPreprocessing pp) throws IOException
    {
            if(idxpil==1) //training data set
            {
                pp_train();
                JOptionPane.showMessageDialog(null, "Pre-Processing for Training Dataset has been saved");
            }
               
            else if(idxpil==2) //testing data set
            {
                pp_test();
                JOptionPane.showMessageDialog(null, "Pre-Processing for Testing Dataset has been saved");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please choose dataset");
            }
    }

    //PREPROCESSING UNTUK TRAINING
    
    //get nama file png untuk preprocessing train 
    private String[] pp_getimgtrain()
    {

		int i;
		String pp_traininputimg[] = new String[644];

		for(i=0;i<644;i++){
			
                        pp_traininputimg[i] = "D:/TUGAS AKHIR 2/DATASET JEPANG/Data Training/data_  ("+(i+1)+").png";
		}
		return pp_traininputimg;
    }
    
    //get nama file png untuk train setelah preprocessing
    private String[] pp_outputtrain()
    {

		int i;
		String pp_outputtrain[] = new String[644];

		for(i=0;i<644;i++){
			
                        pp_outputtrain[i] = "D:/TUGAS AKHIR 2/DATASET JEPANG/Data Training/datapp_"+(i+1)+".png";
		}
		return pp_outputtrain;
    }
    
    //get nama file pgm untuk train
    private String[] pp_outputpgmtrain()
    {

		int i;
		String pp_outputpgm[] = new String[644];

		for(i=0;i<644;i++){
			
                        pp_outputpgm[i] = "D:/TUGAS AKHIR 2/DATASET JEPANG/Data Training/datapgm_"+(i+1);
		}
		return pp_outputpgm;
    }
    
    //PREPROCESSING TRAIN
    private void pp_train() throws IOException {
        
        String[] namafile_inputtrain = new String[644];
        String[] namafile_outputtrain = new String[644];
        String[] namafile_outputpgmtrain = new String[644];
            
            int i;
            
            namafile_inputtrain = pp_getimgtrain();
            namafile_outputtrain = pp_outputtrain();
            namafile_outputpgmtrain = pp_outputpgmtrain();
            
            for(i=0; i<644;i++)
            {
                BufferedImage image = ImageIO.read(new File(namafile_inputtrain[i]));
                preprocessing.gray(image);
                ImageIO.write(image,"PNG",new File(namafile_outputtrain[i]));
                
                BufferedImage inputbiner = ImageIO.read(new File(namafile_outputtrain[i]));
                BufferedImage output = preprocessing.binarization(inputbiner);
                ImageIO.write(output,"PNG",new File(namafile_outputtrain[i]));
                                
                preprocessing.writeImageToPgm(output, namafile_outputpgmtrain[i]);
            }
            
    }
    
    //PREPROCESSING UNTUK TESTING
    
    
    //get nama file png untuk preprocessing testing
    private String[] pp_getimgtest()
    {

		int i;
		String pp_testinputimg[] = new String[138];

		for(i=0;i<138;i++){
			
                        pp_testinputimg[i] = "D:/TUGAS AKHIR 2/DATASET JEPANG/Data Testing/data_"+(i+1)+".png";
		}
		return pp_testinputimg;
    }
    
    //get nama file png untuk testing setelah preprocessing 
    private String[] pp_outputtest()
    {

		int i;
		String pp_outputtest[] = new String[138];

		for(i=0;i<138;i++){
			
                        pp_outputtest[i] = "D:/TUGAS AKHIR 2/DATASET JEPANG/Data Testing/datapp_"+(i+1)+".png";
		}
		return pp_outputtest;
    }
    
    //get nama file pgm untuk testing
    private String[] pp_outputpgmtest()
    {

		int i;
		String pp_outputpgmtest[] = new String[138];

		for(i=0;i<138;i++){
			
                        pp_outputpgmtest[i] = "D:/TUGAS AKHIR 2/DATASET JEPANG/Data Testing/datapgm_"+(i+1);
		}
		return pp_outputpgmtest;
    }

    //PREPROCESSING TESTING
    private void pp_test() throws IOException {
        
        String[] namafile_inputtest = new String[644];
        String[] namafile_outputtest = new String[644];
        String[] namafile_outputpgmtest = new String[644];
            
            int i;
            
            namafile_inputtest = pp_getimgtest();
            namafile_outputtest = pp_outputtest();
            namafile_outputpgmtest = pp_outputpgmtest();
            
            for(i=0; i<644;i++)
            {
                BufferedImage image = ImageIO.read(new File(namafile_inputtest[i]));
                preprocessing.gray(image);
                ImageIO.write(image,"PNG",new File(namafile_outputtest[i]));
                
                BufferedImage inputbiner = ImageIO.read(new File(namafile_outputtest[i]));
                BufferedImage output = preprocessing.binarization(inputbiner);
                ImageIO.write(output,"PNG",new File(namafile_outputtest[i]));
                                
                preprocessing.writeImageToPgm(output, namafile_outputpgmtest[i]);
            }        
    }
    
    //PROSES TRAINING
 
    //get nama file untuk input training
    public String[] getinput_train()
    {
        int i;
	String namainput_train[] = new String[644];

        for(i=0;i<644;i++){
	
            namainput_train[i] = "D:/TUGAS AKHIR 2/DATASET JEPANG/Data Training/datapgm_"+(i+1)+".pgm";
        }
	
        return namainput_train;
    }
    
    //baca file label untuk training
    public void setimagelabel_train() throws FileNotFoundException, IOException
    {
            int i;
            String line, namaFile;
            Label_Image = new int[644];
            
            namaFile = "D:/TUGAS AKHIR 2/DATASET JEPANG/Data Training/train-log.txt";
            file = new File(namaFile);
            
            FileReader in = new FileReader(file);
            BufferedReader dis = new BufferedReader(in);
            
            for(i=0; i<644; i++)
            {
                if((line = dis.readLine()) != null)
                {
                    Label_Image[i] = Integer.parseInt(line);
                    //Label_Image[i] = String.valueOf(line);
                }
            }
            in.close();
    }
    
    //get label untuk training
    public int[] getlabel_train()
    {
            return Label_Image;
    }
   
    
    //PROSES TESTING
    
    //get nama file untuk input testing
    public String[] getinput_test()
    {
        int i;
        String imagefile[] = new String[644];
            
        for(i=0; i<644; i++)
        {
            imagefile[i] = "D:/TUGAS AKHIR 2/DATASET JEPANG/Data Testing/datapgm_"+(i+1)+".pgm";
        }
        return imagefile;
    }
        
    //baca file label untuk testing
    public void setimagelabel_test() throws FileNotFoundException, IOException
    {
        int i;
        String line, namaFile;
        Label_ImageTest = new int[644];
            
        namaFile = "D:/TUGAS AKHIR 2/DATASET JEPANG/Data Testing/test-log.txt";
        file = new File(namaFile);
            
        FileReader in = new FileReader(file);
        BufferedReader dis = new BufferedReader(in);
            
        for(i=0; i<644; i++)
        {
            if((line = dis.readLine()) != null)
            {
                Label_ImageTest[i] = Integer.parseInt(line);
            }
        }
        in.close();
    }
        
    public int[] getlabel_test()
    {
        return Label_ImageTest;
    }
    
    
    //SET INPUT TRAIN DAN TEST
    
    public void SetInput(String namaFile) throws IOException
    {
            String temp;
            int jumbaris, isibaris;
            
            BufferedReader tampungisi = null;
            
            temp = "";
            jumbaris = 0;
            
            imagee = new image_entity();
            imagee.open(namaFile);
            fileimg = imagee.getFile();
            
 //           FileReader in = new FileReader(fileimg);

            if(file != null)
            {
                
                try{
                    
                    tampungisi = new BufferedReader(new FileReader(fileimg));
                }
                catch (FileNotFoundException ex)
                {
                    //JOptionPane.showMessageDialog(null, "Maaf, gambar pelatihan tidak tersedia");
                    JOptionPane.showMessageDialog(null, "Image file is not available");
                    Logger.getLogger(image.class.getName()).log(Level.SEVERE, null, ex);                   
                }
                
                try{
                    while((temp = tampungisi.readLine()) != null)
                    {
                        jumbaris = jumbaris+1;
                        isibaris = Integer.parseInt(temp);
                        tempbaris[jumbaris-1] = isibaris;                 
                    }
                }
                catch(IOException ex)
                {
                    Logger.getLogger(image.class.getName()).log(Level.SEVERE, null, ex);
                    //JOptionPane.showMessageDialog(null,"Maaf format PGM kosong");
                    JOptionPane.showMessageDialog(null, "PGM file is not available");         
                }
            }
    }
    
    public int[][] getinput2DM()
    {
            int i;
            int x = 0, y = 0;
            
            for(i=1; i<=1024;i++)
            {
                PixelInput[x][y] = tempbaris[i-1];
                if(i%32==0)
                {
                    x++;
                    y=0;
                }
                else
                {
                    y++;
                } 
            }
            return PixelInput;
    }
    
    //option kalo mau pake gambar gagal    
    public String[] filegambargagal(int[] noGmbr)
        {
            String[] nmfile = new String[noGmbr.length];
            
            for(int i = 0; i<noGmbr.length; i++)
            {
                nmfile[i] = "D:/TUGAS AKHIR 2/DATASET JEPANG/Data Training/datapp_"+(i+1)+".png";
            }
            return nmfile;
        }
}
