import greenfoot.*;
import java.util.*;

/**
 * Write a description of class Mina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mina extends Item
{
    boolean toque;
    int cont;
    private List<Zombie> listaZombies = new ArrayList<Zombie>();
    Mina()
    {
        cont = 0;
        toque = false;
    }
    public void act() 
    {
        if(isTouching(Zombie.class))
        {
            toque = true;
            removeTouching(Zombie.class);
        }
        /*if(isTouching(ZombieX.class))
        {
            toque = true;
        }
        if(isTouching(ZombieXL.class))
        {
            toque = true;
        }
        if(isTouching(ZombieDebil.class))
        {
            toque = true;
        }
        if(isTouching(ZombieNormal.class))
        {
            toque = true;
        }
        if(isTouching(Heroe.class))
        {
            toque = true;
        }
        listaZombies = getNeighbours(5, true, Zombie.class);
        if(listaZombies != null)
            toque = true;*/
        if(toque)
        {
            cont++;
            setImage("explocionMina.png");
            if(cont >= 100)
            {
                getWorld().removeObject(this);
            }
        }
    }    
}
