import greenfoot.*;

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
