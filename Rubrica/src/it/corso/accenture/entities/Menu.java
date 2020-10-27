package it.corso.accenture.entities;

import javax.swing.JOptionPane;

public class Menu {
	private String risposta;
	public Menu() {
		this.risposta=null;
		// TODO Auto-generated constructor stub
	}
	
	public String menuIniziale() {
		
		this.risposta = JOptionPane.showInputDialog(null, "CIAO PER INIZIARE SCEGLI LA TUA FUNZIONE.\n"+"1. VISUALIZZA ELENCO CONTATTI\n"+"2. AGGIUNGI CONTATTO\n"+
	"3.ELIMINA CONTATTO\n"+"4.AGGIORNA CONTATTO\n"+"5. CERCA PER NOME\n"+"6. CERCA PER NUMERO\n"+"7. ESCI", "RUBRICA TELEFONICA", JOptionPane.PLAIN_MESSAGE);
		return this.risposta;
	}
	
	public String menuNome() {
		this.risposta = JOptionPane.showInputDialog(null, "INSERISCI NOME CONTATTO: ", "RUBRICA TELEFONICA", JOptionPane.PLAIN_MESSAGE);
					return this.risposta;
	}
	public String menuNumero() {
		this.risposta = JOptionPane.showInputDialog(null, "INSERISCI NUMERO CONTATTO: ", "RUBRICA TELEFONICA", JOptionPane.PLAIN_MESSAGE);
					return this.risposta;
	}

	public String getRisposta() {
		return risposta;
	}

	public void setRisposta(String risposta) {
		this.risposta = risposta;
	}
	
}

