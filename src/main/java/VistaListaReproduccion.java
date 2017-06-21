
														// En esta clase se crea la vista que pertenece a la lista de
import  java.net.URL;									//	reproduccion

import java.awt.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


														public class VistaListaReproduccion extends JFrame implements Observer {

	ClaseObservador miObservador;
	//ClaseObservador miObser;
	int seleccion;
	
	JPanel contentPane;
	List ListaAleatoria;
	JToggleButton BotonAleatorio;
	JButton BotonAdelante;
	JSlider BarraVolumen;
	JButton BotonAtras;
	JButton BotonStop;
	JButton BotonPlay;
	JButton BotonPause;
	JButton BotonVolver;
	JButton BotonBorrar;
	
	public VistaListaReproduccion(ClaseObservador observador) {
		miObservador=observador;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ListaAleatoria = new List();
		ListaAleatoria.setBounds(14, 50, 332, 166);
		contentPane.add(ListaAleatoria);
		
		
		BotonAleatorio = new JToggleButton();
		BotonAleatorio.setBounds(335, 227, 70, 23);
		contentPane.add(BotonAleatorio);
		ImageIcon alea= new ImageIcon(getClass().getResource("alea.png").getPath());
		BotonAleatorio.setIcon(alea);



		BotonAdelante = new JButton(">>");
		BotonAdelante.setBounds(252, 227, 70, 23);
		contentPane.add(BotonAdelante);
		
		BarraVolumen = new JSlider();
		BarraVolumen.setMaximum(141);
		BarraVolumen.setOrientation(SwingConstants.VERTICAL);
		BarraVolumen.setBounds(346, 11, 78, 183);
		contentPane.add(BarraVolumen);
		
		
		BotonAtras = new JButton("<<");
		BotonAtras.setBounds(10, 227, 70, 23);
		contentPane.add(BotonAtras);
		
		
		BotonStop = new JButton("Stop");
		BotonStop.setBounds(172, 227, 70, 23);
		contentPane.add(BotonStop);
		
		BotonPlay = new JButton("Play");
		BotonPlay.setBounds(90, 227, 70, 23);
		contentPane.add(BotonPlay);
		
		BotonVolver = new JButton();
		BotonVolver.setBounds(25, 11, 96, 23);
		contentPane.add(BotonVolver);
		ImageIcon volver= new ImageIcon(getClass().getResource("lista.png").getPath());
		BotonVolver.setIcon(volver);
		
		BotonBorrar = new JButton("Borrar");
		BotonBorrar.setBounds(157, 11, 89, 23);
		contentPane.add(BotonBorrar);
		
		BotonPause = new JButton("||");
		BotonPause.setBounds(90, 227, 70, 23);
	}

	@Override														// Esta es la parte que implementa los observer
	public void update(Observable o, Object arg) {
		seleccion=miObservador.getPanelSeleccionado();				// Se recibe el int que seteamos en los observer
		System.out.println("Notifico en vistasecundaira con" + seleccion);
		
		if(seleccion == 3){											// el 3 nos dice que debemos cambiar a la vista de
			miObservador.setVista(contentPane);						// la lista de reproduccion
			miObservador.setPanel(0);
		}

		if(seleccion ==1 ){											// Si seleccionamos uno, queda visible el boton de pausa
			contentPane.remove(BotonPlay);
			contentPane.add(BotonPause);
			miObservador.notifyObservers();
			
		}
		
		if ( seleccion == 2){
			contentPane.remove(BotonPause);							// Si seleccionamos 2, queda visible el boton de play
			contentPane.add(BotonPlay);
			miObservador.notifyObservers();
			
		}
		
	}
}
