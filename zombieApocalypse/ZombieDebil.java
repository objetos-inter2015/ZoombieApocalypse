import greenfoot.*;

/**
 * Crea al zombie Debil
 * 
 * @author (Arturo Garcia) 
 * @version (1.0)
 */
public class ZombieDebil extends Zombie
{
    int cont = 0;
    boolean congelado = false, remueve = false;
    int contCongelado = 0;
    ExplosivaIcono e;
    CongeladoraIcono c;
    PerforadoraIcono p;
    int z = 0;
    String[] ZOMBIE = {"DEBIL1.png", "DEBIL2.png", "DEBIL3.png", "DEBIL4.png"};
    public ZombieDebil()
    {
        super(1, 8, 5, 2);
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
                PuntosD pts = new PuntosD();
                getWorld().addObject(pts, getX(), getY());
                remueve = true; 
                if(Greenfoot.getRandomNumber(10) <= 2)
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
                PuntosD pts = new PuntosD();
                getWorld().addObject(pts, getX(), getY());
                remueve = true;       
                if(Greenfoot.getRandomNumber(10) <= 2)
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
        if(isTouching(Congeladora.class) && cont >= 5)
        {
            vida--;
            cont = 0;
            congelado = true;
            removeTouching(Bala.class);
            if(vida <= 0)
            {
                PuntosD pts = new PuntosD();
                getWorld().addObject(pts, getX(), getY());
                remueve = true;     
                if(Greenfoot.getRandomNumber(10) <= 2)
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
        if(isTouching(RayoLaser.class))
        {
            remueve = true;
        }
        if(congelado)
        {
            velocidad = 0;
            contCongelado++;
            if(contCongelado == 300)
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
            setImage(ZOMBIE[z]);
            z++;
            if(z > 3)
                z = 0;
        }
    }
}
