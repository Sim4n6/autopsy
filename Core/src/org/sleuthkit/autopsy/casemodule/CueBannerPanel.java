/*
 * Autopsy Forensic Browser
 *
 * Copyright 2011-2018 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.casemodule;

import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.KeyStroke;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;
import org.openide.windows.WindowManager;

/*
 * The panel in the default Autopsy startup window.
 */
@SuppressWarnings("PMD.SingularField") // UI widgets cause lots of false positives
public class CueBannerPanel extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;
    /*
     * This is field is static for the sake of the closeOpenRecentCasesWindow
     * method.
     */
    private static JDialog recentCasesWindow;

    public static void closeOpenRecentCasesWindow() {
        if (null != recentCasesWindow) {
            recentCasesWindow.setVisible(false);
        }
    }

    public CueBannerPanel() {
        initComponents();
        initRecentCasesWindow();
        enableComponents();
    }

    public CueBannerPanel(String welcomeLogo) {
        initComponents();
        ClassLoader cl = Lookup.getDefault().lookup(ClassLoader.class);
        if (cl != null) {
            ImageIcon icon = new ImageIcon(cl.getResource(welcomeLogo));
            autopsyLogo.setIcon(icon);
        }
        initRecentCasesWindow();
        enableComponents();
    }

    public void setCloseButtonActionListener(ActionListener e) {
        closeButton.addActionListener(e);
    }

    public void setCloseButtonText(String text) {
        closeButton.setText(text);
    }

    public void refresh() {
        enableComponents();
    }

    private void initRecentCasesWindow() {
        recentCasesWindow = new JDialog(
                WindowManager.getDefault().getMainWindow(),
                NbBundle.getMessage(CueBannerPanel.class, "CueBannerPanel.title.text"),
                Dialog.ModalityType.APPLICATION_MODAL);
        recentCasesWindow.setSize(new Dimension(750, 400));
        recentCasesWindow.getRootPane().registerKeyboardAction(
                e -> {
                    recentCasesWindow.setVisible(false);
                },
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
        OpenRecentCasePanel recentCasesPanel = OpenRecentCasePanel.getInstance();
        recentCasesPanel.setCloseButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recentCasesWindow.setVisible(false);
            }
        });
        recentCasesWindow.add(recentCasesPanel);
        recentCasesWindow.pack();
        recentCasesWindow.setResizable(false);
    }

    private void enableComponents() {
        boolean enableOpenRecentCaseButton = (RecentCases.getInstance().getTotalRecentCases() > 0);
        openRecentCaseButton.setEnabled(enableOpenRecentCaseButton);
        openRecentCaseLabel.setEnabled(enableOpenRecentCaseButton);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        autopsyLogo = new javax.swing.JLabel();
        this.autopsyLogo.setText("");
        newCaseButton = new javax.swing.JButton();
        openRecentCaseButton = new javax.swing.JButton();
        newCaseLabel = new javax.swing.JLabel();
        openRecentCaseLabel = new javax.swing.JLabel();
        openCaseButton = new javax.swing.JButton();
        openCaseLabel = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        autopsyLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/casemodule/welcome_logo.png"))); // NOI18N
        autopsyLogo.setText(org.openide.util.NbBundle.getMessage(CueBannerPanel.class, "CueBannerPanel.autopsyLogo.text")); // NOI18N

        newCaseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/casemodule/btn_icon_create_new_case.png"))); // NOI18N
        newCaseButton.setText(org.openide.util.NbBundle.getMessage(CueBannerPanel.class, "CueBannerPanel.newCaseButton.text")); // NOI18N
        
        Border newCaseBorder = BorderFactory.createRaisedBevelBorder();
        newCaseButton.setBorder(newCaseBorder);
        
        newCaseButton.setBorderPainted(false);
        newCaseButton.setContentAreaFilled(false);
        newCaseButton.setPreferredSize(new java.awt.Dimension(64, 64));
        newCaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCaseButtonActionPerformed(evt);
            }
        });

        openRecentCaseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/casemodule/btn_icon_open_recent.png"))); // NOI18N
        openRecentCaseButton.setText(org.openide.util.NbBundle.getMessage(CueBannerPanel.class, "CueBannerPanel.openRecentCaseButton.text")); // NOI18N
        
        Border openRecentCaseBorder = BorderFactory.createRaisedBevelBorder();
        openRecentCaseButton.setBorder(openRecentCaseBorder);
        
        openRecentCaseButton.setBorderPainted(false);
        openRecentCaseButton.setContentAreaFilled(false);
        openRecentCaseButton.setPreferredSize(new java.awt.Dimension(64, 64));
        openRecentCaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openRecentCaseButtonActionPerformed(evt);
            }
        });

        newCaseLabel.setFont(newCaseLabel.getFont().deriveFont(newCaseLabel.getFont().getStyle() & ~java.awt.Font.BOLD, 13));
        newCaseLabel.setText(org.openide.util.NbBundle.getMessage(CueBannerPanel.class, "CueBannerPanel.newCaseLabel.text")); // NOI18N

        openRecentCaseLabel.setFont(openRecentCaseLabel.getFont().deriveFont(openRecentCaseLabel.getFont().getStyle() & ~java.awt.Font.BOLD, 13));
        openRecentCaseLabel.setText(org.openide.util.NbBundle.getMessage(CueBannerPanel.class, "CueBannerPanel.openRecentCaseLabel.text")); // NOI18N

        openCaseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/casemodule/btn_icon_open_existing.png"))); // NOI18N
        openCaseButton.setText(org.openide.util.NbBundle.getMessage(CueBannerPanel.class, "CueBannerPanel.openCaseButton.text")); // NOI18N
        
        Border openCaseBorder = BorderFactory.createRaisedBevelBorder();
        openCaseButton.setBorder(openCaseBorder);
        
        openCaseButton.setBorderPainted(false);
        openCaseButton.setContentAreaFilled(false);
        openCaseButton.setMargin(new java.awt.Insets(1, 1, 1, 1));
        openCaseButton.setPreferredSize(new java.awt.Dimension(64, 64));
        openCaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openCaseButtonActionPerformed(evt);
            }
        });

        openCaseLabel.setFont(openCaseLabel.getFont().deriveFont(openCaseLabel.getFont().getStyle() & ~java.awt.Font.BOLD, 13));
        openCaseLabel.setText(org.openide.util.NbBundle.getMessage(CueBannerPanel.class, "CueBannerPanel.openCaseLabel.text")); // NOI18N

        closeButton.setFont(closeButton.getFont().deriveFont(closeButton.getFont().getStyle() & ~java.awt.Font.BOLD, 11));
        closeButton.setText(org.openide.util.NbBundle.getMessage(CueBannerPanel.class, "CueBannerPanel.closeButton.text")); // NOI18N

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(autopsyLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(newCaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(openRecentCaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(openCaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newCaseLabel)
                            .addComponent(openRecentCaseLabel)
                            .addComponent(openCaseLabel))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(autopsyLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(newCaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(newCaseLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(openRecentCaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(openRecentCaseLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(openCaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(openCaseLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(closeButton))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void newCaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCaseButtonActionPerformed
        Lookup.getDefault().lookup(CaseNewActionInterface.class).actionPerformed(evt);
    }//GEN-LAST:event_newCaseButtonActionPerformed

    private void openCaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openCaseButtonActionPerformed
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        Lookup.getDefault().lookup(CaseOpenAction.class).actionPerformed(evt);
        setCursor(null);
    }//GEN-LAST:event_openCaseButtonActionPerformed

    private void openRecentCaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openRecentCaseButtonActionPerformed
        recentCasesWindow.setLocationRelativeTo(this);
        OpenRecentCasePanel.getInstance();  //refreshes the recent cases table
        recentCasesWindow.setVisible(true);
    }//GEN-LAST:event_openRecentCaseButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel autopsyLogo;
    private javax.swing.JButton closeButton;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton newCaseButton;
    private javax.swing.JLabel newCaseLabel;
    private javax.swing.JButton openCaseButton;
    private javax.swing.JLabel openCaseLabel;
    private javax.swing.JButton openRecentCaseButton;
    private javax.swing.JLabel openRecentCaseLabel;
    // End of variables declaration//GEN-END:variables

}
