package visao.controle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import org.controlsfx.control.Notifications;

import Dao.PessoaDao;
import application.Main;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelo.dominio.Pessoa;
import negocio.PessoaNegocio;

public class PessoaControle {
	@FXML
	private Pane paneCadPessoas;
	@FXML
	private Label lbcadpessoas;
	@FXML
	private Label lbNome;
	@FXML
	private TextField txtNome;
	@FXML
	private Label lbCPF;
	@FXML
	private TextField txtCPF;
	@FXML
	private Label lbEndereco;
	@FXML
	private TextField txtEndereco;
	@FXML
	private Label lbTelefone;
	@FXML
	private TextField txtTelefone;
	@FXML
	private Label lbEmail;
	@FXML
	private TextField txtEmail;
	@FXML
	private Label lbSenha;
	@FXML
	private TextField txtSenha;
	@FXML
	private Button btnLimpar;
	@FXML
	private Button btnSalvar;

	// Event Listener on Button[#btnSalvar].onAction
	@FXML

	Pessoa pessoa = new Pessoa();
	PessoaNegocio pessoaNegocio = new PessoaNegocio();
	PessoaDao pessoaDao = new PessoaDao();
	Main main = null;
	@FXML
	public void salvar() throws SQLException {
		String validar;
		boolean validacao = false;
		pegaValores(pessoa);
		validacao = validarCampos();
		if(validacao) {
			if (pessoa.getId() == 0) {
				validar = pessoaNegocio.salvar(pessoa);
				if(validar.equals("salvo")) {
					String msg = "Usuário inserido!";
					System.out.println(msg);
					limparCadastro();
				}else{
					System.out.println(validar);
				}
			} 
		}
	}
	private void pegaValores(Pessoa pessoa) {

		pessoa.setNome(txtNome.getText());
		pessoa.setCPF(txtCPF.getText());
		pessoa.setEndereco(txtEndereco.getText());
		pessoa.setTelefone(txtTelefone.getText());
		pessoa.setEmail(txtEmail.getText());
		pessoa.setSenha(txtSenha.getText());

		if(pessoa.getId()==0){
			pessoa.setSenha("123456");
		}
	}
	@FXML
	public boolean validarCampos(){

		String nome =  txtNome.getText();
		String cpf = txtCPF.getText();
		String email = txtEmail.getText();
		String senha = txtSenha.getText();

		List<Control>  controls = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		sb.append("");

		if(nome.equals("") || nome == null){
			sb.append("O nome não pode estar vazio!. \n");
			controls.add(txtNome);
		}
		if(cpf.equals("") || cpf == null){
			sb.append("O CPF não pode estar vazio!. \n");
			controls.add(txtCPF);
		}

		if(email.equals("") || email == null){
			sb.append("O E-mail não pode estar vazio!. \n");
			controls.add(txtEmail);
		}
		if(senha.equals("") || senha == null){
			sb.append("A senha não pode estar vazia!. \n");
			controls.add(txtSenha);
		}

		if(!sb.equals("")) {
			System.out.println(sb.toString());
			animaCamposValidados(controls);
		}

		return sb.toString().isEmpty();
	}
	@FXML
	public void limparCadastro() {

		txtNome.setText("");
		txtCPF.setText("");
		txtEndereco.setText("");
		txtTelefone.setText("");
		txtEmail.setText("");
		txtSenha.setText("");
		txtNome.requestFocus();
	}

	public void animaCamposValidados(List<Control> controls) {
		controls.forEach(control -> {
			RotateTransition rotateTransition = new RotateTransition(Duration.millis(60), control);
			rotateTransition.setFromAngle(-4);
			rotateTransition.setToAngle(4);
			rotateTransition.setCycleCount(8);
			rotateTransition.setAutoReverse(true);
			rotateTransition.setOnFinished((ActionEvent event1) ->{
				control.setRotate(0);
			});
			rotateTransition.play();
		});
		if(!controls.isEmpty()){
			controls.get(0).requestFocus();

		}
	}

}

