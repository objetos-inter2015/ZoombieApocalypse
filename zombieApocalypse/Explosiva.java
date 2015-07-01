import greenfoot.*;

/**
 * Write a description of class Explosiva here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosiva extends Bala
{
    boolean toque;
    int cont;
    boolean remueve = false;
    Explosiva()
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
                    remueve = true;
                }
            }    
            muevete(3);
            if(remueve)
                getWorld().removeObject(this);
    }   
    public void muevete(int x)
    {
        move(x);
        if(getX() > 1090)
        {
            remueve = true;
        }
    }
}
