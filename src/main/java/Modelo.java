import javazoom.jlgui.basicplayer.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/*
	En la clase modelo se encuentra todo el codigo que accen las acciones
 */
public class Modelo extends Controlador implements BasicPlayerListener {

		private String path;
		private	File files = null;
		private BasicPlayer player;
		private	List listapr;
		private String unir;
		private File[] listFiles;
		private File folder;
    	private List listarep;
		private ArrayList <String> listarepro;
		private File reproducirListaRepr;
		private Random numeroalea;
		private int terminoInicial;
		private int terminoFinal;
    //private double bytesLength;
		//private float progressUpdate;
		//private int progressNow;
		private boolean alea;
        boolean enPrincipal;


		void iniciarm() {
			player = new BasicPlayer();                                // Creamos un objeto de la clase BasicPlayer

			JFileChooser fc = new JFileChooser();                            //Aca vamos a elegir de que carpeta queremos cargar
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);        // nuestras canciones

			/* Component contentPane = null; */
			int ventanaseleccionada = fc.showOpenDialog(null);

			if (ventanaseleccionada == JFileChooser.APPROVE_OPTION) {
				folder = fc.getSelectedFile();
				path = folder.getAbsolutePath();                        // aca obtenemos el path de la carpeta seleccionada
			}
			listarepro= new ArrayList<>();
			numeroalea = new Random();
			terminoInicial=0;
			player.addBasicPlayerListener(this);
			alea = false;
			/* boolean termine; */
            enPrincipal=true;
		}

		/*
            en el metodo cargar lo que hacemos es cargar todas las canciones que esten en los formatos soportados por nuestro
            reproductor, en la lista para poder ser reproducida
         */
		void cargar(List listapr) {


			this.listapr = listapr;


			listFiles = folder.listFiles();

			assert listFiles != null;
			for (File listFile : listFiles) {
				if (listFile.isFile()) {
					files = listFile.getAbsoluteFile();
					if (files.getName().endsWith("mp3") || files.getName().endsWith("wav") || files.getName().endsWith("mp4")) {
						System.out.println(files);
						//		System.out.println(listFiles[i]);
						listapr.add(files.getName());

					}
				}
			}
		}
	
	/*
		El metodo play crea con el nombre de la cancion que tenemos en la lista, un tipo de File para que
		 lo pueda reproducir el BasicPlayer
		Tambien pregunta el estado del hilo, para que si esta en estado de pausa no empiece a reproducir desde el
		principio de la cancion, si no que desde donde habia quedado
	 */


		void play() {
			//unir = path.concat("\\" + listapr.getSelectedItem());


            File archivo = new File(unir(listapr.getSelectedItem()));

			System.out.println("soy archivo1 " + archivo.getAbsolutePath());

			if (player.getStatus() == -1 || player.getStatus() == 2) {

				try {
					player.open(archivo);
					player.play();
				} catch (BasicPlayerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}


			if (player.getStatus() == 0) {
				try {
					player.open(new File(unir));

					player.play();
					System.out.println("Soy status play " + player.getStatus());

				} catch (BasicPlayerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}


			if (player.getStatus() == 1) {

				try {
					player.resume();
					System.out.println("Soy status resume " + player.getStatus());
				} catch (BasicPlayerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();


				}
			}
		}
		/*

		El metodo unir me crea el path completo para poder reproducir
		 */

		private String unir(String seleccion){
			unir = path.concat("\\" + seleccion);
			return unir;

		}

	/*
		El metodo pause, pausa la reproduccion de la cancion
	 */
	
	void pause(){
		try {
			player.pause();
			System.out.println("soy status pausa " + player.getStatus());
		} catch (BasicPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
		El metodo stop detiene la reproduccion de la cancion
	 */
	
	void stop(){
		try {
			player.stop();
			System.out.println("Soy status stop " + player.getStatus());
		} catch (BasicPlayerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/*
	El metodo adelante, selecciona el proximo elemento de la lista y lo pone a repdoducir
	 */

	void adelante(){
		listapr.select((listapr.getSelectedIndex()+1));
		//unir = "C:\\Users\\marti\\Music\\" + listapr.getSelectedItem();
		try {
			player.stop();
			player.open(new File(unir(listapr.getSelectedItem())));
			player.play();
		} catch (BasicPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
		El metodo atras selecciona el elemento anterior de la lista y lo pone a reproducir
	 */
	void atras(){
		
		listapr.select((listapr.getSelectedIndex()-1));
		//unir = "C:\\Users\\marti\\Music\\" + listapr.getSelectedItem();
		try {
			player.stop();
			player.open(new File(unir(listapr.getSelectedItem())));
			player.play();
		} catch (BasicPlayerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/*
			el metodo volumen cambia el volumen de la cancion que se esta reproduciendo
	 */
	void volumen(JSlider source){
		
		source.setMaximum(141);
		try {
			player.setGain(source.getValue()*0.01); // Aca lo multiplico porque el volumen 
														//	solo puede ir entre 0 y 1.4 								
		} catch (BasicPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
		El meetodo buscar cancion lo que hace es buscar de acuerdo a lo que nosotros vamos escribiendo
	 */

	void buscarcancion(String s){
		
		listapr.removeAll();				//aca se borra toda la lista

		for (File listFile : listFiles) {
			if (listFile.isFile()) {
				files = listFile.getAbsoluteFile();
				if (files.getName().endsWith("mp3") || files.getName().endsWith("wav") || files.getName().endsWith("mp4")) {


					if (files.toString().toLowerCase().contains(s)) {        // se fija si hay canciones que contengan las letras
						//System.out.println(files.toString());			// que estamos ingresando, ignorando mayusculas
						listapr.add(files.getName());                    // y si hay, las agrega a la lista

					}

				}

			}
		}
	}
		/*
			En este metodo lo que hacemo es seleccionar la carpeta de donde queremos cargar nuestra musica
		 */

	void seleccioncarpeta(List lista){
		JFileChooser fc=new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		int ventanaseleccionada = fc.showOpenDialog(null);
		
		if(ventanaseleccionada== JFileChooser.APPROVE_OPTION){
				folder=fc.getSelectedFile();
				path= folder.getAbsolutePath();
			
				//path= path.concat("\\");
				listapr.removeAll();
				cargar(lista);
		}
	}
		/*
		En este metodo lo que se hace es agregar las canciones que nostoros tenemos seleccionadas en nuestra
		vista principal a la lista de reproduccion
		 */
	
	void agregarLista(String string, List listarep){
			String archi;
			archi=string;
			this.listarep=listarep;
			
			listarep.add(archi);
			String devuelvo;
			devuelvo=unir(string);
			listarepro.add(devuelvo);
			terminoFinal= listarepro.size();

	}
		/*
		aca borramos los archivos de nuestra lista de reproduccion
		 */
	
	void borrar(String archivo){

		listarep.remove(archivo);
		for(int i=0; i<listarepro.size(); i++){
			if(listarepro.get(i).contains(listarep.getSelectedItem())) {
				listarepro.remove(listarepro.get(i));

			}
		}
		System.out.println("tengo " + listarepro.size()+ " archivos");
	}

	
	void adelanterep(){
		listarep.select((listarep.getSelectedIndex()+1));
		verListaRepr();


	}
	void atrasrep(){
		
		listarep.select((listarep.getSelectedIndex()-1));
		verListaRepr();
	}

		/* En este metodo creamos un arrayList con los archivos que cargamos a nuestra lista de
		reproduccion con el path completo, porque si no lo perdiamos
		 */
		void verListaRepr(){


		for (String aListarepro : listarepro) {
			if (aListarepro.contains(listarep.getSelectedItem())) {
				reproducirListaRepr = new File(aListarepro);
				playLista(reproducirListaRepr);

			}
		}
	}

	/* En este metodo lo que hacemos es reproducir el archivo de la lista de reproduccion

	 */
	private void playLista(File repro){
		try {
			player.open(repro);
			player.play();
		} catch (BasicPlayerException e) {
			e.printStackTrace();
		}
	}

	void aleatorio(){

		//System.out.println("Soy numero aleatorio " + resultado);
		alea = !alea;

	}

	private void cambiarAleatorio(){
        int resultado = (int) (numeroalea.nextDouble() * terminoFinal + terminoInicial);
        listarep.select(resultado);
		reproducirListaRepr = new File(listarepro.get(resultado));
		playLista(reproducirListaRepr);

	}

	@Override
	public void opened(Object arg0, Map arg1) {

	}

	@Override
	public void progress(int bytesread, long microseconds, byte[] pcmdata, Map properties) {

	}

	@Override
	public void stateUpdated(BasicPlayerEvent basicPlayerEvent) {
		System.out.println("soy evento de modelo "+ basicPlayerEvent.getCode());

				if (basicPlayerEvent.getCode() == 8) {
					if(!enPrincipal) {

					if ( !alea ) {
						adelanterep();


					}
					if (alea) {
						cambiarAleatorio();
					}
				}
			}

	}

	@Override
	public void setController(BasicController basicController) {

	}

}
