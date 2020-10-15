package ejerciciosCambioDivisa;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CambioDivisa extends Application{

	private Divisa euro = new Divisa("Euro", 1.0);
    private Divisa libra = new Divisa("Libra", 0.9);
    private Divisa dolar = new Divisa("Dólar", 1.17);
    private Divisa yen = new Divisa("Yen", 124.17);
	
	private Stage primaryStage;
	
	private Button cambiarButton;
	private ComboBox<String> origenCombo;
	private ComboBox<Integer> destinoCombo;
	private TextField origenText, destinoText;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		origenText = new TextField("0");
		origenText.setPrefColumnCount(4);
		
		origenCombo = new ComboBox();
		
		HBox origenBox = new HBox();
		origenBox.setAlignment(Pos.BASELINE_CENTER);
		origenBox.setSpacing(5);
		origenBox.getChildren().addAll(origenText, origenCombo);
		origenBox.setStyle("-fx-background-color: white");
		
		destinoText = new TextField("0");
		destinoText.setPrefColumnCount(4);
		
		HBox destinoBox = new HBox();
		destinoBox.setAlignment(Pos.BASELINE_CENTER);
		destinoBox.setSpacing(5);
		destinoBox.getChildren().addAll(destinoText, origenCombo);
		destinoBox.setStyle("-fx-background-color: white");
		
		cambiarButton = new Button("Cambiar");
		
		
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(origenBox, destinoBox, cambiarButton);
		
		Scene scene = new Scene(root, 320, 200);
		
		primaryStage.setTitle("Cambion de divisa");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		}

	public static void main(String[] args) {
		launch(args);

	}

}
