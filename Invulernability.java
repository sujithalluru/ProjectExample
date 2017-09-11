
import mayflower.*;

public class Invulernability extends MovableAnimatedActor{

	private Timer t;
	private Boolean invulernable;
	
	//Starts Invulernablity timer (..again)
	public void setInvulernable(){
		invulernable = true;
		t.reset();
	}
	
	//Checks if Invulernability is active
	public boolean isInvulernable(){
		if(t.hasTimePassed(800)){
			invulernable = false;
		}
		return invulernable;
	}
	
	
    public Invulernability() {
    	//Sets initial condition
    	invulernable = false; 
    	t = new Timer();
    }
    
    
}