import greenfoot.*;
import java.util.*;

/**
 * Cuando toca a un enemigo, explota en una enorme bola de fuego y si un zombie lo toca muere instantaneamente, si un jugador lo toca este tambien se vera afectado
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
