package negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Dao.LoginDao;
import Dao.PessoaDao;
import modelo.dominio.Pessoa;

public class PessoaNegocio {
	
	PessoaDao pessoaDao = new PessoaDao();
	
	
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
	
	 public String salvar(Pessoa pessoa) throws SQLException {
	    	
	        boolean cpfValido = false;
	        boolean emailValido = false;
	        String salvo = "falha!";
	        StringBuilder sb = new StringBuilder();
//	        cpfValido = validaCPF(adm.getCpf());
//	        if (!cpfValido) {
//	            sb.append("cpf inválido. \n");
//	        }
	        emailValido = validEmail(pessoa.getEmail());
	        if (!emailValido) {
	            sb.append("Email inválido. \n");
	        }
	        if(!checarUsuario(pessoa)){
	        	sb.append("Email já cadastrado no sistema!\n");
	        }
	        if (sb.toString().isEmpty()) {
	          salvo = pessoaDao.Cadastrar(pessoa);
	        } else {
	            sb.append(salvo);
	            return sb.toString();
	        }
	        sb.append(salvo);
	        return sb.toString();
	    }
	 
	 public List<Pessoa> listarpessoas() throws SQLException{
	        List<Pessoa> pessoas = new ArrayList<Pessoa>();
	        pessoas = pessoaDao.listarPessoas();
	        return pessoas;
	 }
	 
	 public boolean checarUsuario(Pessoa pessoa) throws SQLException{
	    	
	    	List<Pessoa> pessoaList = new ArrayList<>();
	    	pessoaList = listarpessoas();
	    	
	    	for(Pessoa pessoa2: pessoaList){
	    		if(pessoa.getEmail().equalsIgnoreCase(pessoa2.getEmail())){
	    			return false;
	    		}
	    	}
	    	return true;
	    	
	    }

}
