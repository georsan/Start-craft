import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class CampoDeBatalla here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CampoDeBatalla extends World
{
    List<Actor> Objeto;
    int x = 0;
    int y = 0;
    /**
     * Crear los personajes y estructuras en el campo de batalla.
     */
    public void crearPersonajes()
    {
        List<Actor> Objeto;
        int x = 0;
        int y = 0;
        // Este for es para crear solo 2 estructuras de cada clase
        for (int i = 0;i <= 1;i++) {
            //Este while es para crear una mina de cristal en un sitio del campo de batalla que este vacio
            do{
                x = Greenfoot.getRandomNumber(getWidth());
                y = Greenfoot.getRandomNumber(getHeight());
                Objeto = getObjectsAt(x, y, Actor.class);
            }while(!Objeto.isEmpty());
            MinaCristal cristal = new MinaCristal();
            addObject(cristal,x,y);
            //While para crear obstaculos en un sitio del campo de batalla que este vacio
            do{
                x = Greenfoot.getRandomNumber(getWidth());
                y = Greenfoot.getRandomNumber(getHeight());
                Objeto = getObjectsAt(x, y, Actor.class);
            }while(!Objeto.isEmpty());
            Obstaculo obstaculo = new Obstaculo();
            addObject(obstaculo,x,y);
        }
        //Se creara un solo deposito para las dos tribus
        do{
            x = Greenfoot.getRandomNumber(getWidth());
            y = Greenfoot.getRandomNumber(getHeight());
            Objeto = getObjectsAt(x, y, Actor.class);
        }while(!Objeto.isEmpty());
        Deposito deposito = new Deposito();
        addObject(deposito,x,y);
        
        
        int value = 2;
        for(int k=0; k<value; k++) {
            do{
                x = Greenfoot.getRandomNumber(getWidth());
                y = Greenfoot.getRandomNumber(getHeight());
                Objeto = getObjectsAt(x, y, Actor.class);
            }while(!Objeto.isEmpty());
            if (Objeto.isEmpty()){
                /** Esto if(k%2==0) es para que me cree personajes de una tribu si k es par,
                 * y de la otra si k es impar*/
                if (k%2==0){
                    Guerrero guerrero = new Guerrero("Protoss");
                    addObject(guerrero, x, y);
                    guerrero.setTribu();
                    do{
                        x = Greenfoot.getRandomNumber(getWidth());
                        y = Greenfoot.getRandomNumber(getHeight());
                        Objeto = getObjectsAt(x, y, Actor.class);
                    }while(!Objeto.isEmpty());
                    //Medico medico = new Medico("Protoss");
                    //addObject(medico, x, y);
                    //medico.setTribu();
                    do{
                        x = Greenfoot.getRandomNumber(getWidth());
                        y = Greenfoot.getRandomNumber(getHeight());
                        Objeto = getObjectsAt(x, y, Actor.class);
                    }while(!Objeto.isEmpty());
                    if(Objeto.isEmpty()){
                        //Constructor constructor = new Constructor("Protoss");
                        //addObject(constructor, x, y);
                        //constructor.setTribu();
                    }
                }
                else{
                    Guerrero guerrero = new Guerrero("Zerg");
                    addObject(guerrero, x, y);
                    guerrero.setTribu();
                    do{
                        x = Greenfoot.getRandomNumber(getWidth());
                        y = Greenfoot.getRandomNumber(getHeight());
                        Objeto = getObjectsAt(x, y, Actor.class);
                    }while(!Objeto.isEmpty());
                    //Medico medico = new Medico("Zerg");
                    //addObject(medico, x, y);
                    //medico.setTribu();
                    do{
                        x = Greenfoot.getRandomNumber(getWidth());
                        y = Greenfoot.getRandomNumber(getHeight());
                        Objeto = getObjectsAt(x, y, Actor.class);
                    }while(!Objeto.isEmpty());
                    //Constructor constructor = new Constructor("Zerg");
                    //addObject(constructor, x, y);
                    //constructor.setTribu();
                }
            }
        }
    }

    public CampoDeBatalla()
    {
        super(800, 500, 1);
      
        /* Create a new world with 600x400 cells with a cell size of 1x1 pixels.*/
        crearPersonajes();
        act();
    }
}
