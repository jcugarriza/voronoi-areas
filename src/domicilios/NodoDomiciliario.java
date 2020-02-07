package domicilios;

import java.awt.Color;

public class NodoDomiciliario extends Nodo {

    private boolean ocupado;

    public NodoDomiciliario(int x, int y, int medida, Color color, String nombre) {
        this.setX(x);
        this.setY(y);
        this.setMedida(medida);
        this.setColor(color);
        this.setNombre(nombre);
        this.ocupado = false;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    public boolean getOcupado() {
        return ocupado;
    }

}
