package game;

import java.util.Scanner;

public class Spiel {
    Mitglieder steam;  
    Feinde fteam;      
    Spieler spieler;     
    Scanner scanner = new Scanner(System.in); 
    String spielerName; 
    Chef chef;

    public Spiel() {
        steam = new Mitglieder();
    }

    public void Anfang() {
        System.out.println("Bitte geben Sie Ihren Namen ein:");
        spielerName = scanner.nextLine();
        System.out.println("Herzlich willkommen, " + spielerName);
        spieler = new Spieler(spielerName);
        
        System.out.println("Drücken Sie „Enter/Eingabetaste“, um unsere Reise zu beginnen.");

        //kapitel 0
        String[] kapitel0Text = Gesprach.kapitel0();
        for (int i = 0; i < kapitel0Text.length; i++) {
            String kapitel0 = kapitel0Text[i].replace("[SpielerName]", spielerName);
            System.out.println(kapitel0);
            scanner.nextLine(); 
        }
        
        //Element wählen
        HinzufugenSpieler();
        steam.Mitgliederhinzufugen(spieler);
        
        // entwicklen
        String[] dia3Text = Gesprach.dia3();
        for (int i = 0; i < dia3Text.length; i++) {
            String dia3 = dia3Text[i].replace("[SpielerName]", spielerName);
            System.out.println(dia3);
            scanner.nextLine(); 
        }
        MCEntwickeln(spieler);
        // Kapitel 1
        String[] dia4Text = Gesprach.dia4();
        for (int i = 0; i < dia4Text.length; i++) {
            String dia4 = dia4Text[i].replace("[SpielerName]", spielerName);
            System.out.println(dia4);
            scanner.nextLine(); 
        }
        
        Kampf1Kapitel1();
        
        Spieler spielerduke = new Spieler("Duke");
        spielerduke.setElement("Feuer");
        steam.Mitgliederhinzufugen(spielerduke);
        
        String[] dia5Text = Gesprach.dia5();
        for (int i = 0; i < dia5Text.length; i++) {
            String dia5 = dia5Text[i].replace("[SpielerName]", spielerName);
            System.out.println(dia5);
            scanner.nextLine(); 
        }
        
        Kampf1Kapitel2();
        
        String[] dia6Text = Gesprach.dia6();
        for (int i = 0; i < dia6Text.length; i++) {
            String dia6 = dia6Text[i].replace("[SpielerName]", spielerName);
            System.out.println(dia6);
            scanner.nextLine(); 
           }
            
        // Kapitel 3
        
        // Partner wählen
        Spieler spielercharlotte = new Spieler("Charlotte");
        spielercharlotte.setElement("Wasser");
        steam.Mitgliederhinzufugen(spielercharlotte);
        
        System.out.println("Treffen Sie Ihre Entscheidung:");
        System.out.println("1. Duke (Feuer)");
        System.out.println("2. Charlotte (Wasser)");
        
        steam.Mitgliederentfernen();
        int swahl = scanner.nextInt();
        while(true) {
        	 if(swahl==1) {
            	steam.Mitgliederhinzufugen(spielerduke);
            	System.out.println("Die Aufstellung hat sich nicht geändert");
            	break;
            } 
        	 if(swahl==2) {
             	steam.Mitgliederhinzufugen(spielercharlotte);
             	System.out.println("Duke ist aus dem Team, Charlotte ist Ihrem Team beigetreten");
             	break;
             } else {
            	 System.out.print("Ungültige Auswahl. Bitte geben Sie nur 1 oder 2 ein.");
            }
        }
        
        // Kapitel 4
        String[] dia7Text = Gesprach.dia7();
        for (int i = 0; i < dia7Text.length; i++) {
            String dia7 = dia7Text[i].replace("[SpielerName]", spielerName);
            System.out.println(dia7);
            scanner.nextLine(); 
           }
        
        Kampfende();
        
        String[] dialetztText = Gesprach.dialetzt();
        for (int i = 0; i < dialetztText.length; i++) {
            String dialetzt = dialetztText[i].replace("[SpielerName]", spielerName);
            System.out.println(dialetzt);
            scanner.nextLine(); 
           }
        
    }


	public void HinzufugenSpieler() {
	System.out.println("Bitte wählen Sie es sorgfältig aus!\n1. Wasser\n2.Erde\n3.Feuer\n4.Luft");
       int wahl = scanner.nextInt();
        scanner.nextLine();
        if (wahl == 1) {
            spieler.setElement("Wasser");
            System.out.println("Dein Element ist Wasser.");
        } else if (wahl == 2) {
            spieler.setElement("Erde");
            System.out.println("Dein Element ist Erde.");
        } else if (wahl == 3) {
            spieler.setElement("Feuer");
            System.out.println("Dein Element ist Feuer.");
        } else if (wahl == 4) {
            spieler.setElement("Luft");
            System.out.println("Dein Element ist Luft.");
        } else {
            System.out.println("Ungültige Wahl. Standardmäßig wird Ihr Element Wasser gesetzt.");
            spieler.setElement("Wasser");
        }
    }
	public void MCEntwickeln(Spieler spieler) {
		System.out.println("Ihre Statistik: Angriff: " + spieler.ang + " - Gesundheit: " +  spieler.ges + " - Verteidigung: " + spieler.ver);
        System.out.println("Sie haben die Chance, sich zu verbessern, indem Sie Ihre Statistik um 50 erhöhen.");
        int mal = 2;
        while (mal > 0) {
            System.out.println("Wählen Sie den Wert aus, den Sie erhöhen möchten");
            System.out.println("1. Angriff + 50");
            System.out.println("2. Gesundheit + 50");
            System.out.println("3. Verteidigung + 50");
            int wahl = scanner.nextInt();
            if (wahl == 1) {
                System.out.println("Angriff + 50!");
                spieler.ang += 50;
            } else if (wahl == 2) {
                System.out.println("Gesundheit + 50!");
                spieler.ges += 50;
            } else if (wahl == 3) {
                System.out.println("Verteidigung + 50!");
                spieler.ver += 50;
            } else {
                System.out.println("Ungültige Auswahl. Sie haben Ihre Chance verpasst, Ihre Fähigkeiten zu verbessern.");
            }
            System.out.println("Ihre Statistik: Gesundheit: " +  spieler.ges + " - Angriff: " + spieler.ang + " - Verteidigung: " + spieler.ver);
            mal--;
        }
	}
	public void Kampf1Kapitel1() {
    Feind[] feinde = { 
        new Feind("Wolf 1", 100, 500, 0, "Feuer"), 
        new Feind("Wolf 2", 100, 500, 0, "Feuer") 
    };
    fteam = new Feinde(feinde.length);
    fteam.Feindhinzufugen(feinde);
    Kampf kampf1 = new Kampf(steam, fteam);
    kampf1.Anfang();
}
	public void Kampf1Kapitel2() {
		Feind[] feinde = { new Feind("Hexe 1", 100, 1000, 0, "Feuer"), new Feind("Hexe 2", 100, 1000, 0, "Erde"), new Feind("Hexe 3", 100, 1000, 0, "Wasser") };
        fteam = new Feinde(feinde.length);
        fteam.Feindhinzufugen(feinde);
        Kampf kampf2 = new Kampf(steam, fteam);
        kampf2.Anfang();
	}
	public void Kampfende() {
		Chef chef = new Chef();
		Kampf kampf3 = new Kampf(steam, fteam);
        kampf3.KampfEnde(chef);
	}
}