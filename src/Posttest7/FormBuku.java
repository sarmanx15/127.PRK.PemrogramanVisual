/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Posttest7;
import Posttest6.*;
import java.sql.*;// mengimport java sql
import javax.swing.JOptionPane;//mengimport java swing untuk jendela konfirmasi pesan
import javax.swing.table.DefaultTableModel;// mengimport tabel model
/**
 *
 * @author acer
 */
public class FormBuku extends javax.swing.JFrame {
private DefaultTableModel model;//membuat model pada tabel
private Connection con = koneksi.getConnection();//mengambil koneksi dari file koneksi.java
private Statement stt;//untuk mengeksekusi query mysql
private ResultSet rss;// untuk menampung data dari database
    /**
     * Creates new form FormBuku
     */
    public FormBuku() {
        initComponents();// digunakan untuk memanggil fungsi formbuku
    }
     private void InitTable(){
        model = new DefaultTableModel(); // membuat model tabel baru
        model.addColumn("ID");
        model.addColumn("JUDUL");// menambah kolum pada tabel dengan nama JUDUL
        model.addColumn("PENULIS");// menambah kolum pada tabel dengan nama PENULIS
        model.addColumn("HARGA");// menambah kolum pada tabel dengan nama HARGA
        
        jTable1.setModel(model);// memberikan model pada jtable1
    }
     
     private void TampilData(){//method untuk menampilkan data
        try{// coba untuk mengecek error
            String sql = "SELECT * FROM buku"; // query mysql untuk menampilkan semua data dari tabel buku
            stt = con.createStatement();// memanggil koneksi
            rss = stt.executeQuery(sql);// mengeksekusi query yang ada pada variabel sql
            while(rss.next()){//melakukan perulangan untuk menampilkan data
                Object[] o = new Object[4];//tipe data objek dengan 3 elemen
                o[0] = rss.getString("id");
                o[1] = rss.getString("judul");//elemen pertama untuk menampilkan judul
                o[2] = rss.getString("penulis");// elemen kedua untuk menampilkan penulis
                o[3] = rss.getInt("harga");// elemen ketiga untuk menampilkan harga
                model.addRow(o);//menambah row pada model
            }
            
        }catch(SQLException e){//menangkap jika terjadi error
            System.out.println(e.getMessage());//menampilkan pesan error
        }
    }
     private void TambahData(String judul, String penulis, String harga){// method untuk menambah data pada table
        try{// coba untuk mengecek error
            String sql = "INSERT INTO buku VALUES(NULL,'"+judul+"','"+penulis+"',"+harga+")";// menginsertkan data pada variabel buku
            stt = con.createStatement();// memanggil koneksi
            stt.executeUpdate(sql);//mengeksekusi query yang ada pada bariable sq;
            model.addRow(new Object[]{judul,penulis,harga});//menambah 1 baris data dengan elemen objek berupa judul,penulis,harga
        }catch(SQLException e){//menangkap jika ada terjadi error
            System.out.println(e.getMessage());// menampillkan pesan error
        }
        InitTable();
        TampilData();
    }
    public boolean UbahData(String id, String judul, String penulis, String harga){
        try{
            String sql = "UPDATE buku set judul = '"+judul+"', penulis = '"+penulis+"', harga = "+harga+" WHERE id = "+id+";";
            stt = con.createStatement();
            stt.executeUpdate(sql);
            return true;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean validasi(String judul, String penulis){
        try{
            String sql = "Select *from buku where judul = '"+judul+"' and penulis = '"+penulis+"';";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            if(rss.next())
                return true;
            else 
                return false;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            return true;
        }
    }
    
    public boolean HapusData(String id){
        try{
            String sql = "DELETE FROM buku WHERE id = "+id+";";
            stt = con.createStatement();
            stt.executeUpdate(sql);
            return true;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
      private void PencarianData(String by, String cari){
        try{
            String sql = "Select *from buku where "+by+" Like '%"+cari+"%';";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
                Object[] data = new Object[4];
                data[0] = rss.getString("id");
                data[1] = rss.getString("judul");
                data[2] = rss.getString("penulis");
                data[3] = rss.getInt("harga");
                model.addRow(data);
            }
        }
            catch(Exception e){
                    System.out.println(e.getMessage());
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfJudul = new javax.swing.JTextField();
        tfHarga = new javax.swing.JTextField();
        cbPenulis = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        tfCari = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbCari = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Data Buku");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(276, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Simple Design By 1515015127");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, -1));

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Tambah Data");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Judul");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Penulis");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Harga");

        tfJudul.setText("tfJudul");
        tfJudul.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfJudulCaretUpdate(evt);
            }
        });
        tfJudul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfJudulActionPerformed(evt);
            }
        });

        tfHarga.setText("tfHarga");
        tfHarga.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfHargaCaretUpdate(evt);
            }
        });

        cbPenulis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Penulis Buku", "Tere Liye", "W.S Rendra", "Felix Siauw", "Asma Nadia", "Dewi Lestari" }));

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Posttest6/img/Save.png"))); // NOI18N
        btnSimpan.setText("SIMPAN");
        btnSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSimpanMouseClicked(evt);
            }
        });
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel5.add(btnSimpan);

        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Posttest6/img/Update.png"))); // NOI18N
        btnUbah.setText("UBAH");
        btnUbah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUbahMouseClicked(evt);
            }
        });
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        jPanel5.add(btnUbah);

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Posttest6/img/Delete.png"))); // NOI18N
        btnHapus.setText("HAPUS");
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
        });
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel5.add(btnHapus);

        btnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Posttest6/img/Exit.png"))); // NOI18N
        btnKeluar.setText("KELUAR");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });
        jPanel5.add(btnKeluar);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Daftar Buku");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Cari");

        tfCari.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfCariCaretUpdate(evt);
            }
        });
        tfCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCariActionPerformed(evt);
            }
        });
        tfCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCariKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("By");

        cbCari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cari Berdasarkan", "Judul", "Penulis", "Harga" }));
        cbCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbCariMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbCariMousePressed(evt);
            }
        });
        cbCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbPenulis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfHarga)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(27, 27, 27)
                                .addComponent(tfJudul))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jSeparator1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbCari, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbPenulis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfJudulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfJudulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfJudulActionPerformed

    private void btnSimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btnSimpanMouseClicked

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
            
            
        if((cbPenulis.getSelectedItem().toString().equals("Pilih Penulis Buku")) || 
            Float.parseFloat(tfHarga.getText())<=0
                ){// melakukan pengecekkan jika syarat terpenuhi, baris perintah dibawah akan dijalankan
            JOptionPane.showMessageDialog(null, "Pilih Penulis atau harga tidak boleh 0 atau huruf","Konfirmasi",JOptionPane.INFORMATION_MESSAGE);
            //kode diatas untuk menampilkan sebuah jendela konfirmasi yang berisi pesan "Pilih Penulis atau harga tidak boleh 0 atau huruf"
        }
        else{
            String judul = tfJudul.getText();//menginisialisasi judul, nerisi nilai dari tfjudul (textfield)
            String penulis = cbPenulis.getSelectedItem().toString();//menginisialisasi penulis, dengan nilai dari cbpenulis (combobox)
            String harga = tfHarga.getText();// menginisialisasi harga dengan nilai dari tfHarga (textfield)
            if(validasi(judul,penulis)){
                JOptionPane.showMessageDialog(null, "Penulis dan Judul sudah tersedia","Konfirmasi",JOptionPane.INFORMATION_MESSAGE);
        }
            else{
                TambahData(judul,penulis,harga);//memanggil method tambahdata dengan membawa parameter berupa variabel judul, penulis, harga
        }
        }
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btnUbahMouseClicked

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btnHapusMouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int baris = jTable1.getSelectedRow();
        String id = jTable1.getValueAt(baris, 0).toString();
        if(HapusData(id)){
            JOptionPane.showMessageDialog(null, "Berhasil Hapus Data");
        }
        else{
            JOptionPane.showConfirmDialog(null, "Gagal Hapus Data");
            
        }
        InitTable();TampilData();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0); //untuk keluar dari program
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        InitTable();//memanggil method initdata pada saat even ini berjalan
        TampilData();//memanggil method tammpildata pada saat even ini berjalan
    }//GEN-LAST:event_formComponentShown

    private void cbCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCariMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_cbCariMouseClicked

    private void tfCariCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfCariCaretUpdate
        // TODO add your handling code here:
        if(cbCari.getSelectedItem().equals("Cari Berdasarkan")){//jika pada combobox yang terseleksi masih"cari bardasarkan, maka jalankan perintah berikut
             JOptionPane.showMessageDialog(null, "Pilih Filter Pencarian","Konfirmasi",JOptionPane.INFORMATION_MESSAGE);
             //sintak diatas untuk menampilkan pesan dialog beruppa kofirmasi
        }
        else{
        InitTable();
        if(tfCari.getText().length()==0){
            TampilData();
        }
        else{
            PencarianData(cbCari.getSelectedItem().toString(), tfCari.getText());
            
        }
        }
    }//GEN-LAST:event_tfCariCaretUpdate

    private void cbCariMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCariMousePressed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_cbCariMousePressed

    private void cbCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCariActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbCariActionPerformed

    private void tfCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCariKeyTyped

    }//GEN-LAST:event_tfCariKeyTyped

    private void tfJudulCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfJudulCaretUpdate
        // TODO add your handling code here:
        if(tfJudul.getText().length()==0 || tfHarga.getText().length()==0 ){
            btnSimpan.setEnabled(false);
        }
        else{
            btnSimpan.setEnabled(true);
        }
        //sintak diatas untuk melakukan pengecekan jika beberapa textfile pada seleksi kondisinya tidak terisi maka tombol simpan tidak bisa digunakan
    }//GEN-LAST:event_tfJudulCaretUpdate

    private void tfHargaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfHargaCaretUpdate
        // TODO add your handling code here:
        if(tfJudul.getText().length()==0 || tfHarga.getText().length()==0){
            btnSimpan.setEnabled(false);
        }
        else{
            btnSimpan.setEnabled(true);
        }
        //sintak diatas untuk melakukan pengecekan jika beberapa textfile pada seleksi kondisinya tidak terisi maka tombol simpan tidak bisa digunakan
    }//GEN-LAST:event_tfHargaCaretUpdate

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        tfJudul.setText("");
        tfHarga.setText("");
        
        //sintak diatas digunakan untuk mengeset nilai pada textfield menjadi kosong dan mendisablejn tombol hapus dan ubah
    }//GEN-LAST:event_formWindowOpened

    private void tfCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCariActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         int baris = jTable1.getSelectedRow();
        tfJudul.setText(jTable1.getValueAt(baris,1).toString());
        cbPenulis.setSelectedItem(jTable1.getValueAt(baris, 2).toString());
        tfHarga.setText(jTable1.getValueAt(baris, 3).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        int baris = jTable1.getSelectedRow();
        String id = jTable1.getValueAt(baris, 0).toString();
        String judul = tfJudul.getText();
        String penulis = cbPenulis.getSelectedItem().toString();
        String harga = tfHarga.getText();
        if(UbahData(id,judul,penulis,harga)){
            JOptionPane.showMessageDialog(null, "Berhasil Ubah Data");
        }
        else{
            JOptionPane.showConfirmDialog(null, "Gagal Ubah Data");
            
        }
        InitTable();TampilData();
    }//GEN-LAST:event_btnUbahActionPerformed

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
            java.util.logging.Logger.getLogger(FormBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cbCari;
    private javax.swing.JComboBox<String> cbPenulis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tfCari;
    private javax.swing.JTextField tfHarga;
    private javax.swing.JTextField tfJudul;
    // End of variables declaration//GEN-END:variables
}
