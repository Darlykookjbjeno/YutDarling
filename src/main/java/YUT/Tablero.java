package YUT;
import java.util.*;



public class Tablero {
	private static Tablero _instanciaTablero = null;
	//Array de las casillas comunes a todos los jugadores.
        
	private List<Casilla> casillasBlancas;
	//Array de las casillas que se cruzan.
        
	private List<Casilla> pasillo;
	//Numero de fichas que el jugador tiene en juego.
        
	private int fichasEnJuego;
	//Constructor porn defecto que realiza las llamadas
        
	private Tablero() {
		crearBlancas();
		crearPasillo();
		fichasEnJuego = 0;
	}
	//Getters y setters
	
        /*
         Metodo que devuelve el array de los que se cruzan principal
         retorna el array de casillas blancas
        */	
        
        public List<Casilla> getCasillasBlancas() {
                return casillasBlancas;
        }

        
        /*
         Metodo que crea el pasillo de casillas blancas
         El parametro casillasBlancas define el numero de casillas blancas
        */
        
        public void setCasillasBlancas(List<Casilla> casillasBlancas) {
                this.casillasBlancas = casillasBlancas;
        }

        /*
         Metodo que devuelve el array de las celdas de tipo pasillo 
         devuelve celdas de tipo pasillo 
        */	
        
	public List<Casilla> getPasillo() {
		return pasillo;
	}

	/*
	 Metodo que crea el array de tipo pasillo 
         el parametro pasillo define el array de casillas de tipo pasillo 
	*/		
        
	public void setPasillo(List<Casilla> pasillo) {
		this.pasillo = pasillo;
	}
	
	/*
	* Metodo estatico que implementa el patron Singleton haciendo posible la creacion de una instancia
	* de la clase Tablero unicamente si no hay una instancia ya creada
	* devuelve el tablero
	*/		
	public static Tablero crearInstacia() {
		if(_instanciaTablero==null) {
			_instanciaTablero = new Tablero();
		}
		return _instanciaTablero;
	}
	
        /*
         Inicializa el array de las casillas comunes y cambia su tipo en funcion del numero que sea.
        */
	public void crearBlancas() {
		
		casillasBlancas = new ArrayList<Casilla>(20);
		
		for(int i=0; i<20; i++){
			Casilla aux;
			if(i==0) {
				aux = new Casilla(TipoCasilla.SALIDA, i+1); 
			} else if (i== 5 || i==10 || i==15 || i==19){
				aux = new Casilla(TipoCasilla.SEGURO, i+1); 
			} else if (i== 6 || i==11 || i==16 || i==18){
				aux = new Casilla(TipoCasilla.ENTRADA, i+1);
			}else {
				aux = new Casilla(TipoCasilla.NORMAL, i+1); 		
			}
			casillasBlancas.add(aux); 
		}
	}
	
        /*
         Inicializa el pasillo y setea la ultima casilla como meta.
        */	
        
	public void crearPasillo() {
		pasillo = new ArrayList<Casilla>(8);
		for(int i= 0; i<8; i++){
			Casilla aux;
			if(i == 7){
				aux = new Casilla(TipoCasilla.META, i+1);
			}else {
				aux = new Casilla(TipoCasilla.PASILLO, i+1);	
			}
			pasillo.add(aux);
		}
	}

        /*
        Añade una ficha nueva al jugador haciendo uso del patron Factory usando diferentes fabricas en 
        funcion del color de la ficha a crear. 
        */		
	

	public void addFichaAlJuego(Color color) {
		  FabricaAbstractaFichas fabrica;
		  Ficha ficha;
		  
		  switch(color) {
		   case ROJO: 
		    fabrica = new FabricaFichasRoja();
		    ficha = fabrica.crearFicha(); 
		    this.casillasBlancas.get(0).ponerFicha(ficha);
		    break;
		   case Negro:
		    fabrica = new FabricaFichasNegras();
		    ficha = fabrica.crearFicha(); 
		    this.casillasBlancas.get(0).ponerFicha(ficha);
		    break;
		   case AZUL:
		    fabrica = new FabricaFichasAzul();
		    ficha = fabrica.crearFicha(); 
		    this.casillasBlancas.get(0).ponerFicha(ficha);
		    break;
		   
		   default:
		    break;
		  }
		  
		  this.fichasEnJuego++;
		 }


        /*
          Metodo utilizado para mover las fichas.
        */	
	
        
	//posicion por casilla en la que esta la ficha
	//cambiar constructor con posicion y next devuelvo y luego incremento
	public void moverFicha(Ficha ficha, Casilla casillaActual, int nDado){
		Iterador iterator = new Iterador(casillaActual.getPosicionActual(), casillaActual.getTipoCasilla());
		Casilla casillaDestino = null;
		while(iterator.hayMas() && nDado >= 0) {
			casillaDestino = iterator.siguienteCasilla();
			nDado--;
		}
		casillaDestino.ponerFicha(ficha);
		casillaActual.borrarFicha(ficha);
	}
	
	public void moverFicha(Casilla casilla, int nDado){
		Ficha ficha = casilla.getFichas().get(0);
		Iterador iterator = new Iterador(casilla.getPosicionActual(), casilla.getTipoCasilla());
		/*this.casillasBlancas.get(posicion-1+nDado).ponerFicha(ficha);
		this.casillasBlancas.get(posicion-1).borrarFicha(ficha);*/
		
        }
	
	/*
	 Metodo utilizado para borrar las fichas. REVISAR
	*/	
	public void borrarFicha(int posicion) {
		this.casillasBlancas.get(posicion-1).borrarFicha(this.casillasBlancas.get(posicion-1).getFichas().get(0));
	}
	
	public void borrarFicha() {
		this.fichasEnJuego--;
	}
	
        /*
         Metodo utilizado para mover las fichas.
         retorna las fichas que hay en juego
        */	
                public int getFichasEnJuego() {
                        return fichasEnJuego;
                }
        /*
        Metodo utilizado para modificar el numero de fichas en juego
        el parametro fichasEnjuego indica el numero de fichas que hay en juego 
        */	
	public void setFichasEnJuego(int fichasEnJuego) {
		this.fichasEnJuego = fichasEnJuego;
	}
}
