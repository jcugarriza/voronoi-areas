package voronoi;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Vertex {

    private final int x;
    private final int y;
    private final Color color;

    public Vertex(int x, int y) {
        Random r = new Random();
        this.x = x;
        this.y = y;
        this.color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }

    public double distanceTo(int x, int y) {
        return Math.sqrt(Math.pow(this.y - y, 2) + Math.pow(this.x - x, 2));
    }

    public final int getRGBColor() {
        return this.color.getRGB();
    }

    public void draw(Graphics2D g) {
        g.fillOval(this.x - 2, this.y - 2, 4, 4);
    }
}
