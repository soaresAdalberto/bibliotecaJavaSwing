package uemg.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import uemg.model.EmprestimosCRUD;
import uemg.model.EmprestimosModel;
import uemg.view.Emprestimos;

public class EmprestimosController implements ActionListener {
 
    //Instânciando os objetos das classes/view que irei precisar no controller:
    EmprestimosCRUD ec = new EmprestimosCRUD();
    EmprestimosModel em = new EmprestimosModel();
    Emprestimos ee = new Emprestimos();
    DefaultTableModel model = new DefaultTableModel();

    //Construtor do controller, passando como referência os comandos da view:
    public EmprestimosController(Emprestimos e) {
        this.ee = e;
        this.ee.btnSelect.addActionListener(this);
        this.ee.btnGravar.addActionListener(this);
        this.ee.btnEditar.addActionListener(this);
        this.ee.btnOk.addActionListener(this);
        this.ee.btnExcluir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Visualizando os dados:
        if (e.getSource() == ee.btnSelect) {
            limparTabela();
            Pesquisar(ee.dgEmprestimos);
            clean();
        }
        
        //Adicionando os dados:
        if (e.getSource() == ee.btnGravar) {
            Adicionar();
            limparTabela();
            Pesquisar(ee.dgEmprestimos);
            clean();
        }
        
        //Habilitando a edição dos dados:
        if (e.getSource() == ee.btnEditar) {
            int linha = ee.dgEmprestimos.getSelectedRow();
            
            if (linha == -1) {
                JOptionPane.showMessageDialog(ee, "Você deve selecionar algum registro!");
            } else {
                String cpf_leitor = (String) ee.dgEmprestimos.getValueAt(linha, 0);
                String nome_obra = (String) ee.dgEmprestimos.getValueAt(linha, 1);
                String dt_emprestimo = (String) ee.dgEmprestimos.getValueAt(linha, 2);
                String dt_devolucao = (String) ee.dgEmprestimos.getValueAt(linha, 3);
                                
                ee.ftfCpf.setText(cpf_leitor);
                ee.txfNomeObra.setText(nome_obra);
                ee.ftfEmprestimo.setText(dt_emprestimo);
                ee.ftfDevolucao.setText(dt_devolucao);
            }
        }
        
        //Salvando os dados que foram editados:
        if (e.getSource() == ee.btnOk) {
            Atualizar();
            limparTabela();
            Pesquisar(ee.dgEmprestimos);
            clean();
        }
        
        //Excluindo os dados do banco:
        if (e.getSource() == ee.btnExcluir) {
            
            int linha = ee.dgEmprestimos.getSelectedRow();
            
            if (linha == -1) {
                JOptionPane.showMessageDialog(ee, "Você deve selecionar algum registro!");
            } else {
                String cpf = (String) ee.dgEmprestimos.getValueAt(linha, 0).toString();
                ec.Deletar(cpf);
                JOptionPane.showMessageDialog(ee, "Usuário excluído com sucesso.");
            }
            limparTabela();
            Pesquisar(ee.dgEmprestimos);
        }
    }
    
    //Método que preenche a tabela com os dados que existem no banco:    
    public void Pesquisar(JTable dgEmprestimos) {
        //centrarCeldas(tabla);
        model = (DefaultTableModel) dgEmprestimos.getModel();
        dgEmprestimos.setModel(model);
        List<EmprestimosModel>lista = ec.listar();
        Object[] object = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getCpf_leitor();
            object[1] = lista.get(i).getNome_obra();
            object[2] = lista.get(i).getDt_emprestimo();
            object[3] = lista.get(i).getDt_devolucao();
            model.addRow(object);
        }
        ee.dgEmprestimos.setModel(model);
    }
    
    //Método que recebe os parâmetros para adicionar na tabela do banco:
    public void Adicionar() {
        
        //Extraindo os dados dos textFields:
        String cpf_leitor = ee.ftfCpf.getText();
        String nome_obra = ee.txfNomeObra.getText();
        String dt_emprestimo = ee.ftfEmprestimo.getText();
        String dt_devolucao = ee.ftfDevolucao.getText();
                       
        //Setando os dados dentro da minha classe:
        em.setCpf_leitor(cpf_leitor);
        em.setNome_obra(nome_obra);
        em.setDt_emprestimo(dt_emprestimo);
        em.setDt_devolucao(dt_devolucao);
                
        //Executando o método de adicionar e armazenando o resultado na var:
        int r = ec.Adicionar(em);
        
        //Usando o resultado da var para mostrar se o registro foi add ou não:
        if (r==1) {
            JOptionPane.showMessageDialog(ee, "Registro incluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(ee, "Erro ao incluir registro!");
        }
    }
    
    //Método para atualizar os dados editados:
    public void Atualizar() {
        if (ee.ftfCpf.getText().equals("")) {
            JOptionPane.showMessageDialog(ee, "Escolha um registro antes de apertar a opção editar.");
        } else {
            //Extraindo os dados dos textFields:
            String cpf_leitor = ee.ftfCpf.getText();
            String nome_obra = ee.txfNomeObra.getText();
            String dt_emprestimo = ee.ftfEmprestimo.getText();
            String dt_devolucao = ee.ftfDevolucao.getText();
           
            //Setando os dados dentro da minha classe:
            em.setCpf_leitor(cpf_leitor);
            em.setNome_obra(nome_obra);
            em.setDt_emprestimo(dt_emprestimo);
            em.setDt_devolucao(dt_devolucao);

            //Executando o método de adicionar e armazenando o resultado na var:
            int linha = ee.dgEmprestimos.getSelectedRow();
            String cpf = (String) ee.dgEmprestimos.getValueAt(linha, 0).toString();
            int r = ec.Atualizar(em, cpf);

            //Usando o resultado da var p/ mostrar se o registro foi atualizado ou não:
            if (r!=0) {
                JOptionPane.showMessageDialog(ee, "Registro atualizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(ee, "Erro ao atualizar registro!");
            }
        }
    }
    
    //Método para limpar os textFields após realizar alguma ação:
    void clean() {
        ee.ftfCpf.setText("");
        ee.txfNomeObra.setText("");
        ee.ftfEmprestimo.setText("");
        ee.ftfDevolucao.setText("");
    }
    
    //Método para limpar a tabela:
     void limparTabela() {
        for (int i = 0; i < ee.dgEmprestimos.getRowCount(); i++) {
            model.removeRow(i);
            i = i - 1;
        }
    }   
}
