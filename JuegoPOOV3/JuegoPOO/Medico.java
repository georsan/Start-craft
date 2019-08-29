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
        curar();
        super.act();
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
        if(getWorld() != null)
        {
            Tribu act = (Tribu) getOneObjectAtOffset(0,0,Tribu.class);
            if(act != null && act.getTribu() == getTribu())
            {
                if(getTribu() == "Protoss")
                {
                    if(act.getEnergia() <= 145)
                    {
                        if(poderDeSanacion >= 20)
                        {
                            act.setEnergia(15);
                            poderDeSanacion -=20;
                        }
                    }
                    else
                    {
                        int a = 160 - act.getEnergia();
                        act.setEnergia(a);
                    }
                }
                else if (getTribu() == "Zerg")
                {
                    if(act.getEnergia() <= 135)
                        {
                            if(poderDeSanacion >= 20)
                            {
                                act.setEnergia(25);
                                poderDeSanacion -= 20;
                            }
                        }
                        else
                        {
                            int a = 160 - act.getEnergia();
                            act.setEnergia(a);
                        }
                }
            }
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
            super.setLocation(oldX, oldY);
            turn(180);
        }
    }    
}
