import greenfoot.*;
import java.util.*;

/**
 * Write a description of class Escenario here.
 * 
 * @author (Arturo Garcia Perez) 
 * @version (1.0)
 */
public class Juego extends World
{
    Heroe heroe;
    int cont, contZ;
    int frecuencia = 200;
    int ZONA1 = 120,
    ZONA2 = 200,
    ZONA3 = 280,
    ZONA4 = 360,
    ZONA5 = 440;
    int entrada = 0, cont2 = 0;
    private List<Zombie> listaZombie = new ArrayList<Zombie>();
    private List<Zombie> listaZombieAt = new ArrayList<Zombie>();
    private List<Bala> listaBala = new ArrayList<Bala>();
    private List<Item> listaItem = new ArrayList<Item>();
  
    /**
     * inicializa el mundo, muestra los objetos que siempre estaran ahi.
     */
    public Juego()
    {    
        super(1100, 600, 1); 
        heroe = new Heroe();       
        BarricadaIcono barrera = new BarricadaIcono();
        LaserIcono laser = new LaserIcono();
        MinaIcono mina = new MinaIcono();
        addObject(barrera, 50, 50);
        addObject(laser, 150, 50);
        addObject(mina, 250, 50);
        addObject(heroe, 300, ZONA3);
    }
    /**
     * verifica que el jugador este con vida, y al mismo tiempo genera zombies para jugar
     */
    public void act()
    {
        aleatorioDeZombie();
        for(int i = 0; i < getHeight(); i++)
        {
            listaZombieAt = getObjectsAt(5, i, Zombie.class);
            if(listaZombieAt != null)
            {
                heroe.quitaVida(20);
            }
        }
        if(heroe.vida < 0)       
        {            
            removeObject(heroe);
            listaZombie = getObjects(Zombie.class);
            listaBala = getObjects(Bala.class);
            listaItem = getObjects(Item.class);
            removeObjects(listaZombie);
            removeObjects(listaItem);
            removeObjects(listaBala);
            setBackground("GAME OVER.png");
        }        
    }
    /**
     *genera aleatoriamente un tipo de zombie y lo coloca en una de las 5 secciones horizontales tambien de manera aleatoria.
     *dependiendo el numero de zombies que han aparecido, esta funcion aumentara tambien la frecuencia con la que estos apareccen, esto hara la ilusion de niveles 
     *en el juego.
     */
    public void aleatorioDeZombie()
    {
        if(contZ == 10 && entrada == 0 && cont2 > 10)
        {
            frecuencia = 150;
            heroe.aumentaBalas(2);
            heroe.aumentaMunicion(10);
            entrada++;
            cont2 = 0;
        }
        if(contZ == 30 && entrada == 1 && cont2 > 10)
        {
            frecuencia = 125;
            heroe.aumentaBalas(2);
            heroe.aumentaMunicion(20);
            entrada++;
            cont2 = 0;
        }
        if(contZ == 50 && entrada == 2 && cont2 > 10)
        {
            frecuencia = 100;
            heroe.aumentaBalas(2);
            heroe.aumentaMunicion(30);
            entrada++;
            cont2 = 0;
        }
        if(contZ >= 70 && entrada == 3 && cont2 > 10)
        {
            frecuencia = 75;
            heroe.aumentaBalas(2);
            heroe.aumentaMunicion(40);
            entrada++;
            cont2 = 0;
        }
        if(contZ >= 100 && entrada == 4 && cont2 > 10)
        {
            frecuencia = 75;
            heroe.aumentaBalas(2);
            heroe.aumentaMunicion(40);
            entrada++;
            cont2 = 0;
        }
        if(cont > frecuencia)
        {
            int tipoZombie = Greenfoot.getRandomNumber(5);
            int zona = Greenfoot.getRandomNumber(5);
            switch(tipoZombie)
            {
                case 0:
                switch(zona)
                {
                    case 0:
                    ZombieNormal zombieN = new ZombieNormal();
                    addObject(zombieN, 1050, ZONA1);
                    contZ++;
                    break;
                    case 1:
                    ZombieNormal zombieN1 = new ZombieNormal();
                    addObject(zombieN1, 1050, ZONA2);
                    contZ++;
                    break;
                    case 2:
                    ZombieNormal zombieN2 = new ZombieNormal();
                    addObject(zombieN2, 1050, ZONA3);
                    contZ++;
                    break;
                    case 3:
                    ZombieNormal zombieN3 = new ZombieNormal();
                    addObject(zombieN3, 1050, ZONA4);
                    contZ++;
                    break;
                    case 4:
                    ZombieNormal zombieN4 = new ZombieNormal();
                    addObject(zombieN4, 1050, ZONA5);
                    contZ++;
                    break;                    
                }
                cont = 0;
                break;
                case 1:
                switch(zona)
                {
                    case 0:
                    ZombieFuerte zombieF = new ZombieFuerte();
                    addObject(zombieF, 1050, ZONA1);
                    contZ++;
                    break;
                    case 1:
                    ZombieFuerte zombieF1 = new ZombieFuerte();
                    addObject(zombieF1, 1050, ZONA2);
                    contZ++;
                    break;
                    case 2:
                    ZombieFuerte zombieF2 = new ZombieFuerte();
                    addObject(zombieF2, 1050, ZONA3);
                    contZ++;
                    break;
                    case 3:
                    ZombieFuerte zombieF3 = new ZombieFuerte();
                    addObject(zombieF3, 1050, ZONA4);
                    contZ++;
                    break;
                    case 4:
                    ZombieFuerte zombieF4 = new ZombieFuerte();
                    addObject(zombieF4, 1050, ZONA5);
                    contZ++;
                    break;                    
                }
                cont = 0;
                break;
                case 2:
                switch(zona)
                {
                    case 0:
                    ZombieDebil zombieDebil = new ZombieDebil();
                    addObject(zombieDebil, 1050, ZONA1);
                    contZ++;
                    break;
                    case 1:
                    ZombieDebil zombieDebil1 = new ZombieDebil();
                    addObject(zombieDebil1, 1050, ZONA2);
                    contZ++;
                    break;
                    case 2:
                    ZombieDebil zombieDebil2 = new ZombieDebil();
                    addObject(zombieDebil2, 1050, ZONA3);
                    contZ++;
                    break;
                    case 3:
                    ZombieDebil zombieDebil3 = new ZombieDebil();
                    addObject(zombieDebil3, 1050, ZONA4);
                    contZ++;
                    break;
                    case 4:
                    ZombieDebil zombieDebil4 = new ZombieDebil();
                    addObject(zombieDebil4, 1050, ZONA5);
                    contZ++;
                    break;                    
                }
                cont = 0;
                break;
                case 3:
                switch(zona)
                {
                    case 0:
                    ZombieX zombieX = new ZombieX();
                    addObject(zombieX, 1050, ZONA1);
                    contZ++;
                    break;
                    case 1:
                    ZombieX zombieX1 = new ZombieX();
                    addObject(zombieX1, 1050, ZONA2);
                    contZ++;
                    break;
                    case 2:
                    ZombieX zombieX2 = new ZombieX();
                    addObject(zombieX2, 1050, ZONA3);
                    contZ++;
                    break;
                    case 3:
                    ZombieX zombieX3 = new ZombieX();
                    addObject(zombieX3, 1050, ZONA4);
                    contZ++;
                    break;
                    case 4:
                    ZombieX zombieX4 = new ZombieX();
                    addObject(zombieX4, 1050, ZONA5);
                    contZ++;
                    break;                    
                }
                cont = 0;
                break;
                case 4:
                switch(zona)
                {
                    case 0:
                    ZombieXL zombieXL = new ZombieXL();
                    addObject(zombieXL, 1050, ZONA1);
                    contZ++;
                    break;
                    case 1:
                    ZombieXL zombieXL1 = new ZombieXL();
                    addObject(zombieXL1, 1050, ZONA2);
                    contZ++;
                    break;
                    case 2:
                    ZombieXL zombieXL2 = new ZombieXL();
                    addObject(zombieXL2, 1050, ZONA3);
                    contZ++;
                    break;
                    case 3:
                    ZombieXL zombieXL3 = new ZombieXL();
                    addObject(zombieXL3, 1050, ZONA4);
                    contZ++;
                    break;
                    case 4:
                    ZombieXL zombieXL4 = new ZombieXL();
                    addObject(zombieXL4, 1050, ZONA5);
                    contZ++;
                    break;                    
                }
                cont = 0;
                break;
            }
        }
        cont++;
        cont2++;
    }
}
