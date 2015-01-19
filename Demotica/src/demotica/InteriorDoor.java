/**
 * É uma SubClasse da Classe Door que indica que é uma porta interior da casa
 */
package demotica;

import java.io.Serializable;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class InteriorDoor extends Door implements Serializable{

    /**
     * 
     * @param id - Identificador da porta 
     */
    public InteriorDoor(int id) {
        super(id);
    }

    /**
     * 
     * @return uma String com "Porta Interior"
     */
    @Override
    public String toString() {        
        return super.toString()+"Interior";
    }
}
