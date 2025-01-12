package game;

import java.util.Scanner;

public class Feind {
    String fname;
    int maxges;
    int ang;
    int ver;
    int ges;
    String element;
    int vermal;
    Scanner sc = new Scanner(System.in);

    public Feind(String fname, int ang, int ver, int ges, String element) {
        this.fname = fname;
        this.ang = ang;
        this.ver = ver;
        this.ges = ges;
        this.maxges = ges;
        this.element = element;
    }

    public void setElement(String element) {
        this.element = element;
    }
    public String getElement() {
        return element;
    }

    public int getGesundheit() {
        return this.ges;
    }

    public int getAngriff() {
        return this.ang;
    }

    public void FeindMal(Spieler[] mitglieder, Feind[] feinde) {
        int Wahl = (int) (Math.random() * 2);
        if (Wahl == 0) {
            if (element.equals("Luft")) {
                FahLuft(mitglieder);
            } else {
                SingleAngreifen(mitglieder);
            }
        } else if (Wahl == 1) {
            if (element.equals("Wasser")) {
                Heilen(feinde);
            } else if (element.equals("Erde")) {
                Schilden(feinde);
            }
        }
        if (vermal > 0) {
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

    public void Heilen(Feind[] feinde) {
        for (int i = 0; i < feinde.length; i++) {
            if (feinde[i] != null && feinde[i].Leben()) {
                int healAmount = (int)(feinde[i].maxges * 0.2); 
                feinde[i].ges += healAmount;
                if (feinde[i].ges > feinde[i].maxges) {
                    feinde[i].ges = feinde[i].maxges;
                }
                System.out.println(feinde[i].fname + " wird geheilt um " + healAmount + " Gesundheit.");
            }
        }
    }

    public void Schilden(Feind[] feinde) {
        vermal = 3;
    }

    public void Angreifen(Spieler spieler) {
        int fangs = this.ang;
        if (element.equals("Feuer")) {
            double kritratio = Math.random();
            if (kritratio <= 0.4) {
                fangs *= 2;
                System.out.println(fname + " greift mit einem kritischen Treffer an!");
            }
        }
        if (element.equals("Luft")) {
            fangs = fangs * 3 / 4;
        }
        spieler.Angegriffen(fangs);
        System.out.println(fname + " verursacht " + fangs + " Schaden.");
    }

    public void Angegriffen(int sang) {
        int aktver = this.ver;
        if (vermal > 0) {
            aktver += 200;
        }
        int fangs = (int)(sang * 100 / (aktver + 100));
        this.ges -= fangs;
        if (this.ges <= 0) {
            this.ges = 0;
        }
    }
    
    public String getName() {
        return fname;
    }
}
