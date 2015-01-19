package demotica;

import java.io.Serializable;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class ExteriorDoorStandard extends ExteriorDoor implements Serializable{

    public ExteriorDoorStandard(int num) {
        super(num);

    }
    
    @Override
    public String toString() {
        return super.toString() +"do Exterior";
    }
    
}