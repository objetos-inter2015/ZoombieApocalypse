import greenfoot.*;
import java.util.*;

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    BotonAyuda botonA;
    BotonJugar botonJ;
    Boton boton;
    BotonRecords botonR;
    //private List<String> lista = new ArrayList<String>();
    /**
     * Cuando el usuario muere, cambia a la pantalla de game over y verifica el click a los botones
     * 
     */
    public GameOver()
    {    
        
        super(1100, 600, 1); 
        botonA = new BotonAyuda();
        botonJ = new BotonJugar();
        boton = new Boton();
        botonR = new BotonRecords();
        addObject(boton, 120, 500);
        addObject(botonJ, 400, 500);
        addObject(botonR, 680, 500);
        addObject(botonA, 940, 500); 
        
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(boton))
        {
            MenuPrincipal menu = new MenuPrincipal();
            Greenfoot.setWorld(menu);
        }
        if(Greenfoot.mouseClicked(botonA))
        {
            Ayuda ayuda = new Ayuda();            
            Greenfoot.setWorld(ayuda);
        }
        if(Greenfoot.mouseClicked(botonJ))
        {
            Juego jugar = new Juego();            
            Greenfoot.setWorld(jugar);
        }
        if(Greenfoot.mouseClicked(botonR))
        {
            Records record = new Records();            
            Greenfoot.setWorld(record);
        }
    }
}
