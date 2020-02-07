package domicilios;

import java.awt.Color;

public abstract class Nodo {

    private int x;
    private int y;
    private int medida;
    private Color color;
    private String nombre;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMedida() {
        return medida;
    }

    public Color getColor() {
        return color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setMedida(int medida) {
        this.medida = medida;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
