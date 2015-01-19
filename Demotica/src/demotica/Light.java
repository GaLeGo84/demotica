package demotica;

import java.io.Serializable;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class Light implements Serializable{

    private int intensity;   
    private boolean status;

    public Light(){       
        this.intensity = 10; //é entre de 0 a 20
        this.status = false;        
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    

    @Override
    public String toString() {
        return "Light{intensity=" + intensity + ", status=" + status +'}';
    }
    
    
    
    

}
