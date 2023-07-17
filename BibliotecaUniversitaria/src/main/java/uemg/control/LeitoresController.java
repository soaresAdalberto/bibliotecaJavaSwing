package uemg.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import uemg.model.LeitoresCRUD;
import uemg.model.LeitoresModel;
import uemg.view.Leitores;


public class LeitoresController implements ActionListener{
    
    //Instânciando os objetos das classes/view que irei precisar no controller:
    LeitoresCRUD lc = new LeitoresCRUD();
    LeitoresModel lm = new LeitoresModel();
    Leitores l = new Leitores();
    DefaultTableModel model = new DefaultTableModel();

    //Construtor do controller passando como referência os comandos da view:
    public LeitoresController(Leitores l) {
        this.l = l;
        this.l.btnSelect.addActionListener(this);
        this.l.btnGravar.addActionListener(this);
        this.l.btnEditar.addActionListener(this);
        this.l.btnOk.addActionListener(this);
        this.l.btnExcluir.addActionListener(this);
    }

    //Sobrescrevendo este método para pegar quando clico em algum dos botões:
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Visualizando os dados:
        if (e.getSource() == l.btnSelect) {
            limparTabela();
            Pesquisar(l.dgLeitores);
            clean();
        }
        
        //Adicionando os dados:
        if (e.getSource() == l.btnGravar) {
            Adicionar();
            limparTabela();
            Pesquisar(l.dgLeitores);
            clean();
        }
        
        //Habilitando a edição dos dados:
        if (e.getSource() == l.btnEditar) {
            int linha = l.dgLeitores.getSelectedRow();
            
            if (linha == -1) {
                JOptionPane.showMessageDialog(l, "Você deve selecionar algum registro!");
            } else {
                String nome = (String) l.dgLeitores.getValueAt(linha, 0);
                String cpf = (String) l.dgLeitores.getValueAt(linha, 1);
                String email = (String) l.dgLeitores.getValueAt(linha, 2);
                String telefone = (String) l.dgLeitores.getValueAt(linha, 3);
                String endereco = (String) l.dgLeitores.getValueAt(linha, 4);
                
                l.txfNome.setText(nome);
                l.ftfCpf.setText(cpf);
                l.txfEmail.setText(email);
                l.ftfTelefone.setText(telefone);
                l.txfEndereco.setText(endereco);
            }
        }
        
        //Salvando os dados que foram editados:
        if (e.getSource() == l.btnOk) {
            Atualizar();
            limparTabela();
            Pesquisar(l.dgLeitores);
            clean();
        }
        
        //Excluindo os dados do banco:
        if (e.getSource() == l.btnExcluir) {
            
            int linha = l.dgLeitores.getSelectedRow();
            
            if (linha == -1) {
                JOptionPane.showMessageDialog(l, "Você deve selecionar algum registro!");
            } else {
                String cpf = (String) l.dgLeitores.getValueAt(linha, 1).toString();
                lc.Deletar(cpf);
                JOptionPane.showMessageDialog(l, "Usuário excluído com sucesso.");
            }
            limparTabela();
            Pesquisar(l.dgLeitores);
        }
    }
    
    //Método que preenche a tabela com os dados que existem no banco:    
    public void Pesquisar(JTable dgLeitores) {
        //centrarCeldas(tabla);
        model = (DefaultTableModel) dgLeitores.getModel();
        dgLeitores.setModel(model);
        List<LeitoresModel>lista = lc.listar();
        Object[] object = new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getNome();
            object[1] = lista.get(i).getCpf();
            object[2] = lista.get(i).getEmail();
            object[3] = lista.get(i).getTelefone();
            object[4] = lista.get(i).getEndereco();
            model.addRow(object);
        }
        l.dgLeitores.setModel(model);
    }
    
    //Método que recebe os parâmetros para adicionar na tabela do banco:
    public void Adicionar() {
        
        //Extraindo os dados dos textFields:
        String nome = l.txfNome.getText();
        String cpf = l.ftfCpf.getText();
        String email = l.txfEmail.getText();
        String telefone = l.ftfTelefone.getText();
        String endereco = l.txfEndereco.getText();
        
        //Tratando a gravação de usuários com campos vazios:
        if (nome.isEmpty() || cpf.isEmpty() || email.isEmpty() || telefone.isEmpty() || endereco.isEmpty()) {
            JOptionPane.showMessageDialog(l, "Preencha todos os campos antes de adicionar um usuário.");
            return;
        }
        
        //Setando os dados dentro da minha classe:
        lm.setNome(nome);
        lm.setCpf(cpf);
        lm.setEmail(email);
        lm.setTelefone(telefone);
        lm.setEndereco(endereco);
        
        //Executando o método de adicionar e armazenando o resultado na var:
        int r = lc.Adicionar(lm);
        
        //Usando o resultado da var para mostrar se o usuário foi add ou não:
        if (r==1) {
            JOptionPane.showMessageDialog(l, "Usuário adicionado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(l, "Erro ao adicionar usuário!");
        }
    }
    
    //Método para atualizar os dados editados:
    public void Atualizar() {
        if (l.ftfCpf.getText().equals("")) {
            JOptionPane.showMessageDialog(l, "Escolha um registro antes de apertar a opção editar.");
        } else {
            //Extraindo os dados dos textFields:
            String nome = l.txfNome.getText();
            String cpf = l.ftfCpf.getText();
            String email = l.txfEmail.getText();
            String telefone = l.ftfTelefone.getText();
            String endereco = l.txfEndereco.getText();

            //Setando os dados dentro da minha classe:
            lm.setNome(nome);
            lm.setCpf(cpf);
            lm.setEmail(email);
            lm.setTelefone(telefone);
            lm.setEndereco(endereco);

            //Executando o método de adicionar e armazenando o resultado na var:
            int r = lc.Atualizar(lm);

            //Usando o resultado da var p/ mostrar se o usuário foi atualizado ou não:
            if (r==1) {
                JOptionPane.showMessageDialog(l, "Usuário atualizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(l, "Erro ao atualizar usuário!");
            }
        }
    }
    
    //Método para limpar os textFields após realizar alguma ação:
    void clean() {
        l.txfNome.setText("");
        l.ftfCpf.setText("");
        l.txfEmail.setText("");
        l.ftfTelefone.setText("");
        l.txfEndereco.setText("");
    }
    
    //Método para limpar a tabela:
     void limparTabela() {
        for (int i = 0; i < l.dgLeitores.getRowCount(); i++) {
            model.removeRow(i);
            i = i - 1;
        }
    }
}
