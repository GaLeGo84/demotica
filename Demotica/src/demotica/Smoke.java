package demotica;

import java.io.Serializable;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class Smoke extends Sensor implements Serializable{

    private boolean detection;  

    public Smoke( ) {
        this.detection=false;
    }

    public boolean isDetection() {
        return detection;
    }

    public void setDetection(boolean detection) {
        this.detection = detection;
    }

    @Override
    public String toString() {
        String su = super.toString();
        return su+"de Fumo{" + "Deteção=" + detection + '}';
    }
    
    

}
