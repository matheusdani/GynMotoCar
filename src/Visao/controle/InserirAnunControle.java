package Visao.controle;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

import javafx.scene.layout.Pane;

public class InserirAnunControle {
	@FXML
	private Pane paneInserirAnun;
	@FXML
	private Label lbanuncio;
	@FXML
	private Label lbdescricao;
	@FXML
	private Label lbmodelo;
	@FXML
	private TextField txtmodelo;
	@FXML
	private Label lbmarca;
	@FXML
	private TextField txtmarca;
	@FXML
	private Label lbtipo;
	@FXML
	private TextField txttipo;
	@FXML
	private Label lbpotencia;
	@FXML
	private TextField txtpotencia;
	@FXML
	private Label lbvalor;
	@FXML
	private TextField txtvalor;
	@FXML
	private Label lbcombustivel;
	@FXML
	private ComboBox cbocombustivel;
	@FXML
	private TextField txtdescricao;
	@FXML
	private Label lbano;
	@FXML
	private ComboBox cboano;
	@FXML
	private Label lbcor;
	@FXML
	private ComboBox cbocor;
	@FXML
	private Label lbmensagem;
	@FXML
	private TextField txtmensagem;
	@FXML
	private Button btnCancel;
	@FXML
	private Button btnSalvar;

	// Event Listener on Button[#btnCancel].onAction
	@FXML
	public void cancelarInserir(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#btnSalvar].onAction
	@FXML
	public void salvarAnuncio(ActionEvent event) {
		// TODO Autogenerated
	}
}