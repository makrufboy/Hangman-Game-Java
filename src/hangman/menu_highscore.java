/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import hangman.koneksidb;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableModel;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class menu_highscore extends javax.swing.JFrame {
    private Dimension layar;
    private DefaultTableModel Model;
    
    
    /**
     * Creates new form menu_highscore
     */
    public menu_highscore() {
        initComponents();
        
        setTitle("Form Score");
        //Agar posisi form diTengah :
        layar = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((layar.width / 2) - (getSize().width / 2),
        (layar.height / 2) - (getSize().height / 2));
        
        //Untuk Atur Header Table :
        Model=new DefaultTableModel();
        tblGaji.setModel(Model);
        
        Model.addColumn("No");
        Model.addColumn("Nama");
        Model.addColumn("Score");
        
        //Mengambil nilai dari Method :
        AmbilData();
    }
     public void AmbilData() {
        //Menghapus Seluruh Data
        Model.getDataVector().removeAllElements();
        //Memberitahu bahwa data kosong
        Model.fireTableDataChanged();
        
        try {
            //Memanggil koneksi :
            Connection c=koneksidb.getConnection();
            //Membaca perintah SQL static di JAVA :
            Statement stmt=c.createStatement();
            //Perintah QUERY :
            String sql = "select *from player inner join score on player.id_player=score.id_player order by point asc;";
            //Menjalankan perintah Query :
            ResultSet rs=stmt.executeQuery(sql);
            
            while (rs.next()) {
                Object[] o=new Object[4];
                o[0]=rs.getInt("id_player");
                o[1]=rs.getString("nama_player");
                o[2]=rs.getInt("point");
                Model.addRow(o);
            }
            rs.close();
            stmt.close();
            
        } catch (SQLException e) {
            System.out.println("Terjadi Error dalam pengambilan data"+e);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGaji = new javax.swing.JTable();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Kristen ITC", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("HIGH SCORE");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(400, 20, 150, 40);

        jLabel3.setFont(new java.awt.Font("Chiller", 1, 45)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 51));
        jLabel3.setText(" HANGMAN ");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 20, 200, 59);

        jLabel4.setFont(new java.awt.Font("Chiller", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 102));
        jLabel4.setText("GUESS THE WORD!");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 70, 150, 40);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/titan.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(10, 350, 80, 100);

        tblGaji.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblGaji);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(220, 70, 540, 340);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/highh.PNG"))); // NOI18N
        jPanel1.add(Background);
        Background.setBounds(0, 0, 790, 450);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        form_utama d = new form_utama();
        d.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(menu_highscore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_highscore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_highscore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_highscore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_highscore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblGaji;
    // End of variables declaration//GEN-END:variables
}
