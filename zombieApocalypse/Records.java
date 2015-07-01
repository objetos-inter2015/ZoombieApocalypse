import greenfoot.*;
import java.util.*;

/**
 * Write a description of class Records here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Records extends World
{
    BotonAyuda botonA;
    BotonJugar botonJ;
    Boton boton;
    BotonRecords botonR;
    private List<UserInfo> lista = new ArrayList<UserInfo>();
    /**
     * Constructor for objects of class Records.
     * 
     */
    public Records()
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
        int x = 1;
        Iterator<UserInfo> it = lista.iterator();
        while(it.hasNext())//recorrido de una lista
        {
            showText(x + " " + String.valueOf(it.next()), 550, 300 + (20 * (x - 1)));
            //cad += it.next() + "\n";
        }*/
        addObject(new ScoreBoard(400, 400), getWidth() / 2 - 100, getHeight() / 2 - 30);
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
