package YUT;
import java.util.Date;
import java.util.Random;



public class Dado {
	private static Dado instanciaDado = null;
	Random random;
		
		private Dado() {
			random = new Random();
			random.setSeed(new Date().getTime());
		}
		
		public static Dado crearDado() {
			if(instanciaDado == null) {
				instanciaDado = new Dado();
			}
			return instanciaDado;
		}
		
/**
* Metodo para obtener un numero aleatorio 
* @return devuelve un numero aleatorio entre 1 y 6
*/	
                
                
 /*public char tirarDado() {
     
     
        String alphabet = "XO-";
 
        Random r = new Random();
        Random s = new Random();
        Random t = new Random();
        Random u = new Random();
        
        char c = (char)alphabet.charAt(r.nextInt(alphabet.length()));     
        char d = (char)alphabet.charAt(s.nextInt(alphabet.length())); 
        char e = (char)alphabet.charAt(t.nextInt(alphabet.length())); 
        char f = (char)alphabet.charAt(u.nextInt(alphabet.length())); 
        
	Vista.resultadoDado(c,c);
        
        
        return c;
	
	}*/
      public int tirarDado() {
             int n = random.nextInt(6)+1;
	  Vista.resultadoDado(n);
	  return n;
	}


}


