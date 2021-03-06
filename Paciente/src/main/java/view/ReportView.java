/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.PacienteController;
import java.awt.Color;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.Paciente;

/**
 *
 * @author matheusnascimento
 */
public class ReportView extends javax.swing.JFrame {

    private String baseUrl;
    private Paciente paciente;
    private PacienteController reportController;
    private boolean exitThread;

    /**
     * Creates new form ReportView
     *
     * @param paciente
     * @param baseUrl
     */
    public ReportView(Paciente paciente, String baseUrl) {
        this.paciente = paciente;
        this.baseUrl = baseUrl;
        this.exitThread = false;
        reportController = new PacienteController();
        initComponents();
        tfFreqCardiaca.setText(paciente.getFreqCardiaca());
        tfPressao.setText(paciente.getPressaoArterial());
        tfTemperatura.setText(paciente.getTemperatura() + "");
        tfSaturacao.setText(paciente.getSaturacao());
        lbNome.setText("Paciente: " + paciente.getNome());
        lbSituacao.setText("Gravidade: " + paciente.getGravidade());
        Thread threadMonitorarPaciente = new Thread(monitorarPaciente, "Monitoramento Gravidade");
        threadMonitorarPaciente.start();

    }

    Runnable monitorarPaciente
            = new Runnable() {
        @Override
        public void run() {
            System.out.println("Runnable running");

            try {
                while (!exitThread) {
                    int gravidade = reportController.getPacienteStatus(baseUrl, paciente.getCpf());
                    lbSituacao.setText("Gravidade: " + String.valueOf(gravidade));
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbNome = new javax.swing.JLabel();
        tfTemperatura = new javax.swing.JTextField();
        tfFreqCardiaca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfPressao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfSaturacao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        lbSituacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbNome.setText("Paciente");

        tfTemperatura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfTemperaturaKeyPressed(evt);
            }
        });

        tfFreqCardiaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfFreqCardiacaKeyPressed(evt);
            }
        });

        jLabel2.setText("Temperatura (??C)");

        jLabel3.setText("Frequ??ncia Card??aca (bpm)");

        tfPressao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPressaoKeyPressed(evt);
            }
        });

        jLabel4.setText("Press??o Arterial (mmHg)");

        tfSaturacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSaturacaoActionPerformed(evt);
            }
        });
        tfSaturacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfSaturacaoKeyPressed(evt);
            }
        });

        jLabel5.setText("Satura????o (% SpO2)");

        btnUpdate.setText("Atualizar");
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lbSituacao.setText("Gravidade: 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                        .addGap(277, 277, 277))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfPressao, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfSaturacao, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lbNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(128, 128, 128))
                            .addComponent(tfTemperatura, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfFreqCardiaca, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(33, 33, 33))
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(22, 22, 22))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(60, 60, 60)))
                                        .addGap(8, 8, 8)))))
                        .addGap(65, 65, 65)
                        .addComponent(lbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSituacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(tfTemperatura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(tfFreqCardiaca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(tfPressao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(tfSaturacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        // TODO add your handling code here:
        btnUpdate.setText("Enviando...");
        Boolean status = reportController.updatePaciente(baseUrl, paciente.toString());
        if (!status) {
            btnUpdate.setBackground(Color.RED);
        } else {
            btnUpdate.setBackground(Color.GREEN);
        }
        btnUpdate.setText("Atualizar");

    }//GEN-LAST:event_btnUpdateMouseClicked

    private void tfTemperaturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTemperaturaKeyPressed
        // TODO add your handling code here:
        float temperatura;
        try {
            char key = evt.getKeyChar();
            int keyCode = evt.getKeyCode(); 		        
            String text = keyCode == 8 ? tfTemperatura.getText().substring(0, tfTemperatura.getText().length() -1) 
                    : tfTemperatura.getText() + key;

            temperatura = Float.parseFloat(text);
        } catch (Exception e) {
            temperatura = 0;
        }
        paciente.setTemperatura(temperatura);
        Boolean status = reportController.updatePaciente(baseUrl, paciente.toString());
        if (!status) {
            btnUpdate.setBackground(Color.RED);
        } else {
            btnUpdate.setBackground(Color.GREEN);
        }
    }//GEN-LAST:event_tfTemperaturaKeyPressed

    private void tfFreqCardiacaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFreqCardiacaKeyPressed
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        int keyCode = evt.getKeyCode(); 		        
        String text = keyCode == 8 ? tfFreqCardiaca.getText().substring(0, tfFreqCardiaca.getText().length() -1) 
                : tfFreqCardiaca.getText() + key;
        
        paciente.setFreqCardiaca(text);
        Boolean status = reportController.updatePaciente(baseUrl, paciente.toString());
        if (!status) {
            btnUpdate.setBackground(Color.RED);
        } else {
            btnUpdate.setBackground(Color.GREEN);
        }
    }//GEN-LAST:event_tfFreqCardiacaKeyPressed

    private void tfPressaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPressaoKeyPressed
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        int keyCode = evt.getKeyCode(); 		        
        String text = keyCode == 8 ? tfPressao.getText().substring(0, tfPressao.getText().length() -1) 
                : tfPressao.getText() + key;
        paciente.setPressaoArterial(text);
        Boolean status = reportController.updatePaciente(baseUrl, paciente.toString());
        if (!status) {
            btnUpdate.setBackground(Color.RED);
        } else {
            btnUpdate.setBackground(Color.GREEN);
        }
    }//GEN-LAST:event_tfPressaoKeyPressed


    private void tfSaturacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSaturacaoKeyPressed
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        int keyCode = evt.getKeyCode(); 		        
        String text = keyCode == 8 ? tfSaturacao.getText().substring(0, tfSaturacao.getText().length() -1) 
                : tfSaturacao.getText() + key;
        paciente.setSaturacao(text);
        Boolean status = reportController.updatePaciente(baseUrl, paciente.toString());
        if (!status) {
            btnUpdate.setBackground(Color.RED);
        } else {
            btnUpdate.setBackground(Color.GREEN);
        }

    }//GEN-LAST:event_tfSaturacaoKeyPressed

    private void tfSaturacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSaturacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSaturacaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbSituacao;
    private javax.swing.JTextField tfFreqCardiaca;
    private javax.swing.JTextField tfPressao;
    private javax.swing.JTextField tfSaturacao;
    private javax.swing.JTextField tfTemperatura;
    // End of variables declaration//GEN-END:variables
}
