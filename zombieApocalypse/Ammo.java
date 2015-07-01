import greenfoot.*;

/**
 * Contiene municion que el usuario tiene que recoger, desaparece a los 4 segundos.
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
