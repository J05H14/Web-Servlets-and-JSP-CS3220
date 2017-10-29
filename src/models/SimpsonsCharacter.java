package models;

import java.util.Random;

public class SimpsonsCharacter {
	String name;
	int images;
	int id;

	public SimpsonsCharacter(String name, int images) {
		this.name = name;
		this.images = images;
	}

	public String getThumbnail() {
		String nameURL = this.name.replaceAll(" ", "_").toLowerCase();

		if(images == 0) {
			return "http://via.placeholder.com/150?text=N/A";
		}
		else {
			return "http://albertcervantes.com/cs3220/cdn/simpsons/" + nameURL + "/pic_0000.jpg";
		}
	}

	public String getRandomImage() {
		if(this.images != 0) {
			Random rand = new Random();
			String nameURL = this.name.replaceAll(" ", "_").toLowerCase();
			int image = rand.nextInt(this.images);
			String imageURL = String.format("%04d", image);

			return "http://albertcervantes.com/cs3220/cdn/simpsons/" + nameURL + "/pic_" + imageURL + ".jpg";
		}
		else {
			return "http://google.com";
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getImages() {
		return images;
	}

	public void setImages(int images) {
		this.images = images;
	}
}
