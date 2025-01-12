package game;

public class Elementarreaktion {
	String[] team;
	boolean wasser = false; 
	boolean erde = false;
	boolean luft = false;
	boolean feuer = false;
	
	boolean sprießen = false;
	boolean verdampfen = false;
	boolean beben = false;
	boolean brennen = false;
	boolean tropfen = false;
	boolean uberladen = false;
	
	public Elementarreaktion() {
		team = new String[0];
	}
	public void Elementhinzufugen(String element) {
	        String[] neuteam = new String[team.length + 1];
	        for (int i = 0; i < team.length; i++) {
	            neuteam[i] = team[i];
	        }
	        neuteam[team.length] = element;
	        team = neuteam;
	 }
	public void Elemententfernen() {
	    if (team.length == 3) { 
	        String[] neuteam = new String[1]; 
	        neuteam[0] = team[0];
	        team = neuteam; 
	    }
	}
	public void Elementprufen() {
		for (int i = 0; i < team.length; i++) {
            String element = team[i];
            if (element.equals("Wasser")) {
                wasser = true;
            } else if (element.equals("Erde")) {
                erde = true;
            } else if (element.equals("Feuer")) {
                feuer = true;
            } else if (element.equals("Luft")) {
                luft = true;
            }
        }
		boolean sprießen = wasser && luft;
		boolean beben = luft && erde;
		boolean brennen = luft && feuer;
		boolean verdampfen = wasser && feuer;
		boolean tropfen = wasser && erde;
		boolean uberladen = feuer && erde;
	}

}
