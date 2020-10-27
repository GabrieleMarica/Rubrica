package it.corso.accenture.entities;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

import javax.swing.JOptionPane;

public class Rubrica {

	// TODO Auto-generated constructor stub
	private TreeMap<String, String> myMap;

	public Rubrica() {
		myMap = new TreeMap<String, String>();

		// TODO Auto-generated constructor stub
	}

	public Map<String, String> stampaRubrica() {

		Set<Entry<String, String>> entries = myMap.entrySet();
		Iterator<Entry<String, String>> iter = entries.iterator();

		if (iter.hasNext()) {
			JOptionPane.showMessageDialog(null, "Contatti:\n", "RUBRICA TELEFONICA", JOptionPane.PLAIN_MESSAGE);
			String a = "";
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				String key = (String) entry.getKey();
				String value = (String) entry.getValue();
				a += " Nome: " + key + " Numero: " + value + "\n";

			}
			JOptionPane.showMessageDialog(null, a, "RUBRICA TELEFONICA", JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "NESSUN CONTATTO IN RUBRICA", "RUBRICA TELEFONICA",
					JOptionPane.PLAIN_MESSAGE);
		}

		System.out.println("Scritture e Lettura file in console");
		scritturaSuFile(myMap);
		return myMap;

	}

	public Map<String, String> aggiungiContatto(String chiaveTemp, String valoreTemp) {

		if (!this.myMap.containsKey(chiaveTemp)) {
			this.myMap.put(chiaveTemp, valoreTemp);

		} else {
			JOptionPane.showMessageDialog(null, "ATTENZIONE NOME GIA INSERITO IN RUBRICA. RIPROVARE.",
					"RUBRICA TELEFONICA", JOptionPane.PLAIN_MESSAGE);

		}
		scritturaSuFile(myMap);
		return myMap;
	}

	public Map<String, String> eliminaContatto(String chiaveTemp, Predicate<String> p) {
		/*
		 * if (this.myMap.containsKey(chiaveTemp)) { this.myMap.remove(chiaveTemp);
		 * JOptionPane.showMessageDialog(null, "CONTATTO ELIMINATO",
		 * "RUBRICA TELEFONICA", JOptionPane.PLAIN_MESSAGE); } else {
		 * JOptionPane.showMessageDialog(null, "NESSUN CONTATTO IN RUBRICA",
		 * "RUBRICA TELEFONICA", JOptionPane.PLAIN_MESSAGE); } scritturaSuFile(myMap);
		 * return myMap; }
		 */
		if (myMap.size() >= 1) {
			for (Entry<String, String> a : myMap.entrySet()) {
				if (p.test(a.getKey()) && p.test(chiaveTemp)) {

					myMap.remove(a.getKey(), a.getValue());
					JOptionPane.showMessageDialog(null, "CONTATTO ELIMINATO", "RUBRICA TELEFONICA",
							JOptionPane.PLAIN_MESSAGE);
				 break;
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, "NESSUN CONTATTO IN RUBRICA", "RUBRICA TELEFONICA",
					JOptionPane.PLAIN_MESSAGE);
		}

		return myMap;

	}

	public Map<String, String> aggiornaContatto(String chiaveTemp,String valoreTemp, Predicate<String> p) {

		/*
		 * if (this.myMap.containsKey(chiaveTemp)) { this.myMap.put(chiaveTemp,
		 * valoreTemp); JOptionPane.showMessageDialog(null, "CONTATTO AGGIORNATO",
		 * "RUBRICA TELEFONICA", JOptionPane.PLAIN_MESSAGE); } else {
		 * JOptionPane.showMessageDialog(null, "NESSUN CONTATTO IN RUBRICA",
		 * "RUBRICA TELEFONICA", JOptionPane.PLAIN_MESSAGE); } scritturaSuFile(myMap);
		 * return myMap; }
		 */
		if (myMap.size() >= 1) {
			for (Entry<String, String> a : myMap.entrySet()) {
				if (p.test(a.getKey()) && p.test(chiaveTemp)) {

					myMap.replace(a.getKey(), a.getValue(), valoreTemp);
					JOptionPane.showMessageDialog(null, "CONTATTO AGGIORNATO", "RUBRICA TELEFONICA",
							JOptionPane.PLAIN_MESSAGE);
					break;
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, "NESSUN CONTATTO IN RUBRICA", "RUBRICA TELEFONICA",
					JOptionPane.PLAIN_MESSAGE);
		}

		return myMap;

	}

	public Map<String, String> cercaNumero(String valoreTemp, Predicate<String> p) {
		// Set<Entry<String, String>> entries = myMap.entrySet();

		/*
		 * Iterator<Entry<String, String>> iter = entries.iterator(); if
		 * (this.myMap.values().contains(valoreTemp)) { Map.Entry entry = (Map.Entry)
		 * iter.next(); String key = (String) entry.getKey(); String value = (String)
		 * entry.getValue(); JOptionPane.showMessageDialog(null, " Nome: " + key +
		 * " Numero: " + value, "RUBRICA TELEFONICA", JOptionPane.PLAIN_MESSAGE);
		 */
		if (myMap.size() >= 1) {
			for (Entry<String, String> a : myMap.entrySet()) {
				if (p.test(a.getValue()) && p.test(valoreTemp)) {

					JOptionPane.showMessageDialog(null, " Nome: " + a.getKey() + " Numero: " + a.getValue(),
							"RUBRICA TELEFONICA", JOptionPane.PLAIN_MESSAGE);
					break;
				} 
			}
		} else {
			JOptionPane.showMessageDialog(null, "NESSUN CONTATTO IN RUBRICA", "RUBRICA TELEFONICA",
					JOptionPane.PLAIN_MESSAGE);
		}

		return myMap;

	}

	public Map<String, String> cercaNome(String chiaveTemp, Predicate<String> p) {
		/*
		 * Set<Entry<String, String>> entries = myMap.entrySet(); Iterator<Entry<String,
		 * String>> iter = entries.iterator(); if (this.myMap.containsKey(chiaveTemp)) {
		 * Map.Entry entry = (Map.Entry) iter.next(); String key = (String)
		 * entry.getKey(); String value = (String) entry.getValue();
		 * JOptionPane.showMessageDialog(null, " Nome: " + key + " Numero: " + value,
		 * "RUBRICA TELEFONICA", JOptionPane.PLAIN_MESSAGE); } else {
		 * JOptionPane.showMessageDialog(null, "NESSUN CONTATTO IN RUBRICA",
		 * "RUBRICA TELEFONICA", JOptionPane.PLAIN_MESSAGE); } return myMap;
		 */
		if (myMap.size() >= 1) {
			for (Entry<String, String> a : myMap.entrySet()) {
				if (p.test(a.getKey()) && p.test(chiaveTemp)) {

					JOptionPane.showMessageDialog(null, " Nome: " + a.getKey() + " Numero: " + a.getValue(),
							"RUBRICA TELEFONICA", JOptionPane.PLAIN_MESSAGE);
				} 
			}
		} else {
			JOptionPane.showMessageDialog(null, "NESSUN CONTATTO IN RUBRICA", "RUBRICA TELEFONICA",
					JOptionPane.PLAIN_MESSAGE);
		}

		return myMap;

	}

	public void scritturaSuFile(Map<String, String> a) {
		try {
			File fileTwo = new File("C:\\Users\\gabri\\Desktop\\Documenti\\Gabriele Java\\telefono.txt");
			FileOutputStream fos = new FileOutputStream(fileTwo);
			PrintWriter pw = new PrintWriter(fos);

			for (Map.Entry<String, String> m : a.entrySet()) {
				pw.println(m.getKey() + "=" + m.getValue());
			}

			pw.flush();
			pw.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		letturaSuFile();

	}

	public void letturaSuFile() {
		try {
			File toRead = new File("C:\\Users\\gabri\\Desktop\\Documenti\\Gabriele Java\\telefono.txt");
			FileInputStream fis = new FileInputStream(toRead);

			Scanner sc = new Scanner(fis);

			Map<String, String> mapInFile = new TreeMap<String, String>();

			// read data from file line by line:
			String currentLine;
			while (sc.hasNextLine()) {
				currentLine = sc.nextLine();
				// now tokenize the currentLine:
				StringTokenizer st = new StringTokenizer(currentLine, "=", false);
				// put tokens ot currentLine in map
				mapInFile.put(st.nextToken(), st.nextToken());
			}
			fis.close();

			// print All data in MAP
			for (Map.Entry<String, String> m : mapInFile.entrySet()) {
				System.out.println("Nome: " + m.getKey() + " Numero: " + m.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
