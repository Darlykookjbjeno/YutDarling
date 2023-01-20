package YUT;

import java.util.Scanner;

public class JugadorZorro implements ITipoJugador{
    public String ObtenerDescripcion()
    {
        return "Jugador Normal";
    }
    
    public int eleccion(Color color, int fichasEnJuego) {
    	return Vista.eleccionFicha(color,fichasEnJuego);
    }
}
