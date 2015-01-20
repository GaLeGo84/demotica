/**
 * É uma SubClasse da SuperClasse Sensor
 */
package demotica;

import java.io.Serializable;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class Gas extends Sensor implements Serializable{

    private boolean detection;

    /**
     * deteção que inicializa falso: True - Ligado, False - Desligado
     */
    public Gas() {
        this.detection = false;
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
     * @param detection - muda o estado da deteção
     */
    public void setDetection(boolean detection) {
        this.detection = detection;
    }

    /**
     * 
     * @return uma String com Gás{Deteção= "Valor" }
     */
    @Override
    public String toString() {
        String su = super.toString();
        return su+"Gás{" + "Deteção=" + detection + '}';
    }
  
}