
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.apache.commons.dbutils.DbUtils;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class PharmacistFrame extends javax.swing.JFrame {


    Connection conn = null;
    ResultSet rs=null;
    Statement stmt=null;
    PreparedStatement pstmt=null;
    String sold;
    int Selectedrow=-1;
    
    public PharmacistFrame() {
       initComponents();
       fillTable();
       getnotifications();
       
        
    }
    public void fillTable(){
       int barcodeNum; 
       String medicine;
       String company;
       int stock ; 
       float price;
       String sql="select * from drugs";
       try{
           conn = DriverManager.getConnection("jdbc:mysql://localhost/pharmacistlogin","root","Mstf0411!!");
           stmt=  conn.createStatement();
           rs=stmt.executeQuery(sql);
           while(rs.next()){
                barcodeNum=rs.getInt(1); 
                medicine=rs.getString(2);
                company=rs.getString(3);
                stock=rs.getInt(4); 
                price=rs.getFloat(5);
                DefaultTableModel model = (DefaultTableModel)DrugTable.getModel();
                model.addRow(new Object[]{barcodeNum,medicine,company,stock,price});
                
           }
       }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
        }
       
    }
    
    public void exportTable(File file ) throws IOException {
        
        TableModel model=(DefaultTableModel)DrugTable.getModel();
        FileWriter out = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(out);
        
        for(int i=0; i<model.getColumnCount(); i++) {
            bw.write(model.getColumnName(i)+"\t");
        }
        bw.write("\n");
        for(int i=0;i<model.getRowCount();i++) {
            for(int j=0;j<model.getColumnCount();j++){
                bw.write(model.getValueAt(i,j)+"\t");
            }
            bw.write("\n");
        }
        bw.close();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        insertbtn = new javax.swing.JButton();
        salebtn = new javax.swing.JButton();
        offerbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        DrugTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextArea = new javax.swing.JTextArea();
        searchbtn = new javax.swing.JButton();
        addtostockbtn = new javax.swing.JButton();
        exportbtn = new javax.swing.JButton();
        searchfield = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TextAreaforOffers = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        TextAreaForSearch = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        insertbtn.setText("INSERT");
        insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtnActionPerformed(evt);
            }
        });

        salebtn.setText("SALE");
        salebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salebtnActionPerformed(evt);
            }
        });

        offerbtn.setText("SEE SPECIAL OFFERS");
        offerbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offerbtnActionPerformed(evt);
            }
        });

        DrugTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barcode Number", "Medicine", "Company", "Stock", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        DrugTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DrugTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DrugTable);

        TextArea.setColumns(20);
        TextArea.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        TextArea.setRows(5);
        jScrollPane2.setViewportView(TextArea);

        searchbtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\KULLANICI-PC\\Documents\\NetBeansProjects\\stock_management\\SAVEBUTTON.png")); // NOI18N
        searchbtn.setPreferredSize(new java.awt.Dimension(51, 24));
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });

        addtostockbtn.setText("ADD TO STOCK");
        addtostockbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtostockbtnActionPerformed(evt);
            }
        });

        exportbtn.setText("EXPORT");
        exportbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportbtnActionPerformed(evt);
            }
        });

        searchfield.setForeground(new java.awt.Color(102, 102, 102));
        searchfield.setText("Barcode Number");
        searchfield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchfieldMouseClicked(evt);
            }
        });
        searchfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchfieldActionPerformed(evt);
            }
        });

        TextAreaforOffers.setColumns(20);
        TextAreaforOffers.setRows(5);
        jScrollPane3.setViewportView(TextAreaforOffers);

        TextAreaForSearch.setColumns(20);
        TextAreaForSearch.setRows(5);
        jScrollPane4.setViewportView(TextAreaForSearch);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(insertbtn)
                                .addGap(4, 4, 4)
                                .addComponent(salebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addtostockbtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exportbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3)
                            .addComponent(offerbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(insertbtn)
                            .addComponent(salebtn)
                            .addComponent(addtostockbtn)
                            .addComponent(exportbtn)
                            .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(offerbtn, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void getnotifications(){
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost/pharmacistlogin","root","Mstf0411!!");
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("Select * from drugs where stocknumber<=3 and stocknumber>=1" );
            String Notifications="Drugs are about to run out of Stock:\n";
            while(rs.next()){
                Notifications=Notifications+"Drug Name:"+rs.getString(2)+"\n";
                
            }
            TextArea.setText(Notifications);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    public void sale(int number){
        TableModel model=(DefaultTableModel)DrugTable.getModel();
        sold=model.getValueAt(Selectedrow, 1).toString();
        try{
            JOptionPane.showMessageDialog(null,sold+" is sold");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/pharmacistlogin","root","Mstf0411!!");
            pstmt = conn.prepareStatement("update drugs set stocknumber=stocknumber - ? where name=? and stocknumber>0");
            pstmt.setInt(1, number);
            pstmt.setString(2,sold);
            pstmt.executeUpdate();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    private void salebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salebtnActionPerformed
       int saleamount=Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the sale amount"));
       sale(saleamount);
       this.setVisible(false);
       new PharmacistFrame().setVisible(true);
    }//GEN-LAST:event_salebtnActionPerformed

    private void insertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbtnActionPerformed
       this.setVisible(false);
       new insertframe().setVisible(true);
    }//GEN-LAST:event_insertbtnActionPerformed

    private void offerbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_offerbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_offerbtnActionPerformed

    private void addtostockbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtostockbtnActionPerformed
        this.setVisible(false);
        new updateframe().setVisible(true);
    }//GEN-LAST:event_addtostockbtnActionPerformed

    private void exportbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportbtnActionPerformed
        try{
            exportTable( new File("C:/Users/KULLANICI-PC/Documents/NetBeansProjects/stock_management/test.xls"));
            JOptionPane.showMessageDialog(null, "The drug list is saved to the file");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_exportbtnActionPerformed
    public void search(){
        int search = Integer.parseInt(searchfield.getText());
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost/pharmacistlogin","root","Mstf0411!!");
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("Select * from drugs" );
            while(rs.next()){
                if(rs.getInt(1)==search)
                    TextAreaForSearch.setText("Barcode:"+rs.getString(1)+"\nName:"+rs.getString(2)+"\nStock:"+rs.getString(4)+"\nPrice:"+rs.getString(5));
                    
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
    
        search();
    }//GEN-LAST:event_searchbtnActionPerformed

    private void DrugTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DrugTableMouseClicked

        Selectedrow=DrugTable.getSelectedRow();
    }//GEN-LAST:event_DrugTableMouseClicked

    private void searchfieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchfieldMouseClicked
        boolean i=true;
        while(i){
            searchfield.setText("");
            i=false;
        }
        
    }//GEN-LAST:event_searchfieldMouseClicked

    private void searchfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchfieldActionPerformed

   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PharmacistFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DrugTable;
    private javax.swing.JTextArea TextArea;
    private javax.swing.JTextArea TextAreaForSearch;
    private javax.swing.JTextArea TextAreaforOffers;
    private javax.swing.JButton addtostockbtn;
    private javax.swing.JButton exportbtn;
    private javax.swing.JButton insertbtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton offerbtn;
    private javax.swing.JButton salebtn;
    private javax.swing.JButton searchbtn;
    private javax.swing.JTextField searchfield;
    // End of variables declaration//GEN-END:variables
}
