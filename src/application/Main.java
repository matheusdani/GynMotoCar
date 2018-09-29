package application;
	
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

	@Override
	public void start(Stage principal) throws Exception{
		VBox raiz = new VBox(10); // 1
		raiz.setAlignment(Pos.CENTER); // 2
		URL arquivoFXML;
		arquivoFXML = getClass().getResource("/visao/telas/Login.fxml");
		Parent fxmlParent =(Parent) FXMLLoader.load(arquivoFXML);
		Scene cena = new Scene(fxmlParent, 790, 600);
		principal.resizableProperty().setValue(false);
		principal.setTitle("GynMotoCar");
		principal.setScene(cena);
		principal.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
