package riskGUI;

//import java.awt.Color;
//import java.awt.image.BufferedImage;
//import java.io.File;

//import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Country {

	//name,cont,but,id,armies,own
	private String name;
	private int continent;
	private JButton button;
	private int id;
	private int armies = 0;
	private String owner = "";
	
	public Country(String n, int c, JButton b, int ID){
		name = n;
		continent = c;
		button = b;
		id = ID;
	}
	
	public void setName(String inName){name = inName; }
	public void setOwner(String inOwner){owner = inOwner;}
	public void setContinent(int inContinent){continent = inContinent;}
	public void setButton(JButton inButton){button = inButton;}
	public void setID(int inID){id = inID;}
	public void setArmies(int inArmies){armies = inArmies;}
	
	public void incrementArmies(){
		this.armies = this.armies++;
		String buttonText = this.button.getText();
		int buttonTextInt = Integer.parseInt(buttonText);
		buttonTextInt = buttonTextInt + 1;
		String incrementedText = Integer.toString(buttonTextInt);
		this.button.setText(incrementedText);
	}
	public void decrementArmies(){
		this.armies = this.armies--;
		String buttonText = this.button.getText();
		int buttonTextInt = Integer.parseInt(buttonText);
		buttonTextInt = buttonTextInt - 1;
		String incrementedText = Integer.toString(buttonTextInt);
		this.button.setText(incrementedText);
		
	}
	
	public void changeButtonColor(String newColor){
		if(true){//this may be used to identify which buttons color is to change????
			ImageIcon image = new ImageIcon("imgs/"+newColor+".jpg");
			this.button.setIcon(image);
		}
	}
	
	public String getName(){return this.name;}
	public String getOwner(){return this.owner;}
	public int getContinent(){return this.continent;}
	public JButton getButton(){return this.button;}
	public int getID(){return this.id;}
	public int getArmies(){return this.armies;}

}
