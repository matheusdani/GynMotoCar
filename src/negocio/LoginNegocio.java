package negocio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.xml.bind.ValidationEvent;

import Dao.LoginDao;
import Modelo.dominio.Usuario;

public class LoginNegocio {
	LoginDao loginDao = new LoginDao();
	
	public String fazerLogin(Usuario user) {
		String salvo = "salvo";
		
		salvo = ValidarCampo(user.getLogin(), user.getSenha());
		if(salvo.equals("salvo")) {
			if(validEmail(user.getLogin())) {
				user = loginDao.buscarUser(user.getLogin());
				if(user==null){
					salvo = "Usuário não cadastrado no sistema";
				}
			}
			
		}
		
		return salvo;
	}


	public boolean validEmail(String email) {
		System.out.println("Metodo de validacao de email");
		Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$"); 
		Matcher m = p.matcher(email); 
		if (m.find()){
			System.out.println("O email "+email+" e valido");
			return true;
		}
		else{
			System.out.println("O E-mail "+email+" é inválido");
			return false;
		}  
	}


	public String ValidarCampo(String login, String senha) {

		String log = (JOptionPane.showInputDialog(null,"Informe o Login")); 
		// Verifica se o campo esta vazio!  
		if( log.equals("") ) {
			JOptionPane.showMessageDialog(null, "ERRO, Preenchimento  Obrigatorio!!!");
		}
		else {
			login = "salvo";
			return login;
		}


		String se = (JOptionPane.showInputDialog(null,"Informe a senha")); 
		// Verifica se o campo esta vazio!  
		if( se.equals("") ) {
			JOptionPane.showMessageDialog(null, "ERRO, Preenchimento  Obrigatorio!!!");
		}
		else {
			senha = "salvo";
		}
		return senha;

	}

}
