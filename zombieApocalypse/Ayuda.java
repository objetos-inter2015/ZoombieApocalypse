import greenfoot.*;

/**
 * Muestra la pantalla de ayuda para el usuario
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ayuda extends World
{
    BotonAyuda botonA;
    BotonJugar botonJ;
    Boton boton;
    BotonRecords botonR;
    /**
     * Constructor for objects of class Ayuda.
     * 
     */
    public Ayuda()
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
    }
    /**
     * verifica constantemente si el usuario ha dado click a algun boton
     */
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
