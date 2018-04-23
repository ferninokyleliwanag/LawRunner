import java.awt.*;

public class Map {

    private static final int CLEAR = 0;

    private static final int BLOCKED = 1;


    private static final int WIDTH = 15;

    private static final int HEIGHT = 15;


    public static final int TILE_SIZE = 30;


    private int[][] data = new int[WIDTH][HEIGHT];


    public Map() {


        for (int y=0;y<HEIGHT;y++) {
            data[0][y] = BLOCKED;
            data[2][y] = BLOCKED;
            data[7][y] = BLOCKED;
            data[11][y] = BLOCKED;
            data[WIDTH-1][y] = BLOCKED;
        }
        for (int x=0;x<WIDTH;x++) {
            if ((x > 0) && (x < WIDTH-1)) {
                data[x][10] = CLEAR;
            }

            if (x > 2) {
                data[x][9] = BLOCKED;
            }
            data[x][0] = BLOCKED;
            data[x][HEIGHT-1] = BLOCKED;
        }

        data[4][9] = CLEAR;
        data[7][5] = CLEAR;
        data[7][4] = CLEAR;
        data[11][7] = CLEAR;
    }


    public void paint(Graphics2D g) {


        for (int x=0;x<WIDTH;x++) {
            for (int y=0;y<HEIGHT;y++) {



                g.setColor(Color.darkGray);
                if (data[x][y] == BLOCKED) {
                    g.setColor(Color.gray);
                }


                g.fillRect(x*TILE_SIZE,y*TILE_SIZE,TILE_SIZE,TILE_SIZE);
                g.setColor(g.getColor().darker());
                g.drawRect(x*TILE_SIZE,y*TILE_SIZE,TILE_SIZE,TILE_SIZE);
            }
        }
    }


    public boolean blocked(float x, float y) {

        return data[(int) x][(int) y] == BLOCKED;
    }
}
