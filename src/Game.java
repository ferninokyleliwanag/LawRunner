import com.sun.corba.se.impl.orbutil.graph.Graph;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.net.URL;

public class Game extends JFrame {

    Image sprite;
    Board board;
    BufferStrategy strategy;
    boolean run = true;
    Map map;
    Sprite player;

    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;


    public Game() {
        //load player
        getImage();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    up = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    down = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    left = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    right = true;
                }

            }

            @Override
            public void keyReleased(KeyEvent e){
                super.keyReleased(e);
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    up = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    down = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    left = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    right = false;
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {

            }


        });

        setTitle("Runnin' From The Law");
        board = new Board();
        map = new Map();
        player = new Sprite(sprite, map, 5f, 5f);
        add(board);
        pack();
        setLocationRelativeTo(null);
        createBufferStrategy(2);
        strategy = getBufferStrategy();
        gameLoop();
    }

    public static void main(String[] args){
        new Game();
    }

    public void gameLoop(){
        boolean gameRunning = true;
        long last = System.nanoTime();

        while(gameRunning){
            Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
            g.setColor(Color.black);
            g.fillRect(0,0,500,500);
            g.translate(0,25);
            map.paint(g);
            player.paint(g);
            g.dispose();
            strategy.show();

            try{Thread.sleep(4);} catch (Exception e) {};

            long delta = (System.nanoTime() - last) / 1000000;
            last = System.nanoTime();

            for(int i=0; i<delta / 5; i++){
                logic(5);
            }

            if((delta%5) != 0){
                logic(delta % 5);
            }
        }

    }

    public void getImage(){

        try {
            URL url = Thread.currentThread().getContextClassLoader().getResource("pixel.png");
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

    public void logic(long delta) {
        // check the keyboard and record which way the player

        // is trying to move this loop

        float dx = 0;
        float dy = 0;
        if (left) {
            dx -= 1;
        }
        if (right) {
            dx += 1;
        }
        if (up) {
            dy -= 1;
        }
        if (down) {
            dy += 1;
        }

        // if the player needs to move attempt to move the entity

        // based on the keys multiplied by the amount of time thats

        // passed

        if ((dx != 0) || (dy != 0)) {
            player.move(dx * delta * 0.003f,
                    dy * delta * 0.003f);
        }
    }

}
