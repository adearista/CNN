/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import controller.convnet;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Win7
 */
public class formTesting extends javax.swing.JFrame {

    /**
     * Creates new form formTesting
     */
    
    private int[] lblGmbrGagal;
    private int[] lblGmbrBenar;
    private String[] nmgambar;
    private boolean kondisi;
    private int putaran,inc = 0;
    
    public void setData(int[] lblGmbrGagal, int[] lblGmbrBenar, String[] nmfilegambar)
    {
        this.lblGmbrBenar = lblGmbrBenar;
        this.lblGmbrGagal = lblGmbrGagal;
        this.nmgambar = nmfilegambar;
        
    }

//    public void tampiltabel(){
//        
//        Object header[]= {"Huruf","Jumlah","Berhasil","Gagal","Persentase"};
//        
//        DefaultTableModel data = new DefaultTableModel(null,header)
//        {
//            public boolean isCellEditable(int rowIndex, int colIndex)
//                {
//                    return false;
//                }
//        
//        };
//        
//        JTable table = new JTable(data);
//        jTable1.setModel(data);
//        int row = table.get
//        
//    }
    
    public formTesting() {
        
        super("Japanese Handwriting Recognition using CNN LeNet5");
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(menuawal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        kondisi = false;
        initComponents();
        this.setLocationRelativeTo(this.rootPane);
//        tampiltabel();
    }
    
    
    public void setImage(int round, int jumgambar)
    {
        int i;
        
        this.putaran = round;
        
        for(i=round; i<jumgambar; i++)
//        {
//            if(i<20)
//            {
//                putaran++;
//                
                if(nmgambar.equals("")==false)
                {
                    ImageIcon ic = new ImageIcon(nmgambar[i]);
                    
                    if(i==0)
                    {
//                        jTable1.setValueAt(lblGmbrGagal[i], row, col);
//                        isigambar1.setIcon(ic);
                       // tul1.setText(lblGmbrBenar[i]+"/"+lblGmbrGagal[i]);
                    }
//                    else if(i==1)
//                    {
//                        isigambar2.setIcon(ic);
//                        tul2.setText(lblGmbrBenar[i]+"/"+lblGmbrGagal[i]);
//                    }
//                    else if(i==2)
//                    {
//                        isigambar3.setIcon(ic);
//                        tul3.setText(lblGmbrBenar[i]+"/"+lblGmbrGagal[i]);
//                    }
//                    else if(i==3)
//                    {
//                        isigambar4.setIcon(ic);
//                        tul4.setText(lblGmbrBenar[i]+"/"+lblGmbrGagal[i]);
//                    }
//                    else if(i==4)
//                    {
//                        isigambar5.setIcon(ic);
//                        tul5.setText(lblGmbrBenar[i]+"/"+lblGmbrGagal[i]);
//                    }
//                    else if(i==5)
//                    {
//                        isigambar6.setIcon(ic);
//                        tul6.setText(lblGmbrBenar[i]+"/"+lblGmbrGagal[i]);
//                    }
//                    else if(i==6)
//                    {
//                        isigambar7.setIcon(ic);
//                        tul7.setText(lblGmbrBenar[i]+"/"+lblGmbrGagal[i]);
//                    }
//                    else if(i==7)
//                    {
//                        isigambar8.setIcon(ic);
//                        tul8.setText(lblGmbrBenar[i]+"/"+lblGmbrGagal[i]);
//                    }
//                    else if(i==8)
//                    {
//                        isigambar9.setIcon(ic);
//                        tul9.setText(lblGmbrBenar[i]+"/"+lblGmbrGagal[i]);
//                    }
//                    else if(i==9)
//                    {
//                        isigambar10.setIcon(ic);
//                        tul10.setText(lblGmbrBenar[i]+"/"+lblGmbrGagal[i]);
//                    }
//                    else if(i==10)
//                    {
//                        isigambar11.setIcon(ic);
//                        tul11.setText(lblGmbrBenar[i]+"/"+lblGmbrGagal[i]);
//                    }
//                    else if(i==11)
//                    {
//                        isigambar12.setIcon(ic);
//                        tul12.setText(lblGmbrBenar[i]+"/"+lblGmbrGagal[i]);
//                    }
//                    else if(i==12)
//                    {
//                        isigambar13.setIcon(ic);
//                        tul13.setText(lblGmbrBenar[i]+"/"+lblGmbrGagal[i]);
//                    }
//                    else if(i==13)
//                    {
//                        isigambar14.setIcon(ic);
//                        tul14.setText(lblGmbrBenar[i]+"/"+lblGmbrGagal[i]);
//                    }
//                    else if(i==14)
//                    {
//                        isigambar15.setIcon(ic);
//                        tul15.setText(lblGmbrBenar[i]+"/"+lblGmbrGagal[i]);
//                    }
//                    else if(i==15)
//                    {
//                        isigambar16.setIcon(ic);
//                        tul16.setText(lblGmbrBenar[i]+"/"+lblGmbrGagal[i]);
//                    }
//                    else if(i==16)
//                    {
//                        isigambar17.setIcon(ic);
//                        tul17.setText(lblGmbrBenar[i]+"/"+lblGmbrGagal[i]);
//                    }
//                    else if(i==17)
//                    {
//                        isigambar18.setIcon(ic);
//                        tul18.setText(lblGmbrBenar[i]+"/"+lblGmbrGagal[i]);
//                    }
//                    else if(i==18)
//                    {
//                        isigambar19.setIcon(ic);
//                        tul19.setText(lblGmbrBenar[i]+"/"+lblGmbrGagal[i]);
//                    }
//                    else if(i==19)
//                    {
//                        isigambar20.setIcon(ic);
//                        tul20.setText(lblGmbrBenar[i]+"/"+lblGmbrGagal[i]);
//                    }
//                }
//            }
//            else
//            {
//                inc++;
//            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        from = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        until = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        status = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        berhasil_i = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        gagal_i = new javax.swing.JLabel();
        persen_i = new javax.swing.JLabel();
        jum_i = new javax.swing.JLabel();
        jum_a = new javax.swing.JLabel();
        gagal_a = new javax.swing.JLabel();
        berhasil_a = new javax.swing.JLabel();
        persen_a = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jum_u = new javax.swing.JLabel();
        jum_e = new javax.swing.JLabel();
        jum_o = new javax.swing.JLabel();
        gagal_u = new javax.swing.JLabel();
        gagal_e = new javax.swing.JLabel();
        gagal_o = new javax.swing.JLabel();
        berhasil_u = new javax.swing.JLabel();
        berhasil_e = new javax.swing.JLabel();
        berhasil_o = new javax.swing.JLabel();
        persen_u = new javax.swing.JLabel();
        persen_e = new javax.swing.JLabel();
        persen_o = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jum_ka = new javax.swing.JLabel();
        jum_ki = new javax.swing.JLabel();
        jum_ku = new javax.swing.JLabel();
        jum_ke = new javax.swing.JLabel();
        jum_ko = new javax.swing.JLabel();
        jum_sa = new javax.swing.JLabel();
        jum_shi = new javax.swing.JLabel();
        gagal_ka = new javax.swing.JLabel();
        gagal_ki = new javax.swing.JLabel();
        gagal_ku = new javax.swing.JLabel();
        gagal_ke = new javax.swing.JLabel();
        gagal_ko = new javax.swing.JLabel();
        gagal_sa = new javax.swing.JLabel();
        gagal_shi = new javax.swing.JLabel();
        berhasil_ka = new javax.swing.JLabel();
        berhasil_ki = new javax.swing.JLabel();
        berhasil_ku = new javax.swing.JLabel();
        berhasil_ke = new javax.swing.JLabel();
        berhasil_ko = new javax.swing.JLabel();
        berhasil_sa = new javax.swing.JLabel();
        berhasil_shi = new javax.swing.JLabel();
        persen_ka = new javax.swing.JLabel();
        persen_ki = new javax.swing.JLabel();
        persen_ku = new javax.swing.JLabel();
        persen_ke = new javax.swing.JLabel();
        persen_ko = new javax.swing.JLabel();
        persen_sa = new javax.swing.JLabel();
        persen_shi = new javax.swing.JLabel();
        totalgambar = new javax.swing.JLabel();
        totalgagal = new javax.swing.JLabel();
        totalberhasil = new javax.swing.JLabel();
        totalpersen = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Japanese Hiragana Character Recognition using");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Convolutional Neural Network");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(382, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel3.setText("Data testing count");

        from.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromActionPerformed(evt);
            }
        });

        jLabel4.setText("From   :");

        jLabel5.setText("Until    :");

        jButton1.setText("Testing Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        status.setText(" ");

        jLabel6.setText("Report");

        jLabel7.setText("a");

        berhasil_i.setText("...");

        jLabel9.setText("i");

        gagal_i.setText("...");

        persen_i.setText("...");

        jum_i.setText("...");

        jum_a.setText("....");

        gagal_a.setText("...");

        berhasil_a.setText("...");

        persen_a.setText("...");

        jLabel8.setText("u");

        jLabel10.setText("e");

        jLabel12.setText("o");

        jum_u.setText("....");

        jum_e.setText("....");

        jum_o.setText("....");

        gagal_u.setText("...");

        gagal_e.setText("...");

        gagal_o.setText("...");

        berhasil_u.setText("...");

        berhasil_e.setText("...");

        berhasil_o.setText("...");

        persen_u.setText("...");

        persen_e.setText("...");

        persen_o.setText("...");

        jLabel16.setText("ka");

        jLabel17.setText("ki");

        jLabel18.setText("ku");

        jLabel19.setText("ke");

        jLabel20.setText("ko");

        jLabel21.setText("sa");

        jLabel22.setText("shi");

        jum_ka.setText("....");

        jum_ki.setText("....");

        jum_ku.setText("....");

        jum_ke.setText("....");

        jum_ko.setText("....");

        jum_sa.setText("....");

        jum_shi.setText("....");

        gagal_ka.setText("...");

        gagal_ki.setText("...");

        gagal_ku.setText("...");

        gagal_ke.setText("...");

        gagal_ko.setText("...");

        gagal_sa.setText("...");

        gagal_shi.setText("...");

        berhasil_ka.setText("...");

        berhasil_ki.setText("...");

        berhasil_ku.setText("...");

        berhasil_ke.setText("...");

        berhasil_ko.setText("...");

        berhasil_sa.setText("...");

        berhasil_shi.setText("...");

        persen_ka.setText("...");

        persen_ki.setText("...");

        persen_ku.setText("...");

        persen_ke.setText("...");

        persen_ko.setText("...");

        persen_sa.setText("...");

        persen_shi.setText("...");

        totalgambar.setText("....");

        totalgagal.setText("...");

        totalberhasil.setText("...");

        totalpersen.setText("...");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Huruf", "Jumlah", "Gagal", "Berhasil", "Persentase"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(status, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(until))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton2))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(totalgambar)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jum_shi))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jum_ka))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jum_ki))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jum_ku))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jum_ke))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jum_ko))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jum_sa))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jum_u))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jum_e))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jum_o))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addGap(52, 52, 52)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jum_a, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jum_i, javax.swing.GroupLayout.Alignment.TRAILING)))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(gagal_i)
                                    .addComponent(gagal_a)
                                    .addComponent(gagal_o)
                                    .addComponent(gagal_e)
                                    .addComponent(gagal_u)
                                    .addComponent(gagal_ka))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(berhasil_i)
                                            .addComponent(berhasil_a)
                                            .addComponent(berhasil_o)
                                            .addComponent(berhasil_e)
                                            .addComponent(berhasil_u))
                                        .addGap(106, 106, 106)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(persen_i)
                                            .addComponent(persen_a)
                                            .addComponent(persen_o)
                                            .addComponent(persen_e)
                                            .addComponent(persen_u)
                                            .addComponent(persen_shi)
                                            .addComponent(persen_sa)
                                            .addComponent(persen_ko)
                                            .addComponent(persen_ke)
                                            .addComponent(persen_ku)
                                            .addComponent(persen_ki)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(berhasil_ka)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(persen_ka))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(gagal_shi)
                                    .addComponent(gagal_sa)
                                    .addComponent(gagal_ko)
                                    .addComponent(gagal_ke)
                                    .addComponent(gagal_ku)
                                    .addComponent(gagal_ki)
                                    .addComponent(totalgagal))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(berhasil_ki)
                                    .addComponent(berhasil_ku)
                                    .addComponent(berhasil_ke)
                                    .addComponent(berhasil_ko)
                                    .addComponent(berhasil_sa)
                                    .addComponent(berhasil_shi)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(totalberhasil)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(totalpersen)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(136, 136, 136)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel4)
                                                            .addComponent(jLabel7)
                                                            .addComponent(jum_a)
                                                            .addComponent(gagal_a))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel5)
                                                            .addComponent(until, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(138, 138, 138)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(persen_a)
                                                            .addComponent(berhasil_a))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel9)
                                                            .addComponent(jum_i)
                                                            .addComponent(gagal_i)
                                                            .addComponent(berhasil_i)
                                                            .addComponent(persen_i))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel8))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addGap(189, 189, 189)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jum_u)
                                                            .addComponent(gagal_u)
                                                            .addComponent(berhasil_u)
                                                            .addComponent(persen_u))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel10)
                                                    .addComponent(jum_e)
                                                    .addComponent(gagal_e)
                                                    .addComponent(berhasil_e)
                                                    .addComponent(persen_e))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jButton1)
                                                    .addComponent(jLabel12)
                                                    .addComponent(jum_o)
                                                    .addComponent(gagal_o)
                                                    .addComponent(berhasil_o)
                                                    .addComponent(persen_o))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel16)
                                                        .addComponent(berhasil_ka, javax.swing.GroupLayout.Alignment.TRAILING))
                                                    .addComponent(persen_ka)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(125, 125, 125)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jum_ka)
                                                    .addComponent(gagal_ka))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel17)
                                                .addComponent(jum_ki))
                                            .addComponent(persen_ki))
                                        .addGap(0, 12, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(gagal_ki)
                                                    .addComponent(berhasil_ki))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel18)
                                                    .addComponent(jum_ku)
                                                    .addComponent(gagal_ku)
                                                    .addComponent(berhasil_ku)))
                                            .addComponent(persen_ku, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(status))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel19)
                                            .addComponent(jum_ke)
                                            .addComponent(gagal_ke)
                                            .addComponent(berhasil_ke)
                                            .addComponent(persen_ke))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(jum_ko)
                                    .addComponent(gagal_ko)
                                    .addComponent(berhasil_ko)
                                    .addComponent(persen_ko))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(jum_sa)
                                    .addComponent(gagal_sa)
                                    .addComponent(berhasil_sa)
                                    .addComponent(persen_sa))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22)
                                    .addComponent(jum_shi)
                                    .addComponent(gagal_shi)
                                    .addComponent(berhasil_shi)
                                    .addComponent(persen_shi))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(totalgambar)
                                    .addComponent(totalgagal)
                                    .addComponent(totalberhasil)
                                    .addComponent(totalpersen))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(20, 20, 20))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        try {
            menuawal ma = new menuawal();
            ma.setVisible(true);
            this.setVisible(false);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(formTraining.class.getName()).log(Level.SEVERE, null, ex);

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        String str;
        convnet hm;

        try
        {
            String a = from.getText();
            String b = until.getText();

            int c = Integer.parseInt(a);
            int d = Integer.parseInt(b);

            try
            {
                hm = new convnet();
                hm.testing(this, Integer.parseInt(from.getText()), Integer.parseInt(until.getText()));
                str = "<html>" + "<font color = \"#FF0000\">" + "<b>" + "Testing Completed" + "</b>" + "</font>" + "</html>";

                status.setText(str);
            }
            catch(FileNotFoundException ex)
            {
                Logger.getLogger(formTesting.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(IOException ex)
            {
                Logger.getLogger(formTesting.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.kondisi = true;
        }
        catch(NumberFormatException nfe)
        {
            if(from.getText().equals("") || until.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Data Kosong!");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Masukkan harus angka!");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fromActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formTesting().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel berhasil_a;
    public javax.swing.JLabel berhasil_e;
    public javax.swing.JLabel berhasil_i;
    public javax.swing.JLabel berhasil_ka;
    public javax.swing.JLabel berhasil_ke;
    public javax.swing.JLabel berhasil_ki;
    public javax.swing.JLabel berhasil_ko;
    public javax.swing.JLabel berhasil_ku;
    public javax.swing.JLabel berhasil_o;
    public javax.swing.JLabel berhasil_sa;
    public javax.swing.JLabel berhasil_shi;
    public javax.swing.JLabel berhasil_u;
    private javax.swing.JTextField from;
    public javax.swing.JLabel gagal_a;
    public javax.swing.JLabel gagal_e;
    public javax.swing.JLabel gagal_i;
    public javax.swing.JLabel gagal_ka;
    public javax.swing.JLabel gagal_ke;
    public javax.swing.JLabel gagal_ki;
    public javax.swing.JLabel gagal_ko;
    public javax.swing.JLabel gagal_ku;
    public javax.swing.JLabel gagal_o;
    public javax.swing.JLabel gagal_sa;
    public javax.swing.JLabel gagal_shi;
    public javax.swing.JLabel gagal_u;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    public javax.swing.JLabel jum_a;
    public javax.swing.JLabel jum_e;
    public javax.swing.JLabel jum_i;
    public javax.swing.JLabel jum_ka;
    public javax.swing.JLabel jum_ke;
    public javax.swing.JLabel jum_ki;
    public javax.swing.JLabel jum_ko;
    public javax.swing.JLabel jum_ku;
    public javax.swing.JLabel jum_o;
    public javax.swing.JLabel jum_sa;
    public javax.swing.JLabel jum_shi;
    public javax.swing.JLabel jum_u;
    public javax.swing.JLabel persen_a;
    public javax.swing.JLabel persen_e;
    public javax.swing.JLabel persen_i;
    public javax.swing.JLabel persen_ka;
    public javax.swing.JLabel persen_ke;
    public javax.swing.JLabel persen_ki;
    public javax.swing.JLabel persen_ko;
    public javax.swing.JLabel persen_ku;
    public javax.swing.JLabel persen_o;
    public javax.swing.JLabel persen_sa;
    public javax.swing.JLabel persen_shi;
    public javax.swing.JLabel persen_u;
    private javax.swing.JLabel status;
    public javax.swing.JLabel totalberhasil;
    public javax.swing.JLabel totalgagal;
    public javax.swing.JLabel totalgambar;
    public javax.swing.JLabel totalpersen;
    private javax.swing.JTextField until;
    // End of variables declaration//GEN-END:variables

    

}
