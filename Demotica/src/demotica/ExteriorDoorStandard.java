/**
 * SubClasse da Classe ExteriorDoor que define que é uma porta exterior
 */
package demotica;

import java.io.Serializable;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class ExteriorDoorStandard extends ExteriorDoor implements Serializable{

    /**
     * 
     * @param id - o id da porta
     */
    public ExteriorDoorStandard(int id) {
        super(id);

    }
    
    /**
     * 
     * @return uma String com "Porta do Exterior"
     */
    @Override
    public String toString() {
        return super.toString() +"do Exterior";
    }
    
}