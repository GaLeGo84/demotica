package demotica;

import java.io.Serializable;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class Moviment extends Sensor implements Serializable{

    private long time;
    private int interval;
    private boolean detection;

    public Moviment(int interval) {
        this.time = System.currentTimeMillis();
        this.interval = interval;
        this.detection = false;
    }  

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public boolean isDetection() {
        return detection;
    }

    public void setDetection(boolean detection) {
        this.detection = detection;
    } 

    @Override
    public String toString() {
        String su = super.toString();
        return su+"Movimento{" + "time=" + time + ", interval=" + interval + ", detection=" + detection + '}';
    }

}