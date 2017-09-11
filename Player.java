 
import mayflower.*;

public class Player extends MovableAnimatedActor {

	//Animations
	Animation rightWalk;
	Animation idle;
	Animation leftWalk;
	Animation climbUp;
	Animation climbDown;
	Animation rightFall;
	Animation leftFall;
	Animation straightFall;
	Animation hurtAnimation;
	Animation jump;
	
	//Dimensions
	private int width = 55;
	private int height = 55;
	

	public  int health;
	private int points = 0;
	private GameOver endStage;
	private Invulernability cooldown;

	//Increases player's score by num
	public void addPoint(int num){
		points += num;
	}
	
	//Returns player's score
	public int getPoints(){
		return points;
	}
	
	//Returns player's stats to initial condition
	public void resetData(){
		points = 0;
		health = 10;
	}

	//Removes num of lifes from player
	public void removeLife(int num){
		health -= num;
		currentlyHurt = false;
		//Changes Stage to Losing Stage
		if(health <= 0){
			endStage.message.setText("You Lose!");
			getMayflower().setStage(endStage);
		}
	}
	
	//Returns player's current health
	public int getLife(){
		return health;
	}
	
	//Creates string array of file locations for animation
	private void fillArray(String[] arr, String fileLocation, String fileType, Boolean reverseOrder){
		int y = 0;
		
		//Loads files in numerical order
		if(reverseOrder == false){
			for(int x = 0; x < arr.length; x++){
				String img = String.format(fileLocation + (x+1) + fileType);
				arr[x] = img;
			}
		}
		
		//Loads files in reverse order, to flip animation
		else{
			for(int x = arr.length; x > 0; x--){
				String img = String.format(fileLocation + x  + fileType);
				arr[y] = img;
				y++;
			}
		}
	}
	


    public Player() 
    {
    	//Sets initial conditions
    	endStage = new GameOver(this);
    	cooldown = new Invulernability();
    	health = 10;
    	
    	//Walk Right Animation
    	String[] arr = new String[8];
    	fillArray(arr,"img/player1/Walk",".png",false);
    	rightWalk = new Animation(50, arr);
    	rightWalk.resize(width,height);
    	setWalkRightAnimation(rightWalk);
    	
    	//Walk Left Animation
		String[] arr2 = new String[8];
		fillArray(arr2,"img/player1/Walk",".png",true);
    	leftWalk = new Animation(50, arr2);
    	leftWalk.resize(width,height);
    	setWalkLeftAnimation(leftWalk);
    	
    	//Climb Up Animation
    	String[] arr3 = new String[10];
		fillArray(arr3, "img/player1/Climb",".png", false);
    	climbUp = new Animation(50, arr3);
    	climbUp.resize(width,height);
    	setClimbUpAnimation(climbUp);
    	
    	//Climb Down Animation
    	String[] arr4 = new String[10];
		fillArray(arr4,"img/player1/Climb",".png", true);
    	climbDown = new Animation(50, arr4);
    	climbDown.resize(width,height);
    	setClimbDownAnimation(climbDown);
    	
    	//Idle Animation
    	String[] arr5 = new String[8];
		fillArray(arr5,"img/player1/Idle",".png", false);
    	idle = new Animation(50, arr5);
    	idle.resize(width,height);
    	setIdleAnimation(idle);
    	
    	//Falling Right Animation
    	String[] arr6 = new String[14];
    	fillArray(arr6, "img/player1/Fall",".png", false);
    	rightFall = new Animation(50, arr6);
    	rightFall.resize(width, height);
    	setRightFallingAnimation(rightFall);
    	
    	//Falling Left Animation
    	String[] arr7 = new String[14];
    	fillArray(arr7, "img/player1/Fall", ".png", true);
    	leftFall = new Animation(50, arr7);
    	leftFall.resize(width, height);
    	setLeftFallingAnimation(leftFall);
    	
    	//Falling Straight Down Animation
		String[] arr8 = new String[7];
		fillArray(arr8, "img/player1/StraightFall", ".png", false);
		straightFall = new Animation(50, arr8);
		straightFall.resize(width, height);
		setStraightFallingAnimation(straightFall);
		
		//Hurt Animation
		String[] arr9 = new String[1];
		fillArray(arr9, "img/Enemy", ".png",false);
		hurtAnimation = new Animation(50, arr9);
		hurtAnimation.resize(width, height);
		setHurtAnimation(hurtAnimation);
		
		//Jump Animation
		String[] arr10 = new String[7];
		fillArray(arr10, "img/player1/StraightFall",".png", true);
		jump = new Animation(50, arr10);
		jump.resize(width, height);
		setJumpAnimation(jump);
		
    }
    
	
  
    
    public void update()
    {
    	super.update();
    	isBlocked();
    	
    	Actor[] touching = getTouching();
    	for(Actor a : touching){
    		
    		//Enables player to climb Ladders, if touching ladder
    		if(a instanceof StairBlock){
    		
   				enableUp();
   				enableDown();
   				disableFalling();
   				disableJump();
   			
   			}
   			//Disables ladder climbing, if not touching ladder
   			else{
   				disableUp();
   				disableDown();
   				enableFalling();
   				enableJump();
   				
   			}
   			
   			//If player makes contact with a HazardBlock, 1 life is subtracted
   			if(currentlyHurt && !cooldown.isInvulernable()){
   				//Cooldown is engaged, to prevent excessive health loss
   				cooldown.setInvulernable();
   				removeLife(1);
   			}
   			
   			else if(a instanceof Scanner){
   				//Prevents damage from contact with scanner
   			}
   			
   			//If player makes contact with an Enemy, 2 lifes are subtracted 
   			else if(a instanceof Enemy && !cooldown.isInvulernable()){
   				removeLife(2);
   				cooldown.setInvulernable();
   				
   			}
   			
   			//Prevents Damage from ocurring when not in contact with Hazard/Enemy
   			else{
   				currentlyHurt = false;
   			}
   			
    
    	} 
    }   
}