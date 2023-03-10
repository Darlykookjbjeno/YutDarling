package YUT;
import java.util.*;


public class Iterador {
    
	private Tablero tablero;
	private int indice;
        
    /*
      Constructor por defecto para crear una instancia de tablero
     */		
	public Iterador() {
		this.tablero = Tablero.crearInstacia();
		this.indice = 0;
	}
	
	public Iterador(int posicion, TipoCasilla tipo) {
		this.tablero = Tablero.crearInstacia();
		if(tipo.equals(TipoCasilla.PASILLO)){
			this.indice = this.tablero.getCasillasBlancas().size() + posicion-1;
		}
		else { 
			this.indice = posicion-1;
		}
		
	}
	
	public ArrayList<Casilla> recorrer(Color color) {
		ArrayList<Casilla> casillas = new ArrayList<Casilla>();
		Casilla casillaActual = null;
		this.indice = 0;
		
		while(hayMas()) {
			casillaActual = siguienteCasilla();
			if(casillaActual.getFichas().size() != 0)
			{	if (casillaActual.getFichas().get(0).getColor().equals(color)) {
					casillas.add(casillaActual);
				}
			}
		}
		
		return casillas;
	}

    /*
     Metodo devuelve la siguiente casilla del tablero. 
     devuelve la siguiente casilla 
    */	
	public Casilla siguienteCasilla() {
		Casilla aux = null;
		int indicePasillo = this.indice-this.tablero.getCasillasBlancas().size()+1;
		int sizeAll = this.tablero.getCasillasBlancas().size()+this.tablero.getPasillo().size();
		
		
		if(this.indice<this.tablero.getCasillasBlancas().size()) {
			aux = this.tablero.getCasillasBlancas().get(this.indice);
		} else if(this.indice>=this.tablero.getCasillasBlancas().size() && this.indice<sizeAll){
			if(indicePasillo<this.tablero.getPasillo().size()) {
				aux = this.tablero.getPasillo().get(indicePasillo);
			}
		}
		this.indice++;
		return aux;
	}
        /*
         Metodo que comprueba si una ficha le quedan casillas por recorrer
         devuelve un booleano indicando si quedan más casillas por recorrer 
        */	
        
	public boolean hayMas() {
		boolean haymas;
		int sizeAll = this.tablero.getCasillasBlancas().size()+this.tablero.getPasillo().size();
		if(this.indice<sizeAll-1) {
			haymas = true;
		} else {
			haymas = false;
			this.indice = -1;
		}
		return haymas;
	}
}
