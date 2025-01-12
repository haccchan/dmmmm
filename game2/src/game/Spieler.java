package game;

import java.util.Scanner;

public class Spieler {
	String sname; // die Spielername
	int maxges; // die maximale Spielergesundheit
	int ang; // der Spielerangriff
	int ver; // die Spielerverteidigung
	int ges; // die aktuelliesierte Spielergesundheit
	String element; // der Spielerelement
	int vermal; // die Anzahl der Runden, in denen der Verteidigungsschild aktiviert wird
	Scanner sc = new Scanner(System.in);
	
	public Spieler(String sname) {
		this.ang = 500; 
		this.ver = 50;
		this.maxges = 500;
		this.ges = maxges;
		this.vermal =0;
		this.sname = sname;
		
	}
	
	
	public void setElement(String element) {
		this.element = element;
	}
	public String getElement() {
        return element;
    }
	 public String getName() {
	        return this.sname;
	    }


	    public int getGesundheit() {
	        return this.ges;
	    }

	    public int getAngriff() {
	        return this.ang;
	    }

	    public int getVerteidigung() {
	        return this.ver;
	    }

	    public int getMaxGesundheit() {
	        return this.ges;
	    }

	public void SpielerMal(Feind[] feinde,Spieler[] mitglieder) { // die Aktionen, die der Spieler macht in seinem Mal
		System.out.println(sname + " (" + this.ang + " - " + this.ges + " - " + this.ver + ") ist dran!\nWählen Sie Ihre Aktion:");
		System.out.println("1. Angreifen"); 
		if(this.element.equals("Wasser")) {
			System.out.println("2. Heilen"); 
		} else if(this.element.equals("Erde")) {
			System.out.println("2. einen Schild für alle Mitglieder schaffen (noch " + vermal + " Runde(n), nicht stapelbar)"); 
			// Alle Mitglieder werden ihre Verteidigungswerte in 3 Runden um 20% erhöht.
			// Wenn es noch 1 oder 2 Runde(n), in der/denen der Schild aktiv ist, gibt, 
			// kann der Spieler diese Fähigkeit wieder aktivieren.
			// Aber es stellt einen neunen Schild (=20% Veiteidigungswert), der in weiteren 3 (statt 1 oder 2) Runden aktiv ist, 
			// statt 2 Schilden (= 2*20% = 40% Veiteidigungswert).
			
		}
		
		int Wahl = sc.nextInt();
		if(Wahl==1) {
			if(this.element.equals("Luft")) {  // die Fähigkeit des Luftelements
				FahLuft(feinde); 
			} else { //normaler Angriff
				SingleAngreifen(feinde); 
			}
		} else if(Wahl==2) {
			if(this.element.equals("Wasser")) { // die Fähigkeit des Wasserelements
				Heilen(mitglieder); 
			} else if(this.element.equals("Erde")) { // die Fähigkeit des Erdeelements
				Schilden(mitglieder);
			}	
		} else {
			System.out.println("Ungültige Aktion. Sie haben Ihren Versuch verloren."); 
		}
		if(vermal>0) { // Countdown der Schilddauer
			vermal--;
		} 
	}	
	public boolean Leben() { //überprüfen, ob der Spieler noch lebt oder nicht, um seine Aktion zu machen
		if(ges>0) {
			return true;
		} 
		return false;
	}
	
	public void FahLuft(Feind[] feinde) { // Für der Besitzer des Luftelements werden alle Feinde angegriffen,
		for(int i=0; i<feinde.length; i++) { 
			if(feinde[i]!=null && feinde[i].Leben()==true) { 
				Angreifen(feinde[i]);
			}
		}
	}
	
	public void SingleAngreifen(Feind[] feinde) { // während greift der Spieler einzeln für die andere an.
		System.out.println("Wählen Sie den Gegner aus, den Sie angreifen möchten: ");
		for(int i=0; i<feinde.length; i++) {
			System.out.println(i+1 + ". " + feinde[i].fname);
		}
		int target = sc.nextInt()-1;
		if(feinde[target].Leben()==true) {
			Angreifen(feinde[target]);
		} else {
			System.out.println("Ungültige Aktion. Sie haben Ihren Versuch verloren."); 
		}
		
	}
	public void Heilen(Spieler[] mitglieder) { // Alle Mitglieder werden ihre Gesundheitswerte um 20% erhöht.
		for(int i=0;i<mitglieder.length;i++) {
			if(mitglieder[i]!=null && mitglieder[i].Leben()==true) {
				int healAmount = (int)(mitglieder[i].maxges * 0.2); 
				mitglieder[i].ges += healAmount;
				if(mitglieder[i].ges >= mitglieder[i].maxges) {
					mitglieder[i].ges= mitglieder[i].maxges;
				}
				
			}
		}
		System.out.println("Alle Mitglieder werden geheilt.");
	}
	public void Schilden(Spieler[] mitglieder) { // Die Schilddauer setzen
		vermal = 3;
	}
	public void Angreifen(Feind feind) { // Der Angriff des Spielers
		int sangf = this.ang; // der Schaden des Feinds setzen
		if(this.element.equals("Feuer")) { // die Fähigkeit des Feuerelements
			double krit = Math.random();
			double kritratio = 0.4;
			if(krit<=kritratio) {
				sangf *= 2;
				System.out.println(sname + " erfolgreich angreift einen kritischen Schaden!");
			}
			
		}
		if(this.element.equals("Luft")) { // die Fähigkeit des Luftelements
			sangf = sangf*3/4;
		}
		feind.Angegriffen(sangf);
		System.out.println(sname + " schafft einen Schaden mit dem Wert " + sangf + ".");
	}
	public void SangC(Chef chef,Spieler[] mitglieder) { 
		System.out.println(sname + " (" + this.ang + " - " + this.ges + " - " + this.ver + ") ist dran! Wählen Sie Ihre Aktion:");
		System.out.println("1. Angreifen"); 
		if(this.element.equals("Wasser")) {
			System.out.println("2. Heilen"); 
		} else if(this.element.equals("Erde")) {
			System.out.println("2. einen Schild für alle Mitglieder schaffen (noch " + vermal + " Runde(n), nicht stapelbar)"); 
		}
		
		int Wahl = sc.nextInt();
		if(Wahl==1) {
			int sangc = this.ang; 
			if(this.element.equals("Feuer")) { 
				double krit = Math.random();
				double kritratio = 0.4;
				if(krit<=kritratio) {
					sangc *= 2;
				}
				System.out.println(sname + " erfolgreich angreift einen kritischen Schaden!");
			}
			if(this.element.equals("Luft")) { 
				sangc = sangc*3/4;
			}
			chef.Angegriffen(sangc);
			System.out.println(sname + " schafft einen Schaden mit dem Wert " + sangc );
			}
		 else if(Wahl==2) {
			if(this.element.equals("Wasser")) { 
				Heilen(mitglieder); 
			} else if(this.element.equals("Erde")) {
				Schilden(mitglieder);
			}	
		} else {
			System.out.println("Ungültige Aktion. Sie haben Ihren Versuch verloren."); 
		}
		if(vermal>0) { 
			vermal--;
		} 
	}
	public void Angegriffen(int fang) {
		int aktver = this.ver;
		if(vermal>0) { // die Fähigkeit des Erdeelements
			aktver += 200;
		}
		int fangs = (int)(fang * 100 / (aktver + 100));
		this.ges -= fangs;
		if(this.ges<=0) {
			this.ges=0;
		}
	}
}
