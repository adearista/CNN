/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Random;

/**
 *
 * @author Win7
 */
public class weight {
    
    private double[][][] bobot_c1 = new double[6][5][5];
    private double[] bias_c1 = new double[6];
    
    private double[] bobot_s2 = new double[6];
    private double[] bias_s2 = new double[6];
    
    private double[][][][] bobot_c3 = new double[6][16][5][5];
    private double[] bias_c3 = new double[16];
    
    private double[] bobot_s4 = new double[16]; 
    private double[] bias_s4 = new double[16];
    
    private double[][][] bobot_c5 = new double[16][25][120];
    private double[] bias_c5 = new double[120];
    
    private double[][] bobot_f6 = new double[120][84];
    private double[] bias_f6 = new double[84];
    
    private double[][] target84 = new double[46][84];;
    
    private File filebobot;
    private weight_entity b;
    
    
    public weight()
    {
        b = new weight_entity();
    }
    
    //UNTUK GET PARAMETER PERTAMA KALI
    
    //UNTUK NILAI BOBOT RANDOM
    private double RandomFan_In(int kernel)
    {
        
        double temp, temp1, temp2;
        double batas = 2.4/kernel;
        Random rand = new Random();
        boolean stop = false;
        temp = batas/2;
        
        while(stop == false)
	{                     
            temp1 = (rand.nextInt(100000)-50000);
            temp2 = (rand.nextInt(1000000));
            
            System.out.println("temp1: "+temp1 +"|"+"temp2:"+temp2);
            if((temp1 != 0) && (temp2 != 0))
            {
                temp = temp1/temp2;
            }
            if(temp >= -batas && temp <= batas)
            {
		stop = true;
            }
	}
	return temp;
    }
    
    //SET NILAI RANDOM PER LAYER

    public void SetBobot_C1()
    {
        int jumplane_c1,i,j;

	for(jumplane_c1 = 0;jumplane_c1<6;jumplane_c1++)
	{	
            for(i=0;i<5;i++)
            {
                for(j=0;j<5;j++)
		{
                    bobot_c1[jumplane_c1][i][j] = (double) RandomFan_In(25);
		}
            }
	}
    }

    public void SetBias_C1()
    {
	int jumplane_c1;

	for(jumplane_c1 = 0; jumplane_c1<6;jumplane_c1++)
	{
            bias_c1[jumplane_c1] = (double) RandomFan_In(1);
	}
    }
    
    public void SetBobot_S2()
    {
        int jumplane_s2;
        
        for(jumplane_s2 = 0; jumplane_s2<6; jumplane_s2++)
        {
            bobot_s2[jumplane_s2] = (double) RandomFan_In(1);
        }
    }
    
    public void SetBias_S2()
    {
        int jumplane_s2;
        
        for(jumplane_s2 = 0; jumplane_s2<6; jumplane_s2++)
        {
            bias_s2[jumplane_s2] = (double) RandomFan_In(1);
        }
    }
    
    public void SetBobot_C3()
    {
        int i,j,k,t,ss2,index;
        
        char[] charArr;
        
        String[] result = inisialisasi();
        
        for(i=0; i<16; i++)
        {
            charArr = result[i].toCharArray();
            
            for(ss2 = 0; ss2<charArr.length; ss2++)
            {
                index = Integer.parseInt(Character.toString(charArr[ss2]));
                
                for(j=0; j<5; j++)
                {
                    for(k=0; k<5; k++)
                    {
                        t = charArr.length*25;
                        bobot_c3[index][i][j][k] = (double) RandomFan_In(t);
                    }
                }
            }
        }
    }
    
    public void SetBias_C3()
    {
        int jumplane_c3;
        
        for(jumplane_c3 = 0; jumplane_c3<16; jumplane_c3++)
        {
            bias_c3[jumplane_c3] = (double) RandomFan_In(1);
        }
    }
    
    public void SetBobot_S4()
    {
        int jumplane_s4;
        
        for(jumplane_s4 = 0; jumplane_s4<16; jumplane_s4++)
        {
            bobot_s4[jumplane_s4] = (double) RandomFan_In(1);
        }
    }
    
    public void SetBias_S4()
    {
        int jumplane_s4;
        
        for(jumplane_s4 = 0; jumplane_s4<16; jumplane_s4++)
        {
            bias_s4[jumplane_s4] = (double) RandomFan_In(1);
        }
    }
    
    public void SetBobot_C5()
    {
        int i,j,k;
        
        for(i=0; i<120; i++)
        {
            for(j=0; j<16; j++)
            {
                for(k=0; k<25; k++)
                {
                    bobot_c5[j][k][i] = (double) RandomFan_In(25*16);
                }
            }
        }
    }
    
    public void SetBias_C5()
    {
        int i;
        
        for(i = 0; i<120; i++)
        {
            bias_c5[i] = (double) RandomFan_In(1);
        }
    }
    
    public void SetBobot_F6()
    {
        int i,j;
        
        for(j = 0; j<84; j++)
        {
            for(i = 0; i<120; i++)
            {
                bobot_f6[i][j] = (double) RandomFan_In(120);
            }
        }
    }
    
    public void SetBias_F6()
    {
        int i;
        
        for(i = 0; i<84; i++)
        {
            bias_f6[i] = (double) RandomFan_In(1);
        }
    }
   
    //INISIALISASI CONNECTION C3 S2
    public String[] inisialisasi()
    {
        String[] result = new String[16];
        result[0] = "012";
        result[1] = "123";
        result[2] = "234";
        result[3] = "345";
        result[4] = "045";
        result[5] = "015";
        result[6] = "0123";
        result[7] = "1234";
        result[8] = "2345";
        result[9] = "0345";
        result[10] = "0145";
        result[11] = "0125";
        result[12] = "0134";
        result[13] = "1245";
        result[14] = "0235";
        result[15] = "012345";
        
        return result;
        
    }
   
    //GET NAMA FILE UNTUK WRITE AND READ PARAMETER
    
    public String[] getfilename_parameter()
    {
        String fileName[] = new String[12];
        
        fileName[0] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/bobotc1.txt";
        fileName[1] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/biasc1.txt";
        fileName[2] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/bobots2.txt";
        fileName[3] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/biass2.txt";
        fileName[4] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/bobotc3.txt";
        fileName[5] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/biasc3.txt";
        fileName[6] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/bobots4.txt";
        fileName[7] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/biass4.txt";
        fileName[8] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/bobotc5.txt";
        fileName[9] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/biasc5.txt";
        fileName[10] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/bobotf6.txt";
        fileName[11] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/biasf6.txt";
    
        return fileName;
    }
      
    //WRITE BOBOT BIAS TO TXT
    DecimalFormat df = new DecimalFormat(".#####");
    
    public void writeSetBobot_C1(String filename) throws FileNotFoundException, IOException
    {
        int i,j,k;
        File file;
        
        b.open(filename);
        
        file = b.getFile();
        
        FileWriter in = new FileWriter(file);
        PrintWriter filebobot_c1 = new PrintWriter(in); 
       
        
        for(i=0; i<6; i++)
        {
            for(j=0; j<5; j++)
            {
                for(k=0; k<5; k++)
                {
                        
                        filebobot_c1.println(Double.valueOf(df.format(bobot_c1[i][j][k])));                       
                }
            }
        }
        in.close();        
    }
    
    public void writeSetBias_C1(String filename) throws FileNotFoundException, IOException
    {
        int i;
        File file;
        
        b.open(filename);
        
        file = b.getFile();
        
        FileWriter in = new FileWriter(file);
        PrintWriter filebias_c1 = new PrintWriter(in); 
       
        for(i=0; i<6; i++)
        {
            filebias_c1.println(Double.valueOf(df.format(bias_c1[i])));
        }
        in.close();
    }

    public void writeSetBobot_S2(String filename) throws FileNotFoundException, IOException
    {
        int i;
        File file;
        
        b.open(filename);
        
        file = b.getFile();
        
        FileWriter in = new FileWriter(file);
        PrintWriter filebobot_s2 = new PrintWriter(in); 
       
        for(i=0; i<6; i++)
        {
            filebobot_s2.println(Double.valueOf(df.format(bobot_s2[i])));
        }
        in.close();
    }
    
    public void writeSetBias_S2(String filename) throws FileNotFoundException, IOException
    {
        int i;
        File file;
        
        b.open(filename);
        
        file = b.getFile();
        
        FileWriter in = new FileWriter(file);
        PrintWriter filebias_s2 = new PrintWriter(in); 
       
        for(i=0; i<6; i++)
        {
            filebias_s2.println(Double.valueOf(df.format(bias_s2[i])));
        }
        in.close();
    }
      
    public void writeSetBobot_C3(String filename) throws FileNotFoundException, IOException
    {
        String[] result = inisialisasi();
        int i,j,k,ss2,index;
        char[] charArr;
        String line;
        File file;
        
        b.open(filename);
        file = b.getFile();
       
        FileWriter in = new FileWriter(file);
        PrintWriter filebobot_c3 = new PrintWriter(in); 
       
        for(i=0; i<16; i++)
        {
            charArr = result[i].toCharArray();
            for(ss2 = 0; ss2<charArr.length; ss2++)
            {
                index = Integer.parseInt(Character.toString(charArr[ss2]));
                
                for(j=0; j<5; j++)
                {
                    for(k=0; k<5; k++)
                    {
                        filebobot_c3.println(Double.valueOf(df.format(bobot_c3[index][i][j][k])));
                    }
                }
            }
        }
        in.close();
    }
    
    public void writeSetBias_C3(String filename) throws FileNotFoundException, IOException
    {
        int i;
        File file;
        
        b.open(filename);
        
        file = b.getFile();
        
        FileWriter in = new FileWriter(file);
        PrintWriter filebias_c3 = new PrintWriter(in); 
       
        for(i=0; i<16; i++)
        {
            filebias_c3.println(Double.valueOf(df.format(bias_c3[i])));
        }
        in.close();
    }

    public void writeSetBobot_S4(String filename) throws FileNotFoundException, IOException
    {
        int i;
        File file;
        
        b.open(filename);
        
        file = b.getFile();
        
        FileWriter in = new FileWriter(file);
        PrintWriter filebobot_s4 = new PrintWriter(in); 
       
        for(i=0; i<16; i++)
        {
            filebobot_s4.println(Double.valueOf(df.format(bobot_s4[i])));
        
        }
        in.close();
    }
    
    public void writeSetBias_S4(String filename) throws FileNotFoundException, IOException
    {
        int i;
        File file;
        
        b.open(filename);
        
        file = b.getFile();
        
        FileWriter in = new FileWriter(file);
        PrintWriter filebias_s4 = new PrintWriter(in); 
       
        for(i=0; i<16; i++)
        {
            filebias_s4.println(Double.valueOf(df.format(bias_s4[i])));
        }
        in.close();
    }
      
    public void writeSetBobot_C5(String filename) throws FileNotFoundException, IOException
    {
        int i,j,k;
        File file;
        
        b.open(filename);
        
        file = b.getFile();
        
        FileWriter in = new FileWriter(file);
        PrintWriter filebobot_c5 = new PrintWriter(in); 
       
        for(i=0; i<120; i++)
        {
            for(j=0; j<16; j++)
            {
                for(k=0; k<25; k++)
                {
                    filebobot_c5.println(Double.valueOf(df.format(bobot_c5[j][k][i])));
                }
            }
        }
        in.close();
    }
    
    public void writeSetBias_C5(String filename) throws FileNotFoundException, IOException
    {
        int i;
        File file;
        
        b.open(filename);
        
        file = b.getFile();
        
        FileWriter in = new FileWriter(file);
        PrintWriter filebias_c5 = new PrintWriter(in); 
       
        for(i=0; i<120; i++)
        {
            filebias_c5.println(Double.valueOf(df.format(bias_c5[i])));
        }
        in.close();
    }
  
    public void writeSetBobot_F6(String filename) throws FileNotFoundException, IOException
    {
        int i,j;
        File file;
        
        b.open(filename);
        
        file = b.getFile();
        
        FileWriter in = new FileWriter(file);
        PrintWriter filebobot_f6 = new PrintWriter(in); 
       
        for(j=0; j<84; j++)
        {
            for(i=0; i<120; i++)
            {
                filebobot_f6.println(Double.valueOf(df.format(bobot_f6[i][j])));
            }
        }
        in.close();
    }
    
    public void writeSetBias_F6(String filename) throws FileNotFoundException, IOException
    {
        int i;
        File file;
        
        b.open(filename);
        
        file = b.getFile();
        
        FileWriter in = new FileWriter(file);
        PrintWriter filebias_f6 = new PrintWriter(in); 
       
        for(i=0; i<84; i++)
        {
            filebias_f6.println(Double.valueOf(df.format(bias_f6[i])));
        }
        in.close();
    }
       
    //GET BOBOT BIAS SETELAH DI INISIALISASI
    
    public void readBobot_C1(String filename) throws FileNotFoundException, IOException
    {
        int i,j,k;
        String line;
        File file;
        
        b.open(filename);
        file = b.getFile();
        
        FileReader in = new FileReader(file);
        BufferedReader dis = new BufferedReader(in);
        
        for(i=0; i<6; i++)
        {
            for(j=0; j<5; j++)
            {
                for(k=0; k<5; k++)
                {
                    if((line = dis.readLine()) != null)
                    {
                        bobot_c1[i][j][k] = Double.parseDouble(line);
                    }
                }
            }
        }
        in.close();
    }
    
    public void readBias_C1(String filename) throws FileNotFoundException, IOException
    {
        int i;
        String line;
        File file;
        
        b.open(filename);
        file = b.getFile();
        
        FileReader in = new FileReader(file);
        BufferedReader dis = new BufferedReader(in);
        
        for(i=0; i<6; i++)
        {
            if((line = dis.readLine()) != null)
            {
                bias_c1[i] = Double.parseDouble(line);
            }
        }
        in.close();
    }
    
    public void readBobot_S2(String filename) throws FileNotFoundException, IOException
    {
        int i;
        String line;
        File file;
        
        b.open(filename);
        file = b.getFile();
        
        FileReader in = new FileReader(file);
        BufferedReader dis = new BufferedReader(in);
        
        for(i=0; i<6; i++)
        {
            if((line = dis.readLine()) != null)
            {
                        bobot_s2[i] = Double.parseDouble(line);
            }
        }
        in.close();
    }
    
    public void readBias_S2(String filename) throws FileNotFoundException, IOException
    {
        int i;
        String line;
        File file;
        
        b.open(filename);
        file = b.getFile();
        
        FileReader in = new FileReader(file);
        BufferedReader dis = new BufferedReader(in);
        
        for(i=0; i<6; i++)
        {
            if((line = dis.readLine()) != null)
            {
                bias_s2[i] = Double.parseDouble(line);
            }
        }
        in.close();
    }
    
    public void readBobot_C3(String filename) throws FileNotFoundException, IOException
    {
        String[] result = inisialisasi();
        int i,j,k,ss2,index;
        char[] charArr;
        String line;
        File file;
        
        b.open(filename);
        file = b.getFile();
        
        FileReader in = new FileReader(file);
        BufferedReader dis = new BufferedReader(in);
        
        for(i=0; i<16; i++)
        {
            charArr = result[i].toCharArray();
            for(ss2 = 0; ss2<charArr.length; ss2++)
            {
                index = Integer.parseInt(Character.toString(charArr[ss2]));
                
                for(j=0; j<5; j++)
                {
                    for(k=0; k<5; k++)
                    {
                        if((line = dis.readLine()) != null)
                        {
                            bobot_c3[index][i][j][k] = Double.parseDouble(line);
                        }
                    }
                }
            }
        }
        in.close();
    }
    
    public void readBias_C3(String filename) throws FileNotFoundException, IOException
    {
        int i;
        String line;
        File file;
        
        b.open(filename);
        file = b.getFile();
        
        FileReader in = new FileReader(file);
        BufferedReader dis = new BufferedReader(in);
        
        for(i=0; i<16; i++)
        {
            if((line = dis.readLine()) != null)
            {
                bias_c3[i] = Double.parseDouble(line);
            }
        }
        in.close();
    }
    
    public void readBobot_S4(String filename) throws FileNotFoundException, IOException
    {
        int i;
        String line;
        File file;
        
        b.open(filename);
        file = b.getFile();
        
        FileReader in = new FileReader(file);
        BufferedReader dis = new BufferedReader(in);
        
        for(i=0; i<16; i++)
        {
            if((line = dis.readLine()) != null)
            {
                bobot_s4[i] = Double.parseDouble(line);
            }
        }
        in.close();
    }
    
    public void readBias_S4(String filename) throws FileNotFoundException, IOException
    {
        int i;
        String line;
        File file;
        
        b.open(filename);
        file = b.getFile();
        
        FileReader in = new FileReader(file);
        BufferedReader dis = new BufferedReader(in);
        
        for(i=0; i<16; i++)
        {
            if((line = dis.readLine()) != null)
            {
                bias_s4[i] = Double.parseDouble(line);
            }
        }
        in.close();
    }
    
    public void readBobot_C5(String filename) throws FileNotFoundException, IOException
    {
        int i,j,k;
        String line;
        File file;
        
        b.open(filename);
        file = b.getFile();
        
        FileReader in = new FileReader(file);
        BufferedReader dis = new BufferedReader(in);
        
        for(i=0; i<120; i++)
        {
            for(j=0; j<16; j++)
            {
                for(k=0; k<25; k++)
                {
                    if((line = dis.readLine()) != null)
                    {
                        bobot_c5[j][k][i] = Double.parseDouble(line);
                    }
                }
            }
        }
        in.close();
    }
    
    public void readBias_C5(String filename) throws FileNotFoundException, IOException
    {
        int i;
        String line;
        File file;
        
        b.open(filename);
        file = b.getFile();
        
        FileReader in = new FileReader(file);
        BufferedReader dis = new BufferedReader(in);
        
        for(i=0; i<120; i++)
        {
            if((line = dis.readLine()) != null)
            {
                bias_c5[i] = Double.parseDouble(line);
            }
        }
        in.close();
    }
    
    public void readBobot_F6(String filename) throws FileNotFoundException, IOException
    {
        int i,j;
        String line;
        File file;
        
        b.open(filename);
        file = b.getFile();
        
        FileReader in = new FileReader(file);
        BufferedReader dis = new BufferedReader(in);
        
        for(j=0; j<84; j++)
        {
            for(i=0; i<120; i++)
            {
                if((line = dis.readLine()) != null)
                {
                    bobot_f6[i][j] = Double.parseDouble(line);
                }
            }
        }
        in.close();
    }
    
    public void readBias_F6(String filename) throws FileNotFoundException, IOException
    {
        int i;
        String line;
        File file;
        
        b.open(filename);
        file = b.getFile();
        
        FileReader in = new FileReader(file);
        BufferedReader dis = new BufferedReader(in);
        
        for(i=0; i<84; i++)
        {
            if((line = dis.readLine()) != null)
            {
                bias_f6[i] = Double.parseDouble(line);
            }
        }
        in.close();
    }
    
    //GET BOBOT DAN BIAS

    public double[][][] GetBobot_C1()
    {
        return bobot_c1;
    }
    public double[] GetBias_C1()
    {
        return bias_c1;
    }
    public double[] GetBobot_S2()
    {
        return bobot_s2;
    }
    public double[] GetBias_S2()
    {
        return bias_s2;
    }
    public double[][][][] GetBobot_C3()
    {
        return bobot_c3;
    }
    public double[] GetBias_C3()
    {
        return bias_c3;
    }
    public double[] GetBobot_S4()
    {
        return bobot_s4;
    }
    public double[] GetBias_S4()
    {
        return bias_s4;
    }
    public double[][][] GetBobot_C5()
    {
        return bobot_c5;
    }
    public double[] GetBias_C5()
    {
        return bias_c5;
    }
    public double[][] GetBobot_F6()
    {
        return bobot_f6;
    }
    public double[] GetBias_F6()
    {
        return bias_f6;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    //TRAINING
    
    //SET TARGET
    private String[] ParamManual()
    {
        String tempparam[] = new String[46];

        tempparam[0] = "000000000010000011000011111001111000111111111111111110011111111000011000000000000000";
        tempparam[1] = "000000000000000000000100001010000111100011111000101100000110000000000000000000000000";
        tempparam[2] = "001100000111000000100011111011111100100011000001000001100000110000111000111000011000";
        tempparam[3] = "000000000000000011100000010001111000001100001110001101001100111100011100000000000000";
        tempparam[4] = "000000000000000010000001101111110010010110001111111100011110011011011000000000000000";
        tempparam[5] = "000000000000000011000001100011111111111111011110001110000111000000000000000000000000";
        tempparam[6] = "000000000110000011110111111011111110011111001111000001100110000011111000000000000000";
        tempparam[7] = "000000000001100001110001111001110000110000011000000110000001100000011000001100000000";
        tempparam[8] = "000000000000001100110110011011111111111110110011011001101100110000010000000000000000";
        tempparam[9] = "000000000000000111110011111000000000000000000000011000001111111011111100000000000000";
        tempparam[10] = "001000000110000011011001111111111000000110000011000000100111000011111000001100000000";
        tempparam[11] = "000000001000000100000010000001000000100000010000001000000100011011111000111000000000";
        tempparam[12] = "000000000000000001100001111111111110011100001110000111000001100001100000000000000000";
        tempparam[13] = "000000000000000110010011011011111111111110001011000111100001110000000000000000000000";
        tempparam[14] = "000000000000000111110001110001111111111110001100000110000001110000011000000000000000";
        tempparam[15] = "000000000000000011000001110011111000111111011011111000001101111110001100000000000000";
        tempparam[16] = "000000000110000011100111111011100000111110011111101100010000011001111000000000000000";
        tempparam[17] = "000000000000000000000011111111111110000011000111100011100000000000000000000000000000";
        tempparam[18] = "000000000000001111111111111100011000001000000100000011000001110000011000000000000000";
        tempparam[19] = "000000011000001100011011111101111000111000110000011000001111111011111100000000000000";
        tempparam[20] = "000000000110000010000111111111100110100110110011000111110011111001110000000000000000";
        tempparam[21] = "000000000000001100011110111111000001000000100100011011111100111000000000000000000000";
        tempparam[22] = "000000000000000101000010111001111111111001111111111111110000111000000000000000000000";
        tempparam[23] = "000000000000000110000111111011111111111011111011111111110111111000000000000000000000";
        tempparam[24] = "000000000000000011100111111111110011011001111000111101110000110000000000000000000000";
        tempparam[25] = "000000000000001100110110111110011101000010100001011111111111111000000000000000000000";
        tempparam[26] = "000000000000001111010111001101101111100111110011011111000111000000000000000000000000";
        tempparam[27] = "000000000000000011100000110000100000011111100111111111011111100000000000000000000000";
        tempparam[28] = "000000000000000000000000000001110001111100110011100000110000000000000000000000000000";
        tempparam[29] = "000000000000001101111110111011011111001110100011011111111111111000000000000000000000";
        tempparam[30] = "000000000011000001111111111101111000111111011111000011001111100111111111111110000000";
        tempparam[31] = "000000000000000111100000110000110000111111111111111001111100100000000000000000000000";
        tempparam[32] = "000000000000000110000111101111110010110000111001111100111111111001111000000000000000";
        tempparam[33] = "000000000110000011000111110000111001110000111110101110010110011011111100111100000000";
        tempparam[34] = "000000000000000001000010110001111111111001111000111100111100110000000000000000000000";
        tempparam[35] = "000000000000000001000010111101111111110001001011100110000011000000100000000000000000";
        tempparam[36] = "000000000000000001100100111011111111101101110111111111110001100000100000000000000000";
        tempparam[37] = "000000000011000001100000111100011000001100000110011111001111111111111100000000000000";
        tempparam[38] = "000000001100000011000110000011000001100000111111111111111100011000011100111100000000";
        tempparam[39] = "000000001101100110110011001001100100110010011001000001100000110000110000000000000000";
        tempparam[40] = "000000001111100111110000110000110000111111110001100111110111111001111000000000000000";
        tempparam[41] = "000000000000000110010011011011111100111110111011011101110110111000000000000000000000";
        tempparam[42] = "000000000000000111110000110000110000111110111001111000010000011001111000000000000000";
        tempparam[43] = "000000000000000110000011000011111111111001111000111100110110110000000000000000000000";
        tempparam[44] = "000000000010000011110111111001100000111011111111100111000111100011000001111100000000";
        tempparam[45] = "000000000000000001000001100000110000111000011100001110011101111100011000000000000000";
//        tempparam[46] = "000000000000000010011001011111110110101001010100011110000011000000000000000000000000";
//        tempparam[47] = "000000000000000110111001111111110000111100011110000011001100000011100000000000000000";
//        tempparam[48] = "000000000000000001100001111111110111110000111000001110000011000000100000000000000000";
//        tempparam[49] = "000000000000001000111100011110111111000100100010011001001101100000000000000000000000";
//        tempparam[50] = "000000000000000000111111111111111000000000000000000000001111110111111000000000000000";
//        tempparam[51] = "000000000000000110111011011101111101111100000110000001001111100011110000000000000000";
//        tempparam[52] = "000000011000001100111110111111001101100000110000011000001100001111111101111000000000";
//        tempparam[53] = "000000000000000001111000111111111110011000001100000110000011000000000000000000000000";
//        tempparam[54] = "000000000000000000011011011101111101111110011010001111100000000000000000000000000000";
//        tempparam[55] = "000000000000000111111011111101111101111110001100000110000011100000000000000000000000";
//        tempparam[56] = "000000000000000011011001111111111000111111110000011010001001111000000000000000000000";
//        tempparam[57] = "000000000000000110011011111111111000110000011111001100100000110001110000000000000000";
//        tempparam[58] = "000000000000000000000000001100000111111111100001100000110001110000000000000000000000";
//        tempparam[59] = "000000000000000000000111111011111110011011001100000110000001110000000000000000000000";
//        tempparam[60] = "000000000000001100011110011101111100111000110000011000001111110001110000000000000000";
//        tempparam[61] = "000000000000000000011100011110111101011100100010010111101111111000000000000000000000";
//        tempparam[62] = "000000000000000000001011011111101100110111110010111011000111100000000000000000000000";
//        tempparam[63] = "000000000000000011011001111100000000011100100111110011011011100000000000000000000000";
//        tempparam[64] = "000000000000000000000000011101110101101110100011100000110000000000000000000000000000";
//        tempparam[65] = "000000000000000000011101111110001101011110100010010111101011110000000000000000000000";
//        tempparam[66] = "000000000000000000011100011110111101000100100010011111101011111000000000000000000000";
//        tempparam[67] = "000000000000000000011111011111101111100111110110011111000111000000000000000000000000";
//        tempparam[68] = "000000000000000011011000111100000000011100100111111011011011100000000000000000000000";
//        tempparam[69] = "000000000000000000000000011101111111111100100011100000110000000000000000000000000000";
//        tempparam[70] = "000000000000000000011101111110111101011110100010010111001011110101111000000000000000";
              
        return tempparam;
    }
    
//        private String[] ParamManual()
//    {
//        String tempparam[] = new String[46];
//
//        tempparam[0] = "001100000110000111110111110000111000011110011111111111111111001101100111110111111111";
//        tempparam[1] = "100001010000101000011100001110000111000001100000111000011110001111000011100000110000";
//        tempparam[2] = "001110000011000000000111111111100110000011000001100000110000011000011000011000011100";
//        tempparam[3] = "001100000111000000000011110011111000001100001100000111000111100011110011011001001111";
//        tempparam[4] = "011000001100100111011111101111100000110000011111101111110110001111000111100111110110";
//        tempparam[5] = "001000000100000010010011101111110011111001010100101010000101000110100011110000011000";
//        tempparam[6] = "001000000111100011110111110000011110011111011111000001100000010110000011111000011110";
//        tempparam[7] = "000001100001110001110001110001110001110000111000001110000011100000111000001110000011";
//        tempparam[8] = "100011010001101000110101111110111111000110100011010001101100110110011011001100000100";
//        tempparam[9] = "111111011111100000000000000000000000000000000000000000001000000110000011111110111111";
//        tempparam[10] = "001100000110000011111001111111111001100110000011100000110000000110000011111100111110";
//        tempparam[11] = "110000011000001100000110000011000001100000110000011000001100000110000111111110111110";
//        tempparam[12] = "000110000011111111111111110000111000011100001110000111000011100000110000011000011000";
//        tempparam[13] = "000011001101100110110011011101111111111110111011001101100110110011000001111100011110";
//        tempparam[14] = "011111001111000011100001100101111111111110110110000110000011000001100000011100000110";////
//        tempparam[15] = "000000000000000011000001110011111000111111011011111000001101111110001100000000000000";
//        tempparam[16] = "000000000110000011100111111011100000111110011111101100010000011001111000000000000000";
//        tempparam[17] = "000000000000000000000011111111111110000011000111100011100000000000000000000000000000";
//        tempparam[18] = "000000000000001111111111111100011000001000000100000011000001110000011000000000000000";
//        tempparam[19] = "000000011000001100011011111101111000111000110000011000001111111011111100000000000000";
//        tempparam[20] = "000000000110000010000111111111100110100110110011000111110011111001110000000000000000";
//        tempparam[21] = "000000000000001100011110111111000001000000100100011011111100111000000000000000000000";
//        tempparam[22] = "000000000000000101000010111001111111111001111111111111110000111000000000000000000000";
//        tempparam[23] = "000000000000000110000111111011111111111011111011111111110111111000000000000000000000";
//        tempparam[24] = "000000000000000011100111111111110011011001111000111101110000110000000000000000000000";
//        tempparam[25] = "000000000000001100110110111110011101000010100001011111111111111000000000000000000000";
//        tempparam[26] = "000000000000001111010111001101101111100111110011011111000111000000000000000000000000";
//        tempparam[27] = "000000000000000011100000110000100000011111100111111111011111100000000000000000000000";
//        tempparam[28] = "000000000000000000000000000001110001111100110011100000110000000000000000000000000000";
//        tempparam[29] = "000000000000001101111110111011011111001110100011011111111111111000000000000000000000";
//        tempparam[30] = "000000000011000001111111111101111000111111011111000011001111100111111111111110000000";
//        tempparam[31] = "000000000000000111100000110000110000111111111111111001111100100000000000000000000000";
//        tempparam[32] = "000000000000000110000111101111110010110000111001111100111111111001111000000000000000";
//        tempparam[33] = "000000000110000011000111110000111001110000111110101110010110011011111100111100000000";
//        tempparam[34] = "000000000000000001000010110001111111111001111000111100111100110000000000000000000000";
//        tempparam[35] = "000000000000000001000010111101111111110001001011100110000011000000100000000000000000";
//        tempparam[36] = "000000000000000001100100111011111111101101110111111111110001100000100000000000000000";
//        tempparam[37] = "000000000011000001100000111100011000001100000110011111001111111111111100000000000000";
//        tempparam[38] = "000000001100000011000110000011000001100000111111111111111100011000011100111100000000";
//        tempparam[39] = "000000001101100110110011001001100100110010011001000001100000110000110000000000000000";
//        tempparam[40] = "000000001111100111110000110000110000111111110001100111110111111001111000000000000000";
//        tempparam[41] = "000000000000000110010011011011111100111110111011011101110110111000000000000000000000";
//        tempparam[42] = "000000000000000111110000110000110000111110111001111000010000011001111000000000000000";
//        tempparam[43] = "000000000000000110000011000011111111111001111000111100110110110000000000000000000000";
//        tempparam[44] = "000000000010000011110111111001100000111011111111100111000111100011000001111100000000";
//        tempparam[45] = "000000000000000001000001100000110000111000011100001110011101111100011000000000000000";
////        tempparam[46] = "000000000000000010011001011111110110101001010100011110000011000000000000000000000000";
////        tempparam[47] = "000000000000000110111001111111110000111100011110000011001100000011100000000000000000";
////        tempparam[48] = "000000000000000001100001111111110111110000111000001110000011000000100000000000000000";
////        tempparam[49] = "000000000000001000111100011110111111000100100010011001001101100000000000000000000000";
////        tempparam[50] = "000000000000000000111111111111111000000000000000000000001111110111111000000000000000";
////        tempparam[51] = "000000000000000110111011011101111101111100000110000001001111100011110000000000000000";
////        tempparam[52] = "000000011000001100111110111111001101100000110000011000001100001111111101111000000000";
////        tempparam[53] = "000000000000000001111000111111111110011000001100000110000011000000000000000000000000";
////        tempparam[54] = "000000000000000000011011011101111101111110011010001111100000000000000000000000000000";
////        tempparam[55] = "000000000000000111111011111101111101111110001100000110000011100000000000000000000000";
////        tempparam[56] = "000000000000000011011001111111111000111111110000011010001001111000000000000000000000";
////        tempparam[57] = "000000000000000110011011111111111000110000011111001100100000110001110000000000000000";
////        tempparam[58] = "000000000000000000000000001100000111111111100001100000110001110000000000000000000000";
////        tempparam[59] = "000000000000000000000111111011111110011011001100000110000001110000000000000000000000";
////        tempparam[60] = "000000000000001100011110011101111100111000110000011000001111110001110000000000000000";
////        tempparam[61] = "000000000000000000011100011110111101011100100010010111101111111000000000000000000000";
////        tempparam[62] = "000000000000000000001011011111101100110111110010111011000111100000000000000000000000";
////        tempparam[63] = "000000000000000011011001111100000000011100100111110011011011100000000000000000000000";
////        tempparam[64] = "000000000000000000000000011101110101101110100011100000110000000000000000000000000000";
////        tempparam[65] = "000000000000000000011101111110001101011110100010010111101011110000000000000000000000";
////        tempparam[66] = "000000000000000000011100011110111101000100100010011111101011111000000000000000000000";
////        tempparam[67] = "000000000000000000011111011111101111100111110110011111000111000000000000000000000000";
////        tempparam[68] = "000000000000000011011000111100000000011100100111111011011011100000000000000000000000";
////        tempparam[69] = "000000000000000000000000011101111111111100100011100000110000000000000000000000000000";
////        tempparam[70] = "000000000000000000011101111110111101011110100010010111001011110101111000000000000000";
////              
//        return tempparam;
//    }
    
    
    public void SetTarget84()
    {
        int i,j,x;
        int[] val;
        String s;
        String temp[] = ParamManual();
        
        for(i=0; i<46; i++)
        {
            char ss[] = temp[i].toCharArray();
            val = new int[84];
            
            for(x=0; x<val.length; x++)
            {
                s = Character.toString(ss[x]);
                val[x] = Integer.parseInt(s);
            }
            
            for(j=0; j<val.length; j++)
            {
                if(val[j]==1)
                {
                    target84[i][j] = (double)-1.0;
                }
                else
                {
                    target84[i][j] = (double) 1.0;
                }
            }
        }    
    }
    
    public double[][] GetTarget()
    {
        return (target84);
    }
    
    ////////////////////////////////////////////////////////////////////////////  
    
    //SIMPAN BOBOT TRAINING
   
    public void simpanBobot_C1(String namaFile, double[][][] bobot_c1)
    {
        int i,j,k;
        StringBuffer temp = new StringBuffer();
        
        for(i=0; i<6; i++)
        {
            for(j=0; j<5; j++)
            {
                for(k=0; k<5; k++)
                {
                    temp.append(bobot_c1[i][j][k]);
                    temp.append(System.getProperty("line.separator"));
                }
            }
        }
        b.open(namaFile);
        filebobot = b.getFile();
        
        try
        {
            FileWriter fstream = new FileWriter(filebobot);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(temp.toString());
            out.close();
        }
        catch(Exception e)
        {
            System.err.println("Error : "+e.getMessage());
        }
    }
    
    public void simpanBias_C1(String namaFile, double[] bias_c1)
    {
        int jumplane_c1;
        StringBuffer temp = new StringBuffer();
        
        for(jumplane_c1 = 0; jumplane_c1<6; jumplane_c1++)
        {
            temp.append(bias_c1[jumplane_c1]);
            temp.append(System.getProperty("line.separator"));
        }
        
        b.open(namaFile);
        filebobot = b.getFile();
        
        try
        {
            FileWriter fstream = new FileWriter(filebobot);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(temp.toString());
            out.close();
        }
        catch(Exception e)
        {
            System.err.println("Error : "+e.getMessage());
        }
    }
    
    public void simpanBobot_S2(String namaFile, double[] bobot_s2)
    {
        int jumplane_s2;
        StringBuffer temp = new StringBuffer();
        
        for(jumplane_s2 = 0; jumplane_s2<6; jumplane_s2++)
        {
            temp.append(bobot_s2[jumplane_s2]);
            temp.append(System.getProperty("line.separator"));
        }
        
        b.open(namaFile);
        filebobot = b.getFile();
        
        try
        {
            FileWriter fstream = new FileWriter(filebobot);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(temp.toString());
            out.close();
        }
        catch(Exception e)
        {
            System.err.println("Error : "+e.getMessage());
        }
    }
    
    public void simpanBias_S2(String namaFile, double[] bias_s2)
    {
        int jumplane_s2;
        StringBuffer temp = new StringBuffer();
        
        for(jumplane_s2 = 0; jumplane_s2<6; jumplane_s2++)
        {
            temp.append(bias_s2[jumplane_s2]);
            temp.append(System.getProperty("line.separator"));
        }
        
        b.open(namaFile);
        filebobot = b.getFile();
        
        try
        {
            FileWriter fstream = new FileWriter(filebobot);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(temp.toString());
            out.close();
        }
        catch(Exception e)
        {
            System.err.println("Error : "+e.getMessage());
        }
    }
    
    public void simpanBobot_C3(String namaFile, double[][][][] bobot_c3)
    {
        int i,j,k,ss2,index;
        char[] charArr;
        StringBuffer temp = new StringBuffer();
        
        String[] result = inisialisasi();
        
        for(i=0; i<16; i++)
        {
            charArr = result[i].toCharArray();
            
            for(ss2=0; ss2<charArr.length; ss2++)
            {
                index = Integer.parseInt(Character.toString(charArr[ss2]));
                
                for(j=0; j<5; j++)
                {
                    for(k=0; k<5; k++)
                    {
                        temp.append(bobot_c3[index][i][j][k]);
                        temp.append(System.getProperty("line.separator"));
                    }
                }
            }
        }
        
        b.open(namaFile);
        filebobot = b.getFile();
        
        try
        {
            FileWriter fstream = new FileWriter(filebobot);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(temp.toString());
            out.close();
        }
        catch(Exception e)
        {
            System.err.println("Error : "+e.getMessage());
        }
    }
    
    public void simpanBias_C3(String namaFile, double[] bias_c3)
    {
        int jumplane_c3;
        StringBuffer temp = new StringBuffer();
        
        for(jumplane_c3 = 0; jumplane_c3<16; jumplane_c3++)
        {
            temp.append(bias_c3[jumplane_c3]);
            temp.append(System.getProperty("line.separator"));
        }
        
        b.open(namaFile);
        filebobot = b.getFile();
        
        try
        {
            FileWriter fstream = new FileWriter(filebobot);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(temp.toString());
            out.close();
        }
        catch(Exception e)
        {
            System.err.println("Error : "+e.getMessage());
        }
    }
    
    public void simpanBobot_S4(String namaFile, double[] bobot_s4)
    {
        int jumplane_s4;
        StringBuffer temp = new StringBuffer();
        
        for(jumplane_s4 = 0; jumplane_s4<16; jumplane_s4++)
        {
            temp.append(bobot_s4[jumplane_s4]);
            temp.append(System.getProperty("line.separator"));
        }
        
        b.open(namaFile);
        filebobot = b.getFile();
        
        try
        {
            FileWriter fstream = new FileWriter(filebobot);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(temp.toString());
            out.close();
        }
        catch(Exception e)
        {
            System.err.println("Error : "+e.getMessage());
        }   
    }
    
    public void simpanBias_S4(String namaFile, double[] bias_s4)
    {
        int jumplane_s4;
        StringBuffer temp = new StringBuffer();
        
        for(jumplane_s4 = 0; jumplane_s4<16; jumplane_s4++)
        {
            temp.append(bias_s4[jumplane_s4]);
            temp.append(System.getProperty("line.separator"));
        }
        
        b.open(namaFile);
        filebobot = b.getFile();
        
        try
        {
            FileWriter fstream = new FileWriter(filebobot);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(temp.toString());
            out.close();
        }
        catch(Exception e)
        {
            System.err.println("Error : "+e.getMessage());
        }
    }
    
    public void simpanBobot_C5(String namaFile, double[][][] bobot_c5)
    {
        int i,j,k;
        StringBuffer temp = new StringBuffer();
        
        for(i=0; i<120; i++)
        {
            for(j=0; j<16; j++)
            {
                for(k=0; k<25; k++)
                {
                    temp.append(bobot_c5[j][k][i]);
                    temp.append(System.getProperty("line.separator"));
                }
            }
        }
        
        b.open(namaFile);
        filebobot = b.getFile();
        
        try
        {
            FileWriter fstream = new FileWriter(filebobot);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(temp.toString());
            out.close();
        }
        catch(Exception e)
        {
            System.err.println("Error : "+e.getMessage());
        }
    }
    
    public void simpanBias_C5(String namaFile, double[] bias_c5)
    {
        int i;
        StringBuffer temp = new StringBuffer();
        
        for(i=0; i<120; i++)
        {
            temp.append(bias_c5[i]);
            temp.append(System.getProperty("line.separator"));
        }
        
        b.open(namaFile);
        filebobot = b.getFile();
        
        try
        {
            FileWriter fstream = new FileWriter(filebobot);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(temp.toString());
            out.close();
        }
        catch(Exception e)
        {
            System.err.println("Error : "+e.getMessage());
        }
    }
    
    public void simpanBobot_F6(String namaFile, double[][] bobot_f6)
    {
        int i,j;
        StringBuffer temp = new StringBuffer();
        
        for(j=0;j<84;j++)
        {
            for(i=0; i<120; i++)
            {
                temp.append(bobot_f6[i][j]);
                temp.append(System.getProperty("line.separator"));
            }
        }
        
        b.open(namaFile);
        filebobot = b.getFile();
        
        try
        {
            FileWriter fstream = new FileWriter(filebobot);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(temp.toString());
            out.close();
        }
        catch(Exception e)
        {
            System.err.println("Error : "+e.getMessage());
        }
    }
    
    public void simpanBias_F6(String namaFile, double[] bias_f6)
    {
        int i;
        StringBuffer temp = new StringBuffer();
        
        for(i=0; i<84; i++)
        {
            temp.append(bias_f6[i]);
            temp.append(System.getProperty("line.separator"));
        }
        
        b.open(namaFile);
        filebobot = b.getFile();
        
        try
        {
            FileWriter fstream = new FileWriter(filebobot);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(temp.toString());
            out.close();
        }
        catch(Exception e)
        {
            System.err.println("Error : "+e.getMessage());
        }
    }

    
    public String[] getfilename_update()
    {
        String fileName[] = new String[12];
        
        fileName[0] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/new_bobotc1.txt";
        fileName[1] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/new_biasc1.txt";
        fileName[2] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/new_bobots2.txt";
        fileName[3] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/new_biass2.txt";
        fileName[4] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/new_bobotc3.txt";
        fileName[5] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/new_biasc3.txt";
        fileName[6] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/new_bobots4.txt";
        fileName[7] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/new_biass4.txt";
        fileName[8] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/new_bobotc5.txt";
        fileName[9] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/new_biasc5.txt";
        fileName[10] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/new_bobotf6.txt";
        fileName[11] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/new_biasf6.txt";
        
        return fileName;        
    }

    
}
