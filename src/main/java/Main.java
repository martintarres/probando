public class Main {

	public static void main(String[] args) throws Exception {

			ClaseObservador observador = new ClaseObservador(); 		/*Aca se crea una clase observador*/
			Modelo modelo = new Modelo();								/* Se crea la clase modelo */
			Vista vista = new Vista(observador);						/* Se crea la clase vista */
			Controlador controlador = new Controlador(modelo, vista);	/* se crea el controlador */
		try {
			controlador.iniciar();										/* Se instancia el metodo inciar */
		} catch (Exception e) {
			e.printStackTrace();
		}
		observador.addObserver(vista);								/* Se agregan los observers de las vistas */
	}
}
