package negocio;

import javax.swing.JOptionPane;

public class VerificarCampo {
public String ValidarCampo(String login, String senha) {
	 
	String log = (JOptionPane.showInputDialog(null,"Informe o Login")); 
	// Verifica se o campo esta vazio!  
	if( log.equals("") ) {
		JOptionPane.showMessageDialog(null, "ERRO, Preenchimento  Obrigatorio!!!");
	}
	else {
		login = log;
		return login;
	}
	
	
	String se = (JOptionPane.showInputDialog(null,"Informe a senha")); 
	// Verifica se o campo esta vazio!  
	if( se.equals("") ) {
		JOptionPane.showMessageDialog(null, "ERRO, Preenchimento  Obrigatorio!!!");
	}
	else {
		senha = se;
}
	return senha;
	
}

}