package game;

public class Mitglieder {
	int sanzahl;
	Spieler[] mitglieder;
	Elementarreaktion er;
	public Mitglieder() {
		mitglieder = new Spieler[0];
        er = new Elementarreaktion();
    
	}
	public void Mitgliederhinzufugen(Spieler spieler) {
		Spieler[] neuteam = new Spieler[mitglieder.length + 1];
        for (int i = 0; i < mitglieder.length; i++) {
            neuteam[i] = mitglieder[i];
        }
        neuteam[mitglieder.length] = spieler;
        mitglieder = neuteam;
        er.Elementhinzufugen(spieler.element);
        ERAktivieren();
    }
	public void Mitgliederentfernen() {
	    if (mitglieder.length == 3) { 
	        Spieler[] neuteam = new Spieler[1]; 
	        neuteam[0] = mitglieder[0];
	        mitglieder = neuteam; 
	    }
	}
	public Spieler getMC(){
		return mitglieder[0];
	}
	
	public void ERAktivieren() {
		if (er.sprießen) {
            for (int i = 0; i < mitglieder.length; i++) {
                if (mitglieder[i] != null && mitglieder[i].Leben()) {
                    int heil = mitglieder[i].maxges * 20 / 100;
                    mitglieder[i].ges += heil;
                }
            }
        }
		if(er.brennen) {
			for (int i = 0; i < mitglieder.length; i++) {
                if (mitglieder[i] != null && mitglieder[i].Leben()) {
                    int starker = mitglieder[i].ang * 20 / 100;
                    mitglieder[i].ang += starker;
                }
            }
		}
		if(er.beben) {
			for (int i = 0; i < mitglieder.length; i++) {
                if (mitglieder[i] != null && mitglieder[i].Leben()) {
                    int schild = mitglieder[i].ver * 20 / 100;
                    mitglieder[i].ver += schild;
                }
            }
		}
		if (er.verdampfen) {
            for (int i = 0; i < mitglieder.length; i++) {
                if (mitglieder[i] != null && mitglieder[i].Leben()) {
                    int heil = mitglieder[i].maxges * 10 / 100;
                    mitglieder[i].ges += heil;
                    int starker = mitglieder[i].ang * 20 / 100;
                    mitglieder[i].ang += starker;
                }
            }
        }
		if (er.tropfen) {
            for (int i = 0; i < mitglieder.length; i++) {
                if (mitglieder[i] != null && mitglieder[i].Leben()) {
                    int heil = mitglieder[i].maxges * 10 / 100;
                    mitglieder[i].ges += heil;
                    int schild = mitglieder[i].ver * 10 / 100;
                    mitglieder[i].ver += schild;
                }
            }
        }
		if (er.uberladen) {
            for (int i = 0; i < mitglieder.length; i++) {
                if (mitglieder[i] != null && mitglieder[i].Leben()) {
                	int starker = mitglieder[i].ang * 20 / 100;
                	mitglieder[i].ang += starker;
                    int schild = mitglieder[i].ver * 10 / 100;
                    mitglieder[i].ver += schild;
                }
            }
        }
	}

}
