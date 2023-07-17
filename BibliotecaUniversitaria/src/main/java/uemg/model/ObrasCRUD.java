package uemg.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import uemg.singleton.MyConnectionSingleton;

//Minha classe onde irei criar o CRUD seguindo o padrão de projetos DAO:
public class ObrasCRUD {
    
    //Parâmetros para conexão:
    MyConnectionSingleton connect = new MyConnectionSingleton();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    ObrasModel om = new ObrasModel();
    
    //Método para realizar pesquisa no banco de dados:
    public List Pesquisar(){
        
        List<ObrasModel>dados = new ArrayList<>(); 
        
        String sql = "SELECT * FROM obras";
        
        try {
            con = connect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                ObrasModel o = new ObrasModel();
                o.setTipo_Periodico(rs.getString("Tipo_Periodicos"));
                o.setCategoria_Periodico(rs.getString("Categoria_Periodicos"));
                o.setNome_Obra(rs.getString("Nm_Obra"));
                o.setAutor(rs.getString("Nm_Autor"));
                o.setEdicao(rs.getInt("Edicao"));
                o.setCidade(rs.getString("Cidade"));
                o.setEditora(rs.getString("Editora"));
                o.setPaginas(rs.getInt("Paginas"));
                o.setCm(rs.getFloat("Cm"));
                o.setIsbn(rs.getString("Isbn"));
                o.setCdu(rs.getString("Cdu"));
                o.setExemplares(rs.getInt("Exemplares"));
                o.setAno(rs.getInt("Ano"));
                o.setPalavras_Chave(rs.getString("Palavras_Chave"));
                
                dados.add(o);
            }
            
        } catch (Exception e) {
        }
        
        return dados;
    }
    
    //Método para fazer inclusão no banco de dados:
    public int Adicionar(ObrasModel om) {
        
        String sql = " INSERT INTO obras (Tipo_Periodicos, Categoria_Periodicos, Nm_Obra, Nm_Autor, Edicao, Cidade, Editora, Paginas, Cm, Isbn, Cdu, Exemplares, Ano, Palavras_Chave) ";
               sql += " VALUES";
               sql += " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = connect.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, om.getTipo_Periodico());
            ps.setString(2, om.getCategoria_Periodico());
            ps.setString(3, om.getNome_Obra());
            ps.setString(4, om.getAutor());
            ps.setInt(5, om.getEdicao());
            ps.setString(6, om.getCidade());
            ps.setString(7, om.getEditora());
            ps.setInt(8, om.getPaginas());
            ps.setFloat(9, om.getCm());
            ps.setString(10, om.getIsbn());
            ps.setString(11, om.getCdu());
            ps.setInt(12, om.getExemplares());
            ps.setInt(13, om.getAno());
            ps.setString(14, om.getPalavras_Chave());
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return 1;
    }
    
    //Método para atualizar os dados no banco:
    public int Atualizar(ObrasModel om) {
        int r = 0;
        
        String sql = "UPDATE obras SET Tipo_Periodicos = ?, Categoria_Periodicos = ?, Nm_Obra = ?, Nm_Autor = ?, ";
        sql += "Edicao = ?, Cidade = ?, Editora = ?, Paginas = ?, Cm = ?, Isbn = ?, Cdu = ?, Exemplares = ?, Ano = ?, Palavras_Chave = ?";
        sql += "WHERE Nm_Obra = ?";
    
        try {
            con = connect.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, om.getTipo_Periodico());
            ps.setString(2, om.getCategoria_Periodico());
            ps.setString(3, om.getNome_Obra());
            ps.setString(4, om.getAutor());
            ps.setInt(5, om.getEdicao());
            ps.setString(6, om.getCidade());
            ps.setString(7, om.getEditora());
            ps.setInt(8, om.getPaginas());
            ps.setFloat(9, om.getCm());
            ps.setString(10, om.getIsbn());
            ps.setString(11, om.getCdu());
            ps.setInt(12, om.getExemplares());
            ps.setInt(13, om.getAno());
            ps.setString(14, om.getPalavras_Chave());
            ps.setString(15, om.getNome_Obra());
            
            r = ps.executeUpdate();
            
            if (r != 0) {
                return 1;
            } else {
                return 0;
            }
            
        } catch (Exception e) {
        }
        
        return r;
    }   
    
    public void Deletar(String nome) {
        
        String sql = "DELETE FROM obras WHERE Nm_Obra = ?";
        
        try {
            con = connect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nome);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
