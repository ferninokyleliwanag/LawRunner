import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Board extends JPanel {

    Map map;
    Sprite sprite;

    List<Sprite> actors = new ArrayList<>();


    public Board(){
        setPreferredSize(new Dimension(445,450));
        setBackground(Color.BLACK);
        map = new Map();

    }




}
