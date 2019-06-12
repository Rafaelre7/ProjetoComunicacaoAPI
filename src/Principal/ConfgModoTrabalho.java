/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import com.digi.xbee.api.XBeeDevice;
import com.digi.xbee.api.exceptions.XBeeException;
import com.digi.xbee.api.utils.HexUtils;
import java.awt.Dialog;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class ConfgModoTrabalho extends javax.swing.JFrame {

    private MainApp ma;
    public static boolean frmPortaOpened = false;
    private ConexaoFrame conexaoFrame;

    /**
     * Creates new form ConfgXbee
     */
    public ConfgModoTrabalho(ConexaoFrame conexFrame) {

        initComponents();
        ImageIcon icone = new ImageIcon(getClass().getResource("/Img/icone.png"));
        setIconImage(icone.getImage());
        setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
        setLocationRelativeTo(null);

        this.conexaoFrame = conexFrame;
        XBeeDevice xBee = conexFrame.getMainApp().getxBee();

        //condição para habilitar os botoes se a conexão ja estiver aberta
        if (xBee.isOpen()) {
            this.btnEnviarWork.setEnabled(true);
        } else {
            this.btnEnviarWork.setEnabled(false);
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

        jLabel3 = new javax.swing.JLabel();
        panelNome = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfDescricao = new javax.swing.JTextField();
        btnEnviarDescricao = new javax.swing.JToggleButton();
        panelPreamble = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbPreambulo = new javax.swing.JComboBox<>();
        btnEnviarPream = new javax.swing.JToggleButton();
        panelRede = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfRede = new javax.swing.JTextField();
        btnEnviarWork3 = new javax.swing.JToggleButton();
        panelMdoWork = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbModo = new javax.swing.JComboBox<>();
        btnEnviarWork = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configuração Xbee");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Configuração Xbee");

        panelNome.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição Xbee"));
        panelNome.setPreferredSize(new java.awt.Dimension(300, 180));

        jLabel1.setText("Entre com a descrição desejada..:");

        btnEnviarDescricao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Send_24x24.png"))); // NOI18N
        btnEnviarDescricao.setText("Enviar");
        btnEnviarDescricao.setToolTipText("");
        btnEnviarDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarDescricaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelNomeLayout = new javax.swing.GroupLayout(panelNome);
        panelNome.setLayout(panelNomeLayout);
        panelNomeLayout.setHorizontalGroup(
            panelNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDescricao)
                    .addGroup(panelNomeLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 86, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNomeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEnviarDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelNomeLayout.setVerticalGroup(
            panelNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNomeLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(btnEnviarDescricao)
                .addGap(15, 15, 15))
        );

        panelPreamble.setBorder(javax.swing.BorderFactory.createTitledBorder("Preambulo ID Xbee"));
        panelPreamble.setPreferredSize(new java.awt.Dimension(300, 180));

        jLabel5.setText("Selecione o Preamble ID..:");

        cbPreambulo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", " " }));

        btnEnviarPream.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Send_24x24.png"))); // NOI18N
        btnEnviarPream.setText("Enviar");
        btnEnviarPream.setToolTipText("");
        btnEnviarPream.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarPreamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPreambleLayout = new javax.swing.GroupLayout(panelPreamble);
        panelPreamble.setLayout(panelPreambleLayout);
        panelPreambleLayout.setHorizontalGroup(
            panelPreambleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPreambleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPreambleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPreambulo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelPreambleLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 131, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPreambleLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEnviarPream, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelPreambleLayout.setVerticalGroup(
            panelPreambleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPreambleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(cbPreambulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(btnEnviarPream)
                .addGap(15, 15, 15))
        );

        panelRede.setBorder(javax.swing.BorderFactory.createTitledBorder("Rede Xbee"));
        panelRede.setPreferredSize(new java.awt.Dimension(300, 180));

        jLabel4.setText("Entre com a rede desejada..:");

        btnEnviarWork3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Send_24x24.png"))); // NOI18N
        btnEnviarWork3.setText("Enviar");
        btnEnviarWork3.setToolTipText("");
        btnEnviarWork3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarWork3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRedeLayout = new javax.swing.GroupLayout(panelRede);
        panelRede.setLayout(panelRedeLayout);
        panelRedeLayout.setHorizontalGroup(
            panelRedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfRede)
                    .addGroup(panelRedeLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 117, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRedeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEnviarWork3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelRedeLayout.setVerticalGroup(
            panelRedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(tfRede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btnEnviarWork3)
                .addGap(15, 15, 15))
        );

        panelMdoWork.setBorder(javax.swing.BorderFactory.createTitledBorder("Modo de Trabalho Xbee"));
        panelMdoWork.setPreferredSize(new java.awt.Dimension(300, 180));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setText("Selecione o modo de trabalho..:");

        cbModo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Transparent Mode [0]", "API Mode Without Escapes [1]", "API Mode With Escapes [2]" }));

        btnEnviarWork.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Send_24x24.png"))); // NOI18N
        btnEnviarWork.setText("Enviar");
        btnEnviarWork.setToolTipText("");
        btnEnviarWork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarWorkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMdoWorkLayout = new javax.swing.GroupLayout(panelMdoWork);
        panelMdoWork.setLayout(panelMdoWorkLayout);
        panelMdoWorkLayout.setHorizontalGroup(
            panelMdoWorkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMdoWorkLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMdoWorkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbModo, 0, 278, Short.MAX_VALUE)
                    .addGroup(panelMdoWorkLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMdoWorkLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEnviarWork, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelMdoWorkLayout.setVerticalGroup(
            panelMdoWorkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMdoWorkLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbModo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btnEnviarWork)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(260, 260, 260))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPreamble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelMdoWork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPreamble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelMdoWork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarWorkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarWorkActionPerformed

        //obtem o preambulo selecionado
        String modo = cbModo.getSelectedItem().toString();
        String modo1 = String.valueOf(cbModo.getSelectedIndex());

        XBeeDevice xBee = this.conexaoFrame.getMainApp().getxBee();

        try {
            //Alterando preambulo
//            xBee.setParameter("AP", HexUtils.hexStringToByteArray(modo1));
            xBee.setParameter("AP", HexUtils.hexStringToByteArray(modo1));

            JOptionPane.showMessageDialog(null, "Alterado modo de trabalho para : " + modo);

            abrir();
//            this.dispose();

        } catch (Exception ex) {

            this.btnEnviarWork.setEnabled(true);
            JOptionPane.showMessageDialog(this, "Error: " + ex);

        }

    }//GEN-LAST:event_btnEnviarWorkActionPerformed

    private void btnEnviarDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarDescricaoActionPerformed
        // TODO add your handling code here:
        //obtem o preambulo selecionado
        String descricao = tfDescricao.getText();

        XBeeDevice xBee = this.conexaoFrame.getMainApp().getxBee();

        try {

            xBee.setParameter("NI", HexUtils.hexStringToByteArray(descricao));
            xBee.setParameter("NI", descricao.getBytes());
            xBee.setNodeID(descricao);
            alert("Descrição alterada com sucesso !");

            abrir();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnEnviarDescricaoActionPerformed

    private void btnEnviarPreamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarPreamActionPerformed
        // TODO add your handling code here:
        //obtem o preambulo selecionado
        String preambulo = cbPreambulo.getSelectedItem().toString();

        XBeeDevice xBee = this.conexaoFrame.getMainApp().getxBee();

        try {
            //Alterando preambulo
            xBee.setParameter("HP", HexUtils.hexStringToByteArray(preambulo));

            alert("Alterado Preambule com sucesso ,Atual: " + preambulo);
            abrir();

//            this.dispose();
        } catch (Exception ex) {

            this.btnEnviarPream.setEnabled(true);
            JOptionPane.showMessageDialog(this, "Error: " + ex);

        }
    }//GEN-LAST:event_btnEnviarPreamActionPerformed

    private void btnEnviarWork3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarWork3ActionPerformed
        //obtem a rede selecionada
        String rede = tfRede.getText();

        XBeeDevice xBee = this.conexaoFrame.getMainApp().getxBee();
        try {
            // Atribui o ID de rede
//            xBee.setPANID(HexUtils.hexStringToByteArray(rede));
            xBee.setParameter("ID", HexUtils.hexStringToByteArray(rede));
            alert("Rede alterada com sucesso !");
            
            abrir();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnEnviarWork3ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        abrir();
    }//GEN-LAST:event_formWindowOpened

    private void abrir() {
        if (this.conexaoFrame.getMainApp().getxBee().isOpen()) {
            try {

                XBeeDevice xBee = this.conexaoFrame.getMainApp().getxBee();

                tfDescricao.setText(xBee.getNodeID());
                tfRede.setText(HexUtils.byteArrayToHexString(xBee.getPANID()));
                cbModo.setSelectedIndex(1);
                int preambulo = Integer.parseInt(HexUtils.byteArrayToHexString(xBee.getParameter("HP")));
                cbPreambulo.setSelectedIndex(preambulo);
                cbModo.setSelectedIndex(2);
            } catch (XBeeException e) {
                e.printStackTrace();
                alert("Ocorreu um erro");
            }

        } else {
            System.out.println("fechado");
        }

    }

    private void alert(String msg) {
        JOptionPane.showMessageDialog(null, msg);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnEnviarDescricao;
    private javax.swing.JToggleButton btnEnviarPream;
    private javax.swing.JToggleButton btnEnviarWork;
    private javax.swing.JToggleButton btnEnviarWork3;
    private javax.swing.JComboBox<String> cbModo;
    private javax.swing.JComboBox<String> cbPreambulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel panelMdoWork;
    private javax.swing.JPanel panelNome;
    private javax.swing.JPanel panelPreamble;
    private javax.swing.JPanel panelRede;
    private javax.swing.JTextField tfDescricao;
    private javax.swing.JTextField tfRede;
    // End of variables declaration//GEN-END:variables
}
