package YUT;

import java.util.ArrayList;

import java.util.Scanner;

public interface Vista {

    
	public void welcolme();
        
        public int askNumeroJugadores();
        
        public int askColor(int numJugador, ArrayList<Color> colores);

	public int askPersonajeJugador();
        
        public void Continuar();
        
        public void turnoJugador(Jugador jugador);
        
        public static int eleccionFicha(Color color, int fichasEnJuego) {
                System.out.println("");
		System.out.println("¿Cual quieres mover?" + "-" + color.toString());
		Scanner scc = new Scanner(System.in);
		int i = scc.nextInt();
                    if (i <= fichasEnJuego) {
                            System.out.println("Jugador-" + color);
                            System.out.println("- muevo la ficha numero: " + i);
                            return i;
                    } else {
			return 0;
                    }
	}
        
        

	public static void resultadoDado(int result) {
		System.out.println("Has sacado:" + result);
                System.out.println("");
                System.out.println("");
	}
        
        
        public static void mostrarFichasEnJuego(ArrayList<Casilla> listaFichasJugador , int size){
		for(int i = 0; i < listaFichasJugador.size(); i++) {
			System.out.println("Ficha " + (i+1) + " en casilla: " + listaFichasJugador.get(i).getPosicionActual() + "\n");
		
                }
	}
}