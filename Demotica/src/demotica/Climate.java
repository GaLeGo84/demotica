/**
 * Classe referente ao Sistema de Climatização da divisão
 */
package demotica;

import java.io.Serializable;


/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class Climate implements Serializable{

    private static int MINVALUE=12;
    private static int MAXVALUE=25;
    private boolean aircon;
    private boolean heating;
    private boolean status;

    /**
     * aircon - Identifica o ar Condicionado
     * status - Identifica estado da Climatização
     * heating - Identifica o Aquecimento
     */
    public Climate() {
        this.aircon = false;
        this.status =true;
        this.heating = false;
    }   

    /**
     * 
     * @return o valor minimo por defeito
     */
    public int getMINVALUE() {
        return MINVALUE;
    }

    /**
     * 
     * @param MINVALUE  - Substitui o valor minimo
     */
    public void setMINVALUE(int MINVALUE) {
        this.MINVALUE = MINVALUE;
    }

    /**
     * 
     * @return o valor máximo por defeito
     */
    public int getMAXVALUE() {
        return MAXVALUE;
    }

    /**
     * 
     * @param MAXVALUE - substitui o valor maximo
     */
    public void setMAXVALUE(int MAXVALUE) {
        this.MAXVALUE = MAXVALUE;
    }

    /**
     * 
     * @return o estado do sistema de climatização
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * 
     * @param status - substitui o estado 
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * 
     * @return o estado do ar condicionado
     */
    public boolean isAircon() {
        return aircon;
    }

    /**
     * 
     * @param aircon - ar condicionado susbtitui por ar condicionado
     */
    public void setAircon(boolean aircon) {
        this.aircon = aircon;
    }

    /**
     * 
     * @return o aquecimento
     */
    public boolean isHeating() {
        return heating;
    }

    /**
     * 
     * @param heating - substitui o estado do aquecimento
     */
    public void setHeating(boolean heating) {
        this.heating = heating;
    }

}