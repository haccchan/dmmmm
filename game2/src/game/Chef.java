package game;

import java.util.Scanner;

public class Chef {
    String cname;
    int maxges; // Maximale Gesundheit
    int ang;    // Angriffswert
    int ver;    // Verteidigungswert
    int ges;    // Gesundheit
    String[] element; // Elemente des Chefs
    int vermal; 
    Scanner sc = new Scanner(System.in);

    public Chef() {
        this.cname = "Oberhexe";
        this.ang = 200;
        this.ver = 100;
        this.ges = 1500;
        this.maxges = ges;
        this.element = new String[] {"Erde", "Luft"};
        int schild = this.ver * 20 / 100;
        this.ver += schild;
    }
   
    public void ChefMal(Spieler[] mitglieder) {
        int Wahl = (int) (Math.random() * 3);
        if (Wahl == 0) {
            FahLuft(mitglieder);
            } 
        else if (Wahl == 1) {
            Schilden();
            } else {
                SingleAngreifen(mitglieder);
            }
      
        if (vermal > 0) {
        	System.out.println("Die Oberhexe aktiviert ihren Schild"); 
            vermal--;
        }
    }
    public boolean Leben() {
        return ges > 0;
    }
    public void FahLuft(Spieler[] mitglieder) { 
		for(int i=0; i<mitglieder.length; i++) { 
			if(mitglieder[i]!=null && mitglieder[i].Leben()==true) { 
				Angreifen(mitglieder[i]);
			}
		}
	}
    public void SingleAngreifen(Spieler[] mitglieder) {
        int target = (int) (Math.random() * mitglieder.length);
        if (mitglieder[target].Leben()) {
            Angreifen(mitglieder[target]);
        } else {
            for (int i = target + mitglieder.length; i >= 0; i--) {
                if (mitglieder[i % mitglieder.length] != null && mitglieder[i % mitglieder.length].Leben()) {
                    Angreifen(mitglieder[i % mitglieder.length]);
                    break;
                }
            }
        }
    }
    public void Schilden() {
        vermal = 3;
    }
    public void Angreifen(Spieler spieler) {
        int cangs = this.ang;
        spieler.Angegriffen(cangs);
        System.out.println(cname + " verursacht " + cangs + " " + spieler.getName() + " Schaden.");
    }
    public void Angegriffen(int sang) {
        int aktver = this.ver;
        if (vermal > 0) {
            aktver += 200;
        }
        int cangs = (int)(sang * 100 / (aktver + 100));
        this.ges -= cangs;
        if (this.ges <= 0) {
            this.ges = 0;
        }
    }
	
	
}