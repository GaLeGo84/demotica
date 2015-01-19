package demotica;

import java.io.Serializable;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class Wind extends Sensor implements Serializable{

    private int intensity;

    public Wind(){
        this.intensity=20;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    @Override
    public String toString() {
        String su = super.toString();
        return su+"Vento{" + "Intensidade=" + intensity + '}';
    }
    
    
    
    
}
