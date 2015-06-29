import greenfoot.*;

/**
 * Write a description of class Ammo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ammo extends Item
{
    int cont = 0;
    public void act() 
    {
        if(cont >= 400)
            getWorld().removeObject(this);
        cont++;
    }    
}
