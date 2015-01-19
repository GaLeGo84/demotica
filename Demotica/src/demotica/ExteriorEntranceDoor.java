/**
 * É uma SubClasse da Classe ExteriorDoor que identifica a porta de entrada 
 */
package demotica;

import java.io.Serializable;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class ExteriorEntranceDoor extends ExteriorDoor implements Serializable{

    private Security security;

    /**
     * 
     * @param id - identifica o id da porta
     * @param security - identifica a componente de Segurança
     */
    public ExteriorEntranceDoor(int id, Security security){
        super(id);
        this.security = security;
    }
    
    /**
     * 
     * @return a componente de Segurança
     */
    public Security getSecurity() {
        return security;
    }  

    /**
     * Ativa o estado da componete de segurança
     */
    public void activeSecurity(){
        security.setStatus(true);
    }
    
    /**
     * Desativa o estado da componete de segurança
     */
    public void deactiveSecurity(){
        security.setStatus(false);
    }

    /**
     * 
     * @return uma String com o nome "Porta de Entrada"
     */
    @Override
    public String toString() {
        return super.toString() +"de Entrada";
    }
}