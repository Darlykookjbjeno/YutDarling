package YUT;



public class FabricaFichasAzul implements FabricaAbstractaFichas{
    
    //sobreescritura de metodos
	@Override
	public Ficha crearFicha() {
		Color c1 = Color.AZUL;
		Ficha f1 = new Ficha(c1);
		return f1;
	}
}
