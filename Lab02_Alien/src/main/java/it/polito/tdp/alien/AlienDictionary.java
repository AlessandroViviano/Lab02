package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {
	
	List<WordEnhanced> dictionary ;
	
	public AlienDictionary() {
		dictionary = new LinkedList<WordEnhanced>();
	}
	
	public void addWord(String alienWord, String translation) {
		
		for(WordEnhanced w: dictionary)
			if(w.getAlienWord().compareTo(alienWord)==0)
				w.addTranslation(translation);
		
		WordEnhanced wTemp = new WordEnhanced(alienWord, translation);
		dictionary.add(wTemp);
	}
	
	public String translateWord(String alienWord) {
		for(WordEnhanced w: dictionary) {
			if(w.getAlienWord().compareTo(alienWord)==0)
				return w.getTranslation();
		}
		return null ;
	}
	
	public boolean isCorrect(String parola) {
		
		boolean corretto = true;
		
		for(int i=0; i<parola.length(); i++) {
			int ch = parola.charAt(i);
			if(Character.isLetter(ch)==false && ch!='?') {
				corretto = false;
			}
		}
		
		if(corretto==true)
			return true;
		else
			return false;
	}
	
	public String stampaTraduzioni(WordEnhanced word) {
	
		String str = "";
		
		for(String s: word.getTraduzioni())
			str += s+"\n";
		
		return str;
	}
	

}
