import greenfoot.*;

/**
 * Write a description of class Bala here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bala extends Actor
{    
    public void act() 
    {        
    }    
    public void muevete(int x)
    {
        move(x);
        if(getX() > 1090)
        {
            getWorld().removeObject(this);
        }
    }
}
