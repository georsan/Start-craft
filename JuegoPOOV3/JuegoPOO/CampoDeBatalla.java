import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
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
    GreenfootImage imagen;
    int x = 0;
    int y = 0;
    
    /**
     * Constructor de CampoDeBatalla
     */
    public CampoDeBatalla()
    {
        super(900, 700, 1);
        /* Create a new world with 600x400 cells with a cell size of 1x1 pixels.*/
        crearPersonajes();
        act();
    }
    
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
            do{
                x = Greenfoot.getRandomNumber(getWidth());
                y = Greenfoot.getRandomNumber(getHeight());
                Objeto = getObjectsAt(x, y, Actor.class);
            }while(!Objeto.isEmpty());
            YacimientoGas yacimiento = new YacimientoGas();
            addObject(yacimiento,x,y);
            do{
                x = Greenfoot.getRandomNumber(getWidth());
                y = Greenfoot.getRandomNumber(getHeight());
                Objeto = getObjectsAt(x, y, Actor.class);
            }while(!Objeto.isEmpty());
            Healthcenter bunker = new Healthcenter();
            addObject(bunker,x,y);
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
            if (Objeto.isEmpty())
            {
                //Esto if(k%2==0) es para crear personajes de cada una de las tribus,al ser solo dos tribus el modulo solo tendra 2 valores posibles y creara actores para las dos tribus
                if (k%2==0)
                {
                    //crear los guerreros de la tribu Protoss
                    Guerrero guerrero = new Guerrero("Protoss");
                    addObject(guerrero, x, y);
                    guerrero.setTribu();
                    do
                    {
                        x = Greenfoot.getRandomNumber(getWidth());
                        y = Greenfoot.getRandomNumber(getHeight());
                        Objeto = getObjectsAt(x, y, Actor.class);
                    }while(!Objeto.isEmpty());
                    //crear los medicos de la tribu Protoss
                    Medico medico = new Medico("Protoss");
                    addObject(medico, x, y);
                    medico.setTribu();
                    do
                    {
                        x = Greenfoot.getRandomNumber(getWidth());
                        y = Greenfoot.getRandomNumber(getHeight());
                        Objeto = getObjectsAt(x, y, Actor.class);
                    }while(!Objeto.isEmpty());
                    //Solo creara personajes en un espacio del campo de batalla que este vacio.
                    if(Objeto.isEmpty())
                    {
                        //crear los constructores de la tribu Protoss
                        Constructor constructor = new Constructor("Protoss");
                        addObject(constructor, x, y);
                        constructor.setTribu();
                    }
                }
                else{
                    //crear los guerreros de la tribu Zerg
                    Guerrero guerrero = new Guerrero("Zerg");
                    addObject(guerrero, x, y);
                    guerrero.setTribu();
                    do
                    {
                        x = Greenfoot.getRandomNumber(getWidth());
                        y = Greenfoot.getRandomNumber(getHeight());
                        Objeto = getObjectsAt(x, y, Actor.class);
                    }while(!Objeto.isEmpty());
                    //crear los medicos de la tribu Zerg
                    Medico medico = new Medico("Zerg");
                    addObject(medico, x, y);
                    medico.setTribu();
                    do
                    {
                        x = Greenfoot.getRandomNumber(getWidth());
                        y = Greenfoot.getRandomNumber(getHeight());
                        Objeto = getObjectsAt(x, y, Actor.class);
                    }while(!Objeto.isEmpty());
                    //crear los constructores de la tribu Zerg
                    Constructor constructor = new Constructor("Zerg");
                    addObject(constructor, x, y);
                    constructor.setTribu();
                }
            }
        }
    }
    
    /**
     * Este metodo recorre las casillas del campo de batalla, si encuentra dos actores de diferentes tribus
     * llama al metodo batalla(), el cual decide el resultado de dicha pelea.
     */
    public void checkBatalla()
    {
        List<Tribu> listaElementos;
        //los for son para recorrer cada casilla del mundo y sacar los objetos de Tribu que tienen.
        for(int i = 0; i<= getHeight()-10; i++){
            for( int j = 0; j<= getWidth()-10; j++){  
                Tribu A = null;
                Tribu R = null;
                // este me devuelve una lista de los objetos que hay en cada casilla
                listaElementos = getObjectsAt(j, i, Tribu.class);
                // aqui checkea si hay dos o mas elementos en la lista, porque si no no hay pelea;
                if(listaElementos.size() >= 2){
                    // Este for me recorre la lista y guarda cada elemento en una variable temporal T1
                    for(Tribu T1 : listaElementos)
                    {
                        if( T1.getTribu()=="Protoss"){
                            A = T1;
                        }
                        if( T1.getTribu()=="Zerg"){
                            R = T1;
                        }
                    }
                    //Si son de diferentres tribus llama al metodo batalla()
                    if( A != null && R != null){
                        batalla(A,R);
                    }
                }
            }
        }
    }
    
    
    /**
     * Este metodo revisa el rol de los actores que se encuentren en la misma casilla del campo
     * de batalla para establecer una especie de probabilidad que tienen de ganar o perder la pelea
     */
    public void batalla(Tribu A, Tribu R)
    {
        int a = Greenfoot.getRandomNumber(100);
        if( A instanceof Guerrero && R instanceof Guerrero)
        { 
            if( a < 50){
                A.setEnergia(-10);
            }
            else if (a>50){
                R.setEnergia(-10);
            }         
        }
        else if( A instanceof Guerrero && R instanceof Medico || A instanceof Guerrero && R instanceof Constructor  ){            
            if( a < 70){
                R.setEnergia(-10);
            }
            else if (a>70){
                //A.setEnergia(-20);
            }
        }
        else if( A instanceof Medico && R instanceof Guerrero || A instanceof Constructor && R instanceof Guerrero  ){           
            if( a < 70){
                A.setEnergia(-10);
            }
            else if (a>70){
                //R.setEnergia(-20);
            }
        }
    }
    
    /**
     * act del campo de batalla
     */
    public void act()
    {
        checkBatalla();
    }
}
