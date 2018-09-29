package negocio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Dao.LoginDao;
import modelo.dominio.Usuario;

public class LoginNegocio {
	LoginDao loginDao = new LoginDao();
	
	public String fazerLogin(Usuario user) {
		String salvo = "salvo";
		
		if(validEmail(user.getLogin())) {
			user = loginDao.buscarUser(user.getLogin());
			if(user==null){
				salvo = "Usuário não cadastrado no sistema";
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

}
