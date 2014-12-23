package demotica;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rodolfo Melo, Henrique Melo, Xico
 */
public class Light implements Serializable{

    private String sn;
    private int intensity;   
    private boolean status;
    private Date times;
    private LinkedList<Time_Interval> time_interval;

    public Light(String sn) {
        this.sn = sn;
        SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd");
        this.intensity = 8; //é entre de 0 a 10
        this.status = false;
        this.times = ft.get2DigitYearStart();
    }

    public String getSn() {
        return sn;
    }

    public float getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "Light{intensity=" + intensity + ", status=" + status +'}';
    }
    
    
    
    

}
