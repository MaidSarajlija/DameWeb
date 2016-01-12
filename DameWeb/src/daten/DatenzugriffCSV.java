package daten;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

import klassen.FarbEnum;
import klassen.KI;
import klassen.KI_Dame;
import klassen.SpielBean;
import klassen.Spielbrett;
import klassen.Spieler;
import klassen.Spielfeld;
import klassen.Spielfigur;

public class DatenzugriffCSV implements Serializable, iDatenzugriff {

	private static final long serialVersionUID = -1632008787864445195L;

	private SpielBean spiel;
	private Spieler s1;
	private Spieler s2;
	Spielbrett brett;
	private ObjectOutputStream oos = null;

	private BufferedWriter br;
	private FileWriter file;
	private BufferedReader rd;
	private FileReader reader;

	/**
	 * Diese Methode öffnet die CSV Datei.
	 */

	public DatenzugriffCSV(SpielBean spiel) {
		this.spiel = spiel;
	}

	@Override
	public void speichern(Object o, String filename) {
		Spielfeld[][] belegung = spiel.getSpielbrett().getFelder();
		try {
			br = new BufferedWriter(new FileWriter(filename + ".csv"));
		} catch (IOException e2) {

			e2.printStackTrace();
		}
		try {

			FarbEnum farbe = spiel.getSpielerAmZug().getFarbe();

			if ((spiel.getSpielerAmZug().getKi() == null)) {

				br.write("spieler :" + spiel.getSpieler1().getName() + " ; "
						+ " mit der Farbe " + spiel.getSpieler1().getFarbe()
						+ " ;" + " Mensch");
				br.newLine();

				br.write("spieler :" + spiel.getSpieler2().getName() + " ; "
						+ " mit der Farbe " + spiel.getSpieler2().getFarbe()
						+ " ;" + " Mensch" + "\n");
				br.newLine();

			} else if (spiel.getSpielerAmZug().getKi() instanceof KI) {
				if (farbe == FarbEnum.WEISS) {
					br.write("spieler :" + spiel.getSpielerAmZug().getName()
							+ " ;" + "WEISS" + ";" + "ki");
					br.newLine();
				}
				if (farbe == FarbEnum.SCHWARZ) {
					br.write(spiel.getSpielerAmZug().getName() + " ;"
							+ "SCHWARZ" + ";" + "ki" + "\n");
					br.newLine();
				}
			}

			char ch = 'L';
			char ch1 = 'A';
			int x = 1;
			String str = null;
			boolean schwarz = true;

			for (int i = 0; i < spiel.getSpielbrett().getFelder().length; i++) {

				for (int j = 0; j < belegung[i].length; j++) {
					str = "" + ch1 + x;
					x++;

					belegung[i][j] = new Spielfeld(spiel.getSpielbrett(), str,
							schwarz);
					spiel.figurSetzen();
					br.write(belegung[i][j].toString() + "\n");

					schwarz = !schwarz;

					if (x > 12) {
						x = 1;
						ch1++;
						if (ch1 == ch) {
							str = "" + ch + x;
							schwarz = !schwarz;

							break;

						}
						schwarz = !schwarz;

					}

				}

			}

			br.write("SpielerAmzug ist :" + spiel.getSpielerAmZug().getName()
					+ ";" + spiel.getSpielerAmZug().getFarbe() + "\n");

		} catch (IOException e1) {

		} finally {
			try {
				br.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	@Override
	public Object laden(String filename) {
		
		try {
            java.io.BufferedReader FileReader=                      //ein Reader um die Datei Zeilenweise auszulesen
                    new java.io.BufferedReader(
                        new java.io.FileReader(
                            new java.io.File(filename)
                        )
                    );
		 String zeile="";
         
         while(null!=(zeile=FileReader.readLine())){         //lesen jeder Zeile  
             String[] split=zeile.split(";");                //hier wird die Zeile zerlegt als Trennzeichen ;
             System.out.print(split[0]);                     //erste Zeit über index 0
             System.out.print(" --> ");
            
                 
            
             
             System.out.println(split[1]);                   //zweite Zeit über index 1
           
         }
        
     } catch (Exception e) {
         e.printStackTrace();
     }
     return filename;

	}

	

}