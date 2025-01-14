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
	    ERDeaktivieren();
	    Spieler[] neuteam = new Spieler[1]; 
	    neuteam[0] = mitglieder[0];
	    mitglieder = neuteam; 
	    er.Elemententfernen();
	    
	    
	}
	public void ERDeaktivieren() {
		if (er.wasser && er.luft) {
            for (int i = 0; i < mitglieder.length; i++) {
                if (mitglieder[i] != null && mitglieder[i].Leben()) {
                    int heil = mitglieder[i].maxges * 20 / 100;
                    mitglieder[i].ges -= heil;
                }
            }
        }
		if(er.feuer && er.luft) {
			for (int i = 0; i < mitglieder.length; i++) {
                if (mitglieder[i] != null && mitglieder[i].Leben()) {
                    int starker = mitglieder[i].ang * 20 / 100;
                    mitglieder[i].ang -= starker;
                }
            }
		}
		if(er.erde && er.luft) {
			for (int i = 0; i < mitglieder.length; i++) {
                if (mitglieder[i] != null && mitglieder[i].Leben()) {
                    int schild = mitglieder[i].ver * 20 / 100;
                    mitglieder[i].ver -= schild;
                }
            }
		}
		if (er.feuer && er.wasser) {
            for (int i = 0; i < mitglieder.length; i++) {
                if (mitglieder[i] != null && mitglieder[i].Leben()) {
                    int heil = mitglieder[i].maxges * 10 / 100;
                    mitglieder[i].ges -= heil;
                    int starker = mitglieder[i].ang * 20 / 100;
                    mitglieder[i].ang -= starker;
                }
            }
        }
		if (er.wasser && er.erde) {
            for (int i = 0; i < mitglieder.length; i++) {
                if (mitglieder[i] != null && mitglieder[i].Leben()) {
                    int heil = mitglieder[i].maxges * 10 / 100;
                    mitglieder[i].ges -= heil;
                    int schild = mitglieder[i].ver * 10 / 100;
                    mitglieder[i].ver -= schild;
                }
            }
        }
		if (er.feuer && er.erde) {
            for (int i = 0; i < mitglieder.length; i++) {
                if (mitglieder[i] != null && mitglieder[i].Leben()) {
                	int starker = mitglieder[i].ang * 20 / 100;
                	mitglieder[i].ang -= starker;
                    int schild = mitglieder[i].ver * 10 / 100;
                    mitglieder[i].ver -= schild;
                }
            }
        }
	}
	
	public Spieler getMC(){
		return mitglieder[0];
	}
	
	public void ERAktivieren() {
		if (er.wasser && er.luft) {
			System.out.println("Sprießen (+20% GES) ist aktiviert für alle Mitglieder!");
            for (int i = 0; i < mitglieder.length; i++) {
                if (mitglieder[i] != null && mitglieder[i].Leben()) {
                    int heil = mitglieder[i].maxges * 20 / 100;
                    mitglieder[i].ges += heil;
                }
            }
        }
		if(er.feuer && er.luft) {
			System.out.println("Brennen (+20% ANG) ist aktiviert für alle Mitglieder!");
			for (int i = 0; i < mitglieder.length; i++) {
                if (mitglieder[i] != null && mitglieder[i].Leben()) {
                    int starker = mitglieder[i].ang * 20 / 100;
                    mitglieder[i].ang += starker;
                }
            }
		}
		if(er.erde && er.luft) {
			System.out.println("Beben (+20% VER) ist aktiviert für alle Mitglieder!");
			for (int i = 0; i < mitglieder.length; i++) {
                if (mitglieder[i] != null && mitglieder[i].Leben()) {
                    int schild = mitglieder[i].ver * 20 / 100;
                    mitglieder[i].ver += schild;
                }
            }
		}
		if (er.feuer && er.wasser) {
			System.out.println("Verdampfen (+10% GES, +10% ANG) ist aktiviert für alle Mitglieder!");
            for (int i = 0; i < mitglieder.length; i++) {
                if (mitglieder[i] != null && mitglieder[i].Leben()) {
                    int heil = mitglieder[i].maxges * 10 / 100;
                    mitglieder[i].ges += heil;
                    int starker = mitglieder[i].ang * 20 / 100;
                    mitglieder[i].ang += starker;
                }
            }
        }
		if (er.wasser && er.erde) {
			System.out.println("Tropfen (+10% GES, +10% VER) ist aktiviert für alle Mitglieder!");
            for (int i = 0; i < mitglieder.length; i++) {
                if (mitglieder[i] != null && mitglieder[i].Leben()) {
                    int heil = mitglieder[i].maxges * 10 / 100;
                    mitglieder[i].ges += heil;
                    int schild = mitglieder[i].ver * 10 / 100;
                    mitglieder[i].ver += schild;
                }
            }
        }
		if (er.feuer && er.erde) {
			System.out.println("Überladen (+10% ANG, +10% VER) ist aktiviert für alle Mitglieder!");
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
