import greenfoot.*;

/**
 * Contiene puntos que el usuario tiene que recoger, desaparece a los 4 segundos
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PuntosZN extends Item
{
    int cont = 0;
    public void act() 
    {
        if(cont >= 300)
            getWorld().removeObject(this);
        cont++;
    }
}
