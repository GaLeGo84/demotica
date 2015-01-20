/**
 * Classe que identifica o Sensor da Luz Natural
 */
package demotica;

import java.io.Serializable;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class NaturaLight extends Sensor implements Serializable{

    private int value;

    /**
     * Value - inicializado a 15
     */
    public NaturaLight() {
        this.value = 15;
    }

    /**
     * 
     * @return o valor que foi capturado
     */
    public int getValue() {
        return value;
    }

    /**
     * 
     * @param value - Substitui o valor capturado
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * 
     * @return uma String "Luz Natural{Valor= "valor"}" 
     */
    @Override
    public String toString() {
        String su = super.toString();
        return su+"Luz Natural{Valor=" + value + "}";
    }
 
}