import greenfoot.*;

/**
 * Write a description of class Barricada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barricada extends Item
{
    int vida = 600, contComidoN = 0, contComidoF = 0, contComidoD = 0, contComidoXL = 0, contComidoX = 0;
    boolean remueve = false;
    public void act() 
    {
        if(isTouching(ZombieNormal.class) && contComidoN >= 10)
        {
            contComidoN = 0;
            vida -= 5;  
            if(vida <= 0)
            {
                remueve = true;
            }
        }
        if(isTouching(ZombieXL.class) && contComidoXL >= 50)
        {
            contComidoXL = 0;
            vida -= 30;    
            if(vida <= 0)
            {
                remueve = true;
            }
        }
        if(isTouching(ZombieFuerte.class) && contComidoF >= 10)
        {
            contComidoF = 0;
            vida -= 10;    
            if(vida <= 0)
            {
                remueve = true;
            }
        }
        if(isTouching(ZombieDebil.class) && contComidoD >= 2)
        {
            contComidoD = 0;
            vida -= 1;     
            if(vida <= 0)
            {
                remueve = true;
            }
        }
        if(isTouching(ZombieX.class) && contComidoX >= 30)
        {  
            contComidoX = 0;
            vida -= 15;
            if(vida <= 0)
            {
                remueve = true;
            }
        }
        getWorld().showText("Barricada: " + String.valueOf(vida), 600, 50);
        contComidoN++;
        contComidoXL++;
        contComidoX++;
        contComidoF++;
        contComidoD++;
        if(remueve)
        getWorld().removeObject(this);
    }    
}
