package models;

import java.util.ArrayList;
import java.util.Random;

public class SimpsonsCharacterBean {
	ArrayList<SimpsonsCharacter> characters;
	
	public SimpsonsCharacterBean() {
		characters = new ArrayList<SimpsonsCharacter>();
	}
	
	public void setAddCharacter() {
		
	}
	
	public String getLastThumbnail() {
		String nameURL = this.characters.get(characters.size() - 1).getName().replaceAll(" ", "_").toLowerCase();
		
		if(characters.get(characters.size() - 1).getImages() == 0) {
			return "http://via.placeholder.com/150?text=N/A";
		}
		else {
			return "http://albertcervantes.com/cs3220/cdn/simpsons/" + nameURL + "/pic_0000.jpg";
		}
	}
	
	public String getRandomImage() {
		Random rand = new Random();
		String nameURL = this.characters.get(characters.size() - 1).getName().replaceAll(" ", "_").toLowerCase();
		int image = rand.nextInt(characters.get(characters.size() - 1).getImages());
		String imageURL = String.format("%04d", image);
		
		return "http://albertcervantes.com/cs3220/cdn/simpsons/" + nameURL + "/pic_" + imageURL + ".jpg";

	}
	
}
