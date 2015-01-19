/**
 * Subclasse da Classe Sensor que identifica o sensor de fumo
 */
package demotica;

import java.io.Serializable;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class Smoke extends Sensor implements Serializable{

    private boolean detection;  

    /**
     * deteção - Identifica o estado da adeteção. True-Detetado, False-Não detetado
     */
    public Smoke( ) {
        this.detection=false;
    }

    /**
     * 
     * @return o estado da deteção
     */
    public boolean isDetection() {
        return detection;
    }

    /**
     * 
     * @param detection Susbstitui o estado da deteção
     */
    public void setDetection(boolean detection) {
        this.detection = detection;
    }

    /**
     * 
     * @return uma String "Sensor de Fumo{Deteção= <valor>}"
     */
    @Override
    public String toString() {
        String su = super.toString();
        return su+"de Fumo{" + "Deteção=" + detection + '}';
    }

}