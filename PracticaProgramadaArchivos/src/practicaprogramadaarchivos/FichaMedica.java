/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package practicaprogramadaarchivos;

import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author fernandafajardo
 */
public class FichaMedica extends javax.swing.JFrame {
    
    private String cedula, nombre, sintoma, diagnostico, tratamiento;    
    
    /**
     * Creates new form FichaMedica
     */
    public FichaMedica() {
        initComponents();
    }
    
    private void agregarPaciente(){
        
            //Capturo los datos de los campos
            nombre = txtNombre.getText();
            cedula = txtCedula.getText();
            sintoma = txtSintoma.getText();
            diagnostico = txtDiagnostico.getText();
            tratamiento = txtTratamiento.getText();

        try{
            try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("pacientes.dat", true))){

                dos.writeUTF(nombre);
                dos.writeUTF(cedula);
                dos.writeUTF(sintoma);
                dos.writeUTF(diagnostico);
                dos.writeUTF(tratamiento);
            }
            JOptionPane.showMessageDialog(null, "Paciente agregado correctamente", "Datos Guardados", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al guardar al paciente", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void guardarDatos(String datos){
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("pacientes.dat", true))) {
              String[] lineas = datos.split("\n");

              for (int i = 0; i + 4 < lineas.length; i += 5) { // Un registro tiene 5 líneas
                  dos.writeUTF(lineas[i]);   // Cédula
                  dos.writeUTF(lineas[i+1]); // Nombre
                  dos.writeUTF(lineas[i+2]); // Síntomas
                  dos.writeUTF(lineas[i+3]); // Diagnóstico
                  dos.writeUTF(lineas[i+4]); // Tratamiento
              }

          } catch (IOException e) {
              JOptionPane.showMessageDialog(null, "Error al guardar datos del paciente", "Error", JOptionPane.ERROR_MESSAGE);
          }
    }
    

    private void consultarNombre() {
        String nombreBuscar = txtNombre.getText().trim();

        try (DataInputStream dis = new DataInputStream(new FileInputStream("pacientes.dat"))) {
            boolean encontrado = false;
            txtRnombre.setText("");
            txtRcedula.setText("");
            txtRsintoma.setText("");
            txtRdiagnostico.setText("");
            txtRtratamiento.setText("");

            while (true) {
                try {
                    String nombre = dis.readUTF();
                    String cedula = dis.readUTF();
                    String sintomas = dis.readUTF();
                    String diagnostico = dis.readUTF();
                    String tratamiento = dis.readUTF();
                    
                    System.out.println("Leyendo -> Cédula: " + cedula + ", Nombre: " + nombre);// Verificar que me está leyendo los datos


                    if (nombre.equalsIgnoreCase(nombreBuscar)) {  
                        
                        txtRnombre.setText("Nombre: " + txtRnombre.getText() + nombre);
                        txtRcedula.setText("Cédula: " + txtRcedula.getText() + cedula);
                        txtRsintoma.setText("Sintómas: " + txtRsintoma.getText() + sintomas);
                        txtRdiagnostico.setText("Diagnóstico: " + txtRdiagnostico.getText() + diagnostico);
                        txtRtratamiento.setText("Tratamiento: " + txtRtratamiento.getText() + tratamiento);
    
                        encontrado = true;
                        // break; // Descomentar si solo quieres el primer resultado encontrado.
                    }
                } catch (EOFException e) {
                    break; // Fin del archivo, salimos del bucle
                }
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "Error, Paciente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void consultarSintoma(){
    
        String sintomaBuscar = txtSintoma.getText().trim();

           try (DataInputStream dis = new DataInputStream(new FileInputStream("pacientes.dat"))) {
               boolean encontrado = false;
               txtRnombre.setText("");  // Limpiar antes de mostrar resultados
               txtRdiagnostico.setText("");
               txtRtratamiento.setText("");

               while (true) {
                   try {
                       // Leer los datos en el orden correcto
                       String nombre = dis.readUTF();
                       String cedula = dis.readUTF();
                       String sintoma = dis.readUTF();
                       String diagnostico = dis.readUTF();
                       String tratamiento = dis.readUTF();

                       // Verificación en consola para depurar
                       System.out.println("Leyendo -> Nombre: " + nombre + ", Sintoma: " + sintoma);

                       // Si el síntoma coincide, mostrar los datos
                       if (sintoma.equalsIgnoreCase(sintomaBuscar)) {
                           txtRnombre.setText("Nombre: " + nombre); // Mostrar solo el nombre
                           txtRdiagnostico.setText("Diagnóstico: " + diagnostico);
                           txtRtratamiento.setText("Tratamiento: " + tratamiento);

                           encontrado = true;
                           break; // Romper el bucle si encuentras el primer resultado
                       }
                   } catch (EOFException e) {
                       break; // Fin del archivo, salimos del bucle
                   }
               }

               if (!encontrado) {
                   JOptionPane.showMessageDialog(null, "Error, Síntoma no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
               }

           } catch (IOException e) {
               JOptionPane.showMessageDialog(null, "Error al leer el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
           }
    }


    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSintoma = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDiagnostico = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTratamiento = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnConsultaN = new javax.swing.JButton();
        btnConsultaS = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtRnombre = new javax.swing.JLabel();
        txtRcedula = new javax.swing.JLabel();
        txtRsintoma = new javax.swing.JLabel();
        txtRdiagnostico = new javax.swing.JLabel();
        txtRtratamiento = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Kodchasan", 0, 13)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Kodchasan", 0, 13)); // NOI18N
        jLabel2.setText("Cédula");

        jLabel3.setFont(new java.awt.Font("Kodchasan", 0, 13)); // NOI18N
        jLabel3.setText("Sintoma");

        jLabel4.setFont(new java.awt.Font("Kodchasan", 0, 13)); // NOI18N
        jLabel4.setText("Diagnostico");

        jLabel5.setFont(new java.awt.Font("Kodchasan", 0, 13)); // NOI18N
        jLabel5.setText("Tratamiento");

        btnAgregar.setFont(new java.awt.Font("Kodchasan", 0, 13)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnConsultaN.setFont(new java.awt.Font("Kodchasan", 0, 13)); // NOI18N
        btnConsultaN.setText("Consultar por Nombre");
        btnConsultaN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaNActionPerformed(evt);
            }
        });

        btnConsultaS.setFont(new java.awt.Font("Kodchasan", 0, 13)); // NOI18N
        btnConsultaS.setText("Consultar por Sintomas");
        btnConsultaS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaSActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Kodchasan", 0, 13)); // NOI18N
        jLabel6.setText("Paciente:");

        txtRnombre.setFont(new java.awt.Font("Kodchasan", 0, 13)); // NOI18N

        txtRcedula.setFont(new java.awt.Font("Kodchasan", 0, 13)); // NOI18N

        txtRsintoma.setFont(new java.awt.Font("Kodchasan", 0, 13)); // NOI18N

        txtRdiagnostico.setFont(new java.awt.Font("Kodchasan", 0, 13)); // NOI18N

        txtRtratamiento.setFont(new java.awt.Font("Kodchasan", 0, 13)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtRnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRcedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRsintoma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRdiagnostico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRtratamiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(32, 32, 32)
                .addComponent(txtRnombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtRcedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtRsintoma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtRdiagnostico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtRtratamiento)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        btnLimpiar.setFont(new java.awt.Font("Kodchasan", 0, 13)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(txtNombre))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtTratamiento, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSintoma, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                    .addComponent(txtDiagnostico))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnConsultaS)
                            .addComponent(btnConsultaN)
                            .addComponent(btnAgregar)
                            .addComponent(btnLimpiar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtSintoma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnConsultaN)
                        .addGap(18, 18, 18)
                        .addComponent(btnConsultaS)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        agregarPaciente();
        txtNombre.setText(" ");
        txtCedula.setText(" ");
        txtSintoma.setText(" ");
        txtDiagnostico.setText(" ");
        txtTratamiento.setText(" ");
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnConsultaNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaNActionPerformed
        // TODO add your handling code here:
        consultarNombre();
        txtNombre.setText(" ");
    }//GEN-LAST:event_btnConsultaNActionPerformed

    private void btnConsultaSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaSActionPerformed
        // TODO add your handling code here:
        consultarSintoma();
        txtSintoma.setText(" ");
    }//GEN-LAST:event_btnConsultaSActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        txtNombre.setText(" ");
        txtCedula.setText(" ");
        txtSintoma.setText(" ");
        txtDiagnostico.setText(" ");
        txtTratamiento.setText(" ");
        txtRnombre.setText(" ");
        txtRcedula.setText(" ");
        txtRsintoma.setText(" ");
        txtRdiagnostico.setText(" ");
        txtRtratamiento.setText(" ");
    }//GEN-LAST:event_btnLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(FichaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FichaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FichaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FichaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FichaMedica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnConsultaN;
    private javax.swing.JButton btnConsultaS;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDiagnostico;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JLabel txtRcedula;
    private javax.swing.JLabel txtRdiagnostico;
    private javax.swing.JLabel txtRnombre;
    private javax.swing.JLabel txtRsintoma;
    private javax.swing.JLabel txtRtratamiento;
    private javax.swing.JTextField txtSintoma;
    private javax.swing.JTextField txtTratamiento;
    // End of variables declaration//GEN-END:variables
}
