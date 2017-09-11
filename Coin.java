
import mayflower.*;
public class Coin extends Actor{

    public Coin() {
    	
    	//Create and Set Coin Image
    	Picture p = new Picture("img/coin.png");
    	p.resize(60, 60);
    	setPicture(p);
    
    	
    }
    public void update(){
    	
    	//Give player points and disppear when touched
    	Actor[] touching = getTouching();
    	for(Actor a : touching){
    		if(a instanceof Player){
    			Player p = (Player)a;
    			p.addPoint(1);
    			Stage s = getStage();
    			s.removeActor(this);
    		}
    	}
    }
    
    
}