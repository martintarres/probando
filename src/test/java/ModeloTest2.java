import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.Random;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.*;

/**
 * Created by martin on 21/6/2017.
 */
public class ModeloTest2 extends Modelo {
    private BasicPlayer player;
    private File folder;
    public List listatest;
    private File folder1;
    private String path;
    private String path1;
    private int incial;
    private int finall;
    private int resultadoalea;
    private Random numeroalea;

/*
    @Before
    public void setUp() throws Exception {
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
*/
    @Test
    public void iniciarm() throws Exception {
    }

    @Test
    public void cargar() throws Exception {
        listatest = new List();
        System.out.println("la verga");
       // String name= "src/test/resources/Coldplay_-_The_Scientist_RB-RcX5DS5A.mp3";
       // path = getClass().getClassLoader().getResource("Coldplay_-_The_Scientist_RB-RcX5DS5A.mp3").getPath();
        //System.out.println(path);
       // folder =new File (path);
        //assertEquals(0 , listatest.getItemCount());
        //listatest.add(folder.getName());
        //assertEquals(1 , listatest.getItemCount());
    }

    @Test
    public void play() throws Exception {
    }

    @Test
    public void pause() throws Exception {
    }

    @Test
    public void stop() throws Exception {
    }

}