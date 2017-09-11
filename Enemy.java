
import mayflower.*;

public class Enemy extends AnimatedActor{
	
	public  Boolean canSee;
	public  Boolean playerToLeft;
	public  Boolean playerToRight;
	private Boolean movingToLeft;
	private Timer   movementTimer;
	private Scanner s;


	
	//Sets conditions for when player is visible
	public void playerVisible(){
		canSee = true;
	}
	
	
	//Sets condition for when player isn't visible
	public void playerNotVisible(){
		canSee = false;
		playerToLeft = false;
		playerToRight = false;
	}
	
	
	//Finds the scanner that is touching the enemy
	private Scanner getMyScanner(){
		Scanner s = null;
		Actor[] touching = getTouching();
		for(Actor a : touching){
			if(a instanceof Scanner){
				s = (Scanner)a;
			}
		}
		return s;
	}
		
		
    public Enemy() {
    		
    		
 		//Create and Set Enemy Image
    	Picture p = new Picture("img/Enemy.png");
    	p.resize(30, 30);
    	setPicture(p);
    	
    	
    	//Sets Starting Conditions
    	movingToLeft  = false;
    	canSee = false;
    	movementTimer = new Timer();
    
    
    }
    
    public void update(){
    	super.update();
    	
   		//Creates and moves scanner with enemy
   		s = getMyScanner();
    	if(s != null){
    		s.setPosition(getX(),getY());		
    		//If player isn't within range, move on set-path
    		if(!s.canSee){	
    			if(movementTimer.hasTimePassed(1000)){
    				if(movingToLeft){
    					movingToLeft = false;
    				}
    				else{
    					movingToLeft = true;
    				}
    				movementTimer.reset();
    			}
    			if(movingToLeft){
    				move(1,"West");
    				if(isBlocked()){
    					move(1,"East");
    				}
    			}
    			else{
    				move(1,"East");
    				if(isBlocked()){
    					move(1,"West");
    				}
    			}	
    		}
    		//If player is in range, move towards player
    		else if(s.canSee){
    			if(s.playerToLeft){
    				move(1, "West");
    				if(isBlocked()){
    					move(1,"East");
    				}
    			}	
    			else{
    				move(1, "East");
    				if(isBlocked()){
    					move(1,"West");
    				}
    			}
    		}
    	}
    }
}