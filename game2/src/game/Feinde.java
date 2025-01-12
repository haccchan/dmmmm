package game;

public class Feinde {
	int fanzahl;
	Feind[] feinde;
	Elementarreaktion er;
	
	public Feinde(int fanzahl){
		this.fanzahl=fanzahl;
		feinde = new Feind[fanzahl];
		er = new Elementarreaktion();
	}
	public void Feindhinzufugen(Feind[] feinde) {
		this.feinde = feinde;
		for(int i=0; i<feinde.length; i++) {
			er.Elementhinzufugen(feinde[i].element);
		}
		ERAktivieren();
	}
	
	public void ERAktivieren() {
		if (er.sprießen) {
			System.out.println("Sprießen (+20% GES) ist aktiviert für alle Feinde!");
            for (int i = 0; i < feinde.length; i++) {
                if (feinde[i] != null && feinde[i].Leben()) {
                    int heil = feinde[i].maxges * 20 / 100;
                    feinde[i].ges += heil;
                }
            }
        }
		if(er.brennen) {
			System.out.println("Brennen (+20% ANG) ist aktiviert für alle Feinde!");
			for (int i = 0; i < feinde.length; i++) {
                if (feinde[i] != null && feinde[i].Leben()) {
                    int starker = feinde[i].ang * 20 / 100;
                    feinde[i].ang += starker;
                }
            }
		}
		if(er.beben) {
			System.out.println("Beben (+20% VER) ist aktiviert für alle Feinde!");
			for (int i = 0; i < feinde.length; i++) {
                if (feinde[i] != null && feinde[i].Leben()) {
                    int schild = feinde[i].ver * 20 / 100;
                    feinde[i].ver += schild;
                }
            }
		}
		if (er.verdampfen) {
			System.out.println("Verdampfen (+10% GES, +10% ANG) ist aktiviert für alle Feinde!");
            for (int i = 0; i < feinde.length; i++) {
                if (feinde[i] != null && feinde[i].Leben()) {
                    int heil = feinde[i].maxges * 10 / 100;
                    feinde[i].ges += heil;
                    int starker = feinde[i].ang * 10 / 100;
                    feinde[i].ang += starker;
                }
            }
        }
		if (er.tropfen) {
			System.out.println("Tropfen (+10% GES, +10% VER) ist aktiviert für alle Feinde!");
            for (int i = 0; i < feinde.length; i++) {
                if (feinde[i] != null && feinde[i].Leben()) {
                    int heil = feinde[i].maxges * 10 / 100;
                    feinde[i].ges += heil;
                    int schild = feinde[i].ver * 10 / 100;
                    feinde[i].ver += schild;
                }
            }
        }
		if (er.uberladen) {
			System.out.println("Überladen (+10% ANG, +10% VER) ist aktiviert für alle Feinde!");
            for (int i = 0; i < feinde.length; i++) {
                if (feinde[i] != null && feinde[i].Leben()) {
                	int starker = feinde[i].ang * 20 / 100;
                    feinde[i].ang += starker;
                    int schild = feinde[i].ver * 10 / 100;
                    feinde[i].ver += schild;
                }
            }
        }
	}

}
