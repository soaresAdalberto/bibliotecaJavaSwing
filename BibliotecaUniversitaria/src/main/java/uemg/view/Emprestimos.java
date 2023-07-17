package uemg.view;

import uemg.control.EmprestimosController;

public class Emprestimos extends javax.swing.JFrame {

     public Emprestimos() {
        initComponents();
        btnEditar.setFocusable(false);
        btnExcluir.setFocusable(false);
        btnGravar.setFocusable(false);
        btnOk.setFocusable(false);
        btnSelect.setFocusable(false);
        btnVoltar.setFocusable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        pLeitores = new javax.swing.JPanel();
        lSair = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        pDados = new javax.swing.JPanel();
        lCpf = new javax.swing.JLabel();
        lNome = new javax.swing.JLabel();
        lEmprestimo = new javax.swing.JLabel();
        lDevolucao = new javax.swing.JLabel();
        ftfCpf = new javax.swing.JFormattedTextField();
        txfNomeObra = new javax.swing.JTextField();
        ftfDevolucao = new javax.swing.JFormattedTextField();
        ftfEmprestimo = new javax.swing.JFormattedTextField();
        pRegistros = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgEmprestimos = new javax.swing.JTable();
        pOperacoes = new javax.swing.JPanel();
        btnOk = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        btnSelect = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pLeitores.setBackground(new java.awt.Color(102, 0, 0));
        pLeitores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lSair.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        lSair.setForeground(new java.awt.Color(255, 255, 255));
        lSair.setText("X");
        lSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lSairMouseClicked(evt);
            }
        });
        pLeitores.add(lSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, -1, -1));

        btnVoltar.setBackground(new java.awt.Color(102, 0, 0));
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setText("VOLTAR");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        pLeitores.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 560, -1, 32));

        pDados.setBackground(new java.awt.Color(102, 0, 0));
        pDados.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pDados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lCpf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lCpf.setForeground(new java.awt.Color(255, 255, 255));
        lCpf.setText("CPF do leitor:");
        pDados.add(lCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        lNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lNome.setForeground(new java.awt.Color(255, 255, 255));
        lNome.setText("Nome da obra:");
        pDados.add(lNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        lEmprestimo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lEmprestimo.setForeground(new java.awt.Color(255, 255, 255));
        lEmprestimo.setText("Empréstimo:");
        pDados.add(lEmprestimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        lDevolucao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lDevolucao.setForeground(new java.awt.Color(255, 255, 255));
        lDevolucao.setText("Devolução:");
        pDados.add(lDevolucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        ftfCpf.setBackground(new java.awt.Color(102, 0, 0));
        ftfCpf.setForeground(new java.awt.Color(255, 255, 255));
        try {
            ftfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        pDados.add(ftfCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 250, -1));

        txfNomeObra.setBackground(new java.awt.Color(102, 0, 0));
        txfNomeObra.setForeground(new java.awt.Color(255, 255, 255));
        pDados.add(txfNomeObra, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 250, -1));

        ftfDevolucao.setBackground(new java.awt.Color(102, 0, 0));
        ftfDevolucao.setForeground(new java.awt.Color(255, 255, 255));
        try {
            ftfDevolucao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        pDados.add(ftfDevolucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 250, -1));

        ftfEmprestimo.setBackground(new java.awt.Color(102, 0, 0));
        ftfEmprestimo.setForeground(new java.awt.Color(255, 255, 255));
        try {
            ftfEmprestimo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        pDados.add(ftfEmprestimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 250, -1));

        pLeitores.add(pDados, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 56, 410, 184));

        pRegistros.setBackground(new java.awt.Color(102, 0, 0));
        pRegistros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        dgEmprestimos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "Nome da obra", "Empréstimo", "Devolução"
            }
        ));
        jScrollPane1.setViewportView(dgEmprestimos);

        javax.swing.GroupLayout pRegistrosLayout = new javax.swing.GroupLayout(pRegistros);
        pRegistros.setLayout(pRegistrosLayout);
        pRegistrosLayout.setHorizontalGroup(
            pRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pRegistrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                .addContainerGap())
        );
        pRegistrosLayout.setVerticalGroup(
            pRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRegistrosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
        );

        pLeitores.add(pRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 740, 300));

        pOperacoes.setBackground(new java.awt.Color(102, 0, 0));
        pOperacoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pOperacoes.setForeground(new java.awt.Color(255, 255, 255));

        btnOk.setBackground(new java.awt.Color(102, 0, 0));
        btnOk.setForeground(new java.awt.Color(255, 255, 255));
        btnOk.setText("OK");

        btnGravar.setBackground(new java.awt.Color(102, 0, 0));
        btnGravar.setForeground(new java.awt.Color(255, 255, 255));
        btnGravar.setText("GRAVAR");

        btnSelect.setBackground(new java.awt.Color(102, 0, 0));
        btnSelect.setForeground(new java.awt.Color(255, 255, 255));
        btnSelect.setText("PESQUISAR");

        btnEditar.setBackground(new java.awt.Color(102, 0, 0));
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(102, 0, 0));
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pOperacoesLayout = new javax.swing.GroupLayout(pOperacoes);
        pOperacoes.setLayout(pOperacoesLayout);
        pOperacoesLayout.setHorizontalGroup(
            pOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(pOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pOperacoesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(pOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pOperacoesLayout.setVerticalGroup(
            pOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 157, Short.MAX_VALUE)
            .addGroup(pOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pOperacoesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnOk)
                    .addGap(7, 7, 7)
                    .addComponent(btnGravar)
                    .addGap(7, 7, 7)
                    .addComponent(btnSelect)
                    .addGap(7, 7, 7)
                    .addComponent(btnEditar)
                    .addGap(7, 7, 7)
                    .addComponent(btnExcluir)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pLeitores.add(pOperacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 310, 180));

        getContentPane().add(pLeitores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 610));

        setSize(new java.awt.Dimension(756, 607));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lSairMouseClicked
        dispose();
    }//GEN-LAST:event_lSairMouseClicked

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        Menu m = new Menu();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnExcluir;
    public javax.swing.JButton btnGravar;
    public javax.swing.JButton btnOk;
    public javax.swing.JButton btnSelect;
    private javax.swing.JButton btnVoltar;
    public javax.swing.JTable dgEmprestimos;
    public javax.swing.JFormattedTextField ftfCpf;
    public javax.swing.JFormattedTextField ftfDevolucao;
    public javax.swing.JFormattedTextField ftfEmprestimo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lCpf;
    private javax.swing.JLabel lDevolucao;
    private javax.swing.JLabel lEmprestimo;
    private javax.swing.JLabel lNome;
    private javax.swing.JLabel lSair;
    private javax.swing.JPanel pDados;
    private javax.swing.JPanel pLeitores;
    private javax.swing.JPanel pOperacoes;
    private javax.swing.JPanel pRegistros;
    public javax.swing.JTextField txfNomeObra;
    // End of variables declaration//GEN-END:variables
}
