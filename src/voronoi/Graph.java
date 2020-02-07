package voronoi;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;

public class Graph {

    private LinkedList<Vertex> vertices = new LinkedList<>();
    private int size;

    public Graph() {
        this.size = 0;
    }

    public void addSite(int x, int y) {
        this.vertices.add(new Vertex(x, y));
        this.size++;
    }

    public void draw(final BufferedImage screen, int screenWidth, int screenHeight) {
        Vertex nearest;
        Graphics2D g = (Graphics2D) screen.getGraphics();
        setRenderingHints(g);
        if (this.size == 0) {
            g.setColor(new Color(250, 250, 250));
            g.fillRect(0, 0, 1101, 601);
        } else {
            final Vertex startVertex = this.vertices.get(0);
            for (int x = 0; x < screenWidth; x++) {
                for (int y = 0; y < screenHeight; y++) {
                    nearest = startVertex;
                    for (Vertex vertex : this.vertices) {
                        if (vertex.distanceTo(x, y) < nearest.distanceTo(x, y)) {
                            nearest = vertex;
                        }
                    }
                    screen.setRGB(x, y, nearest.getRGBColor());
                }
            }
            g.setColor(Color.black);
            this.vertices.forEach((vertex) -> vertex.draw(g));
        }
        g.dispose();
    }

    public static void setRenderingHints(Graphics2D g) {
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );
        g.setRenderingHint(
                RenderingHints.KEY_STROKE_CONTROL,
                RenderingHints.VALUE_STROKE_DEFAULT
        );
        g.setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC
        );
        g.setRenderingHint(
                RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY
        );
    }

    public void reset() {
        this.vertices = new LinkedList<>();
        this.size = 0;
    }

    public void generateRandom(int n) {
        this.vertices = new LinkedList<>();
        this.size = n;
        Random ran = new Random();
        for (int i = 0; i < n; i++) {
            this.vertices.add(new Vertex(ran.nextInt(1100), ran.nextInt(600)));
        }
    }
}
