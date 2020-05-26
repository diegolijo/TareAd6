package jit.Frames;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import jit.mongodb.*;
import static jit.mongodb.BaseDatos.*;

public class Principal extends javax.swing.JFrame {

    private final String usuario;
    private final String nome;
    private ArrayList listaMensaxes;
    private int paginaMenajes;
    private ArrayList listaUsuarios;

    public Principal(String usuario) {

        initComponents();

        this.usuario = usuario;
        BaseDatos bd = new BaseDatos();
        DBCollection colecion = bd.getBaseDatos().getCollection("usuario");
        DBObject query = new BasicDBObject("username", usuario);
        DBObject cursor = colecion.findOne(query);
        nome = cursor.get("nome").toString();

        //   jList.setVisibleRowCount(5);
        this.setLocationRelativeTo(null);

        jButtonSeguir.setEnabled(false);
    }

    private Principal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButtonLeerMensaxe = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList = new javax.swing.JList<>();
        jButton4 = new javax.swing.JButton();
        jTextFieldUsuario = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButtonSeguir = new javax.swing.JButton();
        jTextFieldHastag = new javax.swing.JTextField();
        jButton6BuscarHastags = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Escribir mensaxe");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonLeerMensaxe.setText("Mensaxes");
        jButtonLeerMensaxe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLeerMensaxeActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText(">");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("<");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jList.setToolTipText("");
        jList.setVisibleRowCount(5);
        jList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList);

        jButton4.setText("Usuarios");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Buscar Usuario");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButtonSeguir.setText("Seguir");
        jButtonSeguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeguirActionPerformed(evt);
            }
        });

        jButton6BuscarHastags.setText("Buscar Hashtag");
        jButton6BuscarHastags.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6BuscarHastagsActionPerformed(evt);
            }
        });

        jButton6.setText("Mensaxes Follows");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonLeerMensaxe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonSeguir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldHastag, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton6BuscarHastags))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(78, 78, 78)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton6)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))
                        .addGap(0, 46, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSeguir)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldHastag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton6BuscarHastags))
                            .addComponent(jButtonLeerMensaxe)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton1))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        EscribirMensaje form = new EscribirMensaje(usuario, nome);
        form.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonLeerMensaxeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLeerMensaxeActionPerformed

        paginaMenajes = 0;
        listaMensaxes = selectDocumentos("mensaxe");

        if (listaMensaxes.size() < 5) {
            jList.setModel(getModeloDoc(0, listaMensaxes.size() - 1));
        } else {
            jList.setModel(getModeloDoc(0, 4));
        }


    }//GEN-LAST:event_jButtonLeerMensaxeActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (!(listaMensaxes == null)) {

            if (paginaMenajes > 0) {
                paginaMenajes -= 1;
            }

            if (listaMensaxes.size() > (paginaMenajes * 5) + 5) {
                jList.setModel(getModeloDoc((paginaMenajes * 5), (paginaMenajes * 5) + 4));
            } else {
                jList.setModel(getModeloDoc((paginaMenajes * 5), listaMensaxes.size() - 1));
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!(listaMensaxes == null)) {
            if ((paginaMenajes * 5) + 5 < listaMensaxes.size()) {
                paginaMenajes += 1;
            }

            if (listaMensaxes.size() > (paginaMenajes * 5) + 5) {
                jList.setModel(getModeloDoc((paginaMenajes * 5), (paginaMenajes * 5) + 4));
            } else {
                jList.setModel(getModeloDoc((paginaMenajes * 5), listaMensaxes.size() - 1));
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        listaMensaxes = null;
        listaUsuarios = selectDocumentos("usuario");
        jList.setModel(getModeloUsuario());


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        listaMensaxes = null;
        String user = jTextFieldUsuario.getText();

        if (!user.equals("")) {
            listaUsuarios = selectDocumentos("usuario", jTextFieldUsuario.getText());
            jList.setModel(getModeloUsuario());
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListMouseClicked

        //que la lista de mensajes este vacia es que la ultima busqueda fue de usuarios
        if (listaMensaxes == null) {
            //comprobamos si estamos siguiendo 
            int index = jList.getSelectedIndex();
            DBObject object = (DBObject) listaUsuarios.get(index);
            String user = object.get("username").toString();

            if (siguiendo(usuario, user) || usuario.equals(user)) {
                jButtonSeguir.setEnabled(false);
            } else {
                jButtonSeguir.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jListMouseClicked

    private void jButtonSeguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeguirActionPerformed

        int index = jList.getSelectedIndex();
        DBObject object = (DBObject) listaUsuarios.get(index);
        String user = object.get("username").toString();

        updateSiguiendo(usuario, user);

        jButtonSeguir.setEnabled(false);

    }//GEN-LAST:event_jButtonSeguirActionPerformed

    private void jButton6BuscarHastagsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6BuscarHastagsActionPerformed
        String hastag = jTextFieldHastag.getText();
        listaMensaxes = null;
        if (!hastag.equals("")) {
            listaMensaxes = selectDocumentosHastag("mensaxe", jTextFieldHastag.getText());
            jList.setModel(getModeloDoc(0, listaMensaxes.size() - 1));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6BuscarHastagsActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       
        paginaMenajes = 0;
        ArrayList<String> array = selectFollows(usuario);
        listaMensaxes = new ArrayList();

        if (!(array == null)) {

            for (int i = 0; i < array.size(); i++) {

                String usuarios = array.get(i);

                ArrayList array2 = selectMensajes(usuarios);
                for (int j = 0; j < array2.size(); j++) {

                    listaMensaxes.add(array2.get(j));
                }
            }

            if (listaMensaxes.size() < 5) {
                jList.setModel(getModeloDoc(0, listaMensaxes.size() - 1));
            } else {
                jList.setModel(getModeloDoc(0, 4));
            }

        } else {
            DefaultListModel model = new DefaultListModel<>();
            model.addElement("Non hai mensaxes que amosar");
            jList.setModel(model);
        }


    }//GEN-LAST:event_jButton6ActionPerformed

    private DefaultListModel getModeloDoc(int inicio, int fin) {

        DefaultListModel model = new DefaultListModel<>();
        //     listaMensaxes = selectDocumentos("mensaxe");
        for (int i = inicio; i <= fin; i++) {
            model.addElement(mensaxeToString((DBObject) listaMensaxes.get(i)));
        }
        return model;
    }

    private DefaultListModel getModeloUsuario() {

        DefaultListModel model = new DefaultListModel<>();

        for (int i = 0; i < listaUsuarios.size(); i++) {
            model.addElement(usuarioToString((DBObject) listaUsuarios.get(i)));
        }
        return model;
    }

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton6BuscarHastags;
    private javax.swing.JButton jButtonLeerMensaxe;
    private javax.swing.JButton jButtonSeguir;
    private javax.swing.JList<String> jList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldHastag;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables

}
