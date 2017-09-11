
import mayflower.*;

public class StageTwo extends MyStage {

    public StageTwo(Player p) {
    	//Sends Map and Number of Coins to MyStage to be created
    	super(new int[][]{
						 {1,1,1,1,1,1,1,1,1,1,1,1},
						 {1,0,0,0,0,0,0,0,0,3,0,1},
						 {1,0,0,0,0,6,0,0,0,3,0,1},
						 {1,0,4,2,2,2,2,2,2,2,0,1},
						 {1,0,4,0,0,0,0,0,0,0,0,1},
						 {1,0,4,0,6,0,0,0,0,0,0,1},
						 {1,0,2,2,2,2,2,2,2,2,4,1},
						 {1,0,0,0,0,0,0,0,0,0,4,1},
						 {1,0,0,0,0,0,0,0,0,0,4,1},
						 {1,0,0,0,0,0,0,0,0,0,4,1},
						 {1,1,1,5,1,5,1,5,1,1,1,1},
						 {1,1,1,1,1,1,1,1,1,1,1,1}
						 },2);
		//Adds player to map @initial position
		player = p;					 
		addActor(p,110,540);
    }
    
    
}