import greenfoot.*;

/**
 * Write a description of class PuntosF here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PuntosF extends Item
{
    int cont = 0;
    public void act() 
    {
        if(cont >= 300)
            getWorld().removeObject(this);
        cont++;
    }    
}
