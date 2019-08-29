import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tribu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tribu extends Actor
{
    private String tribu;
    private int energia;
    int zerg;
    int protoss;
    int posX;
    int posY;
    int iter=0;
    boolean terminar=false;
    
    GreenfootImage imagen;
    
    /**
     * Act - do whatever the Tribu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(checkEnergia())
        {
            if(checkEnergia()){
                getWorld().removeObject(this);
                return;
            }
        }
        iteraciones();
        actualizarPosicion();
        ChocaDeposito();
        movimiento();
    }
    /**
     * Este metodo determina el fin del juego por iteraciones.
     */
    public boolean iteraciones()
    {
        if(iter == 1000)
        {
            terminar = true;
            Greenfoot.stop();
        }
        else
        {
            move(10);
            iter ++;
        }
        return terminar;
    }
    
    /**
     * Constructor de Tribu
     */
    
    public Tribu(String tribu)
    {
        this.tribu = tribu;
        this.energia = 1000;
    }
    
    /**
     * Este metodo define el movimiento aleatorio de los miembros de la tribu.
     */
    public void movimiento()
    {
        if(!checkEnergia())
        {
            World m = getWorld();
            if(getX() >= m.getWidth()-20||getX()<=5) 
            {
                turn(180);
                if(Greenfoot.getRandomNumber(100)<90)
                {
                    turn(Greenfoot.getRandomNumber(90-45));
                }
            }
            if (getY()>=m.getHeight()-20||getY()<=5)
            {
                turn(180);
                if(Greenfoot.getRandomNumber(100)<90)
                {
                    turn(Greenfoot.getRandomNumber(90-45));
                }
            }
        }
    }
    
    /**
     * Este metodo define el movimiento por teclado de los miembros de la tribu
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
     * Chequear la energia de los miembros de una tribu
     */
    public boolean checkEnergia()
    {
        if(energia == 0 || energia < 0)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Si un personaje pasa por un Deposito, tomara energia de dicha estructura
     */
    public  void  ChocaDeposito(){
        if(getTribu() == "Protoss")
        {
            Deposito act = (Deposito) getOneObjectAtOffset(0,0,Deposito.class);
            if( act != null){
                if( energia <=135 && act.getCristales() >= 25){
                    setEnergia(25);
                    act.setCristales(-25);
                }
                else if( energia <= 135 &&  act.getCristales() > 0 && act.getCristales() < 20)
                {
                    setEnergia(act.getCristales());
                    act.setCristales(-act.getCristales());
                }
            }
        }
        else if (getTribu() == "Zerg")
        {
            Deposito act = (Deposito) getOneObjectAtOffset(0,0,Deposito.class);
            if( act != null){
                if( energia <= 145 && act.getCristales() >= 15){
                    setEnergia(15);
                    act.setCristales(-15);
                }
                else if( energia <= 145 &&  act.getCristales() > 0 && act.getCristales() < 15)
                {
                    setEnergia(act.getCristales());
                    act.setCristales(-act.getCristales());
                }
            }
        }
    }
    
    /**
     * Suma energia a la Tribu
     */
    
    public void setEnergia(int x)
    {
        energia += x;
    }
    
    /**
     * Devuelve la energia de la tribu.
     */
    public int getEnergia()
    {
        return energia;
    }
    
    /**
     * Retorna la tribu del actor.
     */
    public String getTribu()
    {
        return tribu;
    }
}
