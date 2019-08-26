import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Medico here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Medico extends Tribu
{
    private int poderDeSanacion;
    private int posX,posY;
    
    /**
     * Act - do whatever the Medico wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Medico(String tribu) 
    {
        super(tribu);
        poderDeSanacion = 120;
    }
    
    public void act()
    {
        actualizarPosicion();
        curar();
    }
    /**
     * Depende de la tribu a la que pertenezca el medico tendra un aspecto diferente
     */
    public void setTribu()
    {
        if(getTribu() == "Protoss")
        {
            GreenfootImage Imagen = new GreenfootImage("medic.png");
            setImage(Imagen);
        }
        else
        {
            GreenfootImage Imagen = new GreenfootImage("medic2.png");
            setImage(Imagen);
        }
    }
    
    /**
     * Este metodo establece cuanto cura el medico de cada Tribu
     */
    public void curar()
    {
        //Si es de la tribu de los Protoss curara 15 de energia a los de su tribu
        
        if(getTribu() == "Protoss")
        {
            if(getTribu() == "Protoss")
            {
                if(getWorld() != null)
                {
                    Tribu act = (Tribu) getOneObjectAtOffset(0,0,Tribu.class);
                    if(act != null && act.getTribu() != getTribu())
                    {
                        if(act.getEnergia() <= 145)
                        {
                            act.setEnergia(15);
                        }
                        else
                        {
                            int a = act.getEnergia() - 160;
                            act.setEnergia(a);
                        }
                    }
                }
            }
            
            // Si es de la tribu Zerg curara un total de 25 de energia a los de su tribu.
            else if (getTribu() == "Zerg")
            {
                if(getWorld() != null)
                {
                    Tribu act = (Tribu) getOneObjectAtOffset(0,0,Tribu.class);
                    if(act != null && act.getTribu() != getTribu())
                    {
                        if(act.getEnergia() <= 135)
                        {
                            act.setEnergia(25);
                        }
                        else
                        {
                            int a = act.getEnergia() - 160;
                            act.setEnergia(a);
                        }
                    }
                }
            }
        }
    }
    /**
     * Este metodo determina el movimiento de los medicos en el campo de batalla.
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
}
