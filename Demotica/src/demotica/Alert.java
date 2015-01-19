/*
 * Classe referente aos Alertas
 */
package demotica;

import java.io.Serializable;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */
public abstract class Alert implements Serializable{
    
    private static final long serialVersionUID = 5455238796031916510L;
    private boolean status;
    private boolean detection;

    
    /**
     *  status - Identifica o estado do alerta
     *  detection - Identifica a deteção
     */
    public Alert() {
        this.status = true;
        this.detection = false;
    }

    /**
     * 
     * @return o estado do alerta
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * 
     * @param status - Muda de estado
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * 
     * @return a deteção
     */
    public boolean isDetection() {
        return detection;
    }

    /**
     * 
     * @param detection - substituir a deteção
     */
    public void setDetection(boolean detection) {
        this.detection = detection;
    }
    
}