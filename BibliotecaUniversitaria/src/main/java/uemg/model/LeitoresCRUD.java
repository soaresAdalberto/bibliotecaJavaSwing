package uemg.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import uemg.singleton.MyConnectionSingleton;

//Minha classe onde irei criar o CRUD seguindo o padrão de projetos DAO:
public class LeitoresCRUD {
    
    //Parâmetros para conexão:
    MyConnectionSingleton connect = new MyConnectionSingleton();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    LeitoresModel lm = new LeitoresModel();
    
    //Método listar, onde realizo um select no banco:
    public List listar() {
        
        //Lista que recebe os argumentos que serão passados:
        List<LeitoresModel>dados = new ArrayList<>();
        
        //Comando SQL que será executado no banco:
        String sql = "SELECT * FROM leitores";
        
        //Executando o select no banco e retornando os resultados:
        try {
            con = connect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                LeitoresModel l = new LeitoresModel();
                l.setNome(rs.getString("Nm_Leitores"));
                l.setCpf(rs.getString("Cpf_Leitores"));
                l.setEmail(rs.getString("Email_Leitores"));
                l.setTelefone(rs.getString("Tel_Leitores"));
                l.setEndereco(rs.getString("End_Leitores"));
                dados.add(l);
            }
            
        } catch (Exception e) {     
        } return dados;
    }
    
    //Método adicionar, onde realizo um insert no banco:
    public int Adicionar(LeitoresModel lm) {
        
        //Comando SQL para inserir no banco:
        String sql = "INSERT INTO leitores (Nm_Leitores, Cpf_Leitores, Email_Leitores, Tel_Leitores, End_Leitores) ";
        sql+= "VALUES (?, ?, ?, ?, ?)";
        
        //Enviando no try catch os parâmetros que serão inseridos no banco:
        try {
            con = connect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, lm.getNome());
            ps.setString(2, lm.getCpf());
            ps.setString(3, lm.getEmail());
            ps.setString(4, lm.getTelefone());
            ps.setString(5, lm.getEndereco());
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
        
        return 1;
    }
    
    //Método atualizar, onde realizo as edições nos cadastros do banco:
    public int Atualizar(LeitoresModel lm)
    {
        int r = 0;
        
        //Comando SQL para editar no banco:
        String sql = "UPDATE leitores SET Nm_Leitores = ?, Cpf_Leitores = ?, ";
               sql += "Email_Leitores = ?, Tel_Leitores = ?, End_Leitores = ? ";
               sql += "WHERE Cpf_Leitores = ? ";
               
        //Enviando no try catch os parâmetros que serão inseridos no banco:
        try {
            con = connect.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, lm.getNome());
            ps.setString(2, lm.getCpf());
            ps.setString(3, lm.getEmail());
            ps.setString(4, lm.getTelefone());
            ps.setString(5, lm.getEndereco());
            ps.setString(6, lm.getCpf());
            
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
        String sql = "DELETE FROM leitores where Cpf_Leitores = ?";
        
        try {
            con = connect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cpf);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
}
