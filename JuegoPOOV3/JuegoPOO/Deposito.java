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
    private int unidadesGas;
    /**
     * Cantidad inicial de critales acomulados
     * 
     */
    public Deposito() 
    {
        cristalesAcom = 100;
    }    
    public void act()
    {
        generarCristales();
    }
    
    /**
     * Sumar cristales acomulados depende de constructor que pase por el deposito
     */
    public void setCristales(int x)
    {
        cristalesAcom += x;
    }
    
    public void setUnidadesGas(int z)
    {
        unidadesGas += z;
    }
    
    /**
     * Retorna cantidad de cristales que tiene el deposito
     */
    
    public int getCristales()
    {
        return cristalesAcom;
    }
    
    
    /**
     * Este metodo hace que cada 5 unidades que se dejen de gas se genere 20 de cristales, lo que conlleva a una recarga de energia para algun miembro de una tribu
     */
    public void generarCristales()
    {
        if(unidadesGas == 5)
        {
            cristalesAcom += 20;
        }
    }   
}
