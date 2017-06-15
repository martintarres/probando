
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

	/*
	Esta es la clase vista, que contiene el JFrame , y de acuerdo a lo que nuestros observers nos indican,
	se va cargando el jpanel de acuerdo a la vista que querramos ver.
	 */

public class Vista extends JFrame implements Observer {

	
	ClaseObservador miObservador;
	
	int seleccion;
	VistaPrincipal vistaprincipal;
	VistaListaReproduccion vistalistareproduccion;
		
		public Vista(ClaseObservador observador){
			miObservador=observador;
		
			
			setTitle("Reproductor Musical");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			setVisible(true);
			
			vistaprincipal= new VistaPrincipal(miObservador);			// creo el objeto vistaPrincipal
			miObservador.addObserver(vistaprincipal);
			
			vistalistareproduccion = new VistaListaReproduccion(miObservador);		// creo el objeto vistaListaReproduccion
			miObservador.addObserver(vistalistareproduccion);
			
			miObservador.setVista(vistaprincipal.contentPane);						// aca le digo que la vista con la que
			setContentPane(miObservador.getVista());								// mi programa empieza sea la principal
		
			setVisible(true);
			
			
		}
	
	/*
		Este metodo es el que me actualiza el JFrame con el JPanel que mis observers me avisan
		que yo quiero ver
	 */
	
	@Override
	public void update(Observable o, Object arg) {
		/*seleccion=miObservador.getPanelSeleccionado();
	//	seleccion=miObser.getPanelSeleccionado();
		System.out.println("en vista me llego " +seleccion  );*/
		if(seleccion == 0 ){
	
			setContentPane(miObservador.getVista());
			miObservador.setVista(miObservador.getVista());
			setVisible(true);
		}
		
		setContentPane(miObservador.getVista());

		}
	
}
		
	


