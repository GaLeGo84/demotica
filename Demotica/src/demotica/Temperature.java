/**
 * É uma SubClasse da Classe Sensor que idenitifica o Sensor de Temperatura
 */
package demotica;

import java.io.Serializable;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class Temperature extends Sensor implements Serializable{

    private int value;

    /**
     * Value - identifica o vlor da temperatura
     */
    public Temperature( ) {
        this.value = 15;
    }

    /**
     * 
     * @return o valor da temperatura 
     */
    public int getValue() {
        return value;
    }

    /**
     * 
     * @param value Susbstitui o valor da temperatura por outro valor
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * 
     * @return uma String "Sensor Temperatura{Valor= <value> }"
     */
    @Override
    public String toString() {
        String su = super.toString();
        return su+"Temperatura{" + "Valor=" + value + '}';
    }
    
}