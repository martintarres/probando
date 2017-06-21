import javax.swing.*;
import java.util.Observable;

class ClaseObservador extends Observable {
	private int contentPaneSeleccionado;
	private JPanel panel;
	/*public JButton boton;*/
	
	ClaseObservador(){
		
	}

	void setPanel(int contentPaneSeleccionado){					// Este metodo sirve para setear
		this.contentPaneSeleccionado=contentPaneSeleccionado;			//	el panel que estamos viendo actualmente
		setChanged();													// y notifica a los observers
	    notifyObservers();
	
	}
	
	int getPanelSeleccionado() {								// Se pasa un entero para saber a que
																	// panel nos estamos refiriendo
		return contentPaneSeleccionado;
	}	//

	void setVista(JPanel panel) {							// en los observers se carga el panel que vamos a ver

		this.panel=panel;

	}
	JPanel getVista(){
		//notifyObservers();
		return panel;
		
	}


}
