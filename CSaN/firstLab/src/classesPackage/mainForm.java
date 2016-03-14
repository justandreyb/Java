package classesPackage;


import java.awt.Graphics;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Андрей
 */
public class mainForm extends javax.swing.JFrame {

    /**
     * Creates new form mainForm
     */
    public mainForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        panelFigures = new javax.swing.JTabbedPane();
        pLine = new javax.swing.JPanel();
        pLineClear = new javax.swing.JToggleButton();
        pLineDraw = new javax.swing.JButton();
        pRectangle = new javax.swing.JPanel();
        pRectangleDraw = new javax.swing.JButton();
        pRectangleClear = new javax.swing.JToggleButton();
        pEllipse = new javax.swing.JPanel();
        pEllipseDraw = new javax.swing.JButton();
        pEllipseClear = new javax.swing.JToggleButton();
        pTriangle = new javax.swing.JPanel();
        pRectangle3DDraw = new javax.swing.JButton();
        pRectangle3DClear = new javax.swing.JToggleButton();
        pPentagon = new javax.swing.JPanel();
        pPentagonDraw = new javax.swing.JButton();
        pPentagonClear = new javax.swing.JToggleButton();
        pCircle = new javax.swing.JPanel();
        pCircleDraw = new javax.swing.JButton();
        pCircleClear = new javax.swing.JToggleButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OOP - Andrey B.");
        setFocusable(false);
        setName("mainF"); // NOI18N
        setResizable(false);

        panelFigures.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(108, 108, 108), new java.awt.Color(153, 153, 153), null, null));
        panelFigures.setForeground(new java.awt.Color(137, 137, 137));
        panelFigures.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        panelFigures.setToolTipText("");
        panelFigures.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelFigures.setName(""); // NOI18N

        pLineClear.setSelected(true);
        pLineClear.setText("Clear");

        pLineDraw.setText("Draw");
        pLineDraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pLineDrawActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pLineLayout = new javax.swing.GroupLayout(pLine);
        pLine.setLayout(pLineLayout);
        pLineLayout.setHorizontalGroup(
            pLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pLineLayout.createSequentialGroup()
                .addComponent(pLineDraw, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pLineClear, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
        );
        pLineLayout.setVerticalGroup(
            pLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(pLineClear, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(pLineDraw, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelFigures.addTab("Line", pLine);

        pRectangleDraw.setText("Draw");
        pRectangleDraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pRectangleDrawActionPerformed(evt);
            }
        });

        pRectangleClear.setSelected(true);
        pRectangleClear.setText("Clear");

        javax.swing.GroupLayout pRectangleLayout = new javax.swing.GroupLayout(pRectangle);
        pRectangle.setLayout(pRectangleLayout);
        pRectangleLayout.setHorizontalGroup(
            pRectangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pRectangleLayout.createSequentialGroup()
                .addComponent(pRectangleDraw, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pRectangleClear, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
        );
        pRectangleLayout.setVerticalGroup(
            pRectangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRectangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(pRectangleClear, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addComponent(pRectangleDraw, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
        );

        panelFigures.addTab("Rectangle", pRectangle);

        pEllipseDraw.setText("Draw");
        pEllipseDraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pEllipseDrawActionPerformed(evt);
            }
        });

        pEllipseClear.setSelected(true);
        pEllipseClear.setText("Clear");

        javax.swing.GroupLayout pEllipseLayout = new javax.swing.GroupLayout(pEllipse);
        pEllipse.setLayout(pEllipseLayout);
        pEllipseLayout.setHorizontalGroup(
            pEllipseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEllipseLayout.createSequentialGroup()
                .addComponent(pEllipseDraw, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pEllipseClear, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
        );
        pEllipseLayout.setVerticalGroup(
            pEllipseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEllipseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(pEllipseClear, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addComponent(pEllipseDraw, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
        );

        panelFigures.addTab("Ellipse", pEllipse);

        pRectangle3DDraw.setText("Draw");
        pRectangle3DDraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pRectangle3DDrawActionPerformed(evt);
            }
        });

        pRectangle3DClear.setSelected(true);
        pRectangle3DClear.setText("Clear");

        javax.swing.GroupLayout pTriangleLayout = new javax.swing.GroupLayout(pTriangle);
        pTriangle.setLayout(pTriangleLayout);
        pTriangleLayout.setHorizontalGroup(
            pTriangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTriangleLayout.createSequentialGroup()
                .addComponent(pRectangle3DDraw, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pRectangle3DClear, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
        );
        pTriangleLayout.setVerticalGroup(
            pTriangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTriangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(pRectangle3DClear, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addComponent(pRectangle3DDraw, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
        );

        panelFigures.addTab("Rectangle 3D", pTriangle);

        pPentagonDraw.setText("Draw");

        pPentagonClear.setSelected(true);
        pPentagonClear.setText("Clear");

        javax.swing.GroupLayout pPentagonLayout = new javax.swing.GroupLayout(pPentagon);
        pPentagon.setLayout(pPentagonLayout);
        pPentagonLayout.setHorizontalGroup(
            pPentagonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPentagonLayout.createSequentialGroup()
                .addComponent(pPentagonDraw, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pPentagonClear, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
        );
        pPentagonLayout.setVerticalGroup(
            pPentagonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPentagonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(pPentagonClear, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addComponent(pPentagonDraw, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
        );

        panelFigures.addTab("Pentagon", pPentagon);

        pCircleDraw.setText("Draw");

        pCircleClear.setSelected(true);
        pCircleClear.setText("Clear");

        javax.swing.GroupLayout pCircleLayout = new javax.swing.GroupLayout(pCircle);
        pCircle.setLayout(pCircleLayout);
        pCircleLayout.setHorizontalGroup(
            pCircleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pCircleLayout.createSequentialGroup()
                .addComponent(pCircleDraw, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pCircleClear, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
        );
        pCircleLayout.setVerticalGroup(
            pCircleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCircleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(pCircleClear, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addComponent(pCircleDraw, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
        );

        panelFigures.addTab("Circle", pCircle);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFigures, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 229, Short.MAX_VALUE)
                .addComponent(panelFigures, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelFigures.getAccessibleContext().setAccessibleName("panelFigures");

        getAccessibleContext().setAccessibleName("mainF");
        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Line - Draw 
    private void pLineDrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pLineDrawActionPerformed
        if (pLineClear.isSelected())
            repaint();
        
        JOptionPane Dialog = new JOptionPane();
        Graphics Picture = getGraphics();
        
        try {
            String inputStr = Dialog.showInputDialog("Position X : ");
            int recX = Integer.parseInt(inputStr);
            inputStr = Dialog.showInputDialog ("Position Y :") ; 
            int recY = Integer.parseInt(inputStr);
            inputStr = JOptionPane.showInputDialog ("Position X on form :") ; 
            int recFormX = Integer.parseInt(inputStr);
            inputStr = JOptionPane.showInputDialog ("Position Y on form :") ; 
            int recFormY = Integer.parseInt(inputStr);

            Figures currLine = new Line(recX, recY, recFormX, recFormY);
            currLine.Draw(Picture);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Incorrect input");
        }
               
    }//GEN-LAST:event_pLineDrawActionPerformed

    private void pRectangleDrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pRectangleDrawActionPerformed
        if (pRectangleClear.isSelected())
            repaint();
        
        JOptionPane Dialog = new JOptionPane();
        Graphics Picture = getGraphics();
        
        try {
            String inputStr = Dialog.showInputDialog("Position X : ");
            int recX = Integer.parseInt(inputStr);
            inputStr = Dialog.showInputDialog ("Position Y :") ; 
            int recY = Integer.parseInt(inputStr);
            inputStr = JOptionPane.showInputDialog ("On form width :") ; 
            int recFormWidth = Integer.parseInt(inputStr);
            inputStr = JOptionPane.showInputDialog ("On form height :") ; 
            int recFormHeight = Integer.parseInt(inputStr);

            Figures currFigure = new Rectangle(recX, recY, recFormWidth, recFormHeight);
            currFigure.Draw(Picture);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Incorrect input");
        }
         
    }//GEN-LAST:event_pRectangleDrawActionPerformed

    private void pEllipseDrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pEllipseDrawActionPerformed
        if (pEllipseClear.isSelected())
            repaint();
        
        JOptionPane Dialog = new JOptionPane();
        Graphics Picture = getGraphics();
        
        try {
            String inputStr = Dialog.showInputDialog("Position X : ");
            int recX = Integer.parseInt(inputStr);
            inputStr = Dialog.showInputDialog ("Position Y :") ; 
            int recY = Integer.parseInt(inputStr);
            inputStr = JOptionPane.showInputDialog ("On form width :") ; 
            int recFormWidth = Integer.parseInt(inputStr);
            inputStr = JOptionPane.showInputDialog ("On form height :") ; 
            int recFormHeight = Integer.parseInt(inputStr);

            Figures currFigure = new Ellipse(recX, recY, recFormWidth, recFormHeight);
            currFigure.Draw(Picture);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Incorrect input");
        }
    
    }//GEN-LAST:event_pEllipseDrawActionPerformed

    private void pRectangle3DDrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pRectangle3DDrawActionPerformed
        if (pRectangle3DClear.isSelected())
            repaint();
        
        JOptionPane Dialog = new JOptionPane();
        Graphics Picture = getGraphics();
        
        try {
            String inputStr = Dialog.showInputDialog("Position X : ");
            int recX = Integer.parseInt(inputStr);
            inputStr = Dialog.showInputDialog ("Position Y :") ; 
            int recY = Integer.parseInt(inputStr);
            inputStr = JOptionPane.showInputDialog ("On form width :") ; 
            int recFormWidth = Integer.parseInt(inputStr);
            inputStr = JOptionPane.showInputDialog ("On form height :") ; 
            int recFormHeight = Integer.parseInt(inputStr);
            //int recRaised = JOptionPane.showInternalConfirmDialog(null, "Is raised ?", "Question", JOptionPane.YES_NO_OPTION);
            //
            int messageType = JOptionPane.QUESTION_MESSAGE;
            String[] options = {"Raised", "Not raised"};
            int recRaised = JOptionPane.showInternalOptionDialog(
                getContentPane(), 
                "This figure is raised ?", 
                "Question", 0, messageType, 
                null, options, "Raised");
            
            //
            Figures currFigure = new rectangle3D(recX, recY, recFormWidth, recFormHeight, recRaised);
            currFigure.Draw(Picture);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Incorrect input");
        }
    
    }//GEN-LAST:event_pRectangle3DDrawActionPerformed

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
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel pCircle;
    private javax.swing.JToggleButton pCircleClear;
    private javax.swing.JButton pCircleDraw;
    private javax.swing.JPanel pEllipse;
    private javax.swing.JToggleButton pEllipseClear;
    private javax.swing.JButton pEllipseDraw;
    private javax.swing.JPanel pLine;
    private javax.swing.JToggleButton pLineClear;
    private javax.swing.JButton pLineDraw;
    private javax.swing.JPanel pPentagon;
    private javax.swing.JToggleButton pPentagonClear;
    private javax.swing.JButton pPentagonDraw;
    private javax.swing.JPanel pRectangle;
    private javax.swing.JToggleButton pRectangle3DClear;
    private javax.swing.JButton pRectangle3DDraw;
    private javax.swing.JToggleButton pRectangleClear;
    private javax.swing.JButton pRectangleDraw;
    private javax.swing.JPanel pTriangle;
    private javax.swing.JTabbedPane panelFigures;
    // End of variables declaration//GEN-END:variables
}