package demotica;


/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class Door {

    private int id;
    private boolean status;
    private boolean lock;

    /**
     * 
     * @param id -Identifica o id da porta
     */
    public Door(int id) {
        this.id = id;
        this.status = false;
        this.lock = true;
    }

    /**
     * 
     * @return o id da porta
     */
    public int getId(){
        return id;
    }

    /**
     * 
     * @return o estado da porta true-fechada false-aberta
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * 
     * @return a porta trancada
     */
    public boolean isLock() {
        return lock;
    }

    /**
     * 
     * @param lock - porta trancada substitui o estado da porta trancada
     */
    public void setLock(boolean lock) {
        this.lock = lock;
    }

    /**
     * 
     * @param status - estado da porta substitui por outro estado da porta
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * 
     * @return String com o nome "Porta"
     */
    @Override
    public String toString() {
        return "Porta ";
    }


}
