import greenfoot.*;

/**
 * Write a description of class ZombieFuerte here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZombieFuerte extends Zombie
{
    int cont = 0;
    boolean congelado = false, remueve = false;
    int contCongelado = 0;
    ExplosivaIcono e;
    CongeladoraIcono c;
    PerforadoraIcono p;
    public ZombieFuerte()
    {
        super(5, 4, 10, 5);
    }    
    public void act()
    {
        if(!congelado);
            muevete();
        if(contCongelado == 200 && congelado)
            congelado = false;
        if(isTouching(BalaNormal.class) && cont >= 5)
        {
            vida--;
            cont = 0;
            removeTouching(BalaNormal.class);
            if(vida <= 0)
            {
                PuntosF pts = new PuntosF();
                getWorld().addObject(pts, getX(), getY());
                remueve = true;    
                if(Greenfoot.getRandomNumber(10) <= 3)
                {
                    Ammo ammo = new Ammo();
                    getWorld().addObject(ammo, getX(), getY()+20);
                }
                if(Greenfoot.getRandomNumber(100) <= 10)
                {
                    switch (Greenfoot.getRandomNumber(3))
                    {
                        case 0:
                        e = new ExplosivaIcono();
                        getWorld().addObject(e, getX()+30, getY()+20);
                        break;
                        
                        case 1:
                        c = new CongeladoraIcono();
                        getWorld().addObject(c, getX()+30, getY()+20);
                        break;
                        
                        case 2:
                        p = new PerforadoraIcono();
                        getWorld().addObject(p, getX()+30, getY()+20);
                        break;
                    }
                }
            }
        }
        if(isTouching(Perforadora.class) && cont >= 5)
        {
            vida -= 3;
            cont = 0;
            if(vida <= 0)
            {
                remueve = true;
                PuntosF pts = new PuntosF();
                getWorld().addObject(pts, getX(), getY());
                if(Greenfoot.getRandomNumber(10) <= 3)
                {
                    Ammo ammo = new Ammo();
                    getWorld().addObject(ammo, getX(), getY()+20);
                }
                if(Greenfoot.getRandomNumber(100) <= 10)
                {
                    int bal = Greenfoot.getRandomNumber(3);
                    switch (bal)
                    {
                        case 0:
                        e = new ExplosivaIcono();
                        getWorld().addObject(e, getX()+30, getY()+20);
                        break;
                        case 1:
                        c = new CongeladoraIcono();
                        getWorld().addObject(c, getX()+30, getY()+20);
                        break;
                        case 2:
                        p = new PerforadoraIcono();
                        getWorld().addObject(p, getX()+30, getY()+20);
                        break;
                    }
                }
            }
        }
        if(isTouching(Congeladora.class) && cont >= 5)
        {
            vida -= 2;
            cont = 0;
            congelado = true;
            removeTouching(Congeladora.class);
            if(vida <= 0)
            {
                remueve = true;
                PuntosF pts = new PuntosF();
                getWorld().addObject(pts, getX(), getY());
                if(Greenfoot.getRandomNumber(10) <= 3)
                {
                    Ammo ammo = new Ammo();
                    getWorld().addObject(ammo, getX(), getY()+20);
                }
                if(Greenfoot.getRandomNumber(100) <= 10)
                {
                    int bal = Greenfoot.getRandomNumber(3);
                    switch (bal)
                    {
                        case 0:
                        e = new ExplosivaIcono();
                        getWorld().addObject(e, getX()+30, getY()+20);
                        break;
                        case 1:
                        c = new CongeladoraIcono();
                        getWorld().addObject(c, getX()+30, getY()+20);
                        break;
                        case 2:
                        p = new PerforadoraIcono();
                        getWorld().addObject(p, getX()+30, getY()+20);
                        break;
                    }
                }
            }
        }
        if(isTouching(RayoLaser.class))
        {
            remueve = true;
        }            
        if(remueve)
        {
            getWorld().removeObject(this);
        }
        cont++;
        contCongelado++;
    }
    public void muevete()
    {
        if(!isTouching(Heroe.class) && !isTouching(Barricada.class))
        {
            move(-velocidad);
        }
    }
}
