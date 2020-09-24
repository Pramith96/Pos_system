/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controller.CustomerController;
import controller.ItemController;
import controller.OrderController;
import db.DBConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import dto.CustomerDTO;
import dto.ItemDTO;
import dto.OrderDetailDTO;
import dto.OrdersDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author sanu-vithanage
 */
public class OrderForm extends javax.swing.JFrame {

    DefaultTableModel dtm;

    /**
     * Creates new form OrderForm
     */
    public OrderForm() {
        initComponents();
        loadAllCustomers();
        loadItems();
        genarateOID();
        setDate();
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtOrderID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbCustomer = new javax.swing.JComboBox<String>();
        jLabel4 = new javax.swing.JLabel();
        txtCustomerAddress = new javax.swing.JTextField();
        txtOrderDate = new javax.swing.JTextField();
        txtCustomerName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtQtyOnHand = new javax.swing.JTextField();
        txtUnitPrice = new javax.swing.JTextField();
        cmbItem = new javax.swing.JComboBox<String>();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtQty = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtBalance = new javax.swing.JTextField();
        txtDiscount = new javax.swing.JTextField();
        txtPaid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnProceed = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        lbltotal1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("OrderForm");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtOrderID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrderIDActionPerformed(evt);
            }
        });
        jPanel2.add(txtOrderID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        jLabel2.setText("OrderID");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        cmbCustomer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCustomerItemStateChanged(evt);
            }
        });
        jPanel2.add(cmbCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 120, 30));

        jLabel4.setText("Customer Address");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));
        jPanel2.add(txtCustomerAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 160, 30));

        txtOrderDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrderDateActionPerformed(evt);
            }
        });
        jPanel2.add(txtOrderDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 160, -1));
        jPanel2.add(txtCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 160, 30));

        jLabel5.setText("Customer ID");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel6.setText("Customer Name");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        jLabel15.setText("Order Date");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 370, 220));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("Unit Price");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, -1));

        jLabel11.setText("Qty");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));
        jPanel3.add(txtQtyOnHand, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 150, -1));
        jPanel3.add(txtUnitPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 150, -1));

        cmbItem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbItemItemStateChanged(evt);
            }
        });
        jPanel3.add(cmbItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 120, 30));

        jLabel10.setText("Item Name");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jLabel9.setText("Item Code");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });
        txtQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQtyKeyPressed(evt);
            }
        });
        jPanel3.add(txtQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 160, 30));

        jLabel7.setText("Qty On Hand");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));
        jPanel3.add(txtDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 160, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 370, 220));

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Name", "Price", "QOH", "Qty", "Totall"
            }
        ));
        tblOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblOrder);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 610, 240));

        jLabel12.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel12.setText("Rs:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 320, 40, -1));

        lbltotal.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lbltotal.setText("0000.000");
        jPanel1.add(lbltotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 320, 120, -1));

        jLabel14.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel14.setText("Total");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 290, 70, -1));
        jPanel1.add(txtBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 490, 150, 30));

        txtDiscount.setText("0");
        txtDiscount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDiscountFocusGained(evt);
            }
        });
        txtDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiscountActionPerformed(evt);
            }
        });
        txtDiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDiscountKeyReleased(evt);
            }
        });
        jPanel1.add(txtDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 150, 30));

        txtPaid.setText("0");
        txtPaid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPaidFocusGained(evt);
            }
        });
        txtPaid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPaidKeyReleased(evt);
            }
        });
        jPanel1.add(txtPaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 440, 150, 30));

        jLabel3.setText("Balance");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 470, -1, -1));

        jLabel16.setText("Discount");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 370, -1, -1));

        jLabel17.setText("Paid");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, -1, -1));

        jButton1.setText("Search");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 550, 90, 30));

        btnProceed.setText("Proceed");
        btnProceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProceedActionPerformed(evt);
            }
        });
        jPanel1.add(btnProceed, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 550, 90, 30));

        jButton3.setText("Remove");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, -1, -1));

        jLabel18.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel18.setText("Final");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 550, 70, -1));

        lbltotal1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lbltotal1.setText("0000.000");
        jPanel1.add(lbltotal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 550, 120, -1));

        jLabel13.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel13.setText("Rs:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 550, 40, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtOrderIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrderIDActionPerformed
        txtOrderDate.requestFocus();
    }//GEN-LAST:event_txtOrderIDActionPerformed

    private void txtOrderDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrderDateActionPerformed
        cmbCustomer.requestFocus();
    }//GEN-LAST:event_txtOrderDateActionPerformed

    private void cmbCustomerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCustomerItemStateChanged
        String cusID = cmbCustomer.getSelectedItem().toString();
        try {
            CustomerDTO searchCustomer = CustomerController.searchCustomer(cusID);
            txtCustomerName.setText(searchCustomer.getName());
            txtCustomerAddress.setText(searchCustomer.getAddress());
            cmbItem.requestFocus();
        } catch (SQLException ex) {
            Logger.getLogger(OrderForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(OrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbCustomerItemStateChanged

    private void cmbItemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbItemItemStateChanged

        try {
            String itemCode = cmbItem.getSelectedItem().toString();
            ItemDTO searchItem = ItemController.searchItem(itemCode);
            txtDescription.setText(searchItem.getDescription());
            txtQtyOnHand.setText(Integer.toString(searchItem.getQty()));
            txtUnitPrice.setText(Double.toString(searchItem.getUnitPrice()));
            txtQty.requestFocus();
        } catch (SQLException ex) {
            Logger.getLogger(OrderForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(OrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbItemItemStateChanged

    private void txtQtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyPressed
        if (evt.getKeyCode() == 16) {
            txtDiscount.requestFocus();
        }

    }//GEN-LAST:event_txtQtyKeyPressed

    private void txtDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiscountActionPerformed
        txtPaid.requestFocus();
    }//GEN-LAST:event_txtDiscountActionPerformed

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyActionPerformed
        try {
            String itemCode = cmbItem.getSelectedItem().toString();
            String itemName = txtDescription.getText();
            double unitPrice = Double.parseDouble(txtUnitPrice.getText());
            int qtyOnHand = Integer.parseInt(txtQtyOnHand.getText());
            int qty = Integer.parseInt(txtQty.getText());
            double total = unitPrice * qty;

            dtm = (DefaultTableModel) tblOrder.getModel();
            if (!checkItemDuplicate(itemCode)) {
                Object[] row = {itemCode, itemName, unitPrice, qtyOnHand, qty, total};
                dtm.addRow(row);
            } else {
//                JOptionPane.showMessageDialog(this, "Item Duplicated", "Error", JOptionPane.ERROR_MESSAGE);
            }

            calculateTotal();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            txtQty.setText("");
        }

    }//GEN-LAST:event_txtQtyActionPerformed


    private void tblOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderMouseClicked
        JTable table = (JTable) evt.getSource();
        int selectedRow = table.getSelectedRow();
        dtm.removeRow(selectedRow);
        calculateTotal();
    }//GEN-LAST:event_tblOrderMouseClicked

    private void txtDiscountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiscountKeyReleased

        try {
            double total = Double.parseDouble(lbltotal.getText().trim());
            double discount = Double.parseDouble(txtDiscount.getText().trim());
            double updateTotla = total * (100 - discount) / 100;
            lbltotal1.setText("" + updateTotla);
        } catch (NumberFormatException e) {
            txtDiscount.setText("0");
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtDiscountKeyReleased

    private void txtDiscountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiscountFocusGained
        txtDiscount.selectAll();
    }//GEN-LAST:event_txtDiscountFocusGained

    private void txtPaidFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPaidFocusGained
        txtPaid.selectAll();
    }//GEN-LAST:event_txtPaidFocusGained

    private void txtPaidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaidKeyReleased
        double finalTotal = Double.parseDouble(lbltotal1.getText());
        double customerPaidAmount = Double.parseDouble(txtPaid.getText());
        double balance = customerPaidAmount - finalTotal;
        txtBalance.setText(Double.toString(balance));
    }//GEN-LAST:event_txtPaidKeyReleased

    private void btnProceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProceedActionPerformed
        try {
            String orderID = txtOrderID.getText();
            String orderDate = txtOrderDate.getText();
            String customerID = cmbCustomer.getSelectedItem().toString();
            String customerName = txtCustomerName.getText();
            String customerAddress = txtCustomerAddress.getText();
            double total = Double.parseDouble(lbltotal.getText());
            double discount = Double.parseDouble(txtDiscount.getText());
            double paid = Double.parseDouble(txtPaid.getText());
            double balance = Double.parseDouble(txtBalance.getText());

            OrdersDTO dto = new OrdersDTO(orderID, orderDate, customerID);
            ArrayList<OrderDetailDTO> allOrderDetails = new ArrayList<>();
            for (int i = 0; i < dtm.getRowCount(); i++) {
                String itemCode = dtm.getValueAt(i, 0).toString();
                double itemPrice = Double.parseDouble(dtm.getValueAt(i, 2).toString());
                int qty = Integer.parseInt(dtm.getValueAt(i, 4).toString());
                String orderIDD = txtOrderID.getText();
                OrderDetailDTO orderDetails = new OrderDetailDTO(orderIDD, itemCode, qty, itemPrice);
                allOrderDetails.add(orderDetails);
            }

            boolean purchaseOrder = OrderController.purchaseOrder(dto, allOrderDetails);
            if (purchaseOrder) {
                JOptionPane.showMessageDialog(this, "Aded..!", "Done", JOptionPane.INFORMATION_MESSAGE);
                //            print the report
                InputStream is = this.getClass().getResourceAsStream("/reports/invoice.jasper");
                HashMap mapForParamentersvalues = new HashMap();
                mapForParamentersvalues.put("orderID", orderID);
                mapForParamentersvalues.put("customerID", customerID);
                mapForParamentersvalues.put("name", customerName);
                mapForParamentersvalues.put("address", customerAddress);
                mapForParamentersvalues.put("total", total);
                mapForParamentersvalues.put("discount", discount);
                mapForParamentersvalues.put("paid", paid);
                mapForParamentersvalues.put("balance", balance);

                JasperPrint print = JasperFillManager.fillReport(is, mapForParamentersvalues, new JRTableModelDataSource(dtm));
                JasperViewer.viewReport(print, false);
            } else {
                JOptionPane.showMessageDialog(this, "Not Aded..!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (JRException ex) {
            Logger.getLogger(OrderForm.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnProceedActionPerformed

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
            java.util.logging.Logger.getLogger(OrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProceed;
    private javax.swing.JComboBox<String> cmbCustomer;
    private javax.swing.JComboBox<String> cmbItem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JLabel lbltotal1;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtCustomerAddress;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtOrderDate;
    private javax.swing.JTextField txtOrderID;
    private javax.swing.JTextField txtPaid;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtQtyOnHand;
    private javax.swing.JTextField txtUnitPrice;
    // End of variables declaration//GEN-END:variables

    private void loadAllCustomers() {
        try {
            ArrayList<CustomerDTO> allCustomers = CustomerController.getAllCustomers();
            for (CustomerDTO allCustomer : allCustomers) {
                cmbCustomer.addItem(allCustomer.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(OrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void calculateTotal() {
        double total = 0;
        for (int i = 0; i < dtm.getRowCount(); i++) {
            total += Double.parseDouble(dtm.getValueAt(i, 5).toString());
        }
        lbltotal.setText(total + "");
        lbltotal1.setText(total + "");
        double discount = Double.parseDouble(txtDiscount.getText().trim());
        if (discount > 0) {
            double total2 = Double.parseDouble(lbltotal.getText().trim());
            double updateTotla = total2 * (100 - discount) / 100;
            lbltotal1.setText("" + updateTotla);
        }

    }

    private void loadItems() {
        try {
            ArrayList<ItemDTO> allItems = ItemController.getAllItems();
            for (ItemDTO allItem : allItems) {
                cmbItem.addItem(allItem.getCode());
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(OrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void genarateOID() {
        int id = new Random().nextInt(5000000);
        txtOrderID.setText("OID" + id);
    }

    private void setDate() {
        txtOrderDate.setText(LocalDate.now().toString());
    }

    private boolean checkItemDuplicate(String itemCode) {
        for (int i = 0; i < dtm.getRowCount(); i++) {
            String adedItems = dtm.getValueAt(i, 0).toString();
            if (itemCode == adedItems) {
                int oldQty = Integer.parseInt(dtm.getValueAt(i, 4).toString());
                int newQty = Integer.parseInt(txtQty.getText());
                int updateQty = (oldQty + newQty);
                double itemPrice = Double.parseDouble(dtm.getValueAt(i, 2).toString());
                double updatedPrice = updateQty * itemPrice;
                dtm.setValueAt(updateQty, i, 4);
                dtm.setValueAt(updatedPrice, i, 5);
                calculateTotal();
                return true;
            }
        }
        return false;
    }
}
