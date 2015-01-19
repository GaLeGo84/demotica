/**
 * SuperClasse que identifica os Sensores
 */
package demotica;

import java.io.Serializable;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public abstract class Sensor implements Serializable{

    private boolean status;

    /**
     * Status - identifica o estado do sensor. True-Ligado, False-Desligado
     */
    public Sensor() {
        this.status = true;
    }
    /**
     * 
     * @return o estado do sensor 
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * 
     * @param status Susbtitui o estado do sensor
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * 
     * @return uma String "Sensor "
     */
    @Override
    public String toString() {
        return "Sensor ";
    }
    
}