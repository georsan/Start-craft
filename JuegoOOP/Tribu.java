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
    private int direccion;
    
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
            ChocaDeposito();
        }
    }
    
    public Tribu(String tribu)
    {
        this.tribu = tribu;
        this.energia = 100;
    }

    /**
     * Chequear la energia de todos los miembros de una tribu
     */
    public boolean checkEnergia()
    {
        if(energia == 0 || energia <0)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Si un personaje pasa por un Deposito, tomara energia de dicha estructura
     */
    public  void  ChocaDeposito(){   
        Deposito act = (Deposito) getOneObjectAtOffset(0,0,Deposito.class);
        if( act != null){            
            if( energia <=140 && act.getCristales() >= 20){
                setEnergia(20);
                act.setCristales(-20);
            }
            else if( energia <= 140 &&  act.getCristales() > 0 && act.getCristales() < 20){
                setEnergia(act.getCristales());
                act.setCristales(-act.getCristales());
            }
        }
    }
    
    /**
     * Suma energia a la Tribu
     */
    
    public void setEnergia(int x)
    {
        energia = energia + x;
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
