import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Constructor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Constructor extends Tribu
{
    private int cristalMinado;
    private int gas;
    private int posX;
    private int posY;
    /**
     * Act - do whatever the Constructor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Constructor(String Tribu) 
    {
        super(Tribu);
        cristalMinado = 50;
        gas = 30;
    }
    
    public void act()
    {
        pasaMina();
        pasaDeposito();
        super.act();
    }
    
    /**
     * Si un constructor pasa por un yacimiento de gas, cargara 10 unidades de este.
     */
    public void pasaYacimientoGas()
    {
        YacimientoGas act = (YacimientoGas) getOneObjectAtOffset(0,0,YacimientoGas.class);
        if(act!= null)
        {
            gas += 10;
        }
    }
    
    /**
     * Este metodo asegura que si algun constructor pasa por el deposito, dejara la carga que lleva de gas o cristales.
     */

    public void pasaDeposito()
    {
        if(getTribu() == "Protoss")
        {
            Deposito act = (Deposito) getOneObjectAtOffset(0,0,Deposito.class);
            if(act != null)
            {
                if((cristalMinado >= 35 && gas >= 10) || (cristalMinado >= 35 || gas >= 10))
                {
                    act.setCristales(35);
                    act.setUnidadesGas(10);
                    cristalMinado -= 35;
                }
                else
                {
                    act.setCristales(cristalMinado);
                    act.setUnidadesGas(gas);
                    gas = 0;
                    cristalMinado = 0;
                }
            }
        }
        else if(getTribu() == "Zerg")
        {
            Deposito act = (Deposito) getOneObjectAtOffset(0,0,Deposito.class);
            if(act != null)
            {
                if(cristalMinado >= 45 && gas >= 10 || (cristalMinado >= 45 || gas >= 10))
                {
                    act.setCristales(45);
                    cristalMinado -= 45;
                }
                else
                {
                    act.setCristales(cristalMinado);
                    act.setUnidadesGas(gas);
                    gas = 0;
                    cristalMinado = 0;
                }
            }
        }
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
    
    /**
     * Cuando un constructor pasa por la mina de cristal, recolecta una cantidad de cristales
     */
    public void pasaMina()
    {
        if(getWorld() != null)
        {
            MinaCristal act = (MinaCristal) getOneObjectAtOffset(0,0,MinaCristal.class);
            if(act != null)
            {
                act.recolecta();
                cristalMinado += 20;
            }
        }
    }
}
