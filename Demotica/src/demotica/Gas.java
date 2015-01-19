package demotica;

import java.io.Serializable;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class Gas extends Sensor implements Serializable{

    private boolean detection;

    public Gas() {
        this.detection = false;
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
        return su+"Gás{" + "Deteção=" + detection + '}';
    }
    
    
    
}