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
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100, 600, 1); 
        botonA = new BotonAyuda();
        botonJ = new BotonJugar();
        boton = new Boton();
        botonR = new BotonRecords();
        addObject(boton, 120, 500);
        addObject(botonJ, 400, 500);
        addObject(botonR, 680, 500);
        addObject(botonA, 940, 500); 
        /*
        lista = UserInfo.getTop(5);
        Iterator<String> it = lista.iterator();
        while(it.hasNext())//recorrido de una lista
        {
            int x = 1;
            showText(x + " " + it, 550 + 20, 300 + (20 * (x - 1)));
            //cad += it.next() + "\n";
        }*/
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
