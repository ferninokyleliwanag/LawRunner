import com.sun.corba.se.impl.orbutil.graph.Graph;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.net.URL;

public class Game extends JFrame  {

    Image sprite;
    Board board;
    BufferStrategy strategy;
    boolean run = true;
    Map map;
    Sprite player;

    public Game() {
        //load player
        getImage();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setTitle("Runnin' From The Law");
        board = new Board();
        map = new Map();
        player = new Sprite(sprite, map, 1.5f, 1.5f);
        add(board);
        pack();
        setLocationRelativeTo(null);
        createBufferStrategy(2);
        strategy = getBufferStrategy();
        while(run){
           paint();
        }
    }

    public static void main(String[] args){
        new Game();
    }

    public void paint(){
        Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
        g.translate(0,25);
        g.setColor(Color.black);
        g.fillRect(0,0,500,500);
        map.paint(g);
        player.paint(g);
        g.dispose();
        strategy.show();
    }

    public void getImage(){

        try {
            URL url = Thread.currentThread().getContextClassLoader().getResource("sprite.gif");
            if (url == null) {
                System.err.println("Unable to find sprite: sprite.gif");
                System.exit(0);
            }
            sprite = ImageIO.read(url);
        } catch (IOException e) {
            System.err.println("Unable to load sprite: sprite.gif");
            System.exit(0);
        }
    }


}
