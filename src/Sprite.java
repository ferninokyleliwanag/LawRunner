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





    public void paint(Graphics2D g){
        int xp = (int) (Map.TILE_SIZE * x);
        int yp = (int) (Map.TILE_SIZE * y);


        g.rotate(ang,xp,yp);
        g.drawImage(image, (int)(xp-16), (int)(yp-16),30, 30, null);
        g.rotate(-ang,xp,yp);
    }


    @Override
    public boolean move(float dx, float dy) {
        float nx = x + 1;
        float ny = y + 1;



        if(validLocation(nx,ny)) {


            ang = (float) (Math.atan2(dy, dx) - (Math.PI / 2));
            return true;
        }
        return false;

    }

    public boolean validLocation(float nx, float ny){

        if(map.blocked(nx - size, ny - size)){
            return false;
        }
        if(map.blocked(nx + size, ny - size)){
            return false;
        }
        if(map.blocked(nx-size, ny+size)){
            return false;
        }
        if(map.blocked(nx + size, ny + size)){
            return false;
        }

        return true;

    }


}
