import greenfoot.*;
import java.util.*;

/**
 * Write a description of class ZombieNormal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZombieNormal extends Zombie
{
    int cont = 0;
    int contCongelado = 0;
    boolean congelado = false, remueve = false;
    List<Actor> h = new ArrayList<Actor>();
    public ZombieNormal()
    {
        super(3, 4, 5, 4);//vida, velocidad, daño, puntos
    }   
    public void act()
    {
        muevete();
        if(isTouching(BalaNormal.class) && cont >= 5)
        {
            vida--;
            cont = 0;
            removeTouching(BalaNormal.class);
            if(vida == 0)
            {
                remueve = true;
                PuntosZN pts = new PuntosZN();
                getWorld().addObject(pts, getX(), getY());
                if(Greenfoot.getRandomNumber(10) == 0)
                {
                    Ammo ammo = new Ammo();
                    getWorld().addObject(ammo, getX(), getY()+20);
                }
            }
        }
        
        if(isTouching(Perforadora.class) && cont >= 5)
        {
            vida -= 3;
            cont = 0;
            if(vida == 0)
            {
                PuntosZN pts = new PuntosZN();
                getWorld().addObject(pts, getX(), getY());
                if(Greenfoot.getRandomNumber(10) == 0)
                {
                    Ammo ammo = new Ammo();
                    getWorld().addObject(ammo, getX(), getY()+20);
                }
                remueve = true;
            }
        }
        
        if(isTouching(Congeladora.class) && cont >= 5)
        {
            vida--;
            cont = 0;
            congelado = true;
            removeTouching(Bala.class);
            if(vida == 0)
            {
                remueve = true;
                PuntosZN pts = new PuntosZN();
                getWorld().addObject(pts, getX(), getY());
                if(Greenfoot.getRandomNumber(10) == 0)
                {
                    Ammo ammo = new Ammo();
                    getWorld().addObject(ammo, getX(), getY()+20);
                }
            }
        }
        
        if(congelado)
        {
            velocidad = 0;
            contCongelado++;
            if(contCongelado == 200)
                {
                    velocidad = 4;
                }
        }
        cont++;
        if(remueve)
        {
            getWorld().removeObject(this);
        }
    }
    public void muevete()
    {
        if(!isTouching(Heroe.class))
        {
            move(-velocidad);
        }
    }
}
