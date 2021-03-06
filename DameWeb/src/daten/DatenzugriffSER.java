package daten;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;

public class DatenzugriffSER implements iDatenzugriff, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static ByteArrayOutputStream baos=new ByteArrayOutputStream();


	@Override
	public void speichern(String s,Object sp){
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		
		String sav = s;
		sav.concat(".ser");
		try{
			ObjectOutputStream oos1= new ObjectOutputStream(new FileOutputStream(sav+".ser"));
			oos1.writeObject(sp);
			oos1.close();
			System.out.println("SPIEL WURDE GESPEICHERT !");
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		System.out.flush();
		System.setOut(old);
	}

	@Override
	public Object laden(String filename) {
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		Object obj = null;
		try {
		  fis = new FileInputStream(filename);
		  ois = new ObjectInputStream(fis);
		  obj = ois.readObject();
		}
		catch (IOException e) {
		  e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
		  e.printStackTrace();
		}
		finally {
		  if (ois != null) try { ois.close(); } catch (IOException e) {}
		  if (fis != null) try { fis.close(); } catch (IOException e) {}
		}
		
		return obj;
	}
	
}
