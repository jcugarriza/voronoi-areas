package domicilios;

import java.awt.Color;

public class NodoRestaurante extends Nodo {

    public NodoRestaurante(int x, int y, int medida, Color color, String nombre) {
        this.setX(x);
        this.setY(y);
        this.setMedida(medida);
        this.setColor(color);
        this.setNombre(nombre);
    }
}
