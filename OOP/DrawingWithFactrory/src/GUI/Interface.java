package GUI;

import drawing.Factory;
import drawing.Shape;
import javax.swing.JOptionPane;

public class Interface extends javax.swing.JFrame {

    public Interface() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jSplitPane1 = new javax.swing.JSplitPane();
        jLabel4 = new javax.swing.JLabel();
        pnlSelection = new javax.swing.JToolBar();
        btnLine = new javax.swing.JToggleButton();
        btnCircle = new javax.swing.JToggleButton();
        btnEllipse = new javax.swing.JToggleButton();
        btnRectangle = new javax.swing.JToggleButton();
        btnRoundRectangle = new javax.swing.JToggleButton();
        pnlWorkplace = new javax.swing.JPanel();
        pnlInfo = new javax.swing.JPanel();
        lbStX = new javax.swing.JLabel();
        lbDnX = new javax.swing.JLabel();
        lbStY = new javax.swing.JLabel();
        lbDnY = new javax.swing.JLabel();
        mnMenu = new javax.swing.JMenuBar();
        btnFile = new javax.swing.JMenu();
        btnExit = new javax.swing.JMenuItem();
        btnEdit = new javax.swing.JMenu();
        btnClear = new javax.swing.JMenuItem();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Graphics - Andrey B.");
        setBackground(new java.awt.Color(230, 230, 230));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Myriad Pro", 0, 12)); // NOI18N
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(400, 400));
        setName("Interface"); // NOI18N

        pnlSelection.setRollover(true);
        pnlSelection.setToolTipText("Shapes for drawing");
        pnlSelection.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlSelection.setFont(new java.awt.Font("Myriad Pro", 0, 12)); // NOI18N
        pnlSelection.setName("pnlSelection"); // NOI18N

        btnLine.setText("Line");
        btnLine.setFocusable(false);
        btnLine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLine.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLineActionPerformed(evt);
            }
        });
        pnlSelection.add(btnLine);

        btnCircle.setText("Circle");
        btnCircle.setFocusable(false);
        btnCircle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCircle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCircle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCircleActionPerformed(evt);
            }
        });
        pnlSelection.add(btnCircle);

        btnEllipse.setText("Ellipse");
        btnEllipse.setFocusable(false);
        btnEllipse.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEllipse.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEllipse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEllipseActionPerformed(evt);
            }
        });
        pnlSelection.add(btnEllipse);

        btnRectangle.setText("Rectangle");
        btnRectangle.setFocusable(false);
        btnRectangle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRectangle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRectangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRectangleActionPerformed(evt);
            }
        });
        pnlSelection.add(btnRectangle);

        btnRoundRectangle.setText("Round Rectangle");
        btnRoundRectangle.setFocusable(false);
        btnRoundRectangle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRoundRectangle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRoundRectangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoundRectangleActionPerformed(evt);
            }
        });
        pnlSelection.add(btnRoundRectangle);

        pnlWorkplace.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlWorkplaceMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnlWorkplaceMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout pnlWorkplaceLayout = new javax.swing.GroupLayout(pnlWorkplace);
        pnlWorkplace.setLayout(pnlWorkplaceLayout);
        pnlWorkplaceLayout.setHorizontalGroup(
            pnlWorkplaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        pnlWorkplaceLayout.setVerticalGroup(
            pnlWorkplaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );

        pnlInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlInfo.setFont(new java.awt.Font("Myriad Pro", 0, 12)); // NOI18N

        lbStX.setText("X");

        lbDnX.setText("0000");

        lbStY.setText("Y");

        lbDnY.setText("0000");

        javax.swing.GroupLayout pnlInfoLayout = new javax.swing.GroupLayout(pnlInfo);
        pnlInfo.setLayout(pnlInfoLayout);
        pnlInfoLayout.setHorizontalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbStX)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDnX)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbStY)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDnY)
                .addContainerGap(304, Short.MAX_VALUE))
        );
        pnlInfoLayout.setVerticalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lbStX, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbDnX, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbStY)
                .addComponent(lbDnY))
        );

        mnMenu.setFont(new java.awt.Font("Myriad Pro", 0, 12)); // NOI18N
        mnMenu.setName("mnMenu"); // NOI18N

        btnFile.setText("File");

        btnExit.setText("Exit");
        btnFile.add(btnExit);

        mnMenu.add(btnFile);

        btnEdit.setText("Edit");

        btnClear.setText("Clear");
        btnEdit.add(btnClear);

        mnMenu.add(btnEdit);

        setJMenuBar(mnMenu);
        mnMenu.getAccessibleContext().setAccessibleName("mnMenu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSelection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlWorkplace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlWorkplace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlSelection.getAccessibleContext().setAccessibleName("pnlSelection");
        pnlWorkplace.getAccessibleContext().setAccessibleName("pnlWorkspace");
        pnlWorkplace.getAccessibleContext().setAccessibleDescription("");
        pnlInfo.getAccessibleContext().setAccessibleName("pnlInfo");
        pnlInfo.getAccessibleContext().setAccessibleDescription("Information about workplace");

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlWorkplaceMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlWorkplaceMouseMoved
        String currX = String.valueOf(evt.getX());
        lbDnX.setText(currX);
        String currY = String.valueOf(evt.getY());
        lbDnY.setText(currY);
    }//GEN-LAST:event_pnlWorkplaceMouseMoved
//Btns listender
    private void btnLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLineActionPerformed
        if (!btnCircle.isSelected() && !btnEllipse.isSelected() &&
            !btnRectangle.isSelected() && !btnRoundRectangle.isSelected()) {
        }
        else {
            btnCircle.setSelected(false);
            btnEllipse.setSelected(false); 
            btnRectangle.setSelected(false);
            btnRoundRectangle.setSelected(false);
        }
        
        Factory factory = new Factory();
        Shape shape = factory.getShape("btnLine");
        shape.draw();
    }//GEN-LAST:event_btnLineActionPerformed

    private void btnCircleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCircleActionPerformed
        if (!btnLine.isSelected() && !btnEllipse.isSelected() &&
            !btnRectangle.isSelected() && !btnRoundRectangle.isSelected()) {
        }
        else {
            btnLine.setSelected(false);
            btnEllipse.setSelected(false); 
            btnRectangle.setSelected(false);
            btnRoundRectangle.setSelected(false);
        }
        
        Factory factory = new Factory();
        Shape shape = factory.getShape(this.getName());
        shape.draw();
    }//GEN-LAST:event_btnCircleActionPerformed

    private void btnEllipseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEllipseActionPerformed
        if (!btnCircle.isSelected() && !btnLine.isSelected() &&
            !btnRectangle.isSelected() && !btnRoundRectangle.isSelected()) {
        }
        else {
            btnCircle.setSelected(false);
            btnLine.setSelected(false); 
            btnRectangle.setSelected(false);
            btnRoundRectangle.setSelected(false);
        }
        
        Factory factory = new Factory();
        Shape shape = factory.getShape(this.getName());
        shape.draw();
    }//GEN-LAST:event_btnEllipseActionPerformed

    private void btnRectangleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRectangleActionPerformed
        if (!btnCircle.isSelected() && !btnEllipse.isSelected() &&
            !btnLine.isSelected() && !btnRoundRectangle.isSelected()) {
        }
        else {
            btnCircle.setSelected(false);
            btnEllipse.setSelected(false); 
            btnLine.setSelected(false);
            btnRoundRectangle.setSelected(false);
        }
        
        Factory factory = new Factory();
        Shape shape = factory.getShape(this.getName());
        shape.draw();
    }//GEN-LAST:event_btnRectangleActionPerformed

    private void btnRoundRectangleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoundRectangleActionPerformed
        if (!btnCircle.isSelected() && !btnEllipse.isSelected() &&
            !btnRectangle.isSelected() && !btnLine.isSelected()) {
        }
        else {
            btnCircle.setSelected(false);
            btnEllipse.setSelected(false); 
            btnRectangle.setSelected(false);
            btnLine.setSelected(false);
        }
        
        Factory factory = new Factory();
        Shape shape = factory.getShape(this.getName());
        shape.draw();
    }//GEN-LAST:event_btnRoundRectangleActionPerformed

    private void pnlWorkplaceMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlWorkplaceMouseDragged
// graphics image - bacup ; getstartx,y getlastx,y - draw
// line arg xy
//...
    }//GEN-LAST:event_pnlWorkplaceMouseDragged

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
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCircle;
    private javax.swing.JMenuItem btnClear;
    private javax.swing.JMenu btnEdit;
    private javax.swing.JToggleButton btnEllipse;
    private javax.swing.JMenuItem btnExit;
    private javax.swing.JMenu btnFile;
    private javax.swing.JToggleButton btnLine;
    private javax.swing.JToggleButton btnRectangle;
    private javax.swing.JToggleButton btnRoundRectangle;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lbDnX;
    private javax.swing.JLabel lbDnY;
    private javax.swing.JLabel lbStX;
    private javax.swing.JLabel lbStY;
    private javax.swing.JMenuBar mnMenu;
    private javax.swing.JPanel pnlInfo;
    private javax.swing.JToolBar pnlSelection;
    private javax.swing.JPanel pnlWorkplace;
    // End of variables declaration//GEN-END:variables
}
