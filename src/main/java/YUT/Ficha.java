package YUT;


public class Ficha {
	private Color color;

    /*	 
      Constructor de Ficha que recibe el color de la misma ficha por parametro
       El parámetro c1 define de que color va a ser la ficha
     */		
        public Ficha(Color c1){
                this.color = c1;
        }

    /*	 
      Metodo que devuelve el color de la ficha
      retorna el color de la ficha
    */		
	public Color getColor() {
		return color;
	}
}

enum Color{
	Negro,
	ROJO,
	AZUL
}