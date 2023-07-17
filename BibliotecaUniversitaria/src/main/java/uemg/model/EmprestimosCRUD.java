package uemg.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import uemg.singleton.MyConnectionSingleton;

public class EmprestimosCRUD {
    
    //Parâmetros para conexão:
    MyConnectionSingleton connect = new MyConnectionSingleton();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    EmprestimosModel em = new EmprestimosModel();
    
    //Método listar, onde realizo um select no banco:
    public List listar() {
        
        //Lista que recebe os argumentos que serão passados:
        List<EmprestimosModel>dados = new ArrayList<>();
        
        //Comando SQL que será executado no banco:
        String sql = "SELECT * FROM emprestimos";
        
        //Executando o select no banco e retornando os resultados:
        try {
            con = connect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                EmprestimosModel e = new EmprestimosModel();
                e.setCpf_leitor(rs.getString("cpfLeitor"));
                e.setNome_obra(rs.getString("nomeObra"));
                e.setDt_emprestimo(rs.getString("Emprestimo"));
                e.setDt_devolucao(rs.getString("Devolucao"));              
                dados.add(e);
            }
            
        } catch (Exception e) {     
        } return dados;
    }
    
    //Método adicionar, onde realizo um insert no banco:
    public int Adicionar(EmprestimosModel em) {
        
        //Comando SQL para inserir no banco:
        String sql = "INSERT INTO emprestimos (cpfLeitor, nomeObra, Emprestimo, Devolucao) ";
        sql+= "VALUES (?, ?, ?, ?)";
        
        //Enviando no try catch os parâmetros que serão inseridos no banco:
        try {
            con = connect.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, em.getCpf_leitor());
            ps.setString(2, em.getNome_obra());
            ps.setString(3, em.getDt_emprestimo());
            ps.setString(4, em.getDt_devolucao());
            
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
        
        return 1;
    }
    
    //Método atualizar, onde realizo as edições nos cadastros do banco:
    public int Atualizar(EmprestimosModel em, String cpf)
    {
        int r = 0;
        
        //Comando SQL para editar no banco:
        String sql = "UPDATE emprestimos SET cpfLeitor = ?, nomeObra = ?, "; 
               sql += "emprestimos = ?, devolucao = ? ";
               sql += "WHERE cpfLeitor = ? ";
               
        //Enviando no try catch os parâmetros que serão inseridos no banco:
        try {
            con = connect.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, em.getCpf_leitor());
            ps.setString(2, em.getNome_obra());
            ps.setString(3, em.getDt_emprestimo());
            ps.setString(4, em.getDt_devolucao());
            ps.setString(5, cpf);
                        
            r = ps.executeUpdate();
            
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
            
        } catch (Exception e) {
        }
        
        return r;
    }
    
    //Método eliminar, para deletar os registros no banco:
    public void Deletar(String cpf) {
        String sql = "DELETE FROM emprestimos where cpfLeitor = ?";
        
        try {
            con = connect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cpf);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
