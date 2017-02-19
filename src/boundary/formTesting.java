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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        totalgambar = new javax.swing.JLabel();
        berhasil = new javax.swing.JLabel();
        gagal = new javax.swing.JLabel();
        akurasi = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

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
                .addContainerGap(186, Short.MAX_VALUE))
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

        totalgambar.setText("...");

        berhasil.setText("...");

        gagal.setText("...");

        akurasi.setText("...");

        jLabel11.setText("Total Gambar   :");

        jLabel13.setText("Berhasil            :");

        jLabel14.setText("Gagal               :");

        jLabel15.setText("Akurasi            :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(berhasil)
                    .addComponent(totalgambar)
                    .addComponent(gagal)
                    .addComponent(akurasi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(totalgambar)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(until, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(berhasil)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(gagal))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(akurasi)
                                .addComponent(jLabel15)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(status)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 135, Short.MAX_VALUE))))
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
    public javax.swing.JLabel akurasi;
    public javax.swing.JLabel berhasil;
    private javax.swing.JTextField from;
    public javax.swing.JLabel gagal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JLabel status;
    public javax.swing.JLabel totalgambar;
    private javax.swing.JTextField until;
    // End of variables declaration//GEN-END:variables

    

}
