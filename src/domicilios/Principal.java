package domicilios;

import voronoi.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Principal extends javax.swing.JFrame {

    //declaración de variables
    ArrayList<Nodo> lista = new ArrayList();
    Nodo seleccionado1 = null;
    Nodo seleccionado2 = null;
    BufferedImage iconoCliente = Metodos.cargarImagen("iconcliente");
    BufferedImage iconoRestaurante = Metodos.cargarImagen("iconrestaurante");
    BufferedImage iconoDomiciliario = Metodos.cargarImagen("icondomiciliario");
    BufferedImage iconoDomiciliarioOcupado = Metodos.cargarImagen("icondomiciliarioocupado");
    BufferedImage iconoClienteSeleccionado = Metodos.cargarImagen("iconclienteseleccionado");
    BufferedImage iconoRestauranteSeleccionado = Metodos.cargarImagen("iconrestauranteseleccionado");
    BufferedImage iconoDomiciliarioSeleccionado = Metodos.cargarImagen("icondomiciliarioseleccionado");
    BufferedImage iconoDomiciliarioOcupadoSeleccionado = Metodos.cargarImagen("icondomiciliarioocupadoseleccionado");

    public Principal() throws IOException {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pedido = new javax.swing.JButton();
        liberar = new javax.swing.JButton();
        voronoi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Domicilios");
        setBounds(new java.awt.Rectangle(0, 0, 1024, 768));
        setResizable(false);

        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel.setPreferredSize(new java.awt.Dimension(800, 580));
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panelMouseReleased(evt);
            }
        });
        panel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                panelComponentShown(evt);
            }
        });
        panel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                panelPropertyChange(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapa.png"))); // NOI18N

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pedido.setText("Hacer Pedido");
        pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidoActionPerformed(evt);
            }
        });

        liberar.setText("Liberar domiciliarios");
        liberar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                liberarActionPerformed(evt);
            }
        });

        voronoi.setText("Ver diagrama de Voronoi");
        voronoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voronoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(pedido)
                        .addGap(18, 18, 18)
                        .addComponent(liberar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(voronoi)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(liberar)
                        .addComponent(voronoi))
                    .addComponent(pedido))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //muestra un dialog que permite crear un nodo
    void crearNodoEnPanel(int x, int y, int iconWidth, Color c) {

        //campos del dialog
        JTextField text = new JTextField();
        JComboBox box = new JComboBox();
        box.addItem("Domiciliario");
        box.addItem("Restaurante");
        box.addItem("Cliente");
        Object[] message = {
            "Seleccione el tipo de nodo a crear:",
            box,
            "Escriba el nombre del nodo:",
            text
        };
        Object[] options = {"Aceptar", "Cancelar"};
        int op = JOptionPane.showOptionDialog(null, message, "Crear Nodo", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (op == 0) {

            //si se seleccionó una opción y se escribió texto
            if (box.getSelectedIndex() != -1 && !text.getText().equals("")) {
                String tipo = box.getSelectedItem().toString();

                switch (tipo) {
                    case "Cliente":
                        if (nombreNodoExistente(text.getText(), "NodoCliente")) {
                            JOptionPane.showMessageDialog(null, "Ya existe un cliente con el nombre '" + text.getText() + "'.", "Crear nodo", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            lista.add(new NodoCliente(x, y, iconWidth, c, text.getText()));
                            Metodos.dibujarIcono(iconoCliente, x, y, panel);
                            Metodos.dibujarString(iconoCliente, x, y, text.getText(), panel);
                            JOptionPane.showMessageDialog(null, "El cliente con el nombre '" + text.getText() + "' fue creado.", "Crear nodo", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case "Domiciliario":
                        if (nombreNodoExistente(text.getText(), "NodoDomiciliario")) {
                            JOptionPane.showMessageDialog(null, "Ya existe un domiciliario con el nombre '" + text.getText() + "'.", "Crear nodo", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            lista.add(new NodoDomiciliario(x, y, iconWidth, c, text.getText()));
                            Metodos.dibujarIcono(iconoDomiciliario, x, y, panel);
                            Metodos.dibujarString(iconoCliente, x, y, text.getText(), panel);
                            JOptionPane.showMessageDialog(null, "El domiciliario con el nombre '" + text.getText() + "' fue creado.", "Crear nodo", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case "Restaurante":
                        if (nombreNodoExistente(text.getText(), "NodoRestaurante")) {
                            JOptionPane.showMessageDialog(null, "Ya existe un restaurante con el nombre '" + text.getText() + "'.", "Crear nodo", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            lista.add(new NodoRestaurante(x, y, iconWidth, c, text.getText()));
                            Metodos.dibujarIcono(iconoRestaurante, x, y, panel);
                            Metodos.dibujarString(iconoCliente, x, y, text.getText(), panel);
                            JOptionPane.showMessageDialog(null, "El restaurante con el nombre '" + text.getText() + "' fue creado.", "Crear nodo", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    default:
                        System.out.println("default option crearVerticeEnMapa " + x + " " + y);
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Crear nodo", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }

    //se busca si existe un nodo de un tipo ya creado con el nombre deseado
    boolean nombreNodoExistente(String nombre, String tipo) {
        if (!nombre.equals("")) {
            for (Nodo nodo : lista) {
                if (nodo.getClass().getSimpleName().equals(tipo) && nodo.getNombre().equals(nombre)) {
                    return true;
                }
            }
        }
        return false;
    }

    //se dibuja un nodo en el panel
    void dibujarNodo(Nodo seleccionado) {

        if (seleccionado instanceof NodoCliente) {
            Metodos.dibujarIcono(iconoCliente, seleccionado.getX(), seleccionado.getY(), panel);
        } else if (seleccionado instanceof NodoDomiciliario) {
            NodoDomiciliario nd = (NodoDomiciliario) seleccionado;
            if (nd.getOcupado()) {
                Metodos.dibujarIcono(iconoDomiciliarioOcupado, seleccionado.getX(), seleccionado.getY(), panel);
            } else {
                Metodos.dibujarIcono(iconoDomiciliario, seleccionado.getX(), seleccionado.getY(), panel);
            }
        } else if (seleccionado instanceof NodoRestaurante) {
            Metodos.dibujarIcono(iconoRestaurante, seleccionado.getX(), seleccionado.getY(), panel);
        } else {
            System.out.println("default dibujarNodo");
        }
    }

    //se dibuja un nodo seleccionado en el panel
    void dibujarNodoSeleccionado(Nodo seleccionado) {

        if (seleccionado instanceof NodoCliente) {
            Metodos.dibujarIcono(iconoClienteSeleccionado, seleccionado.getX(), seleccionado.getY(), panel);
        } else if (seleccionado instanceof NodoDomiciliario) {
            NodoDomiciliario nd = (NodoDomiciliario) seleccionado;
            if (nd.getOcupado()) {
                Metodos.dibujarIcono(iconoDomiciliarioOcupadoSeleccionado, seleccionado.getX(), seleccionado.getY(), panel);
            } else {
                Metodos.dibujarIcono(iconoDomiciliarioSeleccionado, seleccionado.getX(), seleccionado.getY(), panel);
            }
        } else if (seleccionado instanceof NodoRestaurante) {
            Metodos.dibujarIcono(iconoRestauranteSeleccionado, seleccionado.getX(), seleccionado.getY(), panel);
        } else {
            System.out.println("default dibujarNodoSeleccionado");
        }
    }

    //se busca el domiciliario más cercano al nodo y se ocupa con un pedido
    void ocuparDomiciliarioCercano(Nodo seleccionado) {
        NodoDomiciliario nd = buscarDomiciliario(seleccionado);
        if (nd != null) {

            nd.setOcupado(true);
            dibujarNodo(nd);
            JOptionPane.showMessageDialog(null, "El domiciliario " + nd.getNombre() + " se encargará de este pedido.", "Pedido", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay domiciliarios disponibles en el área del restaurante " + seleccionado.getNombre() + ".", "Pedido", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //se busca el domiciliario más cercano al nodo, siempre y cuando el domiciliario esté en el área del nodo
    NodoDomiciliario buscarDomiciliario(Nodo seleccionado) {

        NodoDomiciliario mayor = null;
        int distResADomLibreMasCercano = 0;

        //se halla el domiciliario libre más cercano al nodo, sin tomar en cuenta el área del nodo
        for (Nodo nodoDom : lista) {
            if (nodoDom instanceof NodoDomiciliario) {
                NodoDomiciliario nd = (NodoDomiciliario) nodoDom;
                int distDomAResFijo = (int) Math.sqrt((int) (Math.pow((nd.getX() - seleccionado.getX()), 2)) + (int) (Math.pow((nd.getY() - seleccionado.getY()), 2)));
                if ((mayor == null || distDomAResFijo < distResADomLibreMasCercano) && !nd.getOcupado()) {
                    mayor = nd;
                    distResADomLibreMasCercano = distDomAResFijo;
                }
            }
        }
        if (mayor != null) {

            //se compara si el domiciliario libre más cercano al nodo está en el área del nodo
            int distComparacion = distResADomLibreMasCercano;
            for (Nodo nodoRes : lista) {

                //si se toma un NodoDomiciliario, se calcula la distancia entre el domiciliario y todos los restaurantes excepto el objetivo
                if (nodoRes instanceof NodoRestaurante && nodoRes != seleccionado) {

                    int distResADomFijo = (int) Math.sqrt((int) (Math.pow((nodoRes.getX() - mayor.getX()), 2)) + (int) (Math.pow((nodoRes.getY() - mayor.getY()), 2)));

                    /*si el domiciliario libre más cercano al nodo no está en el área del nodo, es decir,
                    que está más cerca de otro restaurante que del objetivo, no se puede hacer el pedido*/
                    if (distResADomFijo < distComparacion) {
                        distComparacion = distResADomFijo;
                    }
                }
            }

            //si el domiciliario libre más cercano al nodo no está en el área del nodo, no se puede hacer el pedido
            if (distComparacion < distResADomLibreMasCercano) {
                mayor = null;
            }
        }

        //retorna null si no se puede hacer el pedido, o retorna un domiciliario si se puede
        return mayor;
    }

    private void panelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseReleased

        //se declaran variables necesarias
        int iconWidth = iconoCliente.getWidth(), mediaMedida = (int) iconWidth / 2;
        int x = evt.getX();
        int y = evt.getY();
        int ancho = panel.getWidth(), alto = panel.getHeight();

        if (seleccionado1 == null) {                                            //si no hay nodo seleccionado
            seleccionado1 = Metodos.seleccionar(x, y, iconWidth, lista);            //se intenta seleccionar el nodo en x y
            if (seleccionado1 != null) {                                            //si se pudo seleccionar un nodo en x y
                dibujarNodoSeleccionado(seleccionado1);                                 //se dibuja un nodo seleccionado en el panel
            } else {                                                                //si no hay nodo en x y
                if (Metodos.sePuedeDibujar(x, y, mediaMedida, ancho, alto)) {           //si se puede dibujar un nodo según las medidas de panel
                    if (!Metodos.colisiona(x, y, iconWidth, lista)) {                       //si el nodo no colisiona con otros nodos, se intenta crear un nuevo nodo
                        int red = (int) (Math.random() * 255);
                        int green = (int) (Math.random() * 255);
                        int blue = (int) (Math.random() * 255);
                        crearNodoEnPanel(x, y, iconWidth, new Color(red, green, blue));
                        seleccionado1 = null;
                        seleccionado2 = null;
                    }
                }
            }
        } else if (seleccionado2 == null) {                                     //si hay un solo nodo seleccionado y no dos
            seleccionado2 = Metodos.seleccionar(x, y, iconWidth, lista);            //...
            if (seleccionado2 != null) {
                dibujarNodoSeleccionado(seleccionado2);
            } else {
                dibujarNodo(seleccionado1);
                seleccionado1 = null;
            }
        } else {

            dibujarNodo(seleccionado1);
            seleccionado1 = null;
            dibujarNodo(seleccionado2);
            seleccionado2 = null;
        }
    }//GEN-LAST:event_panelMouseReleased

    private void panelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelComponentShown

    }//GEN-LAST:event_panelComponentShown

    private void panelPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_panelPropertyChange

    }//GEN-LAST:event_panelPropertyChange

    private void pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidoActionPerformed

        if (seleccionado1 == null || seleccionado2 == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar dos nodos: un restaurante y un cliente.", "Pedido", JOptionPane.INFORMATION_MESSAGE);
        } else {

            if (seleccionado1 instanceof NodoRestaurante && seleccionado2 instanceof NodoCliente) {

                ocuparDomiciliarioCercano(seleccionado1);
                dibujarNodo(seleccionado1);
                seleccionado1 = null;
                dibujarNodo(seleccionado2);
                seleccionado2 = null;

            } else if (seleccionado1 instanceof NodoCliente && seleccionado2 instanceof NodoRestaurante) {

                ocuparDomiciliarioCercano(seleccionado2);
                dibujarNodo(seleccionado1);
                seleccionado1 = null;
                dibujarNodo(seleccionado2);
                seleccionado2 = null;

            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un restaurante y un cliente.", "Pedido", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_pedidoActionPerformed

    private void liberarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_liberarActionPerformed

        int cont = 0;
        //se intenta liberar seleccionado1 y seleccionado2
        if (seleccionado1 != null && seleccionado1 instanceof NodoDomiciliario) {
            NodoDomiciliario nodo = (NodoDomiciliario) seleccionado1;
            if (!nodo.getOcupado()) {
                cont++;
            } else {
                nodo.setOcupado(false);
            }
            dibujarNodo(seleccionado1);
            seleccionado1 = null;
        } else {
            cont--;
            JOptionPane.showMessageDialog(null, "Debe seleccionar al menos un domiciliario.", "Liberar Domiciliarios", JOptionPane.INFORMATION_MESSAGE);
        }
        if (seleccionado2 != null && seleccionado2 instanceof NodoDomiciliario) {
            NodoDomiciliario nodo = (NodoDomiciliario) seleccionado2;
            if (!nodo.getOcupado()) {
                cont++;
            } else {
                nodo.setOcupado(false);
            }
            dibujarNodo(seleccionado2);
            seleccionado2 = null;
        }
        //dialog según la cantidad de domiciliarios ocupados
        switch (cont) {
            case 0:
                JOptionPane.showMessageDialog(null, "Domiciliario(s) liberado(s).", "Liberar Domiciliarios", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Un domiciliario no está ocupado y no se liberó.", "Liberar Domiciliarios", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Los domiciliarios no están ocupados.", "Liberar Domiciliarios", JOptionPane.INFORMATION_MESSAGE);
                break;
        }

    }//GEN-LAST:event_liberarActionPerformed

    private void voronoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voronoiActionPerformed
        VoronoiFrame vf = new VoronoiFrame(lista);
        vf.setVisible(true);
    }//GEN-LAST:event_voronoiActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Principal().setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton liberar;
    private javax.swing.JPanel panel;
    private javax.swing.JButton pedido;
    private javax.swing.JButton voronoi;
    // End of variables declaration//GEN-END:variables
}
