package demotica;

import java.io.Serializable;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class ExteriorDoor extends Door implements Serializable{

    public ExteriorDoor(int num) {
        super(num);
    }

    @Override
    public String toString() {
        return "Porta ";
    }
    
    
}
