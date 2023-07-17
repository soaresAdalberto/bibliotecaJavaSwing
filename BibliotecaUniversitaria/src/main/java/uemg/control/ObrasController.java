package uemg.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import uemg.model.ObrasCRUD;
import uemg.model.ObrasModel;
import uemg.view.Obras;

public class ObrasController implements ActionListener{

    //Instanciando as classes que irei utilizar:
    ObrasCRUD oc = new ObrasCRUD();
    ObrasModel om = new ObrasModel();
    Obras o = new Obras();
    DefaultTableModel model = new DefaultTableModel();

    //Construtor:
    public ObrasController(Obras o) {
        this.o = o;
        this.o.btnSelect.addActionListener(this);
        this.o.btnGravar.addActionListener(this);
        this.o.btnEditar.addActionListener(this);
        this.o.btnOk.addActionListener(this);
        this.o.btnExcluir.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {  
        
        //Botão de pesquisar:
        if (e.getSource() == o.btnSelect) {
            limparTabela();
            Pesquisar(o.dgObras);
            clean();
        }
        
        //Botão de gravar (adicionar):
        if (e.getSource() == o.btnGravar) {
            Adicionar();
            limparTabela();
            Pesquisar(o.dgObras);
            clean();
        }
        
        //Botão de editar (habilitar os campos):
        if (e.getSource() == o.btnEditar) {
            
            int linha = o.dgObras.getSelectedRow();
            if (linha == -1) {
                JOptionPane.showMessageDialog(o, "Deve selecionar um registro.");
            } else {
                String tipo_per = (String)o.dgObras.getValueAt(linha, 0).toString();
                String cat_per = (String)o.dgObras.getValueAt(linha, 1).toString();
                String nome = (String)o.dgObras.getValueAt(linha, 2).toString();
                String autor = (String)o.dgObras.getValueAt(linha, 3).toString();
                int edicao = Integer.parseInt((String)o.dgObras.getValueAt(linha, 4).toString());
                String cidade = (String)o.dgObras.getValueAt(linha, 5).toString();
                String editora = (String)o.dgObras.getValueAt(linha, 6).toString();
                int paginas = Integer.parseInt((String)o.dgObras.getValueAt(linha, 7).toString());
                float cm = Float.parseFloat((String)o.dgObras.getValueAt(linha, 8).toString());
                String isbn = (String)o.dgObras.getValueAt(linha, 9).toString();
                String cdu = (String)o.dgObras.getValueAt(linha, 10).toString();
                int exemplares = Integer.parseInt((String)o.dgObras.getValueAt(linha, 11).toString());
                int ano = Integer.parseInt((String)o.dgObras.getValueAt(linha, 12).toString());
                String palavras_chave = (String)o.dgObras.getValueAt(linha, 13).toString();
                
                o.txfTipoPeriodico.setText(tipo_per);
                o.txfCategoriaPedido.setText(cat_per);
                o.txfNomeObra.setText(nome);
                o.txfAutor.setText(autor);
                o.txfEdicao.setText(""+edicao);
                o.txfCidade.setText(cidade);
                o.txfEditora.setText(editora);
                o.txfPaginas.setText(""+paginas);
                o.txfCm.setText(""+cm);
                o.ftfIsbn.setText(isbn);
                o.ftfCdu.setText(cdu);
                o.txfExemplares.setText(""+exemplares);
                o.txfAno.setText(""+ano);
                o.txfPalavraChave.setText(palavras_chave);
            }
        }
        
        //Botão para gravar as atualizações:
        if (e.getSource() == o.btnOk) {
            Atualizar();
            limparTabela();
            Pesquisar(o.dgObras);
            clean();
        }
        
        //Botão para excluir os registros:
        if (e.getSource() == o.btnExcluir) {
            int linha = o.dgObras.getSelectedRow();
            
            if (linha == -1) {
                JOptionPane.showMessageDialog(o, "Você deve selecionar algum registro!");
            } else {
                String nome = (String) o.dgObras.getValueAt(linha, 2).toString();
                oc.Deletar(nome);
                JOptionPane.showMessageDialog(o, "Usuário excluído com sucesso.");
            }
            limparTabela();
            Pesquisar(o.dgObras);
        }
    }
   
    //Método para pesquisar no banco:
    public void Pesquisar(JTable dgObras) {
        model = (DefaultTableModel)dgObras.getModel();
        dgObras.setModel(model);
        List<ObrasModel>lista = oc.Pesquisar();
        Object[] obj = new Object[14];
        
        for (int i = 0; i < lista.size(); i++) {
            obj[0] = lista.get(i).getTipo_Periodico();
            obj[1] = lista.get(i).getCategoria_Periodico();
            obj[2] = lista.get(i).getNome_Obra();
            obj[3] = lista.get(i).getAutor();
            obj[4] = lista.get(i).getEdicao();
            obj[5] = lista.get(i).getCidade();
            obj[6] = lista.get(i).getEditora();
            obj[7] = lista.get(i).getPaginas();
            obj[8] = lista.get(i).getCm();
            obj[9] = lista.get(i).getIsbn();
            obj[10] = lista.get(i).getCdu();
            obj[11] = lista.get(i).getExemplares();
            obj[12] = lista.get(i).getAno();
            obj[13] = lista.get(i).getPalavras_Chave();
            
            model.addRow(obj);
        }
        
        o.dgObras.setModel(model);
    }
    
    //Método para adicionar no banco:
    public void Adicionar() {
        String Tipo_Periodico = o.txfTipoPeriodico.getText();
        String Categoria_Periodico = o.txfCategoriaPedido.getText();
        String Nome_Obra = o.txfNomeObra.getText();
        String Autor = o.txfAutor.getText();
        int Edicao = Integer.parseInt(o.txfEdicao.getText());
        String Cidade = o.txfCidade.getText();
        String Editora = o.txfEditora.getText();
        int Paginas = Integer.parseInt(o.txfPaginas.getText());
        float Cm = Float.parseFloat(o.txfCm.getText());
        String Isbn = o.ftfIsbn.getText();
        String Cdu = o.ftfCdu.getText();
        int Exemplares = Integer.parseInt(o.txfExemplares.getText());
        int Ano = Integer.parseInt(o.txfAno.getText());
        String Palavras_Chave = o.txfPalavraChave.getText();
        
        om.setTipo_Periodico(Tipo_Periodico);
        om.setCategoria_Periodico(Categoria_Periodico);
        om.setNome_Obra(Nome_Obra);
        om.setAutor(Autor);
        om.setEdicao(Edicao);
        om.setCidade(Cidade);
        om.setEditora(Editora);
        om.setPaginas(Paginas);
        om.setCm(Cm);
        om.setIsbn(Isbn);
        om.setCdu(Cdu);
        om.setExemplares(Exemplares);
        om.setAno(Ano);
        om.setPalavras_Chave(Palavras_Chave);
        
        int r = oc.Adicionar(om);
        
        if (r == 1) {
            JOptionPane.showMessageDialog(o, "Registro incluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(o, "Erro ao incluir registro.");
        }
    }
    
    //Método para editar um registro no banco:
    public void Atualizar() {
        String Tipo_Periodico = o.txfTipoPeriodico.getText();
        String Categoria_Periodico = o.txfCategoriaPedido.getText();
        String Nome_Obra = o.txfNomeObra.getText();
        String Autor = o.txfAutor.getText();
        int Edicao = Integer.parseInt(o.txfEdicao.getText());
        String Cidade = o.txfCidade.getText();
        String Editora = o.txfEditora.getText();
        int Paginas = Integer.parseInt(o.txfPaginas.getText());
        float Cm = Float.parseFloat(o.txfCm.getText());
        String Isbn = o.ftfIsbn.getText();
        String Cdu = o.ftfCdu.getText();
        int Exemplares = Integer.parseInt(o.txfExemplares.getText());
        int Ano = Integer.parseInt(o.txfAno.getText());
        String Palavras_Chave = o.txfPalavraChave.getText();
        
        om.setTipo_Periodico(Tipo_Periodico);
        om.setCategoria_Periodico(Categoria_Periodico);
        om.setNome_Obra(Nome_Obra);
        om.setAutor(Autor);
        om.setEdicao(Edicao);
        om.setCidade(Cidade);
        om.setEditora(Editora);
        om.setPaginas(Paginas);
        om.setCm(Cm);
        om.setIsbn(Isbn);
        om.setCdu(Cdu);
        om.setExemplares(Exemplares);
        om.setAno(Ano);
        om.setPalavras_Chave(Palavras_Chave);
        
        int r = oc.Atualizar(om);
        
        if (r != 0) {
            JOptionPane.showMessageDialog(o, "Obra atualizada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(o, "Erro ao atualizar obra.");
        }
    }
    
    //Método para limpar os textFields após realizar alguma ação:
    void clean() {
        o.txfTipoPeriodico.setText("");
        o.txfCategoriaPedido.setText("");
        o.txfNomeObra.setText("");
        o.txfAutor.setText("");
        o.txfEdicao.setText("");
        o.txfCidade.setText("");
        o.txfEditora.setText("");
        o.txfPaginas.setText("");
        o.txfCm.setText("");
        o.ftfIsbn.setText("");
        o.ftfCdu.setText("");
        o.txfExemplares.setText("");
        o.txfAno.setText("");
        o.txfPalavraChave.setText("");
    }
    
    //Método para limpar a tabela:
     void limparTabela() {
        for (int i = 0; i < o.dgObras.getRowCount(); i++) {
            model.removeRow(i);
            i = i - 1;
        }
    }
}
