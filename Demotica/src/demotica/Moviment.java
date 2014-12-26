package demotica;

import java.io.Serializable;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rodolfo Melo, Henrique Melo, Xico
 */
public class Moviment extends Sensor implements Serializable{

    private long time;
    private int interval;
    private boolean detection;

    public Moviment(String SNumber, int interval) {
        super(SNumber);
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
        String str = "Moviment{ "+su+" Detection: "+detection+"} ";
        return str;
    }
}