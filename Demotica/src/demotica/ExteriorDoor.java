package demotica;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class ExteriorDoor extends Door {

    /**
     * 
     * @param id - identifica o id da porta
     */
    public ExteriorDoor(int id) {
        super(id);
    }

    /**
     * 
     * @return uma String com o nome "Porta"
     */
    @Override
    public String toString() {
        return "Porta ";
    }
    
    
}
