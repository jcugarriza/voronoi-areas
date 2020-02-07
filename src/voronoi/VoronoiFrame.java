package voronoi;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import domicilios.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
Métodos para dibujar el diagrama de Voronoi realizados por JD Padilla Gamarra
*/

public class VoronoiFrame extends javax.swing.JFrame {

    ArrayList<Nodo> lista = new ArrayList();
    public VoronoiFrame(ArrayList<Nodo> lista) {
        initComponents();
        this.setGtk();
        this.lista = lista;
        
        crearVoronoi();
    }
    
    void crearVoronoi(){
        for (Nodo nodo : lista) {
            if (nodo instanceof NodoRestaurante) {
                this.drawCanvas.addVertex(nodo.getX(), nodo.getY());
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        drawCanvas = new voronoi.DrawCanvas();

        setTitle("Diagrama de Voronoi");
        setResizable(false);

        drawCanvas.setForeground(new java.awt.Color(204, 204, 255));
        drawCanvas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                drawCanvasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(drawCanvas, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(drawCanvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void drawCanvasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawCanvasMouseClicked
        
    }//GEN-LAST:event_drawCanvasMouseClicked

    public void setGtk() {
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(VoronoiFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.updateComponentTreeUI(this);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private voronoi.DrawCanvas drawCanvas;
    // End of variables declaration//GEN-END:variables
}
