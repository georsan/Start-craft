import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Healthcenter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Healthcenter extends Actor
{
    private int celdasSanacion;
    /**
     * Act - do whatever the Healthcenter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Healthcenter() 
    {
        celdasSanacion = 20;
    }
    /**
     * Disminuye la cantidad de celdas de sanacion que hay en el healthcenter
     */
    public void setCeldasSanacion()
    {
        celdasSanacion -= 1;
    }  
}
