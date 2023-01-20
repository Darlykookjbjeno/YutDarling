package YUT;

import java.util.ArrayList;
import java.util.Scanner;

public class consoleView implements Vista{

	@Override
	public void welcolme() {
		
		System.out.println("Bienvenido a YutDarling!!!");
	}

	
	@Override
	public int askNumeroJugadores() {
		
		Scanner sc = new Scanner(System.in);
		int nJugadores = -1;
		while(nJugadores < 1 || nJugadores > 4){
			System.out.println("¿Cuantos jugadores  van a jugar? (Debe ser un numero entre 2 y 3)");
			nJugadores = sc.nextInt();
		}
		return nJugadores;
	}
       
        @Override
	public int askColor(int numJugador, ArrayList<Color> colores) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("El jugador-" + numJugador );
                System.out.println("");
                System.out.println("¿Con que color jugara?");
                System.out.println("");
                
                int n = 1;
                for(Color color: colores) {
                    System.out.println(n+"-"+color.toString());
                    n++;
                }
                
                int opcion = sc.nextInt();
                
		return opcion;
	}

        @Override
        public int askPersonajeJugador() {
		
                
		Scanner sc = new Scanner(System.in);
		System.out.println("-----Elija el personaje que desea ser-----");
                System.out.println("1.lobo\n2.Zorro\n3.Oso");
                System.out.println("");
                int opcion = sc.nextInt();
		return opcion;
	}
	
        @Override
        public void Continuar() {
            
		System.out.println("");
		System.out.println("Pulsa ENTER para tirar el dado.\n");
                
                try{
                    System.in.read();
                }  
                catch(Exception e){}  
        }

        @Override
        public void turnoJugador(Jugador jugadorActual) {
		System.out.println("");
		System.out.println("Turno jugador "+ jugadorActual.tipoJ.toString()+"-"+jugadorActual.color.toString());
	}
}
