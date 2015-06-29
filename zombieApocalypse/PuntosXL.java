import greenfoot.*;

/**
 * Write a description of class PuntosXL here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PuntosXL extends Item
{
    int cont = 0;
    public void act() 
    {
        if(cont >= 300)
            getWorld().removeObject(this);
        cont++;
    }  
}
