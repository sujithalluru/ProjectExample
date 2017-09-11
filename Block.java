
import mayflower.*;

public class Block extends Actor{

	//Dimensions for every Block
	public int w = 60;
	public int l = 60;
	
    public Block() {
    	
    	//Create and Set Block Image
    	Picture p = new Picture("img/1.png");
    	p.resize(w,l);
    	setPicture(p);
    }
    
    public void update(){
    	
    	//Enable jump if player is touching ground
    	Actor[] touching = getTouching();
    	for(Actor a : touching){
    		if(a instanceof Player){
    			Player p = (Player)a;
    			p.enableJump();
    		}
    	}
    }
    
}