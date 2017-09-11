
import mayflower.*;

public class Animation {
	
	private Picture[] frames;
	private int currentFrame;
	private int frameRate;
	
	
    public Animation(int rate, String[] filenames) 
{
    	
    	//Gathers frames
    	frames = new Picture[filenames.length];
    	for(int i=0; i < filenames.length; i++)
    	{
    		int n = i + 1;
    		frames[i] = new Picture(filenames[i]);
    	}
    	
    	currentFrame = 0;
    	frameRate = rate;
    }
    
    
    
    public int getFrameRate()
    {
    	return frameRate;
    }
    
    
    //Gives current frame & moves index to next frame
    public Picture getNextFrame()
    {
    	currentFrame = currentFrame % frames.length;
    	Picture ret = frames[currentFrame];
    	currentFrame = currentFrame + 1;
    	return ret;
    }
    
    
    //Resize every picture in the animation
    public void resize(int w, int h)
    {
    	for(Picture p : frames)
    	{
    		p.resize(w, h);
    	}
    }
    
    
    //Set Tranparency for every picture in animation
    public void setTransparency(int percent)
    {
    	for(Picture p : frames)
    	{
    		p.setTransparency(percent);
    	}
    }
    
    
}