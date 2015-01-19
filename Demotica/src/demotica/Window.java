/**
 * Classe que identifica as janelas da divisão
 */
package demotica;

import java.io.Serializable;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class Window implements Serializable{

    private boolean status;
    private boolean lock;

    /**
     * status - identifica o estado da janela. true-está aberta , false= está fechada
     * lock - identifica se está trancada a janaela. true-trancada, false- não trancada
     */
    public Window(){
        this.status = false;
        this.lock = true;        
    }

    /**
     * 
     * @return o estado da janela
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * 
     * @param status substitui o estado da janela
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * 
     * @return o estado de trancada
     */
    public boolean isLock() {
        return lock;
    }

    /**
     * 
     * @param lock - substitui o estado da tracada por outo estado
     */
    public void setLock(boolean lock) {
        this.lock = lock;
    }

}