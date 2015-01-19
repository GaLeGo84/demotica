/**
 * Classe que identifica o Sensor de Movimento
 */
package demotica;

import java.io.Serializable;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class Moviment extends Sensor implements Serializable{

    private long time;
    private int interval;
    private boolean detection;

    /**
     * 
     * @param interval - identifica o intervalo
     */
    public Moviment(int interval) {
        this.time = System.currentTimeMillis();
        this.interval = interval;
        this.detection = false;
    }  

    /**
     * 
     * @return a hora + o tempo de intervalo
     */
    public long getTime() {
        return time;
    }

    /**
     * 
     * @param time - hora atuzal + o tempo de intervalo
     */
    public void setTime(long time) {
        this.time = time;
    }

    /**
     * 
     * @return o intervalo
     */
    public int getInterval() {
        return interval;
    }

    /**
     * 
     * @param interval - Substitui o intervalo de tempo por outro intervalo de tempo
     */
    public void setInterval(int interval) {
        this.interval = interval;
    }

    /**
     * 
     * @return o estado da deteção,.true - detetou, false - detetetou
     */
    public boolean isDetection() {
        return detection;
    }

    /**
     * 
     * @param detection - Substitui o estado da deteção
     */
    public void setDetection(boolean detection) {
        this.detection = detection;
    } 

    @Override
    public String toString() {
        String su = super.toString();
        return su+"Movimento{" + "time=" + time + ", interval=" + interval + ", detection=" + detection + '}';
    }

}