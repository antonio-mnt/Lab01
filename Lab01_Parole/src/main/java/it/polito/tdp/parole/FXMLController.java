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
	
	Parole elenco;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private TextArea txtTempi;

    @FXML
    private Button btnCancella;

    @FXML
    private Button btnReset;

    @FXML
    void doCancella(ActionEvent event) {
    	
    	String selezionata = txtResult.getSelectedText();
    	elenco.cancella(selezionata);
    	
    	String e = "";
    	
    	for(String p: elenco.getElenco()) {
    		if(e.equals("")) {
    			e = p;
    		}else {
    			e += "\n"+p;
    		}
    	}
    	
    	txtResult.setText(e);
    	
    	//long time = System.nanoTime();
    	//txtTempi.appendText(""+time+" ns\n");
    	
    }

    @FXML
    void doInsert(ActionEvent event) {
    	
    	long startTime = System.nanoTime();
    	
    	String par = txtParola.getText();
    	if(par.contains(" ") || par.equals("")) {
    		return;
    	}
    	
    	elenco.addParola(par);
    	
    	String e = "";
    	
    	for(String p: elenco.getElenco()) {
    		if(e.equals("")) {
    			e = p;
    		}else {
    			e += "\n"+p;
    		}
    	}
    	
    	txtResult.setText(e);
    	txtParola.clear();
    	//long time = System.nanoTime();
		//long estimatedTime = (System.nanoTime() - startTime);
    	txtTempi.appendText(""+(System.nanoTime() - startTime)+" ns\n");
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	if(elenco.getElenco().size() == 0) {
    		return;
    	}
    	elenco.reset();
    	txtResult.clear();
    	
    	//long time = System.nanoTime();
    	//txtTempi.appendText(""+time+" ns\n");
    	txtTempi.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempi != null : "fx:id=\"txtTempi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        
        elenco = new Parole();

    }
}

