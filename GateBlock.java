
import mayflower.*;

public class GateBlock extends AirBlock{

    public GateBlock() {
    	//Creates and Sets GateBlock Image
    	Picture p = new Picture("img/3.png");
    	p.resize(w, l);
    	setPicture(p);
    }
    
	public void update(){
    		
    		//Moves player to next stage when touching
    		Actor[] touching = getTouching();
    		for(Actor a : touching){
    			if(a instanceof Player){
    				Player p = (Player) a;
    				Stage s = getStage();
    					
    				if(s instanceof Level1){
    					//Moves player from level 1 to 2
    					getMayflower().setStage(new StageTwo(p));
    						
    				}
  
    				else if(s instanceof StageTwo){
    					//Moves player from level 2 to 3
    					getMayflower().setStage(new StageThree(p));
    				}
    				
    				else if(s instanceof StageThree){
    					//Displays winning end stage
    					GameOver endStage = new GameOver(p);
    					endStage.message.setText("You Win!");
    					endStage.setBackground("img/Win.png");
    					getMayflower().setStage(endStage);
    				}	
   		    	}
			}
		}
}







