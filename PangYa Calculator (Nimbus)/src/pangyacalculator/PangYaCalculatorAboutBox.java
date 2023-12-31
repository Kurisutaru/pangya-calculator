/*
 * PangYaCalculatorAboutBox.java
 */

package pangyacalculator;

import org.jdesktop.application.Action;

public class PangYaCalculatorAboutBox extends javax.swing.JDialog {

    public PangYaCalculatorAboutBox(java.awt.Frame parent) {
        super(parent);
        initComponents();
        getRootPane().setDefaultButton(closeButton);
    }

    PangYaCalculatorAboutBox() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Action public void closeAboutBox() {
        dispose();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        closeButton = new javax.swing.JButton();
        javax.swing.JLabel appTitleLabel = new javax.swing.JLabel();
        javax.swing.JLabel versionLabel = new javax.swing.JLabel();
        javax.swing.JLabel appVersionLabel = new javax.swing.JLabel();
        javax.swing.JLabel vendorLabel = new javax.swing.JLabel();
        javax.swing.JLabel appVendorLabel = new javax.swing.JLabel();
        javax.swing.JLabel homepageLabel = new javax.swing.JLabel();
        javax.swing.JLabel appHomepageLabel = new javax.swing.JLabel();
        javax.swing.JLabel appDescLabel = new javax.swing.JLabel();
        javax.swing.JLabel imageLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel homepageLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pangyacalculator.PangYaCalculatorApps.class).getContext().getResourceMap(PangYaCalculatorAboutBox.class);
        setTitle(resourceMap.getString("title")); // NOI18N
        setModal(true);
        setName("aboutBox"); // NOI18N
        setResizable(false);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(pangyacalculator.PangYaCalculatorApps.class).getContext().getActionMap(PangYaCalculatorAboutBox.class, this);
        closeButton.setAction(actionMap.get("closeAboutBox")); // NOI18N
        closeButton.setName("closeButton"); // NOI18N

        appTitleLabel.setFont(appTitleLabel.getFont().deriveFont(appTitleLabel.getFont().getStyle() | java.awt.Font.BOLD, appTitleLabel.getFont().getSize()+4));
        appTitleLabel.setText(resourceMap.getString("Application.title")); // NOI18N
        appTitleLabel.setName("appTitleLabel"); // NOI18N

        versionLabel.setFont(versionLabel.getFont().deriveFont(versionLabel.getFont().getStyle() | java.awt.Font.BOLD));
        versionLabel.setText(resourceMap.getString("versionLabel.text")); // NOI18N
        versionLabel.setName("versionLabel"); // NOI18N

        appVersionLabel.setText(resourceMap.getString("Application.version")); // NOI18N
        appVersionLabel.setName("appVersionLabel"); // NOI18N

        vendorLabel.setFont(vendorLabel.getFont().deriveFont(vendorLabel.getFont().getStyle() | java.awt.Font.BOLD));
        vendorLabel.setText(resourceMap.getString("vendorLabel.text")); // NOI18N
        vendorLabel.setName("vendorLabel"); // NOI18N

        appVendorLabel.setText(resourceMap.getString("Application.vendor")); // NOI18N
        appVendorLabel.setName("appVendorLabel"); // NOI18N

        homepageLabel.setFont(homepageLabel.getFont().deriveFont(homepageLabel.getFont().getStyle() | java.awt.Font.BOLD));
        homepageLabel.setText(resourceMap.getString("homepageLabel.text")); // NOI18N
        homepageLabel.setName("homepageLabel"); // NOI18N

        appHomepageLabel.setText(resourceMap.getString("Application.homepage")); // NOI18N
        appHomepageLabel.setName("appHomepageLabel"); // NOI18N

        appDescLabel.setText(resourceMap.getString("appDescLabel.text")); // NOI18N
        appDescLabel.setName("appDescLabel"); // NOI18N

        imageLabel.setIcon(resourceMap.getIcon("imageLabel.icon")); // NOI18N
        imageLabel.setName("imageLabel"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setIcon(resourceMap.getIcon("jLabel3.icon")); // NOI18N
        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        homepageLabel1.setFont(homepageLabel1.getFont().deriveFont(homepageLabel1.getFont().getStyle() | java.awt.Font.BOLD));
        homepageLabel1.setText(resourceMap.getString("homepageLabel1.text")); // NOI18N
        homepageLabel1.setName("homepageLabel1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imageLabel)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(appTitleLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(versionLabel)
                                .addGap(6, 6, 6)
                                .addComponent(appVersionLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(vendorLabel)
                                .addGap(52, 52, 52)
                                .addComponent(appVendorLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(homepageLabel)
                                .addGap(65, 65, 65)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(homepageLabel1)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel2)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3))
                            .addComponent(appDescLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeButton)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabel)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(appTitleLabel)
                .addGap(6, 6, 6)
                .addComponent(appDescLabel)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(versionLabel)
                    .addComponent(appVersionLabel))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vendorLabel)
                    .addComponent(appVendorLabel))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homepageLabel)
                    .addComponent(jLabel1))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homepageLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2))
                    .addComponent(jLabel3))
                .addGap(166, 166, 166)
                .addComponent(closeButton))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
    
}
