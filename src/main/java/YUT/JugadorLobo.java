package YUT;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class JugadorLobo implements ITipoJugador{
	
	
	public String ObtenerDescripcion()
    {
        return "Lobo";
    }
	
	public int eleccion(Color color, int fichasEnJuego) {
		return Vista.eleccionFicha(color, fichasEnJuego);
	}
}
