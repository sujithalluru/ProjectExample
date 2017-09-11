
import mayflower.*;
import java.util.*;


public class MyStage extends Stage {
	//Dimensions of Spaces
	private int w = 60;
    private int l = 60;


	//Items to Display
	private Text   currentHealth;
	private Text   pointsText;
	public  Player player;
	
	
    public MyStage(int[][] map, int numOfCoins) {
    	showBounds(true);
    	
    	
    	List<int[]> freeSpace = new ArrayList<int[]>();
    	
    	//Interprets 2D Array and converts it into a map
    	for(int i = 0; i < map.length; i++){
    		Actor a;
    		for(int x = 0; x < map[i].length; x++){
    			int currentBlock = map[i][x];
    			int h = x*l;
    			int v = i*w;
    			switch(currentBlock){
    				//Adds AirBlock
    				case 0: 	a = new AirBlock();
    							addActor(a, h, v);
  
    							//Collects AirBlocks position and stores in ArrayList
    							int[] local = {a.getX(), a.getY()};
    							freeSpace.add(local);
    							break;
    				//Adds Block			
    				case 1:		a = new Block();
    							addActor(a, h, v);
    							break;
    				//Adds Block2
    				case 2:		a = new Block2();
    							addActor(a,h,v);
    							break;
    				//Adds GateBlock
    				case 3:		a = new GateBlock();
    							addActor(a, h, v);
    							break;
    				//Adds StairBlock
    				case 4:		a = new StairBlock();
    							addActor(a, h, v);
    							break;
    				//Adds HazardBlock
    				case 5:		a = new HazardBlock();
    							addActor(a, h, v);
    							break;
    				//Adds Enemy
    				case 6:		a = new AirBlock();
    							Actor bad = new Enemy();
    							addActor(a, h, v);
    							bad.setDrawOrder(50);
    							addActor(bad, h, v);
    							Actor scan = new Scanner(bad.getWidth()*5, bad.getHeight());
    							scan.setDrawOrder(49);
    							addActor(scan, h, v);
    							break;
    							
    			} 
    		}
    	
    	}
    	
    	currentHealth = new Text("Lifes: ?");
    	pointsText = new Text("Points: ?");
    	addActor(currentHealth, 0, 0);
    	addActor(pointsText, 0, 30);
    
    	//Places Coins in psuedorandom position
    	for(int i = 0; i < numOfCoins; i++){
    		Coin c = new Coin();
    		Random myRandomizer = new Random();
    		//Checks if Coins overlap with each other
    		int touching = 0;
    		do{
    			int[] myPosition = freeSpace.get(myRandomizer.nextInt(freeSpace.size()));
    			addActor(c, myPosition[0], myPosition[1]);
    			for(Actor a : c.getTouching()){
    				if(a instanceof Coin){
    					++touching;
    				}
    			}
    		}
    		while(touching > 0);
    	
    	}
   		
    }
    
    
    
    
    public void update(){
    	
    	//Updates Displayed Life & Points
    	currentHealth.setText("Lifes: " + player.getLife());
    	pointsText.setText("Points: " + player.getPoints());
    	if(player.getLife() == 0){
    		currentHealth.setText("GAME OVER");
    	}
    }

}