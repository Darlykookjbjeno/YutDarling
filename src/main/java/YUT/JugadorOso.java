package YUT;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class JugadorOso implements ITipoJugador{
	
	
	public String ObtenerDescripcion()
    {
        return "Oso";
    }
	
	public int eleccion(Color color, int fichasEnJuego) {
		return Vista.eleccionFicha(color, fichasEnJuego);
	}
}

