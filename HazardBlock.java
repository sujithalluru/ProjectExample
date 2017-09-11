
import mayflower.*;

public class HazardBlock extends Block{
	public HazardBlock(){
		
		//Creates and Sets HazardBlock Image
		Picture p = new Picture("img/5.png");
		p.resize(w,l);
		setPicture(p);
	}
	
	public void update(){
	}
}