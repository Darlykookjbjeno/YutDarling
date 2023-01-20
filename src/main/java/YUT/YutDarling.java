package YUT;
import javax.sound.midi.SysexMessage;
import java.io.*;
import java.util.*;


public class YutDarling {
	
	private Tablero tablero;
        private int nJugadores;
	private Jugador jugadorActual;
        private ArrayList<Jugador> jugadores;
	private Dado dado;
	private Iterador iterator;
	private int resultadoDado;
	private int cantidadDe6;
	private Vista vista;
	
	/*
	  Constructor por defecto de la clase YutDarling.
	 */
	
	public YutDarling() {
		tablero = Tablero.crearInstacia();
		dado = Dado.crearDado();
		this.iterator = new Iterador();
                this.jugadores = new ArrayList();
                this.vista = new consoleView();
	}
	
	
	/*
	  Metodo para añadir jugadores a la partida
	  El método pide por  consola el color que cada jugador quiera
	 */
        
    public void addJugadores() {
    	vista.welcolme();
        Scanner sc = new Scanner(System.in);
        nJugadores = vista.askNumeroJugadores();
        ArrayList<Color> colores = new ArrayList<Color>(Arrays.asList(Color.values()));
        
        for(int i = 0; i < nJugadores; i++) {
            Jugador jugador = null;
            int j = i+1;
            
            int opcion = vista.askColor(j, colores);
            int n = 1;
            for(Color color: colores) {
                if(n==opcion) {
                    jugador = new Jugador(color);
                    colores.remove(color);
                    break;
                }
                n++;
            }
            
            opcion = vista.askPersonajeJugador();
            if(opcion == 1) {
                jugador.JugadorLobo();
            } else if (opcion == 2) {
                jugador.JugadorZorro();
            }else if(opcion == 3){
                jugador.JugadorOso();
            }
            
            jugadores.add(jugador);
        }
    }
	/*
	  Bucle principal del juego en el cual se suceden las tiradas del dado y se piden 
	  por consola las decisiones que el jugador puede tomar. 
	 */
	
	public void play() {
		ArrayList<Casilla> listaCasillasConFichas;
		
		while(!end()) {
                    for(Jugador jugador: jugadores) {
                        jugadorActual = jugador;
                   //88-x  79=o  45-
                         vista.turnoJugador(jugadorActual);

                            Scanner sc = new Scanner(System.in);
                            vista.Continuar();
                            resultadoDado = dado.tirarDado();


                            if(this.tablero.getFichasEnJuego() <= 2){
                                this.tablero.addFichaAlJuego(jugadorActual.getColor());

                            }else{
                                listaCasillasConFichas = this.iterator.recorrer(jugadorActual.getColor());
                                if(listaCasillasConFichas.size() > 0){
                                    jugadorActual.imprimirLocalizacionFichasJugador();

                                    int eleccion = this.jugadorActual.eleccion();
                                    this.tablero.moverFicha(listaCasillasConFichas.get(eleccion-1).getFichas().get(0), listaCasillasConFichas.get(eleccion-1), resultadoDado);
                                }
                            } 
                    }
                }
        }
 

	/*
	  Función que comprueba si el jugador ha ganado 
	 */
	
	public boolean end() {
		
		if(this.tablero.getPasillo().get(7).getFichas().size() == 4) {
			System.out.println();
			return true;
		}else{
			return false;
		}
	}
}


