import java.awt.Component;
import java.awt.List;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JSlider;

import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

	/*	En la clase modelo se encuentra todo el codigo que accen las acciones
	 */
public class Modelo {

		String path;
		File files = null;
		static BasicPlayer player;
		List listapr;
		String unir;
		File[] listFiles;
		File folder;
		File archivo;
		List listarep;


		public void iniciarm() {
			player = new BasicPlayer();                                // Creamos un objeto de la clase BasicPlayer

			JFileChooser fc = new JFileChooser();                            //Aca vamos a elegir de que carpeta queremos cargar
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);        // nuestras canciones

			Component contentPane = null;
			int ventanaseleccionada = fc.showOpenDialog(contentPane);

			if (ventanaseleccionada == JFileChooser.APPROVE_OPTION) {
				folder = fc.getSelectedFile();
				path = folder.getAbsolutePath();                        // aca obtenemos el path de la carpeta seleccionada
			}

		}

		/*
            en el metodo cargar lo que hacemos es cargar todas las canciones que esten en los formatos soportados por nuestro
            reproductor, en la lista para poder ser reproducida
         */
		public void cargar(List listapr) {


			this.listapr = listapr;


			listFiles = folder.listFiles();

			for (int i = 0; i < listFiles.length; i++) {
				if (listFiles[i].isFile()) {
					files = listFiles[i].getAbsoluteFile();
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


		public void play() {
			//unir = path.concat("\\" + listapr.getSelectedItem());


			archivo = new File(unir(listapr.getSelectedItem()));

			System.out.println("soy archivo1 " + archivo);

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

		public String unir(String seleccion){
			unir = path.concat("\\" + seleccion);
			return unir;

		}

	/*
		El metodo pause, pausa la reproduccion de la cancion
	 */
	
	public void pause(){
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
	
	public void stop(){
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

	public void adelante(){
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
	public void atras(){
		
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
	public void volumen(JSlider source){
		
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

	public void buscarcancion(String s){
		
		listapr.removeAll();				//aca se borra toda la lista
		
		for(int i=0; i<listFiles.length;i++){
			if(listFiles[i].isFile()){
				files=listFiles[i].getAbsoluteFile();
				if(files.getName().endsWith("mp3") || files.getName().endsWith("wav") || files.getName().endsWith("mp4")){
					
					
					if(files.toString().toLowerCase().contains(s)){		// se fija si hay canciones que contengan las letras
						//System.out.println(files.toString());			// que estamos ingresando, ignorando mayusculas
						listapr.add(files.getName());					// y si hay, las agrega a la lista
						
					}
					
					}
			
		}
		}
	}
		/*
			En este metodo lo que hacemo es seleccionar la carpeta de donde queremos cargar nuestra musica
		 */

	public void seleccioncarpeta(List lista){
		JFileChooser fc=new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		Component contentPane = null;
		int ventanaseleccionada = fc.showOpenDialog(contentPane);
		
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
	
	public void agregarLista(String string, List listarep){
			String archi;
			archi=string;
			this.listarep=listarep;
			
			listarep.add(archi);
			
	}
		/*
		aca borramos los archivos de nuestra lista de reproduccion
		 */
	
	public void borrar(String archivo){

		listarep.remove(archivo);
	}

	
	public void adelanterep(){
		listarep.select((listarep.getSelectedIndex()+1));
		//unir = "C:\\Users\\marti\\Music\\" + listarep.getSelectedItem();
		try {
			player.stop();
			player.open(new File(unir(listarep.getSelectedItem())));
			player.play();
		} catch (BasicPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void atrasrep(){
		
		listarep.select((listarep.getSelectedIndex()-1));
		//unir = "C:\\Users\\marti\\Music\\" + listarep.getSelectedItem();
		try {
			player.stop();
			player.open(new File(unir(listarep.getSelectedItem())));
			player.play();
		} catch (BasicPlayerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	

}
