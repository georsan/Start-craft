import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Constructor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Constructor extends Tribu
{
    private int nivelEnergia;
    private int posX;
    private int posY;
    /**
     * Act - do whatever the Constructor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Constructor(String Tribu) 
    {
        super(Tribu);
        nivelEnergia = 100;
    }
    public void act()
    {
        actualizarPosicion();
    }
    
    /**
     * Este metodo determina el movimiento de los constructores.
     */
    public void actualizarPosicion()
    {
        posX = getX();
        posY = getY();
        
        //Si se presiona la tecla p + teclas de movimiento se moveran solo los Protoss
        if (Greenfoot.isKeyDown("p"))
        {
            if(getTribu() == "Protoss")
            {
                if(Greenfoot.isKeyDown("left"))
                posX -= 10;
                if(Greenfoot.isKeyDown("right"))
                posX += 10;
                if(Greenfoot.isKeyDown("down"))
                posY += 10;
                if(Greenfoot.isKeyDown("up"))
                posY -= 10;
            }
            //Se actualiza el movimiento de x y y en el campo de batalla
            setLocation(posX, posY);
        }
        //Si se presiona la tecla z + teclas de movimiento se moveran solo los Zerg
        else if(Greenfoot.isKeyDown("z"))
        {
            if(getTribu() == "Zerg")
            {
                if(Greenfoot.isKeyDown("left"))
                posX -= 10;
                if(Greenfoot.isKeyDown("right"))
                posX += 10;
                if(Greenfoot.isKeyDown("down"))
                posY += 10;
                if(Greenfoot.isKeyDown("up"))
                posY -= 10;
            }
        }
        //Se actualiza el movimiento en x y y en el campo de batalla
        setLocation(posX,posY);    
    }
    
    /**
     * Depende de la tribu a la que pertenezca el constructor tendra un aspecto diferente
     */
    
    public void setTribu()
    {
        if(getTribu() == "Protoss")
        {
            GreenfootImage Imagen = new GreenfootImage("worker.png");
            setImage(Imagen);
        }
        else
        {
            GreenfootImage Imagen = new GreenfootImage("worker2.png");
            setImage(Imagen);
        }
    }
    
    
}
