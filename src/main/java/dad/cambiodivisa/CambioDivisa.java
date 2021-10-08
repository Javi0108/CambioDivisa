package dad.cambiodivisa;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CambioDivisa extends Application {
	
	private TextField origenText;
	private TextField destinoText;
	private ComboBox<Divisa> divisaOrigenCombo;
	private ComboBox<Divisa> divisaDestinoCombo;
	private Button cambiar;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		origenText = new TextField();
		origenText.setPromptText("0");
		origenText.setMaxWidth(50);
		
		divisaOrigenCombo = new ComboBox<>();
		divisaOrigenCombo.setMaxWidth(100);
		divisaOrigenCombo.getItems().addAll(
				new Divisa("Euro", 1.0),
				new Divisa("Dolar", 1.2007),
				new Divisa("Libra", 0.8873),
				new Divisa("Yen", 133.59)
				);
		
		HBox cambio1 = new HBox(5, origenText, divisaOrigenCombo);
		cambio1.setAlignment(Pos.CENTER);
		
		destinoText = new TextField();
		destinoText.setPromptText("0");
		destinoText.setMaxWidth(50);
		destinoText.setDisable(true);
		
		divisaDestinoCombo = new ComboBox<>();
		divisaDestinoCombo.setMaxWidth(100);
		divisaDestinoCombo.getItems().addAll(
				new Divisa("Euro", 1.0),
				new Divisa("Dolar", 1.2007),
				new Divisa("Libra", 0.8873),
				new Divisa("Yen", 133.59)
				);
		
		HBox cambio2 = new HBox(5, destinoText, divisaDestinoCombo);
		cambio2.setAlignment(Pos.CENTER);
		
		cambiar = new Button("Cambiar");
		cambiar.setOnAction(e -> onCambiarAction(e));
		
		VBox root = new VBox(5);
		root.setAlignment(Pos.CENTER);
		root.setSpacing(5);
		root.getChildren().addAll(cambio1, cambio2, cambiar);
		
		Scene scene = new Scene(root, 350, 250);
		primaryStage.setTitle("Cambio de Divisa");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	private void onCambiarAction(ActionEvent e) {
			Double cantidadOrigen = Double.parseDouble(origenText.getText());
			Divisa divisa_Origen = divisaOrigenCombo.getSelectionModel().getSelectedItem();
			Divisa divisa_Destino = divisaDestinoCombo.getSelectionModel().getSelectedItem();
			
			destinoText.setText(Divisa.fromTo(divisa_Origen, divisa_Destino, cantidadOrigen).toString());
	}

	public static void main(String[] args) {
		launch(args);
	}

}
