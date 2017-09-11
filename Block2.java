
import mayflower.*;

public class Block2 extends Block{
	
    public Block2() {
    	
    	//Create and Set Block2 Image
    	Picture p = new Picture("img/2.png");
    	p.resize(w, l);
    	setPicture(p);
    }
    
    public void update(){
    	super.update();
    }
    
}