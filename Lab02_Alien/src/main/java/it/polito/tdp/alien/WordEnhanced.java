package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class WordEnhanced {
	
	private String alienWord ;
	private String translation ;
	private List<String> traduzioni;
	
	public WordEnhanced(String alienWord, String translation) {
		this.alienWord = alienWord ;
		//this.translation = translation ;
		this.traduzioni = new LinkedList<String>();
		traduzioni.add(translation);
	}
	
	public String getAlienWord() {
		return this.alienWord;
	}
	
	public String getTranslation() {
		return this.translation ;
	}
	
	public void setTranslation(String translation) {
		this.translation = translation ;
	}
	
	public void addTranslation(String translation) {
		if(this.traduzioni.contains(translation)==false)
			this.traduzioni.add(translation);
	}
	
	public List<String> getTraduzioni(){
		return this.traduzioni;
	}


}
