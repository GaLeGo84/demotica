/**
 * identifica cada luz que existe na divisão
 */
package demotica;

import java.io.Serializable;

/**
 * @author Rodolfo Melo, Henrique Melo, Francisco Simas
 */

public class Light implements Serializable{

    private int intensity;   
    private boolean status;

    /**
     * intensity 
     * status - a luz é está no estado false, true - Ligado, False - Desligado
     */
    public Light(){       
        this.intensity = 10; //é entre de 0 a 20
        this.status = false;        
    }

    /**
     * 
     * @return o valor da intensidade
     */
    public int getIntensity() {
        return intensity;
    }

    /**
     * 
     * @param intensity - substitui o valor da intensidade por outro valor de intensidade
     */
    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    /**
     * 
     * @return o estado da luz
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * 
     * @param status substitui o estado por outro
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    /**
     * 
     * @return uma String com "Light{Intensidade= <valor>, Estado= <valor>}"
     */
    @Override
    public String toString() {
        return "Light{Intensidade=" + intensity + ", Estado=" + status +'}';
    }
    
}