package riskGUI;

import java.util.ArrayList;

public class Player {
	private int playerID;
	private ArrayList<Card> cards = new ArrayList<Card>();
	private ArrayList<Country> countries = new ArrayList<Country>();
	private int armiesLeft = 0;
	private boolean isPlaying;
	
	public Player(int ID){playerID = ID;}
	
	public int GetID(){return playerID;}
	public ArrayList<Card> GetCards(){return cards;}
	public ArrayList<Country> GetCountrues(){return countries;}
	public int GetRemArmies(){return armiesLeft;}
	public boolean isPlaying(){return isPlaying;}
	
	public void addCountry(Country c){countries.add(c.getID(),c);}
	public void takeCountry(Country c){countries.remove(c.getID());}
	public boolean doesOwn(Country c){return true;}
	
	public void setRemArmies(int a){armiesLeft = a;}
	public void decRemArmies(){armiesLeft--;}
	public void setIsPlaying(boolean i){isPlaying = i;}
}
