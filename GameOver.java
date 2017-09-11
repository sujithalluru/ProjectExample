
import mayflower.*;
public class GameOver extends Stage{
	
	public Text message;
	public Text playAgainMessage;
	private Player p;
	
    public GameOver(Player player) {
    	
    	p = player;
    	setBackground("img/Gameover.png");
    	
    	//Puts "Game Over" Title on display
    	message = new Text("Game Over");
    	addActor(message, 275, 200);
    	
    	//Puts Play Again message on display
    	playAgainMessage = new Text("Press SPACE to play again...");
    	addActor(playAgainMessage, 175, 250);
    
    }
    
    public void update(){
    	
    	//Starts Level One, if user presses space
    	Keyboard kb = getKeyboard();
    	if(kb.isKeyPressed("space")){
    		p.resetData();
    		getMayflower().setStage(new Level1(p));
    	}
    	
    }
    
}