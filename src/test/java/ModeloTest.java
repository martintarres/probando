/*
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class ModeloTest {
	
	private BasicPlayer player;
    private File folder;
	private List listatest;
    private File folder1;
    private String path;
    private String path1;
	private int incial;
	private int finall;
	private int resultadoalea;
	private Random numeroalea;

    @Before
	public void before(){

		player= new BasicPlayer();
		path = "C:\\Users\\marti\\Music\\Coldplay_-_The_Scientist_RB-RcX5DS5A.mp3";
        path1 = "C:\\Users\\marti\\Music\\Luis_Fonsi_-_Despacito_ft_Daddy_Yankee_kJQP7kiw5Fk.mp3";
        folder =new File (path);
        folder1= new File (path1);
		try {
			player.open(folder);
		} catch (BasicPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listatest = new List();
	}
	@Test
	public void testIniciarm() {
			
	}

	@Test
	public void testCargar() {

        assertEquals(0 , listatest.getItemCount());
        listatest.add(folder.getName());


		assertEquals(1 , listatest.getItemCount());

	}

	@Test
	public void testPlay()  {
		try {

			player.play();

		} catch (BasicPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		assertEquals(0, player.getStatus());

	}

	@Test
	public void testUnir(){
		String seleccion ="cancion1";
		String unir;
		unir = path.concat(seleccion);
		assertEquals("C:\\Users\\marti\\Music\\Coldplay_-_The_Scientist_RB-RcX5DS5A.mp3cancion1", unir);
	}

	@Test
	public void testPause()  {
		try {
			
			player.pause();

		} catch (BasicPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(3, player.getStatus());
	}

	@Test
	public void testStop() {
		try {

			//player.play();
			player.stop();

		} catch (BasicPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(3, player.getStatus());
	}

	@Test
	public void testAdelante(){
        listatest.add(folder.getName());
        listatest.add(folder1.getName());
        listatest.select(0);
        assertEquals(listatest.getSelectedItem() , "Coldplay_-_The_Scientist_RB-RcX5DS5A.mp3");
        listatest.select(listatest.getSelectedIndex()+1);
        assertEquals(listatest.getSelectedItem() , "Luis_Fonsi_-_Despacito_ft_Daddy_Yankee_kJQP7kiw5Fk.mp3");
	}

	@Test
	public void testAtras() {
        listatest.add(folder.getName());
        listatest.add(folder1.getName());
        listatest.select(1);
        assertEquals(listatest.getSelectedItem() , "Luis_Fonsi_-_Despacito_ft_Daddy_Yankee_kJQP7kiw5Fk.mp3");
        listatest.select(listatest.getSelectedIndex()-1);
        assertEquals(listatest.getSelectedItem() , "Coldplay_-_The_Scientist_RB-RcX5DS5A.mp3");
	}

	@Test
	public void testVolumen() {

	}

	@Test
	public void testBuscarcancion() {
			listatest.add(folder.getName());
			listatest.add(folder1.getName());
			String s ="lui";
		for(int i=0; i<listatest.getItemCount();i++) {
			listatest.select(i);
			if(listatest.getSelectedItem().toLowerCase().contains(s)){
				assertEquals(listatest.getSelectedItem(),"Luis_Fonsi_-_Despacito_ft_Daddy_Yankee_kJQP7kiw5Fk.mp3" );
			}
				}
		 s ="col";
		for(int i=0; i<listatest.getItemCount();i++) {
			listatest.select(i);
			if(listatest.getSelectedItem().toLowerCase().contains(s)){
				assertEquals(listatest.getSelectedItem(),"Coldplay_-_The_Scientist_RB-RcX5DS5A.mp3" );
			}
		}
			}

	@Test
	public void testSeleccioncarpeta() {

	}

	@Test
	public void testAgregarLista(){
		assertEquals(0, listatest.getItemCount());
		listatest.add(folder1.getName());
		assertEquals(1, listatest.getItemCount());
		listatest.add(folder.getName());
		assertEquals(2, listatest.getItemCount());
	}

	@Test
	public void testBorrar() {
		assertEquals(0, listatest.getItemCount());
        listatest.add(folder.getName());
        assertEquals(1, listatest.getItemCount());
        listatest.add(folder.getName());
        assertEquals(2,listatest.getItemCount());
        listatest.add(folder.getName());
        assertEquals(3, listatest.getItemCount());
        listatest.remove(folder.getName());
		assertEquals(2, listatest.getItemCount());
	}

	@Test
	public void testAdelanterep() {
		listatest.add(folder.getName());
		listatest.add(folder1.getName());
		listatest.select(0);
		assertEquals("Coldplay_-_The_Scientist_RB-RcX5DS5A.mp3", listatest.getSelectedItem());
		listatest.select(listatest.getSelectedIndex()+1);
		assertEquals("Luis_Fonsi_-_Despacito_ft_Daddy_Yankee_kJQP7kiw5Fk.mp3",listatest.getSelectedItem() );

	}

	@Test
	public void testAtrasrep() {
		listatest.add(folder.getName());
		listatest.add(folder1.getName());
		listatest.select(1);
		assertEquals("Luis_Fonsi_-_Despacito_ft_Daddy_Yankee_kJQP7kiw5Fk.mp3", listatest.getSelectedItem());
		listatest.select(listatest.getSelectedIndex()-1);
		assertEquals("Coldplay_-_The_Scientist_RB-RcX5DS5A.mp3", listatest.getSelectedItem());
	}

	@Test

	public void testplayLista(){

		try {
			player.open(folder);
			player.play();
		} catch (BasicPlayerException e) {
			e.printStackTrace();
		}
	}

	/*@Test
	public void testcambiarAleatorio(){


		listatest.add(folder.getName());
		listatest.add(folder.getName());
		listatest.add(folder.getName());
		listatest.add(folder.getName());
		listatest.add(folder.getName());

		incial=0;
		finall=listatest.getItemCount();

		resultadoalea = (int) (numeroalea.nextDouble() * finall + incial);
		System.out.println(resultadoalea);
	}*/

	
/*}
*/