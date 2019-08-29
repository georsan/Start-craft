import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Guerrero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Guerrero extends Tribu
{
    private int posX;
    private int posY;
    
    /**
     * Act - do whatever the Guerrero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Guerrero(String tribu) 
    {
        super(tribu);
    }
    
    public void act()
    {
        super.act();
    }

    
    /**
     * Depende de la tribu a la que pertenezca el guerrero tendra un aspecto diferente
     */
    
    public void setTribu()
    {
        if(getTribu() == "Protoss")
        {
            GreenfootImage Imagen = new GreenfootImage("warrior.png");
            setImage(Imagen);
        }
        else
        {
            GreenfootImage Imagen = new GreenfootImage("warrior2.png");
            setImage(Imagen);
        }
    }
    
    /**
     * Este metodo es para que no se permita moverse atraves de los obstaculos.
     */
    public void setLocation(int x, int y)
    {
        int oldX = getX();
        int oldY = getY();
        super.setLocation(x,y);
        if(!getIntersectingObjects(Obstaculo.class).isEmpty())
        {
            turn(180);
            super.setLocation(oldX, oldY);
        }
    }  
}
