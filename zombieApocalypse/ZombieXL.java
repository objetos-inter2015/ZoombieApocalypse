import greenfoot.*;

/**
 * Crea al zombie XL
 * 
 * @author (Arturo Garcia) 
 * @version (1.0)
 */
public class ZombieXL extends Zombie
{
    int cont = 0, contSalto = 0, bandSalto = 0, cicloSalto = 0;
    boolean congelado = false, remueve = false;
    int contCongelado = 0;
    ExplosivaIcono e;
    CongeladoraIcono c;
    PerforadoraIcono p;
    public ZombieXL()
    {
        super(10, 1, 20, 10);
    }
    public void act()
    {
        if(contCongelado == 200 && congelado)
            congelado = false;
        if(isTouching(BalaNormal.class) && cont >= 5)
        {
            vida--;
            cont = 0;
            removeTouching(BalaNormal.class);
            if(vida <= 0)
            {
                PuntosXL pts = new PuntosXL();
                getWorld().addObject(pts, getX(), getY());
                remueve = true;
                if(Greenfoot.getRandomNumber(10) <= 5)
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
                PuntosXL pts = new PuntosXL();
                getWorld().addObject(pts, getX(), getY());
                remueve = true;              
                if(Greenfoot.getRandomNumber(10) <= 5)
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
                PuntosXL pts = new PuntosXL();
                getWorld().addObject(pts, getX(), getY());
                remueve = true;      
                if(Greenfoot.getRandomNumber(10) <= 5)
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
        if(isTouching(Mina.class))
        {
            remueve = true;
        }
        if(congelado)
        {
            velocidad = 0;
            contCongelado++;
            if(contCongelado >= 200)
                {
                    velocidad = 4;
                    congelado = false;
                }
        }    
        if(contSalto >= 100)
            bandSalto = 1;
        if(bandSalto == 1 && !congelado)
        {
            cicloSalto++;
            muevete();
        }
        cont++;
        contSalto++;
        if(remueve)
        {
            getWorld().removeObject(this);
        }
    }
    /**
     * sobrecarga del metodo muevete del padre que hace brincar a este zombie
     */
    public void muevete()
    {
        if(!isTouching(Heroe.class))       
        {
            if(cicloSalto == 2)
            {
                setLocation(getX()-7,getY()-10);
            }
            if(cicloSalto == 4)
            {
                setLocation(getX()-7,getY()-10);
            }
            if(cicloSalto == 6)
            {
                setLocation(getX()-7,getY()-10);
            }
            if(cicloSalto == 8)
            {
                setLocation(getX()-7,getY()-10);
            }
             if(cicloSalto == 10)
            {
                setLocation(getX()-7,getY()-10);
            }
            if(cicloSalto == 12)
            {
                setLocation(getX()-7,getY()-10);
            }
            if(cicloSalto == 14)
            {
                setLocation(getX()-7,getY()-10);
            }
            if(cicloSalto == 16)
            {
                setLocation(getX()-7,getY()-10);
            }
             if(cicloSalto == 18)
            {
                setLocation(getX()-7,getY()-10);
            }
            if(cicloSalto == 20)
            {
                setLocation(getX()-7,getY()-10);
            }
            if(cicloSalto == 22)
            {
                setLocation(getX()-7,getY()+10);
            }
            if(cicloSalto == 24)
            {
                setLocation(getX()-7,getY()+10);
            }
             if(cicloSalto == 26)
            {
                setLocation(getX()-7,getY()+10);
            }
            if(cicloSalto == 28)
            {
                setLocation(getX()-7,getY()+10);
            }
            if(cicloSalto == 30)
            {
                setLocation(getX()-7,getY()+10);
            }
              if(cicloSalto == 32)
            {
                setLocation(getX()-7,getY()+10);
            }
             if(cicloSalto == 34)
            {
                setLocation(getX()-7,getY()+10);
            }
            if(cicloSalto == 36)
            {
                setLocation(getX()-7,getY()+10);
            }
            if(cicloSalto == 38)
            {
                setLocation(getX()-7,getY()+10);
            }
            if(cicloSalto == 40)
            {
                setLocation(getX() -7,getY()+10);
                bandSalto=0;
                cicloSalto=0;
                contSalto = 0;
            }
        }
        if(isTouching(Heroe.class))
        {
            bandSalto=0;
            cicloSalto=0;
            contSalto = 0;
        }
    }
}
