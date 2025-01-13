package game;

public class Elementarreaktion {
	String[] team;
	boolean wasser = false; 
	boolean erde = false;
	boolean luft = false;
	boolean feuer = false;
	
	
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
	        Elementprufen();
	 }
	public void Elemententfernen() {
	    if (team.length == 3) { 
	        String[] neuteam = new String[1]; 
	        neuteam[0] = team[0];
	        team = neuteam;
	        Elementprufen();
	    }
	}
	public void Elementprufen() {
		wasser = false; 
		erde = false;
		luft = false;
		feuer = false;
		
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
	}

}
