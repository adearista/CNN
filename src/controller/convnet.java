/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import boundary.formTesting;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Win7
 */
public class convnet {
    
    private double alpha;
    
    private int[][] input = new int[32][32];
    
    private double[][][] c1 = new double[6][28][28];
    private double[][][] gradienc1 = new double[6][28][28];
    private double[][][] bobot_c1 = new double[6][5][5];
    private double[] bias_c1 = new double[6];
    private double[][][] dbobot_c1 = new double[6][5][5];
    private double[] dbias_c1 = new double[6];
    
    private double[][][] s2 = new double[6][14][14];
    private double[][][] gradiens2 = new double[6][14][14];
    private double[] bobot_s2 = new double[6];
    private double[] bias_s2 = new double[6];
    private double[] dbobot_s2 = new double[6];
    private double[] dbias_s2 = new double[6];
    
    private double[][][] c3 = new double[16][10][10];
    private double[][][] gradienc3 = new double[16][10][10];
    private double[][][][] bobot_c3 = new double[6][16][5][5];
    private double[] bias_c3 = new double[16];
    private double[][][][] dbobot_c3 = new double[6][16][5][5];
    private double[] dbias_c3 = new double[16];
    
    private double[][][] s4 = new double[16][5][5];
    private double[][][] gradiens4 = new double[16][5][5];
    private double[] bobot_s4 = new double[16];
    private double[] bias_s4 = new double[16];
    private double[] dbobot_s4 = new double[16];
    private double[] dbias_s4 = new double[16];
    
    private double[] c5 = new double[120];
    private double[] gradienc5 = new double[120];
    private double[][][] bobot_c5 = new double[16][25][120];
    private double[] bias_c5 = new double[120];
    private double[][][] dbobot_c5 = new double[16][25][120];
    private double[] dbias_c5 = new double[120];
    
    private double[] f6 = new double[84];
    private double[] gradienf6 = new double[84];
    private double[][] bobot_f6 = new double[120][84];
    private double[] bias_f6 = new double[84];
    private double[][] dbobot_f6 = new double[120][84];
    private double[] dbias_f6 = new double[84];
    
    private double[] output = new double[46];
    
    private image im;
    private weight bm;
 
    public convnet()
    {
        im = new image();
        bm = new weight();
    }

    public void setbobot_biasRandom() throws IOException
    {
        
        String nmfilebobot[] = new String[12];
        nmfilebobot = bm.getfilename_parameter();
        
        bm.SetBobot_C1();
        bobot_c1 = bm.GetBobot_C1();
        bm.writeSetBobot_C1(nmfilebobot[0]);
        
        bm.SetBias_C1();
        bias_c1 = bm.GetBias_C1();
        bm.writeSetBias_C1(nmfilebobot[1]);
        
        bm.SetBobot_S2();
        bobot_s2 = bm.GetBobot_S2();
        bm.writeSetBobot_S2(nmfilebobot[2]);
        
        bm.SetBias_S2();
        bias_s2 = bm.GetBias_S2();
        bm.writeSetBias_S2(nmfilebobot[3]);
        
        bm.SetBobot_C3();
        bobot_c3 = bm.GetBobot_C3();
        bm.writeSetBobot_C3(nmfilebobot[4]);
        
        bm.SetBias_C3();
        bias_c3 = bm.GetBias_C3();
        bm.writeSetBias_C3(nmfilebobot[5]);
        
        bm.SetBobot_S4();
        bobot_s4 = bm.GetBobot_S4();
        bm.writeSetBobot_S4(nmfilebobot[6]);
        
        bm.SetBias_S4();
        bias_s4 = bm.GetBias_S4();
        bm.writeSetBias_S4(nmfilebobot[7]);
        
        bm.SetBobot_C5();
        bobot_c5 = bm.GetBobot_C5();
        bm.writeSetBobot_C5(nmfilebobot[8]);
        
        bm.SetBias_C5();
        bias_c5 = bm.GetBias_C5();
        bm.writeSetBias_C5(nmfilebobot[9]);
        
        bm.SetBobot_F6();
        bobot_f6 = bm.GetBobot_F6();
        bm.writeSetBobot_F6(nmfilebobot[10]);
        
        bm.SetBias_F6();
        bias_f6 = bm.GetBias_F6();
        bm.writeSetBias_F6(nmfilebobot[11]);
    }
    
    public void setbobotTest() throws FileNotFoundException, IOException
    {
        String nmfilebobot[] = new String[12];
        nmfilebobot = bm.getfilename_parameter();
        
        bm.readBobot_C1(nmfilebobot[0]);
        bm.readBias_C1(nmfilebobot[1]);
        
        bm.readBobot_S2(nmfilebobot[2]);
        bm.readBias_S2(nmfilebobot[3]);
        
        bm.readBobot_C3(nmfilebobot[4]);
        bm.readBias_C3(nmfilebobot[5]);
        
        bm.readBobot_S4(nmfilebobot[6]);
        bm.readBias_S4(nmfilebobot[7]);
        
        bm.readBobot_C5(nmfilebobot[8]);
        bm.readBias_C5(nmfilebobot[9]);
        
        bm.readBobot_F6(nmfilebobot[10]);
        bm.readBias_F6(nmfilebobot[11]);
        
        bobot_c1 = bm.GetBobot_C1();
        bias_c1 = bm.GetBias_C1();
        
        bobot_s2 = bm.GetBobot_S2();
        bias_s2 = bm.GetBias_S2();
        
        bobot_c3 = bm.GetBobot_C3();
        bias_c3 = bm.GetBias_C3();
        
        bobot_s4 = bm.GetBobot_S4();
        bias_s4 = bm.GetBias_S4();
        
        bobot_c5 = bm.GetBobot_C5();
        bias_c5 = bm.GetBias_C5();
        
        bobot_f6 = bm.GetBobot_F6();
        bias_f6 = bm.GetBias_F6(); 
    }
    
    public void bobot_testing() throws FileNotFoundException, IOException
    {
        String nmfilebobot[] = new String[12];
        nmfilebobot = bm.getfilename_update();
        
        bm.readBobot_C1(nmfilebobot[0]);
        bm.readBias_C1(nmfilebobot[1]);
        
        bm.readBobot_S2(nmfilebobot[2]);
        bm.readBias_S2(nmfilebobot[3]);
        
        bm.readBobot_C3(nmfilebobot[4]);
        bm.readBias_C3(nmfilebobot[5]);
        
        bm.readBobot_S4(nmfilebobot[6]);
        bm.readBias_S4(nmfilebobot[7]);
        
        bm.readBobot_C5(nmfilebobot[8]);
        bm.readBias_C5(nmfilebobot[9]);
        
        bm.readBobot_F6(nmfilebobot[10]);
        bm.readBias_F6(nmfilebobot[11]);
        
        bobot_c1 = bm.GetBobot_C1();
        bias_c1 = bm.GetBias_C1();
        
        bobot_s2 = bm.GetBobot_S2();
        bias_s2 = bm.GetBias_S2();
        
        bobot_c3 = bm.GetBobot_C3();
        bias_c3 = bm.GetBias_C3();
        
        bobot_s4 = bm.GetBobot_S4();
        bias_s4 = bm.GetBias_S4();
        
        bobot_c5 = bm.GetBobot_C5();
        bias_c5 = bm.GetBias_C5();
        
        bobot_f6 = bm.GetBobot_F6();
        bias_f6 = bm.GetBias_F6(); 
    }
    ////////////////////////////////////////////////////////////////////////////
    
    //TRAINING CNN
    
    
//    public void training(boolean kon)throws IOException
//    {
//        int i,n,inc,index;
//        double err, mse;
//        double EConvergen = (double) 1.0;
//        String[] dirImage = new String[2];
//        int[] label = new int[2];
//        
//        //get image as input
//        n = 2;
//        
//        //dirImage = im.GetImageFile();
//        //im.SetImageLabel();
//        //label = im.GetLabel();
//        
//        dirImage = im.getinput_train();
//        im.setimagelabel_train();
//        label = im.getlabel_train();
//        
//        
//        if(kon == false)
//        {
//            displayalertparam();
//        }
//
//        else
//        {
//            inc = 1;
//            mse = 90;
//            
//            while(mse > EConvergen)
//            {
//                if(inc<=2)
//                {
//                    alpha = (double) 0.05;
//                }
//                else if(inc<=5)
//                {
//                    alpha = (double) 0.02;
//                }
//                else if(inc<=8)
//                {
//                    alpha = (double) 0.01;
//                }
//                else if(inc<=12)
//                {
//                    alpha = (double) 0.005;
//                }
//                else
//                {
//                    alpha = (double) 0.001;
//                }
//                
//                err = 0;
//                
//                for(i=0; i<n; i++)
//                {
//                    try
//                    {
//                        //im.SetInput(dirImage[i]);
//                        
//                        im.SetInput(dirImage[i]);
//                        input = im.getinput2DM();
//                    }
//                    catch (IOException ex)
//                    {
//                        Logger.getLogger(convnet.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    
//                    index = label[i];
//                    feedforward();
//                    
//                    //err = (double)(err+lossfunction(index));
//                    //mse = err/(i+1);
//                    
//                    err = (double) (err + output[index]);
//                    mse = err/(i+1);
//                    
//                    System.out.println("mse-"+inc+"-["+(i+1)+"] : "+mse);
//                    gradienBP(index);
//                    updatebobot_bias();
//                }
//                simpanbobot_bias();
//                inc++;  
//            }
//        }
//    }
    
//    public void training(boolean kon)throws IOException
//    {
//        int i,n,inc,index;
//        double err, mse;
//        double EConvergen = (double) 0.1;
//        String[] dirImage = new String[10];
//        int[] label = new int[10];
//        
//        //get image as input
//        n = 10;
//        dirImage = im.getinput_train();
//        im.setimagelabel_train();
//        label = im.getlabel_train();
//        
//        if(kon == false)
//        {
//            displayalertparam();
//        }
//        else
//        {
//            inc = 1;
//            mse = 999999;
//            
//            while(mse > EConvergen)
//            {
//                if(inc<=2)
//                {
//                    alpha = (double) 0.05;
//                }
//                else if(inc<=5)
//                {
//                    alpha = (double) 0.02;
//                }
//                else if(inc<=8)
//                {
//                    alpha = (double) 0.01;
//                }
//                else if(inc<=12)
//                {
//                    alpha = (double) 0.005;
//                }
//                else
//                {
//                    alpha = (double) 0.001;
//                }
//                
//                err = 0;
//                
//                for(i=0; i<n; i++)
//                {
//                    try
//                    {
//                        im.SetInput(dirImage[i]);
//                        input = im.getinput2DM();
//                    }
//                    catch (IOException ex)
//                    {
//                        Logger.getLogger(convnet.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    
//                    index = label[i];
//                    feedforward();
//                    
//                    //err = (double)(err+lossfunction(index));
//                    //mse = err/(i+1);
//                    
//                    err = (double) (err + output[index]);
//                    mse = err/(i+1);
//                    
//                    System.out.println("mse-"+inc+"-["+(i+1)+"] : "+mse);
//                    gradienBP(index);
//                    updatebobot_bias();
//                    
//                }
//                simpanbobot_bias();
//                inc++;            
//            }
//        }
//    }
//    
//    private void feedforward()
//    {
//        Layer_C1();
//        Layer_S2();
//        Layer_C3();
//        Layer_S4();
//        Layer_C5();
//        Layer_F6();
//        Layer_Output();
//    }
//    
//    //FEEFORWARD
//    
//    private void Layer_C1()
//    {
//        int jumplane_c1,i,j,k,l,x,y;
//        double temp1,tampungan;
//        
//        for(jumplane_c1 = 0; jumplane_c1<6;jumplane_c1++)
//        {
//            for(i=0;i<28;i++)
//            {
//                for(j=0; j<28; j++)
//                {
//                    temp1 = 0;
//                    x = 0;
//                    
//                    for(k=j;k<=j+4;k++)
//                    {
//                        y=0;
//                        
//                        for(l=i; l<=i+4;l++)
//                        {
//                            if(input[k][l]==0)
//                            {
//                                temp1 = temp1 + (1.175*bobot_c1[jumplane_c1][x][y]);
//                            }
//                            else
//                            {
//                                temp1 = temp1 + (-0.1 * bobot_c1[jumplane_c1][x][y]);
//                            }
//                            y++;
//                        }
//                        x++;
//                    }
//                    
//                    tampungan = (temp1+bias_c1[jumplane_c1]);
//                    c1[jumplane_c1][i][j] = 1.7159 * Math.tanh(0.667 * tampungan);
//                }
//            }
//        }
//    }
//    
//    private void Layer_S2()
//    {
//        int jumplane_s2,baris,kolom,i,j,bar,kol;
//        double temp1, temp2;
//        
//        for(jumplane_s2 = 0; jumplane_s2<6; jumplane_s2++)
//        {
//            baris = 0;
//            kolom = 0;
//            
//            for(i=0; i<14;i++)
//            {
//                for(j=0; j<14; j++)
//                {
//                    temp1 = 0;
//                    
//                    for(bar = baris; bar<baris+2; bar++)
//                    {
//                        for(kol = kolom; kol<kolom+2; kol++)
//                        {
//                            temp1 = temp1 + c1[jumplane_s2][bar][kol];
//                        }
//                    }
//                    
//                    temp2 = ((temp1/4) * bobot_s2[jumplane_s2])+bias_s2[jumplane_s2];
//                    s2[jumplane_s2][i][j] = 1.7159 * Math.tanh(0.667 * temp2);
//                    kolom = kolom+2;
//                }
//                baris = baris+2;
//                kolom = 0;
//            }
//        }
//    }
//    
//    private void Layer_C3()
//    {
//        int i,j,k,l,m,ss2,index,x,y;
//        double temp1,temp2,tot;
//        char[] charArr;
//        
//        String[] result = bm.inisialisasi();
//        
//        for(i=0; i<16; i++)
//        {
//            charArr = result[i].toCharArray();
//            
//            for(j=0; j<10; j++)
//            {
//                for(k=0; k<10; k++)
//                {
//                    tot = 0;
//                    
//                    for(ss2 = 0; ss2<charArr.length; ss2++)
//                    {
//                        index = Integer.parseInt(Character.toString(charArr[ss2]));
//                        temp1 = 0;
//                        x = 0;
//                        
//                        for(l=k; l<=k+4; l++)
//                        {
//                            y=0;
//                            for(m = j; m<=j+4; m++)
//                            {
//                                temp1= temp1 + s2[index][l][m] * bobot_c3[index][i][x][y];
//                                y++;
//                            }
//                            x++;
//                        }
//                        tot = tot+temp1;
//                    }
//                    temp2 = tot + bias_c3[i];
//                    c3[i][j][k] = 1.7159 * Math.tanh(0.0667 * temp2);
//                }
//            }
//        }
//    }
//    
//    private void Layer_S4()
//    {
//        int jumplane_s4, baris,kolom,i,j,bar,kol;
//        double temp1, temp2;
//        
//        for(jumplane_s4 = 0; jumplane_s4<16; jumplane_s4++)
//        {
//            baris = 0;
//            kolom = 0;
//            for(i=0; i<5; i++)
//            {
//                for(j=0; j<5; j++)
//                {
//                    temp1 = 0;
//                    
//                    for(bar = baris; bar<baris+2; bar++)
//                    {
//                        for(kol = kolom; kol<kolom+2; kol++)
//                        {
//                            temp1 = temp1+c3[jumplane_s4][bar][kol];
//                        }
//                    }
//                    
//                    temp2 = (temp1*bobot_s4[jumplane_s4])+bias_s4[jumplane_s4];
//                    s4[jumplane_s4][i][j] = 1.7159 * Math.tanh(0.667 * temp2);
//                    kolom = kolom+2;
//                }
//                baris = baris+2;
//                kolom = 0;
//            }   
//        }
//    }
//    
//    private void Layer_C5()
//    {
//        int i,j,k,l,ctr;
//        double temp1, temp2, temp3;
//        
//        for(i=0; i<120; i++)
//        {
//            temp2 = 0;
//            
//            for(j=0; j<16; j++)
//            {
//                temp1 = 0;
//                ctr = 0;
//                
//                for(k=0; k<5; k++)
//                {
//                    for(l=0; l<5; l++)
//                    {
//                        temp1 = temp1 + s4[j][k][l] * bobot_c5[j][ctr][i];
//                        ctr++;
//                    }
//                }
//                temp2 = temp2 + temp1;
//            }
//            temp3 = temp2 + bias_c5[i];
//            c5[i] = 1.7159 * Math.tanh(0.667 * temp3);
//        }
//    }
//    
//    private void Layer_F6()
//    {
//        int i,j;
//        double temp1, temp2, temp3;
//        
//        for(j=0; j<84; j++)
//        {
//            temp2 = 0;
//            
//            for(i=0; i<120; i++)
//            {
//                temp1 = c5[i] * bobot_f6[i][j];
//                temp2 = temp2 + temp1;
//            }
//            temp3 = temp2 + bias_f6[j];
//            f6[j] = 1.7159 * Math.tanh(0.667 * temp3);
//        }
//    }
//    
//    private void Layer_Output()
//    {
//        int i,j;
//        double[][] target84 = new double[12][84];
//        double power;
//        
//        bm.SetTarget84();
//        target84 = bm.GetTarget();
//        
//        for(j=0; j<12; j++)
//        {
//            output[j] = 0;
//            power = 0.0;
//            
//            for(i=0; i<84; i++)
//            {
//                power = power + Math.pow(f6[i] - target84[j][i], 2);
//            }
//            output[j] = power;
//        }
//    }
//    
//    private void gradienBP(int label)
//    {
//        EBP_LayerF6(label);
//        EBP_LayerC5();
//        EBP_LayerS4();
//        EBP_LayerC3();
//        EBP_LayerS2();
//        EBP_LayerC1();
//    }
//    
//    //CARI DELTA BOBOT
//    
//    private void EBP_LayerF6(int label)
//    {
//        int i,j,out;
//        double t1,eror,aksen;
//        double target84[][] = new double[12][84];
//        
//        bm.SetTarget84();
//        target84 = bm.GetTarget();
//        
//        for(i=0; i<84; i++)
//        {
//            t1 = target84[label][i];
//            eror =  t1-f6[i];
//            aksen = derivative(f6[i]);
//            gradienf6[i] = eror*aksen;
//            
//            for(j=0; j<120; j++)
//            {
//                dbobot_f6[j][i] = alpha*c5[j]*gradienf6[i];
//            }
//            dbias_f6[i] = alpha*gradienf6[i];
//        }
//    }
//    
//    private void EBP_LayerC5()
//    {
//        int i,j,k,l,ctr;
//        double temp,aksen;
//        
//        for(i=0; i<120; i++)
//        {
//            
//            temp = 0;
//            for(j=0; j<84; j++)
//            {
//                temp = temp+bobot_f6[i][j]*gradienf6[j];
//            }
//            
//            aksen = derivative(c5[i]);
//            gradienc5[i] = aksen*temp;
//        }
//        
//        //delta w c5
//        
//        for(i=0; i<120; i++)
//        {
//            for(j=0; j<16; j++)
//            {
//                
//                ctr = 0;
//                for(k=0; k<5; k++)
//                {
//                    for(l=0; l<5; l++)
//                    {
//                        dbobot_c5[j][ctr][i] = alpha*s4[j][k][l]*gradienc5[i];
//                        ctr++;
//                    }
//                }
//            }
//            dbias_c5[i] = alpha*gradienc5[i]; //delta bias c5
//        }
//    }
//    
//    private void EBP_LayerS4()
//    {
//        int jumplane_s4,baris,kolom,i,j,bar,kol,k,ctr;
//        double din_s4[][][] = new double[16][5][5];
//        double temp1,aksen;
//        
//        //inisialisasi temp=0
//        
//        for(jumplane_s4 = 0; jumplane_s4<16; jumplane_s4++)
//        {
//            for(i=0; i<5; i++)
//            {
//                for(j=0; j<5; j++)
//                {
//                    din_s4[jumplane_s4][i][j] = 0;
//                }
//            }
//        }
//        
//        //tampung total gradien k dan bobot k yang masuk, cari sigma
//        
//        for(k=0; k<120; k++)
//        {
//            for(jumplane_s4 = 0; jumplane_s4<16; jumplane_s4++)
//            {
//                ctr = 0;
//                
//                for(i=0; i<5; i++)
//                {
//                    for(j=0; j<5; j++)
//                    {
//                        din_s4[jumplane_s4][i][j] = din_s4[jumplane_s4][i][j] + bobot_c5[jumplane_s4][ctr][k] * gradienc5[k];
//                        ctr++;
//                    }
//                }
//            }
//        }
//        
//        //cari gradien s4
//        
//        for(jumplane_s4 = 0; jumplane_s4<16; jumplane_s4++)
//        {
//            for(i=0; i<5; i++)
//            {
//                for(j=0; j<5; j++)
//                {
//                    aksen = derivative(s4[jumplane_s4][i][j]);
//                    gradiens4[jumplane_s4][i][j] = din_s4[jumplane_s4][i][j]*aksen;
//                }
//            }
//        }
//        
//        //delta w s4
//        
//        for(jumplane_s4=0; jumplane_s4<16; jumplane_s4++)
//        {
//            baris = 0;
//            kolom = 0;
//            dbobot_s4[jumplane_s4] = 0;
//            
//            for(i=0; i<5; i++)
//            {
//                for(j=0; j<5; j++)
//                {
//                    temp1 = 0;
//                    for(bar = baris; bar<baris+2; bar++)
//                    {
//                        for(kol = kolom; kol<kolom+2; kol++)
//                        {
//                            temp1 = temp1 + c3[jumplane_s4][bar][kol];
//                        }
//                    }
//                    dbobot_s4[jumplane_s4] = dbobot_s4[jumplane_s4] + temp1*gradiens4[jumplane_s4][i][j];
//                    kolom = kolom+2;
//                }
//                baris = baris+2;
//                kolom = 0;
//            }
//            dbobot_s4[jumplane_s4] = alpha*dbobot_s4[jumplane_s4];
//        }
//        
//        //delta bias s4
//        
//        for(jumplane_s4 = 0; jumplane_s4<16; jumplane_s4++)
//        {
//            dbias_s4[jumplane_s4] = 0;
//            for(i=0;i<5; i++)
//            {
//                for(j=0; j<5; j++)
//                {
//                    dbias_s4[jumplane_s4] = dbias_s4[jumplane_s4] + gradiens4[jumplane_s4][i][j];
//                }
//            }
//            dbias_s4[jumplane_s4] = alpha*dbias_s4[jumplane_s4];
//        }    
//    }
//    
//    private void EBP_LayerC3()
//    {
//        int i,j,k,l,ctr,ii,ctr2,index,bar,baris,kol,kolom;
//        double din_c3[][][] = new double[16][10][10];
//        double tempbobot_c3[][][][] = new double [6][25][16][100]; 
//        char[] charArr;
//        double temp;
//        double aksen;
//        
//        for(i=0;i<16;i++)
//        {
//            for(j=0; j<10; j++)
//            {
//                for(k=0; k<10; k++)
//                {
//                    din_c3[i][j][k] = 0;
//                }
//            }
//        }
//        
//        for(i=0; i<16; i++)
//        {
//            baris = 0;
//            kolom = 0;
//            
//            for(j=0; j<5; j++)
//            {
//                for(k=0; k<5; k++)
//                {
//                    for(bar = baris; bar<baris+2; bar++)
//                    {
//                        for(kol = kolom; kol<kolom+2; kol++)
//                        {
//                            din_c3[i][bar][kol] = din_c3[i][bar][kol] + bobot_s4[i] * gradiens4[i][j][k];
//                        }
//                    }
//                    kolom = kolom+2;
//                }
//                baris = baris+2;
//                kolom = 0;
//            }
//        }
//        
//        for(i=0; i<16; i++)
//        {
//            for(j=0; j<10; j++)
//            {
//                for(k=0; k<10; k++)
//                {
//                    aksen = derivative(c3[i][j][k]);
//                    gradienc3[i][j][k] = din_c3[i][j][k] * aksen;
//                }
//            }
//        }
//        
//        //kali alpa dan inputnya
//        
//        String[] result = bm.inisialisasi();
//        
//        for(i=0; i<16; i++)
//        {
//            ctr2 = 0;
//            charArr = result[i].toCharArray();
//            
//            for(j=0; j<10; j++)
//            {
//                for(k=0; k<10; k++)
//                {
//                    for(int ss2 = 0; ss2<charArr.length; ss2++)
//                    {
//                        index = Integer.parseInt(Character.toString(charArr[ss2]));
//                        ctr = 0;
//                        
//                        for(l=k; l<=k+4;l++)
//                        {
//                            for(ii=j; ii<=j+4; ii++)
//                            {
//                                tempbobot_c3[index][ctr][i][ctr2] = gradienc3[i][j][k] * s2[index][l][ii];
//                                ctr++;
//                            }
//                        }
//                    }
//                    ctr2++;
//                }
//            }
//        }
//        
//        for(i=0; i<16; i++)
//        {
//            ctr = 0;
//            
//            for(j=0; j<5; j++)
//            {
//                for(k=0; k<5; k++)
//                {
//                    charArr = result[j].toCharArray();
//                    
//                    for(int ss2 = 0; ss2<charArr.length; ss2++)
//                    {
//                        index= Integer.parseInt(Character.toString(charArr[ss2]));
//                        temp = 0;
//                        
//                        for(l=0; l<100; l++)
//                        {
//                            temp = temp+tempbobot_c3[index][ctr][i][l];
//                        }
//                        dbobot_c3[index][i][j][k] = alpha * temp;
//                    }
//                    ctr++;
//                }
//            }
//        }
//        
//        for(j=0; j<16; j++)
//        {
//            temp = 0;
//            
//            for(k=0; k<10; k++)
//            {
//                for(l=0; l<10; l++)
//                {
//                    temp = temp + gradienc3[j][k][l];
//                }
//            }
//            dbias_c3[j] = alpha * temp;
//        }
//    }
//    
//    private void EBP_LayerS2()
//    {
//        int jumplane_s2, jumplane_c3, baris,kolom,i,j,k,l,bar,kol,index,x,y;
//        double din_s2[][][] = new double[6][14][14];
//        double temp1,aksen;
//        char[] charArr;
//        
//        for(jumplane_s2 = 0; jumplane_s2<6; jumplane_s2++)
//        {
//            for(i=0; i<14; i++)
//            {
//                for(j=0; j<14; j++)
//                {
//                    din_s2[jumplane_s2][i][j] = 0;
//                }
//            }
//        }
//        
//        String[] result = bm.inisialisasi();
//        
//        for(jumplane_c3 = 0; jumplane_c3<16; jumplane_c3++)
//        {
//            for(i=0; i<10; i++)
//            {
//                for(j=0; j<10; j++)
//                {
//                    charArr = result[jumplane_c3].toCharArray();
//                    
//                    for(int ss2 = 0; ss2<charArr.length; ss2++)
//                    {
//                        index = Integer.parseInt(Character.toString(charArr[ss2]));
//                        
//                        x = 0;
//                        
//                        for(k=j; k<=j+4; k++)
//                        {
//                            y = 0;
//                            
//                            for(l=i; l<=i+4; l++)
//                            {
//                                din_s2[index][k][l] = din_s2[index][k][l] + gradienc3[jumplane_c3][i][j]*bobot_c3[index][jumplane_c3][x][y];
//                                y++;
//                            }
//                            x++;
//                        }
//                    }
//                }
//            }
//        }
//            
//        for(jumplane_s2 = 0; jumplane_s2<6; jumplane_s2++)
//        {
//            for(i=0; i<14; i++)
//            {
//                for(j=0; j<14; j++)
//                {
//                    aksen = derivative(s2[jumplane_s2][i][j]);
//                    gradiens2[jumplane_s2][i][j] = din_s2[jumplane_s2][i][j]*aksen;
//                        
//                }
//            }
//        }
//            
//        //cari dbobot s2
//            
//        for(jumplane_s2 = 0; jumplane_s2<6; jumplane_s2++)
//        {
//            baris = 0;
//            kolom = 0;
//            dbobot_s2[jumplane_s2] = 0;
//                
//            for(i=0; i<14; i++)
//            {
//                for(j=0; j<14; j++)
//                {
//                    temp1 = 0;
//                        
//                    for(bar = baris; bar<baris+2; bar++)
//                    {
//                        for(kol = kolom; kol<kolom+2; kol++)
//                        {
//                            temp1 = temp1+c1[jumplane_s2][bar][kol];
//                        }
//                    }
//                        
//                    dbobot_s2[jumplane_s2] = dbobot_s2[jumplane_s2] + temp1*gradiens2[jumplane_s2][i][j];
//                        
//                    kolom = kolom+2;
//                }
//                baris = baris+2;
//                kolom = 0;
//            }
//            dbobot_s2[jumplane_s2] = alpha*dbobot_s2[jumplane_s2];
//        }
//            
//        for(jumplane_s2 = 0; jumplane_s2<6; jumplane_s2++)
//        {
//            dbias_s2[jumplane_s2] = 0;
//                
//            for(i=0; i<14; i++)
//            {
//                for(j=0; j<14; j++)
//                {
//                    dbias_s2[jumplane_s2] = dbias_s2[jumplane_s2] + gradiens2[jumplane_s2][i][j];
//                }
//            }
//            dbias_s2[jumplane_s2] = alpha*dbias_s2[jumplane_s2];
//        }
//    }
//    
//    private void EBP_LayerC1()
//    {
//        int jumplane_c1,i,j,k,l,ctr,ctr2,baris,kolom,bar,kol;
//        double tempbobot_c1[][][] = new double[25][6][784];
//        double din_c1[][][] = new double[6][28][28];
//        double temp1,aksen;
//        
//        for(jumplane_c1 = 0; jumplane_c1<6; jumplane_c1++)
//        {
//            baris = 0;
//            kolom = 0;
//            
//            for(i=0; i<14;i++)
//            {
//                for(j=0; j<14; j++)
//                {
//                    for(bar = baris; bar<baris+2; bar++)
//                    {
//                        for(kol = kolom; kol<kolom+2; kol++)
//                        {
//                            din_c1[jumplane_c1][bar][kol] = bobot_s2[jumplane_c1] * gradiens2[jumplane_c1][i][j];
//                        }
//                    }
//                    kolom = kolom+2;
//                }
//                baris = baris+2;
//                kolom = 0;
//            }
//        }
//        
//        for(jumplane_c1 = 0; jumplane_c1<6; jumplane_c1++)
//        {
//            for(i=0;i<28;i++)
//            {
//                for(j=0; j<28; j++)
//                {
//                    aksen = derivative(c1[jumplane_c1][i][j]);
//                    gradienc1[jumplane_c1][i][j] = din_c1[jumplane_c1][i][j]*aksen;
//                }
//            }
//        }
//        
//        for(jumplane_c1 = 0; jumplane_c1<6; jumplane_c1++)
//        {
//            ctr2 = 0;
//            
//            for(i=0; i<28; i++)
//            {
//                for(j=0; j<28; j++)
//                {
//                    ctr = 0;
//                    
//                    for(k=j; k<=j+4; k++)
//                    {
//                        for(l=i; l<=i+4; l++)
//                        {
//                            if(input[k][l]==0)
//                            {
//                                tempbobot_c1[ctr][jumplane_c1][ctr2] = 1.175 * gradienc1[jumplane_c1][i][j];
//                            }
//                            else
//                            {
//                                tempbobot_c1[ctr][jumplane_c1][ctr2] = -0.1 * gradienc1[jumplane_c1][i][j];
//                            }
//                            ctr++;
//                        }
//                    }
//                    ctr2++;
//                }
//            }
//        }
//        
//        for(jumplane_c1 = 0; jumplane_c1<6; jumplane_c1++)
//        {
//            ctr = 0;
//            
//            for(i=0; i<5; i++)
//            {
//                for(j=0; j<5; j++)
//                {
//                    temp1 =0;
//                    
//                    for(k=0; k<784; k++)
//                    {
//                        temp1 = temp1 + tempbobot_c1[ctr][jumplane_c1][k];
//                    }
//                    dbobot_c1[jumplane_c1][i][j] = temp1*alpha;
//                    ctr++;
//                }
//            }
//        }
//        
//        for(jumplane_c1=0; jumplane_c1<6; jumplane_c1++)
//        {
//            temp1 = 0;
//            
//            for(i=0; i<28; i++)
//            {
//                for(j=0; j<28; j++)
//                {
//                    temp1 = temp1 + gradienc1[jumplane_c1][i][j];
//                }
//            }
//            dbias_c1[jumplane_c1] = alpha*temp1;
//        }
//    
//    }
//    
//    
//    private void updatebobot_bias()
//    {
//        UpdateBobot_C1();
//        UpdateBias_C1();
//        UpdateBobot_S2();
//        UpdateBias_S2();
//        UpdateBobot_C3();
//        UpdateBias_C3();
//        UpdateBobot_S4();
//        UpdateBias_S4();
//        UpdateBobot_C5();
//        UpdateBias_C5();
//        UpdateBobot_F6();
//        UpdateBias_F6();    
//    }
//    
//    private void UpdateBobot_C1()
//    {
//        
//        int i,j,k;
//        
//        for(i=0; i<6; i++)
//        {
//            for(j=0; j<5; j++)
//            {
//                for(k=0; k<5; k++)
//                {
//                    bobot_c1[i][j][k] = bobot_c1[i][j][k] + dbobot_c1[i][j][k];
//                }
//            }
//        }
//    }
//    
//    private void UpdateBias_C1()
//    {
//        int jumplane_c1;
//        
//        for(jumplane_c1 = 0; jumplane_c1<6; jumplane_c1++)
//        {
//            bias_c1[jumplane_c1] = bias_c1[jumplane_c1] + dbias_c1[jumplane_c1];
//        }
//    }
//    
//    private void UpdateBobot_S2()
//    {
//        int jumplane_s2;
//        
//        for(jumplane_s2 = 0; jumplane_s2 <6; jumplane_s2++)
//        {
//            bobot_s2[jumplane_s2] = bobot_s2[jumplane_s2] + dbobot_s2[jumplane_s2];
//        }
//    }
//    
//    private void UpdateBias_S2()
//    {
//        int jumplane_s2;
//        
//        for(jumplane_s2 = 0; jumplane_s2<6; jumplane_s2++)
//        {
//            bias_s2[jumplane_s2] = bias_s2[jumplane_s2] + dbias_s2[jumplane_s2];
//        }
//    }
//    
//    private void UpdateBobot_C3()
//    {
//        int i,j,k,ss2,index;
//        char[] charArr;
//        String[] result = bm.inisialisasi();
//        
//        for(i=0; i<16; i++)
//        {
//            charArr = result[i].toCharArray();
//            
//            for(ss2 = 0; ss2 < charArr.length; ss2++)
//            {
//                index = Integer.parseInt(Character.toString(charArr[ss2]));
//                
//                for(j=0; j<5; j++)
//                {
//                    for(k=0; k<5; k++)
//                    {
//                        bobot_c3[index][i][j][k] = bobot_c3[index][i][j][k] + dbobot_c3[index][i][j][k];
//                    }
//                }
//            }
//        }
//    }
//    
//    private void UpdateBias_C3()
//    {
//        int jumplane_c3;
//        
//        for(jumplane_c3 = 0; jumplane_c3<16; jumplane_c3++)
//        {
//            bias_c3[jumplane_c3] = bias_c3[jumplane_c3] + dbias_c3[jumplane_c3];
//        }
//    }
//    
//    private void UpdateBobot_S4()
//    {
//        int jumplane_s4;
//        
//        for(jumplane_s4 = 0; jumplane_s4 <16; jumplane_s4++)
//        {
//            bobot_s4[jumplane_s4] = bobot_s4[jumplane_s4] + dbobot_s4[jumplane_s4];
//        }
//    }
//    
//    private void UpdateBias_S4()
//    {
//        int jumplane_s4;
//        
//        for(jumplane_s4 = 0; jumplane_s4<16; jumplane_s4++)
//        {
//            bias_s4[jumplane_s4] = bias_s4[jumplane_s4] + dbias_s4[jumplane_s4];
//        }
//    }
//    
//    private void UpdateBobot_C5()
//    {
//        int i,j,k;
//        
//        for(i=0; i<120; i++)
//        {
//            for(j=0; j<16; j++)
//            {
//                for(k=0;k<25;k++)
//                {
//                    bobot_c5[j][k][i] = bobot_c5[j][k][i] + dbobot_c5[j][k][i];
//                }
//            }
//        }
//    }
//    
//    private void UpdateBias_C5()
//    {
//        int i;
//        
//        for(i=0; i<120; i++)
//        {
//            bias_c5[i] = bias_c5[i]+dbias_c5[i];
//        }
//    }
//    
//    private void UpdateBobot_F6()
//    {
//        int i,j;
//        
//        for(j=0; j<84; j++)
//        {
//            for(i=0; i<120; i++)
//            {
//                bobot_f6[i][j] = bobot_f6[i][j] + dbobot_f6[i][j];
//            }
//        }
//    }
//    
//    private void UpdateBias_F6()
//    {
//        int i;
//        
//        for(i=0; i<84; i++)
//        {
//            bias_f6[i] = bias_f6[i] + dbias_f6[i];
//        }
//    }
//    
//    
//    
//    
//    
//    //TESTING CNN
//    
//    public void testing(formTesting uites, int awal, int akhir)throws FileNotFoundException, IOException
//    {
//        int i,j,inc,hsl,dikenali,jumlahdatatest;
//        String[] nmfile;
//        double min;
//        float akurasitotal,persen,akurasiAngka,total;
//        
//        int[] akurasiPerAngka = new int[12];
//        int[] gagalPerAngka = new int[12];
//        
//        String[] dirImage = new String[12];
//        int[] label = new int[12];
//        
//        int[] lblgmbrbenar = new int[akhir-awal];
//        int[] lblgmbrgagal = new int[akhir-awal];
//        int[] nogambargagal = new int[akhir-awal];
//        
//        //get image as input
////        dirImage = im.GetTestImageFile();
////        im.SetTestImageLabel();
////        label = im.GetLabelTest();
////        jum = akhir - awal;
//        
//        dirImage = im.getinput_test();
//        im.setimagelabel_test();
//        label = im.getlabel_test();
//        
//        jumlahdatatest = akhir - awal;
//        
//        if(jumlahdatatest > dirImage.length)
//        {
//            displayalertoutofrange();
//        }
//        else
//        {
//            for(i=0; i<12; i++)
//            {
//                akurasiPerAngka[i] = 0;
//                gagalPerAngka[i] = 0;
//            }
//            
//            //get bobot from file
//            
//            //setbobotTest();
//            
//            bobot_testing();
//            
//            inc = 0;
//            
//            for(i = awal; i<akhir; i++)
//            {
//                hsl = 0;
//                min = 9999;
//                
//                try
//                {
//                    im.SetInput(dirImage[i]);
//                    input = im.getinput2DM();
//                }
//                catch (IOException ex)
//                {
//                    Logger.getLogger(convnet.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//                feedforward();
//            
//                for(j=0; j<12; j++)
//                {
//                    if(output[j]<min)
//                    {
//                        min = output[j];
//                        hsl = j;
//                        System.out.println("masuk dak nih");
//                    }
//                    
//                    System.out.println("output "+output[j]);
//                    System.out.println("hasil "+hsl);
//                }
//                
//                akurasiPerAngka[label[i]] = akurasiPerAngka[label[i]]+1; //hitung banyak dataset per angka
//                
//                if(label[i] != hsl)
//                {
//                    gagalPerAngka[hsl] = gagalPerAngka[hsl]+1; //hitung kegagalan per angka
//                    lblgmbrbenar[inc] = label[i]; // menampung label yang seharusnya
//                    lblgmbrgagal[inc] = hsl; //menampung label yang gagal dikenali
//                    nogambargagal[inc] = (i+1); //menampung nomer gambar yang gagal
//                    inc++; //hitung kegagalan keseluruhan
//                }
//            }
//            
//            nmfile = im.filegambargagal(nogambargagal);
//            uites.setData(lblgmbrgagal, lblgmbrbenar, nmfile);
//            uites.setImage(0, inc);
//            
//            for(i=0; i<12; i++)
//            {
//                dikenali = (akurasiPerAngka[i] - gagalPerAngka[i]);
//                persen = (float) dikenali/akurasiPerAngka[i];
//                akurasiAngka = (float) persen * 100 ;
//                
//                if(i==0)
//                {
//                    uites.jum_a.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal_a.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil_a.setText(Integer.toString(dikenali));
//                    uites.persen_a.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==1)
//                {
//                    uites.jum_i.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal_i.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil_i.setText(Integer.toString(dikenali));
//                    uites.persen_i.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==2)
//                {
//                    uites.jum_u.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal_u.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil_u.setText(Integer.toString(dikenali));
//                    uites.persen_u.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==3)
//                {
//                    uites.jum_e.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal_e.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil_e.setText(Integer.toString(dikenali));
//                    uites.persen_e.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==4)
//                {
//                    uites.jum_o.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal_o.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil_o.setText(Integer.toString(dikenali));
//                    uites.persen_o.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==5)
//                {
//                    uites.jum_ka.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal_ka.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil_ka.setText(Integer.toString(dikenali));
//                    uites.persen_ka.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==6)
//                {
//                    uites.jum_ki.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal_ki.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil_ki.setText(Integer.toString(dikenali));
//                    uites.persen_ki.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==7)
//                {
//                    uites.jum_ku.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal_ku.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil_ku.setText(Integer.toString(dikenali));
//                    uites.persen_ku.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==8)
//                {
//                    uites.jum_ke.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal_ke.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil_ke.setText(Integer.toString(dikenali));
//                    uites.persen_ke.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==9)
//                {
//                    uites.jum_ko.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal_ko.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil_ko.setText(Integer.toString(dikenali));
//                    uites.persen_ko.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==10)
//                {
//                    uites.jum_sa.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal_sa.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil_sa.setText(Integer.toString(dikenali));
//                    uites.persen_sa.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==11)
//                {
//                    uites.jum_shi.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal_shi.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil_shi.setText(Integer.toString(dikenali));
//                    uites.persen_shi.setText(Float.toString(akurasiAngka));
//                }
//            }
//            
//            total = (float) (akhir-inc)/akhir;
//            akurasitotal = (float) total * 100;
//            
//            
//            uites.totalgambar.setText(" "+(akhir-awal));
//            uites.totalberhasil.setText(" "+((akhir-inc)-awal));
//            uites.totalgagal.setText(" "+inc);
//            uites.totalpersen.setText(" "+akurasitotal+"%");
//            
//        }    
//    }
//    
////    private void feedforward()
////    {
////        Layer_C1();
////        Layer_S2();
////        Layer_C3();
////        Layer_S4();
////        Layer_C5();
////        Layer_F6();
////        Layer_Output();
////    }
//    
//    //FEEFORWARD
//    
////    private void Layer_C1()
////    {
////        int jumplane_c1,i,j,k,l,x,y;
////        double temp1,tampungan;
////        
////        for(jumplane_c1 = 0; jumplane_c1<6;jumplane_c1++)
////        {
////            for(i=0;i<28;i++)
////            {
////                for(j=0; j<28; j++)
////                {
////                    temp1 = 0;
////                    x = 0;
////                    
////                    for(k=j;k<=j+4;k++)
////                    {
////                        y=0;
////                        
////                        for(l=i; l<=i+4;l++)
////                        {
////                            if(input[k][l]==0)
////                            {
////                                temp1 = temp1 + (1.175*bobot_c1[jumplane_c1][x][y]);
////                            }
////                            else
////                            {
////                                temp1 = temp1 + (-0.1 * bobot_c1[jumplane_c1][x][y]);
////                            }
////                            y++;
////                        }
////                        x++;
////                    }
////                    
////                    tampungan = (temp1+bias_c1[jumplane_c1]);
////                    c1[jumplane_c1][i][j] = 1.7159 * Math.tanh(0.667 * tampungan);
////                }
////            }
////        }
////    }
////    
////    private void Layer_S2()
////    {
////        int jumplane_s2,baris,kolom,i,j,bar,kol;
////        double temp1, temp2;
////        
////        for(jumplane_s2 = 0; jumplane_s2<6; jumplane_s2++)
////        {
////            baris = 0;
////            kolom = 0;
////            
////            for(i=0; i<14;i++)
////            {
////                for(j=0; j<14; j++)
////                {
////                    temp1 = 0;
////                    
////                    for(bar = baris; bar<baris+2; bar++)
////                    {
////                        for(kol = kolom; kol<kolom+2; kol++)
////                        {
////                            temp1 = temp1 + c1[jumplane_s2][bar][kol];
////                        }
////                    }
////                    
////                    temp2 = ((temp1/4) * bobot_s2[jumplane_s2])+bias_s2[jumplane_s2];
////                    s2[jumplane_s2][i][j] = 1.7159 * Math.tanh(0.667 * temp2);
////                    kolom = kolom+2;
////                }
////                baris = baris+2;
////                kolom = 0;
////            }
////        }
////    }
////    
////    private void Layer_C3()
////    {
////        int i,j,k,l,m,ss2,index,x,y;
////        double temp1,temp2,tot;
////        char[] charArr;
////        
////        String[] result = bm.inisialisasi();
////        
////        for(i=0; i<16; i++)
////        {
////            charArr = result[i].toCharArray();
////            
////            for(j=0; j<10; j++)
////            {
////                for(k=0; k<10; k++)
////                {
////                    tot = 0;
////                    
////                    for(ss2 = 0; ss2<charArr.length; ss2++)
////                    {
////                        index = Integer.parseInt(Character.toString(charArr[ss2]));
////                        temp1 = 0;
////                        x = 0;
////                        
////                        for(l=k; l<=k+4; l++)
////                        {
////                            y=0;
////                            for(m = j; m<=j+4; m++)
////                            {
////                                temp1= temp1 + s2[index][l][m] * bobot_c3[index][i][x][y];
////                                y++;
////                            }
////                            x++;
////                        }
////                        tot = tot+temp1;
////                    }
////                    temp2 = tot + bias_c3[i];
////                    c3[i][j][k] = 1.7159 * Math.tanh(0.0667 * temp2);
////                }
////            }
////        }
////    }
////    
////    private void Layer_S4()
////    {
////        int jumplane_s4, baris,kolom,i,j,bar,kol;
////        double temp1, temp2;
////        
////        for(jumplane_s4 = 0; jumplane_s4<16; jumplane_s4++)
////        {
////            baris = 0;
////            kolom = 0;
////            for(i=0; i<5; i++)
////            {
////                for(j=0; j<5; j++)
////                {
////                    temp1 = 0;
////                    
////                    for(bar = baris; bar<baris+2; bar++)
////                    {
////                        for(kol = kolom; kol<kolom+2; kol++)
////                        {
////                            temp1 = temp1+c3[jumplane_s4][bar][kol];
////                        }
////                    }
////                    
////                    temp2 = (temp1*bobot_s4[jumplane_s4])+bias_s4[jumplane_s4];
////                    s4[jumplane_s4][i][j] = 1.7159 * Math.tanh(0.667 * temp2);
////                    kolom = kolom+2;
////                }
////                baris = baris+2;
////                kolom = 0;
////            }   
////        }
////    }
////    
////    private void Layer_C5()
////    {
////        int i,j,k,l,ctr;
////        double temp1, temp2, temp3;
////        
////        for(i=0; i<120; i++)
////        {
////            temp2 = 0;
////            
////            for(j=0; j<16; j++)
////            {
////                temp1 = 0;
////                ctr = 0;
////                
////                for(k=0; k<5; k++)
////                {
////                    for(l=0; l<5; l++)
////                    {
////                        temp1 = temp1 + s4[j][k][l] * bobot_c5[j][ctr][i];
////                        ctr++;
////                    }
////                }
////                temp2 = temp2 + temp1;
////            }
////            temp3 = temp2 + bias_c5[i];
////            c5[i] = 1.7159 * Math.tanh(0.667 * temp3);
////        }
////    }
////    
////    private void Layer_F6()
////    {
////        int i,j;
////        double temp1, temp2, temp3;
////        
////        for(j=0; j<84; j++)
////        {
////            temp2 = 0;
////            
////            for(i=0; i<120; i++)
////            {
////                temp1 = c5[i] * bobot_f6[i][j];
////                temp2 = temp2 + temp1;
////            }
////            temp3 = temp2 + bias_f6[j];
////            f6[j] = 1.7159 * Math.tanh(0.667 * temp3);
////        }
////    }
////    
////    private void Layer_Output()
////    {
////        int i,j;
////        double[][] target84 = new double[2][84];
////        double power;
////        
////        bm.SetTarget84();
////        target84 = bm.GetTarget();
////        
////        for(j=0; j<2; j++)
////        {
////            output[j] = 0;
////            power = 0.0;
////            
////            for(i=0; i<84; i++)
////            {
////                power = power + Math.pow(f6[i] - target84[j][i], 2);
////            }
////            output[j] = power;
////        }
////    }
//    
////    private void gradienBP(int label)
////    {
////        EBP_LayerF6(label);
////        EBP_LayerC5();
////        EBP_LayerS4();
////        EBP_LayerC3();
////        EBP_LayerS2();
////        EBP_LayerC1();
////    }
//    
//    private double derivative(double c)
//    {
//        double d = 1.7159 * 0.667 * (1 - Math.pow(Math.tanh(0.667 * c), 2));
//        return d;
//    }
//    
////    private void EBP_LayerF6(int label)
////    {
////        int i,j,out;
////        double t1,eror,aksen;
////        double target84[][] = new double[2][84];
////        
////        bm.SetTarget84();
////        target84 = bm.GetTarget();
////        
////        for(i=0; i<84; i++)
////        {
////            t1 = target84[label][i];
////            eror =  t1-f6[i];
////            aksen = derivative(f6[i]);
////            gradienf6[i] = eror*aksen;
////            
////            for(j=0; j<120; j++)
////            {
////                dbobot_f6[j][i] = alpha*c5[j]*gradienf6[i];
////            }
////            dbias_f6[i] = alpha*gradienf6[i];
////        }
////    }
////    
////    private void EBP_LayerC5()
////    {
////        int i,j,k,l,ctr;
////        double temp,aksen;
////        
////        for(i=0; i<120; i++)
////        {
////            
////            temp = 0;
////            for(j=0; j<84; j++)
////            {
////                temp = temp+bobot_f6[i][j]*gradienf6[j];
////            }
////            
////            aksen = derivative(c5[i]);
////            gradienc5[i] = aksen*temp;
////        }
////        
////        //delta w c5
////        
////        for(i=0; i<120; i++)
////        {
////            for(j=0; j<16; j++)
////            {
////                
////                ctr = 0;
////                for(k=0; k<5; k++)
////                {
////                    for(l=0; l<5; l++)
////                    {
////                        dbobot_c5[j][ctr][i] = alpha*s4[j][k][l]*gradienc5[i];
////                        ctr++;
////                    }
////                }
////            }
////            dbias_c5[i] = alpha*gradienc5[i]; //delta bias c5
////        }
////    }
////    
////    private void EBP_LayerS4()
////    {
////        int jumplane_s4,baris,kolom,i,j,bar,kol,k,ctr;
////        double din_s4[][][] = new double[16][5][5];
////        double temp1,aksen;
////        
////        //inisialisasi temp=0
////        
////        for(jumplane_s4 = 0; jumplane_s4<16; jumplane_s4++)
////        {
////            for(i=0; i<5; i++)
////            {
////                for(j=0; j<5; j++)
////                {
////                    din_s4[jumplane_s4][i][j] = 0;
////                }
////            }
////        }
////        
////        //tampung total gradien k dan bobot k yang masuk, cari sigma
////        
////        for(k=0; k<120; k++)
////        {
////            for(jumplane_s4 = 0; jumplane_s4<16; jumplane_s4++)
////            {
////                ctr = 0;
////                
////                for(i=0; i<5; i++)
////                {
////                    for(j=0; j<5; j++)
////                    {
////                        din_s4[jumplane_s4][i][j] = din_s4[jumplane_s4][i][j] + bobot_c5[jumplane_s4][ctr][k] * gradienc5[k];
////                        ctr++;
////                    }
////                }
////            }
////        }
////        
////        //cari gradien s4
////        
////        for(jumplane_s4 = 0; jumplane_s4<16; jumplane_s4++)
////        {
////            for(i=0; i<5; i++)
////            {
////                for(j=0; j<5; j++)
////                {
////                    aksen = derivative(s4[jumplane_s4][i][j]);
////                    gradiens4[jumplane_s4][i][j] = din_s4[jumplane_s4][i][j]*aksen;
////                }
////            }
////        }
////        
////        //delta w s4
////        
////        for(jumplane_s4=0; jumplane_s4<16; jumplane_s4++)
////        {
////            baris = 0;
////            kolom = 0;
////            dbobot_s4[jumplane_s4] = 0;
////            
////            for(i=0; i<5; i++)
////            {
////                for(j=0; j<5; j++)
////                {
////                    temp1 = 0;
////                    for(bar = baris; bar<baris+2; bar++)
////                    {
////                        for(kol = kolom; kol<kolom+2; kol++)
////                        {
////                            temp1 = temp1 + c3[jumplane_s4][bar][kol];
////                        }
////                    }
////                    dbobot_s4[jumplane_s4] = dbobot_s4[jumplane_s4] + temp1*gradiens4[jumplane_s4][i][j];
////                    kolom = kolom+2;
////                }
////                baris = baris+2;
////                kolom = 0;
////            }
////            dbobot_s4[jumplane_s4] = alpha*dbobot_s4[jumplane_s4];
////        }
////        
////        //delta bias s4
////        
////        for(jumplane_s4 = 0; jumplane_s4<16; jumplane_s4++)
////        {
////            dbias_s4[jumplane_s4] = 0;
////            for(i=0;i<5; i++)
////            {
////                for(j=0; j<5; j++)
////                {
////                    dbias_s4[jumplane_s4] = dbias_s4[jumplane_s4] + gradiens4[jumplane_s4][i][j];
////                }
////            }
////            dbias_s4[jumplane_s4] = alpha*dbias_s4[jumplane_s4];
////        }    
////    }
////    
////    private void EBP_LayerC3()
////    {
////        int i,j,k,l,ctr,ii,ctr2,index,bar,baris,kol,kolom;
////        double din_c3[][][] = new double[16][10][10];
////        double tempbobot_c3[][][][] = new double [6][25][16][100]; 
////        char[] charArr;
////        double temp;
////        double aksen;
////        
////        for(i=0;i<16;i++)
////        {
////            for(j=0; j<10; j++)
////            {
////                for(k=0; k<10; k++)
////                {
////                    din_c3[i][j][k] = 0;
////                }
////            }
////        }
////        
////        for(i=0; i<16; i++)
////        {
////            baris = 0;
////            kolom = 0;
////            
////            for(j=0; j<5; j++)
////            {
////                for(k=0; k<5; k++)
////                {
////                    for(bar = baris; bar<baris+2; bar++)
////                    {
////                        for(kol = kolom; kol<kolom+2; kol++)
////                        {
////                            din_c3[i][bar][kol] = din_c3[i][bar][kol] + bobot_s4[i] * gradiens4[i][j][k];
////                        }
////                    }
////                    kolom = kolom+2;
////                }
////                baris = baris+2;
////                kolom = 0;
////            }
////        }
////        
////        for(i=0; i<16; i++)
////        {
////            for(j=0; j<10; j++)
////            {
////                for(k=0; k<10; k++)
////                {
////                    aksen = derivative(c3[i][j][k]);
////                    gradienc3[i][j][k] = din_c3[i][j][k] * aksen;
////                }
////            }
////        }
////        
////        //kali alpa dan inputnya
////        
////        String[] result = bm.inisialisasi();
////        
////        for(i=0; i<16; i++)
////        {
////            ctr2 = 0;
////            charArr = result[i].toCharArray();
////            
////            for(j=0; j<10; j++)
////            {
////                for(k=0; k<10; k++)
////                {
////                    for(int ss2 = 0; ss2<charArr.length; ss2++)
////                    {
////                        index = Integer.parseInt(Character.toString(charArr[ss2]));
////                        ctr = 0;
////                        
////                        for(l=k; l<=k+4;l++)
////                        {
////                            for(ii=j; ii<=j+4; ii++)
////                            {
////                                tempbobot_c3[index][ctr][i][ctr2] = gradienc3[i][j][k] * s2[index][l][ii];
////                                ctr++;
////                            }
////                        }
////                    }
////                    ctr2++;
////                }
////            }
////        }
////        
////        for(i=0; i<16; i++)
////        {
////            ctr = 0;
////            
////            for(j=0; j<5; j++)
////            {
////                for(k=0; k<5; k++)
////                {
////                    charArr = result[j].toCharArray();
////                    
////                    for(int ss2 = 0; ss2<charArr.length; ss2++)
////                    {
////                        index= Integer.parseInt(Character.toString(charArr[ss2]));
////                        temp = 0;
////                        
////                        for(l=0; l<100; l++)
////                        {
////                            temp = temp+tempbobot_c3[index][ctr][i][l];
////                        }
////                        dbobot_c3[index][i][j][k] = alpha * temp;
////                    }
////                    ctr++;
////                }
////            }
////        }
////        
////        for(j=0; j<16; j++)
////        {
////            temp = 0;
////            
////            for(k=0; k<10; k++)
////            {
////                for(l=0; l<10; l++)
////                {
////                    temp = temp + gradienc3[j][k][l];
////                }
////            }
////            dbias_c3[j] = alpha * temp;
////        }
////    }
////    
////    private void EBP_LayerS2()
////    {
////        int jumplane_s2, jumplane_c3, baris,kolom,i,j,k,l,bar,kol,index,x,y;
////        double din_s2[][][] = new double[6][14][14];
////        double temp1,aksen;
////        char[] charArr;
////        
////        for(jumplane_s2 = 0; jumplane_s2<6; jumplane_s2++)
////        {
////            for(i=0; i<14; i++)
////            {
////                for(j=0; j<14; j++)
////                {
////                    din_s2[jumplane_s2][i][j] = 0;
////                }
////            }
////        }
////        
////        String[] result = bm.inisialisasi();
////        
////        for(jumplane_c3 = 0; jumplane_c3<16; jumplane_c3++)
////        {
////            for(i=0; i<10; i++)
////            {
////                for(j=0; j<10; j++)
////                {
////                    charArr = result[jumplane_c3].toCharArray();
////                    
////                    for(int ss2 = 0; ss2<charArr.length; ss2++)
////                    {
////                        index = Integer.parseInt(Character.toString(charArr[ss2]));
////                        
////                        x = 0;
////                        
////                        for(k=j; k<=j+4; k++)
////                        {
////                            y = 0;
////                            
////                            for(l=i; l<=i+4; l++)
////                            {
////                                din_s2[index][k][l] = din_s2[index][k][l] + gradienc3[jumplane_c3][i][j]*bobot_c3[index][jumplane_c3][x][y];
////                                y++;
////                            }
////                            x++;
////                        }
////                    }
////                }
////            }
////        }
////            
////        for(jumplane_s2 = 0; jumplane_s2<6; jumplane_s2++)
////        {
////            for(i=0; i<14; i++)
////            {
////                for(j=0; j<14; j++)
////                {
////                    aksen = derivative(s2[jumplane_s2][i][j]);
////                    gradiens2[jumplane_s2][i][j] = din_s2[jumplane_s2][i][j]*aksen;
////                        
////                }
////            }
////        }
////            
////        //cari dbobot s2
////            
////        for(jumplane_s2 = 0; jumplane_s2<6; jumplane_s2++)
////        {
////            baris = 0;
////            kolom = 0;
////            dbobot_s2[jumplane_s2] = 0;
////                
////            for(i=0; i<14; i++)
////            {
////                for(j=0; j<14; j++)
////                {
////                    temp1 = 0;
////                        
////                    for(bar = baris; bar<baris+2; bar++)
////                    {
////                        for(kol = kolom; kol<kolom+2; kol++)
////                        {
////                            temp1 = temp1+c1[jumplane_s2][bar][kol];
////                        }
////                    }
////                        
////                    dbobot_s2[jumplane_s2] = dbobot_s2[jumplane_s2] + temp1*gradiens2[jumplane_s2][i][j];
////                        
////                    kolom = kolom+2;
////                }
////                baris = baris+2;
////                kolom = 0;
////            }
////            dbobot_s2[jumplane_s2] = alpha*dbobot_s2[jumplane_s2];
////        }
////            
////        for(jumplane_s2 = 0; jumplane_s2<6; jumplane_s2++)
////        {
////            dbias_s2[jumplane_s2] = 0;
////                
////            for(i=0; i<14; i++)
////            {
////                for(j=0; j<14; j++)
////                {
////                    dbias_s2[jumplane_s2] = dbias_s2[jumplane_s2] + gradiens2[jumplane_s2][i][j];
////                }
////            }
////            dbias_s2[jumplane_s2] = alpha*dbias_s2[jumplane_s2];
////        }
////    }
////    
////    private void EBP_LayerC1()
////    {
////        int jumplane_c1,i,j,k,l,ctr,ctr2,baris,kolom,bar,kol;
////        double tempbobot_c1[][][] = new double[25][6][784];
////        double din_c1[][][] = new double[6][28][28];
////        double temp1,aksen;
////        
////        for(jumplane_c1 = 0; jumplane_c1<6; jumplane_c1++)
////        {
////            baris = 0;
////            kolom = 0;
////            
////            for(i=0; i<14;i++)
////            {
////                for(j=0; j<14; j++)
////                {
////                    for(bar = baris; bar<baris+2; bar++)
////                    {
////                        for(kol = kolom; kol<kolom+2; kol++)
////                        {
////                            din_c1[jumplane_c1][bar][kol] = bobot_s2[jumplane_c1] * gradiens2[jumplane_c1][i][j];
////                        }
////                    }
////                    kolom = kolom+2;
////                }
////                baris = baris+2;
////                kolom = 0;
////            }
////        }
////        
////        for(jumplane_c1 = 0; jumplane_c1<6; jumplane_c1++)
////        {
////            for(i=0;i<28;i++)
////            {
////                for(j=0; j<28; j++)
////                {
////                    aksen = derivative(c1[jumplane_c1][i][j]);
////                    gradienc1[jumplane_c1][i][j] = din_c1[jumplane_c1][i][j]*aksen;
////                }
////            }
////        }
////        
////        for(jumplane_c1 = 0; jumplane_c1<6; jumplane_c1++)
////        {
////            ctr2 = 0;
////            
////            for(i=0; i<28; i++)
////            {
////                for(j=0; j<28; j++)
////                {
////                    ctr = 0;
////                    
////                    for(k=j; k<=j+4; k++)
////                    {
////                        for(l=i; l<=i+4; l++)
////                        {
////                            if(input[k][l]==0)
////                            {
////                                tempbobot_c1[ctr][jumplane_c1][ctr2] = 1.175 * gradienc1[jumplane_c1][i][j];
////                            }
////                            else
////                            {
////                                tempbobot_c1[ctr][jumplane_c1][ctr2] = -0.1 * gradienc1[jumplane_c1][i][j];
////                            }
////                            ctr++;
////                        }
////                    }
////                    ctr2++;
////                }
////            }
////        }
////        
////        for(jumplane_c1 = 0; jumplane_c1<6; jumplane_c1++)
////        {
////            ctr = 0;
////            
////            for(i=0; i<5; i++)
////            {
////                for(j=0; j<5; j++)
////                {
////                    temp1 =0;
////                    
////                    for(k=0; k<784; k++)
////                    {
////                        temp1 = temp1 + tempbobot_c1[ctr][jumplane_c1][k];
////                    }
////                    dbobot_c1[jumplane_c1][i][j] = temp1*alpha;
////                    ctr++;
////                }
////            }
////        }
////        
////        for(jumplane_c1=0; jumplane_c1<6; jumplane_c1++)
////        {
////            temp1 = 0;
////            
////            for(i=0; i<28; i++)
////            {
////                for(j=0; j<28; j++)
////                {
////                    temp1 = temp1 + gradienc1[jumplane_c1][i][j];
////                }
////            }
////            dbias_c1[jumplane_c1] = alpha*temp1;
////        }
////    
////    }
////    
////    private void updatebobot_bias()
////    {
////        UpdateBobot_C1();
////        UpdateBias_C1();
////        UpdateBobot_S2();
////        UpdateBias_S2();
////        UpdateBobot_C3();
////        UpdateBias_C3();
////        UpdateBobot_S4();
////        UpdateBias_S4();
////        UpdateBobot_C5();
////        UpdateBias_C5();
////        UpdateBobot_F6();
////        UpdateBias_F6();    
////    }
//    
////    UPDATE BOBOT
////    
////    private void UpdateBobot_C1()
////    {
////        
////        int i,j,k;
////        
////        for(i=0; i<6; i++)
////        {
////            for(j=0; j<5; j++)
////            {
////                for(k=0; k<5; k++)
////                {
////                    bobot_c1[i][j][k] = bobot_c1[i][j][k] + dbobot_c1[i][j][k];
////                }
////            }
////        }
////    }
////    
////    private void UpdateBias_C1()
////    {
////        int jumplane_c1;
////        
////        for(jumplane_c1 = 0; jumplane_c1<6; jumplane_c1++)
////        {
////            bias_c1[jumplane_c1] = bias_c1[jumplane_c1] + dbias_c1[jumplane_c1];
////        }
////    }
////    
////    private void UpdateBobot_S2()
////    {
////        int jumplane_s2;
////        
////        for(jumplane_s2 = 0; jumplane_s2 <6; jumplane_s2++)
////        {
////            bobot_s2[jumplane_s2] = bobot_s2[jumplane_s2] + dbobot_s2[jumplane_s2];
////        }
////    }
////    
////    private void UpdateBias_S2()
////    {
////        int jumplane_s2;
////        
////        for(jumplane_s2 = 0; jumplane_s2<6; jumplane_s2++)
////        {
////            bias_s2[jumplane_s2] = bias_s2[jumplane_s2] + dbias_s2[jumplane_s2];
////        }
////    }
////    
////    private void UpdateBobot_C3()
////    {
////        int i,j,k,ss2,index;
////        char[] charArr;
////        String[] result = bm.inisialisasi();
////        
////        for(i=0; i<16; i++)
////        {
////            charArr = result[i].toCharArray();
////            
////            for(ss2 = 0; ss2 < charArr.length; ss2++)
////            {
////                index = Integer.parseInt(Character.toString(charArr[ss2]));
////                
////                for(j=0; j<5; j++)
////                {
////                    for(k=0; k<5; k++)
////                    {
////                        bobot_c3[index][i][j][k] = bobot_c3[index][i][j][k] + dbobot_c3[index][i][j][k];
////                    }
////                }
////            }
////        }
////    }
////    
////    private void UpdateBias_C3()
////    {
////        int jumplane_c3;
////        
////        for(jumplane_c3 = 0; jumplane_c3<16; jumplane_c3++)
////        {
////            bias_c3[jumplane_c3] = bias_c3[jumplane_c3] + dbias_c3[jumplane_c3];
////        }
////    }
////    
////    private void UpdateBobot_S4()
////    {
////        int jumplane_s4;
////        
////        for(jumplane_s4 = 0; jumplane_s4 <16; jumplane_s4++)
////        {
////            bobot_s4[jumplane_s4] = bobot_s4[jumplane_s4] + dbobot_s4[jumplane_s4];
////        }
////    }
////    
////    private void UpdateBias_S4()
////    {
////        int jumplane_s4;
////        
////        for(jumplane_s4 = 0; jumplane_s4<16; jumplane_s4++)
////        {
////            bias_s4[jumplane_s4] = bias_s4[jumplane_s4] + dbias_s4[jumplane_s4];
////        }
////    }
////    
////    private void UpdateBobot_C5()
////    {
////        int i,j,k;
////        
////        for(i=0; i<120; i++)
////        {
////            for(j=0; j<16; j++)
////            {
////                for(k=0;k<25;k++)
////                {
////                    bobot_c5[j][k][i] = bobot_c5[j][k][i] + dbobot_c5[j][k][i];
////                }
////            }
////        }
////    }
////    
////    private void UpdateBias_C5()
////    {
////        int i;
////        
////        for(i=0; i<120; i++)
////        {
////            bias_c5[i] = bias_c5[i]+dbias_c5[i];
////        }
////    }
////    
////    private void UpdateBobot_F6()
////    {
////        int i,j;
////        
////        for(j=0; j<84; j++)
////        {
////            for(i=0; i<120; i++)
////            {
////                bobot_f6[i][j] = bobot_f6[i][j] + dbobot_f6[i][j];
////            }
////        }
////    }
////    
////    private void UpdateBias_F6()
////    {
////        int i;
////        
////        for(i=0; i<84; i++)
////        {
////            bias_f6[i] = bias_f6[i] + dbias_f6[i];
////        }
////    }
////    
////    
////    //GET FILE NAME FOR SAVE AND GET KNOWLEDGE
////    
////    public String[] getFileName()
////    {
////        String fileName[] = new String[12];
////        
////        fileName[0] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/bobotc1.txt";
////        fileName[1] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/biasc1.txt";
////        fileName[2] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/bobots2.txt";
////        fileName[3] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/biass2.txt";
////        fileName[4] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/bobotc3.txt";
////        fileName[5] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/biasc3.txt";
////        fileName[6] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/bobots4.txt";
////        fileName[7] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/biass4.txt";
////        fileName[8] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/bobotc5.txt";
////        fileName[9] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/biasc5.txt";
////        fileName[10] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/bobotf6.txt";
////        fileName[11] = "D://TUGAS AKHIR 2/DATASET JEPANG/bobot_bias_train/biasf6.txt";
////    
////        return fileName;        
////    }
////    
    
    private void simpanbobot_bias()
    {
        String tempfileName[] = new String[12];
        tempfileName = bm.getfilename_update();
        
        bm.simpanBobot_C1(tempfileName[0], bobot_c1);
        bm.simpanBias_C1(tempfileName[1], bias_c1);
        
        bm.simpanBobot_S2(tempfileName[2], bobot_s2);
        bm.simpanBias_S2(tempfileName[3], bias_s2);
        
        bm.simpanBobot_C3(tempfileName[4], bobot_c3);
        bm.simpanBias_C3(tempfileName[5], bias_c3);
        
        bm.simpanBobot_S4(tempfileName[6], bobot_s4);
        bm.simpanBias_S4(tempfileName[7], bias_s4);
        
        bm.simpanBobot_C5(tempfileName[8], bobot_c5);
        bm.simpanBias_C5(tempfileName[9], bias_c5);
        
        bm.simpanBobot_F6(tempfileName[10], bobot_f6);
        bm.simpanBias_F6(tempfileName[11], bias_f6);    
    }
    
    
    
    
    
    
    private void displayalertparam()
    {
        JOptionPane.showMessageDialog(null, "Parameter belum terinisialisasi");
    }
    
    private void displayalertoutofrange()
    {
        JOptionPane.showMessageDialog(null, "Maaf masukan anda melebihi jumlah data set");
    }
    
    
    // dari kak desti
    
    public void training() throws IOException
    {
        int i,n,inc,index;
        double err,mse;
        double EConvergen=(double) 0.1 ;
        String[] dirImage=new String[644];
        int[] label=new int[644];


        //get image as input
        n=644;
//        dirImage=im.GetImageFile();
//        im.SetImageLabel();
//        label=im.GetLabel();
        
        dirImage = im.getinput_train();
        im.setimagelabel_train();
        label = im.getlabel_train();
        

        //setbobot_biasRandom();
        setbobotTest();
        
        inc=1;
        
        mse=999999;
        while(mse>EConvergen)
        {
            if(inc<=2)
            {
               alpha=(double) 0.0005;
            }
            else if(inc<=5)
            {
                alpha=(double) 0.0002;
            }
            else if(inc<=8)
            {
                alpha=(double) 0.0001;
            }
            else if(inc<=12)
            {
                alpha=(double) 0.00005;
            }
            else
            {
                alpha=(double) 0.00001;
            }

            err=0;
            for(i=0;i<n;i++)
            {   
                try {
                    im.SetInput(dirImage[i]);
                    input=im.getinput2DM();
                } catch (IOException ex) {
                    Logger.getLogger(convnet.class.getName()).log(Level.SEVERE, null, ex);
                }
                index = label[i];
                feedforward();
                
                err = 0;
                
                for (i=0; i<n; i++)
                {
                        err = (double) (err + output[index]); 
                }

                mse = err/n;
                //err = (double) (err + output[index]);
                //mse = err/(i+1);
              //  System.out.println("mse-"+inc+"-["+(i+1)+"] : "+mse);
                gradienBP(index);
                updatebobot_bias();
            }
            System.out.println("err:"+err+" |  mse:"+inc+"|["+(i)+"] : "+mse);
            simpanbobot_bias();
            inc++;
        }
    }
    
//   public void testing(formTesting uites, int awal, int akhir) throws FileNotFoundException, IOException
//    {
//        int i,j,inc,hsl,dikenali;
//        String[] nmfile;
//        double min;
//        float akurasitotal,persen,akurasiAngka,total;
//        int[] akurasiPerAngka=new int[71];
//        int[] gagalPerAngka=new int[71];
//        String[] dirImage=new String[213];
//        int[] label=new int[213];
//        int[] lblgmbrbenar=new int[akhir-awal];
//        int[] lblgmbrgagal=new int[akhir-awal];
//        int[] nogambargagal=new int[akhir-awal];
//
//
//        //get image as input
////        dirImage=im.GetTestImageFile();
////        im.SetTestImageLabel();
////        label=im.GetLabelTest();
//        
//        dirImage = im.getinput_test();
//        im.setimagelabel_test();
//        label = im.getlabel_test();
//
//        for(i=0;i<71;i++)
//        {
//            akurasiPerAngka[i]=0;
//            gagalPerAngka[i]=0;
//        }
//
//        //get bobot from file
//        //setbobotTest();
//        
//        bobot_testing();
//
//            inc=0;
//            for(i=awal;i<akhir;i++)
//            {
//                hsl=0;
//                min=9999;
//                try {
//                    im.SetInput(dirImage[i]);
//                    input=im.getinput2DM();
//                } catch (IOException ex) {
//                    Logger.getLogger(convnet.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                    feedforward();
//
//                    for(j=0;j<71;j++)
//                    {
//                        if (output[j]< min )
//                        {
//                            min=output[j];
//                            hsl=j;
//                        }
//                    }
//                    akurasiPerAngka[label[i]]=akurasiPerAngka[label[i]]+1; //hitung banyak data set per Angka
//                    if(label[i]!=hsl)
//                    {
//                        gagalPerAngka[hsl]=gagalPerAngka[hsl]+1; //hitung kegagalan per Angka
//                        
//                        lblgmbrbenar[inc]=label[i]; //menampung label yang seharusnya
//                        lblgmbrgagal[inc]=hsl;   //menampung label yang gagal dikenali
//                        nogambargagal[inc]=(i+1);   //menampung nomer gambar yang gagal
//                        inc++;  //hitung kegagalan keseluruhan
//                    }
//            }
//            nmfile=im.filegambargagal(nogambargagal);
//            uites.setData(lblgmbrgagal, lblgmbrbenar,nmfile);
//            
//            for(i=0;i<71;i++)
//            {
//                dikenali=(akurasiPerAngka[i]- gagalPerAngka[i]);
//                persen=(float)dikenali/akurasiPerAngka[i];
//                akurasiAngka=(float)persen*100;
//
//                if(i==0)
//                {
//                    uites.jum_a.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal_a.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil_a.setText(Integer.toString(dikenali));
//                    uites.persen_a.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==1)
//                {
//                    uites.jum_i.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal_i.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil_i.setText(Integer.toString(dikenali));
//                    uites.persen_i.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==2)
//                {
//                    uites.jum_u.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal_u.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil_u.setText(Integer.toString(dikenali));
//                    uites.persen_u.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==3)
//                {
//                    uites.jum_e.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal_e.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil_e.setText(Integer.toString(dikenali));
//                    uites.persen_e.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==4)
//                {
//                    uites.jum_o.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal_o.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil_o.setText(Integer.toString(dikenali));
//                    uites.persen_o.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==5)
//                {
//                    uites.jum_ka.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal_ka.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil_ka.setText(Integer.toString(dikenali));
//                    uites.persen_ka.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==6)
//                {
//                    uites.jum_ki.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal_ki.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil_ki.setText(Integer.toString(dikenali));
//                    uites.persen_ki.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==7)
//                {
//                    uites.jum_ku.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal_ku.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil_ku.setText(Integer.toString(dikenali));
//                    uites.persen_ku.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==8)
//                {
//                    uites.jum_ke.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal_ke.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil_ke.setText(Integer.toString(dikenali));
//                    uites.persen_ke.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==9)
//                {
//                    uites.jum_ko.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal_ko.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil_ko.setText(Integer.toString(dikenali));
//                    uites.persen_ko.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==10)
//                {
//                    uites.jum_sa.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal_sa.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil_sa.setText(Integer.toString(dikenali));
//                    uites.persen_sa.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==11)
//                {
//                    uites.jum_shi.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal_shi.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil_shi.setText(Integer.toString(dikenali));
//                    uites.persen_shi.setText(Float.toString(akurasiAngka));
//                }
//            
////                if(i==0)
////                {
////                    uites.jumgam0.setText(Integer.toString(akurasiPerAngka[i]));
////                    uites.gagal0.setText(Integer.toString(gagalPerAngka[i]));
////                    uites.berhasil0.setText(Integer.toString(dikenali));
////                    uites.lb0.setText(Float.toString(akurasiAngka));
////                }
////                else if(i==1)
////                {
////                    uites.jumgam1.setText(Integer.toString(akurasiPerAngka[i]));
////                    uites.gagal1.setText(Integer.toString(gagalPerAngka[i]));
////                    uites.berhasil1.setText(Integer.toString(dikenali));
////                    uites.lb1.setText(Float.toString(akurasiAngka));
////                }
////                else if(i==2)
////                {
////                    uites.jumgam2.setText(Integer.toString(akurasiPerAngka[i]));
////                    uites.gagal2.setText(Integer.toString(gagalPerAngka[i]));
////                    uites.berhasil2.setText(Integer.toString(dikenali));
////                    uites.lb2.setText(Float.toString(akurasiAngka));
////                }
////                else if(i==3)
////                {
////                    uites.jumgam3.setText(Integer.toString(akurasiPerAngka[i]));
////                    uites.gagal3.setText(Integer.toString(gagalPerAngka[i]));
////                    uites.berhasil3.setText(Integer.toString(dikenali));
////                    uites.lb3.setText(Float.toString(akurasiAngka));
////                }
////                else if(i==4)
////                {
////                    uites.jumgam4.setText(Integer.toString(akurasiPerAngka[i]));
////                    uites.gagal4.setText(Integer.toString(gagalPerAngka[i]));
////                    uites.berhasil4.setText(Integer.toString(dikenali));
////                    uites.lb4.setText(Float.toString(akurasiAngka));
////                }
////                else if(i==5)
////                {
////                    uites.jumgam5.setText(Integer.toString(akurasiPerAngka[i]));
////                    uites.gagal5.setText(Integer.toString(gagalPerAngka[i]));
////                    uites.berhasil5.setText(Integer.toString(dikenali));
////                    uites.lb5.setText(Float.toString(akurasiAngka));
////                }
////                else if(i==6)
////                {
////                    uites.jumgam6.setText(Integer.toString(akurasiPerAngka[i]));
////                    uites.gagal6.setText(Integer.toString(gagalPerAngka[i]));
////                    uites.berhasil6.setText(Integer.toString(dikenali));
////                    uites.lb6.setText(Float.toString(akurasiAngka));
////                }
////                else if(i==7)
////                {
////                    uites.jumgam7.setText(Integer.toString(akurasiPerAngka[i]));
////                    uites.gagal7.setText(Integer.toString(gagalPerAngka[i]));
////                    uites.berhasil7.setText(Integer.toString(dikenali));
////                    uites.lb7.setText(Float.toString(akurasiAngka));
////                }
////                else if(i==8)
////                {
////                    uites.jumgam8.setText(Integer.toString(akurasiPerAngka[i]));
////                    uites.gagal8.setText(Integer.toString(gagalPerAngka[i]));
////                    uites.berhasil8.setText(Integer.toString(dikenali));
////                    uites.lb8.setText(Float.toString(akurasiAngka));
////                }
////                else if(i==9)
////                {
////                    uites.jumgam9.setText(Integer.toString(akurasiPerAngka[i]));
////                    uites.gagal9.setText(Integer.toString(gagalPerAngka[i]));
////                    uites.berhasil9.setText(Integer.toString(dikenali));
////                    uites.lb9.setText(Float.toString(akurasiAngka));
////                }
//            }
//            
//            total=(float)(akhir-inc)/akhir;
//            akurasitotal=(float)total*100;
////
////            uites.lbltotgmbr.setText(" "+(akhir-awal));
////            uites.lblberhasil.setText(" "+(akhir-inc));
////            uites.lblgagal.setText(" "+inc);
////            uites.lblakurasi.setText(" "+akurasitotal+" %");
//            
//            System.out.println("total gambar = "+(akhir-awal));
//            System.out.println("berhasil = "+(akhir-inc));
//            System.out.println("gagal = "+inc);
//            System.out.println("akurasi = "+akurasitotal+" %");
//    }
   public void testing(formTesting uites, int awal, int akhir) throws FileNotFoundException, IOException
    {
        int i,j,inc,hsl,dikenali;
        String[] nmfile;
        double min;
        float akurasitotal,persen,akurasiAngka,total;
        int[] akurasiPerAngka=new int[46];
        int[] gagalPerAngka=new int[46];
        String[] dirImage=new String[644];
        int[] label=new int[644];
        int[] lblgmbrbenar=new int[akhir-awal];
        int[] lblgmbrgagal=new int[akhir-awal];
        int[] nogambargagal=new int[akhir-awal];
       // String[] huruf = new String[46];

        //get image as input
//        dirImage=im.GetTestImageFile();
//        im.SetTestImageLabel();
//        label=im.GetLabelTest();
        
        dirImage = im.getinput_test();
        im.setimagelabel_test();
        label = im.getlabel_test();

        for(i=0;i<46;i++)
        {
            akurasiPerAngka[i]=0;
            gagalPerAngka[i]=0;
        }

        //get bobot from file
        //setbobotTest();
        
        bobot_testing();

            inc=0;
            for(i=awal;i<akhir;i++)
            {
                hsl=0;
                min=9999;
                try {
                    im.SetInput(dirImage[i]);
                    input=im.getinput2DM();
                    System.out.println("baca label "+label[i]);
                } catch (IOException ex) {
                    Logger.getLogger(convnet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                feedforward();

                    for(j=0;j<46;j++)
                    {
                        if (output[j]< min )
                        {
                            min = output[j];
                            hsl = j;                            
                        }
                        System.out.println("output "+output[j]);
                    }
                    //System.out.println("min "+min);
                    //System.out.println("hasil "+hsl);
                    
                    akurasiPerAngka[label[i]]=akurasiPerAngka[label[i]]+1; //hitung banyak data set per Angka
                    
                        
                    if(label[i]!=hsl)
                    {
                        gagalPerAngka[hsl]=gagalPerAngka[hsl]+1; //hitung kegagalan per Angka                       
                        lblgmbrbenar[inc]=label[i]; //menampung label yang seharusnya
                        lblgmbrgagal[inc]=hsl;   //menampung label yang gagal dikenali
                        nogambargagal[inc]=(i+1);   //menampung nomer gambar yang gagal
                        inc++;  //hitung kegagalan keseluruhan
                        
                    }
            }
            nmfile=im.filegambargagal(nogambargagal);
            uites.setData(lblgmbrgagal, lblgmbrbenar,nmfile);
            
            int row,col;
            for(i=0;i<46;i++)
            {
                dikenali=(akurasiPerAngka[i]- gagalPerAngka[i]);
                persen=(float)dikenali/akurasiPerAngka[i];
                akurasiAngka=(float)persen*100;

//  
//                DefaultTableModel model = (DefaultTableModel)jTable1.getModel();

//model.setValueAt(s, 1, 1);
       
                //if(i==0)
                //{
                    //formTesting.jTable1.setValueAt(akurasiPerAngka[i], rowtable, columntable);
                //}
//                    uites.jumgam0.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal0.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil0.setText(Integer.toString(dikenali));
//                    uites.lb0.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==1)
//                {
//                    uites.jumgam1.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal1.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil1.setText(Integer.toString(dikenali));
//                    uites.lb1.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==2)
//                {
//                    uites.jumgam2.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal2.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil2.setText(Integer.toString(dikenali));
//                    uites.lb2.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==3)
//                {
//                    uites.jumgam3.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal3.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil3.setText(Integer.toString(dikenali));
//                    uites.lb3.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==4)
//                {
//                    uites.jumgam4.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal4.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil4.setText(Integer.toString(dikenali));
//                    uites.lb4.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==5)
//                {
//                    uites.jumgam5.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal5.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil5.setText(Integer.toString(dikenali));
//                    uites.lb5.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==6)
//                {
//                    uites.jumgam6.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal6.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil6.setText(Integer.toString(dikenali));
//                    uites.lb6.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==7)
//                {
//                    uites.jumgam7.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal7.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil7.setText(Integer.toString(dikenali));
//                    uites.lb7.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==8)
//                {
//                    uites.jumgam8.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal8.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil8.setText(Integer.toString(dikenali));
//                    uites.lb8.setText(Float.toString(akurasiAngka));
//                }
//                else if(i==9)
//                {
//                    uites.jumgam9.setText(Integer.toString(akurasiPerAngka[i]));
//                    uites.gagal9.setText(Integer.toString(gagalPerAngka[i]));
//                    uites.berhasil9.setText(Integer.toString(dikenali));
//                    uites.lb9.setText(Float.toString(akurasiAngka));
//                }
            }
            
            total=(float)(akhir-inc)/akhir;
            akurasitotal=(float)total*100;
  
            uites.totalgambar.setText(" "+(akhir-awal));
            uites.berhasil.setText(" "+(akhir-inc));
            uites.gagal.setText(" "+inc);
            uites.akurasi.setText(" "+akurasitotal+"%");
    }


//    private void setbobotTest() throws FileNotFoundException, IOException
//    {
//        String nmfilebobot[]=new String[12];
//        nmfilebobot=bm.getFileNameTest();
//
//        bm.FSetBobot_C1(nmfilebobot[0]);
//        bm.FSetbias_C1(nmfilebobot[1]);
//        bm.FSetbobot_S2(nmfilebobot[2]);
//        bm.FSetbias_S2(nmfilebobot[3]);
//        bm.FSetbobot_C3(nmfilebobot[4]);
//        bm.FSetbias_C3(nmfilebobot[5]);
//        bm.FSetbobot_S4(nmfilebobot[6]);
//        bm.FSetbias_S4(nmfilebobot[7]);
//        bm.FSetbobot_C5(nmfilebobot[8]);
//        bm.FSetbias_C5(nmfilebobot[9]);
//        bm.FSetbobot_F6(nmfilebobot[10]);
//        bm.FSetbias_F6(nmfilebobot[11]);
//
//        bobot_c1=bm.GetBobot_C1();
//        bias_c1=bm.GetBias_C1();
//        bobot_s2=bm.GetBobot_S2();
//        bias_s2=bm.GetBias_S2();
//        bobot_c3=bm.GetBobot_C3();
//        bias_c3=bm.GetBias_C3();
//        bobot_s4=bm.GetBobot_S4();
//        bias_s4=bm.GetBias_S4();
//        bobot_c5=bm.GetBobot_C5();
//        bias_c5=bm.GetBias_C5();
//        bobot_f6=bm.GetBobot_F6();
//        bias_f6=bm.GetBias_F6();
//    }
//
//    private void setbobot_biasRandom()
//    {
//        bm.SetBobot_C1();
//        bobot_c1=bm.GetBobot_C1();
//        bm.SetBias_C1();
//        bias_c1=bm.GetBias_C1();
//
//        bm.SetBobot_S2();
//        bobot_s2=bm.GetBobot_S2();
//        bm.SetBias_S2();
//        bias_s2=bm.GetBias_S2();
//
//        bm.SetBobot_C3();
//        bobot_c3=bm.GetBobot_C3();
//        bm.SetBias_C3();
//        bias_c3=bm.GetBias_C3();
//
//        bm.SetBobot_S4();
//        bobot_s4=bm.GetBobot_S4();
//        bm.SetBias_S4();
//        bias_s4=bm.GetBias_S4();
//
//        bm.SetBobot_C5();
//        bobot_c5=bm.GetBobot_C5();
//        bm.SetBias_C5();
//        bias_c5=bm.GetBias_C5();
//
//        bm.SetBobot_F6();
//        bobot_f6=bm.GetBobot_F6();
//        bm.SetBias_F6();
//        bias_f6=bm.GetBias_F6();
//    }

    private void feedforward()
    {
        Layer_C1();
        Layer_S2();
        Layer_C3();
        Layer_S4();
        Layer_C5();
        Layer_F6();
        Layer_Output();
    }
//////////////////
    private void gradienBP(int label)
    {
        EBP_LayerF6(label);
        EBP_LayerC5();
        EBP_LayerS4();
        EBP_LayerC3();
        EBP_LayerS2();
        EBP_LayerC1();
    }

    private void updatebobot_bias()
    {
        UpdateBobot_C1();
        UpdateBias_C1();
        UpdateBobot_S2();
        UpdateBias_S2();
        UpdateBobot_C3();
        UpdateBias_C3();
        UpdateBobot_S4();
        UpdateBias_S4();
        UpdateBobot_C5();
        UpdateBias_C5();
        UpdateBobot_F6();
        UpdateBias_F6();
    }

//    private void simpanbobot_bias()
//    {
//        String tempfileName[]=new String[12];
//
//        tempfileName=bm.getFileName();
//        bm.simpanBobot_C1(tempfileName[0],bobot_c1);
//        bm.simpanBias_C1(tempfileName[1],bias_c1);
//
//        bm.simpanBobot_S2(tempfileName[2],bobot_s2);
//        bm.simpanBias_S2(tempfileName[3],bias_s2);
//
//        bm.simpanBobot_C3(tempfileName[4],bobot_c3);
//        bm.simpanBias_C3(tempfileName[5],bias_c3);
//
//        bm.simpanBobot_S4(tempfileName[6],bobot_s4);
//        bm.simpanBias_S4(tempfileName[7],bias_s4);
//
//        bm.simpanBobot_C5(tempfileName[8],bobot_c5);
//        bm.simpanBias_C5(tempfileName[9],bias_c5);
//
//        bm.simpanBobot_F6(tempfileName[10],bobot_f6);
//        bm.simpanBias_F6(tempfileName[11],bias_f6);
//    }
//
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::://
    //                          FEED FORWARD                        //
    //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::://

    private void Layer_C1()
    {
        int jumplane_c1,i,j,k,l,x,y;
        double temp1,tampungan;

        for(jumplane_c1=0;jumplane_c1<6;jumplane_c1++)
        {
            for(i=0;i<28;i++)
            {
                for(j=0;j<28;j++)
                {
                    temp1=0;
                    x=0;
                    for(k=j;k<=j+4;k++)
                    {
                        y=0;
                        for(l=i;l<=i+4;l++)
                        {
                            if(input[k][l]==0)
                            {
                                temp1=temp1 + (1.175 * bobot_c1[jumplane_c1][x][y]);
                            }
                            else
                            {
                                temp1=temp1 + (-0.1 * bobot_c1[jumplane_c1][x][y]);
                            }
                            y++;
                        }
                        x++;
                    }
                   tampungan=(temp1+bias_c1[jumplane_c1]);
                   c1[jumplane_c1][i][j]=1.7159 * Math.tanh(0.667 * tampungan);
                }
            }
        }
    }


    private void Layer_S2()
    {
        int jumplane_s2,baris,kolom,i,j,bar,kol;
        double temp1,temp2;

        for(jumplane_s2=0;jumplane_s2<6;jumplane_s2++)
        {
            baris=0;
            kolom=0;
            for(i=0;i<14;i++)
            {
                for(j=0;j<14;j++)
                {
                    temp1=0;
                    for(bar=baris;bar<baris+2;bar++)
                    {
                        for(kol=kolom;kol<kolom+2;kol++)
                        {
                            temp1=temp1+c1[jumplane_s2][bar][kol];
                        }
                    }
                    temp2=((temp1/4)*bobot_s2[jumplane_s2])+bias_s2[jumplane_s2];
                    s2[jumplane_s2][i][j]=1.7159 * Math.tanh(0.667 * temp2);
                    kolom=kolom+2;
                }
                baris=baris+2;
                kolom=0;
            }
        }
    }

    private void Layer_C3()
    {
        int i,j,k,l,m,ss2,index,x,y;
        double temp1,temp2,tot;
        char[] charArr;

        String[] result=bm.inisialisasi();
        for(i=0;i<16;i++)
        {
            charArr=result[i].toCharArray();
            for(j=0;j<10;j++)
            {
                for(k=0;k<10;k++)
                {
                    tot=0;
                    for(ss2=0;ss2<charArr.length;ss2++)
                    {
                        index=Integer.parseInt(Character.toString(charArr[ss2]));
                        temp1=0;
                        x=0;
                        for(l=k;l<=k+4;l++)
                        {
                            y=0;
                            for(m=j;m<=j+4;m++)
                            {
                                temp1=temp1 + s2[index][l][m] * bobot_c3[index][i][x][y];
                                y++;
                            }
                            x++;
                        }
                        tot=tot+temp1;
                    }
                    temp2=tot+bias_c3[i];
                    c3[i][j][k]= 1.7159 * Math.tanh(0.667 * temp2);
                }
            }
        }
    }


    private void Layer_S4()
    {
        int jumplane_s4,baris,kolom,i,j,bar,kol;
        double temp1,temp2;

        for(jumplane_s4=0;jumplane_s4<16;jumplane_s4++)
        {
            baris=0;
            kolom=0;
            for(i=0;i<5;i++)
            {
                for(j=0;j<5;j++)
                {
                    temp1=0;
                    for(bar=baris;bar<baris+2;bar++)
                    {
                        for(kol=kolom;kol<kolom+2;kol++)
                        {
                            temp1=temp1+c3[jumplane_s4][bar][kol];
                        }
                    }
                    temp2=(temp1*bobot_s4[jumplane_s4])+bias_s4[jumplane_s4];
                    s4[jumplane_s4][i][j]=1.7159 * Math.tanh(0.667 * temp2);
                    kolom=kolom+2;
                }
                baris=baris+2;
                kolom=0;
            }
        }
    }


    private void Layer_C5()
    {
        int i,j,k,l,ctr;
        double temp1,temp2,temp3;

        for(i=0;i<120;i++)
        {
            temp2=0;
            for(j=0;j<16;j++)
            {
                temp1=0;
                ctr=0;
                for(k=0;k<5;k++)
                {
                    for(l=0;l<5;l++)
                    {
                        temp1=temp1+s4[j][k][l]*bobot_c5[j][ctr][i];
                        ctr++;
                    }
                }
                temp2=temp2+temp1;
            }
            temp3=temp2+bias_c5[i];
            c5[i]=1.7159 * Math.tanh(0.667 * temp3);
        }
    }


    private void Layer_F6()
    {
        int i,j;
        double temp1,temp2,temp3;

        for(j=0;j<84;j++)
        {
            temp2=0;
            for(i=0;i<120;i++)
            {
                temp1=c5[i]*bobot_f6[i][j];
                temp2=temp2+temp1;
            }
            temp3=temp2+bias_f6[j];
            f6[j]=1.7159 * Math.tanh(0.667 * temp3);
        }
    }

    private void Layer_Output()
    {
        int i,j;
        double[][] target84=new double[46][84];
        double power;
        
        bm.SetTarget84();
        target84=bm.GetTarget();

        for(j=0;j<46;j++)
        {
            output[j]=0;
            power=0.0;
            for(i=0;i<84;i++)
            {
                power=power+Math.pow(f6[i] - target84[j][i], 2);
                //System.out.println("f6 "+f6[i]);
                //System.out.println("target "+target84[j][i]);
               // System.out.println("power "+power);
            }
            output[j]=power;
            //System.out.println("output "+output[j]);
        }
    }

  
    //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::://
    //                      FUNGSI DERIFATIVE                       //
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::://
    private double derivative(double c)
    {
        double d=1.7159*0.667*(1-Math.pow(Math.tanh(0.667*c), 2));
        return d;
    }

    //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::://
    //                      CARI DELTA BOBOT                       //
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::://

    private void EBP_LayerF6(int label)
    {
        int i,j,out;
        double t1,eror,aksen;
        double target84[][]=new double[46][84];

        bm.SetTarget84();
        target84=bm.GetTarget();
        //for(out=0;out<10;out++)
        //{
            for(i=0;i<84;i++)
            {
                t1=target84[label][i];
                eror=t1-f6[i];
                aksen=derivative(f6[i]);
                gradienf6[i]=eror*aksen;
                for(j=0;j<120;j++)
                {
                    dbobot_f6[j][i]=alpha*c5[j]*gradienf6[i];
                }
                dbias_f6[i]=alpha*gradienf6[i];
            }
        //}
    }

    private void EBP_LayerC5()
    {
        int i,j,k,l,ctr;
        double temp,aksen;


        for(i=0;i<120;i++)
        {
            temp=0;
            for(j=0;j<84;j++)
            {
                temp=temp+bobot_f6[i][j]*gradienf6[j];
            }
            aksen=derivative(c5[i]);
            gradienc5[i]=aksen*temp;
        }

        //delta w c5
        for(i=0;i<120;i++)
        {
            for(j=0;j<16;j++)
            {
                ctr=0;
                for(k=0;k<5;k++)
                {
                    for(l=0;l<5;l++)
                    {
                        dbobot_c5[j][ctr][i]=alpha*s4[j][k][l]*gradienc5[i];
                        ctr++;
                    }
                }
            }
            dbias_c5[i]=alpha*gradienc5[i];    //delta bias c5
        }
    }


    private void EBP_LayerS4()
    {
        int jumplane_s4,baris,kolom,i,j,bar,kol,k,ctr;
        double din_s4[][][]=new double[16][5][5];
        double temp1,aksen;

        //inisialisasi temp=0
        for(jumplane_s4=0;jumplane_s4<16;jumplane_s4++)
        {
            for(i=0;i<5;i++)
            {
                for(j=0;j<5;j++)
                {
                    din_s4[jumplane_s4][i][j]=0;
                }
            }
        }

        //tampung total gradien k dan bobot k yg masuk, cari sigma
        for(k=0;k<120;k++)
        {
             for(jumplane_s4=0;jumplane_s4<16;jumplane_s4++)
             {
                ctr=0;
                for(i=0;i<5;i++)
                {
                    for(j=0;j<5;j++)
                    {
                        din_s4[jumplane_s4][i][j]=din_s4[jumplane_s4][i][j]+bobot_c5[jumplane_s4][ctr][k]*gradienc5[k];
                        ctr++;
                    }
                }
            }
        }

        // cari gradien s4
        for(jumplane_s4=0;jumplane_s4<16;jumplane_s4++)
        {
            for(i=0;i<5;i++)
            {
                for(j=0;j<5;j++)
                {
                    aksen=derivative(s4[jumplane_s4][i][j]);
                    gradiens4[jumplane_s4][i][j]=din_s4[jumplane_s4][i][j]*aksen;
                }
            }
        }

        // delta w s4
        for(jumplane_s4=0;jumplane_s4<16;jumplane_s4++)
        {
            baris=0;
            kolom=0;
            dbobot_s4[jumplane_s4]=0;
            for(i=0;i<5;i++)
            {
                for(j=0;j<5;j++)
                {
                    temp1=0;
                    for(bar=baris;bar<baris+2;bar++)
                    {
                        for(kol=kolom;kol<kolom+2;kol++)
                        {
                            temp1=temp1+c3[jumplane_s4][bar][kol];
                        }
                    }
                    dbobot_s4[jumplane_s4]=dbobot_s4[jumplane_s4]+temp1*gradiens4[jumplane_s4][i][j];
                    kolom=kolom+2;
                }
                baris=baris+2;
                kolom=0;
            }
            dbobot_s4[jumplane_s4]=alpha*dbobot_s4[jumplane_s4];
        }


        //delta bias s4
        for(jumplane_s4=0;jumplane_s4<16;jumplane_s4++)
        {
            dbias_s4[jumplane_s4]=0;
            for(i=0;i<5;i++)
            {
                for(j=0;j<5;j++)
                {
                    dbias_s4[jumplane_s4]=dbias_s4[jumplane_s4]+gradiens4[jumplane_s4][i][j];
                }
            }
            dbias_s4[jumplane_s4]=alpha*dbias_s4[jumplane_s4];
        }
    }


    private void EBP_LayerC3()
    {
        int i,j,k,l,ctr,ii,ctr2,index,bar,baris,kol,kolom;
        double din_c3[][][]=new double[16][10][10];
        double tempbobot_c3[][][][]=new double[6][25][16][100];
        char[] charArr;double temp;
        double aksen;

        for(i=0;i<16;i++)
        {
            for(j=0;j<10;j++)
            {
                for(k=0;k<10;k++)
                {
                    din_c3[i][j][k]=0;
                }
            }
        }

        for(i=0;i<16;i++)
        {
            baris=0;
            kolom=0;
            for(j=0;j<5;j++)
            {
                for(k=0;k<5;k++)
                {
                    for(bar=baris;bar<baris+2;bar++)
                    {
                        for(kol=kolom;kol<kolom+2;kol++)
                        {
                           din_c3[i][bar][kol]=din_c3[i][bar][kol]+bobot_s4[i]*gradiens4[i][j][k];
                        }
                    }
                    kolom=kolom+2;
                }
                baris=baris+2;
                kolom=0;
            }
        }


        for(i=0;i<16;i++)
        {
            for(j=0;j<10;j++)
            {
               for(k=0;k<10;k++)
                {
                    aksen=derivative(c3[i][j][k]);
                    gradienc3[i][j][k]=din_c3[i][j][k]*aksen;
                }
            }
        }


        //------------- kali alpa dan inputnya
        String[] result=bm.inisialisasi();
        for(i=0;i<16;i++)
        {
            ctr2=0;
            charArr=result[i].toCharArray();
            for(j=0;j<10;j++)
            {
                for(k=0;k<10;k++)
                {
                    for(int ss2=0;ss2<charArr.length;ss2++)
                    {
                        index=Integer.parseInt(Character.toString(charArr[ss2]));
                        ctr=0;

                        for(l=k;l<=k+4;l++)
                        {
                            for(ii=j;ii<=j+4;ii++)
                            {
                                tempbobot_c3[index][ctr][i][ctr2]=gradienc3[i][j][k]*s2[index][l][ii];
                                ctr++;
                            }
                        }
                    }
                    ctr2++;
                }
            }
         }

            for(i=0;i<16;i++)
            {
                ctr=0;
                for(j=0;j<5;j++)
                {
                    for(k=0;k<5;k++)
                    {
                        charArr=result[j].toCharArray();
                        for(int ss2=0;ss2<charArr.length;ss2++)
                        {
                            index=Integer.parseInt(Character.toString(charArr[ss2]));

                            temp=0;
                            for(l=0;l<100;l++)
                            {
                                temp=temp+tempbobot_c3[index][ctr][i][l];
                            }
                            dbobot_c3[index][i][j][k]=alpha * temp;
                        }
                        ctr++;
                    }
                }
            }


        for(j=0;j<16;j++)
        {
            temp=0;
            for(k=0;k<10;k++)
            {
                for(l=0;l<10;l++)
                {
                    temp=temp+gradienc3[j][k][l];
                }
            }
            dbias_c3[j]=alpha*temp;
        }
    }


    private void EBP_LayerS2()
    {
        int jumplane_s2,jumplane_c3,baris,kolom,i,j,k,l,bar,kol,index,x,y;
        double din_s2[][][]=new double[6][14][14];
        double temp1,aksen;
        char[] charArr;

        for(jumplane_s2=0;jumplane_s2<6;jumplane_s2++)
        {
            for(i=0;i<14;i++)
            {
                for(j=0;j<14;j++)
                {
                    din_s2[jumplane_s2][i][j]=0;
                }
            }
        }

        String[] result=bm.inisialisasi();
        for(jumplane_c3=0;jumplane_c3<16;jumplane_c3++)
        {
            for(i=0;i<10;i++)
            {
                for(j=0;j<10;j++)
                {
                    charArr=result[jumplane_c3].toCharArray();
                    for(int ss2=0;ss2<charArr.length;ss2++)
                    {
                        index=Integer.parseInt(Character.toString(charArr[ss2]));
                        x=0;
                        for(k=j;k<=j+4;k++)
                        {
                            y=0;
                            for(l=i;l<=i+4;l++)
                            {
                                din_s2[index][k][l]=din_s2[index][k][l]+gradienc3[jumplane_c3][i][j]*bobot_c3[index][jumplane_c3][x][y];
                                y++;
                            }
                            x++;
                        }
                    }
                }
            }
        }


        for(jumplane_s2=0;jumplane_s2<6;jumplane_s2++)
        {
            for(i=0;i<14;i++)
            {
                for(j=0;j<14;j++)
                {
                    aksen=derivative(s2[jumplane_s2][i][j]);
                    gradiens2[jumplane_s2][i][j]=din_s2[jumplane_s2][i][j]*aksen;
                }
            }
        }


        //------------------------- cari dbobot s2

        for(jumplane_s2=0;jumplane_s2<6;jumplane_s2++)
        {
            baris=0;
            kolom=0;
            dbobot_s2[jumplane_s2]=0;
            for(i=0;i<14;i++)
            {
                for(j=0;j<14;j++)
                {
                    temp1=0;
                    for(bar=baris;bar<baris+2;bar++)
                    {
                        for(kol=kolom;kol<kolom+2;kol++)
                        {
                           temp1=temp1+c1[jumplane_s2][bar][kol];
                        }
                    }
                    dbobot_s2[jumplane_s2]=dbobot_s2[jumplane_s2]+temp1*gradiens2[jumplane_s2][i][j];
                    
                    kolom=kolom+2;
                }
                baris=baris+2;
                kolom=0;
            }
            dbobot_s2[jumplane_s2]=alpha*dbobot_s2[jumplane_s2];
        }


        for(jumplane_s2=0;jumplane_s2<6;jumplane_s2++)
        {
            dbias_s2[jumplane_s2]=0;
            for(i=0;i<14;i++)
            {
                for(j=0;j<14;j++)
                {
                    dbias_s2[jumplane_s2]=dbias_s2[jumplane_s2]+gradiens2[jumplane_s2][i][j];
                }
            }
            dbias_s2[jumplane_s2]=alpha*dbias_s2[jumplane_s2];
        }
    }


    private void EBP_LayerC1()
    {
        int jumplane_c1,i,j,k,l,ctr,ctr2,baris,kolom,bar,kol;
        double tempbobot_c1[][][]=new double[25][6][784];
        double din_c1[][][]=new double[6][28][28];
        double temp1,aksen;


        for(jumplane_c1=0;jumplane_c1<6;jumplane_c1++)
        {
            baris=0;
            kolom=0;
            for(i=0;i<14;i++)
            {
                for(j=0;j<14;j++)
                {
                    for(bar=baris;bar<baris+2;bar++)
                    {
                        for(kol=kolom;kol<kolom+2;kol++)
                        {
                            din_c1[jumplane_c1][bar][kol]=bobot_s2[jumplane_c1]*gradiens2[jumplane_c1][i][j];
                        }
                    }
                    kolom=kolom+2;
                }
                baris=baris+2;
                kolom=0;
            }
        }


       for(jumplane_c1=0;jumplane_c1<6;jumplane_c1++)
        {
            for(i=0;i<28;i++)
            {
                for(j=0;j<28;j++)
                {
                    aksen=derivative(c1[jumplane_c1][i][j]);
                    gradienc1[jumplane_c1][i][j]=din_c1[jumplane_c1][i][j]*aksen;
                }
            }
       }

        for(jumplane_c1=0;jumplane_c1<6;jumplane_c1++)
        {
            ctr2=0;
            for(i=0;i<28;i++)
            {
                for(j=0;j<28;j++)
                {
                    ctr=0;
                    for(k=j;k<=j+4;k++)
                    {
                        for(l=i;l<=i+4;l++)
                        {
                           if(input[k][l]==0)
                            {
                                tempbobot_c1[ctr][jumplane_c1][ctr2]=1.175 * gradienc1[jumplane_c1][i][j];
                            }
                            else
                            {
                                tempbobot_c1[ctr][jumplane_c1][ctr2]=-0.1 * gradienc1[jumplane_c1][i][j];
                            }
                            ctr++;
                        }
                    }
                    ctr2++;
                }
            }
        }


        for(jumplane_c1=0;jumplane_c1<6;jumplane_c1++)
        {
            ctr=0;
            for(i=0;i<5;i++)
            {
                for(j=0;j<5;j++)
                {
                    temp1=0;
                    for(k=0;k<784;k++)
                    {
                       temp1=temp1+tempbobot_c1[ctr][jumplane_c1][k];
                    }
                    dbobot_c1[jumplane_c1][i][j]=temp1*alpha;
                    
                    ctr++;
                }
            }
        }


        for(jumplane_c1=0;jumplane_c1<6;jumplane_c1++)
        {
            temp1=0;
            for(i=0;i<28;i++)
            {
                for(j=0;j<28;j++)
                {
                    temp1=temp1+gradienc1[jumplane_c1][i][j];
                }
            }
            dbias_c1[jumplane_c1]=alpha*temp1;
        }
    }

//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::://
    //                          UPDATE BOBOT                       //
    //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::://

    private void UpdateBobot_C1()
    {
        int i,j,k;

        for(i=0;i<6;i++)
        {
            for(j=0;j<5;j++)
            {
                for(k=0;k<5;k++)
                {
                    bobot_c1[i][j][k]=bobot_c1[i][j][k]+dbobot_c1[i][j][k];
                    /*if(bobot_c1[i][j][k]>0.1)
                    {
                        System.out.println("dbobot1: "+bobot_c1[i][j][k]);
                    }*/
                }
            }
        }
    }

    private void UpdateBias_C1()
    {
        int jumplane_c1;

        for(jumplane_c1=0;jumplane_c1<6;jumplane_c1++)
        {
            bias_c1[jumplane_c1]=bias_c1[jumplane_c1]+dbias_c1[jumplane_c1];
        }
    }

    private void UpdateBobot_S2()
    {
        int jumplane_s2;

        for(jumplane_s2=0;jumplane_s2<6;jumplane_s2++)
        {
            bobot_s2[jumplane_s2]=bobot_s2[jumplane_s2]+dbobot_s2[jumplane_s2];
        }
    }

    private void UpdateBias_S2()
    {
        int jumplane_s2;

        for(jumplane_s2=0;jumplane_s2<6;jumplane_s2++)
        {
            bias_s2[jumplane_s2]=bias_s2[jumplane_s2]+dbias_s2[jumplane_s2];
        }
    }

    private void UpdateBobot_C3()
    {
        int i,j,k,ss2,index;
        char[] charArr;
        String[] result=bm.inisialisasi();

        for(i=0;i<16;i++)
        {
            charArr=result[i].toCharArray();
            for(ss2=0;ss2<charArr.length;ss2++)
            {
                index=Integer.parseInt(Character.toString(charArr[ss2]));
                for(j=0;j<5;j++)
                {
                    for(k=0;k<5;k++)
                    {
                        bobot_c3[index][i][j][k]=bobot_c3[index][i][j][k]+dbobot_c3[index][i][j][k];
                    }
                }
            }
        }
    }

    private void UpdateBias_C3()
    {
        int jumplane_c3;

        for(jumplane_c3=0;jumplane_c3<16;jumplane_c3++)
        {
            bias_c3[jumplane_c3]=bias_c3[jumplane_c3]+dbias_c3[jumplane_c3];
        }
    }

    private void UpdateBobot_S4()
    {
        int jumplane_s4;

        for(jumplane_s4=0;jumplane_s4<16;jumplane_s4++)
        {
            bobot_s4[jumplane_s4]=bobot_s4[jumplane_s4]+dbobot_s4[jumplane_s4];
        }
    }

    private void UpdateBias_S4()
    {
        int jumplane_s4;

        for(jumplane_s4=0;jumplane_s4<16;jumplane_s4++)
        {
            bias_s4[jumplane_s4]=bias_s4[jumplane_s4]+dbias_s4[jumplane_s4];
        }
    }

    private void UpdateBobot_C5()
    {
        int i,j,k;

        for(i=0;i<120;i++)
        {
            for(j=0;j<16;j++)
            {
                for(k=0;k<25;k++)
                {
                    bobot_c5[j][k][i]=bobot_c5[j][k][i]+dbobot_c5[j][k][i];
                }
             }
        }
    }

    private void UpdateBias_C5()
    {
        int i;

        for(i=0;i<120;i++)
        {
            bias_c5[i]=bias_c5[i]+dbias_c5[i];
        }
    }

    private void UpdateBobot_F6()
    {
        int i,j;

        for(j=0;j<84;j++)
        {
            for(i=0;i<120;i++)
            {
                bobot_f6[i][j]=bobot_f6[i][j]+dbobot_f6[i][j];
            }
        }
    }

    private void UpdateBias_F6()
    {
        int i;

        for(i=0;i<84;i++)
        {
            bias_f6[i]=bias_f6[i]+dbias_f6[i];
        }
    }
      
}
