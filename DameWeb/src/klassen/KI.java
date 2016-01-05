package klassen;


import java.io.Serializable;
import java.util.ArrayList;

public abstract class KI implements Serializable {
	private static final long serialVersionUID = 1L;

	protected SpielBean spiel;
	private Spieler spieler;
	protected boolean kannLaufen = false;
	protected boolean kannSchlagen = false;
	protected ArrayList<String> datenLaufen = new ArrayList<String>();
	protected ArrayList<String> datenSchlagen = new ArrayList<String>();
	protected ArrayList<Spielfigur> uberprufteFigur=new ArrayList<Spielfigur>();
	protected ArrayList<String> ziel=new ArrayList<String>();
	private ArrayList<Spielfigur> neuFullWeiss=new ArrayList<Spielfigur>();
	private ArrayList<Spielfigur> neuFullSchwarz=new ArrayList<Spielfigur>();
	private boolean binDrinKi=false;
	private ArrayList<Spielfeld> zielFeldDame=new ArrayList<Spielfeld>();
	private ArrayList<Spielfeld> startFeldDame=new ArrayList<Spielfeld>();
	private ArrayList<Spielfigur> alleDamen=new ArrayList<Spielfigur>();

	/**
	 * der Konstruktor der Klasse mit der Komposition zu Spieler
	 * 
	 * @param spieler
	 */
	


	public KI(SpielBean spiel) {
//		if(spieler==null){
//			throw new RuntimeException("KI kann nicht ohne Spieler existieren !");
//		}
		this.setSpiel(spiel);
		this.setKannSchlagen(kannSchlagen);
		this.setKannLaufen(kannLaufen);
		
	}
	

	public ArrayList<String> getZiel() {
		return ziel;
	}

	public SpielBean getSpiel() {
		return spiel;
	}

	public void setSpiel(SpielBean spiel) {
		this.spiel = spiel;
	}

	public boolean getKannLaufen() {
		return kannLaufen;
	}

	public void setKannLaufen(boolean kannLaufen) {
		this.kannLaufen = kannLaufen;
	}

	public boolean getKannSchlagen() {
		return kannSchlagen;
	}

	public void setKannSchlagen(boolean kannSchlagen) {
		this.kannSchlagen = kannSchlagen;
	}

	public void setSpieler(Spieler spieler) {
		this.spieler = spieler;
	}

	public Spieler getSpieler() {
		return this.spieler;
	}
	
	public void putArrayKI(){
		
		for (Spielfigur each : spiel.getFigurWeiss2()){
			neuFullWeiss.add(each);
		}
		for (Spielfigur each : spiel.getFigurSchwarz2()){
			neuFullSchwarz.add(each);
		}
	}
	public void putArrayKIWeiss(){
		
		for (Spielfigur each : spiel.getFigurWeiss2()){
			neuFullWeiss.add(each);	
		}
	}
	public void putArrayKISchawrz(){
		for (Spielfigur each : spiel.getFigurSchwarz2()){
			neuFullSchwarz.add(each);
		}
	}
	
	public Spielfeld randomSpielfeld(){
		int i=(int)(11 * Math.random()) +0;
		int j=(int)(11 * Math.random()) +0;
		Spielfeld f=spiel.getSpielbrett().getFelder()[i][j];
		if(f.getFarbeFeld().equals(FarbEnum.SCHWARZ)){
			zielFeldDame.add(f);
		}
		
		return f;
	}
	
	public boolean istDiagonal(Spielfeld akt,Spielfeld ziel){
		spiel.getSpielbrett().getPositionen().clear();
		boolean istDiagonal=false;
		Spielfeld nachbar=null;
		Spielfeld nachbar2=null;
        spiel.getSpielbrett().Umwandler(akt.getId());
        spiel.getSpielbrett().Umwandler(ziel.getId());
        
        //ObenRechts
        if ((spiel.getSpielbrett().getPositionen().get(0) < spiel.getSpielbrett().getPositionen().get(2)) 
                && (spiel.getSpielbrett().getPositionen().get(1) < spiel.getSpielbrett().getPositionen().get(3))) {
        		nachbar2=akt;
        	 while (nachbar2.getId() !=ziel.getId()) {
        		//wenn das Zielfeld nicht auf der Diagonalen liegt
                 if(spiel.pruefeOben(nachbar2)||spiel.pruefeID2(nachbar2)){
            		 istDiagonal=false;
            		 break;
            	 }else{
            		 nachbar = spiel.getNachbarDame(nachbar2.getId(), true, true);
                     nachbar2=nachbar;
            	 }
                 
                 istDiagonal=true;   
        }
        	 
        	 
        	  //ObenLinks
        }else  if ((spiel.getSpielbrett().getPositionen().get(0) < spiel.getSpielbrett().getPositionen().get(2)) 
                && (spiel.getSpielbrett().getPositionen().get(1) > spiel.getSpielbrett().getPositionen().get(3))) {
        		nachbar2=akt;
        	while (nachbar2.getId() !=ziel.getId()) {
        		//wenn das Zielfeld nicht auf der Diagonalen liegt
                if(spiel.pruefeOben(nachbar2)||spiel.pruefeID1(nachbar2)){
           		 	istDiagonal=false;
           		 	break;
           	 	}else{
           	 		nachbar = spiel.getNachbarDame(nachbar2.getId(), false, true);
           	 		nachbar2=nachbar;
           	 	}
                
                istDiagonal=true;    
       }
       	 
        	
        	//UnternRechts
        }else  if ((spiel.getSpielbrett().getPositionen().get(0) > spiel.getSpielbrett().getPositionen().get(2)) 
                && (spiel.getSpielbrett().getPositionen().get(1) < spiel.getSpielbrett().getPositionen().get(3))) {
        		nachbar2=akt;
        	while (nachbar2.getId() !=ziel.getId()) {
        		//wenn das Zielfeld nicht auf der Diagonalen liegt
                if(spiel.pruefeUnten(nachbar2)||spiel.pruefeID2(nachbar2)){
           		 	istDiagonal=false;
           		 	break;
           	 	}else{
           	 		nachbar = spiel.getNachbarDame(nachbar2.getId(), true, false);
           	 		nachbar2=nachbar;
           	 	}
                
                istDiagonal=true;    
       }
       	 
        	
       	 //UntenLinks
        }else if ((spiel.getSpielbrett().getPositionen().get(0) > spiel.getSpielbrett().getPositionen().get(2)) 
                && (spiel.getSpielbrett().getPositionen().get(1) > spiel.getSpielbrett().getPositionen().get(3))) {
        		nachbar2=akt;
        	while (nachbar2.getId() !=ziel.getId()) {
        		 //wenn das Zielfeld nicht auf der Diagonalen liegt
                if(spiel.pruefeUnten(nachbar2)||spiel.pruefeID1(nachbar2)){
                	istDiagonal=false;
                	break;
           	 	}else{
           	 		nachbar = spiel.getNachbarDame(nachbar2.getId(), false, false);
           	 		nachbar2=nachbar;
           	 	}
                
                istDiagonal=true;  
       }
       	 
        	
        }
		return istDiagonal;
	}

	

	public Spielfigur randomFigur() {
		Spielfigur f=null;
//		if(binDrinKi==false){
//			putArrayKI();
//		}

		if(spiel.getSpielerAmZug().getFarbe().equals(FarbEnum.WEISS)){
				int n=(int)(neuFullWeiss.size() * Math.random()) +1;
				if(neuFullWeiss.get(n-1)!=null){
					f=neuFullWeiss.get(n-1);
					neuFullWeiss.remove(n-1);
					binDrinKi=true;
				}
				

		}else if(spiel.getSpielerAmZug().getFarbe().equals(FarbEnum.SCHWARZ)){
				int n=(int)(neuFullSchwarz.size() * Math.random()) +1;
				if(neuFullSchwarz.get(n-1)!=null){
					f=neuFullSchwarz.get(n-1);
					neuFullSchwarz.remove(n-1);
					binDrinKi=true;
				}	
		}

		return f;
	}
	
	
	


	//------------------------------LAUFEN--------------------------
	
	public boolean kannLaufen() {
		FarbEnum farbe = spiel.getSpielerAmZug().getFarbe();
		
		 if(binDrinKi==false){
				putArrayKI();
			}
		 if(neuFullWeiss.size()==0){
	        	putArrayKIWeiss();
	        	return false;
	     }
	     if(neuFullSchwarz.size()==0){
	        	putArrayKISchawrz();
	        	return false;
	     
	     }
	     
		Spielfigur figur=randomFigur();
		
		//im Falle wenn die figur eine Dame ist
		startFeldDame.clear();
		zielFeldDame.clear();
		startFeldDame.add(figur.getFeld());
		if(figur.getDame()==true){
			
			while(this.randomSpielfeld().getFarbeFeld().equals(FarbEnum.WEISS)){
			}
			while(this.istDiagonal(figur.getFeld(),zielFeldDame.get(0))==false){
				zielFeldDame.clear();
				while(this.randomSpielfeld().getFarbeFeld().equals(FarbEnum.WEISS)){
				}
			}
			datenLaufen.add(startFeldDame.get(0).getId());
			datenLaufen.add(zielFeldDame.get(0).getId());
			startFeldDame.clear();
			zielFeldDame.clear();
			kannLaufen=true;
			return true;
		}
		
		//im Falle wenn es keine Dame ist und die Figur noch im Spiel ist
		 if(spiel.istFigurDrin(figur.getId())==true){
			switch (farbe) {
			case WEISS:
				if (kannLaufenLinksWeiss(figur.getFeld())
						|| kannLaufenRechtsWeiss(figur.getFeld())) {
					kannLaufen=true;
					return true;
					}
				break;
				
			case SCHWARZ:
				if (kannLaufenLinksSchwarz(figur.getFeld())
						|| kannLaufenRechtsSchwarz(figur.getFeld())) {
//					System.out.println("schwarz "+datenLaufen);
					kannLaufen=true;
					return true;
				}
				break;
			}
//			System.out.println("im laufen drin"+datenLaufen);
		}
		return false;
	}

	private boolean kannLaufenRechtsSchwarz(Spielfeld feld) {
		kannLaufen = false;
		if (feld.getFarbeFeld().equals(FarbEnum.SCHWARZ)) {
			if (feld.getFigur() != null) {
				if (spiel.pruefeOben(feld)) {
					return kannLaufen = false;
				}if(spiel.pruefeID2(feld)){ 
					return kannLaufen = false;
				}else if (feld.getFigur().getFarbe().equals(FarbEnum.SCHWARZ)) {
					Spielfeld feld2 = spiel.getNachbar(feld.getId(), true);
					if ((feld2.getFigur() != null)) {
							kannLaufen = false;
						}
					if (feld2.getFigur() == null) {
						kannLaufen = true;
						datenLaufen.add(feld.getId());
						datenLaufen.add(feld2.getId());

						}
					}
				}
			}
		return kannLaufen;
		}

	private boolean kannLaufenLinksSchwarz(Spielfeld feld) {
		kannLaufen = false;
		if (feld.getFarbeFeld().equals(FarbEnum.SCHWARZ)) {
			if (feld.getFigur() != null) {
				if (spiel.pruefeOben(feld)) {
					return kannLaufen = false;
				}if(spiel.pruefeID1(feld)){ 
					return kannLaufen = false;
				}else if (feld.getFigur().getFarbe().equals(FarbEnum.SCHWARZ)) {
					Spielfeld feld2 = spiel.getNachbar(feld.getId(), false);
					if ((feld2.getFigur() != null)) {
							kannLaufen = false;
						}
					if (feld2.getFigur() == null) {
						kannLaufen = true;
						datenLaufen.add(feld.getId());
						datenLaufen.add(feld2.getId());

						}
					}
				}
			}
		return kannLaufen;
		}

	private boolean kannLaufenRechtsWeiss(Spielfeld feld) {
		kannLaufen = false;
		if (feld.getFarbeFeld().equals(FarbEnum.SCHWARZ)) {
			if (feld.getFigur() != null) {
				if (spiel.pruefeUnten(feld)) {
					return kannLaufen = false;
				}if(spiel.pruefeID1(feld)){ 
					return kannLaufen = false;
				}else if (feld.getFigur().getFarbe().equals(FarbEnum.WEISS)) {
					Spielfeld feld2 = spiel.getNachbar(feld.getId(), true);
					if ((feld2.getFigur() != null)) {
							kannLaufen = false;
						}
					if (feld2.getFigur() == null) {
						kannLaufen = true;
						datenLaufen.add(feld.getId());
						datenLaufen.add(feld2.getId());

						}
					}
				}
			}
		return kannLaufen;
		}

	private boolean kannLaufenLinksWeiss(Spielfeld feld) {
		kannLaufen = false;
		if (feld.getFarbeFeld().equals(FarbEnum.SCHWARZ)) {
			if (feld.getFigur() != null) {
				if (spiel.pruefeUnten(feld)) {
					return kannLaufen = false;
				}if(spiel.pruefeID2(feld)){ 
					return kannLaufen = false;
				
				}else if (feld.getFigur().getFarbe().equals(FarbEnum.WEISS)) {
					Spielfeld feld2 = spiel.getNachbar(feld.getId(), false);
					if ((feld2.getFigur() != null)) {
							kannLaufen = false;
						}
					if (feld2.getFigur() == null) {
						kannLaufen = true;
						datenLaufen.add(feld.getId());
						datenLaufen.add(feld2.getId());

						}
					}
				}
			}
		return kannLaufen;
		}
	
	
	//alles damen die im Spiel vorhanden sind werden in die ArrayList "alleDamen" gespeichert 
	public void setzeDamen(){
		for(int i=0;i<spiel.getSpielbrett().getFelder().length;i++){
			for(int j=0;j<spiel.getSpielbrett().getFelder()[i].length;j++){
				if(spiel.getSpielbrett().getFelder()[i][j].getFigur()!=null){
					if(spiel.getSpielbrett().getFelder()[i][j].getFigur().getFarbe().equals(spiel.getSpielerAmZug().getFarbe())){
						if(spiel.getSpielbrett().getFelder()[i][j].getFigur().getDame()==true){
							alleDamen.add(spiel.getSpielbrett().getFelder()[i][j].getFigur());
						}
					}
				}
			}
		}
	}
	
	private boolean kannDameSchlagen(Spielfigur f) {
		boolean kannSchlagen=false;
		if((kannDameSchlagenOR(f))||(kannDameSchlagenOL(f))||(kannDameSchlagenUR(f))||(kannDameSchlagenUL(f))){
			kannSchlagen=true;
		}
		return kannSchlagen;
	}
	
	
	private boolean kannDameSchlagenOR(Spielfigur f) {
		spiel.getDatenSchlagen().clear();
		boolean kannSchlagen=false;
		String feldId=f.getFeld().getId();
		Spielfeld aktPos=f.getFeld();
		Spielfeld nachbar=null;
		Spielfeld nachbar2=null;
		
		if(spiel.pruefeID2(aktPos)||spiel.pruefeOben(aktPos)){
			kannSchlagen=false;
			return kannSchlagen;
		}
		nachbar=spiel.getNachbarDame(feldId,true,true);
		if(spiel.pruefeID2(nachbar)||spiel.pruefeOben(nachbar)){
			kannSchlagen=false;
			return kannSchlagen;
		}
		while(spiel.pruefeID2(nachbar)==false && spiel.pruefeOben(nachbar)==false){
			nachbar2=spiel.getNachbarDame(nachbar.getId(),true,true);
			if(nachbar.getFigur()!=null && nachbar.getFigur().getFarbe().equals(spiel.getSpielerAmZug().getFarbe())){
				kannSchlagen=false;
				return kannSchlagen;
			}else if(nachbar.getFigur()!=null && nachbar2.getFigur()==null){
				datenSchlagen.add(aktPos.getId());
				datenSchlagen.add(nachbar.getId());
				datenSchlagen.add(nachbar2.getId());
//				spiel.getGegnerDame().add(nachbar);
//				spiel.removeFigurAusArray(nachbar.getFigur());
				kannSchlagen=true;
				return kannSchlagen;
			}else if(nachbar.getFigur()!=null && nachbar2.getFigur()!=null){
				kannSchlagen=false;
				return kannSchlagen;
			}
			nachbar=nachbar2;
		}
		return kannSchlagen;
	}
	
	
	private boolean kannDameSchlagenOL(Spielfigur f) {
		spiel.getDatenSchlagen().clear();
		boolean kannSchlagen=false;
		String feldId=f.getFeld().getId();
		Spielfeld aktPos=f.getFeld();
		Spielfeld nachbar=null;
		Spielfeld nachbar2=null;
		
		if(spiel.pruefeID1(aktPos)||spiel.pruefeOben(aktPos)){
			kannSchlagen=false;
			return kannSchlagen;
		}
		nachbar=spiel.getNachbarDame(feldId,false,true);
		if(spiel.pruefeID1(nachbar)||spiel.pruefeOben(nachbar)){
			kannSchlagen=false;
			return kannSchlagen;
		}
		while(spiel.pruefeID1(nachbar)==false && spiel.pruefeOben(nachbar)==false){
			nachbar2=spiel.getNachbarDame(nachbar.getId(),false,true);
			if(nachbar.getFigur()!=null && nachbar.getFigur().getFarbe().equals(spiel.getSpielerAmZug().getFarbe())){
				kannSchlagen=false;
				return kannSchlagen;
			}else if(nachbar.getFigur()!=null && nachbar2.getFigur()==null){
				datenSchlagen.add(aktPos.getId());
				datenSchlagen.add(nachbar.getId());
				datenSchlagen.add(nachbar2.getId());
//				spiel.getGegnerDame().add(nachbar);
//				spiel.removeFigurAusArray(nachbar.getFigur());
				kannSchlagen=true;
				return kannSchlagen;
			}else if(nachbar.getFigur()!=null && nachbar2.getFigur()!=null){
				kannSchlagen=false;
				return kannSchlagen;
			}
			nachbar=nachbar2;
		}
		return kannSchlagen;
	}
	
	
	private boolean kannDameSchlagenUR(Spielfigur f) {
		spiel.getDatenSchlagen().clear();
		boolean kannSchlagen=false;
		String feldId=f.getFeld().getId();
		Spielfeld aktPos=f.getFeld();
		Spielfeld nachbar=null;
		Spielfeld nachbar2=null;
		
		if(spiel.pruefeID2(aktPos)||spiel.pruefeUnten(aktPos)){
			kannSchlagen=false;
			return kannSchlagen;
		}
		nachbar=spiel.getNachbarDame(feldId,true,false);
		if(spiel.pruefeID2(nachbar)||spiel.pruefeUnten(nachbar)){
			kannSchlagen=false;
			return kannSchlagen;
		}
		while(spiel.pruefeID2(nachbar)==false && spiel.pruefeUnten(nachbar)==false){
			nachbar2=spiel.getNachbarDame(nachbar.getId(),true,false);
			if(nachbar.getFigur()!=null && nachbar.getFigur().getFarbe().equals(spiel.getSpielerAmZug().getFarbe())){
				kannSchlagen=false;
				return kannSchlagen;
			}else if(nachbar.getFigur()!=null && nachbar2.getFigur()==null){
				datenSchlagen.add(aktPos.getId());
				datenSchlagen.add(nachbar.getId());
				datenSchlagen.add(nachbar2.getId());
//				spiel.getGegnerDame().add(nachbar);
//				spiel.removeFigurAusArray(nachbar.getFigur());
				kannSchlagen=true;
				return kannSchlagen;
			}else if(nachbar.getFigur()!=null && nachbar2.getFigur()!=null){
				kannSchlagen=false;
				return kannSchlagen;
			}
			nachbar=nachbar2;
		}
		return kannSchlagen;
		}
	
	
	private boolean kannDameSchlagenUL(Spielfigur f) {
		spiel.getDatenSchlagen().clear();
		boolean kannSchlagen=false;
		String feldId=f.getFeld().getId();
		Spielfeld aktPos=f.getFeld();
		Spielfeld nachbar=null;
		Spielfeld nachbar2=null;
		
		if(spiel.pruefeID1(aktPos)||spiel.pruefeUnten(aktPos)){
			kannSchlagen=false;
			return kannSchlagen;
		}
		nachbar=spiel.getNachbarDame(feldId,false,false);
		if(spiel.pruefeID1(nachbar)||spiel.pruefeUnten(nachbar)){
			kannSchlagen=false;
			return kannSchlagen;
		}
		while(spiel.pruefeID1(nachbar)==false && spiel.pruefeUnten(nachbar)==false){
			nachbar2=spiel.getNachbarDame(nachbar.getId(),false,false);
			if(nachbar.getFigur()!=null && nachbar.getFigur().getFarbe().equals(spiel.getSpielerAmZug().getFarbe())){
				kannSchlagen=false;
				return kannSchlagen;
			}else if(nachbar.getFigur()!=null && nachbar2.getFigur()==null){
				datenSchlagen.add(aktPos.getId());
				datenSchlagen.add(nachbar.getId());
				datenSchlagen.add(nachbar2.getId());
//				spiel.getGegnerDame().add(nachbar);
//				spiel.removeFigurAusArray(nachbar.getFigur());
				kannSchlagen=true;
				return kannSchlagen;
			}else if(nachbar.getFigur()!=null && nachbar2.getFigur()!=null){
				kannSchlagen=false;
				return kannSchlagen;
			}
			nachbar=nachbar2;
		}
		return kannSchlagen;
	}

	
	//------------------------------SCHLAGEN------------------------
	

	public boolean kannSchlagen() {
        FarbEnum farbe = spiel.getSpielerAmZug().getFarbe();
        if(binDrinKi==false){
			putArrayKI();
		}
        if(neuFullWeiss.size()==0){
        	putArrayKIWeiss();
        	return false;
        }
        if(neuFullSchwarz.size()==0){
        	putArrayKISchawrz();
        	return false;
        }
        
//      prüfen ob eine Dame schlagen kann
        alleDamen.clear();
        spiel.getGegnerDame().clear();
		setzeDamen();
		if(alleDamen.isEmpty()==false){
			for(Spielfigur f:alleDamen){
				if(kannDameSchlagen(f)==true){
					kannSchlagen=true;
					return true;
				}
			}
		}
        
        Spielfigur figur=randomFigur();

        if(spiel.istFigurDrin(figur.getId())==true){
        	if(uberprufteFigur.size()>=1){
            	
           	 if(uberprufteFigur.contains(figur)){
//           		 System.out.println("FIGUR---"+figur.getId());
           		 for(int i=0;i<uberprufteFigur.size();i++){
    					if(figur==uberprufteFigur.get(i)){
    						uberprufteFigur.remove(uberprufteFigur.get(i));
    					}
    				}
                }
           	 uberprufteFigur.add(figur);
           }else{
           	 uberprufteFigur.add(figur);
           }
        	
        	
          
           switch (farbe) {
           case WEISS:
           	if (kannSchlagenLinksWeiss(figur.getFeld())
           			|| kannSchlagenRechtsWeiss(figur.getFeld())){
           		kannSchlagen=true;
           		return true;
           	}
           	break;
           case SCHWARZ:
           	if (kannSchlagenLinksSchwarz(figur.getFeld())
           			|| kannSchlagenRechtsSchwarz(figur.getFeld())){
           		kannSchlagen=true;
           		return true;
           	}
           	break;
           }
        }
        return false;
    }
	
	


	public boolean kannSchlagenRechtsSchwarz(Spielfeld feld) {
		
        kannSchlagen = false;
        if (feld.getFarbeFeld().equals(FarbEnum.SCHWARZ)) {
            if (feld.getFigur() != null) {
            
            if (spiel.pruefeID2(feld)) {
                return kannSchlagen = false;
            } else if(spiel.pruefeOben(feld)){
              	 return kannSchlagen = false;
            } else if (feld.getFigur().getFarbe().equals(FarbEnum.SCHWARZ)) {
                Spielfeld feld2 = spiel.getNachbar(feld.getId(), true);
                
                if(spiel.pruefeID2(feld2)){
                    kannSchlagen=false;
                }else{
                	if(spiel.pruefeOben(feld2)){
                		kannSchlagen=false;
                	}else
                
                if ((feld2.getFigur() != null)
                        && (feld2.getFigur().getFarbe().equals(FarbEnum.WEISS))) {
                    Spielfeld feld3 = spiel.getNachbar(feld2.getId(), true);
                    
                    if (feld3.getFigur() == null) {
                        kannSchlagen = true;
                        datenSchlagen.add(feld.getId());
                        datenSchlagen.add(feld2.getId());
                        datenSchlagen.add(feld3.getId());
                    } else {
                        kannSchlagen = false;
                    }
                } else {
                    kannSchlagen = false;
                }
            }
        }}}
        return kannSchlagen;

    }

    public boolean kannSchlagenLinksSchwarz(Spielfeld feld) {

        kannSchlagen = false;
        if (feld.getFarbeFeld().equals(FarbEnum.SCHWARZ)) {
            if (feld.getFigur() != null) {
            
            if (spiel.pruefeID1(feld)) {
                return kannSchlagen = false;
            } else if(spiel.pruefeOben(feld)){
              	 return kannSchlagen = false;
            } else if (feld.getFigur().getFarbe().equals(FarbEnum.SCHWARZ)) {
            
                Spielfeld feld2 = spiel.getNachbar(feld.getId(), false);
                
                if(spiel.pruefeID1(feld2)){
                    kannSchlagen=false;
                }else{
                	if(spiel.pruefeOben(feld2)){
                		kannSchlagen=false;
                	}else
                
                if ((feld2.getFigur() != null)
                        && (feld2.getFigur().getFarbe().equals(FarbEnum.WEISS))) {
                    Spielfeld feld3 = spiel.getNachbar(feld2.getId(), false);
                    if (feld3.getFigur() == null) {
                        kannSchlagen = true;
                        datenSchlagen.add(feld.getId());
                        datenSchlagen.add(feld2.getId());
                        datenSchlagen.add(feld3.getId());
                    } else {
                        kannSchlagen = false;
                    }
                } else {
                    kannSchlagen = false;
                }
            }
        }}}
        return kannSchlagen;

    }

    public boolean kannSchlagenRechtsWeiss(Spielfeld feld) {

        
        kannSchlagen = false;
        if (feld.getFarbeFeld().equals(FarbEnum.SCHWARZ)) {
            if (feld.getFigur() != null) {
            
            if (spiel.pruefeID1(feld)) {
                return kannSchlagen = false;
            } else if(spiel.pruefeUnten(feld)){
              	 return kannSchlagen = false;
            } else if (feld.getFigur().getFarbe().equals(FarbEnum.WEISS)) {
                Spielfeld feld2 = spiel.getNachbar(feld.getId(), true);
                
                if(spiel.pruefeID1(feld2)){
                    kannSchlagen=false;
                }else{
                	if(spiel.pruefeUnten(feld2)){
                		kannSchlagen=false;
                	}else
                
                if ((feld2.getFigur() != null)
                        && (feld2.getFigur().getFarbe().equals(FarbEnum.SCHWARZ))) {
                    Spielfeld feld3 = spiel.getNachbar(feld2.getId(), true);
                    if (feld3.getFigur() == null) {
                        kannSchlagen = true;
                        datenSchlagen.add(feld.getId());
                        datenSchlagen.add(feld2.getId());
                        datenSchlagen.add(feld3.getId());
                    } else {
                        kannSchlagen = false;
                    }
                } else {
                    kannSchlagen = false;
                }
            }
        }}}
        return kannSchlagen;

    }

    public boolean kannSchlagenLinksWeiss(Spielfeld feld) {

        kannSchlagen = false;

        if (feld.getFarbeFeld().equals(FarbEnum.SCHWARZ)) {
            if (feld.getFigur() != null) {
                
            if (spiel.pruefeID2(feld)) {
                return kannSchlagen = false;
            } else if(spiel.pruefeUnten(feld)){
              	 return kannSchlagen = false;
            } else if (feld.getFigur().getFarbe().equals(FarbEnum.WEISS)) {
                Spielfeld feld2 = spiel.getNachbar(feld.getId(), false);
                
                if(spiel.pruefeID2(feld2)){
                    kannSchlagen=false;
                }else{
                	if(spiel.pruefeUnten(feld2)){
                		kannSchlagen=false;
                	}else
                
                if ((feld2.getFigur() != null)
                        && (feld2.getFigur().getFarbe()
                                .equals(FarbEnum.SCHWARZ))) {
                    Spielfeld feld3 = spiel.getNachbar(feld2.getId(), false);
                    if (feld3.getFigur() == null) {
                        kannSchlagen = true;
                        datenSchlagen.add(feld.getId());
                        datenSchlagen.add(feld2.getId());
                        datenSchlagen.add(feld3.getId());
                    } else {
                        kannSchlagen = false;
                    }
                } else {
                    kannSchlagen = false;
                }
            }
        }}}
        return kannSchlagen;

    }


	
//	public abstract String gebeStart();
//	public abstract String gebeZiel();
	public abstract ArrayList<String> startZiel();



}
