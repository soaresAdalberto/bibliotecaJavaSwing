package uemg.control;

import javax.swing.JOptionPane;
import uemg.view.Login;
import uemg.view.Menu;

public class LoginController {
    
    //Atributos das views que serão controladas:
    private Login l;
    private Menu m;
    
    //Usuário e senha:
    private String user = "admin";
    private String pass = "admin";

    //Construtor do controller:
    public LoginController(Login l, Menu m) {
        this.l = l;
        this.m = m;
    }
    
    //Método que realiza login:
    public void logar(){
        String usuario, senha;
        usuario = getL().getTxfUsuario().getText();
        senha = String.valueOf(getL().getPfSenha().getPassword());
        
        if(usuario.equalsIgnoreCase(getUser()) && senha.equalsIgnoreCase(getPass())){            
            getM().setVisible(true);
            getL().setVisible(false);
        }else{
            JOptionPane.showMessageDialog(getL(), "Usuário e/ou senha incorretos!", "Erro ao logar no sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Métodos GET e SET:
    public Login getL() {
        return l;
    }

    public void setL(Login l) {
        this.l = l;
    }

    public Menu getM() {
        return m;
    }

    public void setM(Menu m) {
        this.m = m;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
