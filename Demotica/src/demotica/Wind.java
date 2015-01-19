/**
 * É uma SubClasse da Classe Sensor que identifica o Sensor de movimento 
 */
package demotica;

import java.io.Serializable;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class Wind extends Sensor implements Serializable{

    private int intensity;

    /**
     * Intensity - identifica a itensidade do vento
     */
    public Wind(){
        this.intensity=20;
    }

    /**
     * 
     * @return o valor da intensidade do vento
     */
    public int getIntensity() {
        return intensity;
    }

    /**
     * 
     * @param intensity Substitui o valor da intensidade por outro valor
     */
    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    /**
     * 
     * @return uma String "Vento{Intensidade= <value> }"
     */
    @Override
    public String toString() {
        String su = super.toString();
        return su+"Vento{" + "Intensidade=" + intensity + '}';
    }

}