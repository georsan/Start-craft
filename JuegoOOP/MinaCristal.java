import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MinaCristal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinaCristal extends Actor
{
    public int energia;
    /**
     * Generar un valor aleatorio de energia entre 100 y 400;
     */
    public MinaCristal()
    {
        energia = Greenfoot.getRandomNumber(400-100+1);
    }
    
    /**
     * Disminuye la cantidad de energia de la mina.
     */
    public void Recolecta()
    {
        if (energia >= 20)
        {
            energia -= 20;
        }
    }
}
