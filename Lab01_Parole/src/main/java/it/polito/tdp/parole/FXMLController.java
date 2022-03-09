package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;
    
    @FXML 
    private TextArea txtTempi; 

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doInsert(ActionEvent event) {
    	double start=System.nanoTime();    
    	elenco.addParola(txtParola.getText());
    	txtResult.setText(elenco.getElenco().toString());  //nel setText posso mettere solo stringhe
    	txtParola.clear();
    	double end=System.nanoTime();
    	txtTempi.setText(""+(end-start)/1e9);
    }

    @FXML
    void doReset(ActionEvent event) {
    	double start=System.nanoTime();   //System.nanoTime dice il tempo corrente 
    	elenco.reset();
    	txtResult.clear();
    	txtParola.clear();
    	double end=System.nanoTime();
    	txtTempi.setText(""+(end-start)/1e9);   //tempo che ci ha messo a fare l'operazione (nanosecondi/1e9=secondi)
    }


    @FXML
    void doCancella(ActionEvent event) {
    	double start=System.nanoTime();   
    	elenco.deleteParola(txtParola.getText());
    	txtParola.clear();
    	txtResult.setText(elenco.getElenco().toString());
    	double end=System.nanoTime();
    	txtTempi.setText(""+(end-start)/1e9); 
    }
    
    
    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}

//L'arrayList è più lenta rispetto alla LinkedList che quindi è più conveniente