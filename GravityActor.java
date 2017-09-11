
import mayflower.*;
public class GravityActor extends Actor{
	
	public Boolean isFalling;
	private Boolean landed;
	public Boolean currentlyFalling;
	public Boolean currentlyHurt = false;
	
	//Checks if actor is touching anything
	public boolean isBlocked(){
		Boolean ret = false;
		Actor[] touching = getTouching();
   		for(Actor a : touching){
    		if(a instanceof Block){
    				ret = true;
    				//Before adjusting position, checks if player should be damaged
    				if(a instanceof HazardBlock){
						currentlyHurt = true;
    				}
    				
    		}
		}
		return ret;
	}
	

	//Allows outside classes to control falling
	public void enableFalling(){
		isFalling = true;
	}
	public void disableFalling(){
		isFalling = false;
	}
	

    public GravityActor(){
    	
    		//Sets Initial Conditions
    		landed = isBlocked();
    		isFalling = true;
    		currentlyFalling = true;
    		
    }
    
    public void update(){
 		//Makes player fall, when not touching ground and falling is enabled
		if(!landed  && isFalling){
			move(1, "South");
			currentlyFalling = true;
			landed = isBlocked();
   						
			//Fixes player moving into ground
			if(landed && isFalling){
    			move(1, "North");
    			currentlyFalling = false;
    			landed = isBlocked();
    		}
    	}
 	}  	
}
