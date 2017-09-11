
import mayflower.*;
class StageThree extends MyStage{
	public StageThree(Player p){
		//Sends Map and Number of Coins to MyStage to be created
		super(new int[][]{
						 {1,1,1,1,1,1,1,1,1,1,1,1},
						 {1,0,0,0,0,0,0,0,0,0,0,1},
						 {1,0,0,0,0,0,0,0,0,0,0,1},
						 {1,0,0,0,0,0,0,0,0,0,0,1},
						 {1,0,0,0,0,0,0,0,0,0,0,1},
						 {1,0,0,0,0,0,0,0,0,0,3,1},
						 {1,0,4,2,4,0,0,0,0,0,3,1},
						 {1,0,4,2,4,0,0,0,0,2,2,1},
						 {1,0,4,2,4,0,0,0,0,2,2,1},
						 {1,0,4,2,4,0,0,0,0,2,2,1},
						 {1,0,4,2,4,0,0,6,0,2,2,1},
						 {1,1,1,1,1,1,1,1,1,1,1,1}
						 },2);
		//Adds player to map @initial position
		player = p;				 
		addActor(p, 60, 600);
			
	}	

}
