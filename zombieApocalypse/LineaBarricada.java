import greenfoot.*;

/**
 * Write a description of class LineaBarricada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LineaBarricada extends Item
{
    /**
     * Act - do whatever the LineaBarricada wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }    
    public int toque()
    {
        if(isTouching(Zombie.class))
        {
            removeTouching(Zombie.class);
            return 20;
        }
        else
        return 0;
    }
}
