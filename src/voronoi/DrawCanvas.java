package voronoi;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class DrawCanvas extends Canvas {

    private final Graph graph = new Graph();
    private final BufferedImage image;
    private final Dimension canvasDim = new Dimension(1100, 600);
    private boolean justRepaint = false;

    public DrawCanvas() {
        super();
        this.setSize(this.canvasDim);
        this.image = new BufferedImage(
                this.canvasDim.width,
                this.canvasDim.height,
                BufferedImage.TYPE_INT_RGB
        );
    }

    @Override
    public void update(Graphics g) {
        this.paint(g);
    }

    @Override
    public void paint(Graphics g) {
        if (!justRepaint) {
            this.graph.draw(
                    this.image,
                    this.canvasDim.width,
                    this.canvasDim.height
            );
            this.justRepaint = true;
        }
        g.drawImage(this.image, 0, 0, null);
    }

    public void addVertex(int x, int y) {
        this.justRepaint = false;
        this.graph.addSite(x, y);
        this.repaint();
    }

    public void resetGraph() {
        this.justRepaint = false;
        this.graph.reset();
        this.repaint();
    }

    public void generateRadomGraph(int n) {
        this.justRepaint = false;
        this.graph.generateRandom(n);
        this.repaint();
    }

    public void exportTo() {
        try {
            ImageIO.write(this.image, "png", new File("voronoi.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
