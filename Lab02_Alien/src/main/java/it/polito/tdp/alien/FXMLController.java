package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private AlienDictionary dictionary = new AlienDictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInput;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtOutput;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {
    	this.txtOutput.clear();
    	this.txtInput.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	
    	String parolaTraduzione = txtInput.getText().toLowerCase();
    	
    	boolean corretto = dictionary.isCorrect(parolaTraduzione.replace(" ", ""));
    	
    	if(corretto==false) {
    		txtOutput.appendText("Devi inserire solo lettere!\n");
    		return ;
    	}
    	
    	
    	if(parolaTraduzione.contains(" ")) {
    		int indiceSpazio = parolaTraduzione.indexOf(" ");
        	int lunghezzaStringa = parolaTraduzione.length();
        	String alienWord = parolaTraduzione.substring(0, indiceSpazio);
        	String translation = parolaTraduzione.substring(indiceSpazio, lunghezzaStringa);
 
    		dictionary.addWord(alienWord, translation);
    		return ;
    	}
    	else if(parolaTraduzione.contains("?")) {
    		int indiceInterrogativo = parolaTraduzione.indexOf("?");
    		int lunghezzaStringa = parolaTraduzione.length();
    		String partePrima = parolaTraduzione.substring(0, indiceInterrogativo);
    		String parteSeconda = parolaTraduzione.substring(indiceInterrogativo, lunghezzaStringa);
    		
    		for(WordEnhanced w: dictionary.dictionary) {
    			String prima = w.getAlienWord().substring(0, indiceInterrogativo);
    			String seconda = w.getAlienWord().substring(indiceInterrogativo, lunghezzaStringa);
    			if((partePrima.compareTo(prima)==0)&&(parteSeconda.compareTo(seconda)==0)) {
    				txtOutput.appendText(dictionary.stampaTraduzioni(w));
    				return ;
    			}
    		}
    	}
    	else {
    		for(WordEnhanced w: dictionary.dictionary) {
    			if(w.getAlienWord().compareTo(parolaTraduzione)==0) {
    				txtOutput.appendText(dictionary.stampaTraduzioni(w));
    				return ;
    			}
    		}
    	}

    }

    @FXML
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
}
