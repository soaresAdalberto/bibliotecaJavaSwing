package uemg.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyConnectionSingleton {
    
    //Atributos da minha classe:
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost";
    private static final String PORT = "3306";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static final String DATABASE = "acervobiblioteca";
    private static final String TIMEZONE = "useTimezone=true&serverTImezone=UTC";
    
    private Connection conn;
    private static MyConnectionSingleton instance;

    //Método de conexão seguindo o padrão de projeto singleton:
    public MyConnectionSingleton() {
        
        //Criando a string de conexão:
        String connect = URL + ":" + PORT + "/" + DATABASE + "?" + TIMEZONE;
        
        //Realizando a conexão com o banco de dados:
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(connect, USER, PASS);
            System.out.println("Conexão realizada com sucesso!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possível realizar a conexão com o banco de dados!");
        } catch (SQLException ex) {
            System.out.println("Não foi possível realizar a conexão com o banco de dados!");
        }
        
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    public static MyConnectionSingleton getInstance() throws SQLException{
        
        if(instance == null)
            instance = new MyConnectionSingleton();
        else if(instance.getConnection().isClosed())
            instance = new MyConnectionSingleton();
        
        return instance;
    }
}
