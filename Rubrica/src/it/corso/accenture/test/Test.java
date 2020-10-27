package it.corso.accenture.test;

import javax.swing.JOptionPane;

import it.corso.accenture.entities.Menu;
import it.corso.accenture.entities.Rubrica;

public class Test {

	public static void main(String[] args) {
		Menu menu= new Menu ();
		Rubrica telefono= new Rubrica ();
		boolean ricomincia = false;
		do {
		switch(menu.menuIniziale()) {
		case "1":
			telefono.stampaRubrica();
			break;
		case "2":
			
			telefono.aggiungiContatto(menu.menuNome(), menu.menuNumero());
			break;
		case "3":
			JOptionPane.showMessageDialog(null, "Inserisci il nome del contatto da eliminare: ", "RUBRICA TELEFONICA",JOptionPane.PLAIN_MESSAGE);
			telefono.eliminaContatto(menu.menuNome());
			break;
		case "4":
			JOptionPane.showMessageDialog(null, "Inserisci il nome del contatto da aggiornare: ", "RUBRICA TELEFONICA",JOptionPane.PLAIN_MESSAGE);
			telefono.aggiornaContatto(menu.menuNome(), menu.menuNumero());
			break;
		case "5":
			JOptionPane.showMessageDialog(null, "Inserisci il nome del contatto da cercare: ", "RUBRICA TELEFONICA",JOptionPane.PLAIN_MESSAGE);
			telefono.cercaNome(menu.menuNome());
			break;
		case "6":
			JOptionPane.showMessageDialog(null, "Inserisci il numero del contatto da cercare: ", "RUBRICA TELEFONICA",JOptionPane.PLAIN_MESSAGE);
			telefono.cercaNumero(menu.menuNumero());
			break;
		case "7":
			JOptionPane.showMessageDialog(null, "Programma Terminato", "PARCO AUTO", JOptionPane.PLAIN_MESSAGE);
		ricomincia= true;
			break;
			default:
				JOptionPane.showMessageDialog(null, "ATTENZIONE RISPOSTA NON VALIDA RIPROVARE", "RUBRICA TELEFONICA", JOptionPane.PLAIN_MESSAGE);
				}
		}while(ricomincia == false);
				
			
		
	
	}

}
