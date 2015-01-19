package demotica;

import java.io.Serializable;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class InteriorDoor extends Door implements Serializable{

    public InteriorDoor(int num) {
        super(num);
    }

    @Override
    public String toString() {
        return "Interior";
    }
}
