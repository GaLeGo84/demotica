package demotica;

import java.io.Serializable;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class ExteriorEntranceDoor extends ExteriorDoor implements Serializable{

    //Security - A componente de alarme
    private Security security;
    /**
     * 
     * @param id - id da porta
     * @param security - componente de segurança
     */
    public ExteriorEntranceDoor(int id, Security security) {
        super(id);
        this.security = security;
    }
    /**
     * 
     * @return a componente de segurança
     */
    public Security getSecurity() {
        return security;
    }
    /**
     * 
     * @param security - substitui o estado da componente de segurança
     */
    public void setSecurity(Security security) {
        this.security = security;
    }
    
    /**
     * ativa a componente de segurança
     */
    public void activeSecurity(){
        security.setStatus(true);
    }
    
    /**
     * desativa a componente de segurança
     */
    public void deactiveSecurity(){
        security.setStatus(false);
    }
    /**
     * 
     * @return string com o nome "Porta de Entrada"
     */
    @Override
    public String toString() {
        return super.toString() +"de Entrada";
    }
}