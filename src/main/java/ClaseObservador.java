import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ClaseObservador extends Observable {
	public int contentPaneSeleccionado;
	public JPanel panel;
	public JButton boton;
	
	public ClaseObservador(){
		
	}
	
	public void setPanel(int contentPaneSeleccionado){					// Este metodo sirve para setear
		this.contentPaneSeleccionado=contentPaneSeleccionado;			//	el panel que estamos viendo actualmente
		setChanged();													// y notifica a los observers
	    notifyObservers();
	
	}
	
	public int getPanelSeleccionado() {								// Se pasa un entero para saber a que
																	// panel nos estamos refiriendo
		return contentPaneSeleccionado;
	}	//

	public void setVista(JPanel panel) {							// en los observers se carga el panel que vamos a ver

		this.panel=panel;

	}
	public JPanel getVista(){
		//notifyObservers();
		return panel;
		
	}
	
	public void setBoton(JButton boton){
			this.boton=boton;
	}
	
	public JButton getBoton(){
		return boton;
	}
	
	
	

	
	

}
