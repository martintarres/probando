import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

/**
 * Created by martin on 21/6/2017.
 */



public class ModeloTest1 {
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
        //path = "C:\\Users\\marti\\Music\\Coldplay_-_The_Scientist_RB-RcX5DS5A.mp3";
        path = getClass().getResource("Coldplay_-_The_Scientist_RB-RcX5DS5A.mp3").getPath();
        //path1 = "C:\\Users\\marti\\Music\\Luis_Fonsi_-_Despacito_ft_Daddy_Yankee_kJQP7kiw5Fk.mp3";
        path1= getClass().getResource("Luis_Fonsi_-_Despacito_ft_Daddy_Yankee_kJQP7kiw5Fk.mp3").getPath();
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
    public void iniciarm() throws Exception {
    }

    @Test
    public void cargar() throws Exception {
        assertEquals(0 , listatest.getItemCount());
        listatest.add(folder.getName());


        assertEquals(1 , listatest.getItemCount());
    }

    @Test
    public void play() throws Exception {
        try {

            player.play();

        } catch (BasicPlayerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        assertEquals(0, player.getStatus());
    }

    @Test
    public void pause() throws Exception {
        try {

            player.pause();

        } catch (BasicPlayerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertEquals(3, player.getStatus());
    }

    @Test
    public void stop() throws Exception {
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
    public void adelante() throws Exception {
        listatest.add(folder.getName());
        listatest.add(folder1.getName());
        listatest.select(0);
        assertEquals(listatest.getSelectedItem() , "Coldplay_-_The_Scientist_RB-RcX5DS5A.mp3");
        listatest.select(listatest.getSelectedIndex()+1);
        assertEquals(listatest.getSelectedItem() , "Luis_Fonsi_-_Despacito_ft_Daddy_Yankee_kJQP7kiw5Fk.mp3");
    }

    @Test
    public void atras() throws Exception {
        listatest.add(folder.getName());
        listatest.add(folder1.getName());
        listatest.select(1);
        assertEquals(listatest.getSelectedItem() , "Luis_Fonsi_-_Despacito_ft_Daddy_Yankee_kJQP7kiw5Fk.mp3");
        listatest.select(listatest.getSelectedIndex()-1);
        assertEquals(listatest.getSelectedItem() , "Coldplay_-_The_Scientist_RB-RcX5DS5A.mp3");
    }

    @Test
    public void volumen() throws Exception {
    }

    @Test
    public void buscarcancion() throws Exception {
        listatest.add(folder.getName());
        listatest.add(folder1.getName());
        String s ="lui";
        for(int i=0; i<listatest.getItemCount();i++) {
            listatest.select(i);
            if(listatest.getSelectedItem().toLowerCase().contains(s)){
                assertEquals("Luis_Fonsi_-_Despacito_ft_Daddy_Yankee_kJQP7kiw5Fk.mp3",listatest.getSelectedItem() );
            }
        }
        s ="col";
        for(int i=0; i<listatest.getItemCount();i++) {
            listatest.select(i);
            if(listatest.getSelectedItem().toLowerCase().contains(s)){
                assertEquals("Coldplay_-_The_Scientist_RB-RcX5DS5A.mp3",listatest.getSelectedItem() );
            }
        }
    }

    @Test
    public void seleccioncarpeta() throws Exception {
    }

    @Test
    public void agregarLista() throws Exception {
        assertEquals(0, listatest.getItemCount());
        listatest.add(folder1.getName());
        assertEquals(1, listatest.getItemCount());
        listatest.add(folder.getName());
        assertEquals(2, listatest.getItemCount());
    }

    @Test
    public void borrar() throws Exception {
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
    public void adelanterep() throws Exception {
        listatest.add(folder.getName());
        listatest.add(folder1.getName());
        listatest.select(0);
        assertEquals("Coldplay_-_The_Scientist_RB-RcX5DS5A.mp3", listatest.getSelectedItem());
        listatest.select(listatest.getSelectedIndex()+1);
        assertEquals("Luis_Fonsi_-_Despacito_ft_Daddy_Yankee_kJQP7kiw5Fk.mp3",listatest.getSelectedItem() );
    }

    @Test
    public void atrasrep() throws Exception {
        listatest.add(folder.getName());
        listatest.add(folder1.getName());
        listatest.select(1);
        assertEquals("Luis_Fonsi_-_Despacito_ft_Daddy_Yankee_kJQP7kiw5Fk.mp3", listatest.getSelectedItem());
        listatest.select(listatest.getSelectedIndex()-1);
        assertEquals("Coldplay_-_The_Scientist_RB-RcX5DS5A.mp3", listatest.getSelectedItem());
    }

    @Test
    public void verListaRepr() throws Exception {
    }

    @Test
    public void aleatorio() throws Exception {
    }

}