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
public class Sensor implements Serializable{

    private String SNumber;
    private long timestamp;
    private boolean status;

    public Sensor(String SNumber) {
        this.SNumber = SNumber;
        this.timestamp = System.currentTimeMillis();
        this.status = true;
    }

    public String getSNumber() {
        return SNumber;
    }

    public void setSNumber(String SNumber) {
        this.SNumber = SNumber;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SNumber= " + SNumber+" ";
    }

}
