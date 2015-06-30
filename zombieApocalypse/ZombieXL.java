import greenfoot.*;

/**
 * Write a description of class ZombieXL here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZombieXL extends Zombie
{
    int cont = 0, contSalto = 0, bandSalto = 0, cicloSalto = 0;
    boolean congelado = false, remueve = false;
    int contCongelado = 0;
    public ZombieXL()
    {
        super(10, 1, 20, 10);
    }
    public void act()
    {
        if(!isTouching(Heroe.class))
        {
            muevete();
        }
        if(isTouching(BalaNormal.class) && cont >= 5)
        {
            vida--;
            cont = 0;
            removeTouching(BalaNormal.class);
            if(vida == 0)
            {
                PuntosXL pts = new PuntosXL();
                getWorld().addObject(pts, getX(), getY());
                remueve = true;
                if(Greenfoot.getRandomNumber(10) <= 5)
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
                PuntosXL pts = new PuntosXL();
                getWorld().addObject(pts, getX(), getY());
                remueve = true;              
                if(Greenfoot.getRandomNumber(10) <= 5)
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
                PuntosXL pts = new PuntosXL();
                getWorld().addObject(pts, getX(), getY());
                remueve = true;      
                if(Greenfoot.getRandomNumber(10) <= 5)
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
        
        if(contSalto >= 100)
            bandSalto = 1;
        if(bandSalto == 1)
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
    public void muevete()
    {
        if(!isTouching(Heroe.class))       
        {
            if(cicloSalto == 2)
            {
                setLocation(getX()-5,getY()-10);
            }
            if(cicloSalto == 4)
            {
                setLocation(getX()-5,getY()-10);
            }
            if(cicloSalto == 6)
            {
                setLocation(getX()-5,getY()-10);
            }
            if(cicloSalto == 8)
            {
                setLocation(getX()-5,getY()-10);
            }
             if(cicloSalto == 10)
            {
                setLocation(getX()-5,getY()-10);
            }
            if(cicloSalto == 12)
            {
                setLocation(getX()-5,getY()-10);
            }
            if(cicloSalto == 14)
            {
                setLocation(getX()-5,getY()-10);
            }
            if(cicloSalto == 16)
            {
                setLocation(getX()-5,getY()-10);
            }
             if(cicloSalto == 18)
            {
                setLocation(getX()-5,getY()-10);
            }
            if(cicloSalto == 20)
            {
                setLocation(getX()-5,getY()-10);
            }
            if(cicloSalto == 22)
            {
                setLocation(getX()-5,getY()+10);
            }
            if(cicloSalto == 24)
            {
                setLocation(getX()-5,getY()+10);
            }
             if(cicloSalto == 26)
            {
                setLocation(getX()-5,getY()+10);
            }
            if(cicloSalto == 28)
            {
                setLocation(getX()-5,getY()+10);
            }
            if(cicloSalto == 30)
            {
                setLocation(getX()-5,getY()+10);
            }
              if(cicloSalto == 32)
            {
                setLocation(getX()-5,getY()+10);
            }
             if(cicloSalto == 34)
            {
                setLocation(getX()-5,getY()+10);
            }
            if(cicloSalto == 36)
            {
                setLocation(getX()-5,getY()+10);
            }
            if(cicloSalto == 38)
            {
                setLocation(getX()-5,getY()+10);
            }
            if(cicloSalto == 40)
            {
                setLocation(getX(),getY()+10);
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
