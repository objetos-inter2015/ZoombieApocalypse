import greenfoot.*;
import javax.swing.*;

/**
 * Crea al Jugador del juego
 * 
 * @author (Arturo Garcia Perez) 
 * @version (1.0)
 */
public class Heroe extends Actor
{   
    int vida, lifebar, puntuacion, daño, balas, balasDisponibles, balasExplosivas, balasCongeladoras, balasPerforadoras, balasE, balasC, balasP;
    int tipoDeBala = 1, band = 0, bandRecarga = 0, contComidoN = 0, contComidoF = 0, contComidoD = 0, contComidoXL = 0, contComidoX = 0;
    int x = 6, pts;
    String nombre;
    public Heroe() 
    {
           vida = 3;
           lifebar = 100;
           puntuacion = 0;
           daño = 1;
           balas = 6;
           balasDisponibles = 50;
           balasExplosivas = 0;
           balasCongeladoras = 0;
           balasPerforadoras = 0;
           balasE = 0;
           balasC = 0;
           balasP = 0;
           nombre = JOptionPane.showInputDialog(null,"Cual es tu nombre valiente caballero?" ,"Nombre" ,JOptionPane.QUESTION_MESSAGE);
    }  
    public void act()
    {        
        muevete();
        if(Greenfoot.isKeyDown("space") && band >= 10 && balas > 0 && tipoDeBala == 1)
        {
            band = 0;
            dispara();
            Greenfoot.playSound("disparo.mp3");
            balas--;
        }
        if(Greenfoot.isKeyDown("space") && band >= 10 && balasP > 0 && tipoDeBala == 2)
        {
            band = 0;
            dispara();
            Greenfoot.playSound("disparo.mp3");
            balasP--;
        }
        if(Greenfoot.isKeyDown("space") && band >= 10 && balasC > 0 && tipoDeBala == 3)
        {
            band = 0;
            dispara();
            Greenfoot.playSound("disparo.mp3");
            balasC--;
        }
        if(Greenfoot.isKeyDown("space") && band >= 10 && balasE > 0 && tipoDeBala == 4)
        {
            band = 0;
            dispara();
            Greenfoot.playSound("disparo.mp3");
            balasE--;
        }
        if(isTouching(Mina.class))
        {
            lifebar -= 20;
            if(lifebar <= 0)
            {
                vida--;
                lifebar = 100;
            }
        }
        if(Greenfoot.isKeyDown("r") && bandRecarga >= 10)
        {
            recarga();
            Greenfoot.playSound("recarga.mp3");
        }
        if(Greenfoot.isKeyDown("4"))
        {
            tipoDeBala = 1;
        }
        if(Greenfoot.isKeyDown("5"))
        {
            tipoDeBala = 2;
        }
        if(Greenfoot.isKeyDown("6"))
        {
            tipoDeBala = 3;
        }
        if(Greenfoot.isKeyDown("7"))
        {
            tipoDeBala = 4;
        }
        
        if(isTouching(PuntosZN.class))
        {
           puntuacion += 4;
           removeTouching(PuntosZN.class);
        }
        if(isTouching(PuntosX.class))
        {
           puntuacion += 7;
           removeTouching(PuntosX.class);
        }
        if(isTouching(PuntosD.class))
        {
           puntuacion += 2;
           removeTouching(PuntosD.class);
        }
        if(isTouching(PuntosF.class))
        {
           puntuacion += 5;
           removeTouching(PuntosF.class);
        }
        if(isTouching(PuntosXL.class))
        {
           puntuacion += 10;
           removeTouching(PuntosXL.class);
        }
        if(isTouching(Ammo.class))
        {
           balasDisponibles += 15;
           removeTouching(Ammo.class);
        }
         if(isTouching(PerforadoraIcono.class))
        {
           balasPerforadoras += 15;
           removeTouching(PerforadoraIcono.class);
        }
         if(isTouching(CongeladoraIcono.class))
        {
           balasCongeladoras += 10;
           removeTouching(CongeladoraIcono.class);
        }
         if(isTouching(ExplosivaIcono.class))
        {
           balasExplosivas += 5;
           removeTouching(ExplosivaIcono.class);
        }
        band++;
        bandRecarga++;
        muestraStats();
        seComido();
        
    }
    /**
     * dispara dependiendo de la municion que el usuario tenga seleccionada
     */
    public void dispara()
    {
        switch(tipoDeBala)
        {            
             case 1:
             BalaNormal bala = new BalaNormal();
             getWorld().addObject(bala, getX() + 60, getY() - 10);
             bala.setRotation(0);   
             band = 0;
             break;
        
             case 2:                     
             Perforadora balap = new Perforadora();
             getWorld().addObject(balap, getX() + 60, getY() - 10);
             balap.setRotation(0);   
             band = 0;
             break;
        
             case 3:                    
             Congeladora balac = new Congeladora();
             getWorld().addObject(balac, getX() + 60, getY() - 10);
             balac.setRotation(0);   
             band = 0;
             break;
        
             case 4:
             Explosiva balae = new Explosiva();
             getWorld().addObject(balae, getX() + 60, getY() - 10);
             balae.setRotation(0);   
             band = 0;
             break;
        }
    }
    /**
     * verifica que tipo de municion se esta utilizando y recarga el arma con esa municion 
     */
    public void recarga()
    {
        switch(tipoDeBala)
        {
            case 1:
            if( balasDisponibles - (x - balas) <= 0)
            {
                balas += balasDisponibles;
                balasDisponibles = 0;
            }
            else
            {
                balasDisponibles -= (x - balas);
                balas = x;
            }            
            break;
            
            case 2:
            if( balasPerforadoras - (x - balasP) <= 0)
            {
                balasP += balasPerforadoras;
                balasPerforadoras = 0;
            }
            else
            {
                balasPerforadoras -= (x - balasP);
                balasP = x;
            }
            break;
            
            case 3:
            if( balasCongeladoras - (x - balasC) <= 0)
            {
                balasC += balasCongeladoras;
                balasCongeladoras = 0;
            }
            else
            {
                balasCongeladoras -= (x - balasC);
                balasC = x;
            }
            break;
            
            case 4:
            if( balasExplosivas - (x - balasE) <= 0)
            {
                balasE += balasExplosivas;
                balasExplosivas = 0;
            }
            else
            {
                balasExplosivas -= (x - balasE);
                balasE = x;
            }
            break;
        }
        bandRecarga = 0;
    }
    /**
     * muestra varios parametros del jugador, como la vida y la puntuacion
     */
    public void muestraStats()
    {
        if(tipoDeBala == 1)
        {
            getWorld().showText("Balas: " + String.valueOf(balas), 50, 550);
            getWorld().showText("Municiones: " + String.valueOf(balasDisponibles), 200, 550);
        }
        if(tipoDeBala == 2)
        {
            getWorld().showText("Balas: " + String.valueOf(balasP), 50, 550);
            getWorld().showText("Municiones: " + String.valueOf(balasPerforadoras), 200, 550);
        }
        if(tipoDeBala == 3)
        {
            getWorld().showText("Balas: " + String.valueOf(balasC), 50, 550);
            getWorld().showText("Municiones: " + String.valueOf(balasCongeladoras), 200, 550);
        }
        if(tipoDeBala == 4)
        {
            getWorld().showText("Balas: " + String.valueOf(balasE), 50, 550);
            getWorld().showText("Municiones: " + String.valueOf(balasExplosivas), 200, 550);
        }        
        getWorld().showText("Vidas: " + String.valueOf(vida), 50, 575);
        getWorld().showText("Porcentaje de vida: " + String.valueOf(lifebar) + "%", 220, 575);
        getWorld().showText("Puntuacion: " + String.valueOf(puntuacion) , 375, 550);
        getWorld().showText("Normales (4): " + String.valueOf(balasDisponibles), 550, 550);
        getWorld().showText("Explosivas(7): " + String.valueOf(balasExplosivas), 750, 575);
        getWorld().showText("Congeladoras(6): " + String.valueOf(balasCongeladoras), 750, 550);
        getWorld().showText("Perforadoras(5): " + String.valueOf(balasPerforadoras), 550, 575);
    }
    /**
     * mueve al jugador, verificando que no haya zombies a su derecha o izquierda, si los hay, no lo deja avanzar
     */
    public void muevete()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            if(getY() > 100)
            {
                setRotation(270);
                setImage("AVATAR270.png");
                move(5);
            }           
        }
        if(Greenfoot.isKeyDown("down"))
        {
            if(getY() < 450)
            {                
                setRotation(90);
                setImage("AVATAR90.png");
                move(5);
            }
        }
        if(Greenfoot.isKeyDown("left"))
        {
            if(getX() > 200)
            {                
                setRotation(180);
                setImage("AVATAR180.png");
                move(5); 
            }
        }
        if(Greenfoot.isKeyDown("right") && !isTouching(Zombie.class))
        {   
            if(getX() < 1050)
            {
                setRotation(0);
                setImage("AVATAR.png");
                move(5);   
            }          
        }
    }
    /**
     * cuando un zombie lo toca, dependiendo del tipo, empieza a bajarle puntos a la barra de vida del heroe, si la barra de vida es igual a 0, le resta una vida 
     */
    public void seComido()
    {
        if(isTouching(ZombieNormal.class) && contComidoN >= 10)
        {
            contComidoN = 0;
            lifebar -= 5;
            if(lifebar <= 0)
            {
                lifebar = 100;
                vida--;
            }           
        }
        if(isTouching(ZombieXL.class) && contComidoXL >= 50)
        {
            contComidoXL = 0;
            lifebar -= 30;
            if(lifebar <= 0)
            {
                lifebar = 100;
                vida--;
            }           
        }
        if(isTouching(ZombieFuerte.class) && contComidoF >= 10)
        {
            contComidoF = 0;
            lifebar -= 10;
            if(lifebar <= 0)
            {
                lifebar = 100;
                vida--;
            }           
        }
        if(isTouching(ZombieDebil.class) && contComidoD >= 2)
        {
            contComidoD = 0;
            lifebar -= 1;
            if(lifebar <= 0)
            {
                lifebar = 100;
                vida--;
            }           
        }
        if(isTouching(ZombieX.class) && contComidoX >= 30)
        {
            contComidoX = 0;
            lifebar -= 15;
            if(lifebar <= 0)
            {
                lifebar = 100;
                vida--;
            }           
        }
        contComidoN++;
        contComidoXL++;
        contComidoX++;
        contComidoF++;
        contComidoD++;
    }
    /**
     * aumenta el tamaño del cargador del jugador
     */
    public void aumentaBalas(int aumento)
    {
        x += aumento;
    }
    /**
     * aumenta el numero de balas disponibles
     */
    public void aumentaMunicion(int x)
    {
        balasDisponibles += x;
    }
    /**
     * quita vida al jugador
     */
    public void quitaVida(int x)
    {
        lifebar -= x;
        if(lifebar <= 0)
            {
                lifebar = 100;
                vida--;
            }
    }
    /**
     * quita puntuacion cuando el usuario compra un item
     */
    public void compraItem(int x)
    {
        puntuacion -= x;
    }
}
