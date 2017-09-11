
import mayflower.*;

public class AirBlock extends Actor{
	
	//Dimensions for every Airblock
	public int w = 60;
	public int l = 60;
	
    public AirBlock() {
    	
    	//Create and Set AirBlock Image
    	Picture p = new Picture("img/0.png");
    	p.resize(w, l);
    	setPicture(p);
    }
    
    public void update(){
    	//What an AirBlock Does...
    		//Nothing
    }
    
}