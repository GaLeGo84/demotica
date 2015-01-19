package demotica;

import java.io.Serializable;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class Temperature extends Sensor implements Serializable{

    private int value;

    public Temperature( ) {
        this.value = 15;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String su = super.toString();
        return su+"Temperatura{" + "value=" + value + '}';
    }
    
    
}