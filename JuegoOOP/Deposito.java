import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Deposito here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Deposito extends Actor
{
    private int cristalesAcom;
    /**
     * Cantidad inicial de critales acomulados
     * 
     */
    public Deposito() 
    {
        cristalesAcom = 100;
    }    
    
    /**
     * Sumar cristales acomulados depende de constructor que pase por el deposito
     */
    public void setCristales(int x)
    {
        cristalesAcom += x;
    }
    
    /**
     * Retorna cantidad de cristales que tiene el deposito
     */
    
    public int getCristales()
    {
        return cristalesAcom;
    }
}
