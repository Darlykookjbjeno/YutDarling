package YUT;

import java.util.*;


public class Jugador {
	public Color color;
	public Iterador iterador;
	public int fichasEnJuego;
	public ITipoJugador tipoJugador;
	public tipo tipoJ;

        /*
          Constructor de la clase Jugador
          @param c1 indica el color del jugador
        */	
            public Jugador(Color c1){
                    this.color = c1;
                    this.iterador = new Iterador();
            }


            public void JugadorOso(){
                       tipoJ = tipo.lobo;
                       ITipoJugador jugadorlobo = new JugadorOso();
                       setTipoJugador(jugadorlobo);
            }  
            public void JugadorZorro(){
                        tipoJ = tipo.zorro;
                        ITipoJugador jugadorzorro = new JugadorZorro();
                        setTipoJugador(jugadorzorro);
            }

            public void JugadorLobo(){
                        tipoJ = tipo.oso;
                ITipoJugador jugadoroso = new JugadorLobo();
                setTipoJugador(jugadoroso);
            }
    

            public void Mover(){
                String descripcion = this.tipoJugador.ObtenerDescripcion();
                System.out.println("Tipo de jugador que se mueve " + descripcion);
            }
	
        /*
         Metodo que devuelve el color de un jugador
         retorna el color del jugador
        */
            public Color getColor() {
                    return color;
            }
	
        /*
         Metodo que devuelve las casillas que contienen fichas del color del jugador
         retorna las casillas con ficha de un color
        */
        
            public ArrayList<Casilla> getCasillasConFichas() {
                    return this.iterador.recorrer(this.color);
            }

        /*
         Metodo que imprimme por consola la posicion de las fichas de un jugador
        */
        
            public void imprimirLocalizacionFichasJugador() {
                    ArrayList<Casilla> listaFichasJugador = getCasillasConFichas();
                    this.fichasEnJuego = listaFichasJugador.size();
                    Vista.mostrarFichasEnJuego(listaFichasJugador , fichasEnJuego);

            }

        /*
            Metodo que pregunta al jugador que ficha quiere mover y devuelve la ficha elegida 
            devuelve la ficha elegida por el jugador 
        */	
            public int eleccion(){
                    return this.tipoJugador.eleccion(this.color, this.fichasEnJuego);
            }
                
        /*
            Metodo que obtiene las fichas en juego
            retorna las fichas que se encuentran en juego
        */
            public int getFichasEnJuego() {
                    return fichasEnJuego;
            }

        /*
            Metodo que establece el numero de fichas en juego
            El parametro fichasEnJuego cantidad de fichas que existen en el juego
        */
            public void setFichasEnJuego(int fichasEnJuego) {
                    this.fichasEnJuego = fichasEnJuego;
            }

            public ITipoJugador getTipoJugador() {
                    return tipoJugador;
            }

            public void setTipoJugador(ITipoJugador tipoJugador) {
                    this.tipoJugador = tipoJugador;
            }
}

enum tipo {
	lobo,
	zorro,
        oso
};
