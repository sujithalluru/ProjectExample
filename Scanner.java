
import mayflower.*;
public class Scanner extends Enemy{
	
    public Scanner(int w, int h) {
    	//Creates and Sets Scanner Image	
    	Picture p = new Picture("img/1.png");
    	p.resize(w,h);
    	setPicture(p);
    	//Makes Scanner Invisible
    	p.setTransparency(100);
    }
    public void update(){
    	super.update();
    	//Checks to see if player is in range
    	Actor[] touching = getTouching();
    	for(Actor a : touching){
    		if(a instanceof Player){
    			playerVisible();
    			Player p = (Player)a;
    			//Tells enemy that player is to the right
    			if(getX()+30 < p.getX()+30){
    				playerToRight = true;
    			}
    			//Tells enemy that player is to the left
    			else if(getX()+30 > p.getX()+30){
    				playerToLeft = true;
    			}
    		}
    		//Tells enemy that player is out of range
    		else{
    			playerToRight = false;
    			playerToLeft = false;
    			canSee = false;
    		}
    	}	
    	
    }
}