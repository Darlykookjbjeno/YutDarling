package YUT;


public class FabricaFichasNegras implements FabricaAbstractaFichas{

	@Override
	public Ficha crearFicha() {
		Color c1 = Color.Negro;
		Ficha f1 = new Ficha(c1);
		return f1;
	}
}
