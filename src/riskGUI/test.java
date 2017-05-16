package riskGUI;

public class test {
	public static void main (String[] args){
		String mapFile = "maps/Classic.txt";
		String mapImg = "imgs/Classic.jpg";
		String rules = "";
		String numPlayer = "5";
		RiskGUI myGUI = new RiskGUI();
		myGUI.spawnGame(mapFile, mapImg, numPlayer);
		
		
		///the following demonstrates how to change
		//the color or the number of armies for a country
		String orange = "PCorange";
		myGUI.countries.get(3).changeButtonColor(orange);
		myGUI.countries.get(3).incrementArmies();
		String red = "PCred";
		myGUI.countries.get(2).changeButtonColor(red);
		myGUI.countries.get(2).decrementArmies();
		String blue = "PCblue";
		myGUI.countries.get(0).changeButtonColor(blue);
		myGUI.countries.get(0).incrementArmies();
		String green = "PCgreen";
		myGUI.countries.get(1).changeButtonColor(green);
		myGUI.countries.get(1).decrementArmies();
		
		myGUI.countries.get(4).setArmies(99);
		
		
		
		//these function calls are for testing
		//myGUI.pick();
		//myGUI.placingArmies(5);
		//myGUI.pickAttacker();
		//myGUI.pickDefender();
		//myGUI.confirmAnnihilate("America","Russia");
		//myGUI.move("America","Russia");
		//myGUI.setFortSrc();
		//myGUI.setFortDest();
		//myGUI.notTurn();
		
		for (int i = 6; i>=1; i--)
		{
			myGUI.showRoll("Western United States","Eastern United States",i,i,i,i,i);
		}
		myGUI.showCards(100,1,2,3,4,5,6,7,8,9);
	}
}
