import greenfoot.*;

/**
 * Contiene el constructor para todos los zombies
 * 
 * @author (Arturo Garcia) 
 * @version (1.0)
 */
public class Zombie extends Actor
{
    int vida, velocidad, daño, puntos;
   
    public Zombie(int v, int vel, int damage, int pts) 
    {
        vida = v;
        velocidad = vel;
        daño = damage;
        puntos = pts;
    }    
}
