public class Main {

	public static void main(String[] args) {

			ClaseObservador observador = new ClaseObservador(); 		/*Aca se crea una clase observador*/
			Modelo modelo = new Modelo();								/* Se crea la clase modelo */
			Vista vista = new Vista(observador);						/* Se crea la clase vista */
			Controlador controlador = new Controlador(modelo, vista);	/* se crea el controlador */
			controlador.iniciar();										/* Se instancia el metodo inciar */
			observador.addObserver(vista);								/* Se agregan los observers de las vistas */



	}
}
