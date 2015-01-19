/**
 * Classe que identifica a componente de segurança da porta de entrada
 */
package demotica;

import java.io.Serializable;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class Security implements Serializable{

    private boolean status;

    /**
     * Status - identifica o estado de Segurança. True- Ligado, False-Desligado
     */
    public Security() {
        this.status = false;
    }

    /**
     * 
     * @return o estado de Segurança
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * 
     * @param status - substitui o estado de segurança
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

}