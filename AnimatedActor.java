import mayflower.*;

public class AnimatedActor extends GravityActor{
	
	private Animation animation;
	private Timer animationTimer;

    
    public AnimatedActor() {
    	//Initialize Animation and Start Timer
    	animation = null;
    	animationTimer = new Timer();
    }
    
    public void setAnimation(Animation a){
    	
    	animation = a;
    }
    
    public void update(){
    		
    	super.update();
    	
    	if(animation != null){
    				
    		//Changes images at the time set by frameRate
	    	if(animationTimer.hasTimePassed(animation.getFrameRate())){	
	    		animationTimer.reset();   
		    	setPicture(animation.getNextFrame());
	    	}
    	}
    }
    
}