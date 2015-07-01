import greenfoot.*;

/**
 * Contiene el constructor de las balas y el metodo muevete
 * 
 * @author (Arturo GArcia) 
 * @version (1.0)
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
