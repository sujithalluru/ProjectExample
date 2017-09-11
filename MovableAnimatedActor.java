
import mayflower.*;
public class MovableAnimatedActor extends AnimatedActor{

	//Animations for Player
	private Animation walkRight;
	private Animation walkLeft;
	private Animation rightFalling;
	private Animation leftFalling;
	private Animation straightFall;
	private Animation jumpAnimation;
	private Animation climbUp;
	private Animation climbDown;
	private Animation hurtAnimation;
	private Animation idle;
			
			
	//Animation Conditions
	private Boolean isUpEnabled = false;
	private Boolean isDownEnabled = false;
	private Boolean isJumpEnabled = true;

	
	private Timer jumpTimer;
	private String currentAction;

	

	//Enables Up or Down Movement Conditions
	public void enableUp(){
		isUpEnabled = true;
	}
	public void enableDown(){
		isDownEnabled = true;
	}
	
	//Disables Up or Down Movement Conditions
	public void disableUp(){
		isUpEnabled = false;
	}
	public void disableDown(){
		isDownEnabled = false;
	}
	
	//(Dis)Allows Jump
	public void enableJump(){
		isJumpEnabled = true;
	}
	public void disableJump(){
		isJumpEnabled = false;
	}
	
	//Begins Jump Timer
    public MovableAnimatedActor() {	
    	jumpTimer = new Timer();
    }


	//Sets animations created in player class
	public void setWalkLeftAnimation(Animation ani){
		walkLeft = ani;
	}
	public void setJumpAnimation(Animation ani){
		jumpAnimation = ani;
	}
	public void setHurtAnimation(Animation ani){
		hurtAnimation = ani;
	}
	public void setStraightFallingAnimation(Animation ani){
		straightFall = ani;
	}
	public void setWalkRightAnimation(Animation ani){
		walkRight = ani;
	}
	public void setRightFallingAnimation(Animation ani){
		rightFalling = ani;
	}
	public void setLeftFallingAnimation(Animation ani){
		leftFalling = ani;
	}
	public void setIdleAnimation(Animation ani){
		idle = ani;
	}
	public void setClimbUpAnimation(Animation ani){
		climbUp = ani;
	}
	public void setClimbDownAnimation(Animation ani){
		climbDown = ani;
	}


    
    
    public void update(){
    	
    	String newAction = null;
    	
 	 	//If no action, then the player is idle
    	if(currentAction == null){
    		newAction = "idle";
    	}

    	Keyboard kb = getKeyboard();
    	
    	//Checks if walking left
		if(kb.isKeyPressed("left")){	
			newAction = "walkLeft";
			if(currentlyFalling && !isUpEnabled){
				newAction = "leftFall";
			}
			move(2,"West");
			
			//Prevents walking through walls
			if(isBlocked()){
				move(2, "East");
			}
				
		}
		//Checks to see if player is idle, or falling straight down
		else{
			newAction = "idle";
			if(currentlyFalling && !isUpEnabled){
				newAction = "straightFall";
			}
		}
	
		//Checks if moving right
		if(kb.isKeyPressed("right")){
			newAction = "walkRight";
		
			if(currentlyFalling && !isUpEnabled){
				newAction = "rightFall";
			}
			move(2,"East");	
			
			//Prevents walking through walls	
			if(isBlocked()){
				move(2,"West");
			}
		}
	
		//Checks if climbing up
		if(kb.isKeyPressed("up") && isUpEnabled){
			newAction = "climbUp";
			move(1,"North");
			
			//Prevents climbing through walls
			if(isBlocked()){
				move(1,"South");
			}
		}
		//Checks if jumping
		if(kb.isKeyPressed("up") && isJumpEnabled){
			if(jumpTimer.hasTimePassed(700)){
				isJumpEnabled = false;
			}
			//Resets jumpTimer if player has landed
			if(!currentlyFalling){
				jumpTimer.reset();
				isJumpEnabled = true;			
			}
			if(isJumpEnabled){
				newAction = "jump";
				move(3.5, "North");
				
				//Prevents jumping through walls
				if(isBlocked()){
					move(3.5,"South");
				}
			}
		}
		
		//Checks if climbing down
		if(kb.isKeyPressed("down") && isDownEnabled){
			newAction = "climbDown";
			move(1,"South");
			
			//Prevents climbing into floor
			if(isBlocked()){
				move(1,"North");
			}
		}
    	
    	super.update();
    	
    
    	
    	if(newAction != null && newAction.equals(currentAction)){
    		
    		//Set player's animation to walking right
    		if(newAction.equals("walkRight")){
    			setAnimation(walkRight);
    			currentAction = newAction;
    		}
    		//Sets player's animation to falling right
    		if(newAction.equals("rightFall")){
    			setAnimation(rightFalling);
    			currentAction = newAction;
    		}
    		//Sets player's animation to walking left
    		if(newAction.equals("walkLeft")){
    			setAnimation(walkLeft);
    			currentAction = newAction;
    		}
    		//Sets player's animation to falling left
    		if(newAction.equals("leftFall")){
    			setAnimation(leftFalling);
    			currentAction = newAction;
    		}
    		//Sets player's animation to climbing up
    		if(newAction.equals("climbUp")){
    			setAnimation(climbUp);
    			currentAction = newAction;
    		}
    		//Sets player's animation to climbing down
    		if(newAction.equals("climbDown")){
    			setAnimation(climbDown);
    			currentAction = newAction;
    		}
    		//Sets player's animation to falling down
    		if(newAction.equals("straightFall")){
    			setAnimation(straightFall);
    			currentAction = newAction;
    		}
    		//Sets player's animaton to jumping
    		if(newAction.equals("jump")){
    			setAnimation(jumpAnimation);
    			currentAction = newAction;
    		}
    		//Sets player's animation to idle
    		if(newAction.equals("idle")){
    			setAnimation(idle);
    			currentAction = newAction;
    		}
    	}
    	//Checks if there is a change in action
    	else{
    	
  		  	//Set player's animation to walking right
    		if(newAction.equals("walkRight")){
    			setAnimation(walkRight);
    			currentAction = newAction;
    		}
    		//Sets player's animation to falling right
    		if(newAction.equals("rightFall")){
    			setAnimation(rightFalling);
    			currentAction = newAction;
    		}
    		//Sets player's animation to walking left
    		if(newAction.equals("walkLeft")){
    			setAnimation(walkLeft);
    			currentAction = newAction;
    		}
    		//Sets player's animation to falling left
    		if(newAction.equals("leftFall")){
    			setAnimation(leftFalling);
    			currentAction = newAction;
    		}
    		//Sets player's animation to climbing up
    		if(newAction.equals("climbUp")){
    			setAnimation(climbUp);
    			currentAction = newAction;
    		}
    		//Sets player's animation to climbing down
    		if(newAction.equals("climbDown")){
    			setAnimation(climbDown);
    			currentAction = newAction;
    		}
    		//Sets player's animation to falling down
    		if(newAction.equals("straightFall")){
    			setAnimation(straightFall);
    			currentAction = newAction;
    		}
    		//Sets player's animaton to jumping
    		if(newAction.equals("jump")){
    			setAnimation(jumpAnimation);
    			currentAction = newAction;
    		}
    		//Sets player's animation to idle
    		if(newAction.equals("idle")){
    			setAnimation(idle);
    			currentAction = newAction;
    		}
    	}
    }
}  
