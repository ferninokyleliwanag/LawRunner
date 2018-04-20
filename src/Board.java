import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Board extends JPanel implements ActionListener {

    Map map;
    Sprite sprite;

    List<Sprite> actors = new ArrayList<>();


    public Board(){
        setPreferredSize(new Dimension(450,450));
        setBackground(Color.BLACK);
        map = new Map();

    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        map.paint(g);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //collisions will go here.

    }
}
