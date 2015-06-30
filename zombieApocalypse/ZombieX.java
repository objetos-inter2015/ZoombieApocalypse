import greenfoot.*;

/**
 * Write a description of class ZombieX here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZombieX extends Zombie
{
    int cont = 0;
    boolean congelado = false, remueve = false;
    int contCongelado = 0;
    public ZombieX()
    {
        super(7, 2, 15, 7);
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
                PuntosX pts = new PuntosX();
                getWorld().addObject(pts, getX(), getY());
                remueve = true;  
                if(Greenfoot.getRandomNumber(10) <= 4)
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
                remueve = true;
                PuntosX pts = new PuntosX();
                getWorld().addObject(pts, getX(), getY());
                if(Greenfoot.getRandomNumber(10) <= 4)
                {
                    Ammo ammo = new Ammo();
                    getWorld().addObject(ammo, getX(), getY()+20);
                }
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
                PuntosX pts = new PuntosX();
                getWorld().addObject(pts, getX(), getY());
                if(Greenfoot.getRandomNumber(10) <= 4)
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
        if(remueve)
        {
            getWorld().removeObject(this);
        }
        cont++;
    }
    public void muevete()
    {
        if(!isTouching(Heroe.class) && !isTouching(Barricada.class))
        {
            move(-velocidad);
        }
    }
}
