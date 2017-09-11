
import mayflower.*;

public class TitleStage extends Stage{
	
	private Text message;
	private Text playAgainMessage;
	
    public TitleStage() {
    	
    	//Puts Title on display
    	message = new Text("Let's Play");
    	addActor(message, 275, 200);
    	
    	//Puts Play Again message on display
    	playAgainMessage = new Text("Press SPACE to play...");
    	addActor(playAgainMessage, 175, 250);
    
    }
    
    public void update(){
    	
    	//Starts Level One, if user presses space
    	Keyboard kb = getKeyboard();
    	if(kb.isKeyPressed("space")){
    		getMayflower().setStage(new Level1(new Player()));
    	}
    	
    }
    
}