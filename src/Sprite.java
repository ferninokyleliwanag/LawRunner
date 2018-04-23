import java.awt.*;

public class Sprite implements Move {

    private float x;
    private float y;
    private Image image;
    private Map map;
    private float ang;
    private float size = 0.3f;

    public Sprite(Image image, Map map, float x, float y){
        this.image = image;
        this.map = map;
        this.x = x;
        this.y = y;
    }






    @Override
    public void move(float x, float y) {

    }

    public void paint(Graphics2D g){
        int xp = (int) (Map.TILE_SIZE * x);
        int yp = (int) (Map.TILE_SIZE * y);

        g.drawImage(image, (int)(xp-16), (int)(yp-16), null);
    }



}
